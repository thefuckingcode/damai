package com.taobao.slide.request;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import tb.jl1;
import tb.uk;

/* compiled from: Taobao */
public class d implements IConnection {
    private HttpURLConnection a;
    private Map<String, String> b;

    @Override // com.taobao.slide.request.IConnection
    public void addHeader(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    @Override // com.taobao.slide.request.IConnection
    public void connect() throws IOException {
        this.a.connect();
    }

    @Override // com.taobao.slide.request.IConnection
    public void disconnect() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public Map<String, List<String>> getHeadFields() {
        return this.a.getHeaderFields();
    }

    @Override // com.taobao.slide.request.IConnection
    public String getResponse() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Throwable th;
        IOException e;
        try {
            inputStream = this.a.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                uk.a(inputStream);
                uk.a(byteArrayOutputStream);
                return str;
            } catch (IOException e3) {
                byteArrayOutputStream = null;
                e = e3;
                throw e;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                uk.a(inputStream);
                uk.a(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            byteArrayOutputStream = null;
            e = e4;
            inputStream = null;
            throw e;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
            uk.a(inputStream);
            uk.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public int getResponseCode() throws IOException {
        return this.a.getResponseCode();
    }

    @Override // com.taobao.slide.request.IConnection
    public void openConnection(String str) throws IOException {
        String b2 = uk.b(this.b, "UTF-8");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(b2)) {
            sb.append(jl1.CONDITION_IF);
            sb.append(b2);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
        this.a = httpURLConnection;
        httpURLConnection.setConnectTimeout(5000);
        this.a.setReadTimeout(5000);
        this.a.setUseCaches(false);
        this.a.setDoInput(true);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setBody(byte[] bArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(this.a.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        uk.a(dataOutputStream);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setMethod(String str) throws ProtocolException {
        if (!TextUtils.isEmpty(str)) {
            this.a.setRequestMethod(str);
            if ("POST".equalsIgnoreCase(str)) {
                this.a.setDoOutput(true);
            }
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public void setParams(Map<String, String> map) {
        this.b = map;
    }
}
