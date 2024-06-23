package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() {
        /* class com.amap.api.services.route.Path.AnonymousClass1 */

        private static Path a(Parcel parcel) {
            return new Path(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Path createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Path[] newArray(int i) {
            return null;
        }
    };
    private float a;
    private long b;
    private List<LatLonPoint> c = new ArrayList();

    public Path(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readLong();
        this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.a;
    }

    public long getDuration() {
        return this.b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.c;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeLong(this.b);
        parcel.writeTypedList(this.c);
    }

    public Path() {
    }
}
