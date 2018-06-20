package www.george.com.Configure.Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.george.com.dao.Word;
import www.george.com.mapper.WordMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class WordMapperTest {
    @Autowired
    WordMapper wordMapper;
    @Test
    public void testWordMapper(){
        Word word = wordMapper.selectOneWord(1, 0);
        Assert.assertTrue(word.getWid().equals(0));
    }
}
