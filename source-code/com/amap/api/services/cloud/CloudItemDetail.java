package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class CloudItemDetail extends CloudItem {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new Parcelable.Creator<CloudItemDetail>() {
        /* class com.amap.api.services.cloud.CloudItemDetail.AnonymousClass1 */

        private static CloudItemDetail a(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail[] newArray(int i) {
            return a(i);
        }

        private static CloudItemDetail[] a(int i) {
            return new CloudItemDetail[i];
        }
    };

    public CloudItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
    }

    @Override // com.amap.api.services.cloud.CloudItem
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.cloud.CloudItem
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected CloudItemDetail(Parcel parcel) {
        super(parcel);
    }
}
