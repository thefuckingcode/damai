package com.alibaba.pictures.ut;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import kotlin.Metadata;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ExposureDog$exposure$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ExposureDog this$0;

    ExposureDog$exposure$1(ExposureDog exposureDog, Activity activity) {
        this.this$0 = exposureDog;
        this.$activity = activity;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1122201232")) {
            ipChange.ipc$dispatch("-1122201232", new Object[]{this});
            return;
        }
        ExposureDog exposureDog = this.this$0;
        exposureDog.s(exposureDog.n, this.this$0.e, null);
        this.this$0.p().put("spm", this.this$0.f);
        UTAnalytics instance = UTAnalytics.getInstance();
        k21.h(instance, "UTAnalytics.getInstance()");
        instance.getDefaultTracker().setExposureTag(this.this$0.n, this.this$0.a, this.this$0.b, this.this$0.p());
        this.this$0.o((FragmentActivity) this.$activity);
    }
}
