package com.ali.user.open.tbauth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.cookies.CookieManagerWrapper;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.config.AuthOption;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.model.SystemMessageConstants;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.core.util.ResourceUtils;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.callback.LogoutCallback;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.task.LogoutTask;
import com.ali.user.open.tbauth.task.RpcPresenter;
import com.ali.user.open.tbauth.ui.TbAuthActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import tb.th2;

/* compiled from: Taobao */
public class TbAuthServiceImpl implements TbAuthService {
    private static final String TAG = "TbAuthService";
    private transient Pattern[] mLoginPatterns;
    private transient Pattern[] mLogoutPatterns;

    /* compiled from: Taobao */
    class RefreshTask extends AsyncTask<Object, Void, Void> {
        MemberCallback callback;

        RefreshTask(MemberCallback memberCallback) {
            this.callback = memberCallback;
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            CookieManagerWrapper.INSTANCE.refreshCookie("taobao");
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void r2) {
            this.callback.onSuccess(r2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void goLogin(LoginCallback loginCallback) {
        SDKLogger.d(TAG, "auth goLogin");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), TbAuthActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    private void goQrCodeLogin(Map<String, String> map, LoginCallback loginCallback) {
        String str;
        SDKLogger.d(TAG, "goQrCodeLogin start");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), TbAuthActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("login_type", 4);
        if (map == null) {
            str = "";
        } else {
            str = JSONUtils.toJsonObject(map).toString();
        }
        intent.putExtra("params", str);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    private boolean isAuthEnvironmentValid(LoginCallback loginCallback) {
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d(TAG, "auth static field is null");
            if (loginCallback != null) {
                loginCallback.onFailure(SystemMessageConstants.NPE_ERROR, "服务不存在");
            }
            return false;
        } else if (CommonUtils.isNetworkAvailable()) {
            return true;
        } else {
            SDKLogger.d(TAG, "auth network not available");
            loginCallback.onFailure(SystemMessageConstants.NET_WORK_ERROR, ResourceUtils.getString("member_sdk_network_not_available_message"));
            return false;
        }
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void auth(LoginCallback loginCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_NEED_AUTOLOGIN, "0");
        hashMap.put("needSession", "0");
        auth(hashMap, loginCallback);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void autoLogin(final LoginCallback loginCallback) {
        SessionManager sessionManager = SessionManager.INSTANCE;
        if (!TextUtils.isEmpty(sessionManager.getInternalSession().autoLoginToken) && sessionManager.getInternalSession() != null && !TextUtils.isEmpty(sessionManager.getInternalSession().userId)) {
            SDKLogger.d(TAG, "auth auto login");
            RpcPresenter.loginByRefreshToken(new LoginCallback() {
                /* class com.ali.user.open.tbauth.TbAuthServiceImpl.AnonymousClass2 */

                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    SDKLogger.d(TbAuthServiceImpl.TAG, "auth auto login success");
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onFailure(i, str);
                    }
                }

                @Override // com.ali.user.open.callback.LoginCallback
                public void onSuccess(Session session) {
                    SDKLogger.d(TbAuthServiceImpl.TAG, "auth auto login success");
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onSuccess(TbAuthServiceImpl.this.getSession());
                    }
                    LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
                    if (loginCallback2 != null) {
                        loginCallback2.onSuccess(TbAuthServiceImpl.this.getSession());
                    }
                }
            });
        } else if (loginCallback != null) {
            loginCallback.onFailure(-1, "auto login token is empty");
        }
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean checkSessionValid() {
        return ((SessionService) AliMemberSDK.getService(SessionService.class)).isSessionValid();
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public Session getSession() {
        return ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean isAppAuthSurpport(Context context) {
        AuthOption authOption = KernelContext.sOneTimeAuthOption;
        AuthOption authOption2 = AuthOption.H5ONLY;
        if (authOption == authOption2 || KernelContext.authOption == authOption2) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(th2.ACTION_CUSTOM);
        intent.setData(Uri.parse("tbopen://m.taobao.com/getway/oauth?" + "&appkey=" + ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey() + "&pluginName=taobao.oauth.code.create" + "&apkSign=" + "" + "&sign=" + ""));
        if (context == null) {
            context = KernelContext.getApplicationContext();
        }
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean isLoginUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mLoginPatterns == null && !TextUtils.isEmpty(ConfigManager.LOGIN_URLS)) {
            String[] split = ConfigManager.LOGIN_URLS.split("[;]");
            Pattern[] patternArr = new Pattern[split.length];
            this.mLoginPatterns = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.mLoginPatterns[i] = Pattern.compile(split[i]);
            }
        }
        for (Pattern pattern : this.mLoginPatterns) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean isLogoutUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mLogoutPatterns == null && !TextUtils.isEmpty(ConfigManager.LOGOUT_URLS)) {
            String[] split = ConfigManager.LOGOUT_URLS.split("[,]");
            Pattern[] patternArr = new Pattern[split.length];
            this.mLogoutPatterns = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.mLogoutPatterns[i] = Pattern.compile(split[i]);
            }
        }
        for (Pattern pattern : this.mLogoutPatterns) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void logout(LogoutCallback logoutCallback) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("withNoActivity", "true");
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("logout".toUpperCase(), hashMap);
        } catch (Exception unused) {
        }
        new LogoutTask(logoutCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void refreshCookie(MemberCallback memberCallback) {
        new RefreshTask(memberCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void setLoginCallback(LoginCallback loginCallback) {
        CallbackContext.mGlobalLoginCallback = loginCallback;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void setWebViewProxy(WebViewProxy webViewProxy) {
        KernelContext.mWebViewProxy = webViewProxy;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void tokenLogin(int i, String str, String str2, String str3, LoginCallback loginCallback) {
        TbAuthContext.needSession = true;
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), TbAuthActivity.class);
        intent.putExtra("login_type", 1);
        intent.putExtra("site", i);
        intent.putExtra("scene", str);
        intent.putExtra("loginToken", str2);
        intent.putExtra(TbAuthConstants.H5_QUERY_STR, str3);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void auth(Map<String, String> map, final LoginCallback loginCallback) {
        String str;
        String str2;
        String str3;
        String str4;
        SDKLogger.d(TAG, "auth start");
        HashMap hashMap = new HashMap();
        if (map == null || TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_TRACE_ID))) {
            str = "oauth" + DeviceInfo.deviceId + (System.currentTimeMillis() / 1000);
        } else {
            str = map.get(ParamsConstants.Key.PARAM_TRACE_ID);
        }
        hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, str);
        TbAuthContext.traceId = str;
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Invoke", hashMap);
        if (!isAuthEnvironmentValid(loginCallback)) {
            SDKLogger.d(TAG, "AuthEnvironment invalid");
            return;
        }
        TbAuthContext.sSceneCode = "";
        TbAuthContext.sIBB = "";
        TbAuthContext.authorizeToken = "";
        String str5 = "0";
        if (map != null) {
            str5 = map.get("needSession");
            str4 = map.get(ParamsConstants.Key.PARAM_NEED_AUTOLOGIN);
            str3 = map.get(ParamsConstants.Key.PARAM_ONLY_AUTHCODE);
            TbAuthContext.sSceneCode = map.get(ParamsConstants.Key.PARAM_SCENE_CODE);
            TbAuthContext.authorizeToken = map.get(ParamsConstants.Key.PARAM_AUTHROIZE_TOKEN);
            TbAuthContext.sIBB = map.get(ParamsConstants.Key.PARAM_IBB);
            str2 = map.get(ParamsConstants.Key.PARAM_IS_BIND);
            if ("1".equals(map.get(ParamsConstants.Key.PARAM_H5ONLY))) {
                TbAuthContext.h5Only = true;
            } else {
                TbAuthContext.h5Only = false;
            }
        } else {
            str4 = str5;
            str3 = str4;
            str2 = str3;
        }
        TbAuthContext.needSession = TextUtils.equals(str5, "1");
        TbAuthContext.onlyAuthCode = TextUtils.equals(str3, "1");
        TbAuthContext.isBind = TextUtils.equals(str2, "1");
        if (TextUtils.equals(str4, "1")) {
            autoLogin(new LoginCallback() {
                /* class com.ali.user.open.tbauth.TbAuthServiceImpl.AnonymousClass1 */

                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    TbAuthServiceImpl.this.goLogin(loginCallback);
                }

                @Override // com.ali.user.open.callback.LoginCallback
                public void onSuccess(Session session) {
                    LoginCallback loginCallback = loginCallback;
                    if (loginCallback != null) {
                        loginCallback.onSuccess(TbAuthServiceImpl.this.getSession());
                    }
                }
            });
        } else {
            goLogin(loginCallback);
        }
    }
}
