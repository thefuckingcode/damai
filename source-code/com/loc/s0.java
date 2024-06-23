package com.loc;

import java.nio.ByteBuffer;
import tb.y43;
import tb.z53;

/* compiled from: Taobao */
public final class s0 extends z53 {
    s0(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // tb.z53
    public final int b(CharSequence charSequence) {
        try {
            return super.b(charSequence);
        } catch (Throwable th) {
            y43.a(th);
            return super.b("");
        }
    }
}
