package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        /* class com.amap.api.services.poisearch.Photo.AnonymousClass1 */

        private static Photo a(Parcel parcel) {
            return new Photo(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Photo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Photo[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;

    public Photo() {
    }

    public final int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.a;
    }

    public final String getUrl() {
        return this.b;
    }

    public final void setTitle(String str) {
        this.a = str;
    }

    public final void setUrl(String str) {
        this.b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public Photo(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public Photo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
