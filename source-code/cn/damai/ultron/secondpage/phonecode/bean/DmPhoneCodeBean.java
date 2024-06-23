package cn.damai.ultron.secondpage.phonecode.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DmPhoneCodeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DmPhoneCodeBean> CREATOR = new Parcelable.Creator<DmPhoneCodeBean>() {
        /* class cn.damai.ultron.secondpage.phonecode.bean.DmPhoneCodeBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DmPhoneCodeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1808460803")) {
                return new DmPhoneCodeBean(parcel);
            }
            return (DmPhoneCodeBean) ipChange.ipc$dispatch("-1808460803", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DmPhoneCodeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1048169872")) {
                return new DmPhoneCodeBean[i];
            }
            return (DmPhoneCodeBean[]) ipChange.ipc$dispatch("-1048169872", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String area;
    public String code;

    public DmPhoneCodeBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "49282254")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("49282254", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645381565")) {
            ipChange.ipc$dispatch("645381565", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.area);
        parcel.writeString(this.code);
    }

    protected DmPhoneCodeBean(Parcel parcel) {
        this.area = parcel.readString();
        this.code = parcel.readString();
    }
}
