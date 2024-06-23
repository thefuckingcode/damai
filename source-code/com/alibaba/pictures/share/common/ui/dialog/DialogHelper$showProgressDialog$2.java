package com.alibaba.pictures.share.common.ui.dialog;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.pictures.share.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DialogHelper$showProgressDialog$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DialogInterface.OnCancelListener $cancelListener;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ CharSequence $msg;
    final /* synthetic */ DialogInterface.OnKeyListener $onKeyListener;
    final /* synthetic */ boolean $showProgressBar;
    final /* synthetic */ DialogHelper this$0;

    DialogHelper$showProgressDialog$2(DialogHelper dialogHelper, CharSequence charSequence, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnKeyListener onKeyListener) {
        this.this$0 = dialogHelper;
        this.$msg = charSequence;
        this.$showProgressBar = z;
        this.$cancelable = z2;
        this.$cancelListener = onCancelListener;
        this.$onKeyListener = onKeyListener;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876905659")) {
            ipChange.ipc$dispatch("1876905659", new Object[]{this});
        } else if (!this.this$0.d().isFinishing()) {
            DialogHelper dialogHelper = this.this$0;
            GenericProgressDialog genericProgressDialog = new GenericProgressDialog(this.this$0.d(), R$style.loading_style);
            AlertDialog alertDialog = this.this$0.a;
            if (alertDialog != null) {
                alertDialog.setMessage(this.$msg);
            }
            genericProgressDialog.c(this.$showProgressBar);
            genericProgressDialog.setCancelable(this.$cancelable);
            genericProgressDialog.setOnCancelListener(this.$cancelListener);
            DialogInterface.OnKeyListener onKeyListener = this.$onKeyListener;
            if (onKeyListener != null) {
                genericProgressDialog.setOnKeyListener(onKeyListener);
            }
            genericProgressDialog.setCanceledOnTouchOutside(false);
            genericProgressDialog.show();
            ur2 ur2 = ur2.INSTANCE;
            dialogHelper.a = genericProgressDialog;
        }
    }
}
