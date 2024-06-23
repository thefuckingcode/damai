package com.alibaba.motu.tbrest.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Taobao */
public class GzipUtils {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003f A[SYNTHETIC, Splitter:B:29:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0051 A[SYNTHETIC, Splitter:B:39:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005b A[SYNTHETIC, Splitter:B:44:0x005b] */
    public static byte[] gzip(byte[] bArr) {
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003a A[SYNTHETIC, Splitter:B:25:0x003a] */
    public static byte[] gzipAndRc4Bytes(String str) {
        Throwable th;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str.getBytes("UTF-8"));
                gZIPOutputStream2.flush();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                    }
                    byte[] rc4 = RC4.rc4(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    return rc4;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byte[] rc42 = RC4.rc4(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
            return rc42;
        }
        byte[] rc422 = RC4.rc4(byteArrayOutputStream.toByteArray());
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused3) {
        }
        return rc422;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005f A[SYNTHETIC, Splitter:B:43:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0069 A[SYNTHETIC, Splitter:B:48:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x007a A[SYNTHETIC, Splitter:B:57:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0084 A[SYNTHETIC, Splitter:B:62:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x008e A[SYNTHETIC, Splitter:B:67:0x008e] */
    public static byte[] unGzip(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        Exception e;
        Throwable th2;
        GZIPInputStream gZIPInputStream2;
        byte[] bArr2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr3 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr3, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream3.write(bArr3, 0, read);
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayOutputStream2 = byteArrayOutputStream3;
                            try {
                                e.printStackTrace();
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (byteArrayInputStream != null) {
                                    byteArrayInputStream.close();
                                }
                                return bArr2;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (byteArrayOutputStream != 0) {
                                }
                                if (gZIPInputStream != null) {
                                }
                                if (byteArrayInputStream != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    byteArrayOutputStream3.flush();
                    bArr2 = byteArrayOutputStream3.toByteArray();
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                } catch (Exception e8) {
                    e = e8;
                    byteArrayOutputStream2 = null;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    return bArr2;
                } catch (Throwable th4) {
                    byteArrayOutputStream = 0;
                    th = th4;
                    if (byteArrayOutputStream != 0) {
                    }
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                gZIPInputStream = null;
                byteArrayOutputStream2 = null;
                e.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                }
                if (gZIPInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
                return bArr2;
            } catch (Throwable th5) {
                th2 = th5;
                gZIPInputStream2 = null;
                th = th2;
                gZIPInputStream = gZIPInputStream2;
                byteArrayOutputStream = gZIPInputStream2;
                if (byteArrayOutputStream != 0) {
                }
                if (gZIPInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            byteArrayOutputStream2 = null;
            e.printStackTrace();
            if (byteArrayOutputStream2 != null) {
            }
            if (gZIPInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            return bArr2;
        } catch (Throwable th6) {
            th2 = th6;
            byteArrayInputStream = null;
            gZIPInputStream2 = null;
            th = th2;
            gZIPInputStream = gZIPInputStream2;
            byteArrayOutputStream = gZIPInputStream2;
            if (byteArrayOutputStream != 0) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
        return bArr2;
    }
}
