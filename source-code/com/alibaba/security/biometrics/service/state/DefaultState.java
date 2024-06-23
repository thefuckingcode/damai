package com.alibaba.security.biometrics.service.state;

import android.os.Message;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class DefaultState extends BaseState {
    public DefaultState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.service.state.BaseState
    public String currentState() {
        return "DefaultState";
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState, com.alibaba.security.biometrics.service.util.state.State
    public boolean processMessage(Message message) {
        return true;
    }
}
