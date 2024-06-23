package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() {
        /* class com.amap.api.services.route.RailwaySpace.AnonymousClass1 */

        private static RailwaySpace a(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace[] newArray(int i) {
            return a(i);
        }

        private static RailwaySpace[] a(int i) {
            return new RailwaySpace[i];
        }
    };
    private String a;
    private float b;

    public RailwaySpace(String str, float f) {
        this.a = str;
        this.b = f;
    }

    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.a;
    }

    public float getCost() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readFloat();
    }
}
