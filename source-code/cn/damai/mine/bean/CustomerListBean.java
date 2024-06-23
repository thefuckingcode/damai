package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CustomerListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CustomerListBean> CREATOR = new Parcelable.Creator<CustomerListBean>() {
        /* class cn.damai.mine.bean.CustomerListBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CustomerListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "487714031")) {
                return new CustomerListBean(parcel);
            }
            return (CustomerListBean) ipChange.ipc$dispatch("487714031", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CustomerListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "539335952")) {
                return new CustomerListBean[i];
            }
            return (CustomerListBean[]) ipChange.ipc$dispatch("539335952", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<CustomerBean> result;

    public CustomerListBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1823006091")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1823006091", new Object[]{this})).intValue();
    }

    public List<CustomerBean> getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1801456457")) {
            return this.result;
        }
        return (List) ipChange.ipc$dispatch("-1801456457", new Object[]{this});
    }

    public void setResult(List<CustomerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602214645")) {
            ipChange.ipc$dispatch("602214645", new Object[]{this, list});
            return;
        }
        this.result = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506873098")) {
            ipChange.ipc$dispatch("-506873098", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.result);
    }

    protected CustomerListBean(Parcel parcel) {
        this.result = parcel.createTypedArrayList(CustomerBean.CREATOR);
    }
}
