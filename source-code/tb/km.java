package tb;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* compiled from: Taobao */
public class km extends oq1 {
    private km() {
    }

    public static km s() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new km();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider t() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // tb.oq1
    public void f(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // tb.oq1
    public void g(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) oq1.b(list).toArray(new String[0]));
            return;
        }
        super.g(sSLSocket, str, list);
    }

    @Override // tb.oq1
    public SSLContext l() {
        try {
            return SSLContext.getInstance("TLSv1.3", t());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", t());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    @Override // tb.oq1
    @Nullable
    public String m(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.m(sSLSocket);
    }
}
