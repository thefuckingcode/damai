package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() {
        /* class com.amap.api.services.geocoder.AoiItem.AnonymousClass1 */

        private static AoiItem a(Parcel parcel) {
            return new AoiItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem[] newArray(int i) {
            return a(i);
        }

        private static AoiItem[] a(int i) {
            return new AoiItem[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private LatLonPoint d;
    private Float e;

    public AoiItem() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.c;
    }

    public Float getAoiArea() {
        return this.e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.d;
    }

    public String getAoiId() {
        return this.a;
    }

    public String getAoiName() {
        return this.b;
    }

    public void setAdcode(String str) {
        this.c = str;
    }

    public void setArea(Float f) {
        this.e = f;
    }

    public void setId(String str) {
        this.a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeFloat(this.e.floatValue());
    }

    public AoiItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = Float.valueOf(parcel.readFloat());
    }
}
