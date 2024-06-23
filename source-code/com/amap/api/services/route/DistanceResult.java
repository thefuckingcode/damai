package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* compiled from: Taobao */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() {
        /* class com.amap.api.services.route.DistanceResult.AnonymousClass1 */

        private static DistanceResult a(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult[] newArray(int i) {
            return a(i);
        }

        private static DistanceResult[] a(int i) {
            return new DistanceResult[i];
        }
    };
    private DistanceSearch.DistanceQuery a;
    private List<DistanceItem> b = null;

    public DistanceResult() {
    }

    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.b = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
    }

    protected DistanceResult(Parcel parcel) {
        this.b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
