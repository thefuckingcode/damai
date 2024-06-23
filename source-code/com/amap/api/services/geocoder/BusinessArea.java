package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() {
        /* class com.amap.api.services.geocoder.BusinessArea.AnonymousClass1 */

        private static BusinessArea a(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea[] newArray(int i) {
            return a(i);
        }

        private static BusinessArea[] a(int i) {
            return new BusinessArea[i];
        }
    };
    private LatLonPoint a;
    private String b;

    public BusinessArea() {
    }

    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
    }

    public BusinessArea(Parcel parcel) {
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = parcel.readString();
    }
}
