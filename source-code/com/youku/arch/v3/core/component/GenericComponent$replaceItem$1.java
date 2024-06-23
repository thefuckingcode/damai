package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericComponent$replaceItem$1 extends Lambda implements Function0<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ GenericComponent<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericComponent$replaceItem$1(GenericComponent<VALUE> genericComponent, int i) {
        super(0);
        this.this$0 = genericComponent;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359606688")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-359606688", new Object[]{this});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.this$0.getAdapter();
        if (adapter == null) {
            return null;
        }
        int i = this.$index;
        if (adapter.getInnerAdapter() != null) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter.getInnerAdapter();
            k21.f(innerAdapter);
            if (i >= innerAdapter.getItemCount()) {
                return adapter;
            }
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = adapter.getInnerAdapter();
            k21.f(innerAdapter2);
            innerAdapter2.notifyItemChanged(i);
            return adapter;
        } else if (i >= adapter.getItemCount()) {
            return adapter;
        } else {
            adapter.notifyItemChanged(i);
            return adapter;
        }
    }
}
