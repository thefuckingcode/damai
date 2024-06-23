package cn.damai.commonbusiness.seatbiz.sku.wolf.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class Perform implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<Perform> CREATOR = new Parcelable.Creator<Perform>() {
        /* class cn.damai.commonbusiness.seatbiz.sku.wolf.bean.Perform.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public Perform createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1400910275")) {
                return new Perform(parcel);
            }
            return (Perform) ipChange.ipc$dispatch("-1400910275", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public Perform[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1403518064")) {
                return new Perform[i];
            }
            return (Perform[]) ipChange.ipc$dispatch("1403518064", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private int buyNuwSum;
    private String desc;
    private boolean isSelected;
    private long performDate;
    private long performId;
    private String performName;
    private String performTime;
    private int pos;
    private boolean prePayFlag;
    private List<PerformPrice> priceList;
    private boolean seatPickFlag;
    private int seatPickSum;

    public Perform() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "516568558")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("516568558", new Object[]{this})).intValue();
    }

    public int getBuyNuwSum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-653506392")) {
            return this.buyNuwSum;
        }
        return ((Integer) ipChange.ipc$dispatch("-653506392", new Object[]{this})).intValue();
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1537180669")) {
            return this.desc;
        }
        return (String) ipChange.ipc$dispatch("1537180669", new Object[]{this});
    }

    public long getPerformDate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1238326853")) {
            return this.performDate;
        }
        return ((Long) ipChange.ipc$dispatch("-1238326853", new Object[]{this})).longValue();
    }

    public long getPerformId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-519560914")) {
            return this.performId;
        }
        return ((Long) ipChange.ipc$dispatch("-519560914", new Object[]{this})).longValue();
    }

    public String getPerformName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1879946262")) {
            return this.performName;
        }
        return (String) ipChange.ipc$dispatch("1879946262", new Object[]{this});
    }

    public String getPerformTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1448880296")) {
            return this.performTime;
        }
        return (String) ipChange.ipc$dispatch("-1448880296", new Object[]{this});
    }

    public int getPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "761869557")) {
            return this.pos;
        }
        return ((Integer) ipChange.ipc$dispatch("761869557", new Object[]{this})).intValue();
    }

    public List<PerformPrice> getPriceList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1618701880")) {
            return this.priceList;
        }
        return (List) ipChange.ipc$dispatch("1618701880", new Object[]{this});
    }

    public int getSeatPickSum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "447240196")) {
            return this.seatPickSum;
        }
        return ((Integer) ipChange.ipc$dispatch("447240196", new Object[]{this})).intValue();
    }

    public boolean isPrePayFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "164372969")) {
            return this.prePayFlag;
        }
        return ((Boolean) ipChange.ipc$dispatch("164372969", new Object[]{this})).booleanValue();
    }

    public boolean isSeatPickFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1797298632")) {
            return this.seatPickFlag;
        }
        return ((Boolean) ipChange.ipc$dispatch("1797298632", new Object[]{this})).booleanValue();
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1541798049")) {
            return this.isSelected;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1541798049", new Object[]{this})).booleanValue();
    }

    public void setBuyNuwSum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615274654")) {
            ipChange.ipc$dispatch("-615274654", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.buyNuwSum = i;
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115203713")) {
            ipChange.ipc$dispatch("115203713", new Object[]{this, str});
            return;
        }
        this.desc = str;
    }

    public void setPerformDate(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186637649")) {
            ipChange.ipc$dispatch("1186637649", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.performDate = j;
    }

    public void setPerformId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757931202")) {
            ipChange.ipc$dispatch("-757931202", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.performId = j;
    }

    public void setPerformName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "143808032")) {
            ipChange.ipc$dispatch("143808032", new Object[]{this, str});
            return;
        }
        this.performName = str;
    }

    public void setPerformTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29399838")) {
            ipChange.ipc$dispatch("29399838", new Object[]{this, str});
            return;
        }
        this.performTime = str;
    }

    public void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215012427")) {
            ipChange.ipc$dispatch("-215012427", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pos = i;
    }

    public void setPrePayFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932152579")) {
            ipChange.ipc$dispatch("-1932152579", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.prePayFlag = z;
    }

    public void setPriceList(List<PerformPrice> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070556116")) {
            ipChange.ipc$dispatch("-2070556116", new Object[]{this, list});
            return;
        }
        this.priceList = list;
    }

    public void setSeatPickFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107305602")) {
            ipChange.ipc$dispatch("-2107305602", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.seatPickFlag = z;
    }

    public void setSeatPickSum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899607686")) {
            ipChange.ipc$dispatch("1899607686", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.seatPickSum = i;
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600290247")) {
            ipChange.ipc$dispatch("1600290247", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124971165")) {
            ipChange.ipc$dispatch("124971165", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.buyNuwSum);
        parcel.writeLong(this.performDate);
        parcel.writeLong(this.performId);
        parcel.writeString(this.performName);
        parcel.writeString(this.performTime);
        parcel.writeByte(this.prePayFlag ? (byte) 1 : 0);
        parcel.writeByte(this.seatPickFlag ? (byte) 1 : 0);
        parcel.writeInt(this.seatPickSum);
        parcel.writeTypedList(this.priceList);
        parcel.writeByte(this.isSelected ? (byte) 1 : 0);
        parcel.writeString(this.desc);
    }

    protected Perform(Parcel parcel) {
        this.buyNuwSum = parcel.readInt();
        this.performDate = parcel.readLong();
        this.performId = parcel.readLong();
        this.performName = parcel.readString();
        this.performTime = parcel.readString();
        boolean z = true;
        this.prePayFlag = parcel.readByte() != 0;
        this.seatPickFlag = parcel.readByte() != 0;
        this.seatPickSum = parcel.readInt();
        this.priceList = parcel.createTypedArrayList(PerformPrice.CREATOR);
        this.isSelected = parcel.readByte() == 0 ? false : z;
        this.desc = parcel.readString();
    }
}
