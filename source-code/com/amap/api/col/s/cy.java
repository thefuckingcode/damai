package com.amap.api.col.s;

import com.amap.api.col.s.df;
import java.util.Map;

/* compiled from: Taobao */
public final class cy extends df {
    private byte[] a;
    private Map<String, String> b;

    public cy(byte[] bArr, Map<String, String> map) {
        this.a = bArr;
        this.b = map;
        a(df.a.SINGLE);
        a(df.c.HTTPS);
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> e() {
        return this.b;
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public final byte[] g() {
        return this.a;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
