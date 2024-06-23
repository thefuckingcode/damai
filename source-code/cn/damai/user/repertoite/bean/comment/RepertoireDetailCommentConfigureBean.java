package cn.damai.user.repertoite.bean.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RepertoireDetailCommentConfigureBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RepertoireDetailCommentConfigureBean> CREATOR = new Parcelable.Creator<RepertoireDetailCommentConfigureBean>() {
        /* class cn.damai.user.repertoite.bean.comment.RepertoireDetailCommentConfigureBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RepertoireDetailCommentConfigureBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-16901333")) {
                return new RepertoireDetailCommentConfigureBean(parcel);
            }
            return (RepertoireDetailCommentConfigureBean) ipChange.ipc$dispatch("-16901333", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RepertoireDetailCommentConfigureBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-489871500")) {
                return new RepertoireDetailCommentConfigureBean[i];
            }
            return (RepertoireDetailCommentConfigureBean[]) ipChange.ipc$dispatch("-489871500", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private boolean isEnabledPublish;
    private boolean isShowModule;

    public RepertoireDetailCommentConfigureBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "848347008")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("848347008", new Object[]{this})).intValue();
    }

    public boolean isEnabledPublish() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "476700510")) {
            return this.isEnabledPublish;
        }
        return ((Boolean) ipChange.ipc$dispatch("476700510", new Object[]{this})).booleanValue();
    }

    public boolean isShowModule() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1525568963")) {
            return this.isShowModule;
        }
        return ((Boolean) ipChange.ipc$dispatch("1525568963", new Object[]{this})).booleanValue();
    }

    public void setEnabledPublish(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007943564")) {
            ipChange.ipc$dispatch("1007943564", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isEnabledPublish = z;
    }

    public void setShowModule(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730624313")) {
            ipChange.ipc$dispatch("-730624313", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowModule = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705145675")) {
            ipChange.ipc$dispatch("1705145675", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.isEnabledPublish ? (byte) 1 : 0);
        parcel.writeByte(this.isShowModule ? (byte) 1 : 0);
    }

    protected RepertoireDetailCommentConfigureBean(Parcel parcel) {
        boolean z = true;
        this.isEnabledPublish = parcel.readByte() != 0;
        this.isShowModule = parcel.readByte() == 0 ? false : z;
    }
}
