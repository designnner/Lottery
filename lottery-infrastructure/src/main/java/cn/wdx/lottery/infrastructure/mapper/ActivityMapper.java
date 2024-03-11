package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.domain.activity.model.vo.AlterStateVO;
import cn.wdx.lottery.infrastructure.po.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hi
* @description 针对表【activity(活动配置)】的数据库操作Mapper
* @createDate 2024-03-06 20:04:29
* @Entity cn.wdx.lottery.infrastructure.po.Activity
*/
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    void insertByPo(Activity req);

    Activity queryActivityById(Long activityId);

    int alterState(AlterStateVO alterStateVO);
}




