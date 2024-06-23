package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: Taobao */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta = 0.0f;

    public HoverGestureMapMessage(int i, float f) {
        super(i);
        this.angleDelta = f;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static HoverGestureMapMessage obtain(int i, float f) {
        HoverGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            acquire = new HoverGestureMapMessage(i, f);
        } else {
            acquire.reset();
        }
        acquire.setParams(i, f);
        return acquire;
    }

    private void setParams(int i, float f) {
        setState(i);
        this.angleDelta = f;
    }

    @Override // com.autonavi.base.ae.gmap.AbstractMapMessage, com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public int getType() {
        return 3;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        if (cameraDegree < 0.0f) {
            cameraDegree = 0.0f;
        } else if (cameraDegree > 80.0f) {
            cameraDegree = 80.0f;
        } else if (gLMapState.getCameraDegree() > 40.0f && cameraDegree > 40.0f && gLMapState.getCameraDegree() > cameraDegree) {
            cameraDegree = 40.0f;
        }
        gLMapState.setCameraDegree(cameraDegree);
        gLMapState.recalculate();
    }
}
