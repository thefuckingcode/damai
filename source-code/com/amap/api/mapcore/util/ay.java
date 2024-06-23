package com.amap.api.mapcore.util;

import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
public class ay {
    private final au a;
    private final int b;
    private int c;
    private List<MultiPointItem> d;
    private List<ay> e;

    protected ay(au auVar) {
        this(auVar, 0);
    }

    private int a(int i) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 30;
            case 2:
            case 3:
                return 20;
            case 4:
            case 5:
                return 10;
            case 6:
            default:
                return 5;
        }
    }

    private void b() {
        ArrayList arrayList = new ArrayList(4);
        this.e = arrayList;
        au auVar = this.a;
        arrayList.add(new ay(auVar.a, auVar.e, auVar.b, auVar.f, this.b + 1));
        List<ay> list = this.e;
        au auVar2 = this.a;
        list.add(new ay(auVar2.e, auVar2.c, auVar2.b, auVar2.f, this.b + 1));
        List<ay> list2 = this.e;
        au auVar3 = this.a;
        list2.add(new ay(auVar3.a, auVar3.e, auVar3.f, auVar3.d, this.b + 1));
        List<ay> list3 = this.e;
        au auVar4 = this.a;
        list3.add(new ay(auVar4.e, auVar4.c, auVar4.f, auVar4.d, this.b + 1));
    }

    /* access modifiers changed from: protected */
    public void a(MultiPointItem multiPointItem) {
        IPoint iPoint = multiPointItem.getIPoint();
        if (this.a.a(Point.getx(iPoint), Point.gety(iPoint))) {
            a(Point.getx(iPoint), Point.gety(iPoint), multiPointItem);
        }
    }

    private ay(int i, int i2, int i3, int i4, int i5) {
        this(new au(i, i2, i3, i4), i5);
    }

    private ay(au auVar, int i) {
        this.c = 30;
        this.e = null;
        this.a = auVar;
        this.b = i;
        this.c = a(i);
    }

    private void a(int i, int i2, MultiPointItem multiPointItem) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (this.d.size() <= this.c || this.b >= 40) {
            this.d.add(multiPointItem);
            return;
        }
        if (this.e == null) {
            b();
        }
        List<ay> list = this.e;
        if (list != null) {
            au auVar = this.a;
            if (i2 < auVar.f) {
                if (i < auVar.e) {
                    list.get(0).a(i, i2, multiPointItem);
                } else {
                    list.get(1).a(i, i2, multiPointItem);
                }
            } else if (i < auVar.e) {
                list.get(2).a(i, i2, multiPointItem);
            } else {
                list.get(3).a(i, i2, multiPointItem);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.e = null;
        List<MultiPointItem> list = this.d;
        if (list != null) {
            list.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void a(au auVar, Collection<MultiPointItem> collection, double d2) {
        a(auVar, collection, 1.0f, d2);
    }

    private void a(au auVar, Collection<MultiPointItem> collection, float f, double d2) {
        if (this.a.a(auVar)) {
            List<MultiPointItem> list = this.d;
            if (list != null) {
                int size = (int) (((float) list.size()) * f);
                for (int i = 0; i < size; i++) {
                    MultiPointItem multiPointItem = this.d.get(i);
                    if (auVar.a(multiPointItem.getIPoint())) {
                        collection.add(multiPointItem);
                    }
                }
            }
            if (d2 > 0.0d) {
                au auVar2 = this.a;
                double d3 = ((((double) auVar2.d) - ((double) auVar2.b)) * (((double) auVar2.c) - ((double) auVar2.a))) / d2;
                if (d3 >= ((double) 0.7f)) {
                    f = d3 > 1.0d ? 1.0f : (float) ((((4.8188d * d3) * d3) - (d3 * 4.9339d)) + 1.1093d);
                } else {
                    return;
                }
            }
            List<ay> list2 = this.e;
            if (list2 != null) {
                for (ay ayVar : list2) {
                    ayVar.a(auVar, collection, f, d2);
                }
            }
        }
    }
}
