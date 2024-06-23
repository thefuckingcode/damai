package com.alibaba.poplayer.layermanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: Taobao */
class LayerInfoOrderList extends ArrayList<d> {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Comparator<d> {
        a(LayerInfoOrderList layerInfoOrderList) {
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f() - dVar2.f();
        }
    }

    LayerInfoOrderList() {
    }

    private void sort() {
        Collections.sort(this, new a(this));
    }

    public d findLayerInfoByLevel(int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f() == i) {
                return dVar;
            }
        }
        d dVar2 = new d(i);
        add(dVar2);
        return dVar2;
    }

    public boolean add(d dVar) {
        boolean add = super.add((Object) dVar);
        sort();
        return add;
    }
}
