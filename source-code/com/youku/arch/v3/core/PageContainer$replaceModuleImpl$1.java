package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$replaceModuleImpl$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IModule<ModuleValue> $newModule;
    final /* synthetic */ IModule<ModuleValue> $oldModule;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$replaceModuleImpl$1(PageContainer<VALUE> pageContainer, IModule<ModuleValue> iModule, IModule<ModuleValue> iModule2, int i) {
        super(0);
        this.this$0 = pageContainer;
        this.$oldModule = iModule;
        this.$newModule = iModule2;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176858197")) {
            ipChange.ipc$dispatch("176858197", new Object[]{this});
            return;
        }
        this.this$0.childState.setChanged();
        this.this$0.modules.remove(this.$oldModule);
        this.$oldModule.onRemove();
        this.this$0.childIndexUpdater.onChildRemoved(this.$oldModule);
        this.$newModule.setIndex(this.$index);
        this.this$0.modules.add(this.$index, this.$newModule);
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v("OneArch.PageContainer", "addModule  index is " + this.$index + ", adapter size " + this.this$0.adapters.size());
        }
        this.$newModule.onAdd();
        this.this$0.childIndexUpdater.onChildAdded(this.$newModule);
        IContext pageContext = this.this$0.getPageContext();
        final PageContainer<VALUE> pageContainer = this.this$0;
        final IModule<ModuleValue> iModule = this.$newModule;
        pageContext.runOnUIThreadLocked(new Function0<ur2>() {
            /* class com.youku.arch.v3.core.PageContainer$replaceModuleImpl$1.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1568486302")) {
                    ipChange.ipc$dispatch("-1568486302", new Object[]{this});
                    return;
                }
                pageContainer.updateContentAdapter();
                Iterator<T> it = iModule.getComponents().iterator();
                while (it.hasNext()) {
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = it.next().getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                    }
                }
            }
        });
    }
}
