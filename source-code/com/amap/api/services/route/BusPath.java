package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class BusPath extends Path {
    public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() {
        /* class com.amap.api.services.route.BusPath.AnonymousClass1 */

        private static BusPath a(Parcel parcel) {
            return new BusPath(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPath[] newArray(int i) {
            return null;
        }
    };
    private float a;
    private boolean b;
    private float c;
    private float d;
    private List<BusStep> e = new ArrayList();

    public BusPath(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.b = zArr[0];
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.d;
    }

    public float getCost() {
        return this.a;
    }

    public List<BusStep> getSteps() {
        return this.e;
    }

    public float getWalkDistance() {
        return this.c;
    }

    public boolean isNightBus() {
        return this.b;
    }

    public void setBusDistance(float f) {
        this.d = f;
    }

    public void setCost(float f) {
        this.a = f;
    }

    public void setNightBus(boolean z) {
        this.b = z;
    }

    public void setSteps(List<BusStep> list) {
        this.e = list;
    }

    public void setWalkDistance(float f) {
        this.c = f;
    }

    @Override // com.amap.api.services.route.Path
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeBooleanArray(new boolean[]{this.b});
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeTypedList(this.e);
    }

    public BusPath() {
    }
}
