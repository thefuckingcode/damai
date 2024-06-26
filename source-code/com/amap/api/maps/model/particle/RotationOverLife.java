package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AbstractNativeInstance;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

/* compiled from: Taobao */
public abstract class RotationOverLife extends AbstractNativeInstance {
    protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
    protected final int TYPE_DEFAULT = -1;
    protected int type = -1;

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void finalize() throws Throwable {
        super.finalize();
        long j = this.nativeInstance;
        if (j != 0) {
            AMapNativeParticleSystem.nativeReleaseRotationOverLife(j);
            this.nativeInstance = 0;
        }
    }

    public abstract float getRotate();
}
