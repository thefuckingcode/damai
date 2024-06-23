package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentContentLabelBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COMMON_TYPE_ALL = 0;
    public static final int COMMON_TYPE_COMMENT = 99;
    public static final Parcelable.Creator<CommentContentLabelBean> CREATOR = new Parcelable.Creator<CommentContentLabelBean>() {
        /* class cn.damai.comment.bean.CommentContentLabelBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentContentLabelBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1826355095")) {
                return new CommentContentLabelBean(parcel);
            }
            return (CommentContentLabelBean) ipChange.ipc$dispatch("1826355095", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentContentLabelBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "140732112")) {
                return new CommentContentLabelBean[i];
            }
            return (CommentContentLabelBean[]) ipChange.ipc$dispatch("140732112", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private long count;
    private String labelId;
    private String labelName;
    private String labelType;
    private int pos;
    private String status;

    public CommentContentLabelBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1189309343")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1189309343", new Object[]{this})).intValue();
    }

    public long getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "831243662")) {
            return this.count;
        }
        return ((Long) ipChange.ipc$dispatch("831243662", new Object[]{this})).longValue();
    }

    public String getLabelId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1151092070")) {
            return this.labelId;
        }
        return (String) ipChange.ipc$dispatch("1151092070", new Object[]{this});
    }

    public String getLabelName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1831200042")) {
            return this.labelName;
        }
        return (String) ipChange.ipc$dispatch("-1831200042", new Object[]{this});
    }

    public String getLabelType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "52101637")) {
            return this.labelType;
        }
        return (String) ipChange.ipc$dispatch("52101637", new Object[]{this});
    }

    public int getPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "743864104")) {
            return this.pos;
        }
        return ((Integer) ipChange.ipc$dispatch("743864104", new Object[]{this})).intValue();
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "353435985")) {
            return this.status;
        }
        return (String) ipChange.ipc$dispatch("353435985", new Object[]{this});
    }

    public boolean isStatusChoose() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1711434052")) {
            return "1".equals(getStatus());
        }
        return ((Boolean) ipChange.ipc$dispatch("1711434052", new Object[]{this})).booleanValue();
    }

    public void setCount(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1547773150")) {
            ipChange.ipc$dispatch("1547773150", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.count = j;
    }

    public void setLabelId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-292137776")) {
            ipChange.ipc$dispatch("-292137776", new Object[]{this, str});
            return;
        }
        this.labelId = str;
    }

    public void setLabelName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397135968")) {
            ipChange.ipc$dispatch("1397135968", new Object[]{this, str});
            return;
        }
        this.labelName = str;
    }

    public void setLabelType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350054127")) {
            ipChange.ipc$dispatch("-350054127", new Object[]{this, str});
            return;
        }
        this.labelType = str;
    }

    public void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773181470")) {
            ipChange.ipc$dispatch("-773181470", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pos = i;
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971488941")) {
            ipChange.ipc$dispatch("971488941", new Object[]{this, str});
            return;
        }
        this.status = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101654902")) {
            ipChange.ipc$dispatch("-101654902", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.labelName);
        parcel.writeString(this.labelType);
        parcel.writeString(this.status);
        parcel.writeInt(this.pos);
    }

    protected CommentContentLabelBean(Parcel parcel) {
        this.labelName = parcel.readString();
        this.labelType = parcel.readString();
        this.status = parcel.readString();
        this.pos = parcel.readInt();
    }
}
