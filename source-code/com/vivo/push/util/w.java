package com.vivo.push.util;

import android.content.Context;
import tb.ok1;

/* compiled from: Taobao */
public final class w extends b {
    private static w b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w();
            }
            wVar = b;
        }
        return wVar;
    }

    public final synchronized void a(Context context) {
        if (this.a == null) {
            this.a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c = c(b("com.vivo.push.secure_cache_iv", ""));
        if (c == null || c.length <= 0) {
            return new byte[]{ok1.OP_CREATE_ARRAY, 32, ok1.OP_CREATE_JSON, ok1.OP_UNARY_MIN, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_JSON, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_CALL_DX_PARSER, ok1.OP_INSERT_VALUE, 32, 32, 32};
        }
        return c;
    }

    public final byte[] d() {
        byte[] c = c(b("com.vivo.push.secure_cache_key", ""));
        if (c == null || c.length <= 0) {
            return new byte[]{ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, 32, ok1.OP_GOTO, ok1.OP_UNARY_MIN, ok1.OP_INSERT_KVPAIR, ok1.OP_INSERT_VALUE, ok1.OP_CREATE_ARRAY, ok1.OP_CREATE_JSON};
        }
        return c;
    }

    private static byte[] c(String str) {
        int i;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i = split.length;
            } else {
                i = 0;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = Byte.parseByte(split[i2].trim());
            }
        } catch (Exception e) {
            p.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr;
    }
}
