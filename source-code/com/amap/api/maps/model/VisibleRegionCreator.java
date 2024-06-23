package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }

    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        BadParcelableException e;
        int readInt = parcel.readInt();
        try {
            latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                } catch (BadParcelableException e2) {
                    e = e2;
                    latLng2 = null;
                    latLng = latLng2;
                    e.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                }
            } catch (BadParcelableException e3) {
                e = e3;
                latLng3 = null;
                latLng2 = latLng3;
                latLng = latLng2;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
            }
            try {
                latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                } catch (BadParcelableException e4) {
                    e = e4;
                    e.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                }
            } catch (BadParcelableException e5) {
                e = e5;
                latLng = null;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
            }
        } catch (BadParcelableException e6) {
            e = e6;
            latLng4 = null;
            latLng3 = null;
            latLng2 = latLng3;
            latLng = latLng2;
            e.printStackTrace();
            latLngBounds = null;
            return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
