package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DefaultAddressBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DefaultAddressBean> CREATOR = new Parcelable.Creator<DefaultAddressBean>() {
        /* class cn.damai.mine.bean.DefaultAddressBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DefaultAddressBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1992633727")) {
                return new DefaultAddressBean(parcel);
            }
            return (DefaultAddressBean) ipChange.ipc$dispatch("-1992633727", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DefaultAddressBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1189415376")) {
                return new DefaultAddressBean[i];
            }
            return (DefaultAddressBean[]) ipChange.ipc$dispatch("-1189415376", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String success;

    public DefaultAddressBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1092639756")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1092639756", new Object[]{this})).intValue();
    }

    public String getSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-237336657")) {
            return this.success;
        }
        return (String) ipChange.ipc$dispatch("-237336657", new Object[]{this});
    }

    public void setSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383755353")) {
            ipChange.ipc$dispatch("-383755353", new Object[]{this, str});
            return;
        }
        this.success = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-863632833")) {
            ipChange.ipc$dispatch("-863632833", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.success);
    }

    protected DefaultAddressBean(Parcel parcel) {
        this.success = parcel.readString();
    }
}
