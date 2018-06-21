package www.george.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.dao.MyBookWord;
import www.george.com.dao.Word;
import www.george.com.mapper.MyBookMapper;
import www.george.com.mapper.WordMapper;
import www.george.com.myEnum.BookCatalog;

import java.text.NumberFormat;
import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookMapper myBookMapper;

    @Autowired
    private WordMapper wordMapper;
    public void addWord(final String emailAddr, final String bookName, final String wid){
        myBookMapper.insertOneWord(emailAddr, BookCatalog.getValue(bookName), Integer.parseInt(wid));
    }

    private Word getWord(final List<MyBookWord> bookWordList, final Integer index){
        if(bookWordList.isEmpty()){
            Word word = new Word();
            word.setWord("");
            word.setMeaning("");
            word.setIndex("0");
            return word;
        }
        MyBookWord myBookWord = bookWordList.get(index);
        Word word = wordMapper.selectOneWord(myBookWord.getBid(), myBookWord.getWid());
        word.setIndex(index.toString());
        return word;
    }

    public Word getWord(final String emailAddr, final Integer index){
        List<MyBookWord> bookWordList = myBookMapper.selectAllWordByEmail(emailAddr);
        return getWord(bookWordList, index);
    }

    public Word getLastWord(final String emailAddr, final Integer index){
        List<MyBookWord> bookWordList = myBookMapper.selectAllWordByEmail(emailAddr);
        if(index.equals(0)){
            return getWord(bookWordList, 0);
        } else {
            return getWord(bookWordList, index-1);
        }
    }

    public Word getNextWord(final String emailAddr, final Integer index){
        List<MyBookWord> bookWordList = myBookMapper.selectAllWordByEmail(emailAddr);
        if(index.equals(bookWordList.size() - 1)){
            return getWord(bookWordList, index);
        } else {
            return getWord(bookWordList, index+1);
        }
    }

    public String getProgressPercent(final String emailAddr, final Integer index){
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        List<MyBookWord> bookWordList = myBookMapper.selectAllWordByEmail(emailAddr);
        Integer total = bookWordList.size();
        if(index < 0){
            return percentFormat.format(1/total.floatValue());
        } else if(total.equals(index)){
            return percentFormat.format(1);
        } else {
            return percentFormat.format((index + 1) / total.floatValue());
        }
    }
}
