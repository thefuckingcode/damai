package com.ali.user.mobile.login.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;

/* compiled from: Taobao */
public class TokenLoginTask extends BaseLoginTask {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public String getLoginType() {
        LoginParam loginParam = this.loginParam;
        if (loginParam == null || TextUtils.isEmpty(loginParam.nativeLoginType)) {
            return LoginType.ServerLoginType.TokenLogin.getType();
        }
        return this.loginParam.nativeLoginType;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
    }
}
