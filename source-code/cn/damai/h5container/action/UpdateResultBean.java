package cn.damai.h5container.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UpdateResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UpdateResultBean> CREATOR = new Parcelable.Creator<UpdateResultBean>() {
        /* class cn.damai.h5container.action.UpdateResultBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public UpdateResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1441201259")) {
                return new UpdateResultBean(parcel);
            }
            return (UpdateResultBean) ipChange.ipc$dispatch("1441201259", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public UpdateResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1564951492")) {
                return new UpdateResultBean[i];
            }
            return (UpdateResultBean[]) ipChange.ipc$dispatch("-1564951492", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String hasUpdate;

    public UpdateResultBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-6557732")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-6557732", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288716689")) {
            ipChange.ipc$dispatch("-288716689", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.hasUpdate);
    }

    protected UpdateResultBean(Parcel parcel) {
        this.hasUpdate = parcel.readString();
    }
}
