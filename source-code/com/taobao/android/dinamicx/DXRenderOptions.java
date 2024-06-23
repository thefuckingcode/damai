package com.taobao.android.dinamicx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import tb.d00;
import tb.g10;

/* compiled from: Taobao */
public class DXRenderOptions {
    public static final DXRenderOptions DEFAULT_PRERENDER_OPTIONS = new b().r(2).s(8).k();
    public static final DXRenderOptions DEFAULT_RENDER_OPTIONS = new b().k();
    public static final int NORMAL = 0;
    public static final int PRE_FETCH = 1;
    public static final int PRE_RENDER = 2;
    public static final int SIMPLE = 3;
    private int a;
    private int b;
    private g10 c;
    @Deprecated
    private Object d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private Map<String, String> j;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXRenderType {
    }

    /* compiled from: Taobao */
    public static final class b {
        private int a = d00.f();
        private int b = d00.e();
        private g10 c;
        private Object d;
        private boolean e;
        private boolean f;
        private int g;
        private int h = 0;
        private int i = 8;
        private Map<String, String> j;

        public DXRenderOptions k() {
            return new DXRenderOptions(this);
        }

        public b l(int i2) {
            this.h = i2;
            return this;
        }

        public b m(int i2) {
            this.b = i2;
            return this;
        }

        public b n(boolean z) {
            this.f = z;
            return this;
        }

        public b o(boolean z) {
            this.e = z;
            return this;
        }

        public b p(Object obj) {
            this.d = obj;
            return this;
        }

        public b q(Map<String, String> map) {
            this.j = map;
            return this;
        }

        public b r(int i2) {
            this.g = i2;
            return this;
        }

        public b s(int i2) {
            this.i = i2;
            return this;
        }

        public b t(g10 g10) {
            return this;
        }

        public b u(int i2) {
            this.a = i2;
            return this;
        }
    }

    public int a() {
        return this.h;
    }

    public int b() {
        int i2 = this.b;
        return i2 == 0 ? d00.e() : i2;
    }

    public Object c() {
        return this.d;
    }

    public Map<String, String> d() {
        return this.j;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.i;
    }

    public g10 g() {
        return this.c;
    }

    public int h() {
        int i2 = this.a;
        return i2 == 0 ? d00.f() : i2;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.e;
    }

    public void k(boolean z) {
        this.f = z;
    }

    private DXRenderOptions(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        g10 unused = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.h = bVar.h;
        this.i = bVar.i;
        this.g = bVar.g;
        this.j = bVar.j;
    }
}
