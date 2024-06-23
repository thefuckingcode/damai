package com.meizu.cloud.pushsdk.c.c;

import anet.channel.request.a;
import com.meizu.cloud.pushsdk.c.c.c;

/* compiled from: Taobao */
public class i {
    private final f a;
    private final String b;
    private final c c;
    private final j d;
    private final Object e;

    /* compiled from: Taobao */
    public static class a {
        private f a;
        private String b = "GET";
        private c.a c = new c.a();
        private j d;
        private Object e;

        public a a() {
            return a("GET", (j) null);
        }

        public a a(c cVar) {
            this.c = cVar.c();
            return this;
        }

        public a a(f fVar) {
            if (fVar != null) {
                this.a = fVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(j jVar) {
            return a("POST", jVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
        public a a(String str) {
            f c2;
            StringBuilder sb;
            int i;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    sb = new StringBuilder();
                    sb.append("http:");
                    i = 3;
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        sb = new StringBuilder();
                        sb.append("https:");
                        i = 4;
                    }
                    c2 = f.c(str);
                    if (c2 == null) {
                        return a(c2);
                    }
                    throw new IllegalArgumentException("unexpected url: " + str);
                }
                sb.append(str.substring(i));
                str = sb.toString();
                c2 = f.c(str);
                if (c2 == null) {
                }
            } else {
                throw new IllegalArgumentException("url == null");
            }
        }

        public a a(String str, j jVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (jVar != null && !d.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (jVar != null || !d.a(str)) {
                this.b = str;
                this.d = jVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a b() {
            return a(a.c.HEAD, (j) null);
        }

        public a b(j jVar) {
            return a(a.c.DELETE, jVar);
        }

        public a c(j jVar) {
            return a(a.c.PUT, jVar);
        }

        public i c() {
            if (this.a != null) {
                return new i(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a d(j jVar) {
            return a("PATCH", jVar);
        }
    }

    private i(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public f a() {
        return this.a;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public String b() {
        return this.b;
    }

    public int c() {
        if ("POST".equals(b())) {
            return 1;
        }
        if (a.c.PUT.equals(b())) {
            return 2;
        }
        if (a.c.DELETE.equals(b())) {
            return 3;
        }
        if (a.c.HEAD.equals(b())) {
            return 4;
        }
        return "PATCH".equals(b()) ? 5 : 0;
    }

    public c d() {
        return this.c;
    }

    public j e() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
