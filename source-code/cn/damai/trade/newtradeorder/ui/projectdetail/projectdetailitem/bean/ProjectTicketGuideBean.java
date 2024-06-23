package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectTicketGuideBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTicketGuideBean> CREATOR = new Parcelable.Creator<ProjectTicketGuideBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectTicketGuideBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "487271749")) {
                return new ProjectTicketGuideBean(parcel);
            }
            return (ProjectTicketGuideBean) ipChange.ipc$dispatch("487271749", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectTicketGuideBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1677172208")) {
                return new ProjectTicketGuideBean[i];
            }
            return (ProjectTicketGuideBean[]) ipChange.ipc$dispatch("1677172208", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String headerImageUrl;
    public String purchaseGuideUrl;
    public String tpgBottomText;
    public ProjectTickGuideNoticeListBean tpgNotice;
    public ProjectTickGuidePreListBean tpgPreparation;

    public ProjectTicketGuideBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "14202378")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("14202378", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875111425")) {
            ipChange.ipc$dispatch("875111425", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.headerImageUrl);
        parcel.writeParcelable(this.tpgPreparation, i);
        parcel.writeParcelable(this.tpgNotice, i);
        parcel.writeString(this.tpgBottomText);
        parcel.writeString(this.purchaseGuideUrl);
    }

    protected ProjectTicketGuideBean(Parcel parcel) {
        this.headerImageUrl = parcel.readString();
        this.tpgPreparation = (ProjectTickGuidePreListBean) parcel.readParcelable(ProjectTickGuidePreBean.class.getClassLoader());
        this.tpgNotice = (ProjectTickGuideNoticeListBean) parcel.readParcelable(ProjectTickGuideNoticeListBean.class.getClassLoader());
        this.tpgBottomText = parcel.readString();
        this.purchaseGuideUrl = parcel.readString();
    }
}
