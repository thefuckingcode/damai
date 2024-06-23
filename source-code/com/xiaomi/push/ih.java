package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class ih implements iu<ih, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f628a = new jk("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f629a;

    /* renamed from: a */
    public int compareTo(ih ihVar) {
        int a2;
        if (!getClass().equals(ihVar.getClass())) {
            return getClass().getName().compareTo(ihVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m630a()).compareTo(Boolean.valueOf(ihVar.m630a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m630a() || (a2 = iv.a(this.f629a, ihVar.f629a)) == 0) {
            return 0;
        }
        return a2;
    }

    public List<hs> a() {
        return this.f629a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m629a() {
        if (this.f629a == null) {
            throw new jg("Required field 'normalConfigs' was not present! Struct: " + toString());
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
                m629a();
                return;
            }
            if (a2.f801a == 1 && b == 15) {
                jd a3 = jfVar.m712a();
                this.f629a = new ArrayList(a3.f802a);
                for (int i = 0; i < a3.f802a; i++) {
                    hs hsVar = new hs();
                    hsVar.a(jfVar);
                    this.f629a.add(hsVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m630a() {
        return this.f629a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m631a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean a2 = m630a();
        boolean a3 = ihVar.m630a();
        if (a2 || a3) {
            return a2 && a3 && this.f629a.equals(ihVar.f629a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m629a();
        jfVar.a(f628a);
        if (this.f629a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f629a.size()));
            for (hs hsVar : this.f629a) {
                hsVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m631a((ih) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hs> list = this.f629a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
