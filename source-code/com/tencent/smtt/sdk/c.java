package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.IOException;
import java.util.UnknownFormatConversionException;

/* compiled from: OatHelper */
public class c {
    static int a = 5;
    static int b = 16;
    static char[] c = new char[16];
    static String d = "dex2oat-cmdline";
    static long e = 4096;

    public static String a(Context context, String str) throws Exception {
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(str);
        cVar.a(c);
        boolean z = true;
        if (c[a] != 1) {
            z = false;
        }
        cVar.a(z);
        cVar.a(e);
        return a(new String(a(cVar)));
    }

    private static String a(String str) {
        String[] split = str.split(new String("\u0000"));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            int i3 = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(d)) {
                return str3;
            }
            i = i3;
        }
        return "";
    }

    public static char[] a(com.tencent.smtt.utils.c cVar) throws IOException {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        cVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            cVar.a(cArr2);
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            if (cArr2[1] <= '4') {
                cVar.b();
                cVar.b();
                cVar.b();
            }
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            char[] cArr3 = new char[cVar.b()];
            cVar.a(cArr3);
            return cArr3;
        }
        throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])));
    }
}
