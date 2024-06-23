package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ComponentLoader$createItems$1$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ int $oldChildCount;
    final /* synthetic */ IComponent<ComponentValue> $this_apply;
    final /* synthetic */ ComponentLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComponentLoader$createItems$1$1(int i, IComponent<ComponentValue> iComponent, int i2, ComponentLoader componentLoader) {
        super(0);
        this.$index = i;
        this.$this_apply = iComponent;
        this.$oldChildCount = i2;
        this.this$0 = componentLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056182391")) {
            return (ur2) ipChange.ipc$dispatch("2056182391", new Object[]{this});
        } else if (this.$index == 1) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.$this_apply.getAdapter();
            if (adapter == null) {
                return null;
            }
            adapter.notifyItemRangeRemoved(0, this.$oldChildCount);
            return ur2.INSTANCE;
        } else {
            ((IComponent) this.this$0.getHost()).getProperty().setMore(false);
            this.this$0.getLoadingViewManager().onAllPageLoaded();
            this.this$0.setLoadingState(3);
            return ur2.INSTANCE;
        }
    }
}
