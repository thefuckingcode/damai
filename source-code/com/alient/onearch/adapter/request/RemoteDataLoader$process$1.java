package com.alient.onearch.adapter.request;

import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.data.RequestContext;
import com.youku.arch.v3.data.local.LocalDataSource;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/alient/onearch/adapter/request/RemoteDataLoader$process$1", "Lcom/youku/arch/v3/data/DataLoadCallback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onFilter", "onResponse", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RemoteDataLoader$process$1 implements DataLoadCallback {
    final /* synthetic */ RequestContext $requestContext;

    RemoteDataLoader$process$1(RequestContext requestContext) {
        this.$requestContext = requestContext;
    }

    @Override // com.youku.arch.v3.data.DataLoadCallback
    public void onFilter(@NotNull IResponse iResponse) {
        k21.i(iResponse, "response");
        DataLoadCallback callback = this.$requestContext.getCallback();
        if (callback != null) {
            callback.onFilter(iResponse);
        }
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        k21.i(iResponse, "response");
        if (iResponse.isSuccess()) {
            this.$requestContext.setResponse(iResponse);
        }
        DataLoadCallback callback = this.$requestContext.getCallback();
        if (callback != null) {
            callback.onResponse(iResponse);
        }
        if (iResponse.isSuccess() && this.$requestContext.getRequest().isNeedCache()) {
            LocalDataSource.put$default(LocalDataSource.Companion.getInstance(), iResponse, 0, 2, null);
        }
    }
}
