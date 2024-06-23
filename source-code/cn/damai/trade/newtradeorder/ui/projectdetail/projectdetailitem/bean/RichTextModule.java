package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RichTextModule implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RichTextModule> CREATOR = new Parcelable.Creator<RichTextModule>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RichTextModule.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RichTextModule createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "941219817")) {
                return new RichTextModule(parcel);
            }
            return (RichTextModule) ipChange.ipc$dispatch("941219817", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RichTextModule[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "994281776")) {
                return new RichTextModule[i];
            }
            return (RichTextModule[]) ipChange.ipc$dispatch("994281776", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String content;
    private String title;

    public RichTextModule() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-688549704")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-688549704", new Object[]{this})).intValue();
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1272515833")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("1272515833", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1841095016")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1841095016", new Object[]{this});
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822968419")) {
            ipChange.ipc$dispatch("-822968419", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251996894")) {
            ipChange.ipc$dispatch("1251996894", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354548461")) {
            ipChange.ipc$dispatch("-1354548461", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeString(this.content);
    }

    protected RichTextModule(Parcel parcel) {
        this.title = parcel.readString();
        this.content = parcel.readString();
    }
}
