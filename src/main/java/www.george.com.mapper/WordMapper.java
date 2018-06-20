package www.george.com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import www.george.com.dao.Word;

import java.util.List;

@Repository
public interface WordMapper {
    Word selectOneWord(@Param("bid") int bid, @Param("wid") Integer wid);
    List<Word> selectAll(@Param("bid") Integer bid);
}
