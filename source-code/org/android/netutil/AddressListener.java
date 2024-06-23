package org.android.netutil;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public abstract class AddressListener extends NetListener {
    public AddressListener() {
        super(NetListenerType.NL_NEW_IP_ADDRESS);
    }

    public abstract void onNewAddress(String str);
}
