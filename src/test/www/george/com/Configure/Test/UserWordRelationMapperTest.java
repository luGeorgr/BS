package www.george.com.Configure.Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.george.com.dao.UserWordRelation;
import www.george.com.dao.Word;
import www.george.com.mapper.UserWordRelationMapper;
import www.george.com.mapper.WordMapper;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class UserWordRelationMapperTest {
    @Autowired
    UserWordRelationMapper userWordRelationMapper;
    @Test
    public void testUserWordRelationMapper(){
        boolean b = userWordRelationMapper.userBookExist("18867107612@163.com", 0);
        Assert.assertTrue(b);
        List<UserWordRelation> list = new ArrayList<>(1);
        UserWordRelation userWordRelation = new UserWordRelation();
        userWordRelation.setWid(0);
        userWordRelation.setEmailAddr("18867107612@163.com");
        userWordRelation.setDegree(0);
        userWordRelation.setBid(0);
        list.add(userWordRelation);
        userWordRelationMapper.addAll(list);
    }
}
