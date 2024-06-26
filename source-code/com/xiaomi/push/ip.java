package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jl1;

/* compiled from: Taobao */
public class ip implements iu<ip, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f743a = new jk("XmPushActionUnRegistration");
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 11, 8);
    private static final jc i = new jc("", (byte) 11, 9);
    private static final jc j = new jc("", (byte) 11, 10);
    private static final jc k = new jc("", (byte) 2, 11);
    private static final jc l = new jc("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public long f744a;

    /* renamed from: a  reason: collision with other field name */
    public hy f745a;

    /* renamed from: a  reason: collision with other field name */
    public String f746a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f747a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f748a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f749b;

    /* renamed from: c  reason: collision with other field name */
    public String f750c;

    /* renamed from: d  reason: collision with other field name */
    public String f751d;

    /* renamed from: e  reason: collision with other field name */
    public String f752e;

    /* renamed from: f  reason: collision with other field name */
    public String f753f;

    /* renamed from: g  reason: collision with other field name */
    public String f754g;

    /* renamed from: h  reason: collision with other field name */
    public String f755h;

    /* renamed from: i  reason: collision with other field name */
    public String f756i;

    /* renamed from: a */
    public int compareTo(ip ipVar) {
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
        int a12;
        int a13;
        if (!getClass().equals(ipVar.getClass())) {
            return getClass().getName().compareTo(ipVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m671a()).compareTo(Boolean.valueOf(ipVar.m671a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m671a() && (a13 = iv.a(this.f746a, ipVar.f746a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ipVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = iv.a(this.f745a, ipVar.f745a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a11 = iv.a(this.f749b, ipVar.f749b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a10 = iv.a(this.f750c, ipVar.f750c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a9 = iv.a(this.f751d, ipVar.f751d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a8 = iv.a(this.f752e, ipVar.f752e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = iv.a(this.f753f, ipVar.f753f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = iv.a(this.f754g, ipVar.f754g)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = iv.a(this.f755h, ipVar.f755h)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = iv.a(this.f756i, ipVar.f756i)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = iv.a(this.f748a, ipVar.f748a)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = iv.a(this.f744a, ipVar.f744a)) == 0) {
            return 0;
        }
        return a2;
    }

    public ip a(String str) {
        this.f749b = str;
        return this;
    }

    public void a() {
        if (this.f749b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f750c == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
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
                a();
                return;
            }
            switch (a2.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f746a = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f745a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f749b = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f750c = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f751d = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f752e = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f753f = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f754g = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f755h = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f756i = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f748a = jfVar.m720a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f744a = jfVar.m710a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z) {
        this.f747a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m671a() {
        return this.f746a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m672a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean a2 = m671a();
        boolean a3 = ipVar.m671a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f746a.equals(ipVar.f746a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ipVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f745a.m595a(ipVar.f745a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f749b.equals(ipVar.f749b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f750c.equals(ipVar.f750c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f751d.equals(ipVar.f751d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f752e.equals(ipVar.f752e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f753f.equals(ipVar.f753f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f754g.equals(ipVar.f754g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f755h.equals(ipVar.f755h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f756i.equals(ipVar.f756i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.f748a != ipVar.f748a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f744a == ipVar.f744a;
        }
        return true;
    }

    public ip b(String str) {
        this.f750c = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f743a);
        if (this.f746a != null && m671a()) {
            jfVar.a(a);
            jfVar.a(this.f746a);
            jfVar.b();
        }
        if (this.f745a != null && b()) {
            jfVar.a(b);
            this.f745a.b(jfVar);
            jfVar.b();
        }
        if (this.f749b != null) {
            jfVar.a(c);
            jfVar.a(this.f749b);
            jfVar.b();
        }
        if (this.f750c != null) {
            jfVar.a(d);
            jfVar.a(this.f750c);
            jfVar.b();
        }
        if (this.f751d != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f751d);
            jfVar.b();
        }
        if (this.f752e != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f752e);
            jfVar.b();
        }
        if (this.f753f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f753f);
            jfVar.b();
        }
        if (this.f754g != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f754g);
            jfVar.b();
        }
        if (this.f755h != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f755h);
            jfVar.b();
        }
        if (this.f756i != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f756i);
            jfVar.b();
        }
        if (k()) {
            jfVar.a(k);
            jfVar.a(this.f748a);
            jfVar.b();
        }
        if (l()) {
            jfVar.a(l);
            jfVar.a(this.f744a);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public void b(boolean z) {
        this.f747a.set(1, z);
    }

    public boolean b() {
        return this.f745a != null;
    }

    public ip c(String str) {
        this.f751d = str;
        return this;
    }

    public boolean c() {
        return this.f749b != null;
    }

    public ip d(String str) {
        this.f753f = str;
        return this;
    }

    public boolean d() {
        return this.f750c != null;
    }

    public ip e(String str) {
        this.f754g = str;
        return this;
    }

    public boolean e() {
        return this.f751d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m672a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f752e != null;
    }

    public boolean g() {
        return this.f753f != null;
    }

    public boolean h() {
        return this.f754g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f755h != null;
    }

    public boolean j() {
        return this.f756i != null;
    }

    public boolean k() {
        return this.f747a.get(0);
    }

    public boolean l() {
        return this.f747a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m671a()) {
            sb.append("debug:");
            String str = this.f746a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f745a;
            if (hyVar == null) {
                sb.append("null");
            } else {
                sb.append(hyVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        sb.append("id:");
        String str2 = this.f749b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f750c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str4 = this.f751d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appVersion:");
            String str5 = this.f752e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f753f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("token:");
            String str7 = this.f754g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("deviceId:");
            String str8 = this.f755h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str9 = this.f756i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("needAck:");
            sb.append(this.f748a);
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("createdTs:");
            sb.append(this.f744a);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
