package com.taobao.login4android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;

/* compiled from: Taobao */
public class LoginBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "login.LoginBroadcastReceiver";

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
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
            a[LoginAction.NOTIFY_RESET_STATUS.ordinal()] = 4;
            a[LoginAction.NOTIFY_USER_LOGIN.ordinal()] = 5;
            try {
                a[LoginAction.NOTIFY_LOGOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                LoginAction valueOf = LoginAction.valueOf(intent.getAction());
                if (valueOf != null) {
                    switch (a.a[valueOf.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            LoginStatus.resetLoginFlag();
                            return;
                        case 5:
                            LoginStatus.setUserLogin(true);
                            return;
                        case 6:
                            if (!TextUtils.equals(intent.getStringExtra(LoginConstants.LOGOUT_TYPE), LoginConstants.LogoutType.CHANGE_ACCOUNT.getType())) {
                                LoginStatus.resetLoginFlag();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
