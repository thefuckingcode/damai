package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/youku/arch/v3/loader/ModuleLoader$load$1$1", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onResponse", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ModuleLoader$load$1$1 implements Callback {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ ModuleLoader this$0;

    ModuleLoader$load$1$1(ModuleLoader moduleLoader, int i) {
        this.this$0 = moduleLoader;
        this.$index = i;
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527605812")) {
            ipChange.ipc$dispatch("-527605812", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        if (iResponse.isSuccess()) {
            this.this$0.handleLoadSuccess(iResponse, this.$index);
        } else {
            this.this$0.handleLoadFailure(iResponse);
        }
    }
}
