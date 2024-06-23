package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new Parcelable.Creator<WalkStep>() {
        /* class com.amap.api.services.route.WalkStep.AnonymousClass1 */

        private static WalkStep a(Parcel parcel) {
            return new WalkStep(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkStep[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;
    private float d;
    private float e;
    private List<LatLonPoint> f = new ArrayList();
    private String g;
    private String h;

    public WalkStep(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.g;
    }

    public String getAssistantAction() {
        return this.h;
    }

    public float getDistance() {
        return this.d;
    }

    public float getDuration() {
        return this.e;
    }

    public String getInstruction() {
        return this.a;
    }

    public String getOrientation() {
        return this.b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f;
    }

    public String getRoad() {
        return this.c;
    }

    public void setAction(String str) {
        this.g = str;
    }

    public void setAssistantAction(String str) {
        this.h = str;
    }

    public void setDistance(float f2) {
        this.d = f2;
    }

    public void setDuration(float f2) {
        this.e = f2;
    }

    public void setInstruction(String str) {
        this.a = str;
    }

    public void setOrientation(String str) {
        this.b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f = list;
    }

    public void setRoad(String str) {
        this.c = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    public WalkStep() {
    }
}
