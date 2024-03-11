package cn.wdx.lottery.test;

import cn.wdx.lottery.rpc.IActivityBooth;
import cn.wdx.lottery.rpc.req.ActivityReq;
import cn.wdx.lottery.rpc.res.ActivityRes;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/6 9:12 PM
 * @version: 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private IActivityBooth activityBooth;

    @Test
    public void test() {
        log.info("test");
        ActivityReq activityReq = new ActivityReq();
        activityReq.setActivityId(1L);
        ActivityRes activityRes = activityBooth.queryActivityById(activityReq);
        log.info("activityRes:{}", activityRes);
    }
}
