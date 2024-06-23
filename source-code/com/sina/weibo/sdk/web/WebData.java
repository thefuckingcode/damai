package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

/* compiled from: Taobao */
public class WebData implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebData> CREATOR = new Parcelable.Creator<WebData>() {
        /* class com.sina.weibo.sdk.web.WebData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebData createFromParcel(Parcel parcel) {
            return new WebData(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebData[] newArray(int i) {
            return new WebData[i];
        }
    };
    private static final long serialVersionUID = -4038177938155795889L;
    protected AuthInfo av;
    protected String aw;
    protected String i;
    protected int type;

    public WebData(AuthInfo authInfo, int i2, String str, String str2) {
        this.av = authInfo;
        this.type = i2;
        this.i = str;
        this.aw = str2;
    }

    public final AuthInfo a() {
        return this.av;
    }

    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.i;
    }

    public final String r() {
        return this.aw;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.av, i2);
        parcel.writeInt(this.type);
        parcel.writeString(this.i);
        parcel.writeString(this.aw);
    }

    protected WebData(Parcel parcel) {
        this.av = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        this.type = parcel.readInt();
        this.i = parcel.readString();
        this.aw = parcel.readString();
    }
}
