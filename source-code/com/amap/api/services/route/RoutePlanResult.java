package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() {
        /* class com.amap.api.services.route.RoutePlanResult.AnonymousClass1 */

        private static RoutePlanResult a(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult[] newArray(int i) {
            return a(i);
        }

        private static RoutePlanResult[] a(int i) {
            return new RoutePlanResult[i];
        }
    };
    private LatLonPoint a;
    private LatLonPoint b;

    public RoutePlanResult(Parcel parcel) {
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.a;
    }

    public LatLonPoint getTargetPos() {
        return this.b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }

    public RoutePlanResult() {
    }
}
