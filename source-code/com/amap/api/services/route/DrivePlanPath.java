package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() {
        /* class com.amap.api.services.route.DrivePlanPath.AnonymousClass1 */

        private static DrivePlanPath a(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i) {
            return null;
        }
    };
    float a;
    int b;
    private List<DrivePlanStep> c = new ArrayList();

    public DrivePlanPath(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readInt();
        this.c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.c;
    }

    public float getTrafficLights() {
        return (float) this.b;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.c = list;
    }

    public void setTrafficLights(int i) {
        this.b = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeInt(this.b);
        parcel.writeTypedList(this.c);
    }

    public DrivePlanPath() {
    }
}
