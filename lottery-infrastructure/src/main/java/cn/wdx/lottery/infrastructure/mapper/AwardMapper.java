package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.Award;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author hi
* @description 针对表【award(奖品配置)】的数据库操作Mapper
* @createDate 2024-03-09 09:12:53
* @Entity cn.wdx.lottery.infrastructure.po.Award
*/
@Mapper
public interface AwardMapper extends BaseMapper<Award> {
    Award queryAwardInfo(String awardId);

    void insertList(List<Award> awardList);
}




