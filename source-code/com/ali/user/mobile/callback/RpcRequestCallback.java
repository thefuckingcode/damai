package com.ali.user.mobile.callback;

import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
public interface RpcRequestCallback<T> {
    void onError(RpcResponse<T> rpcResponse);

    void onSuccess(RpcResponse<T> rpcResponse);

    void onSystemError(RpcResponse<T> rpcResponse);
}
