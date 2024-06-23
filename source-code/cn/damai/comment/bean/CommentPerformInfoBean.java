package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentPerformInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentPerformInfoBean> CREATOR = new Parcelable.Creator<CommentPerformInfoBean>() {
        /* class cn.damai.comment.bean.CommentPerformInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentPerformInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-801831221")) {
                return new CommentPerformInfoBean(parcel);
            }
            return (CommentPerformInfoBean) ipChange.ipc$dispatch("-801831221", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentPerformInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2086534138")) {
                return new CommentPerformInfoBean[i];
            }
            return (CommentPerformInfoBean[]) ipChange.ipc$dispatch("-2086534138", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String performId;
    private String performValidTime;

    public CommentPerformInfoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1152035767")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1152035767", new Object[]{this})).intValue();
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "181282685")) {
            return this.performId;
        }
        return (String) ipChange.ipc$dispatch("181282685", new Object[]{this});
    }

    public String getPerformValidTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1155309507")) {
            return this.performValidTime;
        }
        return (String) ipChange.ipc$dispatch("-1155309507", new Object[]{this});
    }

    public void setPerformId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640408935")) {
            ipChange.ipc$dispatch("-640408935", new Object[]{this, str});
            return;
        }
        this.performId = str;
    }

    public void setPerformValidTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1668316225")) {
            ipChange.ipc$dispatch("1668316225", new Object[]{this, str});
            return;
        }
        this.performValidTime = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618320884")) {
            ipChange.ipc$dispatch("1618320884", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.performId);
        parcel.writeString(this.performValidTime);
    }

    protected CommentPerformInfoBean(Parcel parcel) {
        this.performId = parcel.readString();
        this.performValidTime = parcel.readString();
    }
}
