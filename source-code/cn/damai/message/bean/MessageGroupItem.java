package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MessageGroupItem implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageGroupItem> CREATOR = new Parcelable.Creator<MessageGroupItem>() {
        /* class cn.damai.message.bean.MessageGroupItem.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public MessageGroupItem createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "659782251")) {
                return new MessageGroupItem(parcel);
            }
            return (MessageGroupItem) ipChange.ipc$dispatch("659782251", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public MessageGroupItem[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "559582752")) {
                return new MessageGroupItem[i];
            }
            return (MessageGroupItem[]) ipChange.ipc$dispatch("559582752", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private int buType;
    private String gmtCreate;
    private String groupIcon;
    private long groupId;
    private String msgBody;
    private String msgTypeName;
    private String unBadgeReadCount;

    public MessageGroupItem() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1356254570")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1356254570", new Object[]{this})).intValue();
    }

    public int getBuType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-625968610")) {
            return this.buType;
        }
        return ((Integer) ipChange.ipc$dispatch("-625968610", new Object[]{this})).intValue();
    }

    public String getGmtCreate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-619619272")) {
            return this.gmtCreate;
        }
        return (String) ipChange.ipc$dispatch("-619619272", new Object[]{this});
    }

    public String getGroupIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1717674522")) {
            return this.groupIcon;
        }
        return (String) ipChange.ipc$dispatch("-1717674522", new Object[]{this});
    }

    public long getGroupId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1548210804")) {
            return this.groupId;
        }
        return ((Long) ipChange.ipc$dispatch("-1548210804", new Object[]{this})).longValue();
    }

    public String getMsgBody() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-633160623")) {
            return this.msgBody;
        }
        return (String) ipChange.ipc$dispatch("-633160623", new Object[]{this});
    }

    public String getMsgTypeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-560791020")) {
            return this.msgTypeName;
        }
        return (String) ipChange.ipc$dispatch("-560791020", new Object[]{this});
    }

    public int getUnBadgeReadCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269802908")) {
            return ((Integer) ipChange.ipc$dispatch("269802908", new Object[]{this})).intValue();
        } else if (TextUtils.isEmpty(this.unBadgeReadCount)) {
            return 0;
        } else {
            return Integer.parseInt(this.unBadgeReadCount);
        }
    }

    public void setBuType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450996668")) {
            ipChange.ipc$dispatch("-1450996668", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.buType = i;
    }

    public void setGmtCreate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301434174")) {
            ipChange.ipc$dispatch("301434174", new Object[]{this, str});
            return;
        }
        this.gmtCreate = str;
    }

    public void setGroupIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621459792")) {
            ipChange.ipc$dispatch("621459792", new Object[]{this, str});
            return;
        }
        this.groupIcon = str;
    }

    public void setGroupId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773367200")) {
            ipChange.ipc$dispatch("1773367200", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.groupId = j;
    }

    public void setMsgBody(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230603589")) {
            ipChange.ipc$dispatch("230603589", new Object[]{this, str});
            return;
        }
        this.msgBody = str;
    }

    public void setMsgTypeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790363618")) {
            ipChange.ipc$dispatch("1790363618", new Object[]{this, str});
            return;
        }
        this.msgTypeName = str;
    }

    public void setUnBadgeReadCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656316839")) {
            ipChange.ipc$dispatch("656316839", new Object[]{this, str});
            return;
        }
        this.unBadgeReadCount = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235882335")) {
            ipChange.ipc$dispatch("-235882335", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.groupId);
        parcel.writeString(this.msgTypeName);
        parcel.writeString(this.msgBody);
        parcel.writeString(this.groupIcon);
        parcel.writeString(this.gmtCreate);
        parcel.writeString(this.unBadgeReadCount);
        parcel.writeInt(this.buType);
    }

    protected MessageGroupItem(Parcel parcel) {
        this.groupId = parcel.readLong();
        this.msgTypeName = parcel.readString();
        this.msgBody = parcel.readString();
        this.groupIcon = parcel.readString();
        this.gmtCreate = parcel.readString();
        this.unBadgeReadCount = parcel.readString();
        this.buType = parcel.readInt();
    }
}
