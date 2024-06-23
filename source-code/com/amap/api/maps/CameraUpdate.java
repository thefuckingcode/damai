package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: Taobao */
public final class CameraUpdate {
    AbstractCameraUpdateMessage a;

    CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.a = abstractCameraUpdateMessage;
    }

    public AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.a;
    }
}
