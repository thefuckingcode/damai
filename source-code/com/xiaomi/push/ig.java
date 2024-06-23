package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class ig implements iu<ig, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f626a = new jk("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f627a;

    /* renamed from: a */
    public int compareTo(ig igVar) {
        int a2;
        if (!getClass().equals(igVar.getClass())) {
            return getClass().getName().compareTo(igVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m627a()).compareTo(Boolean.valueOf(igVar.m627a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m627a() || (a2 = iv.a(this.f627a, igVar.f627a)) == 0) {
            return 0;
        }
        return a2;
    }

    public List<hu> a() {
        return this.f627a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m626a() {
        if (this.f627a == null) {
            throw new jg("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.m715a();
        while (true) {
            jc a2 = jfVar.m711a();
            byte b = a2.a;
            if (b == 0) {
                jfVar.f();
                m626a();
                return;
            }
            if (a2.f801a == 1 && b == 15) {
                jd a3 = jfVar.m712a();
                this.f627a = new ArrayList(a3.f802a);
                for (int i = 0; i < a3.f802a; i++) {
                    hu huVar = new hu();
                    huVar.a(jfVar);
                    this.f627a.add(huVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m627a() {
        return this.f627a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m628a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean a2 = m627a();
        boolean a3 = igVar.m627a();
        if (a2 || a3) {
            return a2 && a3 && this.f627a.equals(igVar.f627a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m626a();
        jfVar.a(f626a);
        if (this.f627a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f627a.size()));
            for (hu huVar : this.f627a) {
                huVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m628a((ig) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hu> list = this.f627a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
