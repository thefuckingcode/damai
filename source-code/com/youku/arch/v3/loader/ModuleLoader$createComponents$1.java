package com.youku.arch.v3.loader;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.util.PageUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ModuleLoader$createComponents$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ int $size;
    final /* synthetic */ ModuleLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleLoader$createComponents$1(ModuleLoader moduleLoader, int i, int i2) {
        super(0);
        this.this$0 = moduleLoader;
        this.$index = i;
        this.$size = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503386002")) {
            ipChange.ipc$dispatch("1503386002", new Object[]{this});
            return;
        }
        this.this$0.setLoadingPage(this.$index);
        for (DelegateAdapter.Adapter<?> adapter : PageUtil.INSTANCE.getSubAdapters((IModule) this.this$0.getHost(), this.$size, ((IModule) this.this$0.getHost()).getChildCount())) {
            adapter.notifyItemRangeInserted(0, adapter.getItemCount());
        }
        ModuleLoader.access$setLoadingViewState(this.this$0);
    }
}
