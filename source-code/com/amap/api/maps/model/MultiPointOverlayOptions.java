package com.amap.api.maps.model;

/* compiled from: Taobao */
public class MultiPointOverlayOptions {
    private float anchorU = 0.5f;
    private float anchorV = 0.5f;
    private BitmapDescriptor bitmapDescriptor;

    public MultiPointOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public MultiPointOverlayOptions icon(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
        return this;
    }
}
