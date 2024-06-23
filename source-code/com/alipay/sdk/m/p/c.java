package com.alipay.sdk.m.p;

import com.alipay.sdk.m.l.a;
import com.alipay.sdk.m.n.b;
import com.alipay.sdk.m.n.d;
import com.alipay.sdk.m.n.e;
import com.alipay.sdk.m.u.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

/* compiled from: Taobao */
public final class c {
    public boolean a;
    public String b = n.a(24);

    public c(boolean z) {
        this.a = z;
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        return e.b(str, bArr, str2);
    }

    public d a(b bVar, boolean z, String str) {
        byte[] bArr;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.b().getBytes();
        byte[] bytes2 = bVar.a().getBytes();
        if (z) {
            try {
                bytes2 = b.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        if (this.a) {
            bArr = a(bytes, a(this.b, a.e), b(this.b, bytes2, str));
        } else {
            bArr = a(bytes, bytes2);
        }
        return new d(z, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[SYNTHETIC, Splitter:B:29:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b A[SYNTHETIC, Splitter:B:41:0x007b] */
    public b a(d dVar, String str) {
        Throwable th;
        String str2;
        String str3;
        Exception e;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(dVar.a());
            try {
                byte[] bArr = new byte[5];
                byteArrayInputStream.read(bArr);
                byte[] bArr2 = new byte[a(new String(bArr))];
                byteArrayInputStream.read(bArr2);
                str3 = new String(bArr2);
            } catch (Exception e2) {
                e = e2;
                str3 = null;
                try {
                    com.alipay.sdk.m.u.e.a(e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    str2 = null;
                    if (str3 == null) {
                    }
                    return new b(str3, str2);
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            try {
                byte[] bArr3 = new byte[5];
                byteArrayInputStream.read(bArr3);
                int a2 = a(new String(bArr3));
                if (a2 > 0) {
                    byte[] bArr4 = new byte[a2];
                    byteArrayInputStream.read(bArr4);
                    if (this.a) {
                        bArr4 = a(this.b, bArr4, str);
                    }
                    if (dVar.b()) {
                        bArr4 = b.b(bArr4);
                    }
                    str2 = new String(bArr4);
                } else {
                    str2 = null;
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused3) {
                }
            } catch (Exception e3) {
                e = e3;
                com.alipay.sdk.m.u.e.a(e);
                if (byteArrayInputStream != null) {
                }
                str2 = null;
                if (str3 == null) {
                }
                return new b(str3, str2);
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayInputStream = null;
            str3 = null;
            com.alipay.sdk.m.u.e.a(e);
            if (byteArrayInputStream != null) {
            }
            str2 = null;
            if (str3 == null) {
            }
            return new b(str3, str2);
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayInputStream2 != null) {
            }
            throw th;
        }
        if (str3 == null || str2 != null) {
            return new b(str3, str2);
        }
        return null;
    }

    public static byte[] a(String str, String str2) {
        return d.a(str, str2);
    }

    public static byte[] a(String str, byte[] bArr, String str2) {
        return e.a(str, bArr, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004e, code lost:
        if (r2 == null) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0049 A[SYNTHETIC, Splitter:B:30:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0058 A[SYNTHETIC, Splitter:B:40:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005f A[SYNTHETIC, Splitter:B:44:0x005f] */
    public static byte[] a(byte[]... bArr) {
        Throwable th;
        DataOutputStream dataOutputStream;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                dataOutputStream = null;
                try {
                    com.alipay.sdk.m.u.e.a(e);
                    if (byteArrayOutputStream != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                }
                if (dataOutputStream != null) {
                }
                throw th;
            }
            try {
                for (byte[] bArr3 : bArr) {
                    dataOutputStream.write(a(bArr3.length).getBytes());
                    dataOutputStream.write(bArr3);
                }
                dataOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused3) {
                }
                bArr2 = byteArray;
            } catch (Exception e3) {
                e = e3;
                com.alipay.sdk.m.u.e.a(e);
                if (byteArrayOutputStream != null) {
                }
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            com.alipay.sdk.m.u.e.a(e);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused4) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            if (byteArrayOutputStream2 != null) {
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
        try {
            dataOutputStream.close();
        } catch (Exception unused5) {
        }
        return bArr2;
    }

    public static String a(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }
}
