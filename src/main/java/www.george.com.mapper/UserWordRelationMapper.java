package www.george.com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWordRelationMapper {
    Integer countLearnedWord(@Param("emailAddr") String emailAddr,
                             @Param("bid") Integer bid);
}
