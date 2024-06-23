package cn.damai.commonbusiness.seatbiz.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CreateOrderExParams implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CreateOrderExParams> CREATOR = new Parcelable.Creator<CreateOrderExParams>() {
        /* class cn.damai.commonbusiness.seatbiz.common.bean.CreateOrderExParams.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CreateOrderExParams createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1761109879")) {
                return new CreateOrderExParams(parcel);
            }
            return (CreateOrderExParams) ipChange.ipc$dispatch("1761109879", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CreateOrderExParams[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1078177008")) {
                return new CreateOrderExParams[i];
            }
            return (CreateOrderExParams[]) ipChange.ipc$dispatch("-1078177008", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String atomSplit = "1";
    private String channel;
    private String damai;
    private String seatInfo;
    private String umpChannel = "10001";

    public CreateOrderExParams() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "642659761")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("642659761", new Object[]{this})).intValue();
    }

    public String getAtomSplit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1642122032")) {
            return this.atomSplit;
        }
        return (String) ipChange.ipc$dispatch("1642122032", new Object[]{this});
    }

    public String getChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1877974550")) {
            return this.channel;
        }
        return (String) ipChange.ipc$dispatch("-1877974550", new Object[]{this});
    }

    public String getDamai() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-301311201")) {
            return this.damai;
        }
        return (String) ipChange.ipc$dispatch("-301311201", new Object[]{this});
    }

    public String getSeatInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-659839102")) {
            return this.seatInfo;
        }
        return (String) ipChange.ipc$dispatch("-659839102", new Object[]{this});
    }

    public String getUmpChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-9239750")) {
            return this.umpChannel;
        }
        return (String) ipChange.ipc$dispatch("-9239750", new Object[]{this});
    }

    public void setAtomSplit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695937862")) {
            ipChange.ipc$dispatch("1695937862", new Object[]{this, str});
            return;
        }
        this.atomSplit = str;
    }

    public void setChannel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296077516")) {
            ipChange.ipc$dispatch("296077516", new Object[]{this, str});
            return;
        }
        this.channel = str;
    }

    public void setDamai(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740654903")) {
            ipChange.ipc$dispatch("1740654903", new Object[]{this, str});
            return;
        }
        this.damai = str;
    }

    public void setSeatInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137496476")) {
            ipChange.ipc$dispatch("1137496476", new Object[]{this, str});
            return;
        }
        this.seatInfo = str;
    }

    public void setUmpChannel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898651620")) {
            ipChange.ipc$dispatch("1898651620", new Object[]{this, str});
            return;
        }
        this.umpChannel = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582561478")) {
            ipChange.ipc$dispatch("-1582561478", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.damai);
        parcel.writeString(this.channel);
        parcel.writeString(this.atomSplit);
        parcel.writeString(this.umpChannel);
        parcel.writeString(this.seatInfo);
    }

    public CreateOrderExParams(String str, String str2, String str3) {
        this.channel = str;
        this.atomSplit = str2;
        this.seatInfo = str3;
    }

    protected CreateOrderExParams(Parcel parcel) {
        this.damai = parcel.readString();
        this.channel = parcel.readString();
        this.atomSplit = parcel.readString();
        this.umpChannel = parcel.readString();
        this.seatInfo = parcel.readString();
    }
}
