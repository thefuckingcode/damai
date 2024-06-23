package com.alient.onearch.adapter.request;

import com.youku.arch.v3.data.Chain;
import com.youku.arch.v3.data.DataLoader;
import com.youku.arch.v3.data.RequestContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/request/RemoteDataLoader;", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "Lcom/youku/arch/v3/data/Chain;", "chain", "Ltb/ur2;", "process", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class RemoteDataLoader implements DataLoader<RequestContext> {
    @Override // com.youku.arch.v3.data.DataLoader
    public void process(@NotNull Chain<RequestContext> chain) {
        k21.i(chain, "chain");
        RequestContext param = chain.getParam();
        RemoteDataSource.Companion.getInstance().get(param.getRequest(), new RemoteDataLoader$process$1(param));
        chain.proceed();
    }
}
