package com.autonavi.base.ae.gmap.maploader;

import com.autonavi.ae.gmap.maploader.Pools;

/* compiled from: Taobao */
public class ProcessingTile {
    private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = new Pools.SynchronizedPool<>(30);
    public long mCreateTime = 0;
    public String mKeyName;

    public ProcessingTile(String str) {
        setParams(str);
    }

    public static ProcessingTile obtain(String str) {
        ProcessingTile acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ProcessingTile(str);
        }
        acquire.setParams(str);
        return acquire;
    }

    private void setParams(String str) {
        this.mKeyName = str;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0;
        M_POOL.release(this);
    }
}
