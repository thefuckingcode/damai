package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* compiled from: Taobao */
public abstract class dp extends ii {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return null;
    }

    /* access modifiers changed from: protected */
    public byte[] makeHttpRequest() throws gb {
        int protocol = MapsInitializer.getProtocol();
        ih a = ih.a(false);
        if (protocol == 1) {
            if (this.isPostFlag) {
                return a.b(this);
            }
            return a.d(this);
        } else if (protocol != 2) {
            return null;
        } else {
            if (this.isPostFlag) {
                return a.a(this);
            }
            return a.e(this);
        }
    }
}
