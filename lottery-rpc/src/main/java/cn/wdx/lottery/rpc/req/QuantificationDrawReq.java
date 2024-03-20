package cn.wdx.lottery.rpc.req;

import java.util.Map;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 4:12 PM$
 * @github: https://github.com/designnner
 */
public class QuantificationDrawReq {
    private String uId;
    private Long treeId;
    private Map<String,Object> valMap;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }
}
