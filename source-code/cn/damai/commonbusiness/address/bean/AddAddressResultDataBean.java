package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class AddAddressResultDataBean extends BaseOutDo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddAddressResultDataBean> CREATOR = new Parcelable.Creator<AddAddressResultDataBean>() {
        /* class cn.damai.commonbusiness.address.bean.AddAddressResultDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public AddAddressResultDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-858874311")) {
                return new AddAddressResultDataBean(parcel);
            }
            return (AddAddressResultDataBean) ipChange.ipc$dispatch("-858874311", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public AddAddressResultDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "208704688")) {
                return new AddAddressResultDataBean[i];
            }
            return (AddAddressResultDataBean[]) ipChange.ipc$dispatch("208704688", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private AddAddressResultBean data;

    public AddAddressResultDataBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-848182992")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-848182992", new Object[]{this})).intValue();
    }

    public void setData(AddAddressResultBean addAddressResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858338314")) {
            ipChange.ipc$dispatch("1858338314", new Object[]{this, addAddressResultBean});
            return;
        }
        this.data = addAddressResultBean;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2131691931")) {
            ipChange.ipc$dispatch("2131691931", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.data, i);
    }

    protected AddAddressResultDataBean(Parcel parcel) {
        this.data = (AddAddressResultBean) parcel.readParcelable(AddAddressResultBean.class.getClassLoader());
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public AddAddressResultBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "361254398")) {
            return this.data;
        }
        return (AddAddressResultBean) ipChange.ipc$dispatch("361254398", new Object[]{this});
    }
}
