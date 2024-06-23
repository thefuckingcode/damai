package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$removeModule$2$onChildRemoved$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IModule<ModuleValue> $module;
    final /* synthetic */ boolean $notifyUiUpdate;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$removeModule$2$onChildRemoved$1(boolean z, IModule<ModuleValue> iModule, PageContainer<VALUE> pageContainer) {
        super(0);
        this.$notifyUiUpdate = z;
        this.$module = iModule;
        this.this$0 = pageContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211240066")) {
            ipChange.ipc$dispatch("-1211240066", new Object[]{this});
        } else if (this.$notifyUiUpdate) {
            List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = this.$module.getAdapters();
            int size = adapters.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = adapters.get(size);
                    if (vBaseAdapter.getItemCount() > 0) {
                        vBaseAdapter.notifyItemRangeRemoved(0, vBaseAdapter.getItemCount());
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
            this.this$0.updateContentAdapter();
        }
    }
}
