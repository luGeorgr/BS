package www.george.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.dao.UserWordRelation;
import www.george.com.dao.Word;
import www.george.com.mapper.UserWordRelationMapper;
import www.george.com.mapper.WordMapper;
import www.george.com.myEnum.BookCatalog;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private UserWordRelationMapper userWordRelationMapper;
    public Word getOneWord(final String emailAddr){
        List<UserWordRelation> userWordRelationList = userWordRelationMapper.selectByDegree(emailAddr,1);
        if(userWordRelationList.isEmpty()){
            return null;
        }
        int index = (int)(Math.random() * userWordRelationList.size());
        UserWordRelation userWordRelation = userWordRelationList.get(index);
        Word word = wordMapper.selectOneWord(userWordRelation.getBid(), userWordRelation.getWid());
        word.setBid(userWordRelation.getBid().toString());
        return word;
    }

    public void updateWordDegree(final String emailAddr, final Integer bid, final Integer wid, final Integer degree){
        userWordRelationMapper.update(emailAddr, wid, bid, degree);
    }
}
