package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() {
        /* class com.amap.api.services.geocoder.StreetNumber.AnonymousClass1 */

        private static StreetNumber a(Parcel parcel) {
            return new StreetNumber(parcel, (byte) 0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StreetNumber createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StreetNumber[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private LatLonPoint c;
    private String d;
    private float e;

    /* synthetic */ StreetNumber(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.d;
    }

    public final float getDistance() {
        return this.e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public final String getNumber() {
        return this.b;
    }

    public final String getStreet() {
        return this.a;
    }

    public final void setDirection(String str) {
        this.d = str;
    }

    public final void setDistance(float f) {
        this.e = f;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public final void setNumber(String str) {
        this.b = str;
    }

    public final void setStreet(String str) {
        this.a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readFloat();
    }
}
