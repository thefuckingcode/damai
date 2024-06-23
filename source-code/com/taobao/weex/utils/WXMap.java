package com.taobao.weex.utils;

import java.util.HashMap;

/* compiled from: Taobao */
public class WXMap extends HashMap<String, String> {
    public String put(String str, byte[] bArr) {
        return (String) super.put(str, new String(bArr));
    }
}
