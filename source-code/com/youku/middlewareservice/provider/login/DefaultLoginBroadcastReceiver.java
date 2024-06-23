package com.youku.middlewareservice.provider.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.login4android.broadcast.LoginAction;

/* compiled from: Taobao */
public class DefaultLoginBroadcastReceiver extends BroadcastReceiver {
    private final ILoginCallBack callBack;

    /* renamed from: com.youku.middlewareservice.provider.login.DefaultLoginBroadcastReceiver$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$login4android$broadcast$LoginAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[LoginAction.values().length];
            $SwitchMap$com$taobao$login4android$broadcast$LoginAction = iArr;
            iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            try {
                $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public DefaultLoginBroadcastReceiver(ILoginCallBack iLoginCallBack) {
        this.callBack = iLoginCallBack;
    }

    public void onReceive(Context context, Intent intent) {
        LoginAction valueOf;
        ILoginCallBack iLoginCallBack;
        if (intent != null && (valueOf = LoginAction.valueOf(intent.getAction())) != null) {
            int i = AnonymousClass1.$SwitchMap$com$taobao$login4android$broadcast$LoginAction[valueOf.ordinal()];
            if (i == 1) {
                ILoginCallBack iLoginCallBack2 = this.callBack;
                if (iLoginCallBack2 != null) {
                    iLoginCallBack2.onSuccess();
                }
            } else if (i == 2) {
                ILoginCallBack iLoginCallBack3 = this.callBack;
                if (iLoginCallBack3 != null) {
                    iLoginCallBack3.onCancel();
                }
            } else if (i == 3) {
                ILoginCallBack iLoginCallBack4 = this.callBack;
                if (iLoginCallBack4 != null) {
                    iLoginCallBack4.onFailed();
                }
            } else if (i == 4 && (iLoginCallBack = this.callBack) != null) {
                iLoginCallBack.onLogout();
            }
        }
    }
}
