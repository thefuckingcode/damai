package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ProjectTickGuideNoticeListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuideNoticeListBean> CREATOR = new Parcelable.Creator<ProjectTickGuideNoticeListBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuideNoticeListBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuideNoticeListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1917560635")) {
                return new ProjectTickGuideNoticeListBean(parcel);
            }
            return (ProjectTickGuideNoticeListBean) ipChange.ipc$dispatch("1917560635", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuideNoticeListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1193056048")) {
                return new ProjectTickGuideNoticeListBean[i];
            }
            return (ProjectTickGuideNoticeListBean[]) ipChange.ipc$dispatch("-1193056048", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public List<ProjectTickGuideNoticeBean> noticeModules;
    public String title;

    public ProjectTickGuideNoticeListBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1464970289")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1464970289", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290021084")) {
            ipChange.ipc$dispatch("1290021084", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeTypedList(this.noticeModules);
    }

    protected ProjectTickGuideNoticeListBean(Parcel parcel) {
        this.title = parcel.readString();
        this.noticeModules = parcel.createTypedArrayList(ProjectTickGuideNoticeBean.CREATOR);
    }
}
