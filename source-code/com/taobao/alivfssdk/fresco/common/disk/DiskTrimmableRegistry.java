package com.taobao.alivfssdk.fresco.common.disk;

/* compiled from: Taobao */
public interface DiskTrimmableRegistry {
    void registerDiskTrimmable(DiskTrimmable diskTrimmable);

    void unregisterDiskTrimmable(DiskTrimmable diskTrimmable);
}
