package com.autonavi.amap.mapcore.animation;

/* compiled from: Taobao */
public class GLTransformation {
    public double alpha = Double.NaN;
    public double rotate = Double.NaN;
    public double scaleX = Double.NaN;
    public double scaleY = Double.NaN;
    public double x = Double.NaN;
    public double y = Double.NaN;

    public void clear() {
        this.x = Double.NaN;
        this.y = Double.NaN;
        this.alpha = Double.NaN;
        this.scaleX = Double.NaN;
        this.scaleY = Double.NaN;
        this.rotate = Double.NaN;
    }
}
