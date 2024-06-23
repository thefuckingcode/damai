package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RealNameVerifyScheduleBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameVerifyScheduleBean> CREATOR = new Parcelable.Creator<RealNameVerifyScheduleBean>() {
        /* class cn.damai.mine.bean.RealNameVerifyScheduleBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RealNameVerifyScheduleBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1029676491")) {
                return new RealNameVerifyScheduleBean(parcel);
            }
            return (RealNameVerifyScheduleBean) ipChange.ipc$dispatch("-1029676491", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RealNameVerifyScheduleBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1291867920")) {
                return new RealNameVerifyScheduleBean[i];
            }
            return (RealNameVerifyScheduleBean[]) ipChange.ipc$dispatch("-1291867920", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String expectFinishTimeMsg;

    public RealNameVerifyScheduleBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1489325042")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1489325042", new Object[]{this})).intValue();
    }

    public String getExpectFinishTimeMsg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-318844786")) {
            return this.expectFinishTimeMsg;
        }
        return (String) ipChange.ipc$dispatch("-318844786", new Object[]{this});
    }

    public void setExpectFinishTimeMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380435624")) {
            ipChange.ipc$dispatch("380435624", new Object[]{this, str});
            return;
        }
        this.expectFinishTimeMsg = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049500441")) {
            ipChange.ipc$dispatch("1049500441", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.expectFinishTimeMsg);
    }

    protected RealNameVerifyScheduleBean(Parcel parcel) {
        this.expectFinishTimeMsg = parcel.readString();
    }
}
