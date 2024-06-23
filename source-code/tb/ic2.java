package tb;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* compiled from: Taobao */
public class ic2 {
    private static final jf2 a = new jf2();
    private static String b = null;

    public static void a(jc2 jc2) {
        String a2 = a.antiTransfer(jc2);
        if (!TextUtils.equals(a2, b)) {
            b = a2;
            b(a2);
        }
    }

    private static void b(String str) {
        Throwable th;
        Exception e;
        File c = rh0.c();
        if (c != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    c.delete();
                    return;
                }
                BufferedWriter bufferedWriter = null;
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(c));
                    try {
                        bufferedWriter2.write(str, 0, str.length());
                        ej.a(bufferedWriter2);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        try {
                            s91.e(e);
                            ej.a(bufferedWriter);
                        } catch (Throwable th2) {
                            th = th2;
                            ej.a(bufferedWriter);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        ej.a(bufferedWriter);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    s91.e(e);
                    ej.a(bufferedWriter);
                }
            } catch (Throwable th4) {
                s91.e(th4);
            }
        }
    }
}
