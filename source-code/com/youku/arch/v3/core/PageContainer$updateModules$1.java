package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$updateModules$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List<Node> $modules;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$updateModules$1(List<Node> list, PageContainer<VALUE> pageContainer) {
        super(0);
        this.$modules = list;
        this.this$0 = pageContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IModule<ModuleValue> iModule;
        int size;
        int size2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1145422163")) {
            ipChange.ipc$dispatch("1145422163", new Object[]{this});
            return;
        }
        try {
            if (this.$modules.size() < this.this$0.modules.size() && (size2 = this.$modules.size()) <= (size = this.this$0.modules.size() - 1)) {
                while (true) {
                    int i2 = size - 1;
                    PageContainer<VALUE> pageContainer = this.this$0;
                    pageContainer.removeModule(pageContainer.modules.get(size), true);
                    if (size == size2) {
                        break;
                    }
                    size = i2;
                }
            }
            int size3 = this.this$0.modules.size();
            if (size3 > 0) {
                while (true) {
                    int i3 = i + 1;
                    try {
                        PageContainer<VALUE> pageContainer2 = this.this$0;
                        iModule = pageContainer2.createModule(new Config<>(pageContainer2.getPageContext(), this.$modules.get(i).getType(), this.$modules.get(i), i, false, 16, null));
                    } catch (Exception e) {
                        Log.e("OneArch.PageContainer", "create module error " + this.$modules.get(i).getType() + ((Object) e.getMessage()));
                        if (!AppInfoProviderProxy.isDebuggable()) {
                            iModule = null;
                        } else {
                            throw new RuntimeException(e);
                        }
                    }
                    if (iModule != null) {
                        IModule<ModuleValue> iModule2 = this.this$0.modules.get(i);
                        PageContainer<VALUE> pageContainer3 = this.this$0;
                        IModule<ModuleValue> iModule3 = iModule2;
                        if (iModule3.diff(iModule)) {
                            PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
                            performanceLogUtil.markStartPoint("diff module to replaceModule");
                            pageContainer3.replaceModule(i, iModule);
                            performanceLogUtil.markEndPoint("diff module to replaceModule");
                        } else {
                            PerformanceLogUtil performanceLogUtil2 = PerformanceLogUtil.INSTANCE;
                            performanceLogUtil2.markStartPoint("same module to updateComponents");
                            iModule3.updateComponents(iModule.getComponents());
                            performanceLogUtil2.markEndPoint("same module to updateComponents");
                        }
                    }
                    if (i3 >= size3) {
                        break;
                    }
                    i = i3;
                }
            }
            if (this.$modules.size() > this.this$0.modules.size()) {
                PageContainer<VALUE> pageContainer4 = this.this$0;
                pageContainer4.createModules(this.$modules.subList(pageContainer4.modules.size(), this.$modules.size()));
            }
        } catch (Throwable th) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw new RuntimeException(th);
            }
        }
    }
}
