package com.amap.api.col.s;

import com.amap.api.col.s.cw;
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

/* compiled from: Taobao */
public final class di {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053 A[SYNTHETIC, Splitter:B:23:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[SYNTHETIC, Splitter:B:28:0x005d] */
    public static void a(String str, byte[] bArr, dh dhVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        cw cwVar;
        OutputStream outputStream = null;
        try {
            if (!a(dhVar.a, str)) {
                File file = new File(dhVar.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                cwVar = cw.a(file, dhVar.b);
                try {
                    cwVar.a(dhVar.d);
                    byte[] b = dhVar.e.b(bArr);
                    cw.a b2 = cwVar.b(str);
                    outputStream = b2.a();
                    outputStream.write(b);
                    b2.b();
                    cwVar.b();
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        cwVar.close();
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
                    if (cwVar != null) {
                        try {
                            cwVar.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            cwVar = null;
            if (outputStream != null) {
            }
            if (cwVar != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
    public static int a(dh dhVar) {
        Throwable th;
        cw cwVar = null;
        try {
            if (dhVar.f.c()) {
                dhVar.f.a(true);
                cw a = cw.a(new File(dhVar.a), dhVar.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] a2 = a(a, dhVar, arrayList);
                    if (a2 != null) {
                        if (a2.length != 0) {
                            ck ckVar = new ck(a2, dhVar.c);
                            cz.a();
                            JSONObject jSONObject = new JSONObject(new String(cz.a(ckVar).a));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                cwVar = a;
                            } else {
                                ea eaVar = dhVar.f;
                                if (eaVar != null) {
                                    eaVar.a(a2.length);
                                }
                                if (dhVar.f.b() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    try {
                                        a.c();
                                    } catch (Throwable th2) {
                                        cl.c(th2, "ofm", "dlo");
                                    }
                                }
                                return a2.length;
                            }
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return -1;
                } catch (Throwable th4) {
                    th = th4;
                    cwVar = a;
                    try {
                        cl.c(th, "leg", "uts");
                        if (cwVar != null) {
                        }
                        return -1;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            if (cwVar != null) {
                try {
                    cwVar.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            th = th7;
            cl.c(th, "leg", "uts");
            if (cwVar != null) {
                cwVar.close();
            }
            return -1;
        }
        return -1;
        throw th;
    }

    private static byte[] a(cw cwVar, dh dhVar, List<String> list) {
        try {
            File a = cwVar.a();
            if (a != null && a.exists()) {
                String[] list2 = a.list();
                int i = 0;
                for (String str : list2) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a2 = dn.a(cwVar, str2);
                        i += a2.length;
                        list.add(str2);
                        if (i > dhVar.f.b()) {
                            break;
                        }
                        dhVar.g.b(a2);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return dhVar.g.a();
            }
        } catch (Throwable th) {
            cl.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(cw cwVar, List<String> list) {
        if (cwVar != null) {
            try {
                for (String str : list) {
                    cwVar.c(str);
                }
                cwVar.close();
            } catch (Throwable th) {
                cl.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            cl.c(th, "leg", "fet");
            return false;
        }
    }
}
