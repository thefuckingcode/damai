package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.util.PageUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/GenericFactory;", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "Lcom/youku/arch/v3/core/Node;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$moduleFactory$2 extends Lambda implements Function0<GenericFactory<IModule<ModuleValue>, Node>> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$moduleFactory$2(PageContainer<VALUE> pageContainer) {
        super(0);
        this.this$0 = pageContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GenericFactory<IModule<ModuleValue>, Node> invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-757509455")) {
            return PageUtil.INSTANCE.getDefaultModuleFactory(this.this$0.getPageContext());
        }
        return (GenericFactory) ipChange.ipc$dispatch("-757509455", new Object[]{this});
    }
}
