package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$createModules$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Ref$IntRef $lastUpdateIndex;
    final /* synthetic */ List<Node> $nodes;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$createModules$1(PageContainer<VALUE> pageContainer, Ref$IntRef ref$IntRef, List<Node> list) {
        super(0);
        this.this$0 = pageContainer;
        this.$lastUpdateIndex = ref$IntRef;
        this.$nodes = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IModule<ModuleValue> iModule;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998930688")) {
            ipChange.ipc$dispatch("-998930688", new Object[]{this});
            return;
        }
        final int size = this.this$0.modules.size();
        this.$lastUpdateIndex.element = size - 1;
        int size2 = this.$nodes.size() - 1;
        if (size2 >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    PageContainer<VALUE> pageContainer = this.this$0;
                    iModule = pageContainer.createModule(new Config<>(pageContainer.getPageContext(), this.$nodes.get(i).getType(), this.$nodes.get(i), i + size, false, 16, null));
                } catch (Exception e) {
                    Log.e("OneArch.PageContainer", "create module error " + this.$nodes.get(i).getType() + ((Object) e.getMessage()));
                    if (!AppInfoProviderProxy.isDebuggable()) {
                        iModule = null;
                    } else {
                        throw new RuntimeException(e);
                    }
                }
                if (iModule != null) {
                    int i3 = i + size;
                    this.this$0.addModule(i3, iModule, false);
                    if (i3 == this.this$0.getRefreshThreshold()) {
                        if (size == 0) {
                            this.this$0.notifyFirstScreenRender();
                        } else {
                            IContext pageContext = this.this$0.getPageContext();
                            final PageContainer<VALUE> pageContainer2 = this.this$0;
                            pageContext.runOnUIThreadLocked(new Function0<ur2>() {
                                /* class com.youku.arch.v3.core.PageContainer$createModules$1.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // kotlin.jvm.functions.Function0
                                public final void invoke() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-1925205939")) {
                                        ipChange.ipc$dispatch("-1925205939", new Object[]{this});
                                        return;
                                    }
                                    pageContainer2.updateContentAdapter();
                                    PageContainer<VALUE> pageContainer = pageContainer2;
                                    for (IModule<ModuleValue> iModule : pageContainer.modules.subList(size, pageContainer.getRefreshThreshold() + 1)) {
                                        List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = iModule.getAdapters();
                                        if (adapters.size() > 0) {
                                            for (VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter : adapters) {
                                                vBaseAdapter.notifyItemRangeInserted(0, vBaseAdapter.getItemCount());
                                            }
                                        }
                                    }
                                }
                            });
                        }
                        this.$lastUpdateIndex.element = i3;
                    }
                }
                if (i2 > size2) {
                    break;
                }
                i = i2;
            }
        }
        if (this.$lastUpdateIndex.element >= this.this$0.modules.size()) {
            return;
        }
        if (this.$lastUpdateIndex.element == -1) {
            this.this$0.notifyFirstScreenRender();
            return;
        }
        IContext pageContext2 = this.this$0.getPageContext();
        final PageContainer<VALUE> pageContainer3 = this.this$0;
        final Ref$IntRef ref$IntRef = this.$lastUpdateIndex;
        pageContext2.runOnUIThreadLocked(new Function0<ur2>() {
            /* class com.youku.arch.v3.core.PageContainer$createModules$1.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2076358350")) {
                    ipChange.ipc$dispatch("2076358350", new Object[]{this});
                    return;
                }
                pageContainer3.updateContentAdapter();
                List<IModule<ModuleValue>> list = pageContainer3.modules;
                for (IModule<ModuleValue> iModule : list.subList(ref$IntRef.element + 1, list.size())) {
                    for (VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter : iModule.getAdapters()) {
                        vBaseAdapter.notifyItemRangeInserted(0, vBaseAdapter.getItemCount());
                    }
                }
            }
        });
    }
}
