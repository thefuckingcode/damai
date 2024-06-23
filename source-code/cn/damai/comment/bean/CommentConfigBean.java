package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentConfigBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentConfigBean> CREATOR = new Parcelable.Creator<CommentConfigBean>() {
        /* class cn.damai.comment.bean.CommentConfigBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentConfigBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1342269321")) {
                return new CommentConfigBean(parcel);
            }
            return (CommentConfigBean) ipChange.ipc$dispatch("1342269321", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentConfigBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-56507344")) {
                return new CommentConfigBean[i];
            }
            return (CommentConfigBean[]) ipChange.ipc$dispatch("-56507344", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String isEnabledPublish;

    public CommentConfigBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1595406888")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1595406888", new Object[]{this})).intValue();
    }

    public String getIsEnabledPublish() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1542671358")) {
            return this.isEnabledPublish;
        }
        return (String) ipChange.ipc$dispatch("1542671358", new Object[]{this});
    }

    public void setIsEnabledPublish(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593622880")) {
            ipChange.ipc$dispatch("-593622880", new Object[]{this, str});
            return;
        }
        this.isEnabledPublish = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83025827")) {
            ipChange.ipc$dispatch("83025827", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.isEnabledPublish);
    }

    protected CommentConfigBean(Parcel parcel) {
        this.isEnabledPublish = parcel.readString();
    }
}
