package cn.damai.ultron.view.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DmRemindBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DmRemindBean> CREATOR = new Parcelable.Creator<DmRemindBean>() {
        /* class cn.damai.ultron.view.bean.DmRemindBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DmRemindBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1565338389")) {
                return new DmRemindBean(parcel);
            }
            return (DmRemindBean) ipChange.ipc$dispatch("-1565338389", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DmRemindBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1407624008")) {
                return new DmRemindBean[i];
            }
            return (DmRemindBean[]) ipChange.ipc$dispatch("1407624008", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String closeIcon;
    public String icon;
    public String text;
    public String textColor;
    public String tip;

    public DmRemindBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1700183722")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1700183722", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91167285")) {
            ipChange.ipc$dispatch("91167285", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.icon);
        parcel.writeString(this.text);
        parcel.writeString(this.textColor);
        parcel.writeString(this.tip);
        parcel.writeString(this.closeIcon);
    }

    protected DmRemindBean(Parcel parcel) {
        this.icon = parcel.readString();
        this.text = parcel.readString();
        this.textColor = parcel.readString();
        this.tip = parcel.readString();
        this.closeIcon = parcel.readString();
    }
}
