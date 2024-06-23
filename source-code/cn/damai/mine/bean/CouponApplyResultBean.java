package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class CouponApplyResultBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private CouponApplyDataBean data;

    /* compiled from: Taobao */
    public static class CouponAppliedBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<CouponAppliedBean> CREATOR = new Parcelable.Creator<CouponAppliedBean>() {
            /* class cn.damai.mine.bean.CouponApplyResultBean.CouponAppliedBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public CouponAppliedBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-582524149")) {
                    return new CouponAppliedBean(parcel);
                }
                return (CouponAppliedBean) ipChange.ipc$dispatch("-582524149", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public CouponAppliedBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "179140986")) {
                    return new CouponAppliedBean[i];
                }
                return (CouponAppliedBean[]) ipChange.ipc$dispatch("179140986", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private String createTime;
        private String decreaseMoneyNum;
        private String decreaseMoneyTag;
        private String effectiveEndTime;
        private String effectiveStartTime;
        private String effectiveTimeText;
        private String id;
        private String name;
        private String status;
        private String umpCouponTplId;
        private String umpCouponTplSpreadId;
        private String useCouponUrlH5;
        private String useCouponUrlMobile;

        public CouponAppliedBean() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1718501859")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-1718501859", new Object[]{this})).intValue();
        }

        public String getCreateTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1824972668")) {
                return this.createTime;
            }
            return (String) ipChange.ipc$dispatch("-1824972668", new Object[]{this});
        }

        public String getDecreaseMoneyNum() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1871898497")) {
                return this.decreaseMoneyNum;
            }
            return (String) ipChange.ipc$dispatch("-1871898497", new Object[]{this});
        }

        public String getDecreaseMoneyTag() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2140035731")) {
                return this.decreaseMoneyTag;
            }
            return (String) ipChange.ipc$dispatch("2140035731", new Object[]{this});
        }

        public String getEffectiveEndTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1770868028")) {
                return this.effectiveEndTime;
            }
            return (String) ipChange.ipc$dispatch("1770868028", new Object[]{this});
        }

        public String getEffectiveStartTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-542016125")) {
                return this.effectiveStartTime;
            }
            return (String) ipChange.ipc$dispatch("-542016125", new Object[]{this});
        }

        public String getEffectiveTimeText() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1091961252")) {
                return this.effectiveTimeText;
            }
            return (String) ipChange.ipc$dispatch("-1091961252", new Object[]{this});
        }

        public String getId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1915918666")) {
                return this.id;
            }
            return (String) ipChange.ipc$dispatch("-1915918666", new Object[]{this});
        }

        public String getName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1414015014")) {
                return this.name;
            }
            return (String) ipChange.ipc$dispatch("1414015014", new Object[]{this});
        }

        public String getStatus() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1613090803")) {
                return this.status;
            }
            return (String) ipChange.ipc$dispatch("-1613090803", new Object[]{this});
        }

        public String getUmpCouponTplId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "738533064")) {
                return this.umpCouponTplId;
            }
            return (String) ipChange.ipc$dispatch("738533064", new Object[]{this});
        }

        public String getUmpCouponTplSpreadId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1887812965")) {
                return this.umpCouponTplSpreadId;
            }
            return (String) ipChange.ipc$dispatch("-1887812965", new Object[]{this});
        }

        public String getUseCouponUrlH5() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-359045718")) {
                return this.useCouponUrlH5;
            }
            return (String) ipChange.ipc$dispatch("-359045718", new Object[]{this});
        }

        public String getUseCouponUrlMobile() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1352494081")) {
                return this.useCouponUrlMobile;
            }
            return (String) ipChange.ipc$dispatch("-1352494081", new Object[]{this});
        }

        public void setCreateTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1445506010")) {
                ipChange.ipc$dispatch("1445506010", new Object[]{this, str});
                return;
            }
            this.createTime = str;
        }

        public void setDecreaseMoneyNum(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "928894015")) {
                ipChange.ipc$dispatch("928894015", new Object[]{this, str});
                return;
            }
            this.decreaseMoneyNum = str;
        }

        public void setDecreaseMoneyTag(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "744803499")) {
                ipChange.ipc$dispatch("744803499", new Object[]{this, str});
                return;
            }
            this.decreaseMoneyTag = str;
        }

        public void setEffectiveEndTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2109460702")) {
                ipChange.ipc$dispatch("-2109460702", new Object[]{this, str});
                return;
            }
            this.effectiveEndTime = str;
        }

        public void setEffectiveStartTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "335362747")) {
                ipChange.ipc$dispatch("335362747", new Object[]{this, str});
                return;
            }
            this.effectiveStartTime = str;
        }

        public void setEffectiveTimeText(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1519934362")) {
                ipChange.ipc$dispatch("1519934362", new Object[]{this, str});
                return;
            }
            this.effectiveTimeText = str;
        }

        public void setId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-422584344")) {
                ipChange.ipc$dispatch("-422584344", new Object[]{this, str});
                return;
            }
            this.id = str;
        }

        public void setName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "592035704")) {
                ipChange.ipc$dispatch("592035704", new Object[]{this, str});
                return;
            }
            this.name = str;
        }

        public void setStatus(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "138700657")) {
                ipChange.ipc$dispatch("138700657", new Object[]{this, str});
                return;
            }
            this.status = str;
        }

        public void setUmpCouponTplId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1992385514")) {
                ipChange.ipc$dispatch("-1992385514", new Object[]{this, str});
                return;
            }
            this.umpCouponTplId = str;
        }

        public void setUmpCouponTplSpreadId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "665029539")) {
                ipChange.ipc$dispatch("665029539", new Object[]{this, str});
                return;
            }
            this.umpCouponTplSpreadId = str;
        }

        public void setUseCouponUrlH5(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1657589388")) {
                ipChange.ipc$dispatch("-1657589388", new Object[]{this, str});
                return;
            }
            this.useCouponUrlH5 = str;
        }

        public void setUseCouponUrlMobile(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "980349887")) {
                ipChange.ipc$dispatch("980349887", new Object[]{this, str});
                return;
            }
            this.useCouponUrlMobile = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "712303694")) {
                ipChange.ipc$dispatch("712303694", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.createTime);
            parcel.writeString(this.decreaseMoneyNum);
            parcel.writeString(this.decreaseMoneyTag);
            parcel.writeString(this.effectiveEndTime);
            parcel.writeString(this.effectiveStartTime);
            parcel.writeString(this.effectiveTimeText);
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.status);
            parcel.writeString(this.umpCouponTplId);
            parcel.writeString(this.umpCouponTplSpreadId);
            parcel.writeString(this.useCouponUrlH5);
            parcel.writeString(this.useCouponUrlMobile);
        }

        protected CouponAppliedBean(Parcel parcel) {
            this.createTime = parcel.readString();
            this.decreaseMoneyNum = parcel.readString();
            this.decreaseMoneyTag = parcel.readString();
            this.effectiveEndTime = parcel.readString();
            this.effectiveStartTime = parcel.readString();
            this.effectiveTimeText = parcel.readString();
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.status = parcel.readString();
            this.umpCouponTplId = parcel.readString();
            this.umpCouponTplSpreadId = parcel.readString();
            this.useCouponUrlH5 = parcel.readString();
            this.useCouponUrlMobile = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    public static class CouponApplyDataBean {
        private static transient /* synthetic */ IpChange $ipChange;
        private List<CouponAppliedBean> successCoupons;

        public List<CouponAppliedBean> getSuccessCoupons() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1973941831")) {
                return this.successCoupons;
            }
            return (List) ipChange.ipc$dispatch("1973941831", new Object[]{this});
        }

        public void setSuccessCoupons(List<CouponAppliedBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1928884891")) {
                ipChange.ipc$dispatch("-1928884891", new Object[]{this, list});
                return;
            }
            this.successCoupons = list;
        }
    }

    public void setData(CouponApplyDataBean couponApplyDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319776724")) {
            ipChange.ipc$dispatch("-1319776724", new Object[]{this, couponApplyDataBean});
            return;
        }
        this.data = couponApplyDataBean;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public CouponApplyDataBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-983480814")) {
            return this.data;
        }
        return (CouponApplyDataBean) ipChange.ipc$dispatch("-983480814", new Object[]{this});
    }
}
