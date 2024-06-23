package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* compiled from: Taobao */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        /* class com.squareup.okhttp.internal.spdy.PushObserver.AnonymousClass1 */

        @Override // com.squareup.okhttp.internal.spdy.PushObserver
        public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip((long) i2);
            return true;
        }

        @Override // com.squareup.okhttp.internal.spdy.PushObserver
        public boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        @Override // com.squareup.okhttp.internal.spdy.PushObserver
        public boolean onRequest(int i, List<Header> list) {
            return true;
        }

        @Override // com.squareup.okhttp.internal.spdy.PushObserver
        public void onReset(int i, ErrorCode errorCode) {
        }
    };

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
