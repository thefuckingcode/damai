package com.taobao.orange.impl;

import android.text.TextUtils;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.util.OrangeUtils;
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

/* compiled from: Taobao */
public class HurlNetConnection implements INetConnection {
    private HttpURLConnection httpURLConnection;
    private Map<String, String> params;

    @Override // com.taobao.orange.inner.INetConnection
    public void addHeader(String str, String str2) {
        this.httpURLConnection.addRequestProperty(str, str2);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void connect() throws IOException {
        this.httpURLConnection.connect();
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void disconnect() {
        HttpURLConnection httpURLConnection2 = this.httpURLConnection;
        if (httpURLConnection2 != null) {
            httpURLConnection2.disconnect();
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public Map<String, List<String>> getHeadFields() {
        HttpURLConnection httpURLConnection2 = this.httpURLConnection;
        if (httpURLConnection2 == null) {
            return null;
        }
        return httpURLConnection2.getHeaderFields();
    }

    @Override // com.taobao.orange.inner.INetConnection
    public String getResponse() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        IOException e;
        HttpURLConnection httpURLConnection2 = this.httpURLConnection;
        if (httpURLConnection2 == null) {
            return null;
        }
        try {
            inputStream = httpURLConnection2.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e2) {
                byteArrayOutputStream = null;
                e = e2;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                OrangeUtils.close(inputStream);
                OrangeUtils.close(byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                        OrangeUtils.close(inputStream);
                        OrangeUtils.close(byteArrayOutputStream);
                        return str;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
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
            OrangeUtils.close(inputStream);
            OrangeUtils.close(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public int getResponseCode() throws IOException {
        HttpURLConnection httpURLConnection2 = this.httpURLConnection;
        if (httpURLConnection2 == null) {
            return 0;
        }
        return httpURLConnection2.getResponseCode();
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void openConnection(String str) throws IOException {
        String encodeQueryParams = OrangeUtils.encodeQueryParams(this.params, "utf-8");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(encodeQueryParams)) {
            sb.append(jl1.CONDITION_IF);
            sb.append(encodeQueryParams);
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
        this.httpURLConnection = httpURLConnection2;
        httpURLConnection2.setConnectTimeout(5000);
        this.httpURLConnection.setReadTimeout(5000);
        this.httpURLConnection.setUseCaches(false);
        this.httpURLConnection.setDoInput(true);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setBody(byte[] bArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(this.httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        OrangeUtils.close(dataOutputStream);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setMethod(String str) throws ProtocolException {
        if (!TextUtils.isEmpty(str)) {
            this.httpURLConnection.setRequestMethod(str);
            if ("POST".equalsIgnoreCase(str)) {
                this.httpURLConnection.setDoOutput(true);
            }
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setParams(Map<String, String> map) {
        this.params = map;
    }
}
