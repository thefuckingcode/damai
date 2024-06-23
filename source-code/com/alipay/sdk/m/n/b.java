package com.alipay.sdk.m.n;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Taobao */
public class b {
    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|(2:10|(1:12)(1:43))|13|14|15|16|17|(2:18|19)|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC, Splitter:B:31:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0052 A[SYNTHETIC, Splitter:B:35:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0059 A[SYNTHETIC, Splitter:B:39:0x0059] */
    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th2) {
                    gZIPOutputStream = null;
                    byteArrayInputStream = byteArrayInputStream2;
                    th = th2;
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                gZIPOutputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
                th = th3;
                byteArrayOutputStream = null;
                if (byteArrayInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                if (gZIPOutputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = byteArrayInputStream2.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    gZIPOutputStream.write(bArr2, 0, read);
                }
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream2.close();
                byteArrayOutputStream.close();
                try {
                    gZIPOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Throwable th4) {
                th = th4;
                byteArrayInputStream = byteArrayInputStream2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            if (byteArrayInputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (gZIPOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(4:8|9|10|(1:12)(1:37))|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:22|23|29|30|31|32|33|34|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0045 */
    public static byte[] b(byte[] bArr) throws IOException {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr2, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            byteArrayOutputStream.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            throw th;
                        }
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArray;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
            throw th;
        }
    }
}
