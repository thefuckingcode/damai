package tb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Taobao */
public class ot0 {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003f A[SYNTHETIC, Splitter:B:29:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0051 A[SYNTHETIC, Splitter:B:39:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005b A[SYNTHETIC, Splitter:B:44:0x005b] */
    public static byte[] a(byte[] bArr) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        r0 = null;
        byte[] bArr2 = null;
        gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
            } catch (Exception e2) {
                e = e2;
                gZIPOutputStream = null;
                try {
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    return bArr2;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream2 = gZIPOutputStream;
                    if (gZIPOutputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (gZIPOutputStream2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr2;
            }
        } catch (Exception e7) {
            e = e7;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            e.printStackTrace();
            if (gZIPOutputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            return bArr2;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
        return bArr2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|(4:8|9|10|(1:12)(1:59))|13|14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x006b, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0048 A[SYNTHETIC, Splitter:B:34:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x004f A[SYNTHETIC, Splitter:B:38:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0056 A[SYNTHETIC, Splitter:B:42:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x005f A[SYNTHETIC, Splitter:B:49:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0066 A[SYNTHETIC, Splitter:B:53:0x0066] */
    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Throwable th;
        Throwable th2;
        GZIPInputStream gZIPInputStream2;
        byte[] bArr2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr3 = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr3, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr3, 0, read);
                        } catch (Exception unused) {
                            if (byteArrayOutputStream != null) {
                            }
                            if (gZIPInputStream != null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            if (byteArrayOutputStream2 != 0) {
                            }
                            if (gZIPInputStream != null) {
                            }
                            if (byteArrayInputStream != null) {
                            }
                            throw th;
                        }
                    }
                    byteArrayOutputStream.flush();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                } catch (Exception unused2) {
                    byteArrayOutputStream = null;
                    if (byteArrayOutputStream != null) {
                    }
                    if (gZIPInputStream != null) {
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream2 = 0;
                    th = th4;
                    if (byteArrayOutputStream2 != 0) {
                    }
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                gZIPInputStream = null;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (gZIPInputStream != null) {
                }
            } catch (Throwable th5) {
                th2 = th5;
                gZIPInputStream2 = null;
                th = th2;
                gZIPInputStream = gZIPInputStream2;
                byteArrayOutputStream2 = gZIPInputStream2;
                if (byteArrayOutputStream2 != 0) {
                }
                if (gZIPInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            gZIPInputStream = null;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused5) {
                }
            }
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException unused6) {
                }
            }
        } catch (Throwable th6) {
            th2 = th6;
            byteArrayInputStream = null;
            gZIPInputStream2 = null;
            th = th2;
            gZIPInputStream = gZIPInputStream2;
            byteArrayOutputStream2 = gZIPInputStream2;
            if (byteArrayOutputStream2 != 0) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused7) {
                }
            }
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException unused8) {
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException unused9) {
                }
            }
            throw th;
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException unused10) {
        }
        return bArr2;
    }
}
