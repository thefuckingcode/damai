package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.b.e;
import java.io.Serializable;

/* compiled from: Taobao */
public final class AuthInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<AuthInfo> CREATOR = new Parcelable.Creator<AuthInfo>() {
        /* class com.sina.weibo.sdk.auth.AuthInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AuthInfo createFromParcel(Parcel parcel) {
            return new AuthInfo(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AuthInfo[] newArray(int i) {
            return new AuthInfo[i];
        }
    };
    private static final long serialVersionUID = 6421253895937667193L;
    private String app_key;
    private String hash;
    private String package_name;
    private String redirect_url;
    private String scope;

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.app_key = str;
        this.redirect_url = str2;
        this.scope = str3;
        String packageName = context.getPackageName();
        this.package_name = packageName;
        this.hash = e.b(context, packageName);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAppKey() {
        return this.app_key;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getPackageName() {
        return this.package_name;
    }

    public final String getRedirectUrl() {
        return this.redirect_url;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.app_key);
        parcel.writeString(this.redirect_url);
        parcel.writeString(this.scope);
        parcel.writeString(this.package_name);
        parcel.writeString(this.hash);
    }

    protected AuthInfo(Parcel parcel) {
        this.app_key = parcel.readString();
        this.redirect_url = parcel.readString();
        this.scope = parcel.readString();
        this.package_name = parcel.readString();
        this.hash = parcel.readString();
    }
}
