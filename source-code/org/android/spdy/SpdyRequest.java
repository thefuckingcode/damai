package org.android.spdy;

import com.youku.live.livesdk.wkit.component.Constants;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.a;
import tb.ke1;
import tb.v00;

/* compiled from: Taobao */
public final class SpdyRequest {
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    private int connectionTimeoutMs = 0;
    private String domain;
    private Map<String, String> extHead;
    private String host;
    private String method;
    private int port;
    private RequestPriority priority;
    private String proxyIp = "0.0.0.0";
    private int proxyPort = 0;
    private int requestRdTimeoutMs = 0;
    private int requestTimeoutMs = 0;
    private int retryTimes = 0;
    private URL url;

    public SpdyRequest(URL url2, String str, int i, String str2, int i2, String str3, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.url = url2;
        this.domain = "";
        this.host = str;
        this.port = i;
        if (!(str2 == null || i2 == 0)) {
            this.proxyIp = str2;
            this.proxyPort = i2;
        }
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    private String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.url.getPath());
        if (this.url.getQuery() != null) {
            sb.append("?");
            sb.append(this.url.getQuery());
        }
        if (this.url.getRef() != null) {
            sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb.append(this.url.getRef());
        }
        if (sb.length() == 0) {
            sb.append(v00.DIR);
        }
        return sb.toString();
    }

    public void addHeader(String str, String str2) {
        this.extHead.put(str, str2);
    }

    public void addHeaders(Map<String, String> map) {
        this.extHead.putAll(map);
    }

    public String getAuthority() {
        return this.host + ":" + Integer.toString(this.port) + "/" + this.proxyIp + ":" + this.proxyPort;
    }

    public int getConnectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    /* access modifiers changed from: package-private */
    public String getDomain() {
        return this.domain;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap(5);
        hashMap.put(a.TARGET_PATH_UTF8, getPath());
        hashMap.put(a.TARGET_METHOD_UTF8, this.method);
        hashMap.put(":version", "HTTP/1.1");
        hashMap.put(":host", this.url.getAuthority());
        hashMap.put(a.TARGET_SCHEME_UTF8, this.url.getProtocol());
        Map<String, String> map = this.extHead;
        if (map != null && map.size() > 0) {
            hashMap.putAll(this.extHead);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public String getHost() {
        return this.host;
    }

    /* access modifiers changed from: package-private */
    public String getMethod() {
        return this.method;
    }

    /* access modifiers changed from: package-private */
    public int getPort() {
        int i = this.port;
        if (i < 0) {
            return 80;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public int getPriority() {
        return this.priority.getPriorityInt();
    }

    /* access modifiers changed from: package-private */
    public String getProxyIp() {
        return this.proxyIp;
    }

    /* access modifiers changed from: package-private */
    public int getProxyPort() {
        return this.proxyPort;
    }

    public int getRequestRdTimeoutMs() {
        return this.requestRdTimeoutMs;
    }

    public int getRequestTimeoutMs() {
        return this.requestTimeoutMs;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    /* access modifiers changed from: package-private */
    public URL getUrl() {
        return this.url;
    }

    /* access modifiers changed from: package-private */
    public String getUrlPath() {
        return this.url.getProtocol() + ke1.SCHEME_SLASH + this.url.getAuthority() + getPath();
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setRequestRdTimeoutMs(int i) {
        if (i >= 0) {
            this.requestRdTimeoutMs = i;
        }
    }

    public SpdyRequest(URL url2, String str, int i, String str2, RequestPriority requestPriority) {
        this.url = url2;
        this.domain = "";
        this.host = str;
        this.port = i;
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url2, String str, RequestPriority requestPriority) {
        this.url = url2;
        this.domain = "";
        this.host = url2.getHost();
        int port2 = url2.getPort();
        this.port = port2;
        if (port2 < 0) {
            this.port = url2.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url2, String str, RequestPriority requestPriority, int i, int i2) {
        this.url = url2;
        this.domain = "";
        this.host = url2.getHost();
        int port2 = url2.getPort();
        this.port = port2;
        if (port2 < 0) {
            this.port = url2.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url2, String str) {
        this.url = url2;
        this.domain = "";
        this.host = url2.getHost();
        int port2 = url2.getPort();
        this.port = port2;
        if (port2 < 0) {
            this.port = url2.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }

    public SpdyRequest(URL url2, String str, String str2, int i, String str3, int i2, String str4, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.url = url2;
        this.domain = str;
        this.host = str2;
        this.port = i;
        if (!(str3 == null || i2 == 0)) {
            this.proxyIp = str3;
            this.proxyPort = i2;
        }
        this.method = str4;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    public SpdyRequest(URL url2, String str, String str2, int i, String str3, RequestPriority requestPriority) {
        this.url = url2;
        this.domain = str;
        this.host = str2;
        this.port = i;
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url2, String str, String str2, RequestPriority requestPriority) {
        this.url = url2;
        this.domain = str;
        this.host = url2.getHost();
        int port2 = url2.getPort();
        this.port = port2;
        if (port2 < 0) {
            this.port = url2.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url2, String str, String str2, RequestPriority requestPriority, int i, int i2) {
        this.url = url2;
        this.domain = str;
        this.host = url2.getHost();
        int port2 = url2.getPort();
        this.port = port2;
        if (port2 < 0) {
            this.port = url2.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url2, String str, String str2) {
        this.url = url2;
        this.domain = str;
        this.host = url2.getHost();
        int port2 = url2.getPort();
        this.port = port2;
        if (port2 < 0) {
            this.port = url2.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }
}
