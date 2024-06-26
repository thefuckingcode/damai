package com.taobao.login4android.biz.before.logout;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.PreLogoutResponse;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.biz.logout.LogoutParam;
import com.taobao.login4android.log.LoginTLogAdapter;
import java.util.Map;

/* compiled from: Taobao */
public class BeforeLogoutBiz {

    /* compiled from: Taobao */
    static class a implements RpcRequestCallback {
        final /* synthetic */ CommonCallback a;

        /* access modifiers changed from: package-private */
        /* renamed from: com.taobao.login4android.biz.before.logout.BeforeLogoutBiz$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0218a implements LoginFilterCallback {
            C0218a() {
            }

            @Override // com.ali.user.mobile.filter.LoginFilterCallback
            public void onFail(int i, Map<String, String> map) {
                BeforeLogoutBiz.callbackSuccess(a.this.a);
            }

            @Override // com.ali.user.mobile.filter.LoginFilterCallback
            public void onSuccess() {
                BeforeLogoutBiz.callbackSuccess(a.this.a);
            }
        }

        a(CommonCallback commonCallback) {
            this.a = commonCallback;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse rpcResponse) {
            if (rpcResponse != null) {
                try {
                    if (rpcResponse.returnValue != null) {
                        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToLoginPostPage(DataProviderFactory.getApplicationContext(), ((PreLogoutResponse) rpcResponse).returnValue.h5Url, new C0218a());
                        return;
                    }
                } catch (Throwable th) {
                    BeforeLogoutBiz.callbackSuccess(this.a);
                    LoginTLogAdapter.w("login.BeforeLogoutBiz", "logout from server failed.", th);
                    return;
                }
            }
            BeforeLogoutBiz.callbackSuccess(this.a);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse rpcResponse) {
            onError(rpcResponse);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse rpcResponse) {
            onError(rpcResponse);
        }
    }

    public static void callBeforeLogout(LogoutParam logoutParam, CommonCallback commonCallback) {
        try {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.API_NAME = ApiConstants.ApiName.BEFORE_LOGOUT;
            LogoutPreCheckRequest logoutPreCheckRequest = new LogoutPreCheckRequest();
            logoutPreCheckRequest.loggedUserNum = logoutParam.loggedUserNum;
            UserLoginServiceImpl.buildBaseRequest(null, logoutPreCheckRequest);
            rpcRequest.addParam("request", JSON.toJSONString(logoutPreCheckRequest));
            rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
            ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, PreLogoutResponse.class, new a(commonCallback));
        } catch (Throwable th) {
            LoginTLogAdapter.w("login.BeforeLogoutBiz", "logout from server failed.", th);
            th.printStackTrace();
            callbackSuccess(commonCallback);
        }
    }

    public static void callbackSuccess(CommonCallback commonCallback) {
        if (commonCallback != null) {
            commonCallback.onSuccess();
        }
    }
}
