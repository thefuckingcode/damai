package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AbstractNativeInstance;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

/* compiled from: Taobao */
public abstract class SizeOverLife extends AbstractNativeInstance {
    public final int DEFAULT_SIZE = 0;
    protected final int TYPE_CURVESIZEOVERLIFE = 0;
    protected final int TYPE_DEFAULT = -1;
    protected int type = -1;

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void finalize() throws Throwable {
        super.finalize();
        long j = this.nativeInstance;
        if (j != 0) {
            AMapNativeParticleSystem.nativeReleaseSizeOverLife(j);
            this.nativeInstance = 0;
        }
    }

    public abstract float getSizeX(float f);

    public abstract float getSizeY(float f);

    public abstract float getSizeZ(float f);
}
