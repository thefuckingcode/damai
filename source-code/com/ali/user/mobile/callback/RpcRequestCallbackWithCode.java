package com.ali.user.mobile.callback;

import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
public interface RpcRequestCallbackWithCode {
    void onError(String str, RpcResponse rpcResponse);

    void onSuccess(RpcResponse rpcResponse);

    void onSystemError(String str, RpcResponse rpcResponse);
}
