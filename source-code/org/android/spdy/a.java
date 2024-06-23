package org.android.spdy;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    private static volatile boolean e;
    private static final Object f = new Object();
    private static a g = new a();
    private Set<TrustAnchor> a;
    private volatile PKIXParameters b;
    private volatile CertPathValidator c;
    private volatile CertificateFactory d;

    private a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = new HashSet();
    }

    static a e() {
        return g;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0034 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0036 A[SYNTHETIC, Splitter:B:31:0x0036] */
    public synchronized void a() {
        CertificateFactory certificateFactory;
        NoSuchAlgorithmException e2;
        CertificateException e3;
        if (!e) {
            boolean z = false;
            try {
                certificateFactory = CertificateFactory.getInstance("X.509");
                try {
                    CertPathValidator instance = CertPathValidator.getInstance("PKIX");
                    synchronized (f) {
                        this.d = certificateFactory;
                        this.c = instance;
                    }
                    z = true;
                } catch (NoSuchAlgorithmException e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    if (z) {
                    }
                } catch (CertificateException e5) {
                    e3 = e5;
                    e3.printStackTrace();
                    if (z) {
                    }
                }
            } catch (NoSuchAlgorithmException e6) {
                e2 = e6;
                certificateFactory = null;
                e2.printStackTrace();
                if (z) {
                }
            } catch (CertificateException e7) {
                e3 = e7;
                certificateFactory = null;
                e3.printStackTrace();
                if (z) {
                }
            }
            if (z) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIIDdTCCAl2gAwIBAgILBAAAAAABFUtaw5QwDQYJKoZIhvcNAQEFBQAwVzELMAkG\nA1UEBhMCQkUxGTAXBgNVBAoTEEdsb2JhbFNpZ24gbnYtc2ExEDAOBgNVBAsTB1Jv\nb3QgQ0ExGzAZBgNVBAMTEkdsb2JhbFNpZ24gUm9vdCBDQTAeFw05ODA5MDExMjAw\nMDBaFw0yODAxMjgxMjAwMDBaMFcxCzAJBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9i\nYWxTaWduIG52LXNhMRAwDgYDVQQLEwdSb290IENBMRswGQYDVQQDExJHbG9iYWxT\naWduIFJvb3QgQ0EwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDaDuaZ\njc6j40+Kfvvxi4Mla+pIH/EqsLmVEQS98GPR4mdmzxzdzxtIK+6NiY6arymAZavp\nxy0Sy6scTHAHoT0KMM0VjU/43dSMUBUc71DuxC73/OlS8pF94G3VNTCOXkNz8kHp\n1Wrjsok6Vjk4bwY8iGlbKk3Fp1S4bInMm/k8yuX9ifUSPJJ4ltbcdG6TRGHRjcdG\nsnUOhugZitVtbNV4FpWi6cgKOOvyJBNPc1STE4U6G7weNLWLBYy5d4ux2x8gkasJ\nU26Qzns3dLlwR5EiUWMWea6xrkEmCMgZK9FGqkjWZCrXgzT/LCrBbBlDSgeF59N8\n9iFo7+ryUp9/k5DPAgMBAAGjQjBAMA4GA1UdDwEB/wQEAwIBBjAPBgNVHRMBAf8E\nBTADAQH/MB0GA1UdDgQWBBRge2YaRQ2XyolQL30EzTSo//z9SzANBgkqhkiG9w0B\nAQUFAAOCAQEA1nPnfE920I2/7LqivjTFKDK1fPxsnCwrvQmeU79rXqoRSLblCKOz\nyj1hTdNGCbM+w6DjY1Ub8rrvrTnhQ7k4o+YviiY776BQVvnGCv04zcQLcFGUl5gE\n38NflNUVyRRBnMRddWQVDf9VMOyGj/8N7yy5Y0b2qvzfvGn9LhJIZJrglfCm7ymP\nAbEVtQwdpf5pLGkkeB6zpxxxYu7KyJesF12KwvhHhm4qxFYxldBniYUr+WymXUad\nDKqC5JlR3XC321Y9YeRq4VzW9v493kHMB65jUr9TU/Qr6cf9tveCX4XSQRjbgbME\nHMUfpIBvFSDJ3gyICh3WZlXi/EjJKSZp4A==\n-----END CERTIFICATE-----\n".getBytes(StandardCharsets.ISO_8859_1)));
                    synchronized (f) {
                        this.a.add(new TrustAnchor(x509Certificate, null));
                        Set<TrustAnchor> set = this.a;
                        if (set != null) {
                            g(set);
                        }
                    }
                    e = true;
                } catch (CertificateException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CertPathValidator b() {
        CertPathValidator certPathValidator;
        synchronized (f) {
            certPathValidator = this.c;
        }
        return certPathValidator;
    }

    /* access modifiers changed from: package-private */
    public PKIXParameters c() {
        PKIXParameters pKIXParameters;
        synchronized (f) {
            pKIXParameters = this.b;
        }
        return pKIXParameters;
    }

    public CertificateFactory d() {
        CertificateFactory certificateFactory;
        synchronized (f) {
            if (this.d == null) {
                try {
                    this.d = CertificateFactory.getInstance("X.509");
                } catch (CertificateException e2) {
                    e2.printStackTrace();
                }
            }
            certificateFactory = this.d;
        }
        return certificateFactory;
    }

    public Set<TrustAnchor> f() {
        Set<TrustAnchor> set;
        synchronized (f) {
            set = this.a;
        }
        return set;
    }

    /* access modifiers changed from: package-private */
    public PKIXParameters g(Set<TrustAnchor> set) {
        InvalidAlgorithmParameterException e2;
        PKIXParameters pKIXParameters = null;
        if (set == null) {
            return null;
        }
        try {
            PKIXParameters pKIXParameters2 = new PKIXParameters(set);
            try {
                pKIXParameters2.setRevocationEnabled(false);
                this.b = pKIXParameters2;
                return pKIXParameters2;
            } catch (InvalidAlgorithmParameterException e3) {
                e2 = e3;
                pKIXParameters = pKIXParameters2;
                e2.printStackTrace();
                return pKIXParameters;
            }
        } catch (InvalidAlgorithmParameterException e4) {
            e2 = e4;
            e2.printStackTrace();
            return pKIXParameters;
        }
    }
}
