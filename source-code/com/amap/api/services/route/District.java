package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() {
        /* class com.amap.api.services.route.District.AnonymousClass1 */

        private static District a(Parcel parcel) {
            return new District(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;

    public District(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.b;
    }

    public String getDistrictName() {
        return this.a;
    }

    public void setDistrictAdcode(String str) {
        this.b = str;
    }

    public void setDistrictName(String str) {
        this.a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public District() {
    }
}
