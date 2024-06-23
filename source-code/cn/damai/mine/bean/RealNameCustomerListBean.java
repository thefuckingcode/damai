package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class RealNameCustomerListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameCustomerListBean> CREATOR = new Parcelable.Creator<RealNameCustomerListBean>() {
        /* class cn.damai.mine.bean.RealNameCustomerListBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RealNameCustomerListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "873551645")) {
                return new RealNameCustomerListBean(parcel);
            }
            return (RealNameCustomerListBean) ipChange.ipc$dispatch("873551645", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RealNameCustomerListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1977492848")) {
                return new RealNameCustomerListBean[i];
            }
            return (RealNameCustomerListBean[]) ipChange.ipc$dispatch("1977492848", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private ArrayList<RealNameCustomerBean> result;

    public RealNameCustomerListBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1749219554")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1749219554", new Object[]{this})).intValue();
    }

    public ArrayList<RealNameCustomerBean> getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2002027167")) {
            return this.result;
        }
        return (ArrayList) ipChange.ipc$dispatch("-2002027167", new Object[]{this});
    }

    public void setResult(ArrayList<RealNameCustomerBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677983473")) {
            ipChange.ipc$dispatch("-1677983473", new Object[]{this, arrayList});
            return;
        }
        this.result = arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169595757")) {
            ipChange.ipc$dispatch("1169595757", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.result);
    }

    protected RealNameCustomerListBean(Parcel parcel) {
        this.result = parcel.createTypedArrayList(RealNameCustomerBean.CREATOR);
    }
}
