package cn.wdx.lottery.domain.support.ids;



import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.support.ids.policy.RandomNumeric;
import cn.wdx.lottery.domain.support.ids.policy.ShortCode;
import cn.wdx.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 4:10 PM
 * @version: 1.0
 */
@Configuration
public class IdContext {


    @Bean
    public Map<Constants.Ids,IIdGenerator> idGenerator(SnowFlake snowflake, RandomNumeric randomNumeric, ShortCode shortCode){
        Map<Constants.Ids,IIdGenerator> idGeneratorMap = new HashMap<>();
        idGeneratorMap.put(Constants.Ids.SnowFlake,snowflake);
        idGeneratorMap.put(Constants.Ids.RandomNumeric,randomNumeric);
        idGeneratorMap.put(Constants.Ids.ShortCode,shortCode);
        return idGeneratorMap;
    }


}
