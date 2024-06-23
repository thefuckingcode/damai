package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CouponActivityBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CouponActivityBean> CREATOR = new Parcelable.Creator<CouponActivityBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponActivityBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CouponActivityBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1557339913")) {
                return new CouponActivityBean(parcel);
            }
            return (CouponActivityBean) ipChange.ipc$dispatch("1557339913", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CouponActivityBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2087552976")) {
                return new CouponActivityBean[i];
            }
            return (CouponActivityBean[]) ipChange.ipc$dispatch("-2087552976", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String applicable;
    private String couponActSpreadId;
    private String desc;
    private String effectiveEndTime;
    private String effectiveStartTime;
    private String gainType;
    private String gainWholly;
    private String id;
    private String name;
    private String status;
    private List<CouponSubActBean> subCouponActExs;
    private String unapplicableCause;

    public CouponActivityBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2052993384")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2052993384", new Object[]{this})).intValue();
    }

    public String getCouponActSpreadId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "645914026")) {
            return this.couponActSpreadId;
        }
        return (String) ipChange.ipc$dispatch("645914026", new Object[]{this});
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "900031863")) {
            return this.desc;
        }
        return (String) ipChange.ipc$dispatch("900031863", new Object[]{this});
    }

    public String getEffectiveEndTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1399991559")) {
            return this.effectiveEndTime;
        }
        return (String) ipChange.ipc$dispatch("1399991559", new Object[]{this});
    }

    public String getEffectiveStartTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-472017266")) {
            return this.effectiveStartTime;
        }
        return (String) ipChange.ipc$dispatch("-472017266", new Object[]{this});
    }

    public String getGainType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "323970239")) {
            return this.gainType;
        }
        return (String) ipChange.ipc$dispatch("323970239", new Object[]{this});
    }

    public String getGainWholly() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "854440704")) {
            return this.gainWholly;
        }
        return (String) ipChange.ipc$dispatch("854440704", new Object[]{this});
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1851066943")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-1851066943", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-687988623")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-687988623", new Object[]{this});
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1291010456")) {
            return this.status;
        }
        return (String) ipChange.ipc$dispatch("1291010456", new Object[]{this});
    }

    public List<CouponSubActBean> getSubCouponActExs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1736498613")) {
            return this.subCouponActExs;
        }
        return (List) ipChange.ipc$dispatch("-1736498613", new Object[]{this});
    }

    public String getUnapplicableCause() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1214485473")) {
            return this.unapplicableCause;
        }
        return (String) ipChange.ipc$dispatch("1214485473", new Object[]{this});
    }

    public String isApplicable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-372790097")) {
            return this.applicable;
        }
        return (String) ipChange.ipc$dispatch("-372790097", new Object[]{this});
    }

    public void setApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494133959")) {
            ipChange.ipc$dispatch("-494133959", new Object[]{this, str});
            return;
        }
        this.applicable = str;
    }

    public void setCouponActSpreadId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440506868")) {
            ipChange.ipc$dispatch("-440506868", new Object[]{this, str});
            return;
        }
        this.couponActSpreadId = str;
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838427207")) {
            ipChange.ipc$dispatch("1838427207", new Object[]{this, str});
            return;
        }
        this.desc = str;
    }

    public void setEffectiveEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721729353")) {
            ipChange.ipc$dispatch("-721729353", new Object[]{this, str});
            return;
        }
        this.effectiveEndTime = str;
    }

    public void setEffectiveStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789639920")) {
            ipChange.ipc$dispatch("-1789639920", new Object[]{this, str});
            return;
        }
        this.effectiveStartTime = str;
    }

    public void setGainType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570814975")) {
            ipChange.ipc$dispatch("1570814975", new Object[]{this, str});
            return;
        }
        this.gainType = str;
    }

    public void setGainWholly(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1392025378")) {
            ipChange.ipc$dispatch("-1392025378", new Object[]{this, str});
            return;
        }
        this.gainWholly = str;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587819069")) {
            ipChange.ipc$dispatch("1587819069", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145567603")) {
            ipChange.ipc$dispatch("-145567603", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-28473530")) {
            ipChange.ipc$dispatch("-28473530", new Object[]{this, str});
            return;
        }
        this.status = str;
    }

    public void setSubCouponActExs(List<CouponSubActBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040000889")) {
            ipChange.ipc$dispatch("1040000889", new Object[]{this, list});
            return;
        }
        this.subCouponActExs = list;
    }

    public void setUnapplicableCause(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5338805")) {
            ipChange.ipc$dispatch("5338805", new Object[]{this, str});
            return;
        }
        this.unapplicableCause = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1703276445")) {
            ipChange.ipc$dispatch("-1703276445", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.applicable);
        parcel.writeString(this.desc);
        parcel.writeString(this.effectiveEndTime);
        parcel.writeString(this.effectiveStartTime);
        parcel.writeString(this.gainType);
        parcel.writeString(this.gainWholly);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.status);
        parcel.writeString(this.unapplicableCause);
        parcel.writeTypedList(this.subCouponActExs);
        parcel.writeString(this.couponActSpreadId);
    }

    protected CouponActivityBean(Parcel parcel) {
        this.applicable = parcel.readString();
        this.desc = parcel.readString();
        this.effectiveEndTime = parcel.readString();
        this.effectiveStartTime = parcel.readString();
        this.gainType = parcel.readString();
        this.gainWholly = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.status = parcel.readString();
        this.unapplicableCause = parcel.readString();
        this.subCouponActExs = parcel.createTypedArrayList(CouponSubActBean.CREATOR);
        this.couponActSpreadId = parcel.readString();
    }
}
