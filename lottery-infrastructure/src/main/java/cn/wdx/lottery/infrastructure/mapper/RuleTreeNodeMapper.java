package cn.wdx.lottery.infrastructure.mapper;

import cn.wdx.lottery.infrastructure.po.RuleTreeNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author hi
* @description 针对表【rule_tree_node】的数据库操作Mapper
* @createDate 2024-03-13 13:55:26
* @Entity cn.wdx.lottery.infrastructure.po.RuleTreeNode
*/
@Mapper
public interface RuleTreeNodeMapper extends BaseMapper<RuleTreeNode> {

    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    int queryTreeNodeCount(Long treeId);

    List<RuleTreeNode> queryTreeRulePoint(Long treeId);

}




