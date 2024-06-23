package cn.damai.commonbusiness.servicenotice;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ServiceNote implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ServiceNote> CREATOR = new a();
    public String imgUrl;
    public String isSupport;
    public String tagDesc;
    public String tagName;
    public String tagType;

    /* compiled from: Taobao */
    public class a implements Parcelable.Creator<ServiceNote> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public ServiceNote createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-827170037")) {
                return new ServiceNote(parcel);
            }
            return (ServiceNote) ipChange.ipc$dispatch("-827170037", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public ServiceNote[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-197567216")) {
                return new ServiceNote[i];
            }
            return (ServiceNote[]) ipChange.ipc$dispatch("-197567216", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public ServiceNote() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-159760409")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-159760409", new Object[]{this})).intValue();
    }

    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "96667409")) {
            return this.imgUrl;
        }
        return (String) ipChange.ipc$dispatch("96667409", new Object[]{this});
    }

    public String getIsSupport() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1043955126")) {
            return this.isSupport;
        }
        return (String) ipChange.ipc$dispatch("1043955126", new Object[]{this});
    }

    public String getTagDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1932173764")) {
            return this.tagDesc;
        }
        return (String) ipChange.ipc$dispatch("-1932173764", new Object[]{this});
    }

    public String getTagName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "774773046")) {
            return this.tagName;
        }
        return (String) ipChange.ipc$dispatch("774773046", new Object[]{this});
    }

    public String getTagType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1636892571")) {
            return this.tagType;
        }
        return (String) ipChange.ipc$dispatch("-1636892571", new Object[]{this});
    }

    public boolean isSupport() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "398125296")) {
            return TextUtils.equals("true", this.isSupport);
        }
        return ((Boolean) ipChange.ipc$dispatch("398125296", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660934716")) {
            ipChange.ipc$dispatch("-660934716", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.isSupport);
        parcel.writeString(this.tagName);
        parcel.writeString(this.tagDesc);
        parcel.writeString(this.tagType);
        parcel.writeString(this.imgUrl);
    }

    protected ServiceNote(Parcel parcel) {
        this.isSupport = parcel.readString();
        this.tagName = parcel.readString();
        this.tagDesc = parcel.readString();
        this.tagType = parcel.readString();
        this.imgUrl = parcel.readString();
    }
}
