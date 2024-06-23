package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null, parcel.readString());
        bitmapDescriptor.c = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.a = parcel.readInt();
        bitmapDescriptor.b = parcel.readInt();
        return bitmapDescriptor;
    }

    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor[] newArray(int i) {
        return new BitmapDescriptor[i];
    }
}
