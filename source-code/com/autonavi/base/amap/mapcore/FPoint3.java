package com.autonavi.base.amap.mapcore;

/* compiled from: Taobao */
public class FPoint3 extends FPoint {
    public int colorIndex = -1;

    public FPoint3() {
    }

    public void setColorIndex(int i) {
        this.colorIndex = i;
    }

    public FPoint3(float f, float f2, int i) {
        super(f, f2);
        this.colorIndex = i;
    }
}
