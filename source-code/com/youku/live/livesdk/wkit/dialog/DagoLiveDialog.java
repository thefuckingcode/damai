package com.youku.live.livesdk.wkit.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.live.livesdk.R;

/* compiled from: Taobao */
public class DagoLiveDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout contentView;
    private DialogConfig mDialogConfig;
    private TextView textContent;
    private TextView textTitle;

    /* compiled from: Taobao */
    public static class DialogConfig {
        public String cancelText = "取消";
        public String content = "";
        public View contentView = null;
        public boolean isShowCancelBtn = true;
        public String okText = "确定";
        public OnDialogButtonClickListener onCancelBtnClickListener;
        public OnDialogButtonClickListener onOkBtnClickListener;
        public String title = PurchaseConstants.NORMAL_WARNING_TITLE;
    }

    /* compiled from: Taobao */
    public interface OnDialogButtonClickListener {
        void onClick(View view);
    }

    public DagoLiveDialog(@NonNull Context context, DialogConfig dialogConfig) {
        super(context, R.style.lfcontainer_DialogStyleCommon);
        this.mDialogConfig = dialogConfig;
    }

    private void initView() {
        View view;
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136554408")) {
            ipChange.ipc$dispatch("1136554408", new Object[]{this});
            return;
        }
        setClipViewCornerRadius(findViewById(R.id.rootView), 30);
        this.textTitle = (TextView) findViewById(R.id.textTitle);
        this.textContent = (TextView) findViewById(R.id.textContent);
        TextView textView = this.textTitle;
        if (textView != null) {
            DialogConfig dialogConfig = this.mDialogConfig;
            if (dialogConfig == null || (str2 = dialogConfig.title) == null) {
                textView.setText("");
            } else {
                textView.setText(str2);
            }
        }
        TextView textView2 = this.textContent;
        if (textView2 != null) {
            DialogConfig dialogConfig2 = this.mDialogConfig;
            if (dialogConfig2 == null || (str = dialogConfig2.content) == null) {
                textView2.setText("");
            } else {
                textView2.setText(str);
            }
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.contentView);
        this.contentView = frameLayout;
        if (!(frameLayout == null || (view = this.mDialogConfig.contentView) == null)) {
            frameLayout.addView(view, -1, -1);
        }
        Button button = (Button) findViewById(R.id.btnCancel);
        if (button != null) {
            if (TextUtils.isEmpty(this.mDialogConfig.cancelText)) {
                button.setText("取消");
            } else {
                button.setText(this.mDialogConfig.cancelText);
            }
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.livesdk.wkit.dialog.DagoLiveDialog.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-114611940")) {
                        ipChange.ipc$dispatch("-114611940", new Object[]{this, view});
                        return;
                    }
                    if (DagoLiveDialog.this.mDialogConfig.onCancelBtnClickListener != null) {
                        DagoLiveDialog.this.mDialogConfig.onCancelBtnClickListener.onClick(view);
                    }
                    DagoLiveDialog.this.dismiss();
                }
            });
        }
        Button button2 = (Button) findViewById(R.id.btnSure);
        if (button2 != null) {
            if (TextUtils.isEmpty(this.mDialogConfig.okText)) {
                button2.setText("确定");
            } else {
                button2.setText(this.mDialogConfig.okText);
            }
            button2.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.livesdk.wkit.dialog.DagoLiveDialog.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1996678429")) {
                        ipChange.ipc$dispatch("1996678429", new Object[]{this, view});
                        return;
                    }
                    if (DagoLiveDialog.this.mDialogConfig.onOkBtnClickListener != null) {
                        DagoLiveDialog.this.mDialogConfig.onOkBtnClickListener.onClick(view);
                    }
                    DagoLiveDialog.this.dismiss();
                }
            });
        }
        View findViewById = findViewById(R.id.viewCenter);
        if (this.mDialogConfig.isShowCancelBtn) {
            if (button != null) {
                button.setVisibility(0);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
                return;
            }
            return;
        }
        if (button != null) {
            button.setVisibility(8);
        }
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    @TargetApi(21)
    public static void setClipViewCornerRadius(View view, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793559808")) {
            ipChange.ipc$dispatch("1793559808", new Object[]{view, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 21 && view != null && i > 0) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                /* class com.youku.live.livesdk.wkit.dialog.DagoLiveDialog.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void getOutline(View view, Outline outline) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "301520997")) {
                        ipChange.ipc$dispatch("301520997", new Object[]{this, view, outline});
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) i);
                }
            });
            view.setClipToOutline(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655758226")) {
            ipChange.ipc$dispatch("1655758226", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        setContentView(R.layout.dago_dialog_account_security);
        initView();
    }

    public void setOnCancelBtnClickListener(OnDialogButtonClickListener onDialogButtonClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924120976")) {
            ipChange.ipc$dispatch("1924120976", new Object[]{this, onDialogButtonClickListener});
            return;
        }
        this.mDialogConfig.onCancelBtnClickListener = onDialogButtonClickListener;
    }

    public void setOnOkBtnClickListener(OnDialogButtonClickListener onDialogButtonClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896363250")) {
            ipChange.ipc$dispatch("1896363250", new Object[]{this, onDialogButtonClickListener});
            return;
        }
        this.mDialogConfig.onOkBtnClickListener = onDialogButtonClickListener;
    }
}
