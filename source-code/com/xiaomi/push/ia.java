package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class ia implements iu<ia, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f574a = new jk("XmPushActionAckNotification");
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 10, 7);
    private static final jc g = new jc("", (byte) 11, 8);
    private static final jc h = new jc("", (byte) 13, 9);
    private static final jc i = new jc("", (byte) 11, 10);
    private static final jc j = new jc("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f575a = 0;

    /* renamed from: a  reason: collision with other field name */
    public hy f576a;

    /* renamed from: a  reason: collision with other field name */
    public String f577a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f578a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f579a;

    /* renamed from: b  reason: collision with other field name */
    public String f580b;

    /* renamed from: c  reason: collision with other field name */
    public String f581c;

    /* renamed from: d  reason: collision with other field name */
    public String f582d;

    /* renamed from: e  reason: collision with other field name */
    public String f583e;

    /* renamed from: f  reason: collision with other field name */
    public String f584f;

    /* renamed from: g  reason: collision with other field name */
    public String f585g;

    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        if (!getClass().equals(iaVar.getClass())) {
            return getClass().getName().compareTo(iaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m600a()).compareTo(Boolean.valueOf(iaVar.m600a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m600a() && (a11 = iv.a(this.f577a, iaVar.f577a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m602b()).compareTo(Boolean.valueOf(iaVar.m602b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m602b() && (a10 = iv.a(this.f576a, iaVar.f576a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = iv.a(this.f580b, iaVar.f580b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = iv.a(this.f581c, iaVar.f581c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = iv.a(this.f582d, iaVar.f582d)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = iv.a(this.f575a, iaVar.f575a)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = iv.a(this.f583e, iaVar.f583e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = iv.a(this.f579a, iaVar.f579a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = iv.a(this.f584f, iaVar.f584f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = iv.a(this.f585g, iaVar.f585g)) == 0) {
            return 0;
        }
        return a2;
    }

    public ia a(long j2) {
        this.f575a = j2;
        a(true);
        return this;
    }

    public ia a(hy hyVar) {
        this.f576a = hyVar;
        return this;
    }

    public ia a(String str) {
        this.f580b = str;
        return this;
    }

    public String a() {
        return this.f580b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m598a() {
        return this.f579a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m599a() {
        if (this.f580b == null) {
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
                m599a();
                return;
            }
            switch (a2.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f577a = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f576a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f580b = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f581c = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f582d = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f575a = jfVar.m710a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f583e = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        je a3 = jfVar.m713a();
                        this.f579a = new HashMap(a3.f803a * 2);
                        for (int i2 = 0; i2 < a3.f803a; i2++) {
                            this.f579a.put(jfVar.m716a(), jfVar.m716a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f584f = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f585g = jfVar.m716a();
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
        this.f578a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m600a() {
        return this.f577a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m601a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean a2 = m600a();
        boolean a3 = iaVar.m600a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f577a.equals(iaVar.f577a))) {
            return false;
        }
        boolean b2 = m602b();
        boolean b3 = iaVar.m602b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f576a.m595a(iaVar.f576a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iaVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f580b.equals(iaVar.f580b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f581c.equals(iaVar.f581c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iaVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f582d.equals(iaVar.f582d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f575a != iaVar.f575a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f583e.equals(iaVar.f583e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iaVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f579a.equals(iaVar.f579a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f584f.equals(iaVar.f584f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f585g.equals(iaVar.f585g);
        }
        return true;
    }

    public ia b(String str) {
        this.f581c = str;
        return this;
    }

    public String b() {
        return this.f582d;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m599a();
        jfVar.a(f574a);
        if (this.f577a != null && m600a()) {
            jfVar.a(a);
            jfVar.a(this.f577a);
            jfVar.b();
        }
        if (this.f576a != null && m602b()) {
            jfVar.a(b);
            this.f576a.b(jfVar);
            jfVar.b();
        }
        if (this.f580b != null) {
            jfVar.a(c);
            jfVar.a(this.f580b);
            jfVar.b();
        }
        if (this.f581c != null && d()) {
            jfVar.a(d);
            jfVar.a(this.f581c);
            jfVar.b();
        }
        if (this.f582d != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f582d);
            jfVar.b();
        }
        if (f()) {
            jfVar.a(f);
            jfVar.a(this.f575a);
            jfVar.b();
        }
        if (this.f583e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f583e);
            jfVar.b();
        }
        if (this.f579a != null && h()) {
            jfVar.a(h);
            jfVar.a(new je((byte) 11, (byte) 11, this.f579a.size()));
            for (Map.Entry<String, String> entry : this.f579a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (this.f584f != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f584f);
            jfVar.b();
        }
        if (this.f585g != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f585g);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m602b() {
        return this.f576a != null;
    }

    public ia c(String str) {
        this.f582d = str;
        return this;
    }

    public boolean c() {
        return this.f580b != null;
    }

    public ia d(String str) {
        this.f583e = str;
        return this;
    }

    public boolean d() {
        return this.f581c != null;
    }

    public ia e(String str) {
        this.f584f = str;
        return this;
    }

    public boolean e() {
        return this.f582d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m601a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f578a.get(0);
    }

    public boolean g() {
        return this.f583e != null;
    }

    public boolean h() {
        return this.f579a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f584f != null;
    }

    public boolean j() {
        return this.f585g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m600a()) {
            sb.append("debug:");
            String str = this.f577a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m602b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f576a;
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
        String str2 = this.f580b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appId:");
            String str3 = this.f581c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("type:");
            String str4 = this.f582d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("errorCode:");
            sb.append(this.f575a);
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str5 = this.f583e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("extra:");
            Map<String, String> map = this.f579a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f584f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f585g;
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
