package com.ali.user.open.ucc.util;

import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.data.DefaultDataProvider;
import java.util.Map;

/* compiled from: Taobao */
public class MtopRemoteLogin {
    private static final String TAG = "MtopRemoteLogin";

    public static Session getSession(String str) {
        try {
            return ((UccService) AliMemberSDK.getService(UccService.class)).getSession(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void login(LoginCallback loginCallback) {
        login("taobao", loginCallback);
    }

    /* access modifiers changed from: private */
    public static void sendUT(String str) {
        try {
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_UccMtopRemoteLogin", str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void login(final String str, LoginCallback loginCallback) {
        SDKLogger.e(TAG, "TRUSTLOGIN_ENTER");
        if (System.currentTimeMillis() - UccStatus.getLastLoginTime(str) > 3000) {
            UccStatus.resetLoginFlag(str);
        }
        if (!UccStatus.isLogining(str) || System.currentTimeMillis() - UccStatus.getLastLoginTime(str) >= 180000) {
            UccStatus.compareAndSetLogining(str, false, true);
            UccCallbackManager.registerTrustLoginUccCallback(str, loginCallback);
            AliMemberSDK.init(KernelContext.getApplicationContext(), new InitResultCallback() {
                /* class com.ali.user.open.ucc.util.MtopRemoteLogin.AnonymousClass1 */

                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                }

                @Override // com.ali.user.open.core.callback.InitResultCallback
                public void onSuccess() {
                    if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null) {
                        ((UccService) AliMemberSDK.getService(UccService.class)).setUccDataProvider(new DefaultDataProvider());
                    }
                    ((UccService) AliMemberSDK.getService(UccService.class)).trustLogin(str, (Map<String, String>) null, new UccCallback() {
                        /* class com.ali.user.open.ucc.util.MtopRemoteLogin.AnonymousClass1.AnonymousClass1 */

                        @Override // com.ali.user.open.ucc.UccCallback
                        public void onFail(String str, int i, String str2) {
                            SDKLogger.e(MtopRemoteLogin.TAG, "TRUSTLOGIN_FAIL site=" + str + ";code=" + i);
                            MtopRemoteLogin.sendUT("TRUSTLOGIN_FAIL");
                            UccStatus.resetLoginFlag(str);
                            if (UccCallbackManager.getTrustLoginCallbackWithSite(str) != null) {
                                for (LoginCallback loginCallback : UccCallbackManager.getTrustLoginCallbackWithSite(str)) {
                                    if (loginCallback != null) {
                                        loginCallback.onFailure(i, str2);
                                    }
                                }
                                UccCallbackManager.unregisterTrustLoginCallback(str);
                            }
                        }

                        @Override // com.ali.user.open.ucc.UccCallback
                        public void onSuccess(String str, Map map) {
                            SDKLogger.e(MtopRemoteLogin.TAG, "TRUSTLOGIN_SUCCESS");
                            MtopRemoteLogin.sendUT("TRUSTLOGIN_SUCCESS");
                            UccStatus.resetLoginFlag(str);
                            if (UccCallbackManager.getTrustLoginCallbackWithSite(str) != null) {
                                for (LoginCallback loginCallback : UccCallbackManager.getTrustLoginCallbackWithSite(str)) {
                                    if (loginCallback != null) {
                                        loginCallback.onSuccess(null);
                                    }
                                }
                                UccCallbackManager.unregisterTrustLoginCallback(str);
                            }
                        }
                    });
                }
            });
            return;
        }
        UccCallbackManager.registerTrustLoginUccCallback(str, loginCallback);
    }
}
