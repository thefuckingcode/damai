package com.ali.user.mobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class RegionInfo implements Parcelable {
    public static final Parcelable.Creator<RegionInfo> CREATOR = new Parcelable.Creator<RegionInfo>() {
        /* class com.ali.user.mobile.model.RegionInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RegionInfo createFromParcel(Parcel parcel) {
            return new RegionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RegionInfo[] newArray(int i) {
            return new RegionInfo[i];
        }
    };
    public String character;
    public String checkPattern;
    public String code;
    public String domain;
    public boolean isDisplayLetter;
    public String name;
    public String pinyin;

    public RegionInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.character);
        parcel.writeString(this.name);
        parcel.writeString(this.pinyin);
        parcel.writeString(this.code);
        parcel.writeString(this.checkPattern);
        parcel.writeString(this.domain);
        parcel.writeBooleanArray(new boolean[]{this.isDisplayLetter});
    }

    public RegionInfo(Parcel parcel) {
        this.character = parcel.readString();
        this.name = parcel.readString();
        this.pinyin = parcel.readString();
        this.code = parcel.readString();
        this.checkPattern = parcel.readString();
        this.domain = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.isDisplayLetter = zArr[0];
    }
}
