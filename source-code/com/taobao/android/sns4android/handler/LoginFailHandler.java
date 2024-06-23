package com.taobao.android.sns4android.handler;

import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;

/* compiled from: Taobao */
public interface LoginFailHandler {
    boolean loginFailHandler(RpcResponse<LoginReturnData> rpcResponse);
}
