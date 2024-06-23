package com.uc.crashsdk.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.uplayer.AliMediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Taobao */
public final class b {
    private static final int[] a = {126, DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH, 115, 241, 101, 198, 215, 134};
    private static final int[] b = {125, 185, 233, 226, SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, 142, 151, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_LOADING_FACTOR_STEP};
    private static final int[] c = {238, 185, 233, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD, SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, 142, 151, 167};

    public static String a(String str) {
        Throwable th;
        Exception e;
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream3.read(bArr);
                g.a(fileInputStream3);
                byte[] a2 = a(bArr, a);
                if (a2 == null || a2.length <= 0) {
                    g.a((Closeable) null);
                    return null;
                }
                int length = a2.length - 1;
                String str2 = a2[length] == 10 ? new String(a2, 0, length) : new String(a2);
                g.a((Closeable) null);
                return str2;
            } catch (Exception e2) {
                fileInputStream = fileInputStream3;
                e = e2;
                try {
                    g.a(e);
                    g.a(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    g.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream2 = fileInputStream3;
                th = th3;
                g.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            g.a(e);
            g.a(fileInputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            g.a(fileInputStream2);
            throw th;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (!(bArr == null || iArr == null || iArr.length != 8)) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[(length + 2)];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (Exception e) {
                g.a(e);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064 A[ADDED_TO_REGION] */
    public static String a(String str, String str2, boolean z) {
        byte[] e;
        boolean z2;
        String str3;
        String str4;
        boolean z3;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z4;
        Throwable th;
        if (!z || g.a(str)) {
            return str;
        }
        File file = new File(str);
        if (file.exists() && file.length() <= 3145728 && e != null && e.length > 0) {
            boolean z5 = true;
            if (z) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream.write(e);
                            byteArrayOutputStream.flush();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        gZIPOutputStream = null;
                        th = th3;
                        try {
                            g.a(th);
                            g.a(byteArrayOutputStream);
                            g.a(gZIPOutputStream);
                            e = byteArrayOutputStream.toByteArray();
                            z4 = true;
                            if (z4) {
                            }
                            return str;
                        } catch (Throwable th4) {
                            g.a(byteArrayOutputStream);
                            g.a(gZIPOutputStream);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    gZIPOutputStream = null;
                    th = th5;
                    byteArrayOutputStream = null;
                    g.a(th);
                    g.a(byteArrayOutputStream);
                    g.a(gZIPOutputStream);
                    e = byteArrayOutputStream.toByteArray();
                    z4 = true;
                    if (z4) {
                    }
                    return str;
                }
                g.a(byteArrayOutputStream);
                g.a(gZIPOutputStream);
                try {
                    e = byteArrayOutputStream.toByteArray();
                    z4 = true;
                } catch (Throwable th6) {
                    g.a(th6);
                    z4 = false;
                }
                if (z4 || e == null || e.length <= 0) {
                    return str;
                }
                str3 = str + str2;
                z2 = true;
            } else {
                str3 = str;
                z2 = false;
            }
            if (z2) {
                if (str3.equals(file.getName())) {
                    str4 = str3 + ".tmp";
                    z3 = true;
                } else {
                    str4 = str3;
                    z3 = false;
                }
                File file2 = new File(str4);
                if (!g.a(file2, e)) {
                    z5 = false;
                } else if (z3) {
                    file.delete();
                    file2.renameTo(file);
                }
                if (z5) {
                    return str3;
                }
            }
        }
        return str;
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e) {
                g.a(e);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), a);
        if (b2 == null) {
            g.a(fileOutputStream);
            return false;
        }
        try {
            fileOutputStream.write(b2);
            z = true;
        } catch (Throwable th2) {
            g.a(fileOutputStream);
            throw th2;
        }
        g.a(fileOutputStream);
        return z;
    }
}
