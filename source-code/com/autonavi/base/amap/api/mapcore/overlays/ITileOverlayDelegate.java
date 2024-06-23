package com.autonavi.base.amap.api.mapcore.overlays;

import com.autonavi.amap.mapcore.interfaces.ITileOverlay;

/* compiled from: Taobao */
public interface ITileOverlayDelegate extends ITileOverlay {
    void drawTiles();

    void onFling(boolean z);

    void onPause();

    void onResume();

    void reLoadTexture();

    void refresh(boolean z);
}
