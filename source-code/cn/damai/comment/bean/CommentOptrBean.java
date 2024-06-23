package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentOptrBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentOptrBean> CREATOR = new Parcelable.Creator<CommentOptrBean>() {
        /* class cn.damai.comment.bean.CommentOptrBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentOptrBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "455549007")) {
                return new CommentOptrBean(parcel);
            }
            return (CommentOptrBean) ipChange.ipc$dispatch("455549007", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentOptrBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1059086768")) {
                return new CommentOptrBean[i];
            }
            return (CommentOptrBean[]) ipChange.ipc$dispatch("-1059086768", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public long errorLevel;
    public String model;

    public CommentOptrBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "137922693")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("137922693", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339687142")) {
            ipChange.ipc$dispatch("339687142", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.errorLevel);
        parcel.writeString(this.model);
    }

    protected CommentOptrBean(Parcel parcel) {
        this.errorLevel = parcel.readLong();
        this.model = parcel.readString();
    }
}
