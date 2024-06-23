package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() {
        /* class com.amap.api.services.route.Railway.AnonymousClass1 */

        private static Railway a(Parcel parcel) {
            return new Railway(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway[] newArray(int i) {
            return a(i);
        }

        private static Railway[] a(int i) {
            return new Railway[i];
        }
    };
    private String a;
    private String b;

    public Railway() {
    }

    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public void setID(String str) {
        this.a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    protected Railway(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
