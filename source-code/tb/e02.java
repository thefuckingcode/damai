package tb;

import android.text.TextUtils;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import anetwork.channel.Header;
import anetwork.channel.IBodyHandler;
import anetwork.channel.Param;
import anetwork.channel.Request;
import anetwork.channel.entity.BodyHandlerEntry;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class e02 implements Request {
    @Deprecated
    private URI a;
    @Deprecated
    private URL b;
    private String c;
    private boolean d = true;
    private List<Header> e;
    private String f = "GET";
    private List<Param> g;
    private int h = 2;
    private String i = "utf-8";
    private BodyEntry j = null;
    private int k;
    private int l;
    private String m;
    private String n;
    private Map<String, String> o;

    @Deprecated
    public e02(URI uri) {
        this.a = uri;
        this.c = uri.toString();
    }

    @Override // anetwork.channel.Request
    public void addHeader(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.add(new ab(str, str2));
        }
    }

    @Override // anetwork.channel.Request
    public String getBizId() {
        return this.m;
    }

    @Override // anetwork.channel.Request
    public BodyEntry getBodyEntry() {
        return this.j;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public IBodyHandler getBodyHandler() {
        return null;
    }

    @Override // anetwork.channel.Request
    public String getCharset() {
        return this.i;
    }

    @Override // anetwork.channel.Request
    public int getConnectTimeout() {
        return this.k;
    }

    @Override // anetwork.channel.Request
    public Map<String, String> getExtProperties() {
        return this.o;
    }

    @Override // anetwork.channel.Request
    public String getExtProperty(String str) {
        Map<String, String> map = this.o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // anetwork.channel.Request
    public boolean getFollowRedirects() {
        return this.d;
    }

    @Override // anetwork.channel.Request
    public List<Header> getHeaders() {
        return this.e;
    }

    @Override // anetwork.channel.Request
    public String getMethod() {
        return this.f;
    }

    @Override // anetwork.channel.Request
    public List<Param> getParams() {
        return this.g;
    }

    @Override // anetwork.channel.Request
    public int getReadTimeout() {
        return this.l;
    }

    @Override // anetwork.channel.Request
    public int getRetryTime() {
        return this.h;
    }

    @Override // anetwork.channel.Request
    public String getSeqNo() {
        return this.n;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public URI getURI() {
        URI uri = this.a;
        if (uri != null) {
            return uri;
        }
        if (this.c != null) {
            try {
                this.a = new URI(this.c);
            } catch (Exception e2) {
                ALog.d("anet.RequestImpl", "uri error", this.n, e2, new Object[0]);
            }
        }
        return this.a;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public URL getURL() {
        URL url = this.b;
        if (url != null) {
            return url;
        }
        if (this.c != null) {
            try {
                this.b = new URL(this.c);
            } catch (Exception e2) {
                ALog.d("anet.RequestImpl", "url error", this.n, e2, new Object[0]);
            }
        }
        return this.b;
    }

    @Override // anetwork.channel.Request
    public String getUrlString() {
        return this.c;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public boolean isCookieEnabled() {
        return !"false".equals(getExtProperty("EnableCookie"));
    }

    @Override // anetwork.channel.Request
    public void removeHeader(Header header) {
        List<Header> list = this.e;
        if (list != null) {
            list.remove(header);
        }
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setBizId(int i2) {
        this.m = String.valueOf(i2);
    }

    @Override // anetwork.channel.Request
    public void setBodyEntry(BodyEntry bodyEntry) {
        this.j = bodyEntry;
    }

    @Override // anetwork.channel.Request
    public void setBodyHandler(IBodyHandler iBodyHandler) {
        this.j = new BodyHandlerEntry(iBodyHandler);
    }

    @Override // anetwork.channel.Request
    public void setCharset(String str) {
        this.i = str;
    }

    @Override // anetwork.channel.Request
    public void setConnectTimeout(int i2) {
        this.k = i2;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setCookieEnabled(boolean z) {
        setExtProperty("EnableCookie", z ? "true" : "false");
    }

    @Override // anetwork.channel.Request
    public void setExtProperty(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.o == null) {
                this.o = new HashMap();
            }
            this.o.put(str, str2);
        }
    }

    @Override // anetwork.channel.Request
    public void setFollowRedirects(boolean z) {
        this.d = z;
    }

    @Override // anetwork.channel.Request
    public void setHeader(Header header) {
        if (header != null) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            int i2 = 0;
            int size = this.e.size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (header.getName().equalsIgnoreCase(this.e.get(i2).getName())) {
                    this.e.set(i2, header);
                    break;
                }
                i2++;
            }
            if (i2 < this.e.size()) {
                this.e.add(header);
            }
        }
    }

    @Override // anetwork.channel.Request
    public void setHeaders(List<Header> list) {
        this.e = list;
    }

    @Override // anetwork.channel.Request
    public void setMethod(String str) {
        this.f = str;
    }

    @Override // anetwork.channel.Request
    public void setParams(List<Param> list) {
        this.g = list;
    }

    @Override // anetwork.channel.Request
    public void setReadTimeout(int i2) {
        this.l = i2;
    }

    @Override // anetwork.channel.Request
    public void setRetryTime(int i2) {
        this.h = i2;
    }

    @Override // anetwork.channel.Request
    public void setSeqNo(String str) {
        this.n = str;
    }

    @Override // anetwork.channel.Request
    public void setTraceContext(Map<String, String> map) {
        this.o.putAll(map);
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setUri(URI uri) {
        this.a = uri;
    }

    @Override // anetwork.channel.Request
    public Header[] getHeaders(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            if (!(this.e.get(i2) == null || this.e.get(i2).getName() == null || !this.e.get(i2).getName().equalsIgnoreCase(str))) {
                arrayList.add(this.e.get(i2));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Header[] headerArr = new Header[arrayList.size()];
        arrayList.toArray(headerArr);
        return headerArr;
    }

    @Override // anetwork.channel.Request
    public void setBizId(String str) {
        this.m = str;
    }

    @Deprecated
    public e02(URL url) {
        this.b = url;
        this.c = url.toString();
    }

    public e02(String str) {
        this.c = str;
    }
}
