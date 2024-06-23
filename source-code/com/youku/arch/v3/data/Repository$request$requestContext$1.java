package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/arch/v3/data/Repository$request$requestContext$1", "Lcom/youku/arch/v3/data/DataLoadCallback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onFilter", "onResponse", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Repository$request$requestContext$1 implements DataLoadCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Callback $callBack;

    Repository$request$requestContext$1(Callback callback) {
        this.$callBack = callback;
    }

    @Override // com.youku.arch.v3.data.DataLoadCallback
    public void onFilter(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861970211")) {
            ipChange.ipc$dispatch("861970211", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608240762")) {
            ipChange.ipc$dispatch("608240762", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        Callback callback = this.$callBack;
        if (callback != null) {
            callback.onResponse(iResponse);
        }
    }
}
