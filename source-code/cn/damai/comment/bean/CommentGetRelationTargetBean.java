package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentGetRelationTargetBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentGetRelationTargetBean> CREATOR = new Parcelable.Creator<CommentGetRelationTargetBean>() {
        /* class cn.damai.comment.bean.CommentGetRelationTargetBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentGetRelationTargetBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "399816267")) {
                return new CommentGetRelationTargetBean(parcel);
            }
            return (CommentGetRelationTargetBean) ipChange.ipc$dispatch("399816267", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentGetRelationTargetBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1686461534")) {
                return new CommentGetRelationTargetBean[i];
            }
            return (CommentGetRelationTargetBean[]) ipChange.ipc$dispatch("1686461534", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String resultStr;

    public CommentGetRelationTargetBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-124901909")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-124901909", new Object[]{this})).intValue();
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-615587066")) {
            return this.resultStr;
        }
        return (String) ipChange.ipc$dispatch("-615587066", new Object[]{this});
    }

    public void setResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996545432")) {
            ipChange.ipc$dispatch("996545432", new Object[]{this, str});
            return;
        }
        this.resultStr = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39277120")) {
            ipChange.ipc$dispatch("39277120", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.resultStr);
    }

    protected CommentGetRelationTargetBean(Parcel parcel) {
        this.resultStr = parcel.readString();
    }
}
