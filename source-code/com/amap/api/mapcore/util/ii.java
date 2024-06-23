package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Taobao */
public abstract class ii {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;
    int a = 20000;
    int b = 20000;
    Proxy c = null;

    private String a(String str) {
        Map<String, String> params;
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0 || (params = getParams()) == null) {
            return str;
        }
        String a2 = ig.a(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return a(getURL());
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return a(getIPV6URL());
    }

    /* access modifiers changed from: package-private */
    public byte[] d() {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes != null && entityBytes.length != 0) {
            return entityBytes;
        }
        String a2 = ig.a(getParams());
        return !TextUtils.isEmpty(a2) ? gn.a(a2) : entityBytes;
    }

    public int getConntectionTimeout() {
        return this.a;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public int getSoTimeout() {
        return this.b;
    }

    public abstract String getURL();

    /* access modifiers changed from: protected */
    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public final void setConnectionTimeout(int i) {
        this.a = i;
    }

    public final void setProxy(Proxy proxy) {
        this.c = proxy;
    }

    public final void setSoTimeout(int i) {
        this.b = i;
    }
}
