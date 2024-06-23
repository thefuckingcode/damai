package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class DivisionListDataBean extends BaseOutDo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DivisionListDataBean> CREATOR = new Parcelable.Creator<DivisionListDataBean>() {
        /* class cn.damai.commonbusiness.address.bean.DivisionListDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DivisionListDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1608517443")) {
                return new DivisionListDataBean(parcel);
            }
            return (DivisionListDataBean) ipChange.ipc$dispatch("1608517443", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DivisionListDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1992343184")) {
                return new DivisionListDataBean[i];
            }
            return (DivisionListDataBean[]) ipChange.ipc$dispatch("1992343184", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private DivisionListBean data;

    public DivisionListDataBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1377515445")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1377515445", new Object[]{this})).intValue();
    }

    public void setData(DivisionListBean divisionListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428665258")) {
            ipChange.ipc$dispatch("428665258", new Object[]{this, divisionListBean});
            return;
        }
        this.data = divisionListBean;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343032864")) {
            ipChange.ipc$dispatch("-343032864", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.data, i);
    }

    protected DivisionListDataBean(Parcel parcel) {
        this.data = (DivisionListBean) parcel.readParcelable(DivisionListBean.class.getClassLoader());
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public DivisionListBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2029389896")) {
            return this.data;
        }
        return (DivisionListBean) ipChange.ipc$dispatch("2029389896", new Object[]{this});
    }
}
