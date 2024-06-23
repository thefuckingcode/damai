package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ProjectStaticExtendInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticExtendInfoBean> CREATOR = new Parcelable.Creator<ProjectStaticExtendInfoBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticExtendInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectStaticExtendInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1604638549")) {
                return new ProjectStaticExtendInfoBean(parcel);
            }
            return (ProjectStaticExtendInfoBean) ipChange.ipc$dispatch("-1604638549", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectStaticExtendInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2037403104")) {
                return new ProjectStaticExtendInfoBean[i];
            }
            return (ProjectStaticExtendInfoBean[]) ipChange.ipc$dispatch("-2037403104", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public ProjectStaticApproval approvalVO;
    public HighLights highLightsVO;
    public RichTextModule importantContent;
    public String itemDescTitle;
    public String itemExtend;
    public List<RichTextModule> otherContent;
    public RichTextModule outlineContent;

    public ProjectStaticExtendInfoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1905302422")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1905302422", new Object[]{this})).intValue();
    }

    public ProjectStaticApproval getApprovalVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-140759433")) {
            return this.approvalVO;
        }
        return (ProjectStaticApproval) ipChange.ipc$dispatch("-140759433", new Object[]{this});
    }

    public HighLights getHighLightsVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-418733350")) {
            return this.highLightsVO;
        }
        return (HighLights) ipChange.ipc$dispatch("-418733350", new Object[]{this});
    }

    public RichTextModule getImportantContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1423781883")) {
            return this.importantContent;
        }
        return (RichTextModule) ipChange.ipc$dispatch("-1423781883", new Object[]{this});
    }

    public String getItemDescTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "887842882")) {
            return this.itemDescTitle;
        }
        return (String) ipChange.ipc$dispatch("887842882", new Object[]{this});
    }

    public String getItemExtend() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-541359051")) {
            return this.itemExtend;
        }
        return (String) ipChange.ipc$dispatch("-541359051", new Object[]{this});
    }

    public List<RichTextModule> getOtherContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1295169512")) {
            return this.otherContent;
        }
        return (List) ipChange.ipc$dispatch("-1295169512", new Object[]{this});
    }

    public RichTextModule getOutlineContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-722187035")) {
            return this.outlineContent;
        }
        return (RichTextModule) ipChange.ipc$dispatch("-722187035", new Object[]{this});
    }

    public void setApprovalVO(ProjectStaticApproval projectStaticApproval) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "201683213")) {
            ipChange.ipc$dispatch("201683213", new Object[]{this, projectStaticApproval});
            return;
        }
        this.approvalVO = projectStaticApproval;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548156511")) {
            ipChange.ipc$dispatch("-1548156511", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.itemDescTitle);
        parcel.writeString(this.itemExtend);
        parcel.writeParcelable(this.importantContent, i);
        parcel.writeParcelable(this.highLightsVO, i);
        parcel.writeParcelable(this.outlineContent, i);
        parcel.writeTypedList(this.otherContent);
    }

    protected ProjectStaticExtendInfoBean(Parcel parcel) {
        this.itemDescTitle = parcel.readString();
        this.itemExtend = parcel.readString();
        this.importantContent = (RichTextModule) parcel.readParcelable(RichTextModule.class.getClassLoader());
        this.highLightsVO = (HighLights) parcel.readParcelable(HighLights.class.getClassLoader());
        this.outlineContent = (RichTextModule) parcel.readParcelable(RichTextModule.class.getClassLoader());
        this.otherContent = parcel.createTypedArrayList(RichTextModule.CREATOR);
    }
}
