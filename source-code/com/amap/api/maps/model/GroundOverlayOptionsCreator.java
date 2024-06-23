package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class GroundOverlayOptionsCreator implements Parcelable.Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions(readInt, null, (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), parcel.readByte() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        groundOverlayOptions.image(bitmapDescriptor);
        return groundOverlayOptions;
    }

    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
