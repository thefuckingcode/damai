package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

/* compiled from: Taobao */
public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate = 0.0f;

    public ConstantRotationOverLife(float f) {
        this.rotate = f;
        this.type = 0;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateConstantRotationOverLife(this.rotate);
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.rotate;
    }
}
