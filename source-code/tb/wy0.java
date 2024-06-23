package tb;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
public class wy0 {
    @Deprecated
    public static final HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = null;
    @Deprecated
    public static final SSLSocketFactory TRUST_ALL_SSL_SOCKET_FACTORY = null;
    static SSLSocketFactory a;
    static HostnameVerifier b;

    public static HostnameVerifier a() {
        return b;
    }

    public static SSLSocketFactory b() {
        return a;
    }
}
