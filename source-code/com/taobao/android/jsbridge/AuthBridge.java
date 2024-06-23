package com.taobao.android.jsbridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.taobao.android.sso.R;
import com.taobao.android.sso.v2.launch.SsoLogin;
import com.taobao.android.sso.v2.result.ResultActivity;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;

/* compiled from: Taobao */
public class AuthBridge extends WVApiPlugin {
    private static final String APDIDTOKEN_IS_NULL = "1005";
    private static final String CONTEXT_IS_NOT_ACTIVITY = "1004";
    private static final String GET_ALIPAY_TOKEN_FAIL = "1003";
    private BroadcastReceiver mAlipaySsoTokenReceiver;
    private BroadcastReceiver mLoginReceiver;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements DataCallback<String> {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        /* renamed from: a */
        public void result(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SsoLogin.launchAlipay(this.a, DataProviderFactory.getDataProvider().getAlipaySsoDesKey(), str, DataProviderFactory.getDataProvider().getContext().getPackageName(), DataProviderFactory.getDataProvider().getResultActivityPath());
                } catch (Throwable th) {
                    th.printStackTrace();
                    AuthBridge.toast();
                }
            } else {
                AuthBridge.toast();
            }
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            a[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            a[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            a[LoginAction.NOTIFY_ALIPAY_SSO_FAIL.ordinal()] = 4;
            a[LoginAction.NOTIFY_ALIPAY_SSO_CANCEL.ordinal()] = 5;
        }
    }

    private synchronized void alipay(WVCallBackContext wVCallBackContext) {
        if (this.mContext instanceof Activity) {
            registerBroadcast(wVCallBackContext);
            alipayAuth((Activity) this.mContext);
        } else {
            wVCallBackContext.error();
        }
    }

    public static void alipayAuth(Activity activity) {
        AlipayInfo.getInstance().getApdidToken(new a(activity));
    }

    private synchronized void checkIfExist(WVCallBackContext wVCallBackContext) {
        if (SsoLogin.isSupportAliaySso()) {
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
    }

    private synchronized void checkIfTaobaoExist(WVCallBackContext wVCallBackContext) {
        try {
            if (SsoLogin.isSupportTBAuthBind(this.mContext)) {
                wVCallBackContext.success();
            } else {
                wVCallBackContext.error();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            wVCallBackContext.error();
        }
        return;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWhenReceiveSuccess(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
        unregisterLoginReceiver();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWhenReceivedCancel(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            wVCallBackContext.error();
        }
        unregisterLoginReceiver();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fail(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("code", str);
            wVCallBackContext.error(wVResult);
        }
    }

    private synchronized void getAlipaySsoToken(String str, final WVCallBackContext wVCallBackContext) {
        final Context context = wVCallBackContext.getWebview().getContext();
        if (context instanceof Activity) {
            AlipayInfo.getInstance().getApdidToken(new DataCallback<String>() {
                /* class com.taobao.android.jsbridge.AuthBridge.AnonymousClass3 */

                /* renamed from: a */
                public void result(final String str) {
                    if (!TextUtils.isEmpty(str)) {
                        BackgroundExecutor.execute(new Runnable() {
                            /* class com.taobao.android.jsbridge.AuthBridge.AnonymousClass3.AnonymousClass1 */

                            public void run() {
                                final boolean z;
                                TLogAdapter.e("jsbridge", "start launch alipay");
                                try {
                                    SsoLogin.getAlipaySsoToken((Activity) context, DataProviderFactory.getDataProvider().getAlipaySsoDesKey(), str, DataProviderFactory.getDataProvider().getContext().getPackageName(), ResultActivity.class.getName());
                                    z = true;
                                } catch (Exception e) {
                                    TLogAdapter.e("jsbridge", "launch alipay fail" + e.getMessage());
                                    z = false;
                                }
                                MainThreadExecutor.execute(new Runnable() {
                                    /* class com.taobao.android.jsbridge.AuthBridge.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        TLogAdapter.e("jsbridge", "start launch alipay result" + z);
                                        boolean z = z;
                                        if (z) {
                                            IntentFilter intentFilter = new IntentFilter();
                                            intentFilter.addAction("alipay_sso_token");
                                            AuthBridge.this.mAlipaySsoTokenReceiver = new BroadcastReceiver() {
                                                /* class com.taobao.android.jsbridge.AuthBridge.AnonymousClass3.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public void onReceive(Context context, Intent intent) {
                                                    if (!(intent == null || wVCallBackContext == null)) {
                                                        if (intent.getBooleanExtra("result", false)) {
                                                            WVResult wVResult = new WVResult();
                                                            wVResult.addData("ssoToken", intent.getStringExtra("ssoToken"));
                                                            wVResult.addData("desKey", intent.getStringExtra("desKey"));
                                                            wVResult.addData("uuid", intent.getStringExtra("uuid"));
                                                            wVCallBackContext.success(wVResult);
                                                        } else {
                                                            AnonymousClass3 r3 = AnonymousClass3.this;
                                                            AuthBridge.this.fail(wVCallBackContext, intent.getStringExtra("errorCode"));
                                                        }
                                                    }
                                                    LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(AuthBridge.this.mAlipaySsoTokenReceiver);
                                                }
                                            };
                                            LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(AuthBridge.this.mAlipaySsoTokenReceiver, intentFilter);
                                        } else if (!z) {
                                            AnonymousClass3 r0 = AnonymousClass3.this;
                                            AuthBridge.this.fail(wVCallBackContext, "1003");
                                        }
                                    }
                                });
                            }
                        });
                    } else {
                        AuthBridge.this.fail(wVCallBackContext, "1005");
                    }
                }
            });
        } else {
            fail(wVCallBackContext, "1004");
        }
    }

    private void registerBroadcast(final WVCallBackContext wVCallBackContext) {
        this.mLoginReceiver = new BroadcastReceiver() {
            /* class com.taobao.android.jsbridge.AuthBridge.AnonymousClass2 */

            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    LoginAction loginAction = null;
                    try {
                        loginAction = LoginAction.valueOf(action);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    if (loginAction != null) {
                        int i = b.a[loginAction.ordinal()];
                        if (i == 1) {
                            AuthBridge.this.doWhenReceiveSuccess(wVCallBackContext);
                        } else if (i == 2) {
                            AuthBridge.this.doWhenReceivedCancel(wVCallBackContext);
                        } else if (i == 3 || i == 4 || i == 5) {
                            AuthBridge.this.doWhenReceivedCancel(wVCallBackContext);
                        }
                    }
                }
            }
        };
        LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
    }

    private synchronized void taobao(WVCallBackContext wVCallBackContext) {
        if (this.mContext instanceof Activity) {
            registerBroadcast(wVCallBackContext);
            SsoLogin.launchTao((Activity) this.mContext, SsoLogin.getSsoRemoteParam(), DataProviderFactory.getDataProvider().getResultActivityPath());
        } else {
            wVCallBackContext.error();
        }
    }

    /* access modifiers changed from: private */
    public static void toast() {
        try {
            Toast.makeText(DataProviderFactory.getApplicationContext(), DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0).show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void unregisterLoginReceiver() {
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("bridgeAlipaySSOLogin".equals(str)) {
            UserTrackAdapter.sendUT("bridgeAlipaySSOLogin");
            alipay(wVCallBackContext);
            return true;
        } else if ("bridgeAlipaySupported".equals(str)) {
            checkIfExist(wVCallBackContext);
            UserTrackAdapter.sendUT("bridgeAlipaySupported");
            return true;
        } else if ("bridgeTaobaoSSOLogin".equals(str)) {
            taobao(wVCallBackContext);
            UserTrackAdapter.sendUT("bridgeTaobaoSSOLogin");
            return true;
        } else if ("bridgeTaobaoSupported".equals(str)) {
            checkIfTaobaoExist(wVCallBackContext);
            UserTrackAdapter.sendUT("bridgeTaobaoSupported");
            return true;
        } else if (!"getAlipaySsoToken".equals(str)) {
            return false;
        } else {
            getAlipaySsoToken(str2, wVCallBackContext);
            return true;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        super.onDestroy();
        unregisterLoginReceiver();
    }
}
