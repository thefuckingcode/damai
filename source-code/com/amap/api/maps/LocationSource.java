package com.amap.api.maps;

import android.location.Location;

/* compiled from: Taobao */
public interface LocationSource {

    /* compiled from: Taobao */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
