package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/youku/arch/v3/loader/ComponentLoader$load$1$1$2", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onResponse", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ComponentLoader$load$1$1$2 implements Callback {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ ComponentLoader this$0;

    ComponentLoader$load$1$1$2(ComponentLoader componentLoader, int i) {
        this.this$0 = componentLoader;
        this.$index = i;
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2003772303")) {
            ipChange.ipc$dispatch("2003772303", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        String pageName = ((IComponent) this.this$0.getHost()).getPageContext().getPageName();
        if (!(pageName == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
            archMontior.setRequestTime(System.currentTimeMillis() - archMontior.getRequestTime());
            LogUtil.d(ArchMontiorManager.TAG, k21.r("ComponentLoader request --- ", Long.valueOf(archMontior.getRequestTime())));
        }
        if (iResponse.isSuccess()) {
            this.this$0.handleLoadSuccess(iResponse, this.$index);
        } else {
            this.this$0.handleLoadFailure(iResponse);
        }
    }
}
