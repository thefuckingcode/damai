package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.h;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;

@Immutable
@Beta
@GwtCompatible
/* compiled from: Taobao */
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i, boolean z) {
        this.host = str;
        this.port = i;
        this.hasBracketlessColons = z;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        ds1.k(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i) {
        ds1.f(isValidPort(i), "Port out of range: %s", i);
        HostAndPort fromString = fromString(str);
        ds1.k(!fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.host, i, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        ds1.p(str);
        int i = -1;
        boolean z = false;
        if (str.startsWith(jl1.ARRAY_START_STR)) {
            String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
            str2 = hostAndPortFromBracketedHost[0];
            str3 = hostAndPortFromBracketedHost[1];
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                int i2 = indexOf + 1;
                if (str.indexOf(58, i2) == -1) {
                    str2 = str.substring(0, indexOf);
                    str3 = str.substring(i2);
                }
            }
            if (indexOf >= 0) {
                z = true;
            }
            str3 = null;
            str2 = str;
        }
        if (!h.a(str3)) {
            ds1.k(!str3.startsWith(jl1.PLUS), "Unparseable port number: %s", str);
            try {
                i = Integer.parseInt(str3);
                ds1.k(isValidPort(i), "Port number out of range: %s", str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new HostAndPort(str2, i, z);
    }

    private static String[] getHostAndPortFromBracketedHost(String str) {
        ds1.k(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        ds1.k(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
        String substring = str.substring(1, lastIndexOf);
        int i = lastIndexOf + 1;
        if (i == str.length()) {
            return new String[]{substring, ""};
        }
        ds1.k(str.charAt(i) == ':', "Only a colon may follow a close bracket: %s", str);
        int i2 = lastIndexOf + 2;
        for (int i3 = i2; i3 < str.length(); i3++) {
            ds1.k(Character.isDigit(str.charAt(i3)), "Port must be numeric: %s", str);
        }
        return new String[]{substring, str.substring(i2)};
    }

    private static boolean isValidPort(int i) {
        return i >= 0 && i <= 65535;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        if (!rk1.a(this.host, hostAndPort.host) || this.port != hostAndPort.port) {
            return false;
        }
        return true;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        ds1.w(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i) {
        return hasPort() ? this.port : i;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return rk1.b(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        ds1.k(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append(jl1.ARRAY_START);
            sb.append(this.host);
            sb.append(jl1.ARRAY_END);
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(jl1.CONDITION_IF_MIDDLE);
            sb.append(this.port);
        }
        return sb.toString();
    }

    public HostAndPort withDefaultPort(int i) {
        ds1.d(isValidPort(i));
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(this.host, i, this.hasBracketlessColons);
    }
}
