package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jl1;

/* compiled from: Taobao */
public class is implements iu<is, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f777a = new jk("XmPushActionUnSubscriptionResult");
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 6);
    private static final jc f = new jc("", (byte) 11, 7);
    private static final jc g = new jc("", (byte) 11, 8);
    private static final jc h = new jc("", (byte) 11, 9);
    private static final jc i = new jc("", (byte) 11, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f778a;

    /* renamed from: a  reason: collision with other field name */
    public hy f779a;

    /* renamed from: a  reason: collision with other field name */
    public String f780a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f781a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f782b;

    /* renamed from: c  reason: collision with other field name */
    public String f783c;

    /* renamed from: d  reason: collision with other field name */
    public String f784d;

    /* renamed from: e  reason: collision with other field name */
    public String f785e;

    /* renamed from: f  reason: collision with other field name */
    public String f786f;

    /* renamed from: g  reason: collision with other field name */
    public String f787g;

    /* renamed from: a */
    public int compareTo(is isVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(isVar.getClass())) {
            return getClass().getName().compareTo(isVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m679a()).compareTo(Boolean.valueOf(isVar.m679a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m679a() && (a10 = iv.a(this.f780a, isVar.f780a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m681b()).compareTo(Boolean.valueOf(isVar.m681b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m681b() && (a9 = iv.a(this.f779a, isVar.f779a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m682c()).compareTo(Boolean.valueOf(isVar.m682c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m682c() && (a8 = iv.a(this.f782b, isVar.f782b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = iv.a(this.f783c, isVar.f783c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = iv.a(this.f778a, isVar.f778a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = iv.a(this.f784d, isVar.f784d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = iv.a(this.f785e, isVar.f785e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = iv.a(this.f786f, isVar.f786f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = iv.a(this.f787g, isVar.f787g)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f782b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m678a() {
        if (this.f782b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
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
                m678a();
                return;
            }
            switch (a2.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f780a = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f779a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f782b = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f783c = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f778a = jfVar.m710a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f784d = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f785e = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f786f = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f787g = jfVar.m716a();
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
        this.f781a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m679a() {
        return this.f780a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m680a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean a2 = m679a();
        boolean a3 = isVar.m679a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f780a.equals(isVar.f780a))) {
            return false;
        }
        boolean b2 = m681b();
        boolean b3 = isVar.m681b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f779a.m595a(isVar.f779a))) {
            return false;
        }
        boolean c2 = m682c();
        boolean c3 = isVar.m682c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f782b.equals(isVar.f782b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f783c.equals(isVar.f783c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f778a != isVar.f778a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f784d.equals(isVar.f784d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f785e.equals(isVar.f785e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f786f.equals(isVar.f786f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f787g.equals(isVar.f787g);
        }
        return true;
    }

    public String b() {
        return this.f785e;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m678a();
        jfVar.a(f777a);
        if (this.f780a != null && m679a()) {
            jfVar.a(a);
            jfVar.a(this.f780a);
            jfVar.b();
        }
        if (this.f779a != null && m681b()) {
            jfVar.a(b);
            this.f779a.b(jfVar);
            jfVar.b();
        }
        if (this.f782b != null) {
            jfVar.a(c);
            jfVar.a(this.f782b);
            jfVar.b();
        }
        if (this.f783c != null && d()) {
            jfVar.a(d);
            jfVar.a(this.f783c);
            jfVar.b();
        }
        if (e()) {
            jfVar.a(e);
            jfVar.a(this.f778a);
            jfVar.b();
        }
        if (this.f784d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f784d);
            jfVar.b();
        }
        if (this.f785e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f785e);
            jfVar.b();
        }
        if (this.f786f != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f786f);
            jfVar.b();
        }
        if (this.f787g != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f787g);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m681b() {
        return this.f779a != null;
    }

    public String c() {
        return this.f787g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m682c() {
        return this.f782b != null;
    }

    public boolean d() {
        return this.f783c != null;
    }

    public boolean e() {
        return this.f781a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m680a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f784d != null;
    }

    public boolean g() {
        return this.f785e != null;
    }

    public boolean h() {
        return this.f786f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f787g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m679a()) {
            sb.append("debug:");
            String str = this.f780a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m681b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f779a;
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
        String str2 = this.f782b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appId:");
            String str3 = this.f783c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("errorCode:");
            sb.append(this.f778a);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str4 = this.f784d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str5 = this.f785e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f786f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f787g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
