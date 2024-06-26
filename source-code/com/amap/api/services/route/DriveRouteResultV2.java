package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DriveRouteResultV2 extends RouteResult {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new Parcelable.Creator<DriveRouteResultV2>() {
        /* class com.amap.api.services.route.DriveRouteResultV2.AnonymousClass1 */

        private static DriveRouteResultV2 a(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2[] newArray(int i) {
            return a(i);
        }

        private static DriveRouteResultV2[] a(int i) {
            return new DriveRouteResultV2[i];
        }
    };
    private float a;
    private List<DrivePathV2> b = new ArrayList();
    private RouteSearchV2.DriveRouteQuery c;

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.c = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.c;
    }

    public List<DrivePathV2> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.c = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
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

    public DriveRouteResultV2() {
    }
}
