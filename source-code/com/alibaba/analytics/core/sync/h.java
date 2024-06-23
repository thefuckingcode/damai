package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.f;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.bc;
import tb.bz0;
import tb.h82;
import tb.i82;
import tb.sr2;
import tb.ua1;

/* compiled from: Taobao */
public class h {
    public static int a = 0;
    public static final i82 mMonitor = new i82();

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ee A[SYNTHETIC, Splitter:B:106:0x01ee] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0244 A[SYNTHETIC, Splitter:B:123:0x0244] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a8 A[SYNTHETIC, Splitter:B:88:0x01a8] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ce A[SYNTHETIC, Splitter:B:96:0x01ce] */
    public static bc a(byte[] bArr) {
        Throwable th;
        SSLHandshakeException e;
        Exception e2;
        DataOutputStream dataOutputStream;
        Throwable th2;
        IOException e3;
        HashMap<String, String> c;
        Logger.d();
        bc bcVar = new bc();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bz0.b().a()).openConnection();
            if (httpURLConnection != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    String g = Variables.n().g();
                    if (!TextUtils.isEmpty(g)) {
                        httpURLConnection.setRequestProperty("x-k", g);
                    }
                    try {
                        IUTRequestAuthentication w = Variables.n().w();
                        if (w != null) {
                            String sign = w.getSign(ua1.b(bArr));
                            Logger.f("", "signValue", sign);
                            httpURLConnection.setRequestProperty("x-s", sign);
                            if (w instanceof UTBaseRequestAuthentication) {
                                if (((UTBaseRequestAuthentication) w).isEncode()) {
                                    httpURLConnection.setRequestProperty(HttpHeaderConstant.X_T, "2");
                                    Logger.f("", HttpHeaderConstant.X_T, 2);
                                } else {
                                    httpURLConnection.setRequestProperty(HttpHeaderConstant.X_T, "3");
                                    Logger.f("", HttpHeaderConstant.X_T, 3);
                                }
                            } else if ((w instanceof UTSecuritySDKRequestAuthentication) || (w instanceof UTSecurityThridRequestAuthentication)) {
                                httpURLConnection.setRequestProperty(HttpHeaderConstant.X_T, "1");
                                Logger.f("", HttpHeaderConstant.X_T, 1);
                            }
                        }
                    } catch (Throwable th3) {
                        Logger.h("", th3, new Object[0]);
                    }
                    if (f.a() && (c = sr2.b().c()) != null && !c.isEmpty()) {
                        for (Map.Entry<String, String> entry : c.entrySet()) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (value == null || value.isEmpty()) {
                                value = "";
                            }
                            httpURLConnection.setRequestProperty(key, value);
                        }
                    }
                    if (Logger.n()) {
                        Logger.f("UrlWrapper", httpURLConnection.getRequestProperties());
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    DataOutputStream dataOutputStream2 = null;
                    DataInputStream dataInputStream = null;
                    DataOutputStream dataOutputStream3 = null;
                    try {
                        httpURLConnection.connect();
                        if (bArr == null || bArr.length <= 0) {
                            dataOutputStream = null;
                        } else {
                            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                dataOutputStream.write(bArr);
                                dataOutputStream.flush();
                            } catch (SSLHandshakeException e4) {
                                e = e4;
                                dataOutputStream2 = dataOutputStream;
                            } catch (Exception e5) {
                                e2 = e5;
                                dataOutputStream3 = dataOutputStream;
                                try {
                                    Logger.f("", e2);
                                    bcVar.c = System.currentTimeMillis() - currentTimeMillis;
                                    if (dataOutputStream3 != null) {
                                    }
                                    return bcVar;
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (dataOutputStream3 != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream3 = dataOutputStream;
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (IOException e6) {
                                        Logger.f("", e6);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e7) {
                                Logger.f("", e7);
                            }
                        }
                        bcVar.c = System.currentTimeMillis() - currentTimeMillis;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            DataInputStream dataInputStream2 = new DataInputStream(httpURLConnection.getInputStream());
                            try {
                                byte[] bArr2 = new byte[2048];
                                while (true) {
                                    int read = dataInputStream2.read(bArr2, 0, 2048);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e8) {
                                            Logger.f("", e8);
                                        }
                                    }
                                }
                                dataInputStream2.close();
                            } catch (IOException e9) {
                                e3 = e9;
                                dataInputStream = dataInputStream2;
                                try {
                                    Logger.f("", e3);
                                    if (dataInputStream != null) {
                                        try {
                                            dataInputStream.close();
                                        } catch (Exception e10) {
                                            Logger.f("", e10);
                                        }
                                    }
                                    if (byteArrayOutputStream.size() > 0) {
                                    }
                                    return bcVar;
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    if (dataInputStream != null) {
                                    }
                                    throw th2;
                                }
                            } catch (Throwable th7) {
                                th2 = th7;
                                dataInputStream = dataInputStream2;
                                if (dataInputStream != null) {
                                    try {
                                        dataInputStream.close();
                                    } catch (Exception e11) {
                                        Logger.f("", e11);
                                    }
                                }
                                throw th2;
                            }
                        } catch (IOException e12) {
                            e3 = e12;
                            Logger.f("", e3);
                            if (dataInputStream != null) {
                            }
                            if (byteArrayOutputStream.size() > 0) {
                            }
                            return bcVar;
                        }
                        if (byteArrayOutputStream.size() > 0) {
                            int l = a.l(byteArrayOutputStream.toByteArray());
                            a = l;
                            bcVar.a = l;
                            bcVar.e = a.a;
                        }
                    } catch (SSLHandshakeException e13) {
                        e = e13;
                        Logger.f("", e);
                        if (Variables.n().O()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", "3");
                            mMonitor.onEvent(h82.a(h82.j, JSON.toJSONString(hashMap), Double.valueOf(1.0d)));
                        }
                        bcVar.c = System.currentTimeMillis() - currentTimeMillis;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e14) {
                                Logger.f("", e14);
                            }
                        }
                        return bcVar;
                    } catch (Exception e15) {
                        e2 = e15;
                        Logger.f("", e2);
                        bcVar.c = System.currentTimeMillis() - currentTimeMillis;
                        if (dataOutputStream3 != null) {
                            try {
                                dataOutputStream3.close();
                            } catch (IOException e16) {
                                Logger.f("", e16);
                            }
                        }
                        return bcVar;
                    }
                } catch (ProtocolException e17) {
                    Logger.h("", e17, new Object[0]);
                }
            }
            return bcVar;
        } catch (MalformedURLException e18) {
            Logger.h("", e18, new Object[0]);
            return bcVar;
        } catch (IOException e19) {
            Logger.h("", e19, new Object[0]);
            return bcVar;
        }
    }
}
