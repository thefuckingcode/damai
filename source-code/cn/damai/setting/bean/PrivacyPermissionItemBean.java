package cn.damai.setting.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PrivacyPermissionItemBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivacyPermissionItemBean> CREATOR = new Parcelable.Creator<PrivacyPermissionItemBean>() {
        /* class cn.damai.setting.bean.PrivacyPermissionItemBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionItemBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1044359257")) {
                return new PrivacyPermissionItemBean(parcel);
            }
            return (PrivacyPermissionItemBean) ipChange.ipc$dispatch("1044359257", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionItemBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1782146256")) {
                return new PrivacyPermissionItemBean[i];
            }
            return (PrivacyPermissionItemBean[]) ipChange.ipc$dispatch("-1782146256", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public static Integer DNA_TAG = 2;
    public static Integer WANT_SEE_TAG = 1;
    public Integer permissionType;
    public String protocolLink;
    public String protocolName;
    public Integer value;

    public PrivacyPermissionItemBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "703232576")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("703232576", new Object[]{this})).intValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958707260")) {
            ipChange.ipc$dispatch("-958707260", new Object[]{this, parcel});
            return;
        }
        this.permissionType = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.value = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.protocolLink = parcel.readString();
        this.protocolName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461555851")) {
            ipChange.ipc$dispatch("1461555851", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeValue(this.permissionType);
        parcel.writeValue(this.value);
        parcel.writeString(this.protocolLink);
        parcel.writeString(this.protocolName);
    }

    protected PrivacyPermissionItemBean(Parcel parcel) {
        this.permissionType = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.value = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.protocolLink = parcel.readString();
        this.protocolName = parcel.readString();
    }
}
