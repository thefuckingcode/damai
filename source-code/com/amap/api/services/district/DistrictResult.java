package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;
import tb.jl1;

/* compiled from: Taobao */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR = new Parcelable.Creator<DistrictResult>() {
        /* class com.amap.api.services.district.DistrictResult.AnonymousClass1 */

        private static DistrictResult a(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictResult[] newArray(int i) {
            return a(i);
        }

        private static DistrictResult[] a(int i) {
            return new DistrictResult[i];
        }
    };
    private DistrictSearchQuery a;
    private ArrayList<DistrictItem> b = new ArrayList<>();
    private int c;
    private AMapException d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.a = districtSearchQuery;
        this.b = arrayList;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictResult.class != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.a;
        if (districtSearchQuery == null) {
            if (districtResult.a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.b;
        if (arrayList == null) {
            if (districtResult.b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.b)) {
            return false;
        }
        return true;
    }

    public final AMapException getAMapException() {
        return this.d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.b;
    }

    public final int getPageCount() {
        return this.c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.a;
    }

    public final int hashCode() {
        int i;
        DistrictSearchQuery districtSearchQuery = this.a;
        int i2 = 0;
        if (districtSearchQuery == null) {
            i = 0;
        } else {
            i = districtSearchQuery.hashCode();
        }
        int i3 = (i + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.b;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return i3 + i2;
    }

    public final void setAMapException(AMapException aMapException) {
        this.d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public final void setPageCount(int i) {
        this.c = i;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.a + ", mDistricts=" + this.b + jl1.ARRAY_END_STR;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
    }

    public DistrictResult() {
    }

    protected DistrictResult(Parcel parcel) {
        this.a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
