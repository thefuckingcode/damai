package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$replaceModule$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IModule<ModuleValue> $module;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$replaceModule$1(PageContainer<VALUE> pageContainer, int i, IModule<ModuleValue> iModule) {
        super(0);
        this.this$0 = pageContainer;
        this.$index = i;
        this.$module = iModule;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1174909333")) {
            ipChange.ipc$dispatch("1174909333", new Object[]{this});
            return;
        }
        try {
            IModule<ModuleValue> iModule = this.this$0.modules.get(this.$index);
            this.$module.setIndex(iModule.getIndex());
            this.$module.setContainer(iModule.getContainer());
            List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = iModule.getAdapters();
            List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters2 = this.$module.getAdapters();
            boolean z = adapters.size() == adapters2.size();
            if (z) {
                try {
                    int size = adapters.size() - 1;
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            if (!k21.d(adapters2.get(i).getClass(), adapters.get(i).getClass())) {
                                z = false;
                            }
                            if (i2 > size) {
                                break;
                            }
                            i = i2;
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (r7) {
                        throw new IndexOutOfBoundsException("targetType = " + iModule.getType() + ",sourceType = " + this.$module.getType() + AVFSCacheConstants.COMMA_SEP + ((Object) e.getMessage()));
                    }
                }
            }
            if (z) {
                this.this$0.childState.setChanged();
                iModule.onRemove();
                this.this$0.modules.set(this.$index, this.$module);
                IModule<ModuleValue> iModule2 = this.$module;
                if (iModule == iModule2) {
                    iModule2.setIndex(this.$index);
                }
                IContext pageContext = this.this$0.getPageContext();
                final PageContainer<VALUE> pageContainer = this.this$0;
                final IModule<ModuleValue> iModule3 = this.$module;
                pageContext.runOnUIThreadLocked(new Function0<ur2>() {
                    /* class com.youku.arch.v3.core.PageContainer$replaceModule$1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // kotlin.jvm.functions.Function0
                    public final void invoke() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-219051614")) {
                            ipChange.ipc$dispatch("-219051614", new Object[]{this});
                            return;
                        }
                        try {
                            pageContainer.updateContentAdapter();
                            if (AppInfoProviderProxy.isDebuggable()) {
                                LogUtil.v("PageContainer", "replaceModule localNotifyChange");
                            }
                            int size = iModule3.getComponents().size() - 1;
                            if (size >= 0) {
                                int i = 0;
                                while (true) {
                                    int i2 = i + 1;
                                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iModule3.getComponents().get(i).getAdapter();
                                    if (adapter != null) {
                                        adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                                    }
                                    if (i2 <= size) {
                                        i = i2;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw new RuntimeException(th);
                            }
                        }
                    }
                });
                return;
            }
            this.this$0.replaceModuleImpl(this.$index, iModule, this.$module);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.v("PageContainer", "replaceModule not localNotifyChange");
            }
        } finally {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return;
            }
        }
    }
}
