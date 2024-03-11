package cn.wdx.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.wdx.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 4:07 PM
 * @version: 1.0
 */
@Component
public class SnowFlake implements IIdGenerator {
    private Snowflake snowflake;

    @PostConstruct
    public void inint(){
        long workerId;
        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch (Exception e){
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;
        long dataCenterId = 1L;
        snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
    }
    @Override
    public long nextId() {
        return snowflake.nextId();
    }
}
