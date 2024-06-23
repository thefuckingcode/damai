package com.youku.network.a;

import android.text.TextUtils;
import com.youku.httpcommunication.c;

/* compiled from: Taobao */
public abstract class a<I, O> implements b<I, O> {
    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return c.d(str);
            }
        }
        return str;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(";");
        for (int i = 0; i != split.length; i++) {
            split[i] = b(split[i]);
        }
        return TextUtils.join(";", split);
    }
}
