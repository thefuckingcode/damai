package com.alibaba.android.bindingx.core.internal;

import java.util.Collections;
import java.util.Map;
import tb.ag0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class j {
    String a;
    String b;
    ag0 c;
    String d;
    String e;
    Map<String, Object> f;

    j(String str, String str2, ag0 ag0, String str3, String str4, Map<String, Object> map) {
        this.a = str;
        this.b = str2;
        this.c = ag0;
        this.d = str3;
        this.e = str4;
        if (map == null) {
            this.f = Collections.emptyMap();
        } else {
            this.f = map;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.a;
        if (str == null ? jVar.a != null : !str.equals(jVar.a)) {
            return false;
        }
        ag0 ag0 = this.c;
        if (ag0 == null ? jVar.c != null : !ag0.equals(jVar.c)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? jVar.d != null : !str2.equals(jVar.d)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null ? jVar.e != null : !str3.equals(jVar.e)) {
            return false;
        }
        Map<String, Object> map = this.f;
        Map<String, Object> map2 = jVar.f;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ag0 ag0 = this.c;
        int hashCode2 = (hashCode + (ag0 != null ? ag0.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, Object> map = this.f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode4 + i;
    }
}
