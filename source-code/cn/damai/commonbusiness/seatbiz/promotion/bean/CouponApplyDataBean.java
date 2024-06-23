package cn.damai.commonbusiness.seatbiz.promotion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class CouponApplyDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CouponApplyDataBean> CREATOR = new Parcelable.Creator<CouponApplyDataBean>() {
        /* class cn.damai.commonbusiness.seatbiz.promotion.bean.CouponApplyDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CouponApplyDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-190113109")) {
                return new CouponApplyDataBean(parcel);
            }
            return (CouponApplyDataBean) ipChange.ipc$dispatch("-190113109", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CouponApplyDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1245238916")) {
                return new CouponApplyDataBean[i];
            }
            return (CouponApplyDataBean[]) ipChange.ipc$dispatch("-1245238916", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String nextApplicable;
    private List<SuccessCouponBean> successCoupons;

    /* compiled from: Taobao */
    public static class SuccessCouponBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SuccessCouponBean> CREATOR = new Parcelable.Creator<SuccessCouponBean>() {
            /* class cn.damai.commonbusiness.seatbiz.promotion.bean.CouponApplyDataBean.SuccessCouponBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public SuccessCouponBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "624828939")) {
                    return new SuccessCouponBean(parcel);
                }
                return (SuccessCouponBean) ipChange.ipc$dispatch("624828939", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public SuccessCouponBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "21443666")) {
                    return new SuccessCouponBean[i];
                }
                return (SuccessCouponBean[]) ipChange.ipc$dispatch("21443666", new Object[]{this, Integer.valueOf(i)});
            }
        };
        public String createTime;
        public String decreaseMoneyNum;
        public String decreaseMoneyTag;
        public String effectiveEndTime;
        public String effectiveStartTime;
        public String effectiveTimeText;
        public String id;
        public String name;
        public String status;
        public String umpCouponTplId;
        public String umpCouponTplSpreadId;
        public String useCouponUrlH5;
        public String useCouponUrlMobile;

        public SuccessCouponBean() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-124897903")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-124897903", new Object[]{this})).intValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "87016282")) {
                ipChange.ipc$dispatch("87016282", new Object[]{this, parcel, Integer.valueOf(i)});
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

        protected SuccessCouponBean(Parcel parcel) {
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

    public CouponApplyDataBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1870899972")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1870899972", new Object[]{this})).intValue();
    }

    public String getNextApplicable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2089028564")) {
            return this.nextApplicable;
        }
        return (String) ipChange.ipc$dispatch("-2089028564", new Object[]{this});
    }

    public List<SuccessCouponBean> getSuccessCoupons() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-805489813")) {
            return this.successCoupons;
        }
        return (List) ipChange.ipc$dispatch("-805489813", new Object[]{this});
    }

    public void setNextApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547517234")) {
            ipChange.ipc$dispatch("547517234", new Object[]{this, str});
            return;
        }
        this.nextApplicable = str;
    }

    public void setSuccessCoupons(List<SuccessCouponBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103047361")) {
            ipChange.ipc$dispatch("2103047361", new Object[]{this, list});
            return;
        }
        this.successCoupons = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516046159")) {
            ipChange.ipc$dispatch("1516046159", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.nextApplicable);
        parcel.writeList(this.successCoupons);
    }

    protected CouponApplyDataBean(Parcel parcel) {
        this.nextApplicable = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.successCoupons = arrayList;
        parcel.readList(arrayList, SuccessCouponBean.class.getClassLoader());
    }
}
