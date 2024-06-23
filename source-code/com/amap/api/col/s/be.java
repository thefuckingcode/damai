package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* compiled from: Taobao */
public final class be implements IRoutePOISearch {
    private RoutePOISearchQuery a;
    private Context b;
    private RoutePOISearch.OnRoutePOISearchListener c;
    private Handler d = null;

    public be(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.b = context;
            this.a = routePOISearchQuery;
            this.d = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            r.a(this.b);
            if (a()) {
                return (RoutePOISearchResult) new ak(this.b, this.a.clone()).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        ao.a().a(new Runnable() {
            /* class com.amap.api.col.s.be.AnonymousClass1 */

            public final void run() {
                t.j jVar;
                Message obtainMessage = be.this.d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResult = null;
                try {
                    routePOISearchResult = be.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    jVar = new t.j();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    jVar = new t.j();
                } catch (Throwable th) {
                    t.j jVar2 = new t.j();
                    jVar2.b = be.this.c;
                    jVar2.a = routePOISearchResult;
                    obtainMessage.obj = jVar2;
                    obtainMessage.setData(bundle);
                    be.this.d.sendMessage(obtainMessage);
                    throw th;
                }
                jVar.b = be.this.c;
                jVar.a = routePOISearchResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                be.this.d.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }

    private boolean a() {
        RoutePOISearchQuery routePOISearchQuery = this.a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        if (this.a.getFrom() == null && this.a.getTo() == null && this.a.getPolylines() == null) {
            return false;
        }
        return true;
    }
}
