package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectStaticEnterpriseInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticEnterpriseInfo> CREATOR = new Parcelable.Creator<ProjectStaticEnterpriseInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticEnterpriseInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectStaticEnterpriseInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1958124811")) {
                return new ProjectStaticEnterpriseInfo(parcel);
            }
            return (ProjectStaticEnterpriseInfo) ipChange.ipc$dispatch("1958124811", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectStaticEnterpriseInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1264497074")) {
                return new ProjectStaticEnterpriseInfo[i];
            }
            return (ProjectStaticEnterpriseInfo[]) ipChange.ipc$dispatch("1264497074", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String cpName;
    public String entAddress;
    public String entType;
    public String legalPerson;
    public String opFrom;
    public String opTo;
    public String regCapStr;
    public String socialCreditCode;

    public ProjectStaticEnterpriseInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-653629919")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-653629919", new Object[]{this})).intValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "140934147")) {
            ipChange.ipc$dispatch("140934147", new Object[]{this, parcel});
            return;
        }
        this.cpName = parcel.readString();
        this.socialCreditCode = parcel.readString();
        this.legalPerson = parcel.readString();
        this.regCapStr = parcel.readString();
        this.opFrom = parcel.readString();
        this.opTo = parcel.readString();
        this.entType = parcel.readString();
        this.entAddress = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733770038")) {
            ipChange.ipc$dispatch("-1733770038", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.cpName);
        parcel.writeString(this.socialCreditCode);
        parcel.writeString(this.legalPerson);
        parcel.writeString(this.regCapStr);
        parcel.writeString(this.opFrom);
        parcel.writeString(this.opTo);
        parcel.writeString(this.entType);
        parcel.writeString(this.entAddress);
    }

    protected ProjectStaticEnterpriseInfo(Parcel parcel) {
        this.cpName = parcel.readString();
        this.socialCreditCode = parcel.readString();
        this.legalPerson = parcel.readString();
        this.regCapStr = parcel.readString();
        this.opFrom = parcel.readString();
        this.opTo = parcel.readString();
        this.entType = parcel.readString();
        this.entAddress = parcel.readString();
    }
}
