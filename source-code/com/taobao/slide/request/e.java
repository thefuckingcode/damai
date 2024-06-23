package com.taobao.slide.request;

import android.content.Context;
import android.os.RemoteException;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.e02;
import tb.m50;
import tb.nf2;
import tb.uk;

/* compiled from: Taobao */
public class e implements IConnection {
    private Context a;
    private Request b;
    private m50 c;
    private Connection d;
    private Map<String, String> e;

    e(Context context) {
        this.a = context;
    }

    @Override // com.taobao.slide.request.IConnection
    public void addHeader(String str, String str2) {
        this.b.addHeader(str, str2);
    }

    @Override // com.taobao.slide.request.IConnection
    public void connect() {
        this.d = this.c.getConnection(this.b, null);
    }

    @Override // com.taobao.slide.request.IConnection
    public void disconnect() {
        try {
            Connection connection = this.d;
            if (connection != null) {
                connection.cancel();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public Map<String, List<String>> getHeadFields() {
        Connection connection = this.d;
        if (connection == null) {
            return null;
        }
        try {
            return connection.getConnHeadFields();
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0047 A[SYNTHETIC, Splitter:B:29:0x0047] */
    @Override // com.taobao.slide.request.IConnection
    public String getResponse() throws IOException {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        RemoteException e2;
        ParcelableInputStream parcelableInputStream = null;
        if (this.d == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ParcelableInputStream inputStream = this.d.getInputStream();
                if (inputStream != null) {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (RemoteException unused) {
                    }
                }
                uk.a(byteArrayOutputStream);
                return str;
            } catch (RemoteException e3) {
                e2 = e3;
                try {
                    throw new IOException(e2);
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            parcelableInputStream.close();
                        } catch (RemoteException unused2) {
                        }
                    }
                    uk.a(byteArrayOutputStream);
                    throw th;
                }
            }
        } catch (RemoteException e4) {
            e2 = e4;
            byteArrayOutputStream = null;
            throw new IOException(e2);
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (0 != 0) {
            }
            uk.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public int getResponseCode() throws IOException {
        Connection connection = this.d;
        if (connection == null) {
            return 0;
        }
        try {
            return connection.getStatusCode();
        } catch (RemoteException e2) {
            throw new IOException(e2);
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public void openConnection(String str) {
        this.c = new m50(this.a);
        e02 e02 = new e02(str);
        this.b = e02;
        e02.setCharset("UTF-8");
        this.b.setConnectTimeout(5000);
        this.b.setReadTimeout(5000);
        Map<String, String> map = this.e;
        if (!(map == null || map.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                arrayList.add(new nf2(entry.getKey(), entry.getValue()));
            }
            this.b.setParams(arrayList);
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public void setBody(byte[] bArr) {
        this.b.setBodyEntry(new ByteArrayEntry(bArr));
    }

    @Override // com.taobao.slide.request.IConnection
    public void setMethod(String str) {
        this.b.setMethod(str);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setParams(Map<String, String> map) {
        this.e = map;
    }
}
