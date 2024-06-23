package com.taobao.login4android.biz.unifysso;

import android.text.TextUtils;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.helper.LoginResultHelper;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.OnLoginCaller;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.session.ISession;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
public class UnifySsoLogin {
    public static final String TAG = "Login.UnifySsoLogin";

    public static void tokenLogin(int i, String str, ISession iSession) {
        tokenLogin(i, str, false, iSession);
    }

    public static void tokenLogin(final int i, String str, final boolean z, ISession iSession) {
        String str2;
        final LoginParam loginParam = new LoginParam();
        loginParam.token = str;
        loginParam.loginSite = i;
        LoginParam loginParam2 = LoginContext.sCurrentLoginParam;
        if (loginParam2 != null && TextUtils.equals(loginParam2.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
            Properties properties = new Properties();
            if (LoginContext.sCurrentLoginParam != null) {
                properties.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                str2 = LoginContext.sCurrentLoginParam.loginSourcePage;
            } else {
                str2 = UTConstant.PageName.UT_PAGE_EXTEND;
            }
            properties.setProperty("monitor", "T");
            properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
            UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties);
        }
        BackgroundExecutor.execute(new Runnable() {
            /* class com.taobao.login4android.biz.unifysso.UnifySsoLogin.AnonymousClass1 */

            public void run() {
                final RpcResponse rpcResponse;
                try {
                    rpcResponse = UserLoginServiceImpl.getInstance().unifySsoTokenLogin(loginParam);
                } catch (Throwable th) {
                    th.printStackTrace();
                    rpcResponse = null;
                }
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.taobao.login4android.biz.unifysso.UnifySsoLogin.AnonymousClass1.AnonymousClass1 */

                    private void loginFailHit() {
                        LoginParam loginParam = LoginContext.sCurrentLoginParam;
                        if (loginParam != null && TextUtils.equals(loginParam.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
                            Properties properties = new Properties();
                            RpcResponse rpcResponse = rpcResponse;
                            String valueOf = rpcResponse != null ? String.valueOf(rpcResponse.code) : UTConstant.CustomEvent.UT_NETWORK_FAIL;
                            properties.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                            properties.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                            properties.setProperty("loginId", LoginContext.sCurrentLoginParam.loginAccount + "");
                            properties.setProperty("site", LoginContext.sCurrentLoginParam.loginSite + "");
                            UserTrackAdapter.sendUT(LoginContext.sCurrentLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_FAIL, valueOf, LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties);
                        }
                    }

                    public void run() {
                        String str;
                        T t;
                        try {
                            RpcResponse rpcResponse = rpcResponse;
                            if (rpcResponse != null && rpcResponse.returnValue != null && rpcResponse.code == 3000) {
                                LoginParam loginParam = LoginContext.sCurrentLoginParam;
                                if (loginParam != null && TextUtils.equals(loginParam.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
                                    Properties properties = new Properties();
                                    properties.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                                    properties.setProperty("loginId", LoginContext.sCurrentLoginParam.loginAccount + "");
                                    properties.setProperty("site", i + "");
                                    UserTrackAdapter.sendUT(LoginContext.sCurrentLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_SUCCESS, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties);
                                    Properties properties2 = new Properties();
                                    properties2.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                                    properties2.setProperty("monitor", "T");
                                    properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties2);
                                }
                                OnLoginCaller onLoginCaller = AliUserLogin.mLoginCaller;
                                if (onLoginCaller != null) {
                                    onLoginCaller.filterLogin(rpcResponse);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.UnifySsoLogin.getType());
                                LoginDataHelper.processLoginReturnData(true, (LoginReturnData) rpcResponse.returnValue, (Map<String, String>) hashMap);
                            } else if (rpcResponse == null || !"H5".equals(rpcResponse.actionType) || (t = rpcResponse.returnValue) == null || t.token == null) {
                                if (z) {
                                    LoginStatus.resetLoginFlag();
                                    return;
                                }
                                LoginParam loginParam2 = LoginContext.sCurrentLoginParam;
                                if (loginParam2 != null && TextUtils.equals(loginParam2.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
                                    loginFailHit();
                                    String str2 = UTConstant.CustomEvent.UT_NETWORK_FAIL;
                                    RpcResponse rpcResponse2 = rpcResponse;
                                    if (rpcResponse2 != null) {
                                        str2 = String.valueOf(rpcResponse2.code);
                                    }
                                    Properties properties3 = new Properties();
                                    properties3.setProperty("monitor", "T");
                                    properties3.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                    properties3.setProperty("loginId", LoginContext.sCurrentLoginParam.loginAccount + "");
                                    properties3.setProperty("site", LoginContext.sCurrentLoginParam.loginSite + "");
                                    UserTrackAdapter.sendUT(LoginContext.sCurrentLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str2, LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties3);
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("unifySsoLoginFail : code!= 3000 && actionType!= h5");
                                if (rpcResponse != null) {
                                    str = rpcResponse.code + "," + rpcResponse.message;
                                } else {
                                    str = "";
                                }
                                sb.append(str);
                                TLogAdapter.e(UnifySsoLogin.TAG, sb.toString());
                                LoginStatus.resetLoginFlag();
                                BroadCastHelper.sendLoginFailBroadcast(714, "");
                            } else if (z) {
                                LoginStatus.resetLoginFlag();
                            } else {
                                loginFailHit();
                                LoginResultHelper.gotoH5PlaceHolder(DataProviderFactory.getApplicationContext(), rpcResponse.returnValue, LoginContext.sCurrentLoginParam);
                            }
                        } catch (Throwable unused) {
                            LoginStatus.resetLoginFlag();
                            if (!z) {
                                BroadCastHelper.sendLoginFailBroadcast(714, "");
                            }
                        }
                    }
                });
            }
        });
    }
}
