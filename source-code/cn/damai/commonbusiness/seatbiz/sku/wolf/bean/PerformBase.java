package cn.damai.commonbusiness.seatbiz.sku.wolf.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class PerformBase implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<PerformBase> CREATOR = new Parcelable.Creator<PerformBase>() {
        /* class cn.damai.commonbusiness.seatbiz.sku.wolf.bean.PerformBase.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PerformBase createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1505268635")) {
                return new PerformBase(parcel);
            }
            return (PerformBase) ipChange.ipc$dispatch("1505268635", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PerformBase[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1867836176")) {
                return new PerformBase[i];
            }
            return (PerformBase[]) ipChange.ipc$dispatch("1867836176", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public static final int PERFORM_STATUS_NORMAL = 1;
    public static final int PERFORM_STATUS_OTHER = 0;
    public static final int PERFORM_STATUS_PERIOD = 4;
    public static final int PERFORM_STATUS_SUPER_TICKET = 5;
    public static final int PERFORM_STATUS_THROUGH_TICKET = 2;
    public static final int PERFORM_STATUS_TIME_SLOT = 6;
    public static final int PERFORM_STATUS_YEAR = 3;
    private boolean isSelected;
    private String name;
    private List<Perform> performs;
    private int pos;
    private long time;
    private long timeSpan;
    private int type;

    public PerformBase() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "156267167")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("156267167", new Object[]{this})).intValue();
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1898759512")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1898759512", new Object[]{this});
    }

    public List<Perform> getPerforms() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1381781558")) {
            return this.performs;
        }
        return (List) ipChange.ipc$dispatch("1381781558", new Object[]{this});
    }

    public int getPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2040621798")) {
            return this.pos;
        }
        return ((Integer) ipChange.ipc$dispatch("2040621798", new Object[]{this})).intValue();
    }

    public long getTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2085686934")) {
            return this.time;
        }
        return ((Long) ipChange.ipc$dispatch("-2085686934", new Object[]{this})).longValue();
    }

    public long getTimeSpan() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1544622784")) {
            return this.timeSpan;
        }
        return ((Long) ipChange.ipc$dispatch("-1544622784", new Object[]{this})).longValue();
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1624849956")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-1624849956", new Object[]{this})).intValue();
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "208919760")) {
            return this.isSelected;
        }
        return ((Boolean) ipChange.ipc$dispatch("208919760", new Object[]{this})).booleanValue();
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "975240502")) {
            ipChange.ipc$dispatch("975240502", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setPerforms(List<Perform> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-603989930")) {
            ipChange.ipc$dispatch("-603989930", new Object[]{this, list});
            return;
        }
        this.performs = list;
    }

    public void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771601380")) {
            ipChange.ipc$dispatch("771601380", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pos = i;
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "412924664")) {
            ipChange.ipc$dispatch("412924664", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
    }

    public void setTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320334566")) {
            ipChange.ipc$dispatch("-320334566", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.time = j;
    }

    public void setTimeSpan(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272117252")) {
            ipChange.ipc$dispatch("272117252", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.timeSpan = j;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080708934")) {
            ipChange.ipc$dispatch("1080708934", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745962484")) {
            ipChange.ipc$dispatch("-745962484", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeTypedList(this.performs);
        parcel.writeLong(this.time);
        parcel.writeInt(this.type);
        parcel.writeLong(this.timeSpan);
        parcel.writeByte(this.isSelected ? (byte) 1 : 0);
    }

    protected PerformBase(Parcel parcel) {
        this.name = parcel.readString();
        this.performs = parcel.createTypedArrayList(Perform.CREATOR);
        this.time = parcel.readLong();
        this.type = parcel.readInt();
        this.timeSpan = parcel.readLong();
        this.isSelected = parcel.readByte() != 0;
    }
}
