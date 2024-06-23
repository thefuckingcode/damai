package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageLoader$createModules$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ PageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageLoader$createModules$2(PageLoader pageLoader, int i) {
        super(0);
        this.this$0 = pageLoader;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "612766827")) {
            ipChange.ipc$dispatch("612766827", new Object[]{this});
            return;
        }
        PageLoader pageLoader = this.this$0;
        int i = this.$index;
        if (((IContainer) pageLoader.getHost()).getChildCount() > 0) {
            z = true;
        }
        pageLoader.setLoadingViewState((PageLoader) i, (int) z);
    }
}
