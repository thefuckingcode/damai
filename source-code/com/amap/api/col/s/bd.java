package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public final class bd implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;
    private PoiSearch.SearchBound a;
    private PoiSearch.Query b;
    private Context c;
    private PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    private Handler j = null;

    public bd(Context context, PoiSearch.Query query) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.c = context.getApplicationContext();
            setQuery(query);
            this.j = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            if (bound.getCenter() == null) {
                return false;
            }
            return true;
        } else if (bound.getShape().equals("Polygon")) {
            List<LatLonPoint> polyGonList = bound.getPolyGonList();
            if (polyGonList == null || polyGonList.size() == 0) {
                return false;
            }
            for (int i2 = 0; i2 < polyGonList.size(); i2++) {
                if (polyGonList.get(i2) == null) {
                    return false;
                }
            }
            return true;
        } else if (!bound.getShape().equals("Rectangle")) {
            return true;
        } else {
            LatLonPoint lowerLeft = bound.getLowerLeft();
            LatLonPoint upperRight = bound.getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
            return true;
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            r.a(this.c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (c()) {
                PoiSearch.Query query = this.b;
                if (query != null) {
                    if ((!query.queryEquals(this.f) && this.a == null) || (!this.b.queryEquals(this.f) && !this.a.equals(this.g))) {
                        this.h = 0;
                        this.f = this.b.clone();
                        PoiSearch.SearchBound searchBound = this.a;
                        if (searchBound != null) {
                            this.g = searchBound.clone();
                        }
                        HashMap<Integer, PoiResult> hashMap = i;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearch.SearchBound searchBound2 = null;
                    PoiSearch.SearchBound searchBound3 = this.a;
                    if (searchBound3 != null) {
                        searchBound2 = searchBound3.clone();
                    }
                    ah.a().a(this.b.getQueryString());
                    this.b.setPageNum(ah.a().k(this.b.getPageNum()));
                    this.b.setPageSize(ah.a().l(this.b.getPageSize()));
                    if (this.h == 0) {
                        PoiResult poiResult = (PoiResult) new z(this.c, new ac(this.b.clone(), searchBound2)).b();
                        a(poiResult);
                        return poiResult;
                    }
                    PoiResult a2 = a(this.b.getPageNum());
                    if (a2 != null) {
                        return a2;
                    }
                    PoiResult poiResult2 = (PoiResult) new z(this.c, new ac(this.b.clone(), searchBound2)).b();
                    i.put(Integer.valueOf(this.b.getPageNum()), poiResult2);
                    return poiResult2;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "PoiSearch", "searchPOI");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bd.AnonymousClass1 */

                public final void run() {
                    t.h hVar;
                    Message obtainMessage = bd.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    try {
                        poiResult = bd.this.searchPOI();
                        bundle.putInt("errorCode", 1000);
                        hVar = new t.h();
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                        hVar = new t.h();
                    } catch (Throwable th) {
                        t.h hVar2 = new t.h();
                        hVar2.b = bd.this.d;
                        hVar2.a = poiResult;
                        obtainMessage.obj = hVar2;
                        obtainMessage.setData(bundle);
                        bd.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                    hVar.b = bd.this.d;
                    hVar.a = poiResult;
                    obtainMessage.obj = hVar;
                    obtainMessage.setData(bundle);
                    bd.this.j.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        r.a(this.c);
        PoiSearch.Query query = this.b;
        return (PoiItem) new y(this.c, str, query != null ? query.clone() : null).b();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(final String str) {
        ao.a().a(new Runnable() {
            /* class com.amap.api.col.s.bd.AnonymousClass2 */

            public final void run() {
                t.g gVar;
                Message obtainMessage = t.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    poiItem = bd.this.searchPOIId(str);
                    bundle.putInt("errorCode", 1000);
                    gVar = new t.g();
                } catch (AMapException e) {
                    i.a(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e.getErrorCode());
                    gVar = new t.g();
                } catch (Throwable th) {
                    t.g gVar2 = new t.g();
                    gVar2.b = bd.this.d;
                    gVar2.a = poiItem;
                    obtainMessage.obj = gVar2;
                    obtainMessage.setData(bundle);
                    bd.this.j.sendMessage(obtainMessage);
                    throw th;
                }
                gVar.b = bd.this.d;
                gVar.a = poiItem;
                obtainMessage.obj = gVar;
                obtainMessage.setData(bundle);
                bd.this.j.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    private boolean a() {
        PoiSearch.Query query = this.b;
        if (query == null) {
            return false;
        }
        if (!i.a(query.getQueryString()) || !i.a(this.b.getCategory())) {
            return true;
        }
        return false;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        if (bound != null && bound.getShape().equals("Bound")) {
            return true;
        }
        return false;
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }

    private void a(PoiResult poiResult) {
        int i2;
        i = new HashMap<>();
        PoiSearch.Query query = this.b;
        if (query != null && poiResult != null && (i2 = this.h) > 0 && i2 > query.getPageNum()) {
            i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
        }
    }

    private PoiResult a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
