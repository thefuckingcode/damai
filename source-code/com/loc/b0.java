package com.loc;

import com.loc.v;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;
import tb.g33;
import tb.r23;

/* compiled from: Taobao */
public final class b0 {
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
    public static int a(r23 r23) {
        Throwable th;
        v vVar = null;
        try {
            if (r23.f.e()) {
                r23.f.b(true);
                v b = v.b(new File(r23.a), r23.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] e = e(b, r23, arrayList);
                    if (e != null) {
                        if (e.length != 0) {
                            h hVar = new h(e, r23.c);
                            bg.b();
                            JSONObject jSONObject = new JSONObject(new String(bg.c(hVar).a));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                vVar = b;
                            } else {
                                g33 g33 = r23.f;
                                if (g33 != null) {
                                    g33.a(e.length);
                                }
                                if (r23.f.d() < Integer.MAX_VALUE) {
                                    b(b, arrayList);
                                } else {
                                    try {
                                        b.t();
                                    } catch (Throwable th2) {
                                        an.m(th2, "ofm", "dlo");
                                    }
                                }
                                return e.length;
                            }
                        }
                    }
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return -1;
                } catch (Throwable th4) {
                    th = th4;
                    vVar = b;
                    try {
                        an.m(th, "leg", "uts");
                        if (vVar != null) {
                        }
                        return -1;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            if (vVar != null) {
                try {
                    vVar.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            th = th7;
            an.m(th, "leg", "uts");
            if (vVar != null) {
                vVar.close();
            }
            return -1;
        }
        return -1;
        throw th;
    }

    private static void b(v vVar, List<String> list) {
        if (vVar != null) {
            try {
                for (String str : list) {
                    vVar.r(str);
                }
                vVar.close();
            } catch (Throwable th) {
                an.m(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053 A[SYNTHETIC, Splitter:B:23:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[SYNTHETIC, Splitter:B:28:0x005d] */
    public static void c(String str, byte[] bArr, r23 r23) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        v vVar;
        OutputStream outputStream = null;
        try {
            if (!d(r23.a, str)) {
                File file = new File(r23.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                vVar = v.b(file, r23.b);
                try {
                    vVar.f(r23.d);
                    byte[] b = r23.e.b(bArr);
                    v.d l = vVar.l(str);
                    outputStream = l.b();
                    outputStream.write(b);
                    l.c();
                    vVar.p();
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        vVar.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    if (vVar != null) {
                        try {
                            vVar.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            vVar = null;
            if (outputStream != null) {
            }
            if (vVar != null) {
            }
            throw th;
        }
    }

    private static boolean d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            an.m(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] e(v vVar, r23 r23, List<String> list) {
        try {
            File m = vVar.m();
            if (m != null && m.exists()) {
                String[] list2 = m.list();
                int i = 0;
                for (String str : list2) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] f = e0.f(vVar, str2);
                        i += f.length;
                        list.add(str2);
                        if (i > r23.f.d()) {
                            break;
                        }
                        r23.g.c(f);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return r23.g.a();
            }
        } catch (Throwable th) {
            an.m(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
