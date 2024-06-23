package com.ali.user.open.core.util;

/* compiled from: Taobao */
public class Validate {
    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }
}
