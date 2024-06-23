package cn.damai.commonbusiness.rank;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RankInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RankInfo> CREATOR = new a();
    private String id;
    private String name;
    private String order;

    /* compiled from: Taobao */
    public class a implements Parcelable.Creator<RankInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public RankInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-201600357")) {
                return new RankInfo(parcel);
            }
            return (RankInfo) ipChange.ipc$dispatch("-201600357", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public RankInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-595194992")) {
                return new RankInfo[i];
            }
            return (RankInfo[]) ipChange.ipc$dispatch("-595194992", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public RankInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1721148703")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1721148703", new Object[]{this})).intValue();
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1323989960")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-1323989960", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-973148888")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-973148888", new Object[]{this});
    }

    public String getOrder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1471915001")) {
            return this.order;
        }
        return (String) ipChange.ipc$dispatch("-1471915001", new Object[]{this});
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747336358")) {
            ipChange.ipc$dispatch("747336358", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395601226")) {
            ipChange.ipc$dispatch("-395601226", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setOrder(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188324529")) {
            ipChange.ipc$dispatch("-188324529", new Object[]{this, str});
            return;
        }
        this.order = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306615412")) {
            ipChange.ipc$dispatch("-1306615412", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.order);
    }

    protected RankInfo(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.order = parcel.readString();
    }
}
