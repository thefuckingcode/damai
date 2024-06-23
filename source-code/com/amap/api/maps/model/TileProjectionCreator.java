package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class TileProjectionCreator implements Parcelable.Creator<TileProjection> {
    @Override // android.os.Parcelable.Creator
    public TileProjection createFromParcel(Parcel parcel) {
        return new TileProjection(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public TileProjection[] newArray(int i) {
        return new TileProjection[i];
    }
}
