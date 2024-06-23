package com.youku.usercenter.passport.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class PassportConfig implements Parcelable {
    public static final Parcelable.Creator<PassportConfig> CREATOR = new Parcelable.Creator<PassportConfig>() {
        /* class com.youku.usercenter.passport.remote.PassportConfig.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public PassportConfig createFromParcel(Parcel parcel) {
            return new PassportConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PassportConfig[] newArray(int i) {
            return new PassportConfig[i];
        }
    };
    public static final String PASSPORT_THEME_TUDOU = "tudou";
    public static final String PASSPORT_THEME_YOUKU = "youku";
    public String mAlipayAppId;
    public boolean mAlipayLoginSupport = true;
    public String mAlipayPid;
    public String mAlipaySignType;
    public String mAppId;
    public String mAppSecret;
    public boolean mDebug = false;
    public Domain mDomain = Domain.DOMAIN_ONLINE;
    public String mGuid;
    public String mMMAppId;
    public boolean mMMLoginSupport = true;
    public String mPid;
    public String mQQAppId;
    public boolean mQQLoginSupport = true;
    public boolean mTaobaoLoginSupport = true;
    public String mTheme;
    private Bundle mThemeBundle;
    public boolean mUseMtop = true;
    public boolean mUseOrange = true;
    public String mWeiboAppId;
    public boolean mWeiboLoginSupport = true;
    public String mWeiboRedirectUrl;
    public int orientation = 1;

    public PassportConfig() {
    }

    public int describeContents() {
        return 0;
    }

    public ThemeBundle getThemeBundle() {
        Bundle bundle = this.mThemeBundle;
        if (bundle != null) {
            return new ThemeBundle(bundle);
        }
        return null;
    }

    public void setThemeBundle(ThemeBundle themeBundle) {
        if (themeBundle != null) {
            this.mThemeBundle = themeBundle.getBundle();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = this.mAppId;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        parcel.writeString(str);
        String str3 = this.mAppSecret;
        if (str3 == null) {
            str3 = str2;
        }
        parcel.writeString(str3);
        parcel.writeByte(this.mQQLoginSupport ? (byte) 1 : 0);
        parcel.writeByte(this.mMMLoginSupport ? (byte) 1 : 0);
        parcel.writeByte(this.mWeiboLoginSupport ? (byte) 1 : 0);
        parcel.writeByte(this.mTaobaoLoginSupport ? (byte) 1 : 0);
        parcel.writeByte(this.mAlipayLoginSupport ? (byte) 1 : 0);
        String str4 = this.mQQAppId;
        if (str4 == null) {
            str4 = str2;
        }
        parcel.writeString(str4);
        String str5 = this.mMMAppId;
        if (str5 == null) {
            str5 = str2;
        }
        parcel.writeString(str5);
        String str6 = this.mWeiboAppId;
        if (str6 == null) {
            str6 = str2;
        }
        parcel.writeString(str6);
        String str7 = this.mAlipayAppId;
        if (str7 == null) {
            str7 = str2;
        }
        parcel.writeString(str7);
        String str8 = this.mAlipayPid;
        if (str8 == null) {
            str8 = str2;
        }
        parcel.writeString(str8);
        String str9 = this.mAlipaySignType;
        if (str9 == null) {
            str9 = str2;
        }
        parcel.writeString(str9);
        String str10 = this.mWeiboRedirectUrl;
        if (str10 == null) {
            str10 = str2;
        }
        parcel.writeString(str10);
        String str11 = this.mGuid;
        if (str11 == null) {
            str11 = str2;
        }
        parcel.writeString(str11);
        String str12 = this.mPid;
        if (str12 == null) {
            str12 = str2;
        }
        parcel.writeString(str12);
        parcel.writeByte(this.mDebug ? (byte) 1 : 0);
        String str13 = this.mTheme;
        if (str13 != null) {
            str2 = str13;
        }
        parcel.writeString(str2);
        parcel.writeByte(this.mUseMtop ? (byte) 1 : 0);
        parcel.writeByte(this.mUseOrange ? (byte) 1 : 0);
        parcel.writeBundle(this.mThemeBundle);
        parcel.writeString(this.mDomain.name());
        parcel.writeInt(this.orientation);
    }

    protected PassportConfig(Parcel parcel) {
        boolean z = true;
        this.mAppId = parcel.readString();
        this.mAppSecret = parcel.readString();
        this.mQQLoginSupport = parcel.readByte() != 0;
        this.mMMLoginSupport = parcel.readByte() != 0;
        this.mWeiboLoginSupport = parcel.readByte() != 0;
        this.mTaobaoLoginSupport = parcel.readByte() != 0;
        this.mAlipayLoginSupport = parcel.readByte() != 0;
        this.mQQAppId = parcel.readString();
        this.mMMAppId = parcel.readString();
        this.mWeiboAppId = parcel.readString();
        this.mAlipayAppId = parcel.readString();
        this.mAlipayPid = parcel.readString();
        this.mAlipaySignType = parcel.readString();
        this.mWeiboRedirectUrl = parcel.readString();
        this.mGuid = parcel.readString();
        this.mPid = parcel.readString();
        this.mDebug = parcel.readByte() != 0;
        this.mTheme = parcel.readString();
        this.mUseMtop = parcel.readByte() != 0;
        this.mUseOrange = parcel.readByte() == 0 ? false : z;
        this.mThemeBundle = parcel.readBundle(getClass().getClassLoader());
        this.mDomain = Domain.valueOf(parcel.readString());
        this.orientation = parcel.readInt();
    }
}
