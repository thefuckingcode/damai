package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class QueryCardTypeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<QueryCardTypeBean> CREATOR = new Parcelable.Creator<QueryCardTypeBean>() {
        /* class cn.damai.commonbusiness.contacts.bean.QueryCardTypeBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public QueryCardTypeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1010364137")) {
                return new QueryCardTypeBean(parcel);
            }
            return (QueryCardTypeBean) ipChange.ipc$dispatch("-1010364137", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public QueryCardTypeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1226554384")) {
                return new QueryCardTypeBean[i];
            }
            return (QueryCardTypeBean[]) ipChange.ipc$dispatch("1226554384", new Object[]{this, Integer.valueOf(i)});
        }
    };
    List<CustomerType> customerTypeList;
    String tipInfo;

    public QueryCardTypeBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1223318559")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1223318559", new Object[]{this})).intValue();
    }

    public List<CustomerType> getCustomerTypeList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1568719292")) {
            return this.customerTypeList;
        }
        return (List) ipChange.ipc$dispatch("1568719292", new Object[]{this});
    }

    public String getTipInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "577641888")) {
            return this.tipInfo;
        }
        return (String) ipChange.ipc$dispatch("577641888", new Object[]{this});
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771328445")) {
            ipChange.ipc$dispatch("-771328445", new Object[]{this, parcel});
            return;
        }
        this.tipInfo = parcel.readString();
        this.customerTypeList = parcel.createTypedArrayList(CustomerType.CREATOR);
    }

    public void setCustomerTypeList(List<CustomerType> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120869488")) {
            ipChange.ipc$dispatch("-1120869488", new Object[]{this, list});
            return;
        }
        this.customerTypeList = list;
    }

    public void setTipInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889224234")) {
            ipChange.ipc$dispatch("-889224234", new Object[]{this, str});
            return;
        }
        this.tipInfo = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648934666")) {
            ipChange.ipc$dispatch("1648934666", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.tipInfo);
        parcel.writeTypedList(this.customerTypeList);
    }

    protected QueryCardTypeBean(Parcel parcel) {
        this.tipInfo = parcel.readString();
        this.customerTypeList = parcel.createTypedArrayList(CustomerType.CREATOR);
    }
}
