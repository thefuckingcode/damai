package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class ParcelableHeader implements Parcelable {
    public static Parcelable.Creator<ParcelableHeader> CREATOR = new Parcelable.Creator<ParcelableHeader>() {
        /* class anetwork.channel.aidl.ParcelableHeader.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ParcelableHeader createFromParcel(Parcel parcel) {
            return ParcelableHeader.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableHeader[] newArray(int i) {
            return new ParcelableHeader[i];
        }
    };
    private static final String TAG = "anet.ParcelableHeader";
    public Map<String, List<String>> header;
    public int responseCode;

    public ParcelableHeader(int i, Map<String, List<String>> map) {
        this.header = map;
        this.responseCode = i;
    }

    static ParcelableHeader readFromParcel(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.header = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.responseCode = parcel.readInt();
        } catch (Throwable th) {
            ALog.d(TAG, "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    public int describeContents() {
        return 0;
    }

    public Map<String, List<String>> getHeader() {
        return this.header;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.responseCode + ", header=" + this.header + jl1.ARRAY_END_STR;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.header != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.header);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.responseCode);
    }

    ParcelableHeader() {
    }
}
