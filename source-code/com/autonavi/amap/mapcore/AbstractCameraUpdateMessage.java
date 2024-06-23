package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.mapcore.util.eq;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;

/* compiled from: Taobao */
public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public float bearing = Float.NaN;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public float curZoolScale = 0.0f;
    public Point focus = null;
    public DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public boolean isUseAnchor = false;
    public AMap.CancelableCallback mCallback;
    public long mDuration = 250;
    public IMapConfig mapConfig;
    public float maxZoomLevel = 0.0f;
    public float minZoomLevel = 0.0f;
    public Type nowType = Type.none;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public float tilt = Float.NaN;
    public int width;
    public float xPixel;
    public float yPixel;
    public float zoom = Float.NaN;

    /* compiled from: Taobao */
    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    /* access modifiers changed from: protected */
    public void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint) {
        changeCenterByAnchor(iGLMapState, dPoint, this.anchorX, this.anchorY);
    }

    public void generateMapAnimation(IGLMapEngine iGLMapEngine) {
        IGLMapState newMapState = iGLMapEngine.getNewMapState(1);
        runCameraUpdate(newMapState);
        DPoint mapGeoCenter = newMapState.getMapGeoCenter();
        iGLMapEngine.addGroupAnimation(1, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.x, (int) mapGeoCenter.y, this.mCallback);
        newMapState.recycle();
    }

    /* access modifiers changed from: protected */
    public Point getAnchorGeoPoint(IGLMapState iGLMapState, int i, int i2) {
        Point point = new Point();
        iGLMapState.screenToP20Point(i, i2, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    /* access modifiers changed from: protected */
    public void normalChange(IGLMapState iGLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float a = eq.a(this.mapConfig, this.zoom);
        this.zoom = a;
        this.tilt = eq.a(this.mapConfig, this.tilt, a);
        this.bearing = (float) (((((double) this.bearing) % 360.0d) + 360.0d) % 360.0d);
        Point point = this.focus;
        if (point != null && this.geoPoint == null) {
            Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            this.geoPoint = new DPoint((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(anchorGeoPoint), (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(anchorGeoPoint));
        }
        if (!Float.isNaN(this.zoom)) {
            iGLMapState.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            iGLMapState.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            iGLMapState.setCameraDegree(this.tilt);
        }
        Point point2 = this.focus;
        if (point2 != null) {
            changeCenterByAnchor(iGLMapState, this.geoPoint, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
            return;
        }
        DPoint dPoint = this.geoPoint;
        if ((dPoint == null || (dPoint.x == 0.0d && dPoint.y == 0.0d)) ? false : true) {
            iGLMapState.setMapGeoCenter(dPoint.x, dPoint.y);
        }
    }

    public abstract void runCameraUpdate(IGLMapState iGLMapState);

    /* access modifiers changed from: protected */
    public void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint, int i, int i2) {
        iGLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i, i2);
        DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        iGLMapState.setMapGeoCenter((mapGeoCenter.x + dPoint.x) - ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(anchorGeoPoint)), (mapGeoCenter.y + dPoint.y) - ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(anchorGeoPoint)));
    }
}
