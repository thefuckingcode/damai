package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DriveRouteResult extends RouteResult {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() {
        /* class com.amap.api.services.route.DriveRouteResult.AnonymousClass1 */

        private static DriveRouteResult a(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult[] newArray(int i) {
            return a(i);
        }

        private static DriveRouteResult[] a(int i) {
            return new DriveRouteResult[i];
        }
    };
    private float a;
    private List<DrivePath> b = new ArrayList();
    private RouteSearch.DriveRouteQuery c;

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.c;
    }

    public List<DrivePath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
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

    public DriveRouteResult() {
    }
}
