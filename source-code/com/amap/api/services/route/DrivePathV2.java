package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DrivePathV2 extends Path {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new Parcelable.Creator<DrivePathV2>() {
        /* class com.amap.api.services.route.DrivePathV2.AnonymousClass1 */

        private static DrivePathV2 a(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private List<DriveStepV2> b = new ArrayList();
    private int c;
    private Cost d;
    private ElecConsumeInfo e;
    private List<ChargeStationInfo> f = new ArrayList();

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f;
    }

    public Cost getCost() {
        return this.d;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.e;
    }

    public int getRestriction() {
        return this.c;
    }

    public List<DriveStepV2> getSteps() {
        return this.b;
    }

    public String getStrategy() {
        return this.a;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f = list;
    }

    public void setCost(Cost cost) {
        this.d = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.e = elecConsumeInfo;
    }

    public void setRestriction(int i) {
        this.c = i;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.b = list;
    }

    public void setStrategy(String str) {
        this.a = str;
    }

    @Override // com.amap.api.services.route.Path
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.b);
    }

    public DrivePathV2() {
    }
}
