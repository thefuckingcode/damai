package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.i;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: Taobao */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() {
        /* class com.amap.api.services.busline.BusLineItem.AnonymousClass1 */

        private static BusLineItem a(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusLineItem[] newArray(int i) {
            return null;
        }
    };
    private float a;
    private String b;
    private String c;
    private String d;
    private List<LatLonPoint> e = new ArrayList();
    private List<LatLonPoint> f = new ArrayList();
    private String g;
    private String h;
    private String i;
    private Date j;
    private Date k;
    private String l;
    private float m;
    private float n;
    private List<BusStationItem> o = new ArrayList();

    public BusLineItem() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.g;
        if (str == null) {
            if (busLineItem.g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.g)) {
            return false;
        }
        return true;
    }

    public float getBasicPrice() {
        return this.m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f;
    }

    public String getBusCompany() {
        return this.l;
    }

    public String getBusLineId() {
        return this.g;
    }

    public String getBusLineName() {
        return this.b;
    }

    public String getBusLineType() {
        return this.c;
    }

    public List<BusStationItem> getBusStations() {
        return this.o;
    }

    public String getCityCode() {
        return this.d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.e;
    }

    public float getDistance() {
        return this.a;
    }

    public Date getFirstBusTime() {
        Date date = this.j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.h;
    }

    public String getTerminalStation() {
        return this.i;
    }

    public float getTotalPrice() {
        return this.n;
    }

    public int hashCode() {
        int i2;
        String str = this.g;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        return i2 + 31;
    }

    public void setBasicPrice(float f2) {
        this.m = f2;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f = list;
    }

    public void setBusCompany(String str) {
        this.l = str;
    }

    public void setBusLineId(String str) {
        this.g = str;
    }

    public void setBusLineName(String str) {
        this.b = str;
    }

    public void setBusLineType(String str) {
        this.c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.o = list;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.e = list;
    }

    public void setDistance(float f2) {
        this.a = f2;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.j = null;
        } else {
            this.j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.k = null;
        } else {
            this.k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.h = str;
    }

    public void setTerminalStation(String str) {
        this.i = str;
    }

    public void setTotalPrice(float f2) {
        this.n = f2;
    }

    public String toString() {
        return this.b + " " + i.a(this.j) + "-" + i.a(this.k);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeList(this.e);
        parcel.writeList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(i.a(this.j));
        parcel.writeString(i.a(this.k));
        parcel.writeString(this.l);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeList(this.o);
    }

    public BusLineItem(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = i.e(parcel.readString());
        this.k = i.e(parcel.readString());
        this.l = parcel.readString();
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
