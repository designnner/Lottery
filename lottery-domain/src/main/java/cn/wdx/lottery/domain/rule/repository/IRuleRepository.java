package cn.wdx.lottery.domain.rule.repository;

import cn.wdx.lottery.domain.rule.model.aggregates.TreeRuleRich;

/*
 * @author: wdxxx
 * @description:  规则信息仓储服务接口
 * @date:    2024/3/13 1:53 PM
 * @github: https://github.com/designnner
 */
public interface IRuleRepository {
    TreeRuleRich queryTreeRuleRich(Long treeId);
}
