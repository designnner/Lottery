package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.RuleTree;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hi
* @description 针对表【rule_tree】的数据库操作Mapper
* @createDate 2024-03-13 13:55:26
* @Entity cn.wdx.lottery.infrastructure.po.RuleTree
*/
@Mapper
public interface RuleTreeMapper extends BaseMapper<RuleTree> {

    RuleTree queryRuleTreeByTreeId(Long id);

    RuleTree queryTreeSummaryInfo(Long treeId);

}




