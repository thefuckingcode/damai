package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

/* compiled from: Taobao */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            String base64 = ByteString.of((str + ":" + str2).getBytes("ISO-8859-1")).base64();
            return "Basic " + base64;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
