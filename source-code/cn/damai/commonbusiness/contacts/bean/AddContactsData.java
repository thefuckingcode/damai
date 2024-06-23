package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AddContactsData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddContactsData> CREATOR = new Parcelable.Creator<AddContactsData>() {
        /* class cn.damai.commonbusiness.contacts.bean.AddContactsData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public AddContactsData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "313476639")) {
                return new AddContactsData(parcel);
            }
            return (AddContactsData) ipChange.ipc$dispatch("313476639", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public AddContactsData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1153883312")) {
                return new AddContactsData[i];
            }
            return (AddContactsData[]) ipChange.ipc$dispatch("-1153883312", new Object[]{this, Integer.valueOf(i)});
        }
    };
    AddContactsBean data;

    public AddContactsData() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-490748771")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-490748771", new Object[]{this})).intValue();
    }

    public AddContactsBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "171467220")) {
            return this.data;
        }
        return (AddContactsBean) ipChange.ipc$dispatch("171467220", new Object[]{this});
    }

    public void setData(AddContactsBean addContactsBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342102118")) {
            ipChange.ipc$dispatch("-342102118", new Object[]{this, addContactsBean});
            return;
        }
        this.data = addContactsBean;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1464118734")) {
            ipChange.ipc$dispatch("1464118734", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.data, i);
    }

    protected AddContactsData(Parcel parcel) {
        this.data = (AddContactsBean) parcel.readParcelable(AddContactsBean.class.getClassLoader());
    }
}
