package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* compiled from: Taobao */
public class fb implements iu<fb, Object>, Serializable, Cloneable {
    private static final jc a = new jc("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jk f340a = new jk("StatsEvents");
    private static final jc b = new jc("", (byte) 11, 2);
    private static final jc c = new jc("", (byte) 15, 3);

    /* renamed from: a  reason: collision with other field name */
    public String f341a;

    /* renamed from: a  reason: collision with other field name */
    public List<fa> f342a;

    /* renamed from: b  reason: collision with other field name */
    public String f343b;

    public fb() {
    }

    public fb(String str, List<fa> list) {
        this();
        this.f341a = str;
        this.f342a = list;
    }

    /* renamed from: a */
    public int compareTo(fb fbVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(fbVar.getClass())) {
            return getClass().getName().compareTo(fbVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m469a()).compareTo(Boolean.valueOf(fbVar.m469a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m469a() && (a4 = iv.a(this.f341a, fbVar.f341a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fbVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = iv.a(this.f343b, fbVar.f343b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fbVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = iv.a(this.f342a, fbVar.f342a)) == 0) {
            return 0;
        }
        return a2;
    }

    public fb a(String str) {
        this.f343b = str;
        return this;
    }

    public void a() {
        if (this.f341a == null) {
            throw new jg("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f342a == null) {
            throw new jg("Required field 'events' was not present! Struct: " + toString());
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
            short s = a2.f801a;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && b2 == 15) {
                        jd a3 = jfVar.m712a();
                        this.f342a = new ArrayList(a3.f802a);
                        for (int i = 0; i < a3.f802a; i++) {
                            fa faVar = new fa();
                            faVar.a(jfVar);
                            this.f342a.add(faVar);
                        }
                        jfVar.i();
                        jfVar.g();
                    }
                } else if (b2 == 11) {
                    this.f343b = jfVar.m716a();
                    jfVar.g();
                }
            } else if (b2 == 11) {
                this.f341a = jfVar.m716a();
                jfVar.g();
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a() {
        return this.f341a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a(fb fbVar) {
        if (fbVar == null) {
            return false;
        }
        boolean a2 = m469a();
        boolean a3 = fbVar.m469a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f341a.equals(fbVar.f341a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fbVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f343b.equals(fbVar.f343b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fbVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f342a.equals(fbVar.f342a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f340a);
        if (this.f341a != null) {
            jfVar.a(a);
            jfVar.a(this.f341a);
            jfVar.b();
        }
        if (this.f343b != null && b()) {
            jfVar.a(b);
            jfVar.a(this.f343b);
            jfVar.b();
        }
        if (this.f342a != null) {
            jfVar.a(c);
            jfVar.a(new jd((byte) 12, this.f342a.size()));
            for (fa faVar : this.f342a) {
                faVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.m719a();
    }

    public boolean b() {
        return this.f343b != null;
    }

    public boolean c() {
        return this.f342a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fb)) {
            return m470a((fb) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f341a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("operator:");
            String str2 = this.f343b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("events:");
        List<fa> list = this.f342a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
