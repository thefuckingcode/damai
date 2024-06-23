package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
@Deprecated
/* compiled from: Taobao */
public class go extends ii {
    private Map<String, String> d = new HashMap();
    private String e;
    private Map<String, String> f = new HashMap();

    go() {
    }

    /* access modifiers changed from: package-private */
    public void a(Map<String, String> map) {
        this.d.clear();
        this.d.putAll(map);
    }

    /* access modifiers changed from: package-private */
    public void b(Map<String, String> map) {
        this.f.clear();
        this.f.putAll(map);
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return this.f;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        return this.d;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.e = str;
    }
}
