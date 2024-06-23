package cn.damai.homepage.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class SetPrivacyPermissionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SetPrivacyPermissionBean> CREATOR = new Parcelable.Creator<SetPrivacyPermissionBean>() {
        /* class cn.damai.homepage.bean.SetPrivacyPermissionBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public SetPrivacyPermissionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1672401913")) {
                return new SetPrivacyPermissionBean(parcel);
            }
            return (SetPrivacyPermissionBean) ipChange.ipc$dispatch("-1672401913", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public SetPrivacyPermissionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1457849840")) {
                return new SetPrivacyPermissionBean[i];
            }
            return (SetPrivacyPermissionBean[]) ipChange.ipc$dispatch("-1457849840", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public ArrayList<PrivacyPermissionItemBean> setupPermissionList;

    public SetPrivacyPermissionBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "628982121")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("628982121", new Object[]{this})).intValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083805627")) {
            ipChange.ipc$dispatch("2083805627", new Object[]{this, parcel});
            return;
        }
        this.setupPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209101442")) {
            ipChange.ipc$dispatch("209101442", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.setupPermissionList);
    }

    protected SetPrivacyPermissionBean(Parcel parcel) {
        this.setupPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }
}
