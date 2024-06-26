package cn.damai.pay.alipay;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ou2;

/* compiled from: Taobao */
public class AlixDemo extends Activity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static String TAG = "AppDemo4";
    private ProgressDialog mProgress = null;

    /* compiled from: Taobao */
    public static class AlixOnCancelListener implements DialogInterface.OnCancelListener {
        private static transient /* synthetic */ IpChange $ipChange;
        Activity mcontext;

        AlixOnCancelListener(Activity activity) {
            this.mcontext = activity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1009740631")) {
                ipChange.ipc$dispatch("1009740631", new Object[]{this, dialogInterface});
                return;
            }
            this.mcontext.onKeyDown(4, null);
        }
    }

    /* access modifiers changed from: package-private */
    public void closeProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141675152")) {
            ipChange.ipc$dispatch("-2141675152", new Object[]{this});
            return;
        }
        try {
            ProgressDialog progressDialog = this.mProgress;
            if (progressDialog != null) {
                progressDialog.dismiss();
                this.mProgress = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436772070")) {
            ipChange.ipc$dispatch("-1436772070", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        ou2.d(TAG, "onCreate");
        new MobileSecurePayHelper(this).detectMobile_sp();
    }

    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135311654")) {
            ipChange.ipc$dispatch("-1135311654", new Object[]{this});
            return;
        }
        super.onDestroy();
        ou2.d(TAG, "onDestroy");
        try {
            ProgressDialog progressDialog = this.mProgress;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245330128")) {
            return ((Boolean) ipChange.ipc$dispatch("-1245330128", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        } else if (i != 4) {
            return false;
        } else {
            BaseHelper.log(TAG, "onKeyDown back");
            finish();
            return true;
        }
    }
}
