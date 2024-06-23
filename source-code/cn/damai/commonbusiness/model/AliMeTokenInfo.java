package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AliMeTokenInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AliMeTokenInfo> CREATOR = new Parcelable.Creator<AliMeTokenInfo>() {
        /* class cn.damai.commonbusiness.model.AliMeTokenInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public AliMeTokenInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1705545653")) {
                return new AliMeTokenInfo(parcel);
            }
            return (AliMeTokenInfo) ipChange.ipc$dispatch("-1705545653", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public AliMeTokenInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "170467118")) {
                return new AliMeTokenInfo[i];
            }
            return (AliMeTokenInfo[]) ipChange.ipc$dispatch("170467118", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String result;

    public AliMeTokenInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2123686621")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-2123686621", new Object[]{this})).intValue();
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1001010238")) {
            return this.result;
        }
        return (String) ipChange.ipc$dispatch("1001010238", new Object[]{this});
    }

    public void setResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428545696")) {
            ipChange.ipc$dispatch("-428545696", new Object[]{this, str});
            return;
        }
        this.result = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911508472")) {
            ipChange.ipc$dispatch("-1911508472", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.result);
    }

    protected AliMeTokenInfo(Parcel parcel) {
        this.result = parcel.readString();
    }
}
