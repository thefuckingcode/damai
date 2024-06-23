package com.amap.api.maps.model;

import tb.jl1;

/* compiled from: Taobao */
public class AMapCameraInfo {
    private float aspectRatio = 1.0f;
    private float fov = 0.0f;
    private float positionX = 0.0f;
    private float positionY = 0.0f;
    private float positionZ = 0.0f;
    private float rotate = 0.0f;

    public AMapCameraInfo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.fov = f;
        this.aspectRatio = f2;
        this.rotate = f3;
        this.positionX = f4;
        this.positionY = f5;
        this.positionZ = f6;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getFov() {
        return this.fov;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getX() {
        return this.positionX;
    }

    public float getY() {
        return this.positionY;
    }

    public float getZ() {
        return this.positionZ;
    }

    public String toString() {
        return jl1.ARRAY_START_STR + "fov:" + this.fov + " " + "aspectRatio:" + this.aspectRatio + " " + "rotate:" + this.rotate + " " + "pos_x:" + this.positionX + " " + "pos_y:" + this.positionY + " " + "pos_z:" + this.positionZ + jl1.ARRAY_END_STR;
    }
}
