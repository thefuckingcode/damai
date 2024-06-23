package com.alipay.sdk.m.r;

import android.text.TextUtils;

/* compiled from: Taobao */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");
    
    public String a;

    /* access modifiers changed from: public */
    a(String str) {
        this.a = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        a[] values = values();
        for (a aVar2 : values) {
            if (str.startsWith(aVar2.a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
