package www.george.com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import www.george.com.dao.UserWordRelation;

import java.util.List;

@Repository
public interface UserWordRelationMapper {
    Integer countLearnedWord(@Param("emailAddr") String emailAddr,
                             @Param("bid") Integer bid);
    Boolean userBookExist(@Param("emailAddr") String emailAddr,
                          @Param("bid") Integer bid);
    void addAll(@Param("relationList") List<UserWordRelation> relationList);

    List<UserWordRelation> selectByEmailAddrAndBidToLearn(@Param("emailAddr") String emailAddr,
                                                   @Param("bid") Integer bid);
    void update(@Param("emailAddr") String emailAddr,
                @Param("wid") Integer wid,
                @Param("bid") Integer bid,
                @Param("degree") Integer degree);
    List<UserWordRelation> selectByDegree(@Param("emailAddr") String emailAddr,
                                          @Param("degree") Integer degree);
}
