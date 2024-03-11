package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.Strategy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hi
* @description 针对表【strategy(策略配置)】的数据库操作Mapper
* @createDate 2024-03-09 09:12:53
* @Entity cn.wdx.lottery.infrastructure.po.Strategy
*/
@Mapper
public interface StrategyMapper extends BaseMapper<Strategy> {

    Strategy queryStrategy(Long strategyId);

}




