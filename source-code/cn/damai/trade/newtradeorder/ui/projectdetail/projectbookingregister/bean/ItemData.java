package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ItemData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ItemData> CREATOR = new Parcelable.Creator<ItemData>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ItemData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ItemData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1921897173")) {
                return new ItemData(parcel);
            }
            return (ItemData) ipChange.ipc$dispatch("-1921897173", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ItemData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "628657380")) {
                return new ItemData[i];
            }
            return (ItemData[]) ipChange.ipc$dispatch("628657380", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String buyBtnStatus;
    private String buyBtnText;

    public ItemData() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "508149960")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("508149960", new Object[]{this})).intValue();
    }

    public String getBuyBtnStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-889985202")) {
            return this.buyBtnStatus;
        }
        return (String) ipChange.ipc$dispatch("-889985202", new Object[]{this});
    }

    public String getBuyBtnText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1900158647")) {
            return this.buyBtnText;
        }
        return (String) ipChange.ipc$dispatch("-1900158647", new Object[]{this});
    }

    public void setBuyBtnStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421856432")) {
            ipChange.ipc$dispatch("-1421856432", new Object[]{this, str});
            return;
        }
        this.buyBtnStatus = str;
    }

    public void setBuyBtnText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885259339")) {
            ipChange.ipc$dispatch("-885259339", new Object[]{this, str});
            return;
        }
        this.buyBtnText = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502476035")) {
            ipChange.ipc$dispatch("502476035", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.buyBtnText);
        parcel.writeString(this.buyBtnStatus);
    }

    protected ItemData(Parcel parcel) {
        this.buyBtnText = parcel.readString();
        this.buyBtnStatus = parcel.readString();
    }
}
