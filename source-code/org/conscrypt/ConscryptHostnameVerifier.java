package org.conscrypt;

import javax.net.ssl.SSLSession;

public interface ConscryptHostnameVerifier {
    boolean verify(String str, SSLSession sSLSession);
}
