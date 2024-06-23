package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class ProjectSwitchIdDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectSwitchIdResultBean data;

    /* compiled from: Taobao */
    public static class ProjectSwitchIdResultBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ProjectSwitchIdResultBean> CREATOR = new Parcelable.Creator<ProjectSwitchIdResultBean>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean.ProjectSwitchIdResultBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public ProjectSwitchIdResultBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "839013565")) {
                    return new ProjectSwitchIdResultBean(parcel);
                }
                return (ProjectSwitchIdResultBean) ipChange.ipc$dispatch("839013565", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public ProjectSwitchIdResultBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-177965200")) {
                    return new ProjectSwitchIdResultBean[i];
                }
                return (ProjectSwitchIdResultBean[]) ipChange.ipc$dispatch("-177965200", new Object[]{this, Integer.valueOf(i)});
            }
        };
        public String result;

        public ProjectSwitchIdResultBean() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1073121358")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("1073121358", new Object[]{this})).intValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1424597565")) {
                ipChange.ipc$dispatch("1424597565", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.result);
        }

        protected ProjectSwitchIdResultBean(Parcel parcel) {
            this.result = parcel.readString();
        }
    }

    public void setData(ProjectSwitchIdResultBean projectSwitchIdResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162587471")) {
            ipChange.ipc$dispatch("162587471", new Object[]{this, projectSwitchIdResultBean});
            return;
        }
        this.data = projectSwitchIdResultBean;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public ProjectSwitchIdResultBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-575669623")) {
            return this.data;
        }
        return (ProjectSwitchIdResultBean) ipChange.ipc$dispatch("-575669623", new Object[]{this});
    }
}
