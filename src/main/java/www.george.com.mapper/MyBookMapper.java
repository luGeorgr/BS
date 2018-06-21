package www.george.com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import www.george.com.dao.MyBookWord;

import java.util.List;

@Repository
public interface MyBookMapper {
    void insertOneWord(@Param("emailAddr") String emailAddr,
                       @Param("bid") Integer bid,
                       @Param("wid") Integer wid);

    List<MyBookWord> selectWordByBid(@Param("emailAddr") String emailAddr,
                                     @Param("bid") Integer bid);

    void deleteWord(@Param("emailAddr") String emailAddr,
                       @Param("bid") Integer bid,
                       @Param("wid") Integer wid);
}
