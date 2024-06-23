package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CouponSubActBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CouponSubActBean> CREATOR = new Parcelable.Creator<CouponSubActBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponSubActBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CouponSubActBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-147384509")) {
                return new CouponSubActBean(parcel);
            }
            return (CouponSubActBean) ipChange.ipc$dispatch("-147384509", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CouponSubActBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-358062320")) {
                return new CouponSubActBean[i];
            }
            return (CouponSubActBean[]) ipChange.ipc$dispatch("-358062320", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String appAsacCode;
    private String applicable;
    private String decreaseMoneyNum;
    private String decreaseMoneyTag;
    private String desc;
    private String effectiveEndTime;
    private String effectiveStartTime;
    private String effectiveTimeText;
    private String id;
    private String name;
    private String tag;
    private String unapplicableCause;

    public CouponSubActBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "778544971")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("778544971", new Object[]{this})).intValue();
    }

    public String getAppAsacCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1332481617")) {
            return this.appAsacCode;
        }
        return (String) ipChange.ipc$dispatch("-1332481617", new Object[]{this});
    }

    public String getDecreaseMoneyNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-474964307")) {
            return this.decreaseMoneyNum;
        }
        return (String) ipChange.ipc$dispatch("-474964307", new Object[]{this});
    }

    public String getDecreaseMoneyTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-757997375")) {
            return this.decreaseMoneyTag;
        }
        return (String) ipChange.ipc$dispatch("-757997375", new Object[]{this});
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1877456806")) {
            return this.desc;
        }
        return (String) ipChange.ipc$dispatch("-1877456806", new Object[]{this});
    }

    public String getEffectiveEndTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1127165078")) {
            return this.effectiveEndTime;
        }
        return (String) ipChange.ipc$dispatch("-1127165078", new Object[]{this});
    }

    public String getEffectiveStartTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1881944113")) {
            return this.effectiveStartTime;
        }
        return (String) ipChange.ipc$dispatch("1881944113", new Object[]{this});
    }

    public String getEffectiveTimeText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-736674322")) {
            return this.effectiveTimeText;
        }
        return (String) ipChange.ipc$dispatch("-736674322", new Object[]{this});
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2083468644")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("2083468644", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "829490004")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("829490004", new Object[]{this});
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "630099495")) {
            return this.tag;
        }
        return (String) ipChange.ipc$dispatch("630099495", new Object[]{this});
    }

    public String getUnapplicableCause() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "182041054")) {
            return this.unapplicableCause;
        }
        return (String) ipChange.ipc$dispatch("182041054", new Object[]{this});
    }

    public String isApplicable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1898848172")) {
            return this.applicable;
        }
        return (String) ipChange.ipc$dispatch("1898848172", new Object[]{this});
    }

    public void setAppAsacCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-657208409")) {
            ipChange.ipc$dispatch("-657208409", new Object[]{this, str});
            return;
        }
        this.appAsacCode = str;
    }

    public void setApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706856182")) {
            ipChange.ipc$dispatch("706856182", new Object[]{this, str});
            return;
        }
        this.applicable = str;
    }

    public void setDecreaseMoneyNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284180945")) {
            ipChange.ipc$dispatch("1284180945", new Object[]{this, str});
            return;
        }
        this.decreaseMoneyNum = str;
    }

    public void setDecreaseMoneyTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100090429")) {
            ipChange.ipc$dispatch("1100090429", new Object[]{this, str});
            return;
        }
        this.decreaseMoneyTag = str;
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635624388")) {
            ipChange.ipc$dispatch("1635624388", new Object[]{this, str});
            return;
        }
        this.desc = str;
    }

    public void setEffectiveEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754173772")) {
            ipChange.ipc$dispatch("-1754173772", new Object[]{this, str});
            return;
        }
        this.effectiveEndTime = str;
    }

    public void setEffectiveStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831281203")) {
            ipChange.ipc$dispatch("-1831281203", new Object[]{this, str});
            return;
        }
        this.effectiveStartTime = str;
    }

    public void setEffectiveTimeText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351072696")) {
            ipChange.ipc$dispatch("-351072696", new Object[]{this, str});
            return;
        }
        this.effectiveTimeText = str;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995629318")) {
            ipChange.ipc$dispatch("-995629318", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348370422")) {
            ipChange.ipc$dispatch("-348370422", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523204049")) {
            ipChange.ipc$dispatch("-523204049", new Object[]{this, str});
            return;
        }
        this.tag = str;
    }

    public void setUnapplicableCause(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935667112")) {
            ipChange.ipc$dispatch("-1935667112", new Object[]{this, str});
            return;
        }
        this.unapplicableCause = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397013728")) {
            ipChange.ipc$dispatch("1397013728", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.applicable);
        parcel.writeString(this.decreaseMoneyNum);
        parcel.writeString(this.decreaseMoneyTag);
        parcel.writeString(this.desc);
        parcel.writeString(this.effectiveEndTime);
        parcel.writeString(this.effectiveStartTime);
        parcel.writeString(this.effectiveTimeText);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.tag);
        parcel.writeString(this.unapplicableCause);
        parcel.writeString(this.appAsacCode);
    }

    protected CouponSubActBean(Parcel parcel) {
        this.applicable = parcel.readString();
        this.decreaseMoneyNum = parcel.readString();
        this.decreaseMoneyTag = parcel.readString();
        this.desc = parcel.readString();
        this.effectiveEndTime = parcel.readString();
        this.effectiveStartTime = parcel.readString();
        this.effectiveTimeText = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.tag = parcel.readString();
        this.unapplicableCause = parcel.readString();
        this.appAsacCode = parcel.readString();
    }
}
