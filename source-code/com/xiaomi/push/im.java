package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class im implements iu<im, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f709a = new jk("XmPushActionSendMessage");
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 12, 8);
    private static final jc i = new jc("", (byte) 2, 9);
    private static final jc j = new jc("", (byte) 13, 10);
    private static final jc k = new jc("", (byte) 11, 11);
    private static final jc l = new jc("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    public hv f710a;

    /* renamed from: a  reason: collision with other field name */
    public hy f711a;

    /* renamed from: a  reason: collision with other field name */
    public String f712a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f713a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f714a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f715a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f716b;

    /* renamed from: c  reason: collision with other field name */
    public String f717c;

    /* renamed from: d  reason: collision with other field name */
    public String f718d;

    /* renamed from: e  reason: collision with other field name */
    public String f719e;

    /* renamed from: f  reason: collision with other field name */
    public String f720f;

    /* renamed from: g  reason: collision with other field name */
    public String f721g;

    /* renamed from: h  reason: collision with other field name */
    public String f722h;

    /* renamed from: a */
    public int compareTo(im imVar) {
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
        if (!getClass().equals(imVar.getClass())) {
            return getClass().getName().compareTo(imVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m657a()).compareTo(Boolean.valueOf(imVar.m657a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m657a() && (a13 = iv.a(this.f712a, imVar.f712a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(m659b()).compareTo(Boolean.valueOf(imVar.m659b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m659b() && (a12 = iv.a(this.f711a, imVar.f711a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(m660c()).compareTo(Boolean.valueOf(imVar.m660c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m660c() && (a11 = iv.a(this.f716b, imVar.f716b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(m661d()).compareTo(Boolean.valueOf(imVar.m661d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m661d() && (a10 = iv.a(this.f717c, imVar.f717c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(m662e()).compareTo(Boolean.valueOf(imVar.m662e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m662e() && (a9 = iv.a(this.f718d, imVar.f718d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(m663f()).compareTo(Boolean.valueOf(imVar.m663f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m663f() && (a8 = iv.a(this.f719e, imVar.f719e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = iv.a(this.f720f, imVar.f720f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = iv.a(this.f710a, imVar.f710a)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = iv.a(this.f715a, imVar.f715a)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = iv.a(this.f714a, imVar.f714a)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = iv.a(this.f721g, imVar.f721g)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = iv.a(this.f722h, imVar.f722h)) == 0) {
            return 0;
        }
        return a2;
    }

    public hv a() {
        return this.f710a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m655a() {
        return this.f716b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m656a() {
        if (this.f716b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f717c == null) {
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
                m656a();
                return;
            }
            switch (a2.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f712a = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f711a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f716b = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f717c = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f718d = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f719e = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f720f = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hv hvVar = new hv();
                        this.f710a = hvVar;
                        hvVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f715a = jfVar.m720a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je a3 = jfVar.m713a();
                        this.f714a = new HashMap(a3.f803a * 2);
                        for (int i2 = 0; i2 < a3.f803a; i2++) {
                            this.f714a.put(jfVar.m716a(), jfVar.m716a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f721g = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f722h = jfVar.m716a();
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
        this.f713a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m657a() {
        return this.f712a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m658a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean a2 = m657a();
        boolean a3 = imVar.m657a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f712a.equals(imVar.f712a))) {
            return false;
        }
        boolean b2 = m659b();
        boolean b3 = imVar.m659b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f711a.m595a(imVar.f711a))) {
            return false;
        }
        boolean c2 = m660c();
        boolean c3 = imVar.m660c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f716b.equals(imVar.f716b))) {
            return false;
        }
        boolean d2 = m661d();
        boolean d3 = imVar.m661d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f717c.equals(imVar.f717c))) {
            return false;
        }
        boolean e2 = m662e();
        boolean e3 = imVar.m662e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f718d.equals(imVar.f718d))) {
            return false;
        }
        boolean f2 = m663f();
        boolean f3 = imVar.m663f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f719e.equals(imVar.f719e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f720f.equals(imVar.f720f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f710a.m578a(imVar.f710a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f715a != imVar.f715a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f714a.equals(imVar.f714a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f721g.equals(imVar.f721g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f722h.equals(imVar.f722h);
        }
        return true;
    }

    public String b() {
        return this.f717c;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m656a();
        jfVar.a(f709a);
        if (this.f712a != null && m657a()) {
            jfVar.a(a);
            jfVar.a(this.f712a);
            jfVar.b();
        }
        if (this.f711a != null && m659b()) {
            jfVar.a(b);
            this.f711a.b(jfVar);
            jfVar.b();
        }
        if (this.f716b != null) {
            jfVar.a(c);
            jfVar.a(this.f716b);
            jfVar.b();
        }
        if (this.f717c != null) {
            jfVar.a(d);
            jfVar.a(this.f717c);
            jfVar.b();
        }
        if (this.f718d != null && m662e()) {
            jfVar.a(e);
            jfVar.a(this.f718d);
            jfVar.b();
        }
        if (this.f719e != null && m663f()) {
            jfVar.a(f);
            jfVar.a(this.f719e);
            jfVar.b();
        }
        if (this.f720f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f720f);
            jfVar.b();
        }
        if (this.f710a != null && h()) {
            jfVar.a(h);
            this.f710a.b(jfVar);
            jfVar.b();
        }
        if (i()) {
            jfVar.a(i);
            jfVar.a(this.f715a);
            jfVar.b();
        }
        if (this.f714a != null && j()) {
            jfVar.a(j);
            jfVar.a(new je((byte) 11, (byte) 11, this.f714a.size()));
            for (Map.Entry<String, String> entry : this.f714a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (this.f721g != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f721g);
            jfVar.b();
        }
        if (this.f722h != null && l()) {
            jfVar.a(l);
            jfVar.a(this.f722h);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m659b() {
        return this.f711a != null;
    }

    public String c() {
        return this.f719e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m660c() {
        return this.f716b != null;
    }

    public String d() {
        return this.f720f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m661d() {
        return this.f717c != null;
    }

    public String e() {
        return this.f721g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m662e() {
        return this.f718d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m658a((im) obj);
        }
        return false;
    }

    public String f() {
        return this.f722h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m663f() {
        return this.f719e != null;
    }

    public boolean g() {
        return this.f720f != null;
    }

    public boolean h() {
        return this.f710a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f713a.get(0);
    }

    public boolean j() {
        return this.f714a != null;
    }

    public boolean k() {
        return this.f721g != null;
    }

    public boolean l() {
        return this.f722h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m657a()) {
            sb.append("debug:");
            String str = this.f712a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m659b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f711a;
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
        String str2 = this.f716b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f717c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m662e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str4 = this.f718d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m663f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str5 = this.f719e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str6 = this.f720f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("message:");
            hv hvVar = this.f710a;
            if (hvVar == null) {
                sb.append("null");
            } else {
                sb.append(hvVar);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("needAck:");
            sb.append(this.f715a);
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("params:");
            Map<String, String> map = this.f714a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f721g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("userAccount:");
            String str8 = this.f722h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
