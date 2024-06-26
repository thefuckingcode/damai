package com.ali.user.mobile.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.ali.user.mobile.R;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.ui.widget.AUProgressDialog;
import com.ali.user.mobile.ui.widget.AliUserDialog;

/* compiled from: Taobao */
public class DialogHelper {
    protected static final String TAG = "login.DialogHelper";
    private Activity mActivity;
    private AlertDialog mAlertDialog;
    private AlertDialog mProgressDialog;
    private Toast mToast;
    private AliUserDialog mUserAlertDialog;

    public DialogHelper(Activity activity) {
        this.mActivity = activity;
    }

    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        alert(str, str2, str3, onClickListener, str4, onClickListener2, Boolean.FALSE, (DialogInterface.OnCancelListener) null);
    }

    public void alertList(final String[] strArr, final DialogInterface.OnClickListener onClickListener, final boolean z) {
        dismissAlertDialog();
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass3 */

            public void run() {
                if (DialogHelper.this.mActivity != null && !DialogHelper.this.mActivity.isFinishing()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(DialogHelper.this.mActivity, 16973939));
                    builder.setItems(strArr, onClickListener);
                    DialogHelper.this.mAlertDialog = builder.show();
                    DialogHelper.this.mAlertDialog.setCanceledOnTouchOutside(z);
                    DialogHelper.this.mAlertDialog.setCancelable(z);
                }
            }
        });
    }

    public void dismissAlertDialog() {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            AlertDialog alertDialog = this.mAlertDialog;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.mActivity.runOnUiThread(new Runnable() {
                    /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass7 */

                    public void run() {
                        if (DialogHelper.this.mAlertDialog != null && DialogHelper.this.mAlertDialog.isShowing()) {
                            try {
                                DialogHelper.this.mAlertDialog.dismiss();
                            } catch (Exception e) {
                                TLogAdapter.w(DialogHelper.TAG, "dismissProgressDialog", e);
                            } catch (Throwable th) {
                                DialogHelper.this.mAlertDialog = null;
                                throw th;
                            }
                            DialogHelper.this.mAlertDialog = null;
                        }
                    }
                });
            }
            AliUserDialog aliUserDialog = this.mUserAlertDialog;
            if (aliUserDialog != null && aliUserDialog.isShowing()) {
                this.mActivity.runOnUiThread(new Runnable() {
                    /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass8 */

                    public void run() {
                        if (DialogHelper.this.mUserAlertDialog != null && DialogHelper.this.mUserAlertDialog.isShowing()) {
                            try {
                                DialogHelper.this.mUserAlertDialog.dismiss();
                            } catch (Throwable th) {
                                DialogHelper.this.mUserAlertDialog = null;
                                throw th;
                            }
                            DialogHelper.this.mUserAlertDialog = null;
                        }
                    }
                });
            }
        }
    }

    public void dismissProgressDialog() {
        AlertDialog alertDialog = this.mProgressDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mActivity.runOnUiThread(new Runnable() {
                /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass6 */

                public void run() {
                    if (DialogHelper.this.mProgressDialog != null && DialogHelper.this.mProgressDialog.isShowing()) {
                        try {
                            DialogHelper.this.mProgressDialog.dismiss();
                        } catch (Exception e) {
                            TLogAdapter.w(DialogHelper.TAG, "dismissProgressDialog", e);
                        } catch (Throwable th) {
                            DialogHelper.this.mProgressDialog = null;
                            throw th;
                        }
                        DialogHelper.this.mProgressDialog = null;
                    }
                }
            });
        }
    }

    public void hideInputMethod() {
        Activity activity = this.mActivity;
        if (activity != null && activity.getCurrentFocus() != null) {
            ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void showProgressDialog(boolean z, String str) {
        showProgressDialog(str, true, null, z);
    }

    public void toast(final String str, final int i) {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            this.mActivity.runOnUiThread(new Runnable() {
                /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass4 */

                public void run() {
                    try {
                        DialogHelper.this.mToast = new Toast(DialogHelper.this.mActivity);
                        View inflate = LayoutInflater.from(DialogHelper.this.mActivity.getApplicationContext()).inflate(R.layout.aliuser_transient_notification, (ViewGroup) null);
                        ((TextView) inflate.findViewById(16908299)).setText(str);
                        DialogHelper.this.mToast.setView(inflate);
                        DialogHelper.this.mToast.setDuration(i);
                        DialogHelper.this.mToast.setGravity(17, 0, 0);
                        DialogHelper.this.mToast.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void alert(final String str, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2, Boolean bool, DialogInterface.OnCancelListener onCancelListener) {
        dismissAlertDialog();
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass1 */

            public void run() {
                if (DialogHelper.this.mActivity != null && !DialogHelper.this.mActivity.isFinishing()) {
                    AliUserDialog.Builder Builder = AliUserDialog.Builder(DialogHelper.this.mActivity);
                    if (!TextUtils.isEmpty(str)) {
                        Builder.setTitle(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        Builder.setMessage(str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        Builder.setOnPositiveClickListener(str3, new AliUserDialog.PositiveClickListener() {
                            /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass1.AnonymousClass1 */

                            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
                            public void onClick(View view) {
                                try {
                                    if (DialogHelper.this.mUserAlertDialog != null) {
                                        DialogHelper.this.mUserAlertDialog.dismiss();
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                DialogInterface.OnClickListener onClickListener = onClickListener;
                                if (onClickListener != null) {
                                    onClickListener.onClick(null, 0);
                                }
                            }
                        });
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        Builder.setOnNegativeClickListener(str4, new AliUserDialog.NegativeClickListener() {
                            /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass1.AnonymousClass2 */

                            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.NegativeClickListener
                            public void onClick(View view) {
                                try {
                                    if (DialogHelper.this.mUserAlertDialog != null) {
                                        DialogHelper.this.mUserAlertDialog.dismiss();
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                DialogInterface.OnClickListener onClickListener = onClickListener2;
                                if (onClickListener != null) {
                                    onClickListener.onClick(null, 0);
                                }
                            }
                        });
                    }
                    try {
                        DialogHelper.this.mUserAlertDialog = Builder.build().shown();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        });
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, true, null, true);
    }

    public void showProgressDialog(final String str, final boolean z, final DialogInterface.OnCancelListener onCancelListener, final boolean z2) {
        AlertDialog alertDialog = this.mProgressDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.mActivity.runOnUiThread(new Runnable() {
                /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass5 */

                public void run() {
                    if (DialogHelper.this.mActivity != null && !DialogHelper.this.mActivity.isFinishing()) {
                        DialogHelper.this.mProgressDialog = new AUProgressDialog(DialogHelper.this.mActivity);
                        DialogHelper.this.mProgressDialog.setMessage(str);
                        ((AUProgressDialog) DialogHelper.this.mProgressDialog).setProgressVisiable(z2);
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

    public void alert(final String str, final View view, final String str2, final DialogInterface.OnClickListener onClickListener, final String str3, final DialogInterface.OnClickListener onClickListener2, final Boolean bool, final DialogInterface.OnCancelListener onCancelListener) {
        dismissAlertDialog();
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.ali.user.mobile.helper.DialogHelper.AnonymousClass2 */

            public void run() {
                if (DialogHelper.this.mActivity != null && !DialogHelper.this.mActivity.isFinishing()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(DialogHelper.this.mActivity, 16973939));
                    if (!TextUtils.isEmpty(str)) {
                        builder.setTitle(str);
                    }
                    View view = view;
                    if (view != null) {
                        builder.setView(view);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        builder.setPositiveButton(str2, onClickListener);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        builder.setNegativeButton(str3, onClickListener2);
                    }
                    try {
                        DialogHelper.this.mAlertDialog = builder.show();
                        DialogHelper.this.mAlertDialog.setCanceledOnTouchOutside(bool.booleanValue());
                        DialogHelper.this.mAlertDialog.setCancelable(bool.booleanValue());
                        DialogHelper.this.mAlertDialog.setOnCancelListener(onCancelListener);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
