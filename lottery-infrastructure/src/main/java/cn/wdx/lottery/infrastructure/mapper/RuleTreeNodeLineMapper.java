package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.RuleTreeNodeLine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author hi
* @description 针对表【rule_tree_node_line】的数据库操作Mapper
* @createDate 2024-03-13 13:55:26
* @Entity cn.wdx.lottery.infrastructure.po.RuleTreeNodeLine
*/
@Mapper
public interface RuleTreeNodeLineMapper extends BaseMapper<RuleTreeNodeLine> {
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    int queryTreeNodeLineCount(Long treeId);
}




