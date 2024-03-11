package cn.wdx.lottery.domain.activity.service.stateflow;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.activity.service.stateflow.event.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/10 3:42 PM
 * @version: 1.0
 */
public class StateConfig {
    @Resource
    private ArraignmentState arraignmentState;
    @Resource
    private OpenState openState;
    @Resource
    private DointState doingState;

    @Resource
    private RefuseState refuseState;
    @Resource
    private PassState passState;
    @Resource
    private CloseState closeState;
    @Resource
    private EditingState editingState;

    protected Map<Enum<Constants.ActivityState>,AbstractState> stateMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        stateMap.put(Constants.ActivityState.ARRAIGNMENT,arraignmentState);
        stateMap.put(Constants.ActivityState.OPEN,openState);
        stateMap.put(Constants.ActivityState.DOING,doingState);
        stateMap.put(Constants.ActivityState.REFUSE,refuseState);
        stateMap.put(Constants.ActivityState.PASS,passState);
        stateMap.put(Constants.ActivityState.CLOSE,closeState);
        stateMap.put(Constants.ActivityState.EDIT,editingState);
    }




}
