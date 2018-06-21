package www.george.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.dao.UserProgress;
import www.george.com.dao.UserWordRelation;
import www.george.com.dao.Word;
import www.george.com.mapper.UserProgressMapper;
import www.george.com.mapper.UserWordRelationMapper;
import www.george.com.mapper.WordMapper;
import www.george.com.myEnum.BookCatalog;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReciteService {
    @Autowired
    private WordMapper wordMapper;


    @Autowired
    private UserWordRelationMapper userWordRelationMapper;

    @Autowired
    private UserProgressMapper userProgressMapper;
    public void addBook(final String user, final String bookName){
        //查询是否已经为用户添加了书籍
        if(userWordRelationMapper.userBookExist(user, BookCatalog.getValue(bookName))){
            return;
        }

        Integer bid = BookCatalog.getValue(bookName);
        List<Word> wordList = wordMapper.selectAll(bid);
        List<UserWordRelation> relationList = new ArrayList<>(wordList.size());
        for(final Word word : wordList){
            UserWordRelation userWordRelation = new UserWordRelation();
            userWordRelation.setBid(bid);
            userWordRelation.setDegree(0);
            userWordRelation.setEmailAddr(user);
            userWordRelation.setWid(word.getWid());
            relationList.add(userWordRelation);
        }
        if(!relationList.isEmpty())
            userWordRelationMapper.addAll(relationList);
    }

    public Word getOneWord(final String user, final String bookName){
        List<UserWordRelation> userWordRelationList = userWordRelationMapper.selectByEmailAddrAndBidToLearn(user, BookCatalog.getValue(bookName));
        int index = (int)(Math.random() * userWordRelationList.size());
        return wordMapper.selectOneWord(BookCatalog.getValue(bookName), userWordRelationList.get(index).getWid());
    }

    public String getTodayProgress(final String user, final String bookName, final String number){
        Float total = Float.parseFloat(number);
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        Integer weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        UserProgress userProgress = userProgressMapper.selectByEmailAddrAndBidAndWeekday(user, BookCatalog.getValue(bookName), weekday);
        if(userProgress == null){
            return "0%";
        }
        Integer count = userProgress.getWordCount();
        return percentFormat.format(count/total);
    }

    public void updateDegree(final String user, final String wid, final String bookName, final Integer degree){
        userWordRelationMapper.update(user, Integer.parseInt(wid), BookCatalog.getValue(bookName), degree);
    }
}
