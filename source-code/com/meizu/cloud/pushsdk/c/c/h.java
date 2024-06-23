package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.c;
import com.meizu.cloud.pushsdk.c.g.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
public final class h extends j {
    public static final g a = g.a("multipart/mixed");
    public static final g b = g.a("multipart/alternative");
    public static final g c = g.a("multipart/digest");
    public static final g d = g.a("multipart/parallel");
    public static final g e = g.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final e i;
    private final g j;
    private final g k;
    private final List<b> l;
    private long m = -1;

    /* compiled from: Taobao */
    public static final class a {
        private final e a;
        private g b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = h.a;
            this.c = new ArrayList();
            this.a = e.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            Objects.requireNonNull(gVar, "type == null");
            if ("multipart".equals(gVar.a())) {
                this.b = gVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + gVar);
        }

        public a a(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.c.add(bVar);
            return this;
        }

        public h a() {
            if (!this.c.isEmpty()) {
                return new h(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private final c a;
        private final j b;

        private b(c cVar, j jVar) {
            this.a = cVar;
            this.b = jVar;
        }

        public static b a(c cVar, j jVar) {
            Objects.requireNonNull(jVar, "body == null");
            if (cVar != null && cVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (cVar == null || cVar.a(Constants.Protocol.CONTENT_LENGTH) == null) {
                return new b(cVar, jVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }
    }

    h(e eVar, g gVar, List<b> list) {
        this.i = eVar;
        this.j = gVar;
        this.k = g.a(gVar + "; boundary=" + eVar.a());
        this.l = m.a(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.meizu.cloud.pushsdk.c.g.b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.meizu.cloud.pushsdk.c.g.b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.meizu.cloud.pushsdk.c.g.b */
    /* JADX WARN: Multi-variable type inference failed */
    private long a(c cVar, boolean z) throws IOException {
        com.meizu.cloud.pushsdk.c.g.b bVar;
        if (z) {
            cVar = new com.meizu.cloud.pushsdk.c.g.b();
            bVar = cVar;
        } else {
            bVar = 0;
        }
        int size = this.l.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar2 = this.l.get(i2);
            c cVar2 = bVar2.a;
            j jVar = bVar2.b;
            cVar.c(h);
            cVar.b(this.i);
            cVar.c(g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i3 = 0; i3 < a2; i3++) {
                    cVar.b(cVar2.a(i3)).c(f).b(cVar2.b(i3)).c(g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                cVar.b("Content-Type: ").b(a3.toString()).c(g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(g);
            } else if (z) {
                bVar.j();
                return -1;
            }
            byte[] bArr = g;
            cVar.c(bArr);
            if (z) {
                j2 += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(bArr);
        }
        byte[] bArr2 = h;
        cVar.c(bArr2);
        cVar.b(this.i);
        cVar.c(bArr2);
        cVar.c(g);
        if (!z) {
            return j2;
        }
        long a4 = j2 + bVar.a();
        bVar.j();
        return a4;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(c cVar) throws IOException {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() throws IOException {
        long j2 = this.m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a((c) null, true);
        this.m = a2;
        return a2;
    }
}
