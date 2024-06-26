package cn.damai.ultron.view.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DmDeliveryWayBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DmDeliveryWayBean> CREATOR = new Parcelable.Creator<DmDeliveryWayBean>() {
        /* class cn.damai.ultron.view.bean.DmDeliveryWayBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DmDeliveryWayBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-381606359")) {
                return new DmDeliveryWayBean(parcel);
            }
            return (DmDeliveryWayBean) ipChange.ipc$dispatch("-381606359", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DmDeliveryWayBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "666262320")) {
                return new DmDeliveryWayBean[i];
            }
            return (DmDeliveryWayBean[]) ipChange.ipc$dispatch("666262320", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String deliveryType;
    public String desc;
    public boolean selected;
    public String tag;
    public String tip;

    public DmDeliveryWayBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1921588456")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1921588456", new Object[]{this})).intValue();
    }

    public boolean getCheckState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-939812347")) {
            return this.selected;
        }
        return ((Boolean) ipChange.ipc$dispatch("-939812347", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "470086835")) {
            ipChange.ipc$dispatch("470086835", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.deliveryType);
        parcel.writeString(this.desc);
        parcel.writeByte(this.selected ? (byte) 1 : 0);
        parcel.writeString(this.tag);
        parcel.writeString(this.tip);
    }

    protected DmDeliveryWayBean(Parcel parcel) {
        this.deliveryType = parcel.readString();
        this.desc = parcel.readString();
        this.selected = parcel.readByte() != 0;
        this.tag = parcel.readString();
        this.tip = parcel.readString();
    }
}
