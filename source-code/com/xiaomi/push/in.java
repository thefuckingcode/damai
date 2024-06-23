package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class in implements iu<in, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f723a = new jk("XmPushActionSubscription");
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 15, 8);

    /* renamed from: a  reason: collision with other field name */
    public hy f724a;

    /* renamed from: a  reason: collision with other field name */
    public String f725a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f726a;

    /* renamed from: b  reason: collision with other field name */
    public String f727b;

    /* renamed from: c  reason: collision with other field name */
    public String f728c;

    /* renamed from: d  reason: collision with other field name */
    public String f729d;

    /* renamed from: e  reason: collision with other field name */
    public String f730e;

    /* renamed from: f  reason: collision with other field name */
    public String f731f;

    /* renamed from: a */
    public int compareTo(in inVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(inVar.getClass())) {
            return getClass().getName().compareTo(inVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m664a()).compareTo(Boolean.valueOf(inVar.m664a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m664a() && (a9 = iv.a(this.f725a, inVar.f725a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = iv.a(this.f724a, inVar.f724a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = iv.a(this.f727b, inVar.f727b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = iv.a(this.f728c, inVar.f728c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = iv.a(this.f729d, inVar.f729d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = iv.a(this.f730e, inVar.f730e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = iv.a(this.f731f, inVar.f731f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = iv.a(this.f726a, inVar.f726a)) == 0) {
            return 0;
        }
        return a2;
    }

    public in a(String str) {
        this.f727b = str;
        return this;
    }

    public void a() {
        if (this.f727b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f728c == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f729d == null) {
            throw new jg("Required field 'topic' was not present! Struct: " + toString());
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
                        this.f725a = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f724a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f727b = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f728c = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f729d = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f730e = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f731f = jfVar.m716a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jd a3 = jfVar.m712a();
                        this.f726a = new ArrayList(a3.f802a);
                        for (int i = 0; i < a3.f802a; i++) {
                            this.f726a.add(jfVar.m716a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m664a() {
        return this.f725a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m665a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean a2 = m664a();
        boolean a3 = inVar.m664a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f725a.equals(inVar.f725a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f724a.m595a(inVar.f724a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f727b.equals(inVar.f727b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f728c.equals(inVar.f728c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = inVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f729d.equals(inVar.f729d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f730e.equals(inVar.f730e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f731f.equals(inVar.f731f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f726a.equals(inVar.f726a);
        }
        return true;
    }

    public in b(String str) {
        this.f728c = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f723a);
        if (this.f725a != null && m664a()) {
            jfVar.a(a);
            jfVar.a(this.f725a);
            jfVar.b();
        }
        if (this.f724a != null && b()) {
            jfVar.a(b);
            this.f724a.b(jfVar);
            jfVar.b();
        }
        if (this.f727b != null) {
            jfVar.a(c);
            jfVar.a(this.f727b);
            jfVar.b();
        }
        if (this.f728c != null) {
            jfVar.a(d);
            jfVar.a(this.f728c);
            jfVar.b();
        }
        if (this.f729d != null) {
            jfVar.a(e);
            jfVar.a(this.f729d);
            jfVar.b();
        }
        if (this.f730e != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f730e);
            jfVar.b();
        }
        if (this.f731f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f731f);
            jfVar.b();
        }
        if (this.f726a != null && h()) {
            jfVar.a(h);
            jfVar.a(new jd((byte) 11, this.f726a.size()));
            for (String str : this.f726a) {
                jfVar.a(str);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean b() {
        return this.f724a != null;
    }

    public in c(String str) {
        this.f729d = str;
        return this;
    }

    public boolean c() {
        return this.f727b != null;
    }

    public in d(String str) {
        this.f730e = str;
        return this;
    }

    public boolean d() {
        return this.f728c != null;
    }

    public in e(String str) {
        this.f731f = str;
        return this;
    }

    public boolean e() {
        return this.f729d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m665a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f730e != null;
    }

    public boolean g() {
        return this.f731f != null;
    }

    public boolean h() {
        return this.f726a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m664a()) {
            sb.append("debug:");
            String str = this.f725a;
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
            hy hyVar = this.f724a;
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
        String str2 = this.f727b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f728c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("topic:");
        String str4 = this.f729d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f730e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str6 = this.f731f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliases:");
            List<String> list = this.f726a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
