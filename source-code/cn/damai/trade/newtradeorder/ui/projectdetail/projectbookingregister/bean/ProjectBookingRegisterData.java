package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectBookingRegisterData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectBookingRegisterData> CREATOR = new Parcelable.Creator<ProjectBookingRegisterData>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectBookingRegisterData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1728918763")) {
                return new ProjectBookingRegisterData(parcel);
            }
            return (ProjectBookingRegisterData) ipChange.ipc$dispatch("1728918763", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectBookingRegisterData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "864157444")) {
                return new ProjectBookingRegisterData[i];
            }
            return (ProjectBookingRegisterData[]) ipChange.ipc$dispatch("864157444", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private DynamicExtData dynamicExtData;
    private ItemData item;
    private StaticData staticData;

    public ProjectBookingRegisterData() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2069105032")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-2069105032", new Object[]{this})).intValue();
    }

    public DynamicExtData getDynamicExtData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1765890131")) {
            return this.dynamicExtData;
        }
        return (DynamicExtData) ipChange.ipc$dispatch("1765890131", new Object[]{this});
    }

    public ItemData getItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1611335255")) {
            return this.item;
        }
        return (ItemData) ipChange.ipc$dispatch("-1611335255", new Object[]{this});
    }

    public StaticData getStaticData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "474047827")) {
            return this.staticData;
        }
        return (StaticData) ipChange.ipc$dispatch("474047827", new Object[]{this});
    }

    public void setDynamicExtData(DynamicExtData dynamicExtData2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605892973")) {
            ipChange.ipc$dispatch("1605892973", new Object[]{this, dynamicExtData2});
            return;
        }
        this.dynamicExtData = dynamicExtData2;
    }

    public void setItem(ItemData itemData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664076843")) {
            ipChange.ipc$dispatch("-664076843", new Object[]{this, itemData});
            return;
        }
        this.item = itemData;
    }

    public void setStaticData(StaticData staticData2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1293288363")) {
            ipChange.ipc$dispatch("-1293288363", new Object[]{this, staticData2});
            return;
        }
        this.staticData = staticData2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609370963")) {
            ipChange.ipc$dispatch("1609370963", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.staticData, i);
        parcel.writeParcelable(this.dynamicExtData, i);
        parcel.writeParcelable(this.item, i);
    }

    protected ProjectBookingRegisterData(Parcel parcel) {
        this.staticData = (StaticData) parcel.readParcelable(StaticData.class.getClassLoader());
        this.dynamicExtData = (DynamicExtData) parcel.readParcelable(DynamicExtData.class.getClassLoader());
        this.item = (ItemData) parcel.readParcelable(ItemData.class.getClassLoader());
    }
}
