package com.youku.arch.v3.core.module;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModuleValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericModule$removeComponent$1$onChildRemoved$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IComponent<ComponentValue> $component;
    final /* synthetic */ GenericModule<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericModule$removeComponent$1$onChildRemoved$1(IComponent<ComponentValue> iComponent, GenericModule<VALUE> genericModule) {
        super(0);
        this.$component = iComponent;
        this.this$0 = genericModule;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "203213900")) {
            ipChange.ipc$dispatch("203213900", new Object[]{this});
            return;
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.$component.getAdapter();
        if (adapter != null) {
            GenericModule<VALUE> genericModule = this.this$0;
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.v("OneArch.GenericModule", "notifyItemRangeRemoved removeComponent " + genericModule.getChildCount() + " , " + genericModule.getCoordinate());
            }
            adapter.notifyItemRangeRemoved(0, adapter.getItemCount());
        }
        this.this$0.getContainer().updateContentAdapter();
        if (this.this$0.getChildState().hasChanged()) {
            this.this$0.getChildState().clearChanged();
        }
    }
}
