package cn.damai.commonbusiness.citycopy.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CityParam implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CityParam> CREATOR = new Parcelable.Creator<CityParam>() {
        /* class cn.damai.commonbusiness.citycopy.bean.CityParam.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CityParam createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-231777423")) {
                return new CityParam(parcel);
            }
            return (CityParam) ipChange.ipc$dispatch("-231777423", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CityParam[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1493066576")) {
                return new CityParam[i];
            }
            return (CityParam[]) ipChange.ipc$dispatch("-1493066576", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public boolean isOnlyObtainCityId;
    public String selectCityName;

    public CityParam() {
    }

    public static CityParam onlyObtainCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763145244")) {
            return (CityParam) ipChange.ipc$dispatch("1763145244", new Object[]{str});
        }
        CityParam cityParam = new CityParam();
        cityParam.isOnlyObtainCityId = true;
        cityParam.selectCityName = str;
        return cityParam;
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-277769036")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-277769036", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401433751")) {
            ipChange.ipc$dispatch("1401433751", new Object[]{this, parcel, Integer.valueOf(i)});
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
