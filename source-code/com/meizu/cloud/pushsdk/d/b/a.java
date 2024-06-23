package com.meizu.cloud.pushsdk.d.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.meizu.cloud.pushsdk.c.c.e;
import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import com.meizu.cloud.pushsdk.d.a.b;
import com.meizu.cloud.pushsdk.d.f.c;
import io.flutter.wpkbridge.WPKFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
public abstract class a {
    protected final Context a;
    protected final f b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final TimeUnit f;
    protected final AtomicBoolean g = new AtomicBoolean(false);
    private final String h;
    private final g i = g.a("application/json; charset=utf-8");
    private Uri.Builder j;
    private d k;
    private b l;
    private h m;
    private final SSLSocketFactory n;
    private final HostnameVerifier o;
    private String p;
    private final long q;
    private final long r;
    private final com.meizu.cloud.pushsdk.c.c.a s;

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0187a {
        protected final String a;
        protected final Context b;
        protected f c = null;
        protected d d = d.POST;
        protected b e = b.Single;
        protected h f = h.HTTPS;
        protected int g = 5;
        protected int h = 250;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        protected com.meizu.cloud.pushsdk.c.c.a o = new e();

        public C0187a(String str, Context context, Class<? extends a> cls) {
            this.a = str;
            this.b = context;
        }

        public C0187a a(int i2) {
            this.g = i2;
            return this;
        }

        public C0187a a(com.meizu.cloud.pushsdk.c.c.a aVar) {
            if (aVar != null) {
                this.o = aVar;
                String simpleName = C0187a.class.getSimpleName();
                c.c(simpleName, "set new call " + aVar, new Object[0]);
            }
            return this;
        }

        public C0187a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public C0187a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public C0187a b(int i2) {
            this.h = i2;
            return this;
        }

        public C0187a c(int i2) {
            this.i = i2;
            return this;
        }
    }

    public a(C0187a aVar) {
        String simpleName = a.class.getSimpleName();
        this.h = simpleName;
        this.k = aVar.d;
        this.b = aVar.c;
        this.a = aVar.b;
        this.l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.m;
        this.o = aVar.n;
        this.c = aVar.g;
        this.d = aVar.i;
        this.e = aVar.h;
        this.q = aVar.j;
        this.r = aVar.k;
        this.p = aVar.a;
        this.f = aVar.l;
        this.s = aVar.o;
        c();
        c.c(simpleName, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        a(aVar, "");
        this.j.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.j.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.j.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.meizu.cloud.pushsdk.d.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        b bVar = new b("push_group_data", arrayList2);
        String str = this.h;
        c.b(str, "final SelfDescribingJson " + bVar, new Object[0]);
        String uri = this.j.build().toString();
        return new i.a().a(uri).a(j.a(this.i, bVar.toString())).c();
    }

    private void a(k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (Exception unused) {
                c.b(this.h, "Unable to close source data", new Object[0]);
            }
        }
    }

    private void a(com.meizu.cloud.pushsdk.d.a.a aVar, String str) {
        if ("".equals(str)) {
            str = com.meizu.cloud.pushsdk.d.f.e.a();
        }
        aVar.a(WPKFactory.CONF_SERVER_TIME, str);
    }

    private void c() {
        String str;
        StringBuilder sb;
        String str2 = this.h;
        c.a(str2, "security " + this.m, new Object[0]);
        if (this.m == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.p);
        this.j = Uri.parse(sb.toString()).buildUpon();
        if (this.k == d.GET) {
            this.j.appendPath("i");
        } else {
            this.j.appendEncodedPath("push_data_report/mobile");
        }
    }

    /* access modifiers changed from: protected */
    public int a(i iVar) {
        k kVar = null;
        try {
            c.b(this.h, "Sending request: %s", iVar);
            kVar = this.s.a(iVar);
            return kVar.a();
        } catch (IOException e2) {
            c.a(this.h, "Request sending failed: %s", Log.getStackTraceString(e2));
            return -1;
        } finally {
            a(kVar);
        }
    }

    /* access modifiers changed from: protected */
    public LinkedList<e> a(c cVar) {
        int size = cVar.a().size();
        LinkedList<Long> b2 = cVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        long j2 = 22;
        if (this.k == d.GET) {
            for (int i2 = 0; i2 < size; i2++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b2.get(i2));
                com.meizu.cloud.pushsdk.d.a.a aVar = cVar.a().get(i2);
                linkedList.add(new e(aVar.b() + 22 > this.q, a(aVar), linkedList2));
            }
        } else {
            int i3 = 0;
            while (i3 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList = new ArrayList<>();
                long j3 = 0;
                int i4 = i3;
                while (i4 < this.l.a() + i3 && i4 < size) {
                    com.meizu.cloud.pushsdk.d.a.a aVar2 = cVar.a().get(i4);
                    long b3 = aVar2.b() + j2;
                    if (b3 + 88 > this.r) {
                        ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList4 = new LinkedList();
                        arrayList2.add(aVar2);
                        linkedList4.add(b2.get(i4));
                        linkedList.add(new e(true, a(arrayList2), linkedList4));
                    } else {
                        j3 += b3;
                        if (j3 + 88 + ((long) (arrayList.size() - 1)) > this.r) {
                            linkedList.add(new e(false, a(arrayList), linkedList3));
                            ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList3 = new ArrayList<>();
                            LinkedList linkedList5 = new LinkedList();
                            arrayList3.add(aVar2);
                            linkedList5.add(b2.get(i4));
                            arrayList = arrayList3;
                            linkedList3 = linkedList5;
                            j3 = b3;
                        } else {
                            arrayList.add(aVar2);
                            linkedList3.add(b2.get(i4));
                        }
                    }
                    i4++;
                    j2 = 22;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList3));
                }
                i3 += this.l.a();
                j2 = 22;
            }
        }
        return linkedList;
    }

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z);

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public String b() {
        return this.j.clearQuery().build().toString();
    }
}
