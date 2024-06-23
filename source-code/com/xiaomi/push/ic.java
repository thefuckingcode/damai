package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class ic implements iu<ic, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f590a = new jk("XmPushActionCollectData");

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f591a;

    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        if (!getClass().equals(icVar.getClass())) {
            return getClass().getName().compareTo(icVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m605a()).compareTo(Boolean.valueOf(icVar.m605a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m605a() || (a2 = iv.a(this.f591a, icVar.f591a)) == 0) {
            return 0;
        }
        return a2;
    }

    public ic a(List<hr> list) {
        this.f591a = list;
        return this;
    }

    public void a() {
        if (this.f591a == null) {
            throw new jg("Required field 'dataCollectionItems' was not present! Struct: " + toString());
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
                a();
                return;
            }
            if (a2.f801a == 1 && b == 15) {
                jd a3 = jfVar.m712a();
                this.f591a = new ArrayList(a3.f802a);
                for (int i = 0; i < a3.f802a; i++) {
                    hr hrVar = new hr();
                    hrVar.a(jfVar);
                    this.f591a.add(hrVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m605a() {
        return this.f591a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m606a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean a2 = m605a();
        boolean a3 = icVar.m605a();
        if (a2 || a3) {
            return a2 && a3 && this.f591a.equals(icVar.f591a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f590a);
        if (this.f591a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f591a.size()));
            for (hr hrVar : this.f591a) {
                hrVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m606a((ic) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hr> list = this.f591a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
