package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentPraiseInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentPraiseInfoBean> CREATOR = new Parcelable.Creator<CommentPraiseInfoBean>() {
        /* class cn.damai.comment.bean.CommentPraiseInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentPraiseInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-688392967")) {
                return new CommentPraiseInfoBean(parcel);
            }
            return (CommentPraiseInfoBean) ipChange.ipc$dispatch("-688392967", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentPraiseInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-400198608")) {
                return new CommentPraiseInfoBean[i];
            }
            return (CommentPraiseInfoBean[]) ipChange.ipc$dispatch("-400198608", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private boolean hasPraised;
    private String praiseCount;

    public CommentPraiseInfoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "626675120")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("626675120", new Object[]{this})).intValue();
    }

    public String getPraiseCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1220438523")) {
            return this.praiseCount;
        }
        return (String) ipChange.ipc$dispatch("1220438523", new Object[]{this});
    }

    public boolean isHasPraised() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "851587886")) {
            return this.hasPraised;
        }
        return ((Boolean) ipChange.ipc$dispatch("851587886", new Object[]{this})).booleanValue();
    }

    public void setHasPraised(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309271780")) {
            ipChange.ipc$dispatch("-1309271780", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasPraised = z;
    }

    public void setPraiseCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173904603")) {
            ipChange.ipc$dispatch("1173904603", new Object[]{this, str});
            return;
        }
        this.praiseCount = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79760667")) {
            ipChange.ipc$dispatch("79760667", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.hasPraised ? (byte) 1 : 0);
        parcel.writeString(this.praiseCount);
    }

    protected CommentPraiseInfoBean(Parcel parcel) {
        this.hasPraised = parcel.readByte() != 0;
        this.praiseCount = parcel.readString();
    }
}
