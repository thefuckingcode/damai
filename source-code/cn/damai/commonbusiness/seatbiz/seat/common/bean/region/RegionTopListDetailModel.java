package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RegionTopListDetailModel implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionTopListDetailModel> CREATOR = new Parcelable.Creator<RegionTopListDetailModel>() {
        /* class cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionTopListDetailModel.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RegionTopListDetailModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "755419627")) {
                return new RegionTopListDetailModel(parcel);
            }
            return (RegionTopListDetailModel) ipChange.ipc$dispatch("755419627", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RegionTopListDetailModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-173897988")) {
                return new RegionTopListDetailModel[i];
            }
            return (RegionTopListDetailModel[]) ipChange.ipc$dispatch("-173897988", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private long id;
    private String pref;
    private String q;

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-928342788")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-928342788", new Object[]{this})).intValue();
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "968375711")) {
            return this.id;
        }
        return ((Long) ipChange.ipc$dispatch("968375711", new Object[]{this})).longValue();
    }

    public String getPref() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "687416221")) {
            return this.pref;
        }
        return (String) ipChange.ipc$dispatch("687416221", new Object[]{this});
    }

    public String getQ() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-882411795")) {
            return this.q;
        }
        return (String) ipChange.ipc$dispatch("-882411795", new Object[]{this});
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259710331")) {
            ipChange.ipc$dispatch("-259710331", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.id = j;
    }

    public void setPref(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-457690399")) {
            ipChange.ipc$dispatch("-457690399", new Object[]{this, str});
            return;
        }
        this.pref = str;
    }

    public void setQ(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022411561")) {
            ipChange.ipc$dispatch("2022411561", new Object[]{this, str});
            return;
        }
        this.q = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880296113")) {
            ipChange.ipc$dispatch("-880296113", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.pref);
        parcel.writeString(this.q);
    }

    public RegionTopListDetailModel() {
    }

    private RegionTopListDetailModel(Parcel parcel) {
        this.pref = parcel.readString();
        this.q = parcel.readString();
    }
}
