package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
class b implements Parcelable.Creator<RemoteMessage> {
    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        return new RemoteMessage(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
