package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jl1;

/* compiled from: Taobao */
public class hr implements iu<hr, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 10, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f486a = new jk("DataCollectionItem");
    private static final jc b = new jc("", (byte) 8, 2);
    private static final jc c = new jc("", (byte) 11, 3);

    /* renamed from: a  reason: collision with other field name */
    public long f487a;

    /* renamed from: a  reason: collision with other field name */
    public hl f488a;

    /* renamed from: a  reason: collision with other field name */
    public String f489a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f490a = new BitSet(1);

    /* renamed from: a */
    public int compareTo(hr hrVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(hrVar.getClass())) {
            return getClass().getName().compareTo(hrVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m562a()).compareTo(Boolean.valueOf(hrVar.m562a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m562a() && (a4 = iv.a(this.f487a, hrVar.f487a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hrVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = iv.a(this.f488a, hrVar.f488a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hrVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = iv.a(this.f489a, hrVar.f489a)) == 0) {
            return 0;
        }
        return a2;
    }

    public hr a(long j) {
        this.f487a = j;
        a(true);
        return this;
    }

    public hr a(hl hlVar) {
        this.f488a = hlVar;
        return this;
    }

    public hr a(String str) {
        this.f489a = str;
        return this;
    }

    public String a() {
        return this.f489a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m561a() {
        if (this.f488a == null) {
            throw new jg("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f489a == null) {
            throw new jg("Required field 'content' was not present! Struct: " + toString());
        }
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
                if (s != 2) {
                    if (s == 3 && b2 == 11) {
                        this.f489a = jfVar.m716a();
                        jfVar.g();
                    }
                } else if (b2 == 8) {
                    this.f488a = hl.a(jfVar.m709a());
                    jfVar.g();
                }
            } else if (b2 == 10) {
                this.f487a = jfVar.m710a();
                a(true);
                jfVar.g();
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
        jfVar.f();
        if (m562a()) {
            m561a();
            return;
        }
        throw new jg("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f490a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m562a() {
        return this.f490a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m563a(hr hrVar) {
        if (hrVar == null || this.f487a != hrVar.f487a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hrVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f488a.equals(hrVar.f488a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hrVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f489a.equals(hrVar.f489a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m561a();
        jfVar.a(f486a);
        jfVar.a(a);
        jfVar.a(this.f487a);
        jfVar.b();
        if (this.f488a != null) {
            jfVar.a(b);
            jfVar.a(this.f488a.a());
            jfVar.b();
        }
        if (this.f489a != null) {
            jfVar.a(c);
            jfVar.a(this.f489a);
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean b() {
        return this.f488a != null;
    }

    public boolean c() {
        return this.f489a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m563a((hr) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f487a);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("collectionType:");
        hl hlVar = this.f488a;
        if (hlVar == null) {
            sb.append("null");
        } else {
            sb.append(hlVar);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("content:");
        String str = this.f489a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
