package cn.damai.wxapi.qrcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class WeiXinQRCodeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<WeiXinQRCodeBean> CREATOR = new Parcelable.Creator<WeiXinQRCodeBean>() {
        /* class cn.damai.wxapi.qrcode.WeiXinQRCodeBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public WeiXinQRCodeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-353309877")) {
                return new WeiXinQRCodeBean(parcel);
            }
            return (WeiXinQRCodeBean) ipChange.ipc$dispatch("-353309877", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public WeiXinQRCodeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "999416782")) {
                return new WeiXinQRCodeBean[i];
            }
            return (WeiXinQRCodeBean[]) ipChange.ipc$dispatch("999416782", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String qrcodeURL;

    public WeiXinQRCodeBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1632007795")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1632007795", new Object[]{this})).intValue();
    }

    public String getQrcodeURL() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1737850778")) {
            return this.qrcodeURL;
        }
        return (String) ipChange.ipc$dispatch("-1737850778", new Object[]{this});
    }

    public void setQrcodeURL(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4004144")) {
            ipChange.ipc$dispatch("-4004144", new Object[]{this, str});
            return;
        }
        this.qrcodeURL = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617161400")) {
            ipChange.ipc$dispatch("617161400", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.qrcodeURL);
    }

    protected WeiXinQRCodeBean(Parcel parcel) {
        this.qrcodeURL = parcel.readString();
    }
}
