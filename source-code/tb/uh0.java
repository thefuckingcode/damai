package tb;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class uh0 {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0033 A[SYNTHETIC, Splitter:B:27:0x0033] */
    public static byte[] a(Context context, String str) {
        Throwable th;
        try {
            InputStream open = context.getAssets().open(str);
            if (open == null) {
                return "".getBytes();
            }
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(open);
                try {
                    byte[] bArr = new byte[bufferedInputStream2.available()];
                    bufferedInputStream2.read(bArr);
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return bArr;
                } catch (IOException unused2) {
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    return "".getBytes();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                return "".getBytes();
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "".getBytes();
        }
    }
}
