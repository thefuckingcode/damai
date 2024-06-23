package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

/* compiled from: Taobao */
public class EmergeAnimation extends Animation {
    public EmergeAnimation(LatLng latLng) {
        this.glAnimation = new GLEmergeAnimation(latLng);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setDuration(long j) {
        this.glAnimation.setDuration(j);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.glAnimation.setInterpolator(interpolator);
    }
}
