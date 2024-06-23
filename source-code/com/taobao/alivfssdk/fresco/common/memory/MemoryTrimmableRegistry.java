package com.taobao.alivfssdk.fresco.common.memory;

/* compiled from: Taobao */
public interface MemoryTrimmableRegistry {
    void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable);

    void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable);
}
