package com.alibaba.pictures.share.common.ui.dialog;

import androidx.appcompat.app.AlertDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DialogHelper$dismissProgressDialog$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DialogHelper this$0;

    DialogHelper$dismissProgressDialog$1(DialogHelper dialogHelper) {
        this.this$0 = dialogHelper;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362456827")) {
            ipChange.ipc$dispatch("-362456827", new Object[]{this});
            return;
        }
        AlertDialog alertDialog = this.this$0.a;
        if (alertDialog != null && alertDialog.isShowing() && !this.this$0.d().isFinishing()) {
            alertDialog.dismiss();
        }
    }
}
