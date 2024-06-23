package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class SuperGroupObject extends MediaObject {
    public static final Parcelable.Creator<SuperGroupObject> CREATOR = new Parcelable.Creator<SuperGroupObject>() {
        /* class com.sina.weibo.sdk.api.SuperGroupObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final SuperGroupObject createFromParcel(Parcel parcel) {
            return new SuperGroupObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SuperGroupObject[] newArray(int i) {
            return new SuperGroupObject[i];
        }
    };
    public String secName;
    public String sgExtParam;
    public String sgName;

    public SuperGroupObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sgName);
        parcel.writeString(this.secName);
        parcel.writeString(this.sgExtParam);
    }

    protected SuperGroupObject(Parcel parcel) {
        this.sgName = parcel.readString();
        this.secName = parcel.readString();
        this.sgExtParam = parcel.readString();
    }
}
