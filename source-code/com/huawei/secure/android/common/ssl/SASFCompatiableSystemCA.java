package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: Taobao */
public class SASFCompatiableSystemCA extends SSLSocketFactory {
    private static final String i = SASFCompatiableSystemCA.class.getSimpleName();
    private static volatile SASFCompatiableSystemCA j = null;
    private SSLContext a;
    private SSLSocket b;
    private Context c;
    private String[] d;
    private X509TrustManager e;
    private String[] f;
    private String[] g;
    private String[] h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.b = null;
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            g.b(i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            g.b(i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            g.b(i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            g.b(i, "KeyStoreException");
        }
        String str = i;
        g.a(str, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        c.a(context);
        if (j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (j == null) {
                    j = new SASFCompatiableSystemCA(keyStore, context);
                }
            }
        }
        return j;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory, org.apache.http.conn.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        g.c(i, "createSocket: socket host port autoClose");
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.c;
    }

    public String[] getProtocols() {
        return this.h;
    }

    public SSLContext getSslContext() {
        return this.a;
    }

    public SSLSocket getSslSocket() {
        return this.b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f = strArr;
    }

    public void setContext(Context context) {
        this.c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.b = null;
        if (context == null) {
            g.b(i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SSFSecureX509SingleInstance.getInstance(context);
        this.e = instance;
        this.a.init(null, new X509TrustManager[]{instance}, null);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory, org.apache.http.conn.ssl.SSLSocketFactory
    public Socket createSocket() throws IOException {
        g.c(i, "createSocket: ");
        Socket createSocket = this.a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (!a.a(this.h)) {
            g.c(i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.h);
            z = true;
        } else {
            z = false;
        }
        if (!a.a(this.g) || !a.a(this.f)) {
            g.c(i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f);
            }
        } else {
            z2 = false;
        }
        if (!z) {
            g.c(i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z2) {
            g.c(i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
