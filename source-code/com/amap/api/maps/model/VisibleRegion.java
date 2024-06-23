package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.eq;

/* compiled from: Taobao */
public final class VisibleRegion implements Parcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    private final int mVersionCode;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this.mVersionCode = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds2;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.mVersionCode;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        if (!this.nearLeft.equals(visibleRegion.nearLeft) || !this.nearRight.equals(visibleRegion.nearRight) || !this.farLeft.equals(visibleRegion.farLeft) || !this.farRight.equals(visibleRegion.farRight) || !this.latLngBounds.equals(visibleRegion.latLngBounds)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return eq.a(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    public String toString() {
        return eq.a(eq.a("nearLeft", this.nearLeft), eq.a("nearRight", this.nearRight), eq.a("farLeft", this.farLeft), eq.a("farRight", this.farRight), eq.a("latLngBounds", this.latLngBounds));
    }

    public void writeToParcel(Parcel parcel, int i) {
        VisibleRegionCreator.a(this, parcel, i);
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds2);
    }
}
