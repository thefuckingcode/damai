package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ProjectTickGuidePreListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuidePreListBean> CREATOR = new Parcelable.Creator<ProjectTickGuidePreListBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreListBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "495675435")) {
                return new ProjectTickGuidePreListBean(parcel);
            }
            return (ProjectTickGuidePreListBean) ipChange.ipc$dispatch("495675435", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1196568312")) {
                return new ProjectTickGuidePreListBean[i];
            }
            return (ProjectTickGuidePreListBean[]) ipChange.ipc$dispatch("-1196568312", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String title;
    public List<ProjectTickGuidePreBean> tpgPreparationList;

    public ProjectTickGuidePreListBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-944565514")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-944565514", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615772821")) {
            ipChange.ipc$dispatch("1615772821", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeTypedList(this.tpgPreparationList);
    }

    protected ProjectTickGuidePreListBean(Parcel parcel) {
        this.title = parcel.readString();
        this.tpgPreparationList = parcel.createTypedArrayList(ProjectTickGuidePreBean.CREATOR);
    }
}
