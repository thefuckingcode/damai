package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IdCardTypes implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IdCardTypes> CREATOR = new Parcelable.Creator<IdCardTypes>() {
        /* class cn.damai.commonbusiness.contacts.bean.IdCardTypes.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public IdCardTypes createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1031485951")) {
                return new IdCardTypes(parcel);
            }
            return (IdCardTypes) ipChange.ipc$dispatch("1031485951", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public IdCardTypes[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2051419440")) {
                return new IdCardTypes[i];
            }
            return (IdCardTypes[]) ipChange.ipc$dispatch("-2051419440", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public int id;
    public String name;

    public IdCardTypes() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1603419949")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1603419949", new Object[]{this})).intValue();
    }

    public int getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-65007603")) {
            return this.id;
        }
        return ((Integer) ipChange.ipc$dispatch("-65007603", new Object[]{this})).intValue();
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-629237450")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-629237450", new Object[]{this});
    }

    public void setId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065144373")) {
            ipChange.ipc$dispatch("2065144373", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.id = i;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1675718760")) {
            ipChange.ipc$dispatch("1675718760", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259742402")) {
            ipChange.ipc$dispatch("-259742402", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
    }

    public IdCardTypes(int i, String str) {
        this.id = i;
        this.name = str;
    }

    protected IdCardTypes(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
    }
}
