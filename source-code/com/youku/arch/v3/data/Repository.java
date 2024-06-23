package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J,\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¨\u0006\u000e"}, d2 = {"Lcom/youku/arch/v3/data/Repository;", "", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", "callBack", "Ltb/ur2;", "", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "dataLoaders", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Repository {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<Repository> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, Repository$Companion$instance$2.INSTANCE);
    @Nullable
    private static DataLoader<RequestContext> remoteDataLoader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/data/Repository$Companion;", "", "Lcom/youku/arch/v3/data/Repository;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/data/Repository;", "instance", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "remoteDataLoader", "Lcom/youku/arch/v3/data/DataLoader;", "getRemoteDataLoader", "()Lcom/youku/arch/v3/data/DataLoader;", "setRemoteDataLoader", "(Lcom/youku/arch/v3/data/DataLoader;)V", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final Repository getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-617342809")) {
                return (Repository) Repository.instance$delegate.getValue();
            }
            return (Repository) ipChange.ipc$dispatch("-617342809", new Object[]{this});
        }

        @Nullable
        public final DataLoader<RequestContext> getRemoteDataLoader() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1416771066")) {
                return Repository.remoteDataLoader;
            }
            return (DataLoader) ipChange.ipc$dispatch("-1416771066", new Object[]{this});
        }

        public final void setRemoteDataLoader(@Nullable DataLoader<RequestContext> dataLoader) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-84857586")) {
                ipChange.ipc$dispatch("-84857586", new Object[]{this, dataLoader});
                return;
            }
            Repository.remoteDataLoader = dataLoader;
        }
    }

    public final void request(@NotNull IRequest iRequest, @Nullable Callback callback) {
        DataLoader<RequestContext> dataLoader;
        DataLoader<RequestContext> dataLoader2;
        DataLoader<RequestContext> dataLoader3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668629443")) {
            ipChange.ipc$dispatch("-668629443", new Object[]{this, iRequest, callback});
            return;
        }
        k21.i(iRequest, "request");
        long strategy = iRequest.getStrategy();
        ArrayList arrayList = new ArrayList();
        if ((Constants.RequestStrategy.LOCAL_FILE & strategy) > 0) {
            if ((strategy & 2) > 0 && (dataLoader3 = remoteDataLoader) != null) {
                arrayList.add(dataLoader3);
            }
            arrayList.add(new SerialLocalDataLoader());
            arrayList.add(new LocalFileDataLoader());
        } else if ((Constants.RequestStrategy.REMOTE_FILE & strategy) > 0) {
            if ((strategy & 2) > 0 && (dataLoader2 = remoteDataLoader) != null) {
                arrayList.add(dataLoader2);
            }
            arrayList.add(new RemoteFileDataLoader());
        } else {
            if ((Constants.RequestStrategy.LOCAL_SERIAL & strategy) > 0) {
                arrayList.add(new SerialLocalDataLoader());
            } else if ((1 & strategy) > 0) {
                arrayList.add(new LocalDataLoader());
            }
            if ((strategy & 2) > 0 && (dataLoader = remoteDataLoader) != null) {
                arrayList.add(dataLoader);
            }
        }
        request(iRequest, callback, arrayList);
    }

    public final void request(@NotNull IRequest iRequest, @Nullable Callback callback, @NotNull List<? extends DataLoader<RequestContext>> list) {
        RequestContext requestContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1144915666")) {
            ipChange.ipc$dispatch("-1144915666", new Object[]{this, iRequest, callback, list});
            return;
        }
        k21.i(iRequest, "request");
        k21.i(list, "dataLoaders");
        if (callback == null || !(callback instanceof DataLoadCallback)) {
            requestContext = new RequestContext(iRequest, new Repository$request$requestContext$1(callback));
        } else {
            requestContext = new RequestContext(iRequest, (DataLoadCallback) callback);
        }
        new DataLoaderChain(list, 0, requestContext).proceed();
    }
}
