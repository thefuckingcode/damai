package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentImageInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentImageInfoBean> CREATOR = new Parcelable.Creator<CommentImageInfoBean>() {
        /* class cn.damai.comment.bean.CommentImageInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentImageInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "650928779")) {
                return new CommentImageInfoBean(parcel);
            }
            return (CommentImageInfoBean) ipChange.ipc$dispatch("650928779", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentImageInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-288105518")) {
                return new CommentImageInfoBean[i];
            }
            return (CommentImageInfoBean[]) ipChange.ipc$dispatch("-288105518", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public int type;
    public String url;

    public CommentImageInfoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1745100913")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1745100913", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649131130")) {
            ipChange.ipc$dispatch("649131130", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
    }

    protected CommentImageInfoBean(Parcel parcel) {
        this.type = parcel.readInt();
        this.url = parcel.readString();
    }
}
