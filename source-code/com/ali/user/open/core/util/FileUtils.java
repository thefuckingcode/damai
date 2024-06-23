package com.ali.user.open.core.util;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/* compiled from: Taobao */
public class FileUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (0 == 0) goto L_0x0029;
     */
    public static String readFileData(Context context, String str) {
        String str2 = "";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(str);
            int available = fileInputStream.available();
            if (available > 0) {
                byte[] bArr = new byte[available];
                fileInputStream.read(bArr);
                str2 = new String(bArr, "UTF-8");
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (Exception unused3) {
        }
        return str2;
    }

    public static void writeFileData(Context context, String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            fileOutputStream.write(str2.getBytes(Charset.forName("UTF-8")));
            fileOutputStream.flush();
        } catch (Exception unused) {
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused3) {
        }
    }
}
