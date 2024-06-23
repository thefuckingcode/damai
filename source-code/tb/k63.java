package tb;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
public class k63 implements HostnameVerifier {
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
