package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() {
        /* class com.amap.api.maps.offlinemap.Province.AnonymousClass1 */

        /* renamed from: a */
        public Province createFromParcel(Parcel parcel) {
            return new Province(parcel);
        }

        /* renamed from: a */
        public Province[] newArray(int i) {
            return new Province[i];
        }
    };
    private String a = "";
    private String b;
    private String c;
    private String d = "";

    public Province() {
    }

    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.b;
    }

    public String getPinyin() {
        return this.c;
    }

    public String getProvinceCode() {
        return this.d;
    }

    public String getProvinceName() {
        return this.a;
    }

    public void setJianpin(String str) {
        this.b = str;
    }

    public void setPinyin(String str) {
        this.c = str;
    }

    public void setProvinceCode(String str) {
        this.d = str;
    }

    public void setProvinceName(String str) {
        this.a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public Province(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
