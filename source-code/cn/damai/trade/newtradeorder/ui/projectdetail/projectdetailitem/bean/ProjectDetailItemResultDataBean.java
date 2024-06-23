package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectDetailItemResultDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectDetailItemResultDataBean> CREATOR = new Parcelable.Creator<ProjectDetailItemResultDataBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailItemResultDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectDetailItemResultDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-922970165")) {
                return new ProjectDetailItemResultDataBean(parcel);
            }
            return (ProjectDetailItemResultDataBean) ipChange.ipc$dispatch("-922970165", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectDetailItemResultDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1865424886")) {
                return new ProjectDetailItemResultDataBean[i];
            }
            return (ProjectDetailItemResultDataBean[]) ipChange.ipc$dispatch("1865424886", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String errorMsg;
    private String result;

    public ProjectDetailItemResultDataBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1339954495")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1339954495", new Object[]{this})).intValue();
    }

    public String getErrorMsg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "387778326")) {
            return this.errorMsg;
        }
        return (String) ipChange.ipc$dispatch("387778326", new Object[]{this});
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-104154790")) {
            return this.result;
        }
        return (String) ipChange.ipc$dispatch("-104154790", new Object[]{this});
    }

    public void setErrorMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746101624")) {
            ipChange.ipc$dispatch("-746101624", new Object[]{this, str});
            return;
        }
        this.errorMsg = str;
    }

    public void setResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328923196")) {
            ipChange.ipc$dispatch("-328923196", new Object[]{this, str});
            return;
        }
        this.result = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81884524")) {
            ipChange.ipc$dispatch("81884524", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.result);
        parcel.writeString(this.errorMsg);
    }

    protected ProjectDetailItemResultDataBean(Parcel parcel) {
        this.result = parcel.readString();
        this.errorMsg = parcel.readString();
    }
}
