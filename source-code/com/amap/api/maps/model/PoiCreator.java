package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class PoiCreator implements Parcelable.Creator<Poi> {
    @Override // android.os.Parcelable.Creator
    public Poi createFromParcel(Parcel parcel) {
        return new Poi(parcel.readString(), (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public Poi[] newArray(int i) {
        return new Poi[i];
    }
}
