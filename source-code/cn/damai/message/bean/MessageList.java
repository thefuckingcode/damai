package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class MessageList implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageList> CREATOR = new Parcelable.Creator<MessageList>() {
        /* class cn.damai.message.bean.MessageList.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public MessageList createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "963465777")) {
                return new MessageList(parcel);
            }
            return (MessageList) ipChange.ipc$dispatch("963465777", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public MessageList[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1116431408")) {
                return new MessageList[i];
            }
            return (MessageList[]) ipChange.ipc$dispatch("1116431408", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<MessageItem> messageList;

    public MessageList() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1596113932")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1596113932", new Object[]{this})).intValue();
    }

    public List<MessageItem> getMessageList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-546055568")) {
            return this.messageList;
        }
        return (List) ipChange.ipc$dispatch("-546055568", new Object[]{this});
    }

    public void setMessageList(List<MessageItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-807511564")) {
            ipChange.ipc$dispatch("-807511564", new Object[]{this, list});
            return;
        }
        this.messageList = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804079273")) {
            ipChange.ipc$dispatch("-1804079273", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeList(this.messageList);
    }

    protected MessageList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.messageList = arrayList;
        parcel.readList(arrayList, MessageItem.class.getClassLoader());
    }
}
