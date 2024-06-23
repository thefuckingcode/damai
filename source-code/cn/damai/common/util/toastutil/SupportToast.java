package cn.damai.common.util.toastutil;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class SupportToast extends BaseToast {
    private static transient /* synthetic */ IpChange $ipChange;
    private final c mToastHelper;

    SupportToast(Application application) {
        super(application);
        this.mToastHelper = new c(this, application);
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883465989")) {
            ipChange.ipc$dispatch("883465989", new Object[]{this});
            return;
        }
        this.mToastHelper.a();
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103413282")) {
            ipChange.ipc$dispatch("2103413282", new Object[]{this});
            return;
        }
        this.mToastHelper.b();
    }
}
