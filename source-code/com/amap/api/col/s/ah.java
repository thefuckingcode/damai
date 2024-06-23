package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* compiled from: Taobao */
public class ah {
    private static volatile ah r;
    boolean a = true;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    boolean e = true;
    boolean f = true;
    boolean g = true;
    int h = 25;
    int i = 100;
    int j = 100;
    int k = 100;
    int l = 6;
    int m = 100;
    int n = 5000;
    int o = 1200;
    int p = 100000000;
    int q = 16;

    public static ah a() {
        if (r == null) {
            synchronized (ah.class) {
                if (r == null) {
                    r = new ah();
                }
            }
        }
        return r;
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final void d(boolean z) {
        this.e = z;
    }

    public final void e(boolean z) {
        this.f = z;
    }

    public final void f(boolean z) {
        this.g = z;
    }

    public final void g(boolean z) {
        this.b = z;
    }

    public final void h(int i2) {
        this.o = i2;
    }

    public final void i(int i2) {
        this.p = i2;
    }

    public final void j(int i2) {
        this.q = i2;
    }

    public final int k(int i2) {
        int i3;
        return (this.d && (i3 = this.m) < i2) ? i3 : i2;
    }

    public final int l(int i2) {
        int i3;
        return (this.d && (i3 = this.h) < i2) ? i3 : i2;
    }

    public final void b(int i2) {
        this.i = i2;
    }

    public final void c(int i2) {
        this.j = i2;
    }

    public final void d(int i2) {
        this.k = i2;
    }

    public final void e(int i2) {
        this.l = i2;
    }

    public final void f(int i2) {
        this.m = i2;
    }

    public final void g(int i2) {
        this.n = i2;
    }

    public final void b(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (this.f && fromAndTo != null && fromAndTo.getFrom() != null && fromAndTo.getTo() != null) {
            if (((double) this.k) < ((double) i.a(fromAndTo.getFrom(), fromAndTo.getTo())) / 1000.0d) {
                throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
            }
        }
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final void a(int i2) {
        this.h = i2;
    }

    public final void b(List<List<LatLonPoint>> list) throws AMapException {
        if (this.a && list != null) {
            if (this.j >= list.size()) {
                for (List<LatLonPoint> list2 : list) {
                    double b2 = i.b(list2);
                    if (this.q < list2.size()) {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                    } else if (((double) this.p) < b2) {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                    }
                }
                return;
            }
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
        }
    }

    public final void a(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double d2;
        if (!(!this.c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null)) {
            double d3 = 0.0d;
            if (list == null || list.size() == 0) {
                d2 = (double) i.a(fromAndTo.getFrom(), fromAndTo.getTo());
            } else {
                LatLonPoint from = fromAndTo.getFrom();
                LatLonPoint to = fromAndTo.getTo();
                for (LatLonPoint latLonPoint : list) {
                    d3 += (double) i.a(from, latLonPoint);
                    from = latLonPoint;
                }
                d2 = d3 + ((double) i.a(from, to));
            }
            if (((double) this.n) < d2 / 1000.0d) {
                throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
            }
        }
    }

    public final void a(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (this.e && fromAndTo != null && fromAndTo.getFrom() != null && fromAndTo.getTo() != null) {
            if (((double) this.o) < ((double) i.a(fromAndTo.getFrom(), fromAndTo.getTo())) / 1000.0d) {
                throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
            }
        }
    }

    public final void a(List<LatLonPoint> list) throws AMapException {
        if (this.g && list != null && this.l < list.size()) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
        }
    }

    public final void a(String str) throws AMapException {
        if (str != null && this.b && str.length() > this.i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }
}
