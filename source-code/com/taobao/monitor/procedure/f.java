package com.taobao.monitor.procedure;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.td2;
import tb.te0;
import tb.zb;

/* compiled from: Taobao */
public class f {
    private final String a;
    private final String b;
    private String c;
    private long d = SystemClock.uptimeMillis();
    private List<f> e;
    private List<te0> f;
    private List<td2> g;
    private Map<String, Object> h;
    private Map<String, Object> i;
    private List<zb> j;
    private Map<String, zb> k;
    private Map<String, Integer> l;
    private final boolean m;
    private final boolean n;

    f(String str, boolean z, boolean z2) {
        int i2;
        this.a = str;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1 || str.length() <= (i2 = lastIndexOf + 1)) {
            this.b = str;
        } else {
            this.b = str.substring(i2);
        }
        this.m = z;
        this.n = z2;
        l();
    }

    private void l() {
        this.e = new LinkedList();
        this.f = new LinkedList();
        this.g = new LinkedList();
        this.h = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new LinkedList();
        this.k = new ConcurrentHashMap();
    }

    /* access modifiers changed from: package-private */
    public f a(String str, Map<String, Object> map) {
        if (str != null) {
            zb zbVar = this.k.get(str);
            if (zbVar == null) {
                zbVar = new zb(str, map);
                this.k.put(str, zbVar);
                synchronized (this.j) {
                    this.j.add(zbVar);
                }
            }
            zbVar.c(map);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f b(String str, Map<String, Object> map) {
        if (str != null) {
            zb zbVar = this.k.get(str);
            if (zbVar == null) {
                zbVar = new zb(str, null);
                this.k.put(str, zbVar);
                synchronized (this.j) {
                    this.j.add(zbVar);
                }
            }
            zbVar.b(map);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f c(String str, Map<String, Object> map) {
        if (str != null) {
            zb zbVar = this.k.get(str);
            if (zbVar == null) {
                zbVar = new zb(str, null);
                this.k.put(str, zbVar);
                synchronized (this.j) {
                    this.j.add(zbVar);
                }
            }
            zbVar.d(map);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f d(String str, Object obj) {
        if (!(obj == null || str == null)) {
            this.i.put(str, obj);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f e(String str) {
        this.c = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public f f(String str, Object obj) {
        if (!(obj == null || str == null)) {
            this.h.put(str, obj);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f g(f fVar) {
        if (fVar != null) {
            String str = fVar.b;
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            Integer num = this.l.get(str);
            if (num == null) {
                this.l.put(str, 1);
            } else {
                this.l.put(str, Integer.valueOf(num.intValue() + 1));
            }
            if (fVar.n) {
                for (td2 td2 : fVar.g) {
                    char[] charArray = td2.a().toCharArray();
                    if (charArray[0] >= 'a') {
                        charArray[0] = (char) (charArray[0] - ' ');
                    }
                    String str2 = str + String.valueOf(charArray);
                    Integer num2 = this.l.get(str2);
                    if (num2 == null) {
                        this.l.put(str2, 1);
                    } else {
                        this.l.put(str2, Integer.valueOf(num2.intValue() + 1));
                    }
                }
            }
            synchronized (this.e) {
                if (!fVar.m) {
                    this.e.add(fVar);
                }
            }
        }
        return this;
    }

    public List<zb> h() {
        return this.j;
    }

    public Map<String, Integer> i() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public f j(te0 te0) {
        if (te0 != null) {
            synchronized (this.f) {
                this.f.add(te0);
            }
        }
        return this;
    }

    public List<te0> k() {
        return this.f;
    }

    public Map<String, Object> m() {
        return this.i;
    }

    public String n() {
        return this.c;
    }

    public String o() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public f p(td2 td2) {
        if (td2 != null) {
            synchronized (this.g) {
                this.g.add(td2);
            }
        }
        return this;
    }

    public List<td2> q() {
        return this.g;
    }

    public Map<String, Object> r() {
        return this.h;
    }

    public List<f> s() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public f t() {
        f fVar = new f(this.b, this.m, this.n);
        fVar.g = this.g;
        fVar.i = this.i;
        return fVar;
    }

    public String toString() {
        return this.a;
    }

    public long u() {
        return this.d;
    }

    public String v() {
        return this.a;
    }
}
