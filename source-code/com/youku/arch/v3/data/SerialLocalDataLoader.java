package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.local.LocalDataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/data/SerialLocalDataLoader;", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "Lcom/youku/arch/v3/data/Chain;", "chain", "Ltb/ur2;", "process", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class SerialLocalDataLoader implements DataLoader<RequestContext> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.data.DataLoader
    public void process(@NotNull Chain<RequestContext> chain) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687982512")) {
            ipChange.ipc$dispatch("1687982512", new Object[]{this, chain});
            return;
        }
        k21.i(chain, "chain");
        RequestContext param = chain.getParam();
        LocalDataSource.Companion.getInstance().get(param.getRequest(), new SerialLocalDataLoader$process$1(param, chain));
    }
}
