package com.alibaba.pictures.bricks.util.toast;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.tm2;

/* compiled from: Taobao */
public final class SupportToast extends BaseToast {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final tm2 mToastHelper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SupportToast(@NotNull Application application) {
        super(application);
        k21.i(application, "application");
        this.mToastHelper = new tm2(this, application);
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814859948")) {
            ipChange.ipc$dispatch("814859948", new Object[]{this});
            return;
        }
        this.mToastHelper.c();
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686583689")) {
            ipChange.ipc$dispatch("686583689", new Object[]{this});
            return;
        }
        this.mToastHelper.d();
    }
}
