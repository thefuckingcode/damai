package com.taobao.aranger.core.wrapper;

import android.os.Parcel;

/* compiled from: Taobao */
public class BaseWrapper {
    private String mName;

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
    }

    /* access modifiers changed from: package-private */
    public void setName(String str) {
        this.mName = str;
    }

    /* access modifiers changed from: package-private */
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
    }
}
