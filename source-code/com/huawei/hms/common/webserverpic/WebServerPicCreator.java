package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public final class WebServerPicCreator implements Parcelable.Creator<WebServerPic> {
    @Override // android.os.Parcelable.Creator
    public WebServerPic createFromParcel(Parcel parcel) {
        return new WebServerPic((Uri) parcel.readParcelable(Uri.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public WebServerPic[] newArray(int i) {
        return new WebServerPic[i];
    }
}
