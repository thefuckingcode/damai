package com.squareup.okhttp;

import java.io.IOException;

/* compiled from: Taobao */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String protocol;

    private Protocol(String str) {
        this.protocol = str;
    }

    public static Protocol get(String str) throws IOException {
        Protocol protocol2 = HTTP_1_0;
        if (str.equals(protocol2.protocol)) {
            return protocol2;
        }
        Protocol protocol3 = HTTP_1_1;
        if (str.equals(protocol3.protocol)) {
            return protocol3;
        }
        Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.protocol)) {
            return protocol4;
        }
        Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.protocol)) {
            return protocol5;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.protocol;
    }
}
