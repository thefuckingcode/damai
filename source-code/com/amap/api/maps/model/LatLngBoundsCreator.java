package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }

    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        BadParcelableException e;
        int readInt = parcel.readInt();
        LatLng latLng2 = null;
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e2) {
                e = e2;
                e.printStackTrace();
                return new LatLngBounds(readInt, latLng, latLng2);
            }
        } catch (BadParcelableException e3) {
            e = e3;
            latLng = null;
            e.printStackTrace();
            return new LatLngBounds(readInt, latLng, latLng2);
        }
        return new LatLngBounds(readInt, latLng, latLng2);
    }

    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
