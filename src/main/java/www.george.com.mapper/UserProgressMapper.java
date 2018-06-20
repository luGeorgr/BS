package www.george.com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import www.george.com.dao.UserProgress;

import java.util.List;

@Repository
public interface UserProgressMapper {
    void insertOrUpdateUserProgress(@Param("emailAddr") String emailAddr,
                                    @Param("bid") Integer bid,
                                    @Param("weekday") Integer weekday,
                                    @Param("wordCount") Integer wordCount);
    List<UserProgress> selectByEmailAddrAndBid(@Param("emailAddr") String emailAddr,
                                               @Param("bid") Integer bid);

    UserProgress selectByEmailAddrAndBidAndWeekday(@Param("emailAddr") String emailAddr,
                                                         @Param("bid") Integer bid,
                                                         @Param("weekday") Integer weekday);
}
