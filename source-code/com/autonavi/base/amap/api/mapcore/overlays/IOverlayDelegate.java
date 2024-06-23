package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: Taobao */
public interface IOverlayDelegate extends IOverlay {
    boolean calMapFPoint() throws RemoteException;

    boolean checkInBounds();

    void draw(MapConfig mapConfig) throws RemoteException;

    boolean isDrawFinish();
}
