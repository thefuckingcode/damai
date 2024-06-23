package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
class c implements g {
    private String a = "";
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private String e = "";
    private Map<String, List<String>> f;

    public c(HttpURLConnection httpURLConnection, String str, int i, int i2, int i3, String str2) {
        Map<String, List<String>> headerFields;
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = str2;
        this.f = new HashMap();
        if (httpURLConnection != null && (headerFields = httpURLConnection.getHeaderFields()) != null) {
            this.f.putAll(headerFields);
        }
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.d;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + '\n' + "content = [" + this.a + jl1.ARRAY_END + '\n' + "responseSize = " + this.b + '\n' + "requestSize = " + this.c + '\n' + "resultCode = " + this.d + '\n' + "errorMsg = " + this.e;
    }
}
