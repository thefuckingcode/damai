package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jl1;

/* compiled from: Taobao */
public class fa implements iu<fa, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 3, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f328a = new jk("StatsEvent");
    private static final jc b = new jc("", (byte) 8, 2);
    private static final jc c = new jc("", (byte) 8, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 8, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 11, 8);
    private static final jc i = new jc("", (byte) 8, 9);
    private static final jc j = new jc("", (byte) 8, 10);

    /* renamed from: a  reason: collision with other field name */
    public byte f329a;

    /* renamed from: a  reason: collision with other field name */
    public int f330a;

    /* renamed from: a  reason: collision with other field name */
    public String f331a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f332a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f333b;

    /* renamed from: b  reason: collision with other field name */
    public String f334b;

    /* renamed from: c  reason: collision with other field name */
    public int f335c;

    /* renamed from: c  reason: collision with other field name */
    public String f336c;

    /* renamed from: d  reason: collision with other field name */
    public int f337d;

    /* renamed from: d  reason: collision with other field name */
    public String f338d;

    /* renamed from: e  reason: collision with other field name */
    public int f339e;

    /* renamed from: a */
    public int compareTo(fa faVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (!getClass().equals(faVar.getClass())) {
            return getClass().getName().compareTo(faVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m467a()).compareTo(Boolean.valueOf(faVar.m467a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m467a() && (a11 = iv.a(this.f329a, faVar.f329a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(faVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = iv.a(this.f330a, faVar.f330a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(faVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = iv.a(this.f333b, faVar.f333b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(faVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = iv.a(this.f331a, faVar.f331a)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(faVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = iv.a(this.f334b, faVar.f334b)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(faVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = iv.a(this.f335c, faVar.f335c)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(faVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = iv.a(this.f336c, faVar.f336c)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(faVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = iv.a(this.f338d, faVar.f338d)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(faVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = iv.a(this.f337d, faVar.f337d)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(faVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = iv.a(this.f339e, faVar.f339e)) == 0) {
            return 0;
        }
        return a2;
    }

    public fa a(byte b2) {
        this.f329a = b2;
        a(true);
        return this;
    }

    public fa a(int i2) {
        this.f330a = i2;
        b(true);
        return this;
    }

    public fa a(String str) {
        this.f331a = str;
        return this;
    }

    public void a() {
        if (this.f331a == null) {
            throw new jg("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.m715a();
        while (true) {
            jc a2 = jfVar.m711a();
            byte b2 = a2.a;
            if (b2 == 0) {
                jfVar.f();
                if (!m467a()) {
                    throw new jg("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new jg("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new jg("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (a2.f801a) {
                    case 1:
                        if (b2 == 3) {
                            this.f329a = jfVar.a();
                            a(true);
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 2:
                        if (b2 == 8) {
                            this.f330a = jfVar.m709a();
                            b(true);
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 3:
                        if (b2 == 8) {
                            this.f333b = jfVar.m709a();
                            c(true);
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f331a = jfVar.m716a();
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 5:
                        if (b2 == 11) {
                            this.f334b = jfVar.m716a();
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 6:
                        if (b2 == 8) {
                            this.f335c = jfVar.m709a();
                            d(true);
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f336c = jfVar.m716a();
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f338d = jfVar.m716a();
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 9:
                        if (b2 == 8) {
                            this.f337d = jfVar.m709a();
                            e(true);
                            continue;
                            jfVar.g();
                        }
                        break;
                    case 10:
                        if (b2 == 8) {
                            this.f339e = jfVar.m709a();
                            f(true);
                            continue;
                            jfVar.g();
                        }
                        break;
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f332a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a() {
        return this.f332a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a(fa faVar) {
        if (faVar == null || this.f329a != faVar.f329a || this.f330a != faVar.f330a || this.f333b != faVar.f333b) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = faVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f331a.equals(faVar.f331a))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = faVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f334b.equals(faVar.f334b))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = faVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f335c != faVar.f335c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = faVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f336c.equals(faVar.f336c))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = faVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f338d.equals(faVar.f338d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = faVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f337d != faVar.f337d)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = faVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f339e == faVar.f339e;
        }
        return true;
    }

    public fa b(int i2) {
        this.f333b = i2;
        c(true);
        return this;
    }

    public fa b(String str) {
        this.f334b = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f328a);
        jfVar.a(a);
        jfVar.a(this.f329a);
        jfVar.b();
        jfVar.a(b);
        jfVar.a(this.f330a);
        jfVar.b();
        jfVar.a(c);
        jfVar.a(this.f333b);
        jfVar.b();
        if (this.f331a != null) {
            jfVar.a(d);
            jfVar.a(this.f331a);
            jfVar.b();
        }
        if (this.f334b != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f334b);
            jfVar.b();
        }
        if (f()) {
            jfVar.a(f);
            jfVar.a(this.f335c);
            jfVar.b();
        }
        if (this.f336c != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f336c);
            jfVar.b();
        }
        if (this.f338d != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f338d);
            jfVar.b();
        }
        if (i()) {
            jfVar.a(i);
            jfVar.a(this.f337d);
            jfVar.b();
        }
        if (j()) {
            jfVar.a(j);
            jfVar.a(this.f339e);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public void b(boolean z) {
        this.f332a.set(1, z);
    }

    public boolean b() {
        return this.f332a.get(1);
    }

    public fa c(int i2) {
        this.f335c = i2;
        d(true);
        return this;
    }

    public fa c(String str) {
        this.f336c = str;
        return this;
    }

    public void c(boolean z) {
        this.f332a.set(2, z);
    }

    public boolean c() {
        return this.f332a.get(2);
    }

    public fa d(int i2) {
        this.f337d = i2;
        e(true);
        return this;
    }

    public fa d(String str) {
        this.f338d = str;
        return this;
    }

    public void d(boolean z) {
        this.f332a.set(3, z);
    }

    public boolean d() {
        return this.f331a != null;
    }

    public void e(boolean z) {
        this.f332a.set(4, z);
    }

    public boolean e() {
        return this.f334b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fa)) {
            return m468a((fa) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f332a.set(5, z);
    }

    public boolean f() {
        return this.f332a.get(3);
    }

    public boolean g() {
        return this.f336c != null;
    }

    public boolean h() {
        return this.f338d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f332a.get(4);
    }

    public boolean j() {
        return this.f332a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f329a);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("type:");
        sb.append(this.f330a);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("value:");
        sb.append(this.f333b);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("connpt:");
        String str = this.f331a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("host:");
            String str2 = this.f334b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("subvalue:");
            sb.append(this.f335c);
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("annotation:");
            String str3 = this.f336c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("user:");
            String str4 = this.f338d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("time:");
            sb.append(this.f337d);
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("clientIp:");
            sb.append(this.f339e);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
