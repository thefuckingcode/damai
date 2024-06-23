package tb;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/* compiled from: Taobao */
public final class cz0 {

    /* compiled from: Taobao */
    public static class a {
        public byte[] a = null;
    }

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c A[SYNTHETIC, Splitter:B:42:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A[SYNTHETIC, Splitter:B:48:0x00ab] */
    public a a(String str) {
        Throwable th;
        IOException e;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection != null) {
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setDoInput(true);
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
                    httpURLConnection.setInstanceFollowRedirects(true);
                    System.currentTimeMillis();
                    try {
                        httpURLConnection.connect();
                        try {
                            httpURLConnection.getResponseCode();
                        } catch (IOException e2) {
                            Logger.f("HttpsUtil", e2);
                        }
                        System.currentTimeMillis();
                        DataInputStream dataInputStream = null;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            DataInputStream dataInputStream2 = new DataInputStream(httpURLConnection.getInputStream());
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = dataInputStream2.read(bArr, 0, 2048);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e3) {
                                            Logger.f("HttpsUtil", e3);
                                        }
                                    }
                                }
                                dataInputStream2.close();
                                if (byteArrayOutputStream.size() > 0) {
                                    aVar.a = byteArrayOutputStream.toByteArray();
                                }
                            } catch (IOException e4) {
                                e = e4;
                                dataInputStream = dataInputStream2;
                                try {
                                    Logger.h("HttpsUtil", e, new Object[0]);
                                    if (dataInputStream != null) {
                                    }
                                    return aVar;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (dataInputStream != null) {
                                        try {
                                            dataInputStream.close();
                                        } catch (Exception e5) {
                                            Logger.f("HttpsUtil", e5);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataInputStream = dataInputStream2;
                                if (dataInputStream != null) {
                                }
                                throw th;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            Logger.h("HttpsUtil", e, new Object[0]);
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e7) {
                                    Logger.f("HttpsUtil", e7);
                                }
                            }
                            return aVar;
                        }
                    } catch (Exception e8) {
                        Logger.h("HttpsUtil", e8, new Object[0]);
                        System.currentTimeMillis();
                        return aVar;
                    }
                } catch (ProtocolException e9) {
                    Logger.h("HttpsUtil", e9, new Object[0]);
                }
            }
            return aVar;
        } catch (MalformedURLException e10) {
            Logger.h("HttpsUtil", e10, new Object[0]);
            return aVar;
        } catch (IOException e11) {
            Logger.h("HttpsUtil", e11, new Object[0]);
            return aVar;
        }
    }
}
