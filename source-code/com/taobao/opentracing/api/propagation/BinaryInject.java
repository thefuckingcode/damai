package com.taobao.opentracing.api.propagation;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
public interface BinaryInject {
    ByteBuffer injectionBuffer(int i);
}
