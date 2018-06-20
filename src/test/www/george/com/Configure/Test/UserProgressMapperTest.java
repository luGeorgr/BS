package www.george.com.Configure.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.george.com.dao.UserProgress;
import www.george.com.mapper.UserProgressMapper;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class UserProgressMapperTest {


    @Autowired
    UserProgressMapper userProgressMapper;
    @Test
    public void testUserProgressMapper(){
        userProgressMapper.insertOrUpdateUserProgress("18867107612@163.com", 0, 0, 10);
        userProgressMapper.insertOrUpdateUserProgress("18867107612@163.com", 0, 0, 20);
        List<UserProgress> list = userProgressMapper.selectByEmailAddrAndBid("18867107612@163.com", 0);
        userProgressMapper.selectByEmailAddrAndBidAndWeekday("18867107612@163.com", 0, 0);

    }
}
