package com.xiaomi.push;

import android.os.Bundle;
import java.util.Objects;
import tb.jl1;

/* compiled from: Taobao */
public class gp extends gn {
    private int a = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with other field name */
    private a f433a = null;

    /* renamed from: a  reason: collision with other field name */
    private b f434a = b.available;
    private String b = null;

    /* compiled from: Taobao */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* compiled from: Taobao */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public gp(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.f434a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f433a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public gp(b bVar) {
        a(bVar);
    }

    @Override // com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f434a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.a;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f433a;
        if (!(aVar == null || aVar == a.available)) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn, com.xiaomi.push.gn
    /* renamed from: a  reason: collision with other method in class */
    public String m525a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(gy.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(gy.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(gy.a(k()));
            sb.append("\"");
        }
        if (this.f434a != null) {
            sb.append(" type=\"");
            sb.append(this.f434a);
            sb.append("\"");
        }
        sb.append(jl1.G);
        if (this.b != null) {
            sb.append("<status>");
            sb.append(gy.a(this.b));
            sb.append("</status>");
        }
        if (this.a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.a);
            sb.append("</priority>");
        }
        a aVar = this.f433a;
        if (!(aVar == null || aVar == a.available)) {
            sb.append("<show>");
            sb.append(this.f433a);
            sb.append("</show>");
        }
        sb.append(o());
        gr a2 = m521a();
        if (a2 != null) {
            sb.append(a2.m526a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.a = i;
    }

    public void a(a aVar) {
        this.f433a = aVar;
    }

    public void a(b bVar) {
        Objects.requireNonNull(bVar, "Type cannot be null");
        this.f434a = bVar;
    }

    @Override // com.xiaomi.push.gn, com.xiaomi.push.gn
    public void a(String str) {
        this.b = str;
    }
}
