package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class RouteBusLineItem extends BusLineItem {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() {
        /* class com.amap.api.services.route.RouteBusLineItem.AnonymousClass1 */

        private static RouteBusLineItem a(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i) {
            return null;
        }
    };
    private BusStationItem a;
    private BusStationItem b;
    private List<LatLonPoint> c = new ArrayList();
    private int d;
    private List<BusStationItem> e = new ArrayList();
    private float f;

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        BusStationItem busStationItem = this.b;
        if (busStationItem == null) {
            if (routeBusLineItem.b != null) {
                return false;
            }
        } else if (!busStationItem.equals(routeBusLineItem.b)) {
            return false;
        }
        BusStationItem busStationItem2 = this.a;
        if (busStationItem2 == null) {
            if (routeBusLineItem.a != null) {
                return false;
            }
        } else if (!busStationItem2.equals(routeBusLineItem.a)) {
            return false;
        }
        return true;
    }

    public BusStationItem getArrivalBusStation() {
        return this.b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.a;
    }

    public float getDuration() {
        return this.f;
    }

    public int getPassStationNum() {
        return this.d;
    }

    public List<BusStationItem> getPassStations() {
        return this.e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.c;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.b;
        int i2 = 0;
        if (busStationItem == null) {
            i = 0;
        } else {
            i = busStationItem.hashCode();
        }
        int i3 = (hashCode + i) * 31;
        BusStationItem busStationItem2 = this.a;
        if (busStationItem2 != null) {
            i2 = busStationItem2.hashCode();
        }
        return i3 + i2;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.a = busStationItem;
    }

    public void setDuration(float f2) {
        this.f = f2;
    }

    public void setPassStationNum(int i) {
        this.d = i;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeFloat(this.f);
    }

    public RouteBusLineItem() {
    }
}
