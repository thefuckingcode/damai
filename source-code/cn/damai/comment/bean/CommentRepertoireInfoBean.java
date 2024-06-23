package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentRepertoireInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentRepertoireInfoBean> CREATOR = new Parcelable.Creator<CommentRepertoireInfoBean>() {
        /* class cn.damai.comment.bean.CommentRepertoireInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentRepertoireInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1452219517")) {
                return new CommentRepertoireInfoBean(parcel);
            }
            return (CommentRepertoireInfoBean) ipChange.ipc$dispatch("-1452219517", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentRepertoireInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "146176464")) {
                return new CommentRepertoireInfoBean[i];
            }
            return (CommentRepertoireInfoBean[]) ipChange.ipc$dispatch("146176464", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String artsDesc;
    private String repertoireId;
    private String repertoireName;
    private String repertoirePic;

    public CommentRepertoireInfoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1870452821")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1870452821", new Object[]{this})).intValue();
    }

    public String getArtsDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "690516042")) {
            return this.artsDesc;
        }
        return (String) ipChange.ipc$dispatch("690516042", new Object[]{this});
    }

    public String getRepertoireId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "935919963")) {
            return this.repertoireId;
        }
        return (String) ipChange.ipc$dispatch("935919963", new Object[]{this});
    }

    public String getRepertoireName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1841802635")) {
            return this.repertoireName;
        }
        return (String) ipChange.ipc$dispatch("1841802635", new Object[]{this});
    }

    public String getRepertoirePic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1238246656")) {
            return this.repertoirePic;
        }
        return (String) ipChange.ipc$dispatch("-1238246656", new Object[]{this});
    }

    public void setArtsDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48832980")) {
            ipChange.ipc$dispatch("48832980", new Object[]{this, str});
            return;
        }
        this.artsDesc = str;
    }

    public void setRepertoireId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653371165")) {
            ipChange.ipc$dispatch("-653371165", new Object[]{this, str});
            return;
        }
        this.repertoireId = str;
    }

    public void setRepertoireName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144200115")) {
            ipChange.ipc$dispatch("2144200115", new Object[]{this, str});
            return;
        }
        this.repertoireName = str;
    }

    public void setRepertoirePic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599604362")) {
            ipChange.ipc$dispatch("-1599604362", new Object[]{this, str});
            return;
        }
        this.repertoirePic = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303508864")) {
            ipChange.ipc$dispatch("-1303508864", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.repertoireId);
        parcel.writeString(this.repertoireName);
        parcel.writeString(this.repertoirePic);
        parcel.writeString(this.artsDesc);
    }

    protected CommentRepertoireInfoBean(Parcel parcel) {
        this.repertoireId = parcel.readString();
        this.repertoireName = parcel.readString();
        this.repertoirePic = parcel.readString();
        this.artsDesc = parcel.readString();
    }
}
