package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/arch/v3/data/LocalDataLoader$process$1", "Lcom/youku/arch/v3/data/DataLoadCallback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onFilter", "onResponse", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class LocalDataLoader$process$1 implements DataLoadCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ RequestContext $requestContext;

    LocalDataLoader$process$1(RequestContext requestContext) {
        this.$requestContext = requestContext;
    }

    @Override // com.youku.arch.v3.data.DataLoadCallback
    public void onFilter(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113086809")) {
            ipChange.ipc$dispatch("-2113086809", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        DataLoadCallback callback = this.$requestContext.getCallback();
        if (callback != null) {
            callback.onFilter(iResponse);
        }
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        DataLoadCallback callback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026663678")) {
            ipChange.ipc$dispatch("2026663678", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        if (iResponse.isSuccess()) {
            if (this.$requestContext.getResponse() != null) {
                long timestamp = iResponse.getTimestamp();
                IResponse response = this.$requestContext.getResponse();
                k21.f(response);
                if (timestamp <= response.getTimestamp()) {
                    return;
                }
            }
            this.$requestContext.setResponse(iResponse);
            DataLoadCallback callback2 = this.$requestContext.getCallback();
            if (callback2 != null) {
                callback2.onResponse(iResponse);
            }
        } else if ((this.$requestContext.getRequest().getStrategy() & 2) == 0 && k21.d("local_cache_missing", iResponse.getRetCode()) && (callback = this.$requestContext.getCallback()) != null) {
            callback.onResponse(iResponse);
        }
    }
}
