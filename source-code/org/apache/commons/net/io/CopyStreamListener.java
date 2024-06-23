package org.apache.commons.net.io;

import java.util.EventListener;

/* compiled from: Taobao */
public interface CopyStreamListener extends EventListener {
    void bytesTransferred(long j, int i, long j2);

    void bytesTransferred(CopyStreamEvent copyStreamEvent);
}
