package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class hn implements iu<hn, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f467a = new jk("ClientUploadDataItem");
    private static final jc b = new jc("", (byte) 11, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 10, 4);
    private static final jc e = new jc("", (byte) 10, 5);
    private static final jc f = new jc("", (byte) 2, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 11, 8);
    private static final jc i = new jc("", (byte) 11, 9);
    private static final jc j = new jc("", (byte) 13, 10);
    private static final jc k = new jc("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f468a;

    /* renamed from: a  reason: collision with other field name */
    public String f469a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f470a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f471a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f472a;

    /* renamed from: b  reason: collision with other field name */
    public long f473b;

    /* renamed from: b  reason: collision with other field name */
    public String f474b;

    /* renamed from: c  reason: collision with other field name */
    public String f475c;

    /* renamed from: d  reason: collision with other field name */
    public String f476d;

    /* renamed from: e  reason: collision with other field name */
    public String f477e;

    /* renamed from: f  reason: collision with other field name */
    public String f478f;

    /* renamed from: g  reason: collision with other field name */
    public String f479g;

    /* renamed from: a */
    public int compareTo(hn hnVar) {
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
        if (!getClass().equals(hnVar.getClass())) {
            return getClass().getName().compareTo(hnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m555a()).compareTo(Boolean.valueOf(hnVar.m555a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m555a() && (a12 = iv.a(this.f469a, hnVar.f469a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(m557b()).compareTo(Boolean.valueOf(hnVar.m557b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m557b() && (a11 = iv.a(this.f474b, hnVar.f474b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(m558c()).compareTo(Boolean.valueOf(hnVar.m558c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m558c() && (a10 = iv.a(this.f475c, hnVar.f475c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(m559d()).compareTo(Boolean.valueOf(hnVar.m559d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m559d() && (a9 = iv.a(this.f468a, hnVar.f468a)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(m560e()).compareTo(Boolean.valueOf(hnVar.m560e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m560e() && (a8 = iv.a(this.f473b, hnVar.f473b)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = iv.a(this.f472a, hnVar.f472a)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = iv.a(this.f476d, hnVar.f476d)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = iv.a(this.f477e, hnVar.f477e)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = iv.a(this.f478f, hnVar.f478f)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hnVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a3 = iv.a(this.f471a, hnVar.f471a)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hnVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (a2 = iv.a(this.f479g, hnVar.f479g)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f473b;
    }

    public hn a(long j2) {
        this.f468a = j2;
        m554a(true);
        return this;
    }

    public hn a(String str) {
        this.f469a = str;
        return this;
    }

    public hn a(Map<String, String> map) {
        this.f471a = map;
        return this;
    }

    public hn a(boolean z) {
        this.f472a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m551a() {
        return this.f469a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m552a() {
        return this.f471a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m553a() {
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.m715a();
        while (true) {
            jc a2 = jfVar.m711a();
            byte b2 = a2.a;
            if (b2 == 0) {
                jfVar.f();
                m553a();
                return;
            }
            switch (a2.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f469a = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f474b = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f475c = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f468a = jfVar.m710a();
                        m554a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f473b = jfVar.m710a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f472a = jfVar.m720a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f476d = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f477e = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f478f = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je a3 = jfVar.m713a();
                        this.f471a = new HashMap(a3.f803a * 2);
                        for (int i2 = 0; i2 < a3.f803a; i2++) {
                            this.f471a.put(jfVar.m716a(), jfVar.m716a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f479g = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f471a == null) {
            this.f471a = new HashMap();
        }
        this.f471a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m554a(boolean z) {
        this.f470a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m555a() {
        return this.f469a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m556a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean a2 = m555a();
        boolean a3 = hnVar.m555a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f469a.equals(hnVar.f469a))) {
            return false;
        }
        boolean b2 = m557b();
        boolean b3 = hnVar.m557b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f474b.equals(hnVar.f474b))) {
            return false;
        }
        boolean c2 = m558c();
        boolean c3 = hnVar.m558c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f475c.equals(hnVar.f475c))) {
            return false;
        }
        boolean d2 = m559d();
        boolean d3 = hnVar.m559d();
        if ((d2 || d3) && (!d2 || !d3 || this.f468a != hnVar.f468a)) {
            return false;
        }
        boolean e2 = m560e();
        boolean e3 = hnVar.m560e();
        if ((e2 || e3) && (!e2 || !e3 || this.f473b != hnVar.f473b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hnVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f472a != hnVar.f472a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hnVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f476d.equals(hnVar.f476d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hnVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f477e.equals(hnVar.f477e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hnVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f478f.equals(hnVar.f478f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hnVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f471a.equals(hnVar.f471a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hnVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f479g.equals(hnVar.f479g);
        }
        return true;
    }

    public hn b(long j2) {
        this.f473b = j2;
        b(true);
        return this;
    }

    public hn b(String str) {
        this.f474b = str;
        return this;
    }

    public String b() {
        return this.f475c;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m553a();
        jfVar.a(f467a);
        if (this.f469a != null && m555a()) {
            jfVar.a(a);
            jfVar.a(this.f469a);
            jfVar.b();
        }
        if (this.f474b != null && m557b()) {
            jfVar.a(b);
            jfVar.a(this.f474b);
            jfVar.b();
        }
        if (this.f475c != null && m558c()) {
            jfVar.a(c);
            jfVar.a(this.f475c);
            jfVar.b();
        }
        if (m559d()) {
            jfVar.a(d);
            jfVar.a(this.f468a);
            jfVar.b();
        }
        if (m560e()) {
            jfVar.a(e);
            jfVar.a(this.f473b);
            jfVar.b();
        }
        if (f()) {
            jfVar.a(f);
            jfVar.a(this.f472a);
            jfVar.b();
        }
        if (this.f476d != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f476d);
            jfVar.b();
        }
        if (this.f477e != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f477e);
            jfVar.b();
        }
        if (this.f478f != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f478f);
            jfVar.b();
        }
        if (this.f471a != null && j()) {
            jfVar.a(j);
            jfVar.a(new je((byte) 11, (byte) 11, this.f471a.size()));
            for (Map.Entry<String, String> entry : this.f471a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (this.f479g != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f479g);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public void b(boolean z) {
        this.f470a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m557b() {
        return this.f474b != null;
    }

    public hn c(String str) {
        this.f475c = str;
        return this;
    }

    public String c() {
        return this.f477e;
    }

    public void c(boolean z) {
        this.f470a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m558c() {
        return this.f475c != null;
    }

    public hn d(String str) {
        this.f476d = str;
        return this;
    }

    public String d() {
        return this.f478f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m559d() {
        return this.f470a.get(0);
    }

    public hn e(String str) {
        this.f477e = str;
        return this;
    }

    public String e() {
        return this.f479g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m560e() {
        return this.f470a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m556a((hn) obj);
        }
        return false;
    }

    public hn f(String str) {
        this.f478f = str;
        return this;
    }

    public boolean f() {
        return this.f470a.get(2);
    }

    public hn g(String str) {
        this.f479g = str;
        return this;
    }

    public boolean g() {
        return this.f476d != null;
    }

    public boolean h() {
        return this.f477e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f478f != null;
    }

    public boolean j() {
        return this.f471a != null;
    }

    public boolean k() {
        return this.f479g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m555a()) {
            sb.append("channel:");
            String str = this.f469a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m557b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("data:");
            String str2 = this.f474b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m558c()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("name:");
            String str3 = this.f475c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m559d()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("counter:");
            sb.append(this.f468a);
            z = false;
        }
        if (m560e()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("timestamp:");
            sb.append(this.f473b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("fromSdk:");
            sb.append(this.f472a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("category:");
            String str4 = this.f476d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("sourcePackage:");
            String str5 = this.f477e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("id:");
            String str6 = this.f478f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("extra:");
            Map<String, String> map = this.f471a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("pkgName:");
            String str7 = this.f479g;
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
