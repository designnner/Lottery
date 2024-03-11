package cn.wdx.lottery.domain.strategy.service.draw;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.wdx.lottery.domain.strategy.model.req.DrawReq;
import cn.wdx.lottery.domain.strategy.model.res.DrawResult;
import cn.wdx.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.wdx.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.wdx.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.wdx.lottery.infrastructure.po.Award;
import cn.wdx.lottery.infrastructure.po.Strategy;
import cn.wdx.lottery.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 1:35 PM
 * @version: 1.0
 */
@Slf4j
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{
    @Override
    public DrawResult doDrawExec(DrawReq req) {
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();

        this.checkAndInitRateData(strategy.getId(),strategy.getStrategymode(),strategyRich.getStrategyDetails());

        List<String> excludeAwardIds = this.queryExcludeAwardIds(strategy.getId());

        String awardId = this.drawAlgorithm(strategy.getId(), drawAlgorithmMap.get(strategy.getStrategymode()), excludeAwardIds);

        return this.buildDrawResult(req.getUId(), req.getStrategyId(), awardId);


    }

    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    protected abstract String drawAlgorithm(Long strategyId,IDrawAlgorithm drawAlgorithm,List<String> excludeAwardIds);

    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        if(!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)){
            return ;
        }

        IDrawAlgorithm iDrawAlgorithm = drawAlgorithmMap.get(strategyMode);

        if(iDrawAlgorithm.isExistRateTuple(strategyId)){
            return ;
        }

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(String.valueOf(strategyDetail.getAwardid()),strategyDetail.getAwardrate()));
        }
        iDrawAlgorithm.initRateTuple(strategyId,awardRateInfoList);
    }

    private DrawResult buildDrawResult(String uId,Long strategyId,String awardId){
        if(null == awardId){
            log.info("执行策抽奖完成【未中奖】，用户：{},策略ID：{}",uId,strategyId);
            return new DrawResult(uId,strategyId,Constants.DrawState.FAIL.getCode());
        }

        Award award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(String.valueOf(award.getAwardid()), award.getAwardname());
        log.info("执行策抽奖完成【中奖】，用户：{},策略ID：{},奖品ID：{},奖品名称：{}",uId,strategyId,awardId,award.getAwardname());
        return new DrawResult(uId,strategyId,Constants.DrawState.SUCCESS.getCode(),drawAwardInfo);

    }
}
