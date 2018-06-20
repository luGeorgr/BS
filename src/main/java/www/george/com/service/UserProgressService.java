package www.george.com.service;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.dao.UserProgress;
import www.george.com.mapper.UserProgressMapper;
import www.george.com.mapper.UserWordRelationMapper;
import www.george.com.myEnum.BookCatalog;
import www.george.com.myEnum.WeekdayCatalog;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

@Service
public class UserProgressService {
    @Autowired
    private UserProgressMapper userProgressMapper;

    @Autowired
    private UserWordRelationMapper userWordRelationMapper;
    public Map<String, Integer> getUserProgress(final String emailAddr, final String bookName){
        Map<String, Integer> map = initProgressMap();
        Integer bid = BookCatalog.getValue(bookName);
        List<UserProgress> list = userProgressMapper.selectByEmailAddrAndBid(emailAddr, bid);
        for(UserProgress userProgress : list){
            map.put(WeekdayCatalog.getValue(userProgress.getWeekday()), userProgress.getWordCount());
        }
        return map;
    }

    public String getProgressPerncent(final String emailAddr, final String bookName){
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        Integer count = userWordRelationMapper.countLearnedWord(emailAddr, BookCatalog.getValue(bookName));
        return percentFormat.format(count/BookCatalog.getTotalWords(bookName));
    }

    private Map<String, Integer> initProgressMap(){
        Map<String, Integer> map = Maps.newHashMapWithExpectedSize(7);
        map.put("Sunday", 0);
        map.put("Monday", 0);
        map.put("Tuesday", 0);
        map.put("Wednesday", 0);
        map.put("Thursday", 0);
        map.put("Friday", 0);
        map.put("Saturday", 0);
        return map;
    }
}
