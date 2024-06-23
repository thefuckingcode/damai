package com.ali.user.open.ucc.data;

import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.ucc.UccDataProvider;

/* compiled from: Taobao */
public class DefaultDataProvider implements UccDataProvider {
    @Override // com.ali.user.open.ucc.UccDataProvider
    public void getUserToken(String str, final MemberCallback<String> memberCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.taobao.apply.usertoken";
        rpcRequest.version = "1.0";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, UserTokenModel.class, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.data.DefaultDataProvider.AnonymousClass1 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                String str2;
                MemberCallback memberCallback = memberCallback;
                if (memberCallback != null) {
                    if (rpcResponse == null) {
                        str2 = "";
                    } else {
                        str2 = rpcResponse.message;
                    }
                    memberCallback.onFailure(1004, str2);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t = rpcResponse.returnValue;
                T t2 = t;
                if (t != null) {
                    String str = t2.userToken;
                    MemberCallback memberCallback = memberCallback;
                    if (memberCallback != null) {
                        memberCallback.onSuccess(str);
                        return;
                    }
                    return;
                }
                MemberCallback memberCallback2 = memberCallback;
                if (memberCallback2 != null) {
                    memberCallback2.onFailure(1004, rpcResponse.message);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                String str2;
                MemberCallback memberCallback = memberCallback;
                if (memberCallback != null) {
                    if (rpcResponse == null) {
                        str2 = "";
                    } else {
                        str2 = rpcResponse.message;
                    }
                    memberCallback.onFailure(1004, str2);
                }
            }
        });
    }
}
