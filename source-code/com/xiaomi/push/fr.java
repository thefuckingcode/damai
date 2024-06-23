package com.xiaomi.push;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
public final class fr extends fl {
    public fr() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fl
    public ByteBuffer a(ByteBuffer byteBuffer) {
        return m485a().length == 0 ? byteBuffer : super.m482a(byteBuffer);
    }

    @Override // com.xiaomi.push.fl, com.xiaomi.push.fl
    public int c() {
        if (m485a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
