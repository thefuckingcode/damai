package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class LatLonSharePoint extends LatLonPoint {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() {
        /* class com.amap.api.services.core.LatLonSharePoint.AnonymousClass1 */

        private static LatLonSharePoint a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i) {
            return a(i);
        }

        private static LatLonSharePoint[] a(int i) {
            return new LatLonSharePoint[i];
        }
    };
    private String a;

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.a;
        if (str == null) {
            if (latLonSharePoint.a != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.a)) {
            return false;
        }
        return true;
    }

    public String getSharePointName() {
        return this.a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public void setSharePointName(String str) {
        this.a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
    }
}
