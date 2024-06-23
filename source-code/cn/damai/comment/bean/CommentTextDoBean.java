package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentTextDoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentTextDoBean> CREATOR = new Parcelable.Creator<CommentTextDoBean>() {
        /* class cn.damai.comment.bean.CommentTextDoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentTextDoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "69072349")) {
                return new CommentTextDoBean(parcel);
            }
            return (CommentTextDoBean) ipChange.ipc$dispatch("69072349", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentTextDoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1025927312")) {
                return new CommentTextDoBean[i];
            }
            return (CommentTextDoBean[]) ipChange.ipc$dispatch("-1025927312", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String id;
    private String type;
    private String value;

    public CommentTextDoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-559673858")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-559673858", new Object[]{this})).intValue();
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-939357737")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-939357737", new Object[]{this});
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1174531638")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("1174531638", new Object[]{this});
    }

    public String getValue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2011096917")) {
            return this.value;
        }
        return (String) ipChange.ipc$dispatch("-2011096917", new Object[]{this});
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213966617")) {
            ipChange.ipc$dispatch("-213966617", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757985640")) {
            ipChange.ipc$dispatch("1757985640", new Object[]{this, str});
            return;
        }
        this.type = str;
    }

    public void setValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "276905259")) {
            ipChange.ipc$dispatch("276905259", new Object[]{this, str});
            return;
        }
        this.value = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883045005")) {
            ipChange.ipc$dispatch("883045005", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.value);
    }

    protected CommentTextDoBean(Parcel parcel) {
        this.id = parcel.readString();
        this.type = parcel.readString();
        this.value = parcel.readString();
    }
}
