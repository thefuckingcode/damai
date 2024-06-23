package com.taobao.accs.asp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ModifiedRecord implements Parcelable {
    public static final Parcelable.Creator<ModifiedRecord> CREATOR = new Parcelable.Creator<ModifiedRecord>() {
        /* class com.taobao.accs.asp.ModifiedRecord.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ModifiedRecord createFromParcel(Parcel parcel) {
            return new ModifiedRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ModifiedRecord[] newArray(int i) {
            return new ModifiedRecord[i];
        }
    };
    boolean isClear;
    Bundle modified;
    String name;
    long timestampVersion;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeBundle(this.modified);
        parcel.writeInt(this.isClear ? 1 : 0);
        parcel.writeLong(this.timestampVersion);
    }

    private ModifiedRecord(Parcel parcel) {
        this.name = parcel.readString();
        this.modified = parcel.readBundle(getClass().getClassLoader());
        this.isClear = parcel.readInt() != 1 ? false : true;
        this.timestampVersion = parcel.readLong();
    }

    ModifiedRecord(String str) {
        this.name = str;
    }
}
