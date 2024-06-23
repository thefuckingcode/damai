package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new Parcelable.Creator<DrivePlanStep>() {
        /* class com.amap.api.services.route.DrivePlanStep.AnonymousClass1 */

        private static DrivePlanStep a(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private float c;
    private boolean d;
    private List<LatLonPoint> e = new ArrayList();

    public DrivePlanStep(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readInt() != 1 ? false : true;
        this.c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.b;
    }

    public float getDistance() {
        return this.c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.e;
    }

    public String getRoad() {
        return this.a;
    }

    public boolean getToll() {
        return this.d;
    }

    public void setAdCode(String str) {
        this.b = str;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.e = list;
    }

    public void setRoad(String str) {
        this.a = str;
    }

    public void setToll(boolean z) {
        this.d = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.e);
    }

    public DrivePlanStep() {
    }
}
