package com.alibaba.security.realidentity.utils;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class ImageData implements Parcelable {
    public static final Parcelable.Creator<ImageData> CREATOR = new Parcelable.Creator<ImageData>() {
        /* class com.alibaba.security.realidentity.utils.ImageData.AnonymousClass1 */

        private static ImageData a(Parcel parcel) {
            return new ImageData(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ImageData createFromParcel(Parcel parcel) {
            return new ImageData(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ImageData[] newArray(int i) {
            return new ImageData[i];
        }

        private static ImageData[] a(int i) {
            return new ImageData[i];
        }
    };
    public String a;
    public int b;
    public String c;
    public String d;

    public ImageData() {
    }

    private String a() {
        return this.d;
    }

    private void b(String str) {
        this.a = str;
    }

    private int c() {
        return this.b;
    }

    private String d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ImageData{source='" + this.d + '\'' + ", path='" + this.a + '\'' + ", type=" + this.b + ", gestureUrl='" + this.c + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    protected ImageData(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
    }

    private void a(String str) {
        this.d = str;
    }

    private String b() {
        return this.a;
    }

    private void c(String str) {
        this.c = str;
    }

    private void a(int i) {
        this.b = i;
    }
}
