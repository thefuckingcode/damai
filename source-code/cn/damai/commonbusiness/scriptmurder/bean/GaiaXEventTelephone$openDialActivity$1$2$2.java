package cn.damai.commonbusiness.scriptmurder.bean;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.wm2;

/* compiled from: Taobao */
public final class GaiaXEventTelephone$openDialActivity$1$2$2 implements BottomActionDialog.OnActionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Activity $this_refAct;

    GaiaXEventTelephone$openDialActivity$1$2$2(Activity activity) {
        this.$this_refAct = activity;
    }

    @Override // com.alibaba.pictures.bricks.view.BottomActionDialog.OnActionListener
    public void onClick(@NotNull BottomAction bottomAction, @NotNull View view, @NotNull Dialog dialog) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143709695")) {
            ipChange.ipc$dispatch("-2143709695", new Object[]{this, bottomAction, view, dialog});
            return;
        }
        k21.i(bottomAction, "action");
        k21.i(view, "v");
        k21.i(dialog, "dialog");
        dialog.dismiss();
        wm2.INSTANCE.h(this.$this_refAct, bottomAction.getExtra());
    }
}
