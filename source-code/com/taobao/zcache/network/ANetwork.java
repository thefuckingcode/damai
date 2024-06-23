package com.taobao.zcache.network;

import android.os.RemoteException;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableInputStream;
import com.taobao.zcache.Error;
import com.taobao.zcache.ZCache;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.e02;
import tb.m50;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ANetwork extends NetworkAdaptor {
    private final Connection connection;

    public ANetwork(DownloadRequest downloadRequest) {
        m50 m50 = new m50(ZCache.getContext());
        e02 e02 = new e02(downloadRequest.url);
        e02.setBizId("ZCache");
        int i = downloadRequest.timeout;
        if (i > 0) {
            e02.setConnectTimeout(i * 1000);
        }
        e02.setFollowRedirects(true);
        e02.setMethod("GET");
        HashMap<String, String> hashMap = downloadRequest.header;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                e02.addHeader(entry.getKey(), entry.getValue());
            }
        }
        String str = downloadRequest.traceId;
        if (str != null) {
            try {
                e02.setExtProperty("f-pTraceId", str);
            } catch (Exception unused) {
            }
        }
        this.connection = m50.getConnection(e02, null);
        int statusCode = getStatusCode();
        if (statusCode < 0) {
            this.error = new Error(statusCode, "NetworkSDK Error");
        }
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public String getHeaderField(String str) {
        List<String> list;
        Map<String, List<String>> originHeaderFields = getOriginHeaderFields();
        if (originHeaderFields == null || (list = originHeaderFields.get(str)) == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public Map<String, List<String>> getOriginHeaderFields() {
        try {
            return this.connection.getConnHeadFields();
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.zcache.network.NetworkAdaptor
    public InputStream getOriginInputStream() {
        try {
            return new StreamWrapper(this.connection.getInputStream());
        } catch (RemoteException e) {
            setExceptionError(-5, e);
            return null;
        }
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public int getStatusCode() {
        try {
            return this.connection.getStatusCode();
        } catch (RemoteException e) {
            setExceptionError(-4, e);
            return 0;
        }
    }

    /* compiled from: Taobao */
    static class StreamWrapper extends InputStream {
        private final ParcelableInputStream stream;

        public StreamWrapper(ParcelableInputStream parcelableInputStream) {
            this.stream = parcelableInputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            try {
                return this.stream.available();
            } catch (RemoteException e) {
                throw new IOException(e.getMessage(), e);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            try {
                this.stream.close();
            } catch (RemoteException e) {
                throw new IOException(e.getMessage(), e);
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.stream.readByte();
            } catch (RemoteException e) {
                throw new IOException(e.getMessage(), e);
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            try {
                return this.stream.skip((int) j);
            } catch (RemoteException e) {
                throw new IOException(e.getMessage(), e);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            try {
                return this.stream.read(bArr);
            } catch (RemoteException e) {
                throw new IOException(e.getMessage(), e);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            try {
                return this.stream.readBytes(bArr, i, i2);
            } catch (RemoteException e) {
                throw new IOException(e.getMessage(), e);
            }
        }
    }
}
