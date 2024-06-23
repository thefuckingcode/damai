package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() {
        /* class com.amap.api.services.route.SearchCity.AnonymousClass1 */

        private static SearchCity a(Parcel parcel) {
            return new SearchCity(parcel);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SearchCity[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;

    public SearchCity(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.c;
    }

    public String getSearchCityName() {
        return this.a;
    }

    public String getSearchCitycode() {
        return this.b;
    }

    public void setSearchCityName(String str) {
        this.a = str;
    }

    public void setSearchCitycode(String str) {
        this.b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.c = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public SearchCity() {
    }
}
