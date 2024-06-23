package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class Dimension implements Parcelable {
    public static final Parcelable.Creator<Dimension> CREATOR = new Parcelable.Creator<Dimension>() {
        /* class com.alibaba.mtl.appmonitor.model.Dimension.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Dimension createFromParcel(Parcel parcel) {
            return Dimension.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Dimension[] newArray(int i) {
            return new Dimension[i];
        }
    };
    static final String DEFAULT_NULL_VALUE = "null";
    protected String constantValue;
    protected String name;

    public Dimension() {
        this.constantValue = DEFAULT_NULL_VALUE;
    }

    static Dimension readFromParcel(Parcel parcel) {
        try {
            return new Dimension(parcel.readString(), parcel.readString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        String str = this.name;
        if (str == null) {
            if (dimension.name != null) {
                return false;
            }
        } else if (!str.equals(dimension.name)) {
            return false;
        }
        return true;
    }

    public String getConstantValue() {
        return this.constantValue;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setConstantValue(String str) {
        this.constantValue = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.constantValue);
        parcel.writeString(this.name);
    }

    public Dimension(String str) {
        this(str, null);
    }

    public Dimension(String str, String str2) {
        this.constantValue = DEFAULT_NULL_VALUE;
        this.name = str;
        this.constantValue = str2 == null ? DEFAULT_NULL_VALUE : str2;
    }
}
