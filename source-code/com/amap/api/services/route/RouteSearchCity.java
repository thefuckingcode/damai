package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class RouteSearchCity extends SearchCity {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new Parcelable.Creator<RouteSearchCity>() {
        /* class com.amap.api.services.route.RouteSearchCity.AnonymousClass1 */

        private static RouteSearchCity a(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteSearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteSearchCity[] newArray(int i) {
            return null;
        }
    };
    List<District> a = new ArrayList();

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(District.CREATOR);
    }

    @Override // com.amap.api.services.route.SearchCity
    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.a;
    }

    public void setDistricts(List<District> list) {
        this.a = list;
    }

    @Override // com.amap.api.services.route.SearchCity
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }

    public RouteSearchCity() {
    }
}
