package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
public class my {
    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        long j = (long) length;
        if (length <= 96) {
            int i = length & -4;
            int i2 = 0;
            while (i2 < i) {
                j = (j * 67503105) + ((long) (str.charAt(i2) * 769)) + ((long) (str.charAt(i2 + 1) * 513)) + ((long) (str.charAt(i2 + 2) * 257)) + ((long) str.charAt(i2 + 3));
                i2 += 4;
            }
            while (i2 < length) {
                j = (j * 257) + ((long) str.charAt(i2));
                i2++;
            }
        }
        return j + (j << (length & 31));
    }
}
