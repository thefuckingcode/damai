package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RegionDataQuYuInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionDataQuYuInfo> CREATOR = new Parcelable.Creator<RegionDataQuYuInfo>() {
        /* class cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYuInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RegionDataQuYuInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1555980235")) {
                return new RegionDataQuYuInfo(parcel);
            }
            return (RegionDataQuYuInfo) ipChange.ipc$dispatch("1555980235", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RegionDataQuYuInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "387538006")) {
                return new RegionDataQuYuInfo[i];
            }
            return (RegionDataQuYuInfo[]) ipChange.ipc$dispatch("387538006", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String c;
    public long i;
    public String j;
    public String n;
    public String pis;
    public String rainbow;
    public int s;
    public String vid;
    public long zh;

    public RegionDataQuYuInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-290342929")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-290342929", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70154052")) {
            ipChange.ipc$dispatch("-70154052", new Object[]{this, parcel, Integer.valueOf(i2)});
            return;
        }
        parcel.writeString(this.c);
        parcel.writeString(this.n);
        parcel.writeLong((long) i2);
        parcel.writeInt(this.s);
        parcel.writeString(this.pis);
        parcel.writeString(this.j);
        parcel.writeLong(this.zh);
    }

    protected RegionDataQuYuInfo(Parcel parcel) {
        this.c = parcel.readString();
        this.n = parcel.readString();
        this.i = parcel.readLong();
        this.s = parcel.readInt();
        this.pis = parcel.readString();
        this.j = parcel.readString();
        this.zh = parcel.readLong();
    }
}
