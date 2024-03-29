package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.UserTakeActivityCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hi
* @description 针对表【user_take_activity_count(用户活动参与次数表)】的数据库操作Mapper
* @createDate 2024-03-12 19:28:16
* @Entity cn.wdx.lottery.infrastructure.po.UserTakeActivityCount
*/
@Mapper
public interface UserTakeActivityCountMapper extends BaseMapper<UserTakeActivityCount> {

    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount userTakeActivityCount);

    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);
}




