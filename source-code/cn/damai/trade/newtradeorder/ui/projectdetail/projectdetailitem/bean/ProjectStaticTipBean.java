package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectStaticTipBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticTipBean> CREATOR = new Parcelable.Creator<ProjectStaticTipBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticTipBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectStaticTipBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1561471435")) {
                return new ProjectStaticTipBean(parcel);
            }
            return (ProjectStaticTipBean) ipChange.ipc$dispatch("1561471435", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectStaticTipBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "17446928")) {
                return new ProjectStaticTipBean[i];
            }
            return (ProjectStaticTipBean[]) ipChange.ipc$dispatch("17446928", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String description;
    private String name;

    public ProjectStaticTipBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1525935993")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1525935993", new Object[]{this})).intValue();
    }

    public String getDescription() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1121051341")) {
            return this.description;
        }
        return (String) ipChange.ipc$dispatch("1121051341", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1784254320")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1784254320", new Object[]{this});
    }

    public void setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907098039")) {
            ipChange.ipc$dispatch("-1907098039", new Object[]{this, str});
            return;
        }
        this.description = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229934158")) {
            ipChange.ipc$dispatch("229934158", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1628468004")) {
            ipChange.ipc$dispatch("1628468004", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.description);
    }

    protected ProjectStaticTipBean(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
    }
}
