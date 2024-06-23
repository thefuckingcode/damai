package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Taobao */
public abstract class q0 {
    s0 a = new s0(this.b);
    private ByteBuffer b;

    q0(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
    }

    public final q0 a() {
        this.a.c(this.b);
        return this;
    }
}
