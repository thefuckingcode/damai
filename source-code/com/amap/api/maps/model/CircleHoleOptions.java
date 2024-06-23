package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() {
        /* class com.amap.api.maps.model.CircleHoleOptions.AnonymousClass1 */

        /* renamed from: a */
        public CircleHoleOptions createFromParcel(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        /* renamed from: a */
        public CircleHoleOptions[] newArray(int i) {
            return new CircleHoleOptions[i];
        }
    };
    private LatLng point = null;
    private double radius = 0.0d;

    public CircleHoleOptions() {
        this.isPolygonHoleOptions = false;
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d) {
        this.radius = d;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }

    protected CircleHoleOptions(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }
}
