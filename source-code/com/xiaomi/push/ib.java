package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jl1;

/* compiled from: Taobao */
public class ib implements iu<ib, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f586a = new jk("XmPushActionCheckClientInfo");
    private static final jc b = new jc("", (byte) 8, 2);

    /* renamed from: a  reason: collision with other field name */
    public int f587a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f588a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f589b;

    /* renamed from: a */
    public int compareTo(ib ibVar) {
        int a2;
        int a3;
        if (!getClass().equals(ibVar.getClass())) {
            return getClass().getName().compareTo(ibVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m603a()).compareTo(Boolean.valueOf(ibVar.m603a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m603a() && (a3 = iv.a(this.f587a, ibVar.f587a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (a2 = iv.a(this.f589b, ibVar.f589b)) == 0) {
            return 0;
        }
        return a2;
    }

    public ib a(int i) {
        this.f587a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.m715a();
        while (true) {
            jc a2 = jfVar.m711a();
            byte b2 = a2.a;
            if (b2 == 0) {
                break;
            }
            short s = a2.f801a;
            if (s != 1) {
                if (s == 2 && b2 == 8) {
                    this.f589b = jfVar.m709a();
                    b(true);
                    jfVar.g();
                }
            } else if (b2 == 8) {
                this.f587a = jfVar.m709a();
                a(true);
                jfVar.g();
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
        jfVar.f();
        if (!m603a()) {
            throw new jg("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new jg("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f588a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m603a() {
        return this.f588a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m604a(ib ibVar) {
        return ibVar != null && this.f587a == ibVar.f587a && this.f589b == ibVar.f589b;
    }

    public ib b(int i) {
        this.f589b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f586a);
        jfVar.a(a);
        jfVar.a(this.f587a);
        jfVar.b();
        jfVar.a(b);
        jfVar.a(this.f589b);
        jfVar.b();
        jfVar.c();
        jfVar.m719a();
    }

    public void b(boolean z) {
        this.f588a.set(1, z);
    }

    public boolean b() {
        return this.f588a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m604a((ib) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(" + "miscConfigVersion:" + this.f587a + AVFSCacheConstants.COMMA_SEP + "pluginConfigVersion:" + this.f589b + jl1.BRACKET_END_STR;
    }
}
