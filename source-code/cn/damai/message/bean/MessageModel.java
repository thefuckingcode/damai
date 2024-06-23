package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class MessageModel implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageModel> CREATOR = new Parcelable.Creator<MessageModel>() {
        /* class cn.damai.message.bean.MessageModel.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public MessageModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1053884789")) {
                return new MessageModel(parcel);
            }
            return (MessageModel) ipChange.ipc$dispatch("-1053884789", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public MessageModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "473021042")) {
                return new MessageModel[i];
            }
            return (MessageModel[]) ipChange.ipc$dispatch("473021042", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<MessageGroupItem> messageGroupList;
    private MessageNotice notice;

    public MessageModel() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2073546657")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2073546657", new Object[]{this})).intValue();
    }

    public List<MessageGroupItem> getMessageGroupList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1671418884")) {
            return this.messageGroupList;
        }
        return (List) ipChange.ipc$dispatch("-1671418884", new Object[]{this});
    }

    public MessageNotice getNotice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "444439031")) {
            return this.notice;
        }
        return (MessageNotice) ipChange.ipc$dispatch("444439031", new Object[]{this});
    }

    public void setMessageGroupList(List<MessageGroupItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514062160")) {
            ipChange.ipc$dispatch("1514062160", new Object[]{this, list});
            return;
        }
        this.messageGroupList = list;
    }

    public void setNotice(MessageNotice messageNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296239007")) {
            ipChange.ipc$dispatch("-296239007", new Object[]{this, messageNotice});
            return;
        }
        this.notice = messageNotice;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529822902")) {
            ipChange.ipc$dispatch("-529822902", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.messageGroupList);
        parcel.writeParcelable(this.notice, i);
    }

    protected MessageModel(Parcel parcel) {
        this.messageGroupList = parcel.createTypedArrayList(MessageGroupItem.CREATOR);
        this.notice = (MessageNotice) parcel.readParcelable(MessageNotice.class.getClassLoader());
    }
}
