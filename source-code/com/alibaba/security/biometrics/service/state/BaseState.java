package com.alibaba.security.biometrics.service.state;

import android.os.Message;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.model.detector.ABDetector;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.util.state.IState;
import com.alibaba.security.biometrics.service.util.state.State;

/* compiled from: Taobao */
abstract class BaseState extends State implements StateKeys {
    protected static final String TAG = "StateMachine";
    protected ALBiometricsParams mABParams;
    protected ALBiometricsService mABService;
    protected ABStateMachine mABStateMachine;
    protected ABDetectListener mDetectListener = this.mABStateMachine.getDetectListener();
    protected ABDetector mDetector = this.mABStateMachine.getDetector();

    public BaseState(ABStateMachine aBStateMachine) {
        this.mABStateMachine = aBStateMachine;
        ALBiometricsService aLBiometricsService = aBStateMachine.getALBiometricsService();
        this.mABService = aLBiometricsService;
        this.mABParams = aLBiometricsService.getParams();
    }

    /* access modifiers changed from: protected */
    public abstract String currentState();

    /* access modifiers changed from: protected */
    public final void deferMessage(Message message) {
        this.mABStateMachine.deferMsg(message);
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState, com.alibaba.security.biometrics.service.util.state.State
    public void enter() {
        super.enter();
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState, com.alibaba.security.biometrics.service.util.state.State
    public void exit() {
        super.exit();
    }

    /* access modifiers changed from: protected */
    public final void setParams(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.mABParams = aLBiometricsParams;
        }
    }

    /* access modifiers changed from: protected */
    public final void transitionTo(IState iState) {
        this.mABStateMachine.transitionState(iState);
    }
}
