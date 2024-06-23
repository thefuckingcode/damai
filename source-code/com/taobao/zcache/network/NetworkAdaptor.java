package com.taobao.zcache.network;

import android.text.TextUtils;
import com.taobao.zcache.Error;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import mtopsdk.network.util.Constants;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class NetworkAdaptor {
    public Error error;

    NetworkAdaptor() {
    }

    public void close() {
    }

    public abstract String getHeaderField(String str);

    public Map<String, String> getHeaderFields() {
        Map<String, List<String>> originHeaderFields = getOriginHeaderFields();
        if (originHeaderFields == null) {
            return null;
        }
        HashMap hashMap = new HashMap(originHeaderFields.size());
        for (Map.Entry<String, List<String>> entry : originHeaderFields.entrySet()) {
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                hashMap.put(entry.getKey(), value.get(0));
            }
        }
        return hashMap;
    }

    public InputStream getInputStream() {
        InputStream originInputStream = getOriginInputStream();
        if (originInputStream == null) {
            return null;
        }
        if (!TextUtils.equals("gzip", getHeaderField(Constants.Protocol.CONTENT_ENCODING))) {
            return originInputStream;
        }
        try {
            return new GZIPInputStream(originInputStream);
        } catch (IOException e) {
            setExceptionError(-6, e);
            return null;
        }
    }

    public abstract Map<String, List<String>> getOriginHeaderFields();

    /* access modifiers changed from: protected */
    public abstract InputStream getOriginInputStream();

    public abstract int getStatusCode();

    public void setExceptionError(int i, Throwable th) {
        if (th != null) {
            this.error = new Error(i, th.toString());
        }
    }
}
