package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RegionDataSeatPrice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionDataSeatPrice> CREATOR = new Parcelable.Creator<RegionDataSeatPrice>() {
        /* class cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataSeatPrice.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RegionDataSeatPrice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-217944841")) {
                return new RegionDataSeatPrice(parcel);
            }
            return (RegionDataSeatPrice) ipChange.ipc$dispatch("-217944841", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RegionDataSeatPrice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "133090448")) {
                return new RegionDataSeatPrice[i];
            }
            return (RegionDataSeatPrice[]) ipChange.ipc$dispatch("133090448", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String c;
    public long damaiPriceId;
    public String dm;
    public long maitixPriceId;
    public float p;
    public int sum;

    public RegionDataSeatPrice() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-313890191")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-313890191", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099426426")) {
            ipChange.ipc$dispatch("1099426426", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.maitixPriceId);
        parcel.writeLong(this.damaiPriceId);
        parcel.writeString(this.dm);
        parcel.writeFloat(this.p);
        parcel.writeString(this.c);
        parcel.writeInt(this.sum);
    }

    protected RegionDataSeatPrice(Parcel parcel) {
        this.maitixPriceId = parcel.readLong();
        this.damaiPriceId = parcel.readLong();
        this.dm = parcel.readString();
        this.p = parcel.readFloat();
        this.c = parcel.readString();
        this.sum = parcel.readInt();
    }
}
