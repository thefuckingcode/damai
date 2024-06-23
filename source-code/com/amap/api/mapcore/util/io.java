package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.hy;
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
public class io {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a A[SYNTHETIC, Splitter:B:23:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064 A[SYNTHETIC, Splitter:B:28:0x0064] */
    public static void a(String str, byte[] bArr, in inVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        hy hyVar;
        OutputStream outputStream = null;
        try {
            if (!a(inVar.a, str)) {
                File file = new File(inVar.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                hyVar = hy.a(file, 1, 1, inVar.b * ((long) inVar.d));
                try {
                    hyVar.a(inVar.d);
                    byte[] b = inVar.e.b(bArr);
                    hy.a b2 = hyVar.b(str);
                    outputStream = b2.a(0);
                    outputStream.write(b);
                    b2.a();
                    hyVar.e();
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        hyVar.close();
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
                    if (hyVar != null) {
                        try {
                            hyVar.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            hyVar = null;
            if (outputStream != null) {
            }
            if (hyVar != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    public static void a(in inVar) {
        Throwable th;
        hy hyVar = null;
        try {
            if (inVar.f.c()) {
                inVar.f.a(true);
                hy a = hy.a(new File(inVar.a), 1, 1, inVar.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] a2 = a(a, inVar, arrayList);
                    if (a2 != null) {
                        if (a2.length != 0) {
                            JSONObject jSONObject = new JSONObject(new String(id.a().b(new hc(a2, inVar.c))));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                hyVar = a;
                            } else {
                                jh jhVar = inVar.f;
                                if (jhVar != null) {
                                    jhVar.a(a2.length);
                                }
                                if (inVar.f.b() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    a(a);
                                }
                            }
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    hyVar = a;
                    try {
                        hd.c(th, "leg", "uts");
                        if (hyVar == null) {
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
            if (hyVar != null) {
                try {
                    hyVar.close();
                    return;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return;
                }
            } else {
                return;
            }
        } catch (Throwable th6) {
            th = th6;
            hd.c(th, "leg", "uts");
            if (hyVar == null) {
                hyVar.close();
                return;
            }
            return;
        }
        throw th;
    }

    private static byte[] a(hy hyVar, in inVar, List<String> list) {
        try {
            File c = hyVar.c();
            if (c != null && c.exists()) {
                String[] list2 = c.list();
                int length = list2.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = list2[i];
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = iu.a(hyVar, str2, false);
                        i2 += a.length;
                        list.add(str2);
                        if (i2 > inVar.f.b()) {
                            break;
                        }
                        inVar.g.b(a);
                    }
                    i++;
                }
                return inVar.g.a();
            }
        } catch (Throwable th) {
            hd.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(hy hyVar) {
        if (hyVar != null) {
            try {
                hyVar.f();
            } catch (Throwable th) {
                hd.c(th, "ofm", "dlo");
            }
        }
    }

    private static void a(hy hyVar, List<String> list) {
        if (hyVar != null) {
            try {
                for (String str : list) {
                    hyVar.c(str);
                }
                hyVar.close();
            } catch (Throwable th) {
                hd.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            hd.c(th, "leg", "fet");
            return false;
        }
    }
}
