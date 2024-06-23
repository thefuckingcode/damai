package com.youku.arch.v3.data.local;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.data.IDataSource;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import tb.k21;
import tb.m40;

public final class LocalDataSource implements IDataSource {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Companion Companion = new Companion(null);
    public static final String TAG;
    private static final Lazy<LocalDataSource> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, LocalDataSource$Companion$instance$2.INSTANCE);
    private final DataCache cache;

    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        public final LocalDataSource getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1451196963")) {
                return (LocalDataSource) LocalDataSource.instance$delegate.getValue();
            }
            return (LocalDataSource) ipChange.ipc$dispatch("1451196963", new Object[]{this});
        }
    }

    public LocalDataSource(Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Context applicationContext = context.getApplicationContext();
        k21.h(applicationContext, "context.applicationContext");
        this.cache = new DataCache(applicationContext);
    }

    public static /* synthetic */ void put$default(LocalDataSource localDataSource, IResponse iResponse, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = -1;
        }
        localDataSource.put(iResponse, j);
    }

    @Override // com.youku.arch.v3.data.IDataSource
    public void get(IRequest iRequest, DataLoadCallback dataLoadCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613069024")) {
            ipChange.ipc$dispatch("-1613069024", new Object[]{this, iRequest, dataLoadCallback});
            return;
        }
        k21.i(iRequest, "request");
        get(iRequest.getId(), dataLoadCallback);
    }

    public final IResponse getMemCachedData(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-576109231")) {
            return this.cache.get(j);
        }
        return (IResponse) ipChange.ipc$dispatch("-576109231", new Object[]{this, Long.valueOf(j)});
    }

    public final void put(IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495082739")) {
            ipChange.ipc$dispatch("1495082739", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        put$default(this, iResponse, 0, 2, null);
    }

    public final void put(IResponse iResponse, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897044943")) {
            ipChange.ipc$dispatch("-897044943", new Object[]{this, iResponse, Long.valueOf(j)});
            return;
        }
        k21.i(iResponse, "response");
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, k21.r("put data to db ", Long.valueOf(iResponse.getId())));
        }
        if (iResponse.getSource() != "local") {
            Response.Builder builder = new Response.Builder();
            if (j == -1) {
                j = iResponse.getId();
            }
            iResponse = builder.setId(j).setCacheTag(iResponse.getCacheTag()).setRawData(iResponse.getRawData()).setRetCode(iResponse.getRetCode()).setTimestamp(iResponse.getTimestamp()).setSource("local").setJsonObject(iResponse.getJsonObject()).build();
        }
        this.cache.put(iResponse);
    }

    public final void putDataToMemCache(IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100506945")) {
            ipChange.ipc$dispatch("2100506945", new Object[]{this, iResponse});
            return;
        }
        DataCache dataCache = this.cache;
        k21.f(iResponse);
        dataCache.put(iResponse);
    }

    public final void removeById(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400793391")) {
            ipChange.ipc$dispatch("-400793391", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.cache.removeById(j);
    }

    public final void removeByType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809854370")) {
            ipChange.ipc$dispatch("-1809854370", new Object[]{this, str});
            return;
        }
        k21.i(str, "type");
        this.cache.removeByType(str);
    }

    public final void get(long j, DataLoadCallback dataLoadCallback) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568483013")) {
            ipChange.ipc$dispatch("-1568483013", new Object[]{this, Long.valueOf(j), dataLoadCallback});
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, k21.r("get data from local ", Long.valueOf(j)));
        }
        if (dataLoadCallback != null) {
            IResponse iResponse = this.cache.get(j);
            if (iResponse == null) {
                str = null;
            } else {
                str = iResponse.getRawData();
            }
            if (str == null) {
                iResponse = new Response.Builder().setSource("local").setRetCode("local_cache_missing").setRetMessage("local_cache_missing").setId(j).setTimestamp(System.currentTimeMillis()).build();
            }
            dataLoadCallback.onFilter(iResponse);
            dataLoadCallback.onResponse(iResponse);
        }
    }

    public final IResponse getMemCachedData(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1601601230")) {
            return this.cache.get((long) i);
        }
        return (IResponse) ipChange.ipc$dispatch("-1601601230", new Object[]{this, Integer.valueOf(i)});
    }
}
