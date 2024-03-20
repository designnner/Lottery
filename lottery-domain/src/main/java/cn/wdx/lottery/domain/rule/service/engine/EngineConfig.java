package cn.wdx.lottery.domain.rule.service.engine;

import cn.wdx.lottery.domain.rule.service.logic.LogicFilter;
import cn.wdx.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import cn.wdx.lottery.domain.rule.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 2:58 PM$
 * @github: https://github.com/designnner
 */
public class EngineConfig {
    protected static Map<String, LogicFilter> filterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;
    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init(){
        filterMap.put("userAge", userAgeFilter);
        filterMap.put("userGender", userGenderFilter);
    }
}
