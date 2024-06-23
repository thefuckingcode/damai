package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MessageNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageNotice> CREATOR = new Parcelable.Creator<MessageNotice>() {
        /* class cn.damai.message.bean.MessageNotice.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public MessageNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "188815485")) {
                return new MessageNotice(parcel);
            }
            return (MessageNotice) ipChange.ipc$dispatch("188815485", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public MessageNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "921665392")) {
                return new MessageNotice[i];
            }
            return (MessageNotice[]) ipChange.ipc$dispatch("921665392", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String content;
    private String url;

    public MessageNotice() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1919993582")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1919993582", new Object[]{this})).intValue();
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1574500611")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("1574500611", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-700192135")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("-700192135", new Object[]{this});
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-51374893")) {
            ipChange.ipc$dispatch("-51374893", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187428381")) {
            ipChange.ipc$dispatch("1187428381", new Object[]{this, str});
            return;
        }
        this.url = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436579741")) {
            ipChange.ipc$dispatch("1436579741", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.content);
        parcel.writeString(this.url);
    }

    protected MessageNotice(Parcel parcel) {
        this.content = parcel.readString();
        this.url = parcel.readString();
    }
}
