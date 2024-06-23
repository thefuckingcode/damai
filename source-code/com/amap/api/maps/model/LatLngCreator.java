package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class LatLngCreator implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public LatLng createFromParcel(Parcel parcel) {
        return new LatLng(parcel.readDouble(), parcel.readDouble());
    }

    @Override // android.os.Parcelable.Creator
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
