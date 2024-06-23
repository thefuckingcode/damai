package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public final class Crossroad extends Road {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() {
        /* class com.amap.api.services.road.Crossroad.AnonymousClass1 */

        private static Crossroad a(Parcel parcel) {
            return new Crossroad(parcel, (byte) 0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Crossroad createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Crossroad[] newArray(int i) {
            return null;
        }
    };
    private float a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    /* synthetic */ Crossroad(Parcel parcel, byte b2) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.b;
    }

    public final float getDistance() {
        return this.a;
    }

    public final String getFirstRoadId() {
        return this.c;
    }

    public final String getFirstRoadName() {
        return this.d;
    }

    public final String getSecondRoadId() {
        return this.e;
    }

    public final String getSecondRoadName() {
        return this.f;
    }

    public final void setDirection(String str) {
        this.b = str;
    }

    public final void setDistance(float f2) {
        this.a = f2;
    }

    public final void setFirstRoadId(String str) {
        this.c = str;
    }

    public final void setFirstRoadName(String str) {
        this.d = str;
    }

    public final void setSecondRoadId(String str) {
        this.e = str;
    }

    public final void setSecondRoadName(String str) {
        this.f = str;
    }

    @Override // com.amap.api.services.road.Road
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }
}
