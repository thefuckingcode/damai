package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amap.mapcore.AbstractNativeInstance;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

/* compiled from: Taobao */
public class ParticleOverLifeModule extends AbstractNativeInstance implements Parcelable {
    public static final Parcelable.Creator<ParticleOverLifeModule> CREATOR = new Parcelable.Creator<ParticleOverLifeModule>() {
        /* class com.amap.api.maps.model.particle.ParticleOverLifeModule.AnonymousClass1 */

        /* renamed from: a */
        public ParticleOverLifeModule createFromParcel(Parcel parcel) {
            return new ParticleOverLifeModule(parcel);
        }

        /* renamed from: a */
        public ParticleOverLifeModule[] newArray(int i) {
            return new ParticleOverLifeModule[i];
        }
    };
    private static final int TYPE_COLOR = 3;
    private static final int TYPE_ROTATE = 1;
    private static final int TYPE_SCALE = 2;
    private static final int TYPE_VEL = 0;
    private ColorGenerate colorGenerate;
    private boolean isNeedReloadColorGenerate = false;
    private boolean isNeedReloadRotationOverLife = false;
    private boolean isNeedReloadSizeOverLife = false;
    private boolean isNeedReloadVelocityGenerate = false;
    private VelocityGenerate overLife = null;
    private RotationOverLife rotateOverLife;
    private SizeOverLife sizeOverLife;
    private VelocityGenerate velocityOverLife = null;

    protected ParticleOverLifeModule(Parcel parcel) {
        this.nativeInstance = parcel.readLong();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleOverLifeModule();
            if (this.isNeedReloadVelocityGenerate) {
                setVelocityOverLife(this.overLife);
                this.isNeedReloadVelocityGenerate = false;
            }
            if (this.isNeedReloadRotationOverLife) {
                setRotateOverLife(this.rotateOverLife);
                this.isNeedReloadRotationOverLife = false;
            }
            if (this.isNeedReloadSizeOverLife) {
                setSizeOverLife(this.sizeOverLife);
                this.isNeedReloadSizeOverLife = false;
            }
            if (this.isNeedReloadColorGenerate) {
                setColorGenerate(this.colorGenerate);
                this.isNeedReloadColorGenerate = false;
            }
        } catch (Throwable unused) {
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance, java.lang.Object
    public void finalize() throws Throwable {
        super.finalize();
        long j = this.nativeInstance;
        if (j != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleOverLifeModule(j);
            this.nativeInstance = 0;
        }
    }

    public void setColorGenerate(ColorGenerate colorGenerate2) {
        this.colorGenerate = colorGenerate2;
        long j = this.nativeInstance;
        if (j == 0) {
            this.isNeedReloadColorGenerate = true;
        } else if (colorGenerate2 != null) {
            if (colorGenerate2.getNativeInstance() == 0) {
                this.colorGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.colorGenerate.getNativeInstance(), 3);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(j, 0, 3);
        }
    }

    public void setRotateOverLife(RotationOverLife rotationOverLife) {
        this.rotateOverLife = rotationOverLife;
        long j = this.nativeInstance;
        if (j == 0) {
            this.isNeedReloadRotationOverLife = true;
        } else if (rotationOverLife != null) {
            if (rotationOverLife.getNativeInstance() == 0) {
                this.rotateOverLife.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.rotateOverLife.getNativeInstance(), 1);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(j, 0, 1);
        }
    }

    public void setSizeOverLife(SizeOverLife sizeOverLife2) {
        this.sizeOverLife = sizeOverLife2;
        long j = this.nativeInstance;
        if (j == 0) {
            this.isNeedReloadSizeOverLife = true;
        } else if (sizeOverLife2 != null) {
            if (sizeOverLife2.getNativeInstance() == 0) {
                this.sizeOverLife.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.sizeOverLife.getNativeInstance(), 2);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(j, 0, 2);
        }
    }

    public void setVelocityOverLife(VelocityGenerate velocityGenerate) {
        this.overLife = velocityGenerate;
        this.velocityOverLife = velocityGenerate;
        long j = this.nativeInstance;
        if (j == 0) {
            this.isNeedReloadVelocityGenerate = true;
        } else if (velocityGenerate != null) {
            if (velocityGenerate.getNativeInstance() == 0) {
                this.overLife.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.overLife.getNativeInstance(), 0);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(j, 0, 0);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.nativeInstance);
    }

    public ParticleOverLifeModule() {
        createNativeInstace();
    }
}
