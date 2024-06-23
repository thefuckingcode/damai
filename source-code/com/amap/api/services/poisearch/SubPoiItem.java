package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new Parcelable.Creator<SubPoiItem>() {
        /* class com.amap.api.services.poisearch.SubPoiItem.AnonymousClass1 */

        private static SubPoiItem a(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;
    private int d;
    private LatLonPoint e;
    private String f;
    private String g;

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.a = str;
        this.e = latLonPoint;
        this.b = str2;
        this.f = str3;
    }

    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public String getPoiId() {
        return this.a;
    }

    public String getSnippet() {
        return this.f;
    }

    public String getSubName() {
        return this.c;
    }

    public String getSubTypeDes() {
        return this.g;
    }

    public String getTitle() {
        return this.b;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.a = str;
    }

    public void setSnippet(String str) {
        this.f = str;
    }

    public void setSubName(String str) {
        this.c = str;
    }

    public void setSubTypeDes(String str) {
        this.g = str;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }

    public SubPoiItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
    }
}
