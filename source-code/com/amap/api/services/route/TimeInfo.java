package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() {
        /* class com.amap.api.services.route.TimeInfo.AnonymousClass1 */

        private static TimeInfo a(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfo[] newArray(int i) {
            return null;
        }
    };
    private long a;
    private List<TimeInfosElement> b = new ArrayList();

    public TimeInfo(Parcel parcel) {
        this.a = (long) parcel.readInt();
        this.b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.b;
    }

    public long getStartTime() {
        return this.a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.b = list;
    }

    public void setStartTime(long j) {
        this.a = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeTypedList(this.b);
    }

    public TimeInfo() {
    }
}
