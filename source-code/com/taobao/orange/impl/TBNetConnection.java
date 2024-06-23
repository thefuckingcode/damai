package com.taobao.orange.impl;

import android.os.RemoteException;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableInputStream;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.util.OrangeUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.e02;
import tb.m50;
import tb.nf2;

/* compiled from: Taobao */
public class TBNetConnection implements INetConnection {
    private Connection connection;
    private m50 network;
    private Map<String, String> params;
    private Request request;

    @Override // com.taobao.orange.inner.INetConnection
    public void addHeader(String str, String str2) {
        Request request2 = this.request;
        if (request2 != null) {
            request2.addHeader(str, str2);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void connect() throws IOException {
        this.connection = this.network.getConnection(this.request, null);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void disconnect() {
        try {
            Connection connection2 = this.connection;
            if (connection2 != null) {
                connection2.cancel();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public Map<String, List<String>> getHeadFields() {
        Connection connection2 = this.connection;
        if (connection2 == null) {
            return null;
        }
        try {
            return connection2.getConnHeadFields();
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0050 A[SYNTHETIC, Splitter:B:33:0x0050] */
    @Override // com.taobao.orange.inner.INetConnection
    public String getResponse() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ParcelableInputStream parcelableInputStream;
        RemoteException e;
        Connection connection2 = this.connection;
        if (connection2 == null) {
            return null;
        }
        try {
            parcelableInputStream = connection2.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (RemoteException e2) {
                byteArrayOutputStream = null;
                e = e2;
                try {
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (parcelableInputStream != null) {
                    }
                    OrangeUtils.close(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                if (parcelableInputStream != null) {
                }
                OrangeUtils.close(byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = parcelableInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                try {
                    parcelableInputStream.close();
                } catch (RemoteException unused) {
                }
                OrangeUtils.close(byteArrayOutputStream);
                return str;
            } catch (RemoteException e3) {
                e = e3;
                throw new IOException(e);
            }
        } catch (RemoteException e4) {
            byteArrayOutputStream = null;
            e = e4;
            parcelableInputStream = null;
            throw new IOException(e);
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            parcelableInputStream = null;
            if (parcelableInputStream != null) {
                try {
                    parcelableInputStream.close();
                } catch (RemoteException unused2) {
                }
            }
            OrangeUtils.close(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public int getResponseCode() throws IOException {
        Connection connection2 = this.connection;
        if (connection2 == null) {
            return 0;
        }
        try {
            return connection2.getStatusCode();
        } catch (RemoteException e) {
            throw new IOException(e);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void openConnection(String str) throws IOException {
        this.network = new m50(GlobalOrange.context);
        e02 e02 = new e02(str);
        this.request = e02;
        e02.setCharset("utf-8");
        this.request.setConnectTimeout(5000);
        this.request.setReadTimeout(5000);
        Map<String, String> map = this.params;
        if (!(map == null || map.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.params.entrySet()) {
                arrayList.add(new nf2(entry.getKey(), entry.getValue()));
            }
            this.request.setParams(arrayList);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setBody(byte[] bArr) throws IOException {
        Request request2 = this.request;
        if (request2 != null) {
            request2.setBodyEntry(new ByteArrayEntry(bArr));
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setMethod(String str) throws ProtocolException {
        Request request2 = this.request;
        if (request2 != null) {
            request2.setMethod(str);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setParams(Map<String, String> map) {
        this.params = map;
    }
}
