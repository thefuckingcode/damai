package com.amap.api.maps.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class GL3DModelOptions {
    private BitmapDescriptor bitmapDescriptor;
    private int fixedLength;
    private LatLng latLng;
    private float rotate;
    private List<Float> textrueList = new ArrayList();
    private List<Float> vertextList = new ArrayList();

    public GL3DModelOptions angle(float f) {
        this.rotate = f;
        return this;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public GL3DModelOptions position(LatLng latLng2) {
        this.latLng = latLng2;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i) {
        this.fixedLength = i;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        return this;
    }
}
