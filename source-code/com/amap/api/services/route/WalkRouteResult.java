package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class WalkRouteResult extends RouteResult {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() {
        /* class com.amap.api.services.route.WalkRouteResult.AnonymousClass1 */

        private static WalkRouteResult a(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult[] newArray(int i) {
            return a(i);
        }

        private static WalkRouteResult[] a(int i) {
            return new WalkRouteResult[i];
        }
    };
    private List<WalkPath> a = new ArrayList();
    private RouteSearch.WalkRouteQuery b;

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.b;
    }

    public void setPaths(List<WalkPath> list) {
        this.a = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }

    public WalkRouteResult() {
    }
}
