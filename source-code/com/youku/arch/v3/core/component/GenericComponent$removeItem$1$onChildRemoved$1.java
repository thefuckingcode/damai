package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericComponent$removeItem$1$onChildRemoved$1 extends Lambda implements Function0<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IItem<ItemValue> $item;
    final /* synthetic */ GenericComponent<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericComponent$removeItem$1$onChildRemoved$1(IItem<ItemValue> iItem, GenericComponent<VALUE> genericComponent) {
        super(0);
        this.$item = iItem;
        this.this$0 = genericComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> invoke() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-638212476")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-638212476", new Object[]{this});
        }
        int index = this.$item.getIndex();
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.this$0.getAdapter();
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = null;
        if (adapter == null) {
            return null;
        }
        IItem<ItemValue> iItem = this.$item;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter.getInnerAdapter();
        if (innerAdapter != null) {
            z = true;
        }
        if (!z) {
            innerAdapter = null;
        }
        if (innerAdapter != null) {
            try {
                innerAdapter.notifyItemRemoved(index);
                innerAdapter.notifyItemRangeChanged(index, iItem.getComponent().getChildCount() - index);
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
            vBaseAdapter = innerAdapter;
        }
        if (vBaseAdapter != null) {
            return adapter;
        }
        try {
            adapter.notifyItemRemoved(index);
            adapter.notifyItemRangeChanged(index, iItem.getComponent().getChildCount() - index);
            return adapter;
        } catch (Exception e2) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return adapter;
            }
            throw e2;
        }
    }
}
