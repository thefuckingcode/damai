package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DynamicExtData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DynamicExtData> CREATOR = new Parcelable.Creator<DynamicExtData>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.DynamicExtData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DynamicExtData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "792289995")) {
                return new DynamicExtData(parcel);
            }
            return (DynamicExtData) ipChange.ipc$dispatch("792289995", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DynamicExtData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "50419782")) {
                return new DynamicExtData[i];
            }
            return (DynamicExtData[]) ipChange.ipc$dispatch("50419782", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String subFlag;

    public DynamicExtData() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1719027543")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1719027543", new Object[]{this})).intValue();
    }

    public String getSubFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-743816499")) {
            return this.subFlag;
        }
        return (String) ipChange.ipc$dispatch("-743816499", new Object[]{this});
    }

    public void setSubFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1095238729")) {
            ipChange.ipc$dispatch("1095238729", new Object[]{this, str});
            return;
        }
        this.subFlag = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585058732")) {
            ipChange.ipc$dispatch("-585058732", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.subFlag);
    }

    protected DynamicExtData(Parcel parcel) {
        this.subFlag = parcel.readString();
    }
}
