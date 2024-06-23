package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
public class c {
    private static final String a = "c";

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        com.huawei.hms.framework.common.Logger.w(com.huawei.hms.framework.network.grs.h.c.a, "local config file is not exist.filename is {%s}", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2);
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0050 */
    public static String a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!new File(str).isDirectory()) {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
                    IoUtils.closeSecure(open);
                    return str2;
                }
            }
        }
        IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
        IoUtils.closeSecure((InputStream) null);
        return "";
    }
}
