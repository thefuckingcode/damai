package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class CommentGradeBean implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentGradeBean> CREATOR = new Parcelable.Creator<CommentGradeBean>() {
        /* class cn.damai.comment.bean.CommentGradeBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentGradeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1134674485")) {
                return new CommentGradeBean(parcel);
            }
            return (CommentGradeBean) ipChange.ipc$dispatch("-1134674485", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentGradeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2068562038")) {
                return new CommentGradeBean[i];
            }
            return (CommentGradeBean[]) ipChange.ipc$dispatch("2068562038", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String desc;
    public long gradeId;
    public long type;
    public String value;
    public String valueDesc;

    public CommentGradeBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-900809057")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-900809057", new Object[]{this})).intValue();
    }

    public long getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "883095005")) {
            return this.type;
        }
        return ((Long) ipChange.ipc$dispatch("883095005", new Object[]{this})).longValue();
    }

    public int getValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873617961")) {
            return ((Integer) ipChange.ipc$dispatch("873617961", new Object[]{this})).intValue();
        } else if (TextUtils.isEmpty(this.value)) {
            return 0;
        } else {
            try {
                return Integer.parseInt(this.value);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    public String getValueDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1390867931")) {
            return this.valueDesc;
        }
        return (String) ipChange.ipc$dispatch("1390867931", new Object[]{this});
    }

    public void setType(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517592327")) {
            ipChange.ipc$dispatch("1517592327", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.type = j;
    }

    public void setValueDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797971973")) {
            ipChange.ipc$dispatch("-1797971973", new Object[]{this, str});
            return;
        }
        this.valueDesc = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116948468")) {
            ipChange.ipc$dispatch("-1116948468", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.gradeId);
        parcel.writeLong(this.type);
        parcel.writeString(this.value);
        parcel.writeString(this.valueDesc);
        parcel.writeString(this.desc);
    }

    protected CommentGradeBean(Parcel parcel) {
        this.gradeId = parcel.readLong();
        this.type = parcel.readLong();
        this.value = parcel.readString();
        this.valueDesc = parcel.readString();
        this.desc = parcel.readString();
    }
}
