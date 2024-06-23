package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StatusNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<StatusNotice> CREATOR = new Parcelable.Creator<StatusNotice>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public StatusNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1648184961")) {
                return new StatusNotice(parcel);
            }
            return (StatusNotice) ipChange.ipc$dispatch("-1648184961", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public StatusNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1020219088")) {
                return new StatusNotice[i];
            }
            return (StatusNotice[]) ipChange.ipc$dispatch("1020219088", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String hasPopup;
    public String imageUrl;
    private String notice;
    private String popupContent;
    private String popupTitle;
    private String prefixText;

    protected StatusNotice(Parcel parcel) {
        this.prefixText = parcel.readString();
        this.notice = parcel.readString();
        this.hasPopup = parcel.readString();
        this.popupTitle = parcel.readString();
        this.popupContent = parcel.readString();
        this.imageUrl = parcel.readString();
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "4937581")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("4937581", new Object[]{this})).intValue();
    }

    public String getHasPopup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-494744675")) {
            return this.hasPopup;
        }
        return (String) ipChange.ipc$dispatch("-494744675", new Object[]{this});
    }

    public String getNotice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1448624829")) {
            return this.notice;
        }
        return (String) ipChange.ipc$dispatch("-1448624829", new Object[]{this});
    }

    public String getPopupContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1418415080")) {
            return this.popupContent;
        }
        return (String) ipChange.ipc$dispatch("-1418415080", new Object[]{this});
    }

    public String getPopupTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1619788151")) {
            return this.popupTitle;
        }
        return (String) ipChange.ipc$dispatch("1619788151", new Object[]{this});
    }

    public String getPrefixText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1211342902")) {
            return this.prefixText;
        }
        return (String) ipChange.ipc$dispatch("-1211342902", new Object[]{this});
    }

    public boolean isHasPopup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-977195737")) {
            return TextUtils.equals("true", this.hasPopup);
        }
        return ((Boolean) ipChange.ipc$dispatch("-977195737", new Object[]{this})).booleanValue();
    }

    public void setHasPopup(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1960456417")) {
            ipChange.ipc$dispatch("1960456417", new Object[]{this, str});
            return;
        }
        this.hasPopup = str;
    }

    public void setNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942178555")) {
            ipChange.ipc$dispatch("942178555", new Object[]{this, str});
            return;
        }
        this.notice = str;
    }

    public void setPopupContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623313466")) {
            ipChange.ipc$dispatch("-623313466", new Object[]{this, str});
            return;
        }
        this.popupContent = str;
    }

    public void setPopupTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858908999")) {
            ipChange.ipc$dispatch("858908999", new Object[]{this, str});
            return;
        }
        this.popupTitle = str;
    }

    public void setPrefixText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006807724")) {
            ipChange.ipc$dispatch("-1006807724", new Object[]{this, str});
            return;
        }
        this.prefixText = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969810178")) {
            ipChange.ipc$dispatch("-1969810178", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.prefixText);
        parcel.writeString(this.notice);
        parcel.writeString(this.hasPopup);
        parcel.writeString(this.popupTitle);
        parcel.writeString(this.popupContent);
        parcel.writeString(this.imageUrl);
    }

    public StatusNotice() {
    }
}
