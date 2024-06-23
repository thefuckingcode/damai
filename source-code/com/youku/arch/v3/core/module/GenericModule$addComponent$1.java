package com.youku.arch.v3.core.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.Addressable;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/arch/v3/core/module/GenericModule$addComponent$1", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "Lcom/youku/arch/v3/Addressable;", "addressable", "Ltb/ur2;", "onChildAdded", "onChildRemoved", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericModule$addComponent$1 implements OnChildAttachStateChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IComponent<ComponentValue> $component;
    final /* synthetic */ boolean $notifyUiUpdate;
    final /* synthetic */ GenericModule<VALUE> this$0;

    GenericModule$addComponent$1(boolean z, GenericModule<VALUE> genericModule, IComponent<ComponentValue> iComponent) {
        this.$notifyUiUpdate = z;
        this.this$0 = genericModule;
        this.$component = iComponent;
    }

    @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
    public void onChildAdded(@NotNull Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585591132")) {
            ipChange.ipc$dispatch("-585591132", new Object[]{this, addressable});
            return;
        }
        k21.i(addressable, "addressable");
        if (this.$notifyUiUpdate) {
            this.this$0.getPageContext().runOnUIThreadLocked(new GenericModule$addComponent$1$onChildAdded$1(this.this$0, this.$component));
        }
    }

    @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
    public void onChildRemoved(@NotNull Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692927428")) {
            ipChange.ipc$dispatch("692927428", new Object[]{this, addressable});
            return;
        }
        k21.i(addressable, "addressable");
    }
}
