package org.android.netutil;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public enum NetListenerType {
    NL_NULL(-1),
    NL_NEW_IP_ADDRESS(0),
    NL_INTERFACE_ON_OFF(1);
    
    private long value;

    private NetListenerType(long j) {
        this.value = j;
    }

    /* access modifiers changed from: package-private */
    public long getValue() {
        return this.value;
    }
}
