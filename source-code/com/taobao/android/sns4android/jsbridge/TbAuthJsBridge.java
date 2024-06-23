package com.taobao.android.sns4android.jsbridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;

/* compiled from: Taobao */
public class TbAuthJsBridge extends WVApiPlugin {
    private BroadcastReceiver mLoginReceiver;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            a[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            a[LoginAction.NOTIFY_REGISTER_CANCEL.ordinal()] = 3;
            try {
                a[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWhenReceiveSuccess(WVCallBackContext wVCallBackContext) {
        setSuccessCallback(wVCallBackContext);
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            this.mLoginReceiver = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doWhenReceivedCancel(WVCallBackContext wVCallBackContext, String str, String str2) {
        setErrorCallback(wVCallBackContext, str, str2);
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            this.mLoginReceiver = null;
        }
    }

    private void registerBroadcast(final WVCallBackContext wVCallBackContext) {
        this.mLoginReceiver = new BroadcastReceiver() {
            /* class com.taobao.android.sns4android.jsbridge.TbAuthJsBridge.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                LoginAction valueOf;
                if (intent != null && (valueOf = LoginAction.valueOf(intent.getAction())) != null) {
                    int i = a.a[valueOf.ordinal()];
                    if (i == 1) {
                        TbAuthJsBridge.this.doWhenReceiveSuccess(wVCallBackContext);
                    } else if (i == 2 || i == 3 || i == 4) {
                        TbAuthJsBridge.this.doWhenReceivedCancel(wVCallBackContext, intent.getStringExtra("errorCode"), intent.getStringExtra("message"));
                    }
                }
            }
        };
        LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
    }

    private void setErrorCallback(WVCallBackContext wVCallBackContext, String str, String str2) {
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            try {
                if (Integer.parseInt(str) < 10000) {
                    str = "1107";
                }
            } catch (Throwable unused) {
            }
            wVResult.addData("code", str);
            wVResult.addData("message", str2);
            wVCallBackContext.error(wVResult);
        }
    }

    private void setSuccessCallback(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVCallBackContext.success(wVResult);
        }
    }

    private void tbAuthLogin(String str, WVCallBackContext wVCallBackContext) {
        SNSPlatform sNSPlatform = SNSPlatform.PLATFORM_TAOBAO;
        SNSAuth.init(sNSPlatform, "", "");
        registerBroadcast(wVCallBackContext);
        SNSAuth.uccOAuthLogin((Activity) this.mContext, sNSPlatform);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("tbAuthLogin".equals(str)) {
            tbAuthLogin(str2, wVCallBackContext);
            return true;
        }
        wVCallBackContext.error();
        return false;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
        }
        super.onDestroy();
    }
}
