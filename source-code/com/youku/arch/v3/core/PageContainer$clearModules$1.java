package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IModule;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$clearModules$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$clearModules$1(PageContainer<VALUE> pageContainer) {
        super(0);
        this.this$0 = pageContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197886591")) {
            ipChange.ipc$dispatch("-1197886591", new Object[]{this});
            return;
        }
        Iterator<IModule<ModuleValue>> it = this.this$0.modules.iterator();
        PageContainer<VALUE> pageContainer = this.this$0;
        while (it.hasNext()) {
            IModule<ModuleValue> next = it.next();
            it.remove();
            next.onRemove();
            pageContainer.childState.setChanged();
            pageContainer.childIndexUpdater.onChildRemoved(next);
        }
        this.this$0.modules.clear();
    }
}
