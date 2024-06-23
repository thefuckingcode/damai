package com.meizu.cloud.pushsdk.c.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.c.a.b;
import com.meizu.cloud.pushsdk.c.c.b;
import com.meizu.cloud.pushsdk.c.c.c;
import com.meizu.cloud.pushsdk.c.c.f;
import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.h;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class b<T extends b> {
    private static final String a = "b";
    private static final g w = g.a("application/json; charset=utf-8");
    private static final g x = g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private com.meizu.cloud.pushsdk.c.c.a A;
    private int B;
    private boolean C;
    private int D;
    private com.meizu.cloud.pushsdk.c.d.a E;
    private Bitmap.Config F;
    private int G;
    private int H;
    private ImageView.ScaleType I;
    private final Executor J;
    private String K;
    private Type L;
    private final int b;
    private final d c;
    private final int d;
    private final String e;
    private int f;
    private final Object g;
    private e h;
    private final HashMap<String, String> i;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private HashMap<String, String> l;
    private final HashMap<String, String> m;
    private final HashMap<String, String> n;
    private HashMap<String, File> o;
    private String p;
    private String q;
    private JSONObject r;
    private JSONArray s;
    private String t;
    private byte[] u;
    private File v;
    private g y;

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            iArr[e.JSON_ARRAY.ordinal()] = 1;
            a[e.JSON_OBJECT.ordinal()] = 2;
            a[e.STRING.ordinal()] = 3;
            a[e.BITMAP.ordinal()] = 4;
            a[e.PREFETCH.ordinal()] = 5;
        }
    }

    /* compiled from: Taobao */
    public static class a<T extends a> {
        private d a = d.MEDIUM;
        private final String b;
        private Object c;
        private final HashMap<String, String> d = new HashMap<>();
        private final HashMap<String, String> e = new HashMap<>();
        private final HashMap<String, String> f = new HashMap<>();
        private final String g;
        private final String h;
        private int i = 0;
        private Executor j;
        private String k;

        public a(String str, String str2, String str3) {
            this.b = str;
            this.g = str2;
            this.h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0185b<T extends C0185b> {
        private d a = d.MEDIUM;
        private final int b;
        private final String c;
        private Object d;
        private Bitmap.Config e;
        private int f;
        private int g;
        private ImageView.ScaleType h;
        private final HashMap<String, String> i = new HashMap<>();
        private final HashMap<String, String> j = new HashMap<>();
        private final HashMap<String, String> k = new HashMap<>();
        private Executor l;
        private String m;

        public C0185b(String str) {
            this.c = str;
            this.b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* compiled from: Taobao */
    public static class c<T extends c> {
        private d a = d.MEDIUM;
        private final String b;
        private Object c;
        private final HashMap<String, String> d = new HashMap<>();
        private final HashMap<String, String> e = new HashMap<>();
        private final HashMap<String, String> f = new HashMap<>();
        private final HashMap<String, String> g = new HashMap<>();
        private final HashMap<String, File> h = new HashMap<>();
        private int i = 0;
        private Executor j;
        private String k;
        private String l;

        public c(String str) {
            this.b = str;
        }

        public T a(String str, File file) {
            this.h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* compiled from: Taobao */
    public static class d<T extends d> {
        private d a = d.MEDIUM;
        private final int b;
        private final String c;
        private Object d;
        private JSONObject e = null;
        private JSONArray f = null;
        private String g = null;
        private byte[] h = null;
        private File i = null;
        private final HashMap<String, String> j = new HashMap<>();
        private final HashMap<String, String> k = new HashMap<>();
        private final HashMap<String, String> l = new HashMap<>();
        private final HashMap<String, String> m = new HashMap<>();
        private final HashMap<String, String> n = new HashMap<>();
        private Executor o;
        private String p;
        private String q;

        public d(String str) {
            this.c = str;
            this.b = 1;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.k.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 1;
        this.b = 0;
        this.c = aVar.a;
        this.e = aVar.b;
        this.g = aVar.c;
        this.p = aVar.g;
        this.q = aVar.h;
        this.i = aVar.d;
        this.m = aVar.e;
        this.n = aVar.f;
        this.D = aVar.i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C0185b bVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 0;
        this.b = bVar.b;
        this.c = bVar.a;
        this.e = bVar.c;
        this.g = bVar.d;
        this.i = bVar.i;
        this.F = bVar.e;
        this.H = bVar.g;
        this.G = bVar.f;
        this.I = bVar.h;
        this.m = bVar.j;
        this.n = bVar.k;
        this.J = bVar.l;
        this.K = bVar.m;
    }

    public b(c cVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 2;
        this.b = 1;
        this.c = cVar.a;
        this.e = cVar.b;
        this.g = cVar.c;
        this.i = cVar.d;
        this.m = cVar.f;
        this.n = cVar.g;
        this.l = cVar.e;
        this.o = cVar.h;
        this.D = cVar.i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 0;
        this.b = dVar.b;
        this.c = dVar.a;
        this.e = dVar.c;
        this.g = dVar.d;
        this.i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.e;
        this.s = dVar.f;
        this.t = dVar.g;
        this.v = dVar.i;
        this.u = dVar.h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public c a() {
        this.h = e.STRING;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public c a(k kVar) {
        c<Bitmap> a2;
        int i2 = AnonymousClass2.a[this.h.ordinal()];
        if (i2 == 1) {
            try {
                return c.a(new JSONArray(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (Exception e2) {
                return c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e2)));
            }
        } else if (i2 == 2) {
            try {
                return c.a(new JSONObject(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (Exception e3) {
                return c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e3)));
            }
        } else if (i2 == 3) {
            try {
                return c.a(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h());
            } catch (Exception e4) {
                return c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e4)));
            }
        } else if (i2 == 4) {
            synchronized (z) {
                try {
                    a2 = com.meizu.cloud.pushsdk.c.h.b.a(kVar, this.G, this.H, this.F, this.I);
                } catch (Exception e5) {
                    return c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e5)));
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a2;
        } else if (i2 != 5) {
            return null;
        } else {
            return c.a("prefetch");
        }
    }

    public com.meizu.cloud.pushsdk.c.b.a a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        try {
            if (!(aVar.a() == null || aVar.a().b() == null || aVar.a().b().a() == null)) {
                aVar.b(com.meizu.cloud.pushsdk.c.g.g.a(aVar.a().b().a()).h());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public void a(com.meizu.cloud.pushsdk.c.c.a aVar) {
        this.A = aVar;
    }

    public void a(String str) {
        this.K = str;
    }

    public c b() {
        this.h = e.BITMAP;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public c c() {
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public int d() {
        return this.b;
    }

    public String e() {
        String str = this.e;
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            str = str.replace(jl1.BLOCK_START_STR + entry.getKey() + "}", String.valueOf(entry.getValue()));
        }
        f.a f2 = f.c(str).f();
        for (Map.Entry<String, String> entry2 : this.m.entrySet()) {
            f2.a(entry2.getKey(), entry2.getValue());
        }
        return f2.b().toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public e f() {
        return this.h;
    }

    public int g() {
        return this.d;
    }

    public String h() {
        return this.K;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public com.meizu.cloud.pushsdk.c.d.a i() {
        return new com.meizu.cloud.pushsdk.c.d.a() {
            /* class com.meizu.cloud.pushsdk.c.a.b.AnonymousClass1 */

            @Override // com.meizu.cloud.pushsdk.c.d.a
            public void a(long j, long j2) {
                b.this.B = (int) ((100 * j) / j2);
                if (b.this.E != null && !b.this.C) {
                    b.this.E.a(j, j2);
                }
            }
        };
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.c.c.a l() {
        return this.A;
    }

    public j m() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            g gVar = this.y;
            return gVar != null ? j.a(gVar, jSONObject.toString()) : j.a(w, jSONObject.toString());
        }
        JSONArray jSONArray = this.s;
        if (jSONArray != null) {
            g gVar2 = this.y;
            return gVar2 != null ? j.a(gVar2, jSONArray.toString()) : j.a(w, jSONArray.toString());
        }
        String str = this.t;
        if (str != null) {
            g gVar3 = this.y;
            return gVar3 != null ? j.a(gVar3, str) : j.a(x, str);
        }
        File file = this.v;
        if (file != null) {
            g gVar4 = this.y;
            return gVar4 != null ? j.a(gVar4, file) : j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            g gVar5 = this.y;
            return gVar5 != null ? j.a(gVar5, bArr) : j.a(x, bArr);
        }
        b.a aVar = new b.a();
        try {
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public j n() {
        h.a a2 = new h.a().a(h.e);
        try {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), j.a((g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    String name = entry2.getValue().getName();
                    j a3 = j.a(g.a(com.meizu.cloud.pushsdk.c.h.b.a(name)), entry2.getValue());
                    a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), a3);
                    g gVar = this.y;
                    if (gVar != null) {
                        a2.a(gVar);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.c.c.c o() {
        c.a aVar = new c.a();
        try {
            for (Map.Entry<String, String> entry : this.i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
