package cn.wdx.lottery.domain.support.ids.policy;

import cn.wdx.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 4:01 PM
 * @version: 1.0
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
