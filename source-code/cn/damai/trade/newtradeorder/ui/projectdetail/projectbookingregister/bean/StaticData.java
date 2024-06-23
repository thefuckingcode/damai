package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StaticData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<StaticData> CREATOR = new Parcelable.Creator<StaticData>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public StaticData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-213128117")) {
                return new StaticData(parcel);
            }
            return (StaticData) ipChange.ipc$dispatch("-213128117", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public StaticData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-812275794")) {
                return new StaticData[i];
            }
            return (StaticData[]) ipChange.ipc$dispatch("-812275794", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private ItemBase itemBase;
    private ItemExtendInfo itemExtendInfo;
    private VenueBean venue;

    /* compiled from: Taobao */
    public static class ItemBase implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ItemBase> CREATOR = new Parcelable.Creator<ItemBase>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData.ItemBase.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public ItemBase createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1831639117")) {
                    return new ItemBase(parcel);
                }
                return (ItemBase) ipChange.ipc$dispatch("-1831639117", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public ItemBase[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-195414256")) {
                    return new ItemBase[i];
                }
                return (ItemBase[]) ipChange.ipc$dispatch("-195414256", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private String cityId;
        private String cityName;
        private String itemId;
        private String itemName;
        private ItemPics itemPics;
        private String nationalStandardCityId;
        private String showTime;

        public ItemBase() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1511815187")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("1511815187", new Object[]{this})).intValue();
        }

        public String getCityId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1806692233")) {
                return this.cityId;
            }
            return (String) ipChange.ipc$dispatch("-1806692233", new Object[]{this});
        }

        public String getCityName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-993565273")) {
                return this.cityName;
            }
            return (String) ipChange.ipc$dispatch("-993565273", new Object[]{this});
        }

        public String getItemId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "252757023")) {
                return this.itemId;
            }
            return (String) ipChange.ipc$dispatch("252757023", new Object[]{this});
        }

        public String getItemName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1842753713")) {
                return this.itemName;
            }
            return (String) ipChange.ipc$dispatch("-1842753713", new Object[]{this});
        }

        public ItemPics getItemPics() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-196699450")) {
                return this.itemPics;
            }
            return (ItemPics) ipChange.ipc$dispatch("-196699450", new Object[]{this});
        }

        public String getNationalStandardCityId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1983802778")) {
                return this.nationalStandardCityId;
            }
            return (String) ipChange.ipc$dispatch("-1983802778", new Object[]{this});
        }

        public String getShowTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1065503621")) {
                return this.showTime;
            }
            return (String) ipChange.ipc$dispatch("-1065503621", new Object[]{this});
        }

        public void setCityId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1567976377")) {
                ipChange.ipc$dispatch("-1567976377", new Object[]{this, str});
                return;
            }
            this.cityId = str;
        }

        public void setCityName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-618080233")) {
                ipChange.ipc$dispatch("-618080233", new Object[]{this, str});
                return;
            }
            this.cityName = str;
        }

        public void setItemId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145408415")) {
                ipChange.ipc$dispatch("2145408415", new Object[]{this, str});
                return;
            }
            this.itemId = str;
        }

        public void setItemName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1173118097")) {
                ipChange.ipc$dispatch("-1173118097", new Object[]{this, str});
                return;
            }
            this.itemName = str;
        }

        public void setItemPics(ItemPics itemPics2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-812750998")) {
                ipChange.ipc$dispatch("-812750998", new Object[]{this, itemPics2});
                return;
            }
            this.itemPics = itemPics2;
        }

        public void setNationalStandardCityId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "80472120")) {
                ipChange.ipc$dispatch("80472120", new Object[]{this, str});
                return;
            }
            this.nationalStandardCityId = str;
        }

        public void setShowTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1446798275")) {
                ipChange.ipc$dispatch("1446798275", new Object[]{this, str});
                return;
            }
            this.showTime = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614637800")) {
                ipChange.ipc$dispatch("-1614637800", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.cityId);
            parcel.writeString(this.cityName);
            parcel.writeString(this.itemId);
            parcel.writeString(this.itemName);
            parcel.writeString(this.showTime);
            parcel.writeParcelable(this.itemPics, i);
            parcel.writeString(this.nationalStandardCityId);
        }

        protected ItemBase(Parcel parcel) {
            this.cityId = parcel.readString();
            this.cityName = parcel.readString();
            this.itemId = parcel.readString();
            this.itemName = parcel.readString();
            this.showTime = parcel.readString();
            this.itemPics = (ItemPics) parcel.readParcelable(ItemPics.class.getClassLoader());
            this.nationalStandardCityId = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    public static class ItemExtendInfo implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ItemExtendInfo> CREATOR = new Parcelable.Creator<ItemExtendInfo>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData.ItemExtendInfo.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public ItemExtendInfo createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-2101587195")) {
                    return new ItemExtendInfo(parcel);
                }
                return (ItemExtendInfo) ipChange.ipc$dispatch("-2101587195", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public ItemExtendInfo[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-831802896")) {
                    return new ItemExtendInfo[i];
                }
                return (ItemExtendInfo[]) ipChange.ipc$dispatch("-831802896", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private String itemDescTitle;
        private String itemExtend;

        public ItemExtendInfo() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1341557590")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-1341557590", new Object[]{this})).intValue();
        }

        public String getItemDescTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2100027394")) {
                return this.itemDescTitle;
            }
            return (String) ipChange.ipc$dispatch("2100027394", new Object[]{this});
        }

        public String getItemExtend() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1498686581")) {
                return this.itemExtend;
            }
            return (String) ipChange.ipc$dispatch("1498686581", new Object[]{this});
        }

        public void setItemDescTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1192323916")) {
                ipChange.ipc$dispatch("-1192323916", new Object[]{this, str});
                return;
            }
            this.itemDescTitle = str;
        }

        public void setItemExtend(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1399727625")) {
                ipChange.ipc$dispatch("1399727625", new Object[]{this, str});
                return;
            }
            this.itemExtend = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-335971999")) {
                ipChange.ipc$dispatch("-335971999", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.itemDescTitle);
            parcel.writeString(this.itemExtend);
        }

        protected ItemExtendInfo(Parcel parcel) {
            this.itemDescTitle = parcel.readString();
            this.itemExtend = parcel.readString();
        }
    }

    public StaticData() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1521699997")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1521699997", new Object[]{this})).intValue();
    }

    public ItemBase getItemBase() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1258081604")) {
            return this.itemBase;
        }
        return (ItemBase) ipChange.ipc$dispatch("1258081604", new Object[]{this});
    }

    public ItemExtendInfo getItemExtendInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "920240982")) {
            return this.itemExtendInfo;
        }
        return (ItemExtendInfo) ipChange.ipc$dispatch("920240982", new Object[]{this});
    }

    public VenueBean getVenue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1053626626")) {
            return this.venue;
        }
        return (VenueBean) ipChange.ipc$dispatch("-1053626626", new Object[]{this});
    }

    public void setItemBase(ItemBase itemBase2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5665974")) {
            ipChange.ipc$dispatch("-5665974", new Object[]{this, itemBase2});
            return;
        }
        this.itemBase = itemBase2;
    }

    public void setItemExtendInfo(ItemExtendInfo itemExtendInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817440534")) {
            ipChange.ipc$dispatch("-1817440534", new Object[]{this, itemExtendInfo2});
            return;
        }
        this.itemExtendInfo = itemExtendInfo2;
    }

    public void setVenue(VenueBean venueBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425137590")) {
            ipChange.ipc$dispatch("-1425137590", new Object[]{this, venueBean});
            return;
        }
        this.venue = venueBean;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658924488")) {
            ipChange.ipc$dispatch("658924488", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.itemBase, i);
        parcel.writeParcelable(this.itemExtendInfo, i);
        parcel.writeParcelable(this.venue, i);
    }

    protected StaticData(Parcel parcel) {
        this.itemBase = (ItemBase) parcel.readParcelable(ItemBase.class.getClassLoader());
        this.itemExtendInfo = (ItemExtendInfo) parcel.readParcelable(ItemExtendInfo.class.getClassLoader());
        this.venue = (VenueBean) parcel.readParcelable(VenueBean.class.getClassLoader());
    }
}
