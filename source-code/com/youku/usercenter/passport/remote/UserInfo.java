package com.youku.usercenter.passport.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.ali.user.mobile.register.RegistConstants;
import com.alibaba.fastjson.annotation.JSONField;
import org.json.JSONObject;

/* compiled from: Taobao */
public class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        /* class com.youku.usercenter.passport.remote.UserInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    };
    @JSONField(name = "avatar")
    public String mAvatarUrl;
    public String mEmail;
    @JSONField(name = "mobile")
    public String mMobile;
    @JSONField(name = "nickname")
    public String mNickName;
    @JSONField(name = RegistConstants.REGION_INFO)
    public String mRegion;
    @JSONField(name = "ytid")
    public String mUid;
    public String mUserName;
    @Deprecated
    public transient String mYid;
    @Deprecated
    public transient String mYoukuUid;
    public String thirdpartyAvatar;
    public String thirdpartyNickname;
    public String tuid;

    public UserInfo() {
        this.mUserName = "";
        this.mUid = "";
        this.mYoukuUid = "";
        this.mYid = "";
        this.mNickName = "";
        this.mEmail = "";
        this.mRegion = "";
        this.mMobile = "";
        this.mAvatarUrl = "";
    }

    public int describeContents() {
        return 0;
    }

    public void parseFrom(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mUserName = jSONObject.optString("username");
                this.mUid = jSONObject.optString("uid");
                this.mNickName = jSONObject.optString("nickname");
                this.mEmail = jSONObject.optString("email");
                this.mRegion = jSONObject.optString(RegistConstants.REGION_INFO);
                this.mMobile = jSONObject.optString("mobile");
                this.mAvatarUrl = jSONObject.optString("avatar");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = this.mUserName;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        parcel.writeString(str);
        String str3 = this.mUid;
        if (str3 == null) {
            str3 = str2;
        }
        parcel.writeString(str3);
        String str4 = this.mYoukuUid;
        if (str4 == null) {
            str4 = str2;
        }
        parcel.writeString(str4);
        String str5 = this.mYid;
        if (str5 == null) {
            str5 = str2;
        }
        parcel.writeString(str5);
        String str6 = this.mNickName;
        if (str6 == null) {
            str6 = str2;
        }
        parcel.writeString(str6);
        String str7 = this.mEmail;
        if (str7 == null) {
            str7 = str2;
        }
        parcel.writeString(str7);
        String str8 = this.mRegion;
        if (str8 == null) {
            str8 = str2;
        }
        parcel.writeString(str8);
        String str9 = this.mMobile;
        if (str9 == null) {
            str9 = str2;
        }
        parcel.writeString(str9);
        String str10 = this.mAvatarUrl;
        if (str10 != null) {
            str2 = str10;
        }
        parcel.writeString(str2);
        parcel.writeString(this.tuid);
        parcel.writeString(this.thirdpartyNickname);
        parcel.writeString(this.thirdpartyAvatar);
    }

    protected UserInfo(Parcel parcel) {
        this.mUserName = parcel.readString();
        this.mUid = parcel.readString();
        this.mYoukuUid = parcel.readString();
        this.mYid = parcel.readString();
        this.mNickName = parcel.readString();
        this.mEmail = parcel.readString();
        this.mRegion = parcel.readString();
        this.mMobile = parcel.readString();
        this.mAvatarUrl = parcel.readString();
        this.tuid = parcel.readString();
        this.thirdpartyNickname = parcel.readString();
        this.thirdpartyAvatar = parcel.readString();
    }
}
