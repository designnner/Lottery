package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.StrategyDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author hi
* @description 针对表【strategy_detail(策略明细)】的数据库操作Mapper
* @createDate 2024-03-09 09:12:53
* @Entity cn.wdx.lottery.infrastructure.po.StrategyDetail
*/
@Mapper
public interface StrategyDetailMapper extends BaseMapper<StrategyDetail> {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    int deductStock(StrategyDetail strategyDetail);


    void insertList(List<StrategyDetail> strategyDetailList);

}




