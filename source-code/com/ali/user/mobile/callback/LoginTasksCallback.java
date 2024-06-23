package com.ali.user.mobile.callback;

import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
public interface LoginTasksCallback<T> {
    void onCancel();

    void onFail(LoginException<T> loginException);

    void onSuccess(RpcResponse<T> rpcResponse);
}
