package www.george.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.dao.UserWordRelation;
import www.george.com.dao.Word;
import www.george.com.mapper.UserWordRelationMapper;
import www.george.com.mapper.WordMapper;

import java.util.*;
@Service
public class ExamService {

    private static final List<Integer> CHOISE = new ArrayList<>(4);
    private static final List<String> KEYS = new ArrayList<>(4);
    private static final List<String> MESSAGE = new ArrayList<>(4);
    private static final List<String> STATES = new ArrayList<>(4);
    static {
        CHOISE.add(0);
        CHOISE.add(1);
        CHOISE.add(2);
        CHOISE.add(3);
        KEYS.add("A");
        KEYS.add("B");
        KEYS.add("C");
        KEYS.add("D");
        MESSAGE.add("messageA");
        MESSAGE.add("messageB");
        MESSAGE.add("messageC");
        MESSAGE.add("messageD");
        STATES.add("stateA");
        STATES.add("stateB");
        STATES.add("stateC");
        STATES.add("stateD");
    }
    @Autowired
    private UserWordRelationMapper userWordRelationMapper;

    @Autowired
    private WordMapper wordMapper;
    public Map<String, String> getModelMap(final String user){
        Map<String, String> map = new HashMap<>();
        List<UserWordRelation> userWordRelationList = userWordRelationMapper.selectByDegree(user, 2);
        if(userWordRelationList.isEmpty()){
            map.put("word", "You have finish you exam!");
            return map;
        }
        Integer bid = userWordRelationList.get(0).getBid();
        Integer wid = userWordRelationList.get(0).getWid();
        List<Word> words = new ArrayList<>(4);
        words.add(wordMapper.selectOneWord(bid, wid));
        map.put("word", words.get(0).getWord());
        map.put("bid", bid.toString());
        map.put("wid", wid.toString());
        Integer left = wid < 3 ? wid: 3;
        Integer right = 3 - left;
        for(int i = 0; i < left; i++){
            words.add(wordMapper.selectOneWord(bid, wid-i-1));
        }

        for(int i = 0; i < right; i++){
            words.add(wordMapper.selectOneWord(bid, wid+i+1));
        }
        Collections.shuffle(CHOISE);

        int index = 0;
        for(Integer i : CHOISE){
            map.put(KEYS.get(i), words.get(index).getMeaning());
            if(index == 0){
                map.put(MESSAGE.get(i), "You Are Right");
                map.put(STATES.get(i),"1");
            } else{
                map.put(MESSAGE.get(i), "You Are Wrong! The answer is:  " + words.get(0).getMeaning());
                map.put(STATES.get(i),"0");
            }
            index++;
        }
        return map;
    }

    public void updateDegree(String user, Integer bid, Integer wid, Integer degree){
        userWordRelationMapper.update(user, wid, bid, degree);
    }
}
