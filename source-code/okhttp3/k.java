package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.a;

/* compiled from: Taobao */
public final class k {
    private final TlsVersion a;
    private final e b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private k(TlsVersion tlsVersion, e eVar, List<Certificate> list, List<Certificate> list2) {
        this.a = tlsVersion;
        this.b = eVar;
        this.c = list;
        this.d = list2;
    }

    public static k b(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            e b2 = e.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = a.u(certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = a.u(localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new k(forJavaName, b2, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public static k c(TlsVersion tlsVersion, e eVar, List<Certificate> list, List<Certificate> list2) {
        Objects.requireNonNull(tlsVersion, "tlsVersion == null");
        Objects.requireNonNull(eVar, "cipherSuite == null");
        return new k(tlsVersion, eVar, a.t(list), a.t(list2));
    }

    private List<String> e(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public e a() {
        return this.b;
    }

    public List<Certificate> d() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!this.a.equals(kVar.a) || !this.b.equals(kVar.b) || !this.c.equals(kVar.c) || !this.d.equals(kVar.d)) {
            return false;
        }
        return true;
    }

    public List<Certificate> f() {
        return this.c;
    }

    public TlsVersion g() {
        return this.a;
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.a + " cipherSuite=" + this.b + " peerCertificates=" + e(this.c) + " localCertificates=" + e(this.d) + '}';
    }
}
