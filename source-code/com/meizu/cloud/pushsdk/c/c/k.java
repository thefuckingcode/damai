package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.c;

/* compiled from: Taobao */
public class k {
    private final i a;
    private final int b;
    private final String c;
    private final c d;
    private final l e;
    private final k f;
    private final k g;
    private final k h;

    /* compiled from: Taobao */
    public static class a {
        private i a;
        private int b = -1;
        private String c;
        private c.a d = new c.a();
        private l e;
        private k f;
        private k g;
        private k h;

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.e = lVar;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public k a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.b >= 0) {
                return new k(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.b);
            }
        }
    }

    private k(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d.a();
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public int a() {
        return this.b;
    }

    public l b() {
        return this.e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.b + ", message=" + this.c + ", url=" + this.a.a() + '}';
    }
}
