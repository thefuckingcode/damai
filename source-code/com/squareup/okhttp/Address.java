package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
public final class Address {
    final Authenticator authenticator;
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;
    final Proxy proxy;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final String uriHost;
    final int uriPort;

    public Address(String str, int i, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator2, Proxy proxy2, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        Objects.requireNonNull(str, "uriHost == null");
        if (i <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + i);
        } else if (authenticator2 == null) {
            throw new IllegalArgumentException("authenticator == null");
        } else if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        } else if (proxySelector2 != null) {
            this.proxy = proxy2;
            this.uriHost = str;
            this.uriPort = i;
            this.socketFactory = socketFactory2;
            this.sslSocketFactory = sSLSocketFactory;
            this.hostnameVerifier = hostnameVerifier2;
            this.certificatePinner = certificatePinner2;
            this.authenticator = authenticator2;
            this.protocols = Util.immutableList(list);
            this.connectionSpecs = Util.immutableList(list2);
            this.proxySelector = proxySelector2;
        } else {
            throw new IllegalArgumentException("proxySelector == null");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        if (!Util.equal(this.proxy, address.proxy) || !this.uriHost.equals(address.uriHost) || this.uriPort != address.uriPort || !Util.equal(this.sslSocketFactory, address.sslSocketFactory) || !Util.equal(this.hostnameVerifier, address.hostnameVerifier) || !Util.equal(this.certificatePinner, address.certificatePinner) || !Util.equal(this.authenticator, address.authenticator) || !Util.equal(this.protocols, address.protocols) || !Util.equal(this.connectionSpecs, address.connectionSpecs) || !Util.equal(this.proxySelector, address.proxySelector)) {
            return false;
        }
        return true;
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Protocol> getProtocols() {
        return this.protocols;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String getUriHost() {
        return this.uriHost;
    }

    public int getUriPort() {
        return this.uriPort;
    }

    public int hashCode() {
        Proxy proxy2 = this.proxy;
        int i = 0;
        int hashCode = (((((527 + (proxy2 != null ? proxy2.hashCode() : 0)) * 31) + this.uriHost.hashCode()) * 31) + this.uriPort) * 31;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int hashCode2 = (hashCode + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
        int hashCode3 = (hashCode2 + (hostnameVerifier2 != null ? hostnameVerifier2.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner2 = this.certificatePinner;
        if (certificatePinner2 != null) {
            i = certificatePinner2.hashCode();
        }
        return ((((((((hashCode3 + i) * 31) + this.authenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode();
    }
}
