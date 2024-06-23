package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class AddressListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddressListBean> CREATOR = new Parcelable.Creator<AddressListBean>() {
        /* class cn.damai.commonbusiness.address.bean.AddressListBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public AddressListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "309824811")) {
                return new AddressListBean(parcel);
            }
            return (AddressListBean) ipChange.ipc$dispatch("309824811", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public AddressListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1661244000")) {
                return new AddressListBean[i];
            }
            return (AddressListBean[]) ipChange.ipc$dispatch("1661244000", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String ableAdd;
    private String districtMsg;
    private List<AddressBean> list;
    private String msg;

    public AddressListBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "643382858")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("643382858", new Object[]{this})).intValue();
    }

    public String getAbleAdd() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "801246613")) {
            return this.ableAdd;
        }
        return (String) ipChange.ipc$dispatch("801246613", new Object[]{this});
    }

    public String getDistrictMsg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1029911999")) {
            return this.districtMsg;
        }
        return (String) ipChange.ipc$dispatch("-1029911999", new Object[]{this});
    }

    public List<AddressBean> getList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-627437299")) {
            return this.list;
        }
        return (List) ipChange.ipc$dispatch("-627437299", new Object[]{this});
    }

    public String getMsg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1679808687")) {
            return this.msg;
        }
        return (String) ipChange.ipc$dispatch("1679808687", new Object[]{this});
    }

    public void setAbleAdd(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747554945")) {
            ipChange.ipc$dispatch("1747554945", new Object[]{this, str});
            return;
        }
        this.ableAdd = str;
    }

    public void setDistrictMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132515157")) {
            ipChange.ipc$dispatch("132515157", new Object[]{this, str});
            return;
        }
        this.districtMsg = str;
    }

    public void setList(List<AddressBean> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771179103")) {
            ipChange.ipc$dispatch("1771179103", new Object[]{this, list2});
            return;
        }
        this.list = list2;
    }

    public void setMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953009831")) {
            ipChange.ipc$dispatch("1953009831", new Object[]{this, str});
            return;
        }
        this.msg = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1665278913")) {
            ipChange.ipc$dispatch("1665278913", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.ableAdd);
        parcel.writeTypedList(this.list);
        parcel.writeString(this.msg);
        parcel.writeString(this.districtMsg);
    }

    protected AddressListBean(Parcel parcel) {
        this.ableAdd = parcel.readString();
        this.list = parcel.createTypedArrayList(AddressBean.CREATOR);
        this.msg = parcel.readString();
        this.districtMsg = parcel.readString();
    }
}
