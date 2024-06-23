package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentGradeText implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentGradeText> CREATOR = new Parcelable.Creator<CommentGradeText>() {
        /* class cn.damai.issue.net.CommentGradeText.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentGradeText createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1076940787")) {
                return new CommentGradeText(parcel);
            }
            return (CommentGradeText) ipChange.ipc$dispatch("1076940787", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentGradeText[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "49193552")) {
                return new CommentGradeText[i];
            }
            return (CommentGradeText[]) ipChange.ipc$dispatch("49193552", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String level;
    private String text;

    public CommentGradeText() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-358533005")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-358533005", new Object[]{this})).intValue();
    }

    public String getLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-154524567")) {
            return this.level;
        }
        return (String) ipChange.ipc$dispatch("-154524567", new Object[]{this});
    }

    public String getText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "666898974")) {
            return this.text;
        }
        return (String) ipChange.ipc$dispatch("666898974", new Object[]{this});
    }

    public void setLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1996073261")) {
            ipChange.ipc$dispatch("1996073261", new Object[]{this, str});
            return;
        }
        this.level = str;
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093725056")) {
            ipChange.ipc$dispatch("-1093725056", new Object[]{this, str});
            return;
        }
        this.text = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938827592")) {
            ipChange.ipc$dispatch("-938827592", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.level);
        parcel.writeString(this.text);
    }

    protected CommentGradeText(Parcel parcel) {
        this.level = parcel.readString();
        this.text = parcel.readString();
    }
}
