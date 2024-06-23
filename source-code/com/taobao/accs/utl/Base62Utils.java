package com.taobao.accs.utl;

/* compiled from: Taobao */
public class Base62Utils {
    private static final int BASE = 62;
    private static final String digitsChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0 || i == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (j != 0) {
            int i2 = BASE;
            sb.append(digitsChar.charAt((int) (j % ((long) i2))));
            j /= (long) i2;
        }
        return sb.reverse().toString();
    }
}
