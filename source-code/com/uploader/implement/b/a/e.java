package com.uploader.implement.b.a;

import android.text.TextUtils;
import com.uploader.implement.b.b;
import com.uploader.implement.c;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import mtopsdk.network.util.Constants;
import org.android.agoo.message.MessageService;
import tb.h13;
import tb.m53;

/* compiled from: Taobao */
public class e extends a {
    HttpURLConnection d = null;
    boolean e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements HostnameVerifier {
        final /* synthetic */ String a;

        a(e eVar, String str) {
            this.a = str;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        }
    }

    e(c cVar, g gVar) {
        super(cVar, gVar);
        this.e = gVar.f.startsWith("https://");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x011a */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013f A[Catch:{ all -> 0x0171 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015e A[Catch:{ all -> 0x0171 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0166 A[SYNTHETIC, Splitter:B:72:0x0166] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016d A[SYNTHETIC, Splitter:B:76:0x016d] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0174 A[SYNTHETIC, Splitter:B:81:0x0174] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017b A[SYNTHETIC, Splitter:B:85:0x017b] */
    private void h(HttpURLConnection httpURLConnection, b bVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Exception e2;
        m53 m53 = new m53();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "ShortLivedConnection", "code=" + responseCode + ",msg=" + responseMessage + ",headers=" + headerFields);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            if (headerFields != null && !headerFields.isEmpty()) {
                m53.a = new HashMap(headerFields.size());
                for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                    if (entry.getKey() != null) {
                        m53.a.put(entry.getKey(), entry.getValue().get(0));
                    }
                }
            }
            if (m53.a == null) {
                m53.a = new HashMap();
            }
            m53.a.put("response_code", String.valueOf(responseCode));
            m53.a.put("response_msg", responseMessage);
            if (inputStream == null) {
                if (bVar != null) {
                    bVar.a(this, m53);
                }
                j();
                return;
            }
            DataInputStream dataInputStream = null;
            try {
                if ("gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(Constants.Protocol.CONTENT_ENCODING))) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                DataInputStream dataInputStream2 = new DataInputStream(inputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        m53.b = byteArray;
                        m53.d = byteArray.length;
                        if (com.uploader.implement.a.d(2)) {
                            com.uploader.implement.a.a(2, "ShortLivedConnection", this.c + " response body:" + new String(m53.b));
                        }
                        dataInputStream2.close();
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused) {
                        }
                        if (bVar != null) {
                            bVar.a(this, m53);
                        }
                        j();
                    } catch (Exception e3) {
                        e2 = e3;
                        dataInputStream = dataInputStream2;
                        try {
                            if (com.uploader.implement.a.d(8)) {
                            }
                            h13 h13 = new h13(MessageService.MSG_DB_COMPLETE, "6", "parseResponse read", true);
                            if (bVar != null) {
                            }
                            j();
                            if (dataInputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    byteArrayOutputStream = null;
                    dataInputStream = dataInputStream2;
                    if (com.uploader.implement.a.d(8)) {
                    }
                    h13 h132 = new h13(MessageService.MSG_DB_COMPLETE, "6", "parseResponse read", true);
                    if (bVar != null) {
                    }
                    j();
                    if (dataInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e2 = e5;
                byteArrayOutputStream = null;
                if (com.uploader.implement.a.d(8)) {
                    com.uploader.implement.a.b(8, "ShortLivedConnection", this.c + " parseResponse, read Stream error", e2);
                }
                h13 h1322 = new h13(MessageService.MSG_DB_COMPLETE, "6", "parseResponse read", true);
                if (bVar != null) {
                    bVar.a(this, h1322);
                }
                j();
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                if (dataInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "ShortLivedConnection", this.c + " parseResponse:" + e6.toString());
            }
            h13 h133 = new h13(MessageService.MSG_DB_COMPLETE, "6", "parseResponse getStream", true);
            if (bVar != null) {
                bVar.a(this, h133);
            }
            j();
        }
    }

    private void i(HttpURLConnection httpURLConnection, String str) {
        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new a(this, str));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() throws Exception {
        if (this.d == null) {
            g gVar = (g) this.a;
            URL url = new URL(gVar.f);
            if (this.e) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                this.d = httpURLConnection;
                i(httpURLConnection, gVar.g);
            } else {
                Proxy proxy = null;
                if (!TextUtils.isEmpty(gVar.c) && gVar.d > 0) {
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(gVar.c, gVar.d));
                }
                if (proxy != null) {
                    this.d = (HttpURLConnection) url.openConnection(proxy);
                } else {
                    this.d = (HttpURLConnection) url.openConnection();
                }
            }
            this.d.setConnectTimeout(10000);
            this.d.setConnectTimeout(10000);
            this.d.setRequestMethod("POST");
            this.d.setDoOutput(true);
            this.d.setDoInput(true);
        }
    }

    @Override // com.uploader.implement.b.e
    public void a(final m53 m53, final int i) {
        com.uploader.implement.e.b.a(new Runnable() {
            /* class com.uploader.implement.b.a.e.AnonymousClass1 */

            public void run() {
                b e = e.this.e();
                try {
                    e.this.k();
                    Map<String, String> map = m53.a;
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            e.this.d.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (com.uploader.implement.a.d(4)) {
                        com.uploader.implement.a.a(4, "ShortLivedConnection", e.this.c + " URL:" + e.this.d.getURL().toString() + " RequestHeaders:" + e.this.d.getRequestProperties());
                    }
                    try {
                        e.this.d.connect();
                        if (e != null) {
                            e.a(e.this, i);
                        }
                        if (m53.b != null) {
                            OutputStream outputStream = null;
                            try {
                                OutputStream outputStream2 = e.this.d.getOutputStream();
                                m53 m53 = m53;
                                outputStream2.write(m53.b, m53.c, m53.d);
                                if (com.uploader.implement.a.d(4)) {
                                    com.uploader.implement.a.a(4, "ShortLivedConnection", e.this.c + " BODY:" + new String(m53.b));
                                }
                                try {
                                    outputStream2.close();
                                } catch (IOException e2) {
                                    if (com.uploader.implement.a.d(8)) {
                                        com.uploader.implement.a.a(8, "ShortLivedConnection", e2.toString());
                                    }
                                }
                            } catch (Exception e3) {
                                if (com.uploader.implement.a.d(8)) {
                                    com.uploader.implement.a.b(8, "ShortLivedConnection", e.this.c + " send data error.", e3);
                                }
                                e.this.d.disconnect();
                                h13 h13 = new h13(MessageService.MSG_DB_COMPLETE, "5", "send data error", true);
                                if (e != null) {
                                    e.a(e.this, h13);
                                }
                                if (0 != 0) {
                                    try {
                                        outputStream.close();
                                        return;
                                    } catch (IOException e4) {
                                        if (com.uploader.implement.a.d(8)) {
                                            com.uploader.implement.a.a(8, "ShortLivedConnection", e4.toString());
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e5) {
                                        if (com.uploader.implement.a.d(8)) {
                                            com.uploader.implement.a.a(8, "ShortLivedConnection", e5.toString());
                                        }
                                    }
                                }
                                throw th;
                            }
                        }
                        if (e != null) {
                            e.b(e.this, i);
                        }
                        e eVar = e.this;
                        eVar.h(eVar.d, e);
                    } catch (Exception e6) {
                        if (com.uploader.implement.a.d(8)) {
                            com.uploader.implement.a.b(8, "ShortLivedConnection", "connect error.", e6);
                        }
                        h13 h132 = new h13(MessageService.MSG_DB_COMPLETE, "4", "connect error", true);
                        if (e != null) {
                            e.a(e.this, h132);
                        }
                    }
                } catch (Exception e7) {
                    if (com.uploader.implement.a.d(8)) {
                        com.uploader.implement.a.b(8, "ShortLivedConnection", e.this.c + " open connection error, ", e7);
                    }
                    h13 h133 = new h13(MessageService.MSG_DB_COMPLETE, "3", "open connection error", true);
                    if (e != null) {
                        e.a(e.this, h133);
                    }
                }
            }
        });
    }

    @Override // com.uploader.implement.b.e
    public boolean b() {
        return true;
    }

    @Override // com.uploader.implement.b.e
    public boolean c() {
        return true;
    }

    @Override // com.uploader.implement.b.e
    public boolean d() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        try {
            this.d.disconnect();
        } catch (Exception unused) {
        }
    }
}
