package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;
import tb.jl1;

/* compiled from: Taobao */
public final class LatLng implements Parcelable, Cloneable {
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d, double d2) {
        this(d, d2, true);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + jl1.BRACKET_END_STR;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }

    public LatLng(double d, double d2, boolean z) {
        if (z) {
            if (-180.0d > d2 || d2 >= 180.0d) {
                this.longitude = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
            } else {
                this.longitude = d2;
            }
            if (d < -90.0d || d > 90.0d) {
                try {
                    throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
                } catch (AMapException e) {
                    e.printStackTrace();
                }
            }
            this.latitude = Math.max(-90.0d, Math.min(90.0d, d));
            return;
        }
        this.latitude = d;
        this.longitude = d2;
    }

    @Override // java.lang.Object
    public LatLng clone() {
        return new LatLng(this.latitude, this.longitude);
    }
}
