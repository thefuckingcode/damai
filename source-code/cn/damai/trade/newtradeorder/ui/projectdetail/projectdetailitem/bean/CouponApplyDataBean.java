package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

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
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponApplyDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CouponApplyDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1703580299")) {
                return new CouponApplyDataBean(parcel);
            }
            return (CouponApplyDataBean) ipChange.ipc$dispatch("1703580299", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CouponApplyDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1427954022")) {
                return new CouponApplyDataBean[i];
            }
            return (CouponApplyDataBean[]) ipChange.ipc$dispatch("-1427954022", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String nextApplicable;
    private List<SuccessCouponBean> successCoupons;

    /* compiled from: Taobao */
    public static class SuccessCouponBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SuccessCouponBean> CREATOR = new Parcelable.Creator<SuccessCouponBean>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponApplyDataBean.SuccessCouponBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public SuccessCouponBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1465009685")) {
                    return new SuccessCouponBean(parcel);
                }
                return (SuccessCouponBean) ipChange.ipc$dispatch("-1465009685", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public SuccessCouponBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "590876144")) {
                    return new SuccessCouponBean[i];
                }
                return (SuccessCouponBean[]) ipChange.ipc$dispatch("590876144", new Object[]{this, Integer.valueOf(i)});
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
            if (!AndroidInstantRuntime.support(ipChange, "1022050946")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("1022050946", new Object[]{this})).intValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1247942281")) {
                ipChange.ipc$dispatch("1247942281", new Object[]{this, parcel, Integer.valueOf(i)});
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
        if (!AndroidInstantRuntime.support(ipChange, "-1233884115")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1233884115", new Object[]{this})).intValue();
    }

    public String getNextApplicable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-942079715")) {
            return this.nextApplicable;
        }
        return (String) ipChange.ipc$dispatch("-942079715", new Object[]{this});
    }

    public List<SuccessCouponBean> getSuccessCoupons() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1184184164")) {
            return this.successCoupons;
        }
        return (List) ipChange.ipc$dispatch("-1184184164", new Object[]{this});
    }

    public void setNextApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743193185")) {
            ipChange.ipc$dispatch("1743193185", new Object[]{this, str});
            return;
        }
        this.nextApplicable = str;
    }

    public void setSuccessCoupons(List<SuccessCouponBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046542928")) {
            ipChange.ipc$dispatch("-1046542928", new Object[]{this, list});
            return;
        }
        this.successCoupons = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1633544130")) {
            ipChange.ipc$dispatch("-1633544130", new Object[]{this, parcel, Integer.valueOf(i)});
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
