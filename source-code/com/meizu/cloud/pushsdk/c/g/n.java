package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;
import java.io.InterruptedIOException;

/* compiled from: Taobao */
public class n {
    public static final n a = new n() {
        /* class com.meizu.cloud.pushsdk.c.g.n.AnonymousClass1 */

        @Override // com.meizu.cloud.pushsdk.c.g.n
        public void a() {
        }
    };
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
