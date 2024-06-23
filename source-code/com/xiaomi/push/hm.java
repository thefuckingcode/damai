package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class hm implements iu<hm, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f465a = new jk("ClientUploadData");

    /* renamed from: a  reason: collision with other field name */
    public List<hn> f466a;

    public int a() {
        List<hn> list = this.f466a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public int compareTo(hm hmVar) {
        int a2;
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m549a()).compareTo(Boolean.valueOf(hmVar.m549a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m549a() || (a2 = iv.a(this.f466a, hmVar.f466a)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m548a() {
        if (this.f466a == null) {
            throw new jg("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hn hnVar) {
        if (this.f466a == null) {
            this.f466a = new ArrayList();
        }
        this.f466a.add(hnVar);
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.m715a();
        while (true) {
            jc a2 = jfVar.m711a();
            byte b = a2.a;
            if (b == 0) {
                jfVar.f();
                m548a();
                return;
            }
            if (a2.f801a == 1 && b == 15) {
                jd a3 = jfVar.m712a();
                this.f466a = new ArrayList(a3.f802a);
                for (int i = 0; i < a3.f802a; i++) {
                    hn hnVar = new hn();
                    hnVar.a(jfVar);
                    this.f466a.add(hnVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m549a() {
        return this.f466a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m550a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean a2 = m549a();
        boolean a3 = hmVar.m549a();
        if (a2 || a3) {
            return a2 && a3 && this.f466a.equals(hmVar.f466a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m548a();
        jfVar.a(f465a);
        if (this.f466a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f466a.size()));
            for (hn hnVar : this.f466a) {
                hnVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return m550a((hm) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hn> list = this.f466a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
