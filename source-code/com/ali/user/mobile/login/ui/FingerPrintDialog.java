package com.ali.user.mobile.login.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.callback.FingerCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.FingerprintLoginServiceImpl;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.verify.VerifyApi;
import java.util.HashMap;

/* compiled from: Taobao */
public class FingerPrintDialog extends DialogFragment {
    public static final int ERROR_CANCEL = 4002;
    public static final int ERROR_EXCEPTION = 4001;
    public static final int ERROR_OTHER = 4023;
    public static final int STATUS_IV = 3;
    public static final int STATUS_LOGIN = 1;
    public static final int STATUS_SET = 2;
    public String TAG = "login.finger";
    protected TextView mCancelButton;
    public CommonCallback mCommonCallback;
    protected TextView mMessage;
    protected TextView mOKButton;
    protected View mSplitLine;
    protected int status = 2;
    protected boolean transparent = false;

    public FingerPrintDialog(CommonCallback commonCallback) {
        this.mCommonCallback = commonCallback;
    }

    /* access modifiers changed from: protected */
    public void afterAuthenticatedSucceed() {
        close();
        CommonCallback commonCallback = this.mCommonCallback;
        if (commonCallback != null) {
            commonCallback.onSuccess();
        }
    }

    /* access modifiers changed from: protected */
    public void changeStatus(int i) {
        this.status = i;
        if (i == 1) {
            startListen();
            this.mCancelButton.setText(R.string.aliuser_confirm_cancel);
            this.mMessage.setText(getActivity().getString(R.string.aliuser_fingerprint_login_tips));
            this.mSplitLine.setVisibility(8);
            this.mOKButton.setVisibility(8);
        } else if (i == 2) {
            startListen();
            this.mCancelButton.setText(R.string.aliuser_confirm_cancel);
            this.mMessage.setText(R.string.aliuser_fingerprint_check);
            this.mSplitLine.setVisibility(8);
            this.mOKButton.setVisibility(8);
        } else if (i == 3) {
            startListen();
            this.mCancelButton.setText(R.string.aliuser_confirm_cancel);
            this.mMessage.setText(getActivity().getString(R.string.ali_fingerprint_iv));
            this.mSplitLine.setVisibility(8);
            this.mOKButton.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void close() {
        try {
            dismissAllowingStateLoss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: protected */
    public int getLayoutContent() {
        return R.layout.aliuser_fragment_fingerprint_dialog;
    }

    public String getPageName() {
        return "";
    }

    public String getPageSpm() {
        return "";
    }

    @Override // androidx.fragment.app.DialogFragment
    public void onCancel(DialogInterface dialogInterface) {
        onCancelClick();
    }

    /* access modifiers changed from: protected */
    public void onCancelClick() {
        CommonCallback commonCallback = this.mCommonCallback;
        if (commonCallback != null) {
            commonCallback.onFail(4002, "指纹验证取消");
        }
        close();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        try {
            View inflate = layoutInflater.inflate(getLayoutContent(), viewGroup);
            this.mSplitLine = inflate.findViewById(R.id.passport_button_split_line);
            this.mOKButton = (TextView) inflate.findViewById(R.id.passport_button_ok);
            this.mCancelButton = (TextView) inflate.findViewById(R.id.passport_button_cancel);
            this.mMessage = (TextView) inflate.findViewById(R.id.passport_dialog_message);
            this.mCancelButton.setOnClickListener(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.FingerPrintDialog.AnonymousClass1 */

                public void onClick(View view) {
                    FingerPrintDialog.this.onCancelClick();
                }
            });
            this.mOKButton.setOnClickListener(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.FingerPrintDialog.AnonymousClass2 */

                public void onClick(View view) {
                    new HashMap().put("spm", "a2h21.12566855.1.2");
                    FingerPrintDialog.this.changeStatus(2);
                }
            });
            try {
                if (getArguments() != null) {
                    this.status = getArguments().getInt("status");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            changeStatus(this.status);
            return inflate;
        } catch (Throwable th2) {
            String str = this.TAG;
            TLogAdapter.e(str, getPageName() + " inflate layout error", th2);
            UserTrackAdapter.sendUT(getPageName(), "Inflate_Layout_Error", "ERROR", "", null);
            FingerprintLoginServiceImpl.getInstance().disableFingerprintLogin();
            CommonCallback commonCallback = this.mCommonCallback;
            if (commonCallback != null) {
                commonCallback.onFail(4001, "创建指纹识别框失败");
            }
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 17;
        getDialog().getWindow().setAttributes(attributes);
        if (this.transparent) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.aliuser_half_transparent_background)));
        }
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onStop() {
        if (this.transparent) {
            getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.aliuser_menu_out));
        }
        super.onStop();
        stopListen();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException unused) {
        }
    }

    public void showOther() {
        if (this.status == 3) {
            try {
                this.mSplitLine.setVisibility(0);
                this.mOKButton.setVisibility(0);
                this.mOKButton.setText(getActivity().getString(R.string.ali_fingerprint_other_iv));
                this.mOKButton.setOnClickListener(new View.OnClickListener() {
                    /* class com.ali.user.mobile.login.ui.FingerPrintDialog.AnonymousClass3 */

                    public void onClick(View view) {
                        FingerPrintDialog fingerPrintDialog = FingerPrintDialog.this;
                        CommonCallback commonCallback = fingerPrintDialog.mCommonCallback;
                        if (commonCallback != null) {
                            commonCallback.onFail(FingerPrintDialog.ERROR_OTHER, fingerPrintDialog.getActivity().getString(R.string.ali_fingerprint_other_iv));
                        }
                        FingerPrintDialog.this.close();
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @TargetApi(23)
    public void startListen() {
        new CoordinatorWrapper().execute(new Runnable() {
            /* class com.ali.user.mobile.login.ui.FingerPrintDialog.AnonymousClass4 */

            public void run() {
                try {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintStart", "startListen", String.valueOf(FingerPrintDialog.this.status), null);
                    ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).authenticate(new FingerCallback() {
                        /* class com.ali.user.mobile.login.ui.FingerPrintDialog.AnonymousClass4.AnonymousClass1 */

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationError(int i, CharSequence charSequence) {
                            FingerPrintDialog.this.showOther();
                            if (5 == i || i >= 7) {
                                if (7 == i) {
                                    FingerPrintDialog.this.mMessage.setText(R.string.aliuser_fingerprint_try_later);
                                } else if (100 == i) {
                                    FingerPrintDialog fingerPrintDialog = FingerPrintDialog.this;
                                    int i2 = fingerPrintDialog.status;
                                    if (i2 == 2) {
                                        fingerPrintDialog.mMessage.setText(R.string.aliuser_fingerprint_open_error);
                                    } else if (i2 == 1) {
                                        fingerPrintDialog.mMessage.setText(R.string.aliuser_finger_login_changed);
                                    } else {
                                        fingerPrintDialog.mMessage.setText(R.string.aliuser_finger_iv_changed);
                                    }
                                    VerifyApi.invalidAll();
                                }
                            } else if (charSequence != null) {
                                FingerPrintDialog.this.mMessage.setText(charSequence.toString());
                            }
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintFailed", "onAuthenticationError", String.valueOf(FingerPrintDialog.this.status), null);
                        }

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationFailed() {
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintFailed", "onAuthenticationFailed", String.valueOf(FingerPrintDialog.this.status), null);
                            FingerPrintDialog.this.mMessage.setText(R.string.aliuser_fingerprint_not_match);
                        }

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationHelp(int i, CharSequence charSequence) {
                            if (i < 1000 && !TextUtils.isEmpty(charSequence)) {
                                FingerPrintDialog.this.mMessage.setText(charSequence.toString());
                            }
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintFailed", "onAuthenticationHelp", String.valueOf(FingerPrintDialog.this.status), null);
                        }

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintSuccess", "onAuthenticationSucceeded", String.valueOf(FingerPrintDialog.this.status), null);
                            FingerPrintDialog.this.afterAuthenticatedSucceed();
                        }
                    });
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
                UserTrackAdapter.sendUT("FingerPrintException", th.getLocalizedMessage());
                TLogAdapter.e(FingerPrintDialog.this.TAG, th);
            }
        });
    }

    public void stopListen() {
        ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).cancelIdentify();
    }
}
