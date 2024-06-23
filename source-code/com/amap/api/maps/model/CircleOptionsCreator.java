package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    @Override // android.os.Parcelable.Creator
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle readBundle = parcel.readBundle();
        circleOptions.center(new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readFloat());
        boolean z = false;
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.a = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, BaseHoleOptions.class.getClassLoader());
        circleOptions.addHoles(arrayList);
        circleOptions.setStrokeDottedLineType(parcel.readInt());
        if (parcel.readByte() == 1) {
            z = true;
        }
        circleOptions.usePolylineStroke(z);
        return circleOptions;
    }

    @Override // android.os.Parcelable.Creator
    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
