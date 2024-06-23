package org.conscrypt;

import java.nio.ByteBuffer;

public abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() {
        /* class org.conscrypt.BufferAllocator.AnonymousClass1 */

        @Override // org.conscrypt.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i));
        }
    };

    public abstract AllocatedBuffer allocateDirectBuffer(int i);

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
