package cn.wdx.lottery.infrastructure.mapper;


import cn.wdx.lottery.infrastructure.po.Activity;
import cn.wdx.lottery.infrastructure.po.AlterState;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    int alterState(AlterState alterStateVO);

    int subtractionActivityStock(Long activityId);

    List<Activity> scanToDoActivityList(Long id);
}




