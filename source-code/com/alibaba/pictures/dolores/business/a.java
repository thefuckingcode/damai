package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.utils.ReqMethodEnum;
import com.alibaba.pictures.dolores.utils.ReqProtocolEnum;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Objects;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aa;
import tb.k21;
import tb.m40;
import tb.vp;
import tb.zy0;

/* compiled from: Taobao */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C0093a Companion = new C0093a(null);
    @Nullable
    private aa<?> a;
    private long b;
    private ReqMethodEnum c;
    private ReqProtocolEnum d;
    private Map<String, String> e;
    @Nullable
    private final HttpURLConnection f;

    /* renamed from: com.alibaba.pictures.dolores.business.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0093a {
        private C0093a() {
        }

        public /* synthetic */ C0093a(m40 m40) {
            this();
        }
    }

    public a(@Nullable String str, @Nullable Long l) {
        this.b = 3000;
        this.c = ReqMethodEnum.POST;
        this.d = ReqProtocolEnum.HTTP_SECURE;
        if (str != null) {
            str.length();
        }
        if (l != null) {
            this.b = l.longValue();
        }
    }

    private final HttpURLConnection d(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689248910")) {
            return (HttpURLConnection) ipChange.ipc$dispatch("-1689248910", new Object[]{this, str});
        }
        ReqProtocolEnum reqProtocolEnum = ReqProtocolEnum.HTTP_SECURE;
        if (o.J(str, reqProtocolEnum.getProtocol(), true)) {
            ReqProtocolEnum reqProtocolEnum2 = this.d;
            ReqProtocolEnum reqProtocolEnum3 = ReqProtocolEnum.HTTP;
            if (reqProtocolEnum2 == reqProtocolEnum3) {
                String unused = o.G(str, reqProtocolEnum.getProtocol(), reqProtocolEnum3.getProtocol(), true);
            }
        } else {
            ReqProtocolEnum reqProtocolEnum4 = ReqProtocolEnum.HTTP;
            if (!(o.J(str, reqProtocolEnum4.getProtocol(), true))) {
                str = this.d.getProtocol() + str;
            } else if (this.d == reqProtocolEnum) {
                String unused2 = o.G(str, reqProtocolEnum4.getProtocol(), reqProtocolEnum.getProtocol(), true);
            }
        }
        URLConnection openConnection = new URL(str).openConnection();
        Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout((int) this.b);
        httpURLConnection.setReadTimeout((int) this.b);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod(this.c.getMethodName());
        return httpURLConnection;
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457956694")) {
            ipChange.ipc$dispatch("-1457956694", new Object[]{this});
            return;
        }
        try {
            HttpURLConnection httpURLConnection = this.f;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e2) {
            vp.b("HttpUrlBusiness", e2);
        }
    }

    @Nullable
    public final aa<?> b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1329772598")) {
            return this.a;
        }
        return (aa) ipChange.ipc$dispatch("1329772598", new Object[]{this});
    }

    public final void c(@NotNull Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028460204")) {
            ipChange.ipc$dispatch("2028460204", new Object[]{this, map});
            return;
        }
        k21.i(map, "extHeader");
        this.e = map;
    }

    public final void e(@NotNull ReqProtocolEnum reqProtocolEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728752927")) {
            ipChange.ipc$dispatch("1728752927", new Object[]{this, reqProtocolEnum});
            return;
        }
        k21.i(reqProtocolEnum, "protocolEnum");
        this.d = reqProtocolEnum;
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final byte[] f(@NotNull InputStream inputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "835069557")) {
            return (byte[]) ipChange.ipc$dispatch("835069557", new Object[]{this, inputStream});
        }
        k21.i(inputStream, "inputStream");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e2) {
            vp.b("HttpUrlBusiness", e2);
            inputStream.close();
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th) {
            inputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public final void g(@NotNull ReqMethodEnum reqMethodEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624477411")) {
            ipChange.ipc$dispatch("1624477411", new Object[]{this, reqMethodEnum});
            return;
        }
        k21.i(reqMethodEnum, "methodEnum");
        this.c = reqMethodEnum;
    }

    public final void h(@Nullable aa<?> aaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287093136")) {
            ipChange.ipc$dispatch("1287093136", new Object[]{this, aaVar});
            return;
        }
        this.a = aaVar;
    }

    @NotNull
    public final zy0 i() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878842420")) {
            return (zy0) ipChange.ipc$dispatch("-878842420", new Object[]{this});
        }
        zy0 zy0 = new zy0();
        try {
            aa<?> aaVar = this.a;
            if (!(aaVar == null || (str = aaVar.a) == null)) {
                HttpURLConnection d2 = d(str);
                d2.connect();
                zy0.m(Integer.valueOf(d2.getResponseCode()));
                Integer d3 = zy0.d();
                if (d3 != null) {
                    if (d3.intValue() == 200) {
                        zy0.k(Boolean.TRUE);
                        InputStream inputStream = d2.getInputStream();
                        k21.h(inputStream, "inputStream");
                        byte[] f2 = f(inputStream);
                        if (f2 != null) {
                            zy0.l(f2);
                        }
                    }
                }
                zy0.k(Boolean.FALSE);
                zy0.l(null);
            }
        } catch (IOException e2) {
            zy0.m(-1);
            zy0.n("请求抛出异常" + e2.getMessage());
            zy0.k(Boolean.FALSE);
        }
        return zy0;
    }

    public a() {
        this(null, null);
    }
}
