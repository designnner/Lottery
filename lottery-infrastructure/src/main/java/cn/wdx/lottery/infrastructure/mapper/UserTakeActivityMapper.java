package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.UserTakeActivity;
import cn.wdx.middleware.db.router.annotation.DBRouter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hi
* @description 针对表【user_take_activity(用户参与活动记录表)】的数据库操作Mapper
* @createDate 2024-03-12 19:28:16
* @Entity cn.wdx.lottery.infrastructure.po.UserTakeActivity
*/
@Mapper
public interface UserTakeActivityMapper extends BaseMapper<UserTakeActivity> {

    int lockTackActivity(UserTakeActivity userTakeActivity);

    @DBRouter
    UserTakeActivity queryNoConsumedTakeActivityOrder(UserTakeActivity userTakeActivity);
}




