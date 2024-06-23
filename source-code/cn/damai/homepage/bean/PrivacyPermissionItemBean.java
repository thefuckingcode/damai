package cn.damai.homepage.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PrivacyPermissionItemBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivacyPermissionItemBean> CREATOR = new Parcelable.Creator<PrivacyPermissionItemBean>() {
        /* class cn.damai.homepage.bean.PrivacyPermissionItemBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionItemBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "504874731")) {
                return new PrivacyPermissionItemBean(parcel);
            }
            return (PrivacyPermissionItemBean) ipChange.ipc$dispatch("504874731", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionItemBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "958371756")) {
                return new PrivacyPermissionItemBean[i];
            }
            return (PrivacyPermissionItemBean[]) ipChange.ipc$dispatch("958371756", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public Integer permissionType;
    public Integer value;

    public PrivacyPermissionItemBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1344556196")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1344556196", new Object[]{this})).intValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775687136")) {
            ipChange.ipc$dispatch("775687136", new Object[]{this, parcel});
            return;
        }
        this.permissionType = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.value = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099017049")) {
            ipChange.ipc$dispatch("-1099017049", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeValue(this.permissionType);
        parcel.writeValue(this.value);
    }

    protected PrivacyPermissionItemBean(Parcel parcel) {
        this.permissionType = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.value = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
