package cn.damai.commonbusiness.city.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CityParam implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CityParam> CREATOR = new Parcelable.Creator<CityParam>() {
        /* class cn.damai.commonbusiness.city.bean.CityParam.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CityParam createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-741130297")) {
                return new CityParam(parcel);
            }
            return (CityParam) ipChange.ipc$dispatch("-741130297", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CityParam[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2081366416")) {
                return new CityParam[i];
            }
            return (CityParam[]) ipChange.ipc$dispatch("2081366416", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public boolean isOnlyObtainCityId;
    public String selectCityName;

    public CityParam() {
    }

    public static CityParam onlyObtainCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009357948")) {
            return (CityParam) ipChange.ipc$dispatch("1009357948", new Object[]{str});
        }
        CityParam cityParam = new CityParam();
        cityParam.isOnlyObtainCityId = true;
        cityParam.selectCityName = str;
        return cityParam;
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1213906697")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1213906697", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45590302")) {
            ipChange.ipc$dispatch("-45590302", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.selectCityName);
        parcel.writeByte(this.isOnlyObtainCityId ? (byte) 1 : 0);
    }

    protected CityParam(Parcel parcel) {
        this.selectCityName = parcel.readString();
        this.isOnlyObtainCityId = parcel.readByte() != 0;
    }
}
