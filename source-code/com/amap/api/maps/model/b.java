package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
class b implements Parcelable.Creator<Tile> {
    b() {
    }

    /* renamed from: a */
    public Tile createFromParcel(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    /* renamed from: a */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
