package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ComponentLoader$createItems$1$3 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ComponentLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComponentLoader$createItems$1$3(ComponentLoader componentLoader) {
        super(0);
        this.this$0 = componentLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081875450")) {
            ipChange.ipc$dispatch("1081875450", new Object[]{this});
            return;
        }
        this.this$0.getLoadingViewManager().onLoadNextFailure(null);
        this.this$0.setLoadingState(2);
    }
}
