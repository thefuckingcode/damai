package org.android.spdy;

/* compiled from: Taobao */
public class SpdyStreamContext {
    public Spdycb callBack;
    public Object streamContext;
    public int streamId;

    SpdyStreamContext(Object obj) {
        this.streamContext = obj;
        this.callBack = null;
        this.streamId = -1;
    }

    static int getContext(Object obj) {
        if (obj == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    SpdyStreamContext(Object obj, Spdycb spdycb) {
        this.streamContext = obj;
        this.callBack = spdycb;
    }
}
