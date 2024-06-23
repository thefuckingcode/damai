package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class BusRouteResult extends RouteResult {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() {
        /* class com.amap.api.services.route.BusRouteResult.AnonymousClass1 */

        private static BusRouteResult a(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult[] newArray(int i) {
            return a(i);
        }

        private static BusRouteResult[] a(int i) {
            return new BusRouteResult[i];
        }
    };
    private float a;
    private List<BusPath> b = new ArrayList();
    private RouteSearch.BusRouteQuery c;

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.c;
    }

    public List<BusPath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.a = f;
    }

    @Override // com.amap.api.services.route.RouteResult
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }

    public BusRouteResult() {
    }
}
