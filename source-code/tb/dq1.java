package tb;

import android.content.Context;
import com.alibaba.analytics.utils.a;
import java.util.Random;

/* compiled from: Taobao */
public class dq1 {
    public static String a(Context context) {
        String c = eq1.c(context);
        return zf2.f(c) ? c() : c;
    }

    public static String b(Context context) {
        String e = eq1.e(context);
        return zf2.f(e) ? c() : e;
    }

    public static final String c() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a = y11.a(currentTimeMillis);
        byte[] a2 = y11.a(nanoTime);
        byte[] a3 = y11.a(nextInt);
        byte[] a4 = y11.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a, 0, bArr, 0, 4);
        System.arraycopy(a2, 0, bArr, 4, 4);
        System.arraycopy(a3, 0, bArr, 8, 4);
        System.arraycopy(a4, 0, bArr, 12, 4);
        return a.i(bArr);
    }
}
