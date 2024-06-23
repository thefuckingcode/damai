package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ProjectTickGuidePreBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuidePreBean> CREATOR = new Parcelable.Creator<ProjectTickGuidePreBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1130205717")) {
                return new ProjectTickGuidePreBean(parcel);
            }
            return (ProjectTickGuidePreBean) ipChange.ipc$dispatch("-1130205717", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "171775364")) {
                return new ProjectTickGuidePreBean[i];
            }
            return (ProjectTickGuidePreBean[]) ipChange.ipc$dispatch("171775364", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String calendarRemindTitle;
    public String desc;
    public String name;
    public ArrayList<String> preFillCheckList;
    public String projectId;
    public long sellStartTime;
    public String title;
    public boolean visEmail;

    public ProjectTickGuidePreBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-860073928")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-860073928", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591962515")) {
            ipChange.ipc$dispatch("1591962515", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeStringList(this.preFillCheckList);
    }

    protected ProjectTickGuidePreBean(Parcel parcel) {
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.preFillCheckList = parcel.createStringArrayList();
    }
}
