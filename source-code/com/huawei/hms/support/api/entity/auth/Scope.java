package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

/* compiled from: Taobao */
public class Scope implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<Scope> CREATOR = new a();
    private String mScopeUri;

    /* compiled from: Taobao */
    static class a implements Parcelable.Creator<Scope> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Scope[] newArray(int i) {
            return new Scope[i];
        }
    }

    public Scope() {
        this.mScopeUri = null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return Objects.equal(this.mScopeUri, ((Scope) obj).mScopeUri);
    }

    @Deprecated
    public boolean equeals(Object obj) {
        return equals(obj);
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public final int hashCode() {
        String str = this.mScopeUri;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final String toString() {
        return this.mScopeUri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mScopeUri);
    }

    public Scope(String str) {
        this.mScopeUri = str;
    }

    protected Scope(Parcel parcel) {
        this.mScopeUri = parcel.readString();
    }
}
