package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectTickGuideNoticeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuideNoticeBean> CREATOR = new Parcelable.Creator<ProjectTickGuideNoticeBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuideNoticeBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuideNoticeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1740910519")) {
                return new ProjectTickGuideNoticeBean(parcel);
            }
            return (ProjectTickGuideNoticeBean) ipChange.ipc$dispatch("1740910519", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectTickGuideNoticeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "311827216")) {
                return new ProjectTickGuideNoticeBean[i];
            }
            return (ProjectTickGuideNoticeBean[]) ipChange.ipc$dispatch("311827216", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String desc;
    public String imageUrl;
    public String notice;

    public ProjectTickGuideNoticeBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1063000687")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1063000687", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355472218")) {
            ipChange.ipc$dispatch("355472218", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.notice);
        parcel.writeString(this.desc);
        parcel.writeString(this.imageUrl);
    }

    protected ProjectTickGuideNoticeBean(Parcel parcel) {
        this.notice = parcel.readString();
        this.desc = parcel.readString();
        this.imageUrl = parcel.readString();
    }
}
