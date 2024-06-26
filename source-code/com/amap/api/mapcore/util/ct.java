package com.amap.api.mapcore.util;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.HeatMapItem;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeHeatMapLayer;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.Collection;

/* compiled from: Taobao */
public class ct implements IHeatMapLayer, IOverlayDelegate {
    long a = -1;
    private r b;
    private boolean c = true;
    private String d;
    private float e = 0.0f;
    private boolean f;
    private de g;
    private HeatMapLayerOptions h;
    private boolean i = false;

    public ct(r rVar) {
        try {
            this.i = false;
            this.b = rVar;
            this.d = getId();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a() {
        HeatMapLayerOptions heatMapLayerOptions = this.h;
        if (heatMapLayerOptions == null || heatMapLayerOptions.getData() == null || this.h.getData().size() <= 0 || this.h.getGradient() == null || this.h.getGradient().getColors() == null || this.h.getGradient().getColors().length <= 0 || this.h.getGradient().getStartPoints() == null || this.h.getGradient().getStartPoints().length <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        synchronized (this) {
            this.i = true;
            long j = this.a;
            if (j != -1) {
                AMapNativeHeatMapLayer.nativeDestroy(j);
                this.a = -1;
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        de deVar;
        LatLng latLng;
        try {
            if (!this.i) {
                r rVar = this.b;
                if (rVar != null && this.g == null) {
                    this.g = rVar.b();
                }
                if (!(this.g == null || mapConfig == null || !this.c)) {
                    if (this.a != -1) {
                        synchronized (this) {
                            if (this.a != -1) {
                                if (this.f && a()) {
                                    double[] dArr = new double[(this.h.getData().size() * 3)];
                                    Collection<WeightedLatLng> data = this.h.getData();
                                    int size = data.size();
                                    double d2 = 0.0d;
                                    int i2 = 0;
                                    for (WeightedLatLng weightedLatLng : data) {
                                        if (weightedLatLng == null || (latLng = weightedLatLng.latLng) == null) {
                                            Log.e("mapcore", "read file failed");
                                        } else {
                                            int i3 = i2 * 3;
                                            double d3 = latLng.latitude;
                                            dArr[i3 + 0] = d3;
                                            dArr[i3 + 1] = latLng.longitude;
                                            dArr[i3 + 2] = weightedLatLng.intensity;
                                            d2 += d3 / ((double) size);
                                        }
                                        i2++;
                                    }
                                    AMapNativeHeatMapLayer.nativeSetOptions(this.a, dArr, (int) this.h.getMaxIntensity(), this.h.getSize(), this.h.getGradient().getColors(), this.h.getGradient().getStartPoints(), this.h.getMaxZoom(), this.h.getMinZoom(), this.h.getOpacity(), this.h.getGap(), this.h.getType(), d2);
                                    this.f = false;
                                }
                                AMapNativeHeatMapLayer.nativeRender(this.a, mapConfig.getViewMatrix(), mapConfig.getProjectionMatrix(), (int) mapConfig.getSX(), (int) mapConfig.getSY(), mapConfig.getSZ());
                            }
                        }
                        return;
                    }
                    long nativeCreate = AMapNativeHeatMapLayer.nativeCreate();
                    this.a = nativeCreate;
                    if (!(nativeCreate == -1 || (deVar = this.g) == null)) {
                        AMapNativeHeatMapLayer.nativeSetGLShaderManager(nativeCreate, deVar.a());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IHeatMapLayer
    public HeatMapItem getHeatMapItem(LatLng latLng) {
        Object nativeGetHeatMapItem;
        if (latLng == null) {
            return null;
        }
        long j = this.a;
        if (j == -1 || (nativeGetHeatMapItem = AMapNativeHeatMapLayer.nativeGetHeatMapItem(j, latLng.latitude, latLng.longitude)) == null || !(nativeGetHeatMapItem instanceof HeatMapItem)) {
            return null;
        }
        return (HeatMapItem) nativeGetHeatMapItem;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.d == null) {
            this.d = this.b.a("HeatMapLayer");
        }
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IHeatMapLayer
    public HeatMapLayerOptions getOptions() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        r rVar = this.b;
        if (rVar != null && !rVar.a(this.d, true)) {
            destroy();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IHeatMapLayer
    public void setOptions(HeatMapLayerOptions heatMapLayerOptions) {
        this.h = heatMapLayerOptions;
        if (heatMapLayerOptions != null) {
            this.e = heatMapLayerOptions.getZIndex();
            this.c = this.h.isVisible();
        }
        this.f = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.c = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) {
        try {
            this.e = f2;
            this.b.e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(de deVar) {
        this.g = deVar;
    }
}
