package www.george.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.mapper.MyBookMapper;
import www.george.com.mapper.WordMapper;
import www.george.com.myEnum.BookCatalog;

@Service
public class MyBookService {
    @Autowired
    private MyBookMapper myBookMapper;

    @Autowired
    private WordMapper wordMapper;
    public void addWord(final String emailAddr, final String bookName, final String wid){
        myBookMapper.insertOneWord(emailAddr, BookCatalog.getValue(bookName), Integer.parseInt(wid));
    }
}
