package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new Parcelable.Creator<DriveStepV2>() {
        /* class com.amap.api.services.route.DriveStepV2.AnonymousClass1 */

        private static DriveStepV2 a(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;
    private List<LatLonPoint> d = new ArrayList();
    private List<RouteSearchCity> e = new ArrayList();
    private List<TMC> f = new ArrayList();
    private int g = -1;
    private Cost h;
    private Navi i;

    public DriveStepV2(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.h;
    }

    public String getInstruction() {
        return this.a;
    }

    public Navi getNavi() {
        return this.i;
    }

    public String getOrientation() {
        return this.b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.d;
    }

    public String getRoad() {
        return this.c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.e;
    }

    public int getStepDistance() {
        return this.g;
    }

    public List<TMC> getTMCs() {
        return this.f;
    }

    public void setCostDetail(Cost cost) {
        this.h = cost;
    }

    public void setInstruction(String str) {
        this.a = str;
    }

    public void setNavi(Navi navi) {
        this.i = navi;
    }

    public void setOrientation(String str) {
        this.b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.d = list;
    }

    public void setRoad(String str) {
        this.c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.e = list;
    }

    public void setStepDistance(int i2) {
        this.g = i2;
    }

    public void setTMCs(List<TMC> list) {
        this.f = list;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeTypedList(this.f);
    }

    public DriveStepV2() {
    }
}
