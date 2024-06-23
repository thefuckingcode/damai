package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CouponListDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CouponListDataBean> CREATOR = new Parcelable.Creator<CouponListDataBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponListDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CouponListDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1215517655")) {
                return new CouponListDataBean(parcel);
            }
            return (CouponListDataBean) ipChange.ipc$dispatch("1215517655", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CouponListDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1209109520")) {
                return new CouponListDataBean[i];
            }
            return (CouponListDataBean[]) ipChange.ipc$dispatch("1209109520", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<CouponActivityBean> couponActivities;

    public CouponListDataBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1614272895")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1614272895", new Object[]{this})).intValue();
    }

    public List<CouponActivityBean> getCouponActivities() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1660677415")) {
            return this.couponActivities;
        }
        return (List) ipChange.ipc$dispatch("-1660677415", new Object[]{this});
    }

    public void setCouponActivities(List<CouponActivityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847047699")) {
            ipChange.ipc$dispatch("1847047699", new Object[]{this, list});
            return;
        }
        this.couponActivities = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546137494")) {
            ipChange.ipc$dispatch("-1546137494", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.couponActivities);
    }

    protected CouponListDataBean(Parcel parcel) {
        this.couponActivities = parcel.createTypedArrayList(CouponActivityBean.CREATOR);
    }
}
