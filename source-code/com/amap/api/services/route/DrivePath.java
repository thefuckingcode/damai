package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DrivePath extends Path {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() {
        /* class com.amap.api.services.route.DrivePath.AnonymousClass1 */

        private static DrivePath a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private float b;
    private float c;
    private int d;
    private List<DriveStep> e = new ArrayList();
    private int f;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f;
    }

    public List<DriveStep> getSteps() {
        return this.e;
    }

    public String getStrategy() {
        return this.a;
    }

    public float getTollDistance() {
        return this.c;
    }

    public float getTolls() {
        return this.b;
    }

    public int getTotalTrafficlights() {
        return this.d;
    }

    public void setRestriction(int i) {
        this.f = i;
    }

    public void setSteps(List<DriveStep> list) {
        this.e = list;
    }

    public void setStrategy(String str) {
        this.a = str;
    }

    public void setTollDistance(float f2) {
        this.c = f2;
    }

    public void setTolls(float f2) {
        this.b = f2;
    }

    public void setTotalTrafficlights(int i) {
        this.d = i;
    }

    @Override // com.amap.api.services.route.Path
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.e);
        parcel.writeInt(this.d);
    }

    public DrivePath() {
    }
}
