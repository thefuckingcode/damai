package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
public final class jv extends ie {
    Map<String, String> f = null;
    String g = "";
    String h = "";
    byte[] i = null;
    byte[] j = null;
    boolean k = false;
    String l = null;
    Map<String, String> m = null;
    boolean n = false;
    private String o = "";

    public jv(Context context, gm gmVar) {
        super(context, gmVar);
    }

    public final void a() {
        this.k = true;
    }

    public final void a(String str) {
        this.l = str;
    }

    public final void a(Map<String, String> map) {
        this.m = map;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final void b(Map<String, String> map) {
        this.f = map;
    }

    public final void b(byte[] bArr) {
        this.i = bArr;
    }

    public final void c(String str) {
        this.h = str;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final byte[] e() {
        return this.i;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final byte[] f() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ii
    public final String getIPDNSName() {
        return this.o;
    }

    @Override // com.amap.api.mapcore.util.ii, com.amap.api.mapcore.util.gj
    public final String getIPV6URL() {
        return this.h;
    }

    @Override // com.amap.api.mapcore.util.ie, com.amap.api.mapcore.util.ii
    public final Map<String, String> getParams() {
        return this.m;
    }

    @Override // com.amap.api.mapcore.util.ii
    public final Map<String, String> getRequestHead() {
        return this.f;
    }

    @Override // com.amap.api.mapcore.util.ii
    public final String getURL() {
        return this.g;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final boolean h() {
        return this.k;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final String j() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ie
    public final boolean k() {
        return this.n;
    }

    public final void l() {
        this.n = true;
    }
}
