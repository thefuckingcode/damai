package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class DivisionListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DivisionListBean> CREATOR = new Parcelable.Creator<DivisionListBean>() {
        /* class cn.damai.commonbusiness.address.bean.DivisionListBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DivisionListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2088943191")) {
                return new DivisionListBean(parcel);
            }
            return (DivisionListBean) ipChange.ipc$dispatch("2088943191", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DivisionListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-117675056")) {
                return new DivisionListBean[i];
            }
            return (DivisionListBean[]) ipChange.ipc$dispatch("-117675056", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String code;
    private List<DivisionBean> model;

    public DivisionListBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "895076865")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("895076865", new Object[]{this})).intValue();
    }

    public String getCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "632929900")) {
            return this.code;
        }
        return (String) ipChange.ipc$dispatch("632929900", new Object[]{this});
    }

    public List<DivisionBean> getModel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "386151271")) {
            return this.model;
        }
        return (List) ipChange.ipc$dispatch("386151271", new Object[]{this});
    }

    public void setCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146766350")) {
            ipChange.ipc$dispatch("-2146766350", new Object[]{this, str});
            return;
        }
        this.code = str;
    }

    public void setModel(List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409882333")) {
            ipChange.ipc$dispatch("1409882333", new Object[]{this, list});
            return;
        }
        this.model = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296641302")) {
            ipChange.ipc$dispatch("-296641302", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.code);
        parcel.writeTypedList(this.model);
    }

    protected DivisionListBean(Parcel parcel) {
        this.code = parcel.readString();
        this.model = parcel.createTypedArrayList(DivisionBean.CREATOR);
    }
}
