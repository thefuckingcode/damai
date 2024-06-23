package com.alibaba.security.biometrics.service.util.state;

import android.os.Message;

/* compiled from: Taobao */
public class State implements IState {
    protected State() {
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public void exit() {
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        return false;
    }
}
