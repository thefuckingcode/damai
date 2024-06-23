package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() {
        /* class com.amap.api.services.help.Tip.AnonymousClass1 */

        private static Tip a(Parcel parcel) {
            return new Tip(parcel, (byte) 0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Tip createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Tip[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private LatLonPoint b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    /* synthetic */ Tip(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.e;
    }

    public String getAddress() {
        return this.f;
    }

    public String getDistrict() {
        return this.d;
    }

    public String getName() {
        return this.c;
    }

    public String getPoiID() {
        return this.a;
    }

    public LatLonPoint getPoint() {
        return this.b;
    }

    public String getTypeCode() {
        return this.g;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setDistrict(String str) {
        this.d = str;
    }

    public void setID(String str) {
        this.a = str;
    }

    public void setName(String str) {
        this.c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.g = str;
    }

    public String toString() {
        return "name:" + this.c + " district:" + this.d + " adcode:" + this.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeString(this.a);
        parcel.writeValue(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    public Tip() {
        this.h = "";
    }

    private Tip(Parcel parcel) {
        this.h = "";
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.a = parcel.readString();
        this.b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
    }
}
