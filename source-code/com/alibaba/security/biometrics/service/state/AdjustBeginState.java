package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AdjustBeginState extends BaseState {
    public AdjustBeginState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void doAdjustStart() {
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_BEGIN);
        Bundle bundle = new Bundle();
        bundle.putInt("aju_c", ABDetectContext.getInstance().getRetryTimes() + 1);
        ABLogRecorder.i().record(ABLogRecorderKeys.EventIdEnterAdjust, bundle);
        this.mABStateMachine.changeDetectType(ABDetectType.KEEP_STILL, false, false);
        this.mABStateMachine.triggerEventListener(3);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.service.state.BaseState
    public String currentState() {
        return "AdjustBeginState";
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState, com.alibaba.security.biometrics.service.state.BaseState, com.alibaba.security.biometrics.service.util.state.State
    public void enter() {
        super.enter();
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState, com.alibaba.security.biometrics.service.util.state.State
    public boolean processMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        doAdjustStart();
        return true;
    }
}
