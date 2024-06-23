package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.Addressable;
import com.youku.arch.v3.IModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/arch/v3/core/PageContainer$removeModule$2", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "Lcom/youku/arch/v3/Addressable;", "addressable", "Ltb/ur2;", "onChildAdded", "onChildRemoved", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$removeModule$2 implements OnChildAttachStateChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IModule<ModuleValue> $module;
    final /* synthetic */ boolean $notifyUiUpdate;
    final /* synthetic */ PageContainer<VALUE> this$0;

    PageContainer$removeModule$2(PageContainer<VALUE> pageContainer, boolean z, IModule<ModuleValue> iModule) {
        this.this$0 = pageContainer;
        this.$notifyUiUpdate = z;
        this.$module = iModule;
    }

    @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
    public void onChildAdded(@NotNull Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416991411")) {
            ipChange.ipc$dispatch("416991411", new Object[]{this, addressable});
            return;
        }
        k21.i(addressable, "addressable");
    }

    @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
    public void onChildRemoved(@NotNull Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102076947")) {
            ipChange.ipc$dispatch("2102076947", new Object[]{this, addressable});
            return;
        }
        k21.i(addressable, "addressable");
        this.this$0.getPageContext().runOnUIThreadLocked(new PageContainer$removeModule$2$onChildRemoved$1(this.$notifyUiUpdate, this.$module, this.this$0));
    }
}
