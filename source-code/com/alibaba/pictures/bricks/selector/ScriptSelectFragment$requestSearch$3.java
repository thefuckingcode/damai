package com.alibaba.pictures.bricks.selector;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptSelectFragment$requestSearch$3 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptSelectFragment$requestSearch$3(ScriptSelectFragment scriptSelectFragment) {
        super(0);
        this.this$0 = scriptSelectFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1232381238")) {
            ipChange.ipc$dispatch("-1232381238", new Object[]{this});
            return;
        }
        this.this$0.hideLoading();
    }
}
