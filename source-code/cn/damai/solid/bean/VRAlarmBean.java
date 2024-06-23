package cn.damai.solid.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class VRAlarmBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<VRAlarmBean> CREATOR = new Parcelable.Creator<VRAlarmBean>() {
        /* class cn.damai.solid.bean.VRAlarmBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public VRAlarmBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "188919673")) {
                return new VRAlarmBean(parcel);
            }
            return (VRAlarmBean) ipChange.ipc$dispatch("188919673", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public VRAlarmBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-379909840")) {
                return new VRAlarmBean[i];
            }
            return (VRAlarmBean[]) ipChange.ipc$dispatch("-379909840", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public static final String VR_ALARM_KEY = "VR_ALARM_KEY";
    public String itemId;
    public String performId;

    public VRAlarmBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "826133936")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("826133936", new Object[]{this})).intValue();
    }

    public Map<String, String> toMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545054308")) {
            return (Map) ipChange.ipc$dispatch("-1545054308", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("itemId", this.itemId);
        hashMap.put(TicketDetailExtFragment.PERFORM_ID, this.performId);
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867332837")) {
            ipChange.ipc$dispatch("-867332837", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.itemId);
        parcel.writeString(this.performId);
    }

    public VRAlarmBean(String str, String str2) {
        this.itemId = str;
        this.performId = str2;
    }

    protected VRAlarmBean(Parcel parcel) {
        this.itemId = parcel.readString();
        this.performId = parcel.readString();
    }
}
