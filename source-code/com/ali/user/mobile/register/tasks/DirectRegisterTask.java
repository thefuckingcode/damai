package com.ali.user.mobile.register.tasks;

import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.RegisterDataRepository;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;

/* compiled from: Taobao */
public class DirectRegisterTask extends BaseRegisterTask {
    private RegistParam registParam;
    private String token;

    public DirectRegisterTask(RegistParam registParam2, String str) {
        this.registParam = registParam2;
        this.token = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask
    public void invokeRegisterRpc(OceanRegisterParam oceanRegisterParam, RpcRequestCallback<OceanRegisterResult> rpcRequestCallback) {
        RegisterDataRepository.getInstance().directRegister(this.registParam, this.token, rpcRequestCallback);
    }
}
