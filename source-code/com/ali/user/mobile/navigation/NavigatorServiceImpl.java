package com.ali.user.mobile.navigation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.data.RegisterComponent;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegType;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.LoginHistory;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.safe.AES;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.verify.VerifyApi;
import com.ali.user.mobile.webview.AliUserRegisterWebviewActivity;
import com.ali.user.mobile.webview.LoginPostHandler;
import com.ali.user.mobile.webview.WebViewActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginSceneConstants;
import com.taobao.login4android.log.LoginTLogAdapter;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class NavigatorServiceImpl implements NavigatorService {
    private static final String TAG = "Login.NavigatorServiceImpl";

    public static void addData(UrlParam urlParam, Intent intent) {
        intent.putExtra(WebConstant.WEBURL, urlParam.url);
        intent.putExtra("requestCode", urlParam.requestCode);
        if ("changePassword".equals(urlParam.scene) || LoginSceneConstants.SCENE_FOUNDPASSWORD.equals(urlParam.scene)) {
            intent.putExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE, TokenType.FIND_PWD);
        } else {
            intent.putExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE, urlParam.tokenType);
        }
        if (!TextUtils.isEmpty(urlParam.ivScene)) {
            intent.putExtra(WebConstant.WEB_IV_SCENE, urlParam.ivScene);
        }
        if (!TextUtils.isEmpty(urlParam.scene)) {
            intent.putExtra("scene", urlParam.scene);
        }
        if (!TextUtils.isEmpty(urlParam.token)) {
            intent.putExtra("token", urlParam.token);
        }
        if (!TextUtils.isEmpty(urlParam.userid)) {
            intent.putExtra("USERID", urlParam.userid);
        }
        LoginParam loginParam = urlParam.loginParam;
        if (loginParam != null) {
            intent.putExtra(WebConstant.SSO_LOGIN_PARAM, loginParam);
            intent.putExtra(WebConstant.WEB_LOGIN_TYPE, urlParam.loginParam.loginType);
            intent.putExtra(WebConstant.WEB_NATIVE_LOGIN_TYPE, urlParam.loginParam.nativeLoginType);
            intent.putExtra(WebConstant.WEB_SNS_TRUST_LOGIN_TOKEN, urlParam.loginParam.snsToken);
            intent.putExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE, urlParam.loginParam.tokenType);
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(urlParam.loginParam));
            intent.putExtra(WebConstant.WEB_CANCEL_BROADCAST, urlParam.loginParam.sendLoginFailWhenWebviewCancel);
            if ("changePassword".equals(urlParam.scene) || LoginSceneConstants.SCENE_FOUNDPASSWORD.equals(urlParam.scene)) {
                intent.putExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE, TokenType.FIND_PWD);
            } else {
                intent.putExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE, urlParam.loginParam.tokenType);
            }
            intent.putExtra("site", urlParam.loginParam.loginSite);
        }
        if (urlParam.ext != null) {
            intent.putExtra("ext", new JSONObject(urlParam.ext).toJSONString());
        }
        if (!TextUtils.isEmpty(urlParam.loginId)) {
            intent.putExtra(WebConstant.WEB_LOGIN_ID, urlParam.loginId);
        } else {
            LoginParam loginParam2 = urlParam.loginParam;
            if (loginParam2 != null && !TextUtils.isEmpty(loginParam2.loginAccount)) {
                intent.putExtra(WebConstant.WEB_LOGIN_ID, urlParam.loginParam.loginAccount);
            }
        }
        if (urlParam.needTitle) {
            intent.putExtra(WebConstant.WEB_ALLOW_TITLE, true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isProcessSupportLogin(Context context, String str) {
        String[] split;
        try {
            String config = LoginSwitch.getConfig("process_whitelist", "com.taobao.taobao;com.taobao.taobao:wml");
            if (!TextUtils.isEmpty(config) && (split = config.split(";")) != null && split.length > 0) {
                for (String str2 : split) {
                    if (TextUtils.equals(str2, str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void fetchRegisterUrl(final Context context, final RegistParam registParam) {
        BaseRegistRequest baseRegistRequest = new BaseRegistRequest();
        baseRegistRequest.regFrom = registParam.regFrom;
        baseRegistRequest.registSite = registParam.registSite;
        RegisterComponent.getInstance().getRegisterH5Url(baseRegistRequest, new RpcRequestCallback() {
            /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass5 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != null) {
                    T t2 = t;
                    try {
                        if (!TextUtils.isEmpty(t2)) {
                            Context context = context;
                            if (context == null) {
                                context = DataProviderFactory.getApplicationContext();
                            }
                            Intent intent = new Intent(context, AliUserRegisterWebviewActivity.class);
                            if (!(context instanceof Activity)) {
                                intent.addFlags(268435456);
                            }
                            intent.putExtra("site", registParam.registSite);
                            intent.putExtra(WebConstant.WEBURL, (String) t2);
                            context.startActivity(intent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
            }
        });
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void fingerIV(final Context context, final CommonCallback commonCallback) {
        if (commonCallback != null) {
            try {
                UserTrackAdapter.sendUT("fingerIV");
                new AES().checkValid(new CommonCallback() {
                    /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass7 */

                    @Override // com.ali.user.mobile.model.CommonCallback
                    public void onFail(int i, String str) {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "fingerIV_checkFail", String.valueOf(i), null);
                        commonCallback.onFail(1602, "指纹核身失败");
                        VerifyApi.invalidAll();
                    }

                    @Override // com.ali.user.mobile.model.CommonCallback
                    public void onSuccess() {
                        UserTrackAdapter.sendUT("fingerIV_checkSuccess");
                        NavigatorManager.getInstance().navToFinger(context, 3, commonCallback);
                    }
                });
            } catch (Throwable unused) {
                commonCallback.onFail(1602, "指纹核身失败");
            }
        }
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void fingerLogin(final Context context, final CommonCallback commonCallback) {
        try {
            UserTrackAdapter.sendUT("fingerLogin");
            new AES().checkValid(new CommonCallback() {
                /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass6 */

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onFail(int i, String str) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "fingerLogin_checkFail", String.valueOf(i), null);
                    commonCallback.onFail(1602, "指纹登录失败，请换个方式登录");
                    VerifyApi.invalidAll();
                }

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onSuccess() {
                    UserTrackAdapter.sendUT("fingerLogin_checkSuccess");
                    NavigatorManager.getInstance().navToFingerLogin(context, commonCallback);
                }
            });
            return;
        } catch (Throwable unused) {
        }
        th.printStackTrace();
        commonCallback.onFail(1602, "指纹登录失败，请换个方式登录");
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void fingerSet(Context context, CommonCallback commonCallback) {
        NavigatorManager.getInstance().navToFingerSet(context, commonCallback);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void navToLoginPage(Context context, String str, boolean z) {
        NavigatorManager.getInstance().navToLoginPage(context, null, str, z);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void navToLoginPostPage(Context context, String str, LoginFilterCallback loginFilterCallback) {
        LoginPostHandler.openPostPage(context, str, loginFilterCallback);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void navToWebViewPage(String str, UrlParam urlParam) {
        if (DataProviderFactory.getApplicationContext() != null) {
            Intent intent = new Intent(DataProviderFactory.getApplicationContext(), WebViewActivity.class);
            addData(urlParam, intent);
            intent.putExtra("eventName", str);
            intent.addFlags(268435456);
            DataProviderFactory.getApplicationContext().startActivity(intent);
            return;
        }
        EventBus.getDefault().sendEvent(str);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    @SuppressLint({"StaticFieldLeak"})
    public void openLoginPage(final Context context, final String str, final Bundle bundle) {
        try {
            new CoordinatorWrapper().execute(new AsyncTask<Object, Void, LoginHistory>() {
                /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public LoginHistory doInBackground(Object... objArr) {
                    try {
                        LoginTLogAdapter.e(NavigatorServiceImpl.TAG, "login progress:get login history");
                        return SecurityGuardManagerWraper.getLoginHistory();
                    } catch (Exception unused) {
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(LoginHistory loginHistory) {
                    List<HistoryAccount> list;
                    boolean z;
                    LoginTLogAdapter.e(NavigatorServiceImpl.TAG, "login progress:onPostExecute");
                    boolean z2 = true;
                    if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                        try {
                            Class<?> cls = Class.forName("com.taobao.taobaocompat.lifecycle.AppForgroundObserver");
                            z = cls.getField("isForeground").getBoolean(cls);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (!z) {
                            Bundle bundle = bundle;
                            boolean isProcessSupportLogin = bundle != null ? NavigatorServiceImpl.this.isProcessSupportLogin(context, bundle.getString("process_name")) : false;
                            if (DataProviderFactory.getDataProvider().isForbidLoginFromBackground() && !isProcessSupportLogin) {
                                Intent intent = new Intent();
                                intent.setAction("NOTIFY_LOGIN_FAILED");
                                intent.setPackage(DataProviderFactory.getApplicationContext().getPackageName());
                                DataProviderFactory.getApplicationContext().sendBroadcast(intent);
                                return;
                            }
                        }
                    }
                    Bundle bundle2 = bundle;
                    if (bundle2 != null && (TextUtils.equals(bundle2.getString(LoginType.LocalLoginType.SMS_LOGIN), "true") || bundle.getBoolean(LoginConstant.LAUCNH_MOBILE_LOGIN_FRAGMENT_LABEL, false))) {
                        bundle.putString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE, UIBaseConstants.LoginPage.PAGE_SMS_LOGIN);
                    }
                    Bundle bundle3 = bundle;
                    boolean z3 = bundle3 != null && bundle3.getBoolean(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, false);
                    Bundle bundle4 = bundle;
                    if (bundle4 != null && bundle4.getBoolean(LoginConstant.LAUCNH_USER_LOGIN_FRAGMENT_LABEL, false)) {
                        bundle.putString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE, UIBaseConstants.LoginPage.PAGE_PWD_LOGIN);
                    }
                    if (!DataProviderFactory.getDataProvider().isTaobaoApp() || loginHistory == null || (list = loginHistory.accountHistory) == null || list.size() <= 0) {
                        z2 = z3;
                    }
                    Bundle bundle5 = bundle;
                    LoginParam loginParam = null;
                    String string = bundle5 != null ? bundle5.getString(LoginConstant.LOGINPARAM) : null;
                    if (!TextUtils.isEmpty(string)) {
                        loginParam = (LoginParam) JSON.parseObject(string, LoginParam.class);
                    }
                    if (loginParam == null) {
                        loginParam = new LoginParam();
                    }
                    Bundle bundle6 = bundle;
                    String str = "";
                    loginParam.source = bundle6 != null ? bundle6.getString("source") : str;
                    Bundle bundle7 = bundle;
                    if (bundle7 != null) {
                        str = bundle7.getString("loginUIType");
                    }
                    LoginContext.mFrom = loginParam.source;
                    LoginContext.loginUIType = str;
                    if (!TextUtils.isEmpty(str)) {
                        HashMap hashMap = new HashMap();
                        loginParam.externParams = hashMap;
                        hashMap.put("apiReferer", str);
                    }
                    NavigatorManager.getInstance().navToLoginPage(context, bundle, JSON.toJSONString(loginParam), z2);
                }
            }, new Object[0]);
        } catch (Exception e) {
            try {
                Intent intent = new Intent();
                intent.setAction("NOTIFY_LOGIN_FAILED");
                intent.setPackage(DataProviderFactory.getApplicationContext().getPackageName());
                DataProviderFactory.getApplicationContext().sendBroadcast(intent);
            } catch (Exception unused) {
            }
            e.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void openRegWebViewPage(Context context, String str, String str2, LoginParam loginParam) {
        NavigatorManager.getInstance().navToRegWebViewPage(context, str, str2, "", loginParam);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void openRegisterPage(final Context context, final RegistParam registParam) {
        int i = registParam.registSite;
        if (i == 6) {
            fetchRegisterUrl(context, registParam);
        } else if (i == 3 && DataProviderFactory.getDataProvider().needEnterPriseRegister()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, 16973939));
            View inflate = LayoutInflater.from(context).inflate(R.layout.aliuser_cbu_register_dialog, (ViewGroup) null);
            final AlertDialog create = builder.setView(inflate).create();
            Window window = create.getWindow();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            window.setAttributes(layoutParams);
            window.setGravity(80);
            create.show();
            inflate.findViewById(R.id.aliuser_register_enterprise).setOnClickListener(new View.OnClickListener() {
                /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass2 */

                public void onClick(View view) {
                    RegistParam registParam = registParam;
                    registParam.regFrom = "CBU_ENTERPRISE";
                    NavigatorServiceImpl.this.fetchRegisterUrl(context, registParam);
                    create.dismiss();
                }
            });
            inflate.findViewById(R.id.aliuser_register_person).setOnClickListener(new View.OnClickListener() {
                /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass3 */

                public void onClick(View view) {
                    NavigatorManager.getInstance().navToRegisterPage(context, registParam);
                    create.dismiss();
                }
            });
            inflate.findViewById(R.id.aliuser_register_cancel).setOnClickListener(new View.OnClickListener() {
                /* class com.ali.user.mobile.navigation.NavigatorServiceImpl.AnonymousClass4 */

                public void onClick(View view) {
                    create.dismiss();
                }
            });
        } else if (RegType.H5_REG.equals(DataProviderFactory.getDataProvider().getRegType())) {
            fetchRegisterUrl(context, registParam);
        } else {
            NavigatorManager.getInstance().navToRegisterPage(context, registParam);
        }
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void openWebViewPage(Context context, UrlParam urlParam) {
        Intent intent = new Intent(context, WebViewActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        addData(urlParam, intent);
        context.startActivity(intent);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void startWebViewForResult(Activity activity, UrlParam urlParam) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        addData(urlParam, intent);
        activity.startActivityForResult(intent, urlParam.requestCode);
    }

    @Override // com.ali.user.mobile.service.NavigatorService
    public void openRegWebViewPage(String str, String str2, String str3, LoginParam loginParam) {
        if (DataProviderFactory.getApplicationContext() != null) {
            Intent callingIntent = AliUserRegisterWebviewActivity.getCallingIntent(DataProviderFactory.getApplicationContext(), str, str3, loginParam);
            callingIntent.putExtra("eventName", str2);
            callingIntent.addFlags(268435456);
            DataProviderFactory.getApplicationContext().startActivity(callingIntent);
            return;
        }
        EventBus.getDefault().sendEvent(str2);
    }
}
