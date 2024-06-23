package com.alibaba.poplayer.layermanager;

import android.view.View;
import androidx.annotation.UiThread;
import com.alibaba.poplayer.Domain;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.view.Canvas;
import java.util.ArrayList;
import java.util.Iterator;
import tb.cr1;
import tb.er1;
import tb.lu0;

/* compiled from: Taobao */
public class b {
    private final int a;
    private LayerInfoOrderList b = new LayerInfoOrderList();
    private Canvas c;

    public b(int i) {
        this.a = i;
    }

    private lu0<d, PopRequest> b(ArrayList<PopRequest> arrayList) {
        lu0<d, PopRequest> lu0 = new lu0<>();
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            lu0.c(this.b.findLayerInfoByLevel(((c) next.h()).e), next);
        }
        return lu0;
    }

    @UiThread
    private synchronized void g() {
        Canvas d = d();
        if (d == null) {
            cr1.b("%s. updateCanvas ,but lose canvas.", toString());
            return;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.g()) {
                View findViewByLevel = d.findViewByLevel(dVar.f());
                if (findViewByLevel != null) {
                    d().removeView(findViewByLevel);
                }
                if (!(dVar.c() == null || dVar.c().e() == null)) {
                    View e = dVar.c().e();
                    if (e != null) {
                        cr1.b("%s. remove Layer {level:%s}.", toString(), Integer.valueOf(dVar.f()));
                        d.addViewByLevel(e, dVar.f());
                        er1.a(dVar.c(), PopRequest.Status.SHOWING);
                        cr1.b("%s. add Layer {level:%s}.", toString(), Integer.valueOf(dVar.f()));
                    }
                }
                dVar.b();
            }
        }
    }

    public synchronized void a(ArrayList<PopRequest> arrayList) {
        lu0<d, PopRequest> b2 = b(arrayList);
        for (d dVar : b2.b().keySet()) {
            dVar.a(b2.a(dVar));
        }
        g();
    }

    public int c() {
        Iterator it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((d) it.next()).c() != null) {
                i++;
            }
        }
        return i;
    }

    public Canvas d() {
        return this.c;
    }

    public synchronized void e(ArrayList<PopRequest> arrayList) {
        lu0<d, PopRequest> b2 = b(arrayList);
        for (d dVar : b2.b().keySet()) {
            dVar.i(b2.a(dVar));
        }
        g();
    }

    public void f(Canvas canvas) {
        this.c = canvas;
    }

    public void h(PopRequest popRequest) {
        d findLayerInfoByLevel = this.b.findLayerInfoByLevel(((c) popRequest.h()).e);
        if (findLayerInfoByLevel.c() != popRequest) {
            cr1.b("%s.viewReadyNotify=>request not match!", toString());
            return;
        }
        cr1.b("%s.viewReadyNotify=>readyToShow!", toString());
        findLayerInfoByLevel.h();
        g();
    }

    public String toString() {
        return "CanvasViewModel{mDomain=" + Domain.toString(this.a) + '}';
    }
}
