package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class av implements IBusLineSearch {
    private Context a;
    private BusLineSearch.OnBusLineSearchListener b;
    private BusLineQuery c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    private Handler g = null;

    public av(Context context, BusLineQuery busLineQuery) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.c = busLineQuery;
            if (busLineQuery != null) {
                this.d = busLineQuery.clone();
            }
            this.g = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            r.a(this.a);
            if (this.d == null || !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.c.weakEquals(this.d)) {
                this.d = this.c.clone();
                this.e = 0;
                ArrayList<BusLineResult> arrayList = this.f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.e == 0) {
                BusLineResult busLineResult = (BusLineResult) new d(this.a, this.c.clone()).b();
                a(busLineResult);
                return busLineResult;
            }
            BusLineResult b2 = b(this.c.getPageNumber());
            if (b2 != null) {
                return b2;
            }
            BusLineResult busLineResult2 = (BusLineResult) new d(this.a, this.c).b();
            this.f.set(this.c.getPageNumber(), busLineResult2);
            return busLineResult2;
        } catch (AMapException e2) {
            i.a(e2, "BusLineSearch", "searchBusLine");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.av.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 1000;
                        t.a aVar = new t.a();
                        obtainMessage.obj = aVar;
                        aVar.b = av.this.b;
                        aVar.a = av.this.searchBusLine();
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        av.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    av.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (!this.c.weakEquals(busLineQuery)) {
            this.c = busLineQuery;
            this.d = busLineQuery.clone();
        }
    }

    private void a(BusLineResult busLineResult) {
        int i;
        this.f = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.e;
            if (i2 >= i) {
                break;
            }
            this.f.add(null);
            i2++;
        }
        if (i >= 0 && a(this.c.getPageNumber())) {
            this.f.set(this.c.getPageNumber(), busLineResult);
        }
    }

    private BusLineResult b(int i) {
        if (a(i)) {
            return this.f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    private boolean a() {
        BusLineQuery busLineQuery = this.c;
        if (busLineQuery != null && !i.a(busLineQuery.getQueryString())) {
            return true;
        }
        return false;
    }
}
