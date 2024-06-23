package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentStatScoreBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentStatScoreBean> CREATOR = new Parcelable.Creator<CommentStatScoreBean>() {
        /* class cn.damai.comment.bean.CommentStatScoreBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentStatScoreBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "815477611")) {
                return new CommentStatScoreBean(parcel);
            }
            return (CommentStatScoreBean) ipChange.ipc$dispatch("815477611", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentStatScoreBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-751815768")) {
                return new CommentStatScoreBean[i];
            }
            return (CommentStatScoreBean[]) ipChange.ipc$dispatch("-751815768", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String scoreDesc;
    private String scoreRatio;
    private String statScore;

    public CommentStatScoreBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-773183450")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-773183450", new Object[]{this})).intValue();
    }

    public String getScoreDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-554886699")) {
            return this.scoreDesc;
        }
        return (String) ipChange.ipc$dispatch("-554886699", new Object[]{this});
    }

    public String getScoreRatio() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1632210563")) {
            return this.scoreRatio;
        }
        return (String) ipChange.ipc$dispatch("-1632210563", new Object[]{this});
    }

    public String getStatScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1870226096")) {
            return this.statScore;
        }
        return (String) ipChange.ipc$dispatch("1870226096", new Object[]{this});
    }

    public void setScoreDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986823359")) {
            ipChange.ipc$dispatch("-1986823359", new Object[]{this, str});
            return;
        }
        this.scoreDesc = str;
    }

    public void setScoreRatio(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168803327")) {
            ipChange.ipc$dispatch("-1168803327", new Object[]{this, str});
            return;
        }
        this.scoreRatio = str;
    }

    public void setStatScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "177229254")) {
            ipChange.ipc$dispatch("177229254", new Object[]{this, str});
            return;
        }
        this.statScore = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35738267")) {
            ipChange.ipc$dispatch("-35738267", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.scoreRatio);
        parcel.writeString(this.scoreDesc);
        parcel.writeString(this.statScore);
    }

    protected CommentStatScoreBean(Parcel parcel) {
        this.scoreRatio = parcel.readString();
        this.scoreDesc = parcel.readString();
        this.statScore = parcel.readString();
    }
}
