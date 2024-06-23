package com.squareup.okhttp.internal.spdy;

import java.io.IOException;

/* compiled from: Taobao */
public interface IncomingStreamHandler {
    public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS = new IncomingStreamHandler() {
        /* class com.squareup.okhttp.internal.spdy.IncomingStreamHandler.AnonymousClass1 */

        @Override // com.squareup.okhttp.internal.spdy.IncomingStreamHandler
        public void receive(SpdyStream spdyStream) throws IOException {
            spdyStream.close(ErrorCode.REFUSED_STREAM);
        }
    };

    void receive(SpdyStream spdyStream) throws IOException;
}
