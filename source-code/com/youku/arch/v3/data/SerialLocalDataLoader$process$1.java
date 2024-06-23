package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/arch/v3/data/SerialLocalDataLoader$process$1", "Lcom/youku/arch/v3/data/DataLoadCallback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onFilter", "onResponse", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class SerialLocalDataLoader$process$1 implements DataLoadCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Chain<RequestContext> $chain;
    final /* synthetic */ RequestContext $requestContext;

    SerialLocalDataLoader$process$1(RequestContext requestContext, Chain<RequestContext> chain) {
        this.$requestContext = requestContext;
        this.$chain = chain;
    }

    @Override // com.youku.arch.v3.data.DataLoadCallback
    public void onFilter(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448216301")) {
            ipChange.ipc$dispatch("-448216301", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-55579542")) {
            ipChange.ipc$dispatch("-55579542", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        if (iResponse.isSuccess()) {
            IResponse response = this.$requestContext.getResponse();
            if (response != null) {
                RequestContext requestContext = this.$requestContext;
                if (iResponse.getTimestamp() > response.getTimestamp()) {
                    requestContext.setResponse(iResponse);
                    DataLoadCallback callback = requestContext.getCallback();
                    if (callback != null) {
                        callback.onFilter(iResponse);
                    }
                    DataLoadCallback callback2 = requestContext.getCallback();
                    if (callback2 != null) {
                        callback2.onResponse(iResponse);
                    }
                } else {
                    z = true;
                }
                z2 = z;
            }
        } else if ((this.$requestContext.getRequest().getStrategy() & 2) == 0 && (this.$requestContext.getRequest().getStrategy() & Constants.RequestStrategy.LOCAL_FILE) == 0 && k21.d("local_cache_missing", iResponse.getRetCode())) {
            DataLoadCallback callback3 = this.$requestContext.getCallback();
            if (callback3 != null) {
                callback3.onFilter(iResponse);
            }
            DataLoadCallback callback4 = this.$requestContext.getCallback();
            if (callback4 != null) {
                callback4.onResponse(iResponse);
            }
        }
        if (z2) {
            this.$chain.proceed();
        }
    }
}
