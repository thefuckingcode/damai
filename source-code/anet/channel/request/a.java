package anet.channel.request;

import android.text.TextUtils;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import tb.h9;
import tb.jl1;
import tb.ju2;
import tb.yy0;

/* compiled from: Taobao */
public class a {
    public static final String DEFAULT_CHARSET = "UTF-8";
    private yy0 a;
    private yy0 b;
    private yy0 c;
    private URL d;
    private String e;
    private Map<String, String> f;
    private Map<String, String> g;
    private String h;
    private BodyEntry i;
    private boolean j;
    private String k;
    private String l;
    private int m;
    private int n;
    private int o;
    private HostnameVerifier p;
    private SSLSocketFactory q;
    public final RequestStatistic r;
    private boolean s;

    /* compiled from: Taobao */
    public static class b {
        private yy0 a;
        private yy0 b;
        private String c = "GET";
        private Map<String, String> d = new HashMap();
        private Map<String, String> e;
        private String f;
        private BodyEntry g;
        private boolean h = true;
        private int i = 0;
        private HostnameVerifier j;
        private SSLSocketFactory k;
        private String l;
        private String m;
        private int n = 10000;
        private int o = 10000;
        private RequestStatistic p = null;
        private boolean q;

        public b I(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public a J() {
            if (this.g == null && this.e == null && c.b(this.c)) {
                ALog.e("awcn.Request", "method " + this.c + " must have a request body", null, new Object[0]);
            }
            if (this.g != null && !c.a(this.c)) {
                ALog.e("awcn.Request", "method " + this.c + " should not have a request body", null, new Object[0]);
                this.g = null;
            }
            BodyEntry bodyEntry = this.g;
            if (!(bodyEntry == null || bodyEntry.getContentType() == null)) {
                I("Content-Type", this.g.getContentType());
            }
            return new a(this);
        }

        public b K(boolean z) {
            this.q = z;
            return this;
        }

        public b L(String str) {
            this.l = str;
            return this;
        }

        public b M(BodyEntry bodyEntry) {
            this.g = bodyEntry;
            return this;
        }

        public b N(String str) {
            this.f = str;
            this.b = null;
            return this;
        }

        public b O(int i2) {
            if (i2 > 0) {
                this.n = i2;
            }
            return this;
        }

        public b P(Map<String, String> map) {
            this.d.clear();
            if (map != null) {
                this.d.putAll(map);
            }
            return this;
        }

        public b Q(HostnameVerifier hostnameVerifier) {
            this.j = hostnameVerifier;
            return this;
        }

        public b R(String str) {
            if (!TextUtils.isEmpty(str)) {
                if ("GET".equalsIgnoreCase(str)) {
                    this.c = "GET";
                } else if ("POST".equalsIgnoreCase(str)) {
                    this.c = "POST";
                } else if (c.OPTION.equalsIgnoreCase(str)) {
                    this.c = c.OPTION;
                } else if (c.HEAD.equalsIgnoreCase(str)) {
                    this.c = c.HEAD;
                } else if (c.PUT.equalsIgnoreCase(str)) {
                    this.c = c.PUT;
                } else if (c.DELETE.equalsIgnoreCase(str)) {
                    this.c = c.DELETE;
                } else {
                    this.c = "GET";
                }
                return this;
            }
            throw new IllegalArgumentException("method is null or empty");
        }

        public b S(Map<String, String> map) {
            this.e = map;
            this.b = null;
            return this;
        }

        public b T(int i2) {
            if (i2 > 0) {
                this.o = i2;
            }
            return this;
        }

        public b U(boolean z) {
            this.h = z;
            return this;
        }

        public b V(int i2) {
            this.i = i2;
            return this;
        }

        public b W(RequestStatistic requestStatistic) {
            this.p = requestStatistic;
            return this;
        }

        public b X(String str) {
            this.m = str;
            return this;
        }

        public b Y(SSLSocketFactory sSLSocketFactory) {
            this.k = sSLSocketFactory;
            return this;
        }

        public b Z(String str) {
            yy0 g2 = yy0.g(str);
            this.a = g2;
            this.b = null;
            if (g2 != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }

        public b a0(yy0 yy0) {
            this.a = yy0;
            this.b = null;
            return this;
        }
    }

    /* compiled from: Taobao */
    public static final class c {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean a(String str) {
            return b(str) || str.equals(DELETE) || str.equals(OPTION);
        }

        static boolean b(String str) {
            return str.equals("POST") || str.equals(PUT);
        }
    }

    private void b() {
        String b2 = ju2.b(this.g, f());
        if (!TextUtils.isEmpty(b2)) {
            if (!c.b(this.e) || this.i != null) {
                String n2 = this.a.n();
                StringBuilder sb = new StringBuilder(n2);
                if (sb.indexOf("?") == -1) {
                    sb.append(jl1.CONDITION_IF);
                } else if (n2.charAt(n2.length() - 1) != '&') {
                    sb.append('&');
                }
                sb.append(b2);
                yy0 g2 = yy0.g(sb.toString());
                if (g2 != null) {
                    this.b = g2;
                }
            } else {
                try {
                    this.i = new ByteArrayEntry(b2.getBytes(f()));
                    Map<String, String> map = this.f;
                    map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + f());
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        if (this.b == null) {
            this.b = this.a;
        }
    }

    private Map<String, String> t() {
        if (h9.q()) {
            return new HashMap(this.f);
        }
        return this.f;
    }

    public boolean a() {
        return this.i != null;
    }

    public String c() {
        return this.k;
    }

    public byte[] d() {
        if (this.i == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            v(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int e() {
        return this.n;
    }

    public String f() {
        String str = this.h;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> g() {
        return Collections.unmodifiableMap(this.f);
    }

    public String h() {
        return this.b.d();
    }

    public HostnameVerifier i() {
        return this.p;
    }

    public yy0 j() {
        return this.b;
    }

    public String k() {
        return this.e;
    }

    public int l() {
        return this.o;
    }

    public int m() {
        return this.m;
    }

    public String n() {
        return this.l;
    }

    public SSLSocketFactory o() {
        return this.q;
    }

    public URL p() {
        if (this.d == null) {
            yy0 yy0 = this.c;
            if (yy0 == null) {
                yy0 = this.b;
            }
            this.d = yy0.m();
        }
        return this.d;
    }

    public String q() {
        return this.b.n();
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.j;
    }

    public b u() {
        b bVar = new b();
        bVar.c = this.e;
        bVar.d = t();
        bVar.e = this.g;
        bVar.g = this.i;
        bVar.f = this.h;
        bVar.h = this.j;
        bVar.i = this.m;
        bVar.j = this.p;
        bVar.k = this.q;
        bVar.a = this.a;
        bVar.b = this.b;
        bVar.l = this.k;
        bVar.m = this.l;
        bVar.n = this.n;
        bVar.o = this.o;
        bVar.p = this.r;
        bVar.q = this.s;
        return bVar;
    }

    public int v(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.i;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void w(String str, int i2) {
        if (str != null) {
            if (this.c == null) {
                this.c = new yy0(this.b);
            }
            this.c.i(str, i2);
        } else {
            this.c = null;
        }
        this.d = null;
        this.r.setIPAndPort(str, i2);
    }

    public void x(boolean z) {
        if (this.c == null) {
            this.c = new yy0(this.b);
        }
        this.c.k(z ? "https" : "http");
        this.d = null;
    }

    private a(b bVar) {
        this.e = "GET";
        this.j = true;
        this.m = 0;
        this.n = 10000;
        this.o = 10000;
        this.e = bVar.c;
        this.f = bVar.d;
        this.g = bVar.e;
        this.i = bVar.g;
        this.h = bVar.f;
        this.j = bVar.h;
        this.m = bVar.i;
        this.p = bVar.j;
        this.q = bVar.k;
        this.k = bVar.l;
        this.l = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.a = bVar.a;
        yy0 yy0 = bVar.b;
        this.b = yy0;
        if (yy0 == null) {
            b();
        }
        this.r = bVar.p != null ? bVar.p : new RequestStatistic(h(), this.k);
        this.s = bVar.q;
    }
}
