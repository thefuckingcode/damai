package com.ali.user.mobile.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class RegistParam implements Parcelable {
    public static final Parcelable.Creator<RegistParam> CREATOR = new Parcelable.Creator<RegistParam>() {
        /* class com.ali.user.mobile.model.RegistParam.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RegistParam createFromParcel(Parcel parcel) {
            return new RegistParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RegistParam[] newArray(int i) {
            return new RegistParam[i];
        }
    };
    public static final Pattern REG_EMAIL = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    public String regFrom;
    public String registAccount;
    public int registSite;
    public String registerSiteString;
    public String source = "";
    public String token;
    public boolean userSiteHere;

    public RegistParam() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.registAccount);
        parcel.writeString(this.token);
        parcel.writeInt(this.registSite);
        parcel.writeString(this.regFrom);
        parcel.writeInt(this.userSiteHere ? 1 : 0);
        parcel.writeString(this.registerSiteString);
    }

    public RegistParam(Parcel parcel) {
        this.registAccount = parcel.readString();
        this.token = parcel.readString();
        this.registSite = parcel.readInt();
        this.regFrom = parcel.readString();
        this.userSiteHere = parcel.readInt() != 1 ? false : true;
        this.registerSiteString = parcel.readString();
    }
}
