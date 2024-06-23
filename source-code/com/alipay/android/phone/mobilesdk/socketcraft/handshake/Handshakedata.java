package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

import java.util.Iterator;

/* compiled from: Taobao */
public interface Handshakedata {
    byte[] getContent();

    String getFieldValue(String str);

    boolean hasFieldValue(String str);

    Iterator<String> iterateHttpFields();
}
