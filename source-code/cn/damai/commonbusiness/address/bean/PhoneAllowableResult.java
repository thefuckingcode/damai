package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class PhoneAllowableResult implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PhoneAllowableResult> CREATOR = new Parcelable.Creator<PhoneAllowableResult>() {
        /* class cn.damai.commonbusiness.address.bean.PhoneAllowableResult.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PhoneAllowableResult createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-15702935")) {
                return new PhoneAllowableResult(parcel);
            }
            return (PhoneAllowableResult) ipChange.ipc$dispatch("-15702935", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PhoneAllowableResult[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1224485712")) {
                return new PhoneAllowableResult[i];
            }
            return (PhoneAllowableResult[]) ipChange.ipc$dispatch("-1224485712", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public ArrayList<PhoneAllowableBean> result;

    public PhoneAllowableResult() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2147432664")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2147432664", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744492275")) {
            ipChange.ipc$dispatch("1744492275", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeList(this.result);
    }

    protected PhoneAllowableResult(Parcel parcel) {
        ArrayList<PhoneAllowableBean> arrayList = new ArrayList<>();
        this.result = arrayList;
        parcel.readList(arrayList, PhoneAllowableBean.class.getClassLoader());
    }
}
