package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: Taobao */
public class af extends AbstractCameraUpdateMessage {
    public void a(IGLMapState iGLMapState, int i, int i2, Point point) {
        iGLMapState.screenToP20Point(i, i2, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState iGLMapState) {
        float f = this.xPixel;
        float f2 = this.yPixel;
        float f3 = (((float) this.width) / 2.0f) + f;
        float f4 = (((float) this.height) / 2.0f) + f2;
        Point point = new Point();
        a(iGLMapState, (int) f3, (int) f4, point);
        iGLMapState.setMapGeoCenter((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
    }
}
