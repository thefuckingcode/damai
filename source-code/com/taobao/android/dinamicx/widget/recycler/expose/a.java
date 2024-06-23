package com.taobao.android.dinamicx.widget.recycler.expose;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import tb.sx1;
import tb.vz;
import tb.yf0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a implements ExposureLifecycle<Integer, WeakReference<View>> {
    private final c a;
    private final IExposureEngine<Integer, WeakReference<View>> b;
    private final HashSet<String> c = new HashSet<>();
    private final RecyclerView d;

    /* renamed from: com.taobao.android.dinamicx.widget.recycler.expose.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0212a extends vz {
        C0212a(IDXVideoController iDXVideoController) {
            super(iDXVideoController);
        }

        @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback, tb.vz
        public void onScrollExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i, int i2) {
            a.this.b();
        }

        @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback, tb.vz
        public void onScrollStateChangeExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i) {
        }
    }

    public a(RecyclerView recyclerView, c cVar) {
        this.a = cVar;
        this.d = recyclerView;
        sx1.b bVar = new sx1.b(recyclerView, new C0212a(null));
        long e = cVar.e();
        bVar.d(this, e, "recyclerLayoutExpose" + recyclerView.hashCode());
        this.b = bVar.a();
    }

    public void a() {
        this.c.clear();
    }

    public void b() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine != null) {
            iExposureEngine.exposeCache();
        }
    }

    /* renamed from: c */
    public void onAfterCancelDataExpose(Integer num, WeakReference<View> weakReference, String str) {
    }

    /* renamed from: d */
    public boolean onBeforeExposeData(Integer num, WeakReference<View> weakReference, String str) {
        c cVar = this.a;
        if (cVar == null || cVar.h() == null) {
            return false;
        }
        return this.a.h().filter(num.intValue());
    }

    /* renamed from: e */
    public void onDataExpose(Integer num, WeakReference<View> weakReference, String str) {
        c cVar = this.a;
        if (cVar != null && cVar.g() != null) {
            this.a.g().expose(num.intValue());
        }
    }

    /* renamed from: f */
    public boolean onValidateExposeData(Integer num, WeakReference<View> weakReference, String str, Map<Integer, WeakReference<View>> map) {
        View findViewByPosition;
        c cVar = this.a;
        if (cVar == null || cVar.f() == null || this.c.contains(String.valueOf(num)) || (findViewByPosition = this.d.getLayoutManager().findViewByPosition(num.intValue())) == null || this.a.j() == null) {
            return false;
        }
        boolean b2 = yf0.b(findViewByPosition, this.a.j().visiblePercent());
        if (b2) {
            this.c.add(String.valueOf(num));
        }
        return b2;
    }

    public void g() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine != null) {
            iExposureEngine.runZone();
        }
    }

    public void h() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine != null) {
            iExposureEngine.stopZone();
        }
    }

    public void i() {
        IExposureEngine<Integer, WeakReference<View>> iExposureEngine = this.b;
        if (iExposureEngine != null) {
            iExposureEngine.exposeCache();
            this.b.triggerExpose();
        }
    }
}
