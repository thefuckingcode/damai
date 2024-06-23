package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MessageGroupResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageGroupResponse> CREATOR = new Parcelable.Creator<MessageGroupResponse>() {
        /* class cn.damai.message.bean.MessageGroupResponse.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public MessageGroupResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1231204309")) {
                return new MessageGroupResponse(parcel);
            }
            return (MessageGroupResponse) ipChange.ipc$dispatch("-1231204309", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public MessageGroupResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1077912644")) {
                return new MessageGroupResponse[i];
            }
            return (MessageGroupResponse[]) ipChange.ipc$dispatch("1077912644", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private MessageModel model;

    public MessageGroupResponse() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "662286360")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("662286360", new Object[]{this})).intValue();
    }

    public MessageModel getModel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1525530288")) {
            return this.model;
        }
        return (MessageModel) ipChange.ipc$dispatch("1525530288", new Object[]{this});
    }

    public void setModel(MessageModel messageModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746464844")) {
            ipChange.ipc$dispatch("-1746464844", new Object[]{this, messageModel});
            return;
        }
        this.model = messageModel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482016691")) {
            ipChange.ipc$dispatch("1482016691", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.model, i);
    }

    protected MessageGroupResponse(Parcel parcel) {
        this.model = (MessageModel) parcel.readParcelable(MessageModel.class.getClassLoader());
    }
}
