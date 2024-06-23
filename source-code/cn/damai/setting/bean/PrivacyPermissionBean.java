package cn.damai.setting.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class PrivacyPermissionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivacyPermissionBean> CREATOR = new Parcelable.Creator<PrivacyPermissionBean>() {
        /* class cn.damai.setting.bean.PrivacyPermissionBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "860116031")) {
                return new PrivacyPermissionBean(parcel);
            }
            return (PrivacyPermissionBean) ipChange.ipc$dispatch("860116031", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1899652336")) {
                return new PrivacyPermissionBean[i];
            }
            return (PrivacyPermissionBean[]) ipChange.ipc$dispatch("-1899652336", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public ArrayList<PrivacyPermissionItemBean> queryPermissionList;

    public PrivacyPermissionBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1954060237")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1954060237", new Object[]{this})).intValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184264745")) {
            ipChange.ipc$dispatch("-184264745", new Object[]{this, parcel});
            return;
        }
        this.queryPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2058968930")) {
            ipChange.ipc$dispatch("-2058968930", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.queryPermissionList);
    }

    protected PrivacyPermissionBean(Parcel parcel) {
        this.queryPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }
}
