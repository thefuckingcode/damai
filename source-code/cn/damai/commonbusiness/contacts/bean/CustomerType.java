package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CustomerType implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CustomerType> CREATOR = new Parcelable.Creator<CustomerType>() {
        /* class cn.damai.commonbusiness.contacts.bean.CustomerType.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CustomerType createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1468216117")) {
                return new CustomerType(parcel);
            }
            return (CustomerType) ipChange.ipc$dispatch("-1468216117", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CustomerType[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1978816742")) {
                return new CustomerType[i];
            }
            return (CustomerType[]) ipChange.ipc$dispatch("1978816742", new Object[]{this, Integer.valueOf(i)});
        }
    };
    int identityCode;
    String identityName;
    List<InputField> inputFields;

    public CustomerType() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-670963417")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-670963417", new Object[]{this})).intValue();
    }

    public int getIdentityCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "28213795")) {
            return this.identityCode;
        }
        return ((Integer) ipChange.ipc$dispatch("28213795", new Object[]{this})).intValue();
    }

    public String getIdentityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1987548658")) {
            return this.identityName;
        }
        return (String) ipChange.ipc$dispatch("-1987548658", new Object[]{this});
    }

    public List<InputField> getInputFields() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-772442501")) {
            return this.inputFields;
        }
        return (List) ipChange.ipc$dispatch("-772442501", new Object[]{this});
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "946906557")) {
            ipChange.ipc$dispatch("946906557", new Object[]{this, parcel});
            return;
        }
        this.identityCode = parcel.readInt();
        this.identityName = parcel.readString();
        this.inputFields = parcel.createTypedArrayList(InputField.CREATOR);
    }

    public void setIdentityCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669070369")) {
            ipChange.ipc$dispatch("-669070369", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.identityCode = i;
    }

    public void setIdentityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086585200")) {
            ipChange.ipc$dispatch("-1086585200", new Object[]{this, str});
            return;
        }
        this.identityName = str;
    }

    public void setInputFields(List<InputField> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764428105")) {
            ipChange.ipc$dispatch("764428105", new Object[]{this, list});
            return;
        }
        this.inputFields = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927797628")) {
            ipChange.ipc$dispatch("-927797628", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.identityCode);
        parcel.writeString(this.identityName);
        parcel.writeTypedList(this.inputFields);
    }

    protected CustomerType(Parcel parcel) {
        this.identityCode = parcel.readInt();
        this.identityName = parcel.readString();
        this.inputFields = parcel.createTypedArrayList(InputField.CREATOR);
    }
}
