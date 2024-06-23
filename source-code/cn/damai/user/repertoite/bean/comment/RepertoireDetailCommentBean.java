package cn.damai.user.repertoite.bean.comment;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.comment.bean.CommentsItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class RepertoireDetailCommentBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RepertoireDetailCommentBean> CREATOR = new Parcelable.Creator<RepertoireDetailCommentBean>() {
        /* class cn.damai.user.repertoite.bean.comment.RepertoireDetailCommentBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RepertoireDetailCommentBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-579267663")) {
                return new RepertoireDetailCommentBean(parcel);
            }
            return (RepertoireDetailCommentBean) ipChange.ipc$dispatch("-579267663", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RepertoireDetailCommentBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-456383440")) {
                return new RepertoireDetailCommentBean[i];
            }
            return (RepertoireDetailCommentBean[]) ipChange.ipc$dispatch("-456383440", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private RepertoireDetailCommentConfigureBean config;
    private List<CommentsItemBean> hotComments;
    private List<CommentsItemBean> moduleComments;
    private String total;
    private List<CommentsItemBean> userComments;

    public RepertoireDetailCommentBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1415789876")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1415789876", new Object[]{this})).intValue();
    }

    public RepertoireDetailCommentConfigureBean getConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1046572324")) {
            return this.config;
        }
        return (RepertoireDetailCommentConfigureBean) ipChange.ipc$dispatch("-1046572324", new Object[]{this});
    }

    public List<CommentsItemBean> getHotComments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1431568972")) {
            return this.hotComments;
        }
        return (List) ipChange.ipc$dispatch("1431568972", new Object[]{this});
    }

    public List<CommentsItemBean> getModuleComments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-89502951")) {
            return this.moduleComments;
        }
        return (List) ipChange.ipc$dispatch("-89502951", new Object[]{this});
    }

    public String getTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "58902664")) {
            return this.total;
        }
        return (String) ipChange.ipc$dispatch("58902664", new Object[]{this});
    }

    public List<CommentsItemBean> getUserComments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-594709128")) {
            return this.userComments;
        }
        return (List) ipChange.ipc$dispatch("-594709128", new Object[]{this});
    }

    public void setConfig(RepertoireDetailCommentConfigureBean repertoireDetailCommentConfigureBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371999378")) {
            ipChange.ipc$dispatch("1371999378", new Object[]{this, repertoireDetailCommentConfigureBean});
            return;
        }
        this.config = repertoireDetailCommentConfigureBean;
    }

    public void setHotComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369307032")) {
            ipChange.ipc$dispatch("369307032", new Object[]{this, list});
            return;
        }
        this.hotComments = list;
    }

    public void setModuleComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471163693")) {
            ipChange.ipc$dispatch("-1471163693", new Object[]{this, list});
            return;
        }
        this.moduleComments = list;
    }

    public void setTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "22382830")) {
            ipChange.ipc$dispatch("22382830", new Object[]{this, str});
            return;
        }
        this.total = str;
    }

    public void setUserComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834516820")) {
            ipChange.ipc$dispatch("1834516820", new Object[]{this, list});
            return;
        }
        this.userComments = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410110999")) {
            ipChange.ipc$dispatch("1410110999", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.config, i);
        parcel.writeTypedList(this.userComments);
        parcel.writeTypedList(this.moduleComments);
        parcel.writeTypedList(this.hotComments);
        parcel.writeString(this.total);
    }

    protected RepertoireDetailCommentBean(Parcel parcel) {
        this.config = (RepertoireDetailCommentConfigureBean) parcel.readParcelable(RepertoireDetailCommentConfigureBean.class.getClassLoader());
        Parcelable.Creator<CommentsItemBean> creator = CommentsItemBean.CREATOR;
        this.userComments = parcel.createTypedArrayList(creator);
        this.moduleComments = parcel.createTypedArrayList(creator);
        this.hotComments = parcel.createTypedArrayList(creator);
        this.total = parcel.readString();
    }
}
