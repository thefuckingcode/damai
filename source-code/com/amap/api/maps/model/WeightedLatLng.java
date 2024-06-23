package com.amap.api.maps.model;

import com.amap.api.mapcore.util.eq;
import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Taobao */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng2, double d) {
        if (latLng2 != null) {
            this.latLng = latLng2;
            this.mPoint = eq.a(latLng2);
            if (d >= 0.0d) {
                this.intensity = d;
            } else {
                this.intensity = 1.0d;
            }
        } else {
            throw new IllegalArgumentException("latLng can not null");
        }
    }

    /* access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.mPoint;
    }

    public WeightedLatLng(LatLng latLng2) {
        this(latLng2, 1.0d);
    }
}
