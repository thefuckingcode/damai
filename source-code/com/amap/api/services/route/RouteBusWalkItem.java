package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class RouteBusWalkItem extends WalkPath {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() {
        /* class com.amap.api.services.route.RouteBusWalkItem.AnonymousClass1 */

        private static RouteBusWalkItem a(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusWalkItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i) {
            return null;
        }
    };
    private LatLonPoint a;
    private LatLonPoint b;

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.b;
    }

    public LatLonPoint getOrigin() {
        return this.a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }

    public RouteBusWalkItem() {
    }
}
