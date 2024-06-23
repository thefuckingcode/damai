package com.ali.user.open.core.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.ali.user.open.core.R;
import com.ali.user.open.core.webview.AUProgressDialog;

/* compiled from: Taobao */
public class DialogHelper {
    private static volatile DialogHelper instance;
    private AlertDialog mAlertDialog;
    private AlertDialog mProgressDialog;

    public static DialogHelper getInstance() {
        if (instance == null) {
            synchronized (DialogHelper.class) {
                if (instance == null) {
                    instance = new DialogHelper();
                }
            }
        }
        return instance;
    }

    public void alert(final Activity activity, final String str, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2) {
        if (activity != null) {
            dismissAlertDialog(activity);
            activity.runOnUiThread(new Runnable() {
                /* class com.ali.user.open.core.util.DialogHelper.AnonymousClass1 */

                public void run() {
                    Activity activity = activity;
                    if (activity != null && !activity.isFinishing()) {
                        int i = 16973939;
                        if (Build.VERSION.SDK_INT >= 21) {
                            i = 16974393;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, i));
                        if (!TextUtils.isEmpty(str)) {
                            builder.setTitle(str);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            builder.setMessage(str2);
                        } else {
                            builder.setMessage(activity.getString(R.string.member_sdk_network_not_available_message));
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            builder.setPositiveButton(str3, onClickListener);
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            builder.setNegativeButton(str4, onClickListener2);
                        }
                        builder.setCancelable(false);
                        try {
                            DialogHelper.this.mAlertDialog = builder.show();
                            DialogHelper.this.mAlertDialog.getButton(-1).setTextColor(activity.getResources().getColor(17170444));
                            DialogHelper.this.mAlertDialog.getButton(-2).setTextColor(activity.getResources().getColor(17170444));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void dismissAlertDialog(Activity activity) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            activity.runOnUiThread(new Runnable() {
                /* class com.ali.user.open.core.util.DialogHelper.AnonymousClass2 */

                public void run() {
                    if (DialogHelper.this.mAlertDialog != null && DialogHelper.this.mAlertDialog.isShowing()) {
                        try {
                            DialogHelper.this.mAlertDialog.dismiss();
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            DialogHelper.this.mAlertDialog = null;
                            throw th;
                        }
                        DialogHelper.this.mAlertDialog = null;
                    }
                }
            });
        }
    }

    public void dismissProgressDialog(Activity activity) {
        AlertDialog alertDialog = this.mProgressDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            activity.runOnUiThread(new Runnable() {
                /* class com.ali.user.open.core.util.DialogHelper.AnonymousClass4 */

                /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
                /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                    com.ali.user.open.core.trace.SDKLogger.w(com.ali.user.open.core.webview.BaseWebViewActivity.TAG, "dismissProgressDialog");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
                    r3.this$0.mProgressDialog = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
                    throw r1;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0026 */
                public void run() {
                    if (DialogHelper.this.mProgressDialog != null && DialogHelper.this.mProgressDialog.isShowing()) {
                        DialogHelper.this.mProgressDialog.dismiss();
                        DialogHelper.this.mProgressDialog = null;
                    }
                }
            });
        }
    }

    public void showProgressDialog(final Activity activity, final String str, final boolean z, final DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialog = this.mProgressDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            activity.runOnUiThread(new Runnable() {
                /* class com.ali.user.open.core.util.DialogHelper.AnonymousClass3 */

                public void run() {
                    Activity activity = activity;
                    if (activity != null && !activity.isFinishing()) {
                        DialogHelper.this.mProgressDialog = new AUProgressDialog(activity);
                        DialogHelper.this.mProgressDialog.setMessage(str);
                        ((AUProgressDialog) DialogHelper.this.mProgressDialog).setProgressVisiable(true);
                        DialogHelper.this.mProgressDialog.setCancelable(z);
                        DialogHelper.this.mProgressDialog.setOnCancelListener(onCancelListener);
                        try {
                            DialogHelper.this.mProgressDialog.show();
                        } catch (Exception unused) {
                        }
                        DialogHelper.this.mProgressDialog.setCanceledOnTouchOutside(false);
                    }
                }
            });
        }
    }
}
