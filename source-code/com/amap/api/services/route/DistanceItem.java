package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() {
        /* class com.amap.api.services.route.DistanceItem.AnonymousClass1 */

        private static DistanceItem a(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem[] newArray(int i) {
            return a(i);
        }

        private static DistanceItem[] a(int i) {
            return new DistanceItem[i];
        }
    };
    public final int ERROR_CODE_NOT_IN_CHINA = 3;
    public final int ERROR_CODE_NO_DRIVE = 1;
    public final int ERROR_CODE_TOO_FAR = 2;
    private int a = 1;
    private int b = 1;
    private float c = 0.0f;
    private float d = 0.0f;
    private String e;
    private int f;

    public DistanceItem() {
    }

    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.b;
    }

    public float getDistance() {
        return this.c;
    }

    public float getDuration() {
        return this.d;
    }

    public int getErrorCode() {
        return this.f;
    }

    public String getErrorInfo() {
        return this.e;
    }

    public int getOriginId() {
        return this.a;
    }

    public void setDestId(int i) {
        this.b = i;
    }

    public void setDistance(float f2) {
        this.c = f2;
    }

    public void setDuration(float f2) {
        this.d = f2;
    }

    public void setErrorCode(int i) {
        this.f = i;
    }

    public void setErrorInfo(String str) {
        this.e = str;
    }

    public void setOriginId(int i) {
        this.a = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
    }

    protected DistanceItem(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = parcel.readInt();
    }
}
