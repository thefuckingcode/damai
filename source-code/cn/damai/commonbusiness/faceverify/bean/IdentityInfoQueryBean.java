package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IdentityInfoQueryBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IdentityInfoQueryBean> CREATOR = new Parcelable.Creator<IdentityInfoQueryBean>() {
        /* class cn.damai.commonbusiness.faceverify.bean.IdentityInfoQueryBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public IdentityInfoQueryBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1556928905")) {
                return new IdentityInfoQueryBean(parcel);
            }
            return (IdentityInfoQueryBean) ipChange.ipc$dispatch("1556928905", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public IdentityInfoQueryBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1932701776")) {
                return new IdentityInfoQueryBean[i];
            }
            return (IdentityInfoQueryBean[]) ipChange.ipc$dispatch("-1932701776", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String idCard;
    public String idCardType;
    public String identityHash;
    public String name;
    public String needFaceVerify;

    public IdentityInfoQueryBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1337542520")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1337542520", new Object[]{this})).intValue();
    }

    public String getIdCard() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-942759663")) {
            return this.idCard;
        }
        return (String) ipChange.ipc$dispatch("-942759663", new Object[]{this});
    }

    public String getIdCardType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "672686187")) {
            return this.idCardType;
        }
        return (String) ipChange.ipc$dispatch("672686187", new Object[]{this});
    }

    public String getIdentityHash() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1450164622")) {
            return this.identityHash;
        }
        return (String) ipChange.ipc$dispatch("-1450164622", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1140688785")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("1140688785", new Object[]{this});
    }

    public boolean isNeedFaceVerify() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "471408584")) {
            return !TextUtils.isEmpty(this.needFaceVerify) && this.needFaceVerify.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("471408584", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913433411")) {
            ipChange.ipc$dispatch("1913433411", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.needFaceVerify);
        parcel.writeString(this.name);
        parcel.writeString(this.idCard);
        parcel.writeString(this.idCardType);
        parcel.writeString(this.identityHash);
    }

    protected IdentityInfoQueryBean(Parcel parcel) {
        this.needFaceVerify = parcel.readString();
        this.name = parcel.readString();
        this.idCard = parcel.readString();
        this.idCardType = parcel.readString();
        this.identityHash = parcel.readString();
    }
}
