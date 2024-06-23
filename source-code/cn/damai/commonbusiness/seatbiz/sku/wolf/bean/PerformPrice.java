package cn.damai.commonbusiness.seatbiz.sku.wolf.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PerformPrice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PerformPrice> CREATOR = new Parcelable.Creator<PerformPrice>() {
        /* class cn.damai.commonbusiness.seatbiz.sku.wolf.bean.PerformPrice.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PerformPrice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1114001291")) {
                return new PerformPrice(parcel);
            }
            return (PerformPrice) ipChange.ipc$dispatch("1114001291", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PerformPrice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1807190178")) {
                return new PerformPrice[i];
            }
            return (PerformPrice[]) ipChange.ipc$dispatch("1807190178", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private int buyNowSum;
    private boolean isSelected;
    private int num = 1;
    private boolean packagesFlag;
    private double price;
    private long priceId;
    private String priceName;
    private int priceStatus;

    public PerformPrice() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2024434697")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2024434697", new Object[]{this})).intValue();
    }

    public int getBuyNowSum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "72529673")) {
            return this.buyNowSum;
        }
        return ((Integer) ipChange.ipc$dispatch("72529673", new Object[]{this})).intValue();
    }

    public int getNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1390517666")) {
            return this.num;
        }
        return ((Integer) ipChange.ipc$dispatch("-1390517666", new Object[]{this})).intValue();
    }

    public double getPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "212189878")) {
            return this.price;
        }
        return ((Double) ipChange.ipc$dispatch("212189878", new Object[]{this})).doubleValue();
    }

    public long getPriceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2083218145")) {
            return this.priceId;
        }
        return ((Long) ipChange.ipc$dispatch("2083218145", new Object[]{this})).longValue();
    }

    public String getPriceName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1369552771")) {
            return this.priceName;
        }
        return (String) ipChange.ipc$dispatch("1369552771", new Object[]{this});
    }

    public int getPriceStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1922935593")) {
            return this.priceStatus;
        }
        return ((Integer) ipChange.ipc$dispatch("1922935593", new Object[]{this})).intValue();
    }

    public boolean isPackagesFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-47533156")) {
            return this.packagesFlag;
        }
        return ((Boolean) ipChange.ipc$dispatch("-47533156", new Object[]{this})).booleanValue();
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1619546694")) {
            return this.isSelected;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1619546694", new Object[]{this})).booleanValue();
    }

    public void setBuyNowSum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417006881")) {
            ipChange.ipc$dispatch("417006881", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.buyNowSum = i;
    }

    public void setNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780460396")) {
            ipChange.ipc$dispatch("1780460396", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.num = i;
    }

    public void setPackagesFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352013760")) {
            ipChange.ipc$dispatch("352013760", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.packagesFlag = z;
    }

    public void setPrice(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463030550")) {
            ipChange.ipc$dispatch("-463030550", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.price = d;
    }

    public void setPriceId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616453334")) {
            ipChange.ipc$dispatch("-1616453334", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.priceId = (long) i;
    }

    public void setPriceName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836225363")) {
            ipChange.ipc$dispatch("1836225363", new Object[]{this, str});
            return;
        }
        this.priceName = str;
    }

    public void setPriceStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401524737")) {
            ipChange.ipc$dispatch("401524737", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.priceStatus = i;
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101713566")) {
            ipChange.ipc$dispatch("-101713566", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715672546")) {
            ipChange.ipc$dispatch("715672546", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.buyNowSum);
        parcel.writeByte(this.packagesFlag ? (byte) 1 : 0);
        parcel.writeDouble(this.price);
        parcel.writeLong(this.priceId);
        parcel.writeString(this.priceName);
        parcel.writeInt(this.priceStatus);
        parcel.writeByte(this.isSelected ? (byte) 1 : 0);
        parcel.writeInt(this.num);
    }

    protected PerformPrice(Parcel parcel) {
        boolean z = true;
        this.buyNowSum = parcel.readInt();
        this.packagesFlag = parcel.readByte() != 0;
        this.price = parcel.readDouble();
        this.priceId = (long) parcel.readInt();
        this.priceName = parcel.readString();
        this.priceStatus = parcel.readInt();
        this.isSelected = parcel.readByte() == 0 ? false : z;
        this.num = parcel.readInt();
    }
}
