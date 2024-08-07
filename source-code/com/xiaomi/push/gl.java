package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import tb.gl1;

/* compiled from: Taobao */
public class gl extends gn {
    private a a = a.a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f425a = new HashMap();

    /* compiled from: Taobao */
    public static class a {
        public static final a a = new a(gl1.TYPE_OPEN_URL_METHOD_GET);
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f426a;

        private a(String str) {
            this.f426a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f426a;
        }
    }

    public gl() {
    }

    public gl(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn
    /* renamed from: a  reason: collision with other method in class */
    public a m518a() {
        return this.a;
    }

    @Override // com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn
    /* renamed from: a  reason: collision with other method in class */
    public String m519a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(gy.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(gy.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(gy.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f425a.entrySet()) {
            sb.append(gy.a(entry.getKey()));
            sb.append("=\"");
            sb.append(gy.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(m518a());
            str = "\">";
        }
        sb.append(str);
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        gr a2 = m521a();
        if (a2 != null) {
            sb.append(a2.m526a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.a;
        }
        this.a = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.f425a.putAll(map);
    }

    @Override // com.xiaomi.push.gn
    public String b() {
        return null;
    }
}
