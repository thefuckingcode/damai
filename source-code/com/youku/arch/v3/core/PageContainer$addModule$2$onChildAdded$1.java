package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$addModule$2$onChildAdded$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IModule<ModuleValue> $module;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$addModule$2$onChildAdded$1(int i, PageContainer<VALUE> pageContainer, IModule<ModuleValue> iModule) {
        super(0);
        this.$index = i;
        this.this$0 = pageContainer;
        this.$module = iModule;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67358931")) {
            ipChange.ipc$dispatch("67358931", new Object[]{this});
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v("OneArch.PageContainer", "addModule before ItemRangeInserted index is " + this.$index + ", adapter size " + this.this$0.adapters.size() + ", module size " + this.this$0.modules.size());
        }
        this.this$0.updateContentAdapter();
        for (IComponent<ComponentValue> iComponent : this.$module.getComponents()) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
            if (adapter != null) {
                adapter.notifyLocalDataSetChanged(null, iComponent.getItems());
            }
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v("OneArch.PageContainer", "addModule after ItemRangeInserted index is " + this.$index + ", adapter size " + this.this$0.adapters.size() + ", module size " + this.this$0.modules.size());
        }
    }
}
