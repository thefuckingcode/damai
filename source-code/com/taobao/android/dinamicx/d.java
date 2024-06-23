package com.taobao.android.dinamicx;

import java.lang.ref.WeakReference;
import tb.at;
import tb.fz0;
import tb.yx;
import tb.zx;

/* compiled from: Taobao */
public class d {
    protected DXEngineConfig a;
    private WeakReference<zx> b;
    private WeakReference<yx> c;
    private WeakReference<DinamicXEngine> d;
    private boolean e = false;
    private boolean f = false;
    private fz0 g;
    private boolean h = false;
    private int i = 500;

    public d(DXEngineConfig dXEngineConfig) {
        this.a = dXEngineConfig;
        if (at.c0(dXEngineConfig.a)) {
            this.e = true;
        }
        if (at.b0(dXEngineConfig.b())) {
            this.f = true;
        }
        if (at.Q0(dXEngineConfig.b())) {
            this.h = at.O0();
            this.i = at.X();
        }
    }

    public long a() {
        DXRemoteTimeInterface m;
        if (e() == null || (m = e().m()) == null) {
            return -1;
        }
        return m.fetchRemoteTimeSync();
    }

    public DXEngineConfig b() {
        return this.a;
    }

    public yx c() {
        WeakReference<yx> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public zx d() {
        WeakReference<zx> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public DinamicXEngine e() {
        WeakReference<DinamicXEngine> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public fz0 f() {
        return this.g;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.h;
    }

    public void k(DXRootView dXRootView, Object obj) {
        if (e() != null) {
            e().E(dXRootView, obj);
        }
    }

    public void l(yx yxVar) {
        this.c = new WeakReference<>(yxVar);
    }

    /* access modifiers changed from: package-private */
    public void m(zx zxVar) {
        this.b = new WeakReference<>(zxVar);
    }

    public void n(DinamicXEngine dinamicXEngine) {
        this.d = new WeakReference<>(dinamicXEngine);
    }
}
