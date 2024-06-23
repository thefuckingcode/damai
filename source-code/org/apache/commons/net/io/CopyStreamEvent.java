package org.apache.commons.net.io;

import java.util.EventObject;
import tb.jl1;

/* compiled from: Taobao */
public class CopyStreamEvent extends EventObject {
    public static final long UNKNOWN_STREAM_SIZE = -1;
    private static final long serialVersionUID = -964927635655051867L;
    private final int bytesTransferred;
    private final long streamSize;
    private final long totalBytesTransferred;

    public CopyStreamEvent(Object obj, long j, int i, long j2) {
        super(obj);
        this.bytesTransferred = i;
        this.totalBytesTransferred = j;
        this.streamSize = j2;
    }

    public int getBytesTransferred() {
        return this.bytesTransferred;
    }

    public long getStreamSize() {
        return this.streamSize;
    }

    public long getTotalBytesTransferred() {
        return this.totalBytesTransferred;
    }

    public String toString() {
        return getClass().getName() + "[source=" + ((EventObject) this).source + ", total=" + this.totalBytesTransferred + ", bytes=" + this.bytesTransferred + ", size=" + this.streamSize + jl1.ARRAY_END_STR;
    }
}
