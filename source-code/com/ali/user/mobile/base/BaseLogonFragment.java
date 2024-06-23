package com.ali.user.mobile.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;

/* compiled from: Taobao */
public class BaseLogonFragment extends BaseFragment {
    private BroadcastReceiver mLoginReceiver;

    /* renamed from: com.ali.user.mobile.base.BaseLogonFragment$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$login4android$broadcast$LoginAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[LoginAction.values().length];
            $SwitchMap$com$taobao$login4android$broadcast$LoginAction = iArr;
            iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            try {
                $SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doWhenReceiveFail() {
    }

    /* access modifiers changed from: protected */
    public void doWhenReceiveSuccess() {
    }

    /* access modifiers changed from: protected */
    public void doWhenReceivedCancel() {
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLoginReceiver = new BroadcastReceiver() {
            /* class com.ali.user.mobile.base.BaseLogonFragment.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    int i = AnonymousClass2.$SwitchMap$com$taobao$login4android$broadcast$LoginAction[LoginAction.valueOf(intent.getAction()).ordinal()];
                    if (i == 1) {
                        BaseLogonFragment.this.doWhenReceiveSuccess();
                    } else if (i == 2) {
                        BaseLogonFragment.this.doWhenReceivedCancel();
                    } else if (i == 3) {
                        BaseLogonFragment.this.doWhenReceiveFail();
                    }
                }
            }
        };
        LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
        }
        super.onDestroy();
    }
}
