package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() {
        /* class com.amap.api.services.route.TimeInfosElement.AnonymousClass1 */

        private static TimeInfosElement a(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i) {
            return null;
        }
    };
    int a;
    float b;
    float c;
    int d;
    private List<TMC> e = new ArrayList();

    public TimeInfosElement(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.b;
    }

    public int getPathindex() {
        return this.a;
    }

    public int getRestriction() {
        return this.d;
    }

    public List<TMC> getTMCs() {
        return this.e;
    }

    public float getTolls() {
        return this.c;
    }

    public void setDuration(float f) {
        this.b = f;
    }

    public void setPathindex(int i) {
        this.a = i;
    }

    public void setRestriction(int i) {
        this.d = i;
    }

    public void setTMCs(List<TMC> list) {
        this.e = list;
    }

    public void setTolls(float f) {
        this.c = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
    }

    public TimeInfosElement() {
    }
}
