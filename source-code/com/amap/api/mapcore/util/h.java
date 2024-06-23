package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
class h implements LocationSource.OnLocationChangedListener {
    Location a;
    private IAMapDelegate b;

    h(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        this.a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            hd.c(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
