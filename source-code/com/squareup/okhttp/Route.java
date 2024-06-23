package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* compiled from: Taobao */
public final class Route {
    final Address address;
    final ConnectionSpec connectionSpec;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;
    final boolean shouldSendTlsFallbackIndicator;

    public Route(Address address2, Proxy proxy2, InetSocketAddress inetSocketAddress2, ConnectionSpec connectionSpec2) {
        this(address2, proxy2, inetSocketAddress2, connectionSpec2, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        if (!this.address.equals(route.address) || !this.proxy.equals(route.proxy) || !this.inetSocketAddress.equals(route.inetSocketAddress) || !this.connectionSpec.equals(route.connectionSpec) || this.shouldSendTlsFallbackIndicator != route.shouldSendTlsFallbackIndicator) {
            return false;
        }
        return true;
    }

    public Address getAddress() {
        return this.address;
    }

    public ConnectionSpec getConnectionSpec() {
        return this.connectionSpec;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public boolean getShouldSendTlsFallbackIndicator() {
        return this.shouldSendTlsFallbackIndicator;
    }

    public InetSocketAddress getSocketAddress() {
        return this.inetSocketAddress;
    }

    public int hashCode() {
        return ((((((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode()) * 31) + this.connectionSpec.hashCode()) * 31) + (this.shouldSendTlsFallbackIndicator ? 1 : 0);
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public Route(Address address2, Proxy proxy2, InetSocketAddress inetSocketAddress2, ConnectionSpec connectionSpec2, boolean z) {
        Objects.requireNonNull(address2, "address == null");
        Objects.requireNonNull(proxy2, "proxy == null");
        Objects.requireNonNull(inetSocketAddress2, "inetSocketAddress == null");
        Objects.requireNonNull(connectionSpec2, "connectionConfiguration == null");
        this.address = address2;
        this.proxy = proxy2;
        this.inetSocketAddress = inetSocketAddress2;
        this.connectionSpec = connectionSpec2;
        this.shouldSendTlsFallbackIndicator = z;
    }
}
