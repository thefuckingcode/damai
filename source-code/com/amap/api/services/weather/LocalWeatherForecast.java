package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new Parcelable.Creator<LocalWeatherForecast>() {
        /* class com.amap.api.services.weather.LocalWeatherForecast.AnonymousClass1 */

        private static LocalWeatherForecast a(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private List<LocalDayWeatherForecast> e = new ArrayList();

    public LocalWeatherForecast() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.c;
    }

    public String getCity() {
        return this.b;
    }

    public String getProvince() {
        return this.a;
    }

    public String getReportTime() {
        return this.d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.c = str;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setProvince(String str) {
        this.a = str;
    }

    public void setReportTime(String str) {
        this.d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.e = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeList(this.e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
