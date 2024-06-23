package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class aw implements IBusStationSearch {
    private Context a;
    private BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    private Handler g;

    public aw(Context context, BusStationQuery busStationQuery) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.c = busStationQuery;
            this.g = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            r.a(this.a);
            if (a()) {
                if (!this.c.weakEquals(this.d)) {
                    this.d = this.c.clone();
                    this.f = 0;
                    ArrayList<BusStationResult> arrayList = this.e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new d(this.a, this.c).b();
                    this.f = busStationResult.getPageCount();
                    a(busStationResult);
                    return busStationResult;
                }
                BusStationResult b2 = b(this.c.getPageNumber());
                if (b2 != null) {
                    return b2;
                }
                BusStationResult busStationResult2 = (BusStationResult) new d(this.a, this.c).b();
                this.e.set(this.c.getPageNumber(), busStationResult2);
                return busStationResult2;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            i.a(e2, "BusStationSearch", "searchBusStation");
            throw new AMapException(e2.getErrorMessage());
        } catch (Throwable th) {
            i.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.aw.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 7;
                        t.b bVar = new t.b();
                        bVar.b = aw.this.b;
                        obtainMessage.obj = bVar;
                        BusStationResult searchBusStation = aw.this.searchBusStation();
                        obtainMessage.what = 1000;
                        bVar.a = searchBusStation;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        aw.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    aw.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.c)) {
            this.c = busStationQuery;
        }
    }

    private void a(BusStationResult busStationResult) {
        int i;
        this.e = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f;
            if (i2 > i) {
                break;
            }
            this.e.add(null);
            i2++;
        }
        if (i > 0) {
            this.e.set(this.c.getPageNumber(), busStationResult);
        }
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return this.e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i) {
        return i <= this.f && i >= 0;
    }

    private boolean a() {
        BusStationQuery busStationQuery = this.c;
        if (busStationQuery != null && !i.a(busStationQuery.getQueryString())) {
            return true;
        }
        return false;
    }
}
