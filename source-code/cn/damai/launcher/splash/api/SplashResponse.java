package cn.damai.launcher.splash.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lk1;
import tb.xf2;

/* compiled from: Taobao */
public class SplashResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<SplashResponse> CREATOR = new Parcelable.Creator<SplashResponse>() {
        /* class cn.damai.launcher.splash.api.SplashResponse.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: a */
        public SplashResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-956104287")) {
                return new SplashResponse(parcel);
            }
            return (SplashResponse) ipChange.ipc$dispatch("-956104287", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public SplashResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-379485008")) {
                return new SplashResponse[i];
            }
            return (SplashResponse[]) ipChange.ipc$dispatch("-379485008", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public static final int DEFAULT_DURATION = 3;
    public static final int LABEL_HIDE = 0;
    public static final int LABEL_SHOW = 1;
    public static final int SKIPPABLE_DISABLE = 0;
    public static final int SKIPPABLE_ENABLE = 1;
    private String clickJumpDescription;
    public String comboDispatchId;
    public String comboDispatchSystem;
    private String diffCityId;
    private String displayDuration;
    private String endTime;
    private boolean isAdSupportUseCache = true;
    private String os;
    private String pic;
    private String pic2;
    private String schema;
    private String scm;
    private String showLabel;
    private String skippable;
    private String startTime;

    protected SplashResponse(Parcel parcel) {
        boolean z = true;
        this.schema = parcel.readString();
        this.os = parcel.readString();
        this.pic = parcel.readString();
        this.scm = parcel.readString();
        this.pic2 = parcel.readString();
        this.skippable = parcel.readString();
        this.displayDuration = parcel.readString();
        this.showLabel = parcel.readString();
        this.clickJumpDescription = parcel.readString();
        this.startTime = parcel.readString();
        this.endTime = parcel.readString();
        this.isAdSupportUseCache = parcel.readByte() == 0 ? false : z;
        this.comboDispatchSystem = parcel.readString();
        this.comboDispatchId = parcel.readString();
        this.diffCityId = parcel.readString();
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1718859868")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1718859868", new Object[]{this})).intValue();
    }

    public String getClickJumpDescription() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1396338592")) {
            return this.clickJumpDescription;
        }
        return (String) ipChange.ipc$dispatch("1396338592", new Object[]{this});
    }

    public String getDiffCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1553119771")) {
            return this.diffCityId;
        }
        return (String) ipChange.ipc$dispatch("-1553119771", new Object[]{this});
    }

    public String getDisplayDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1556960942")) {
            return this.displayDuration;
        }
        return (String) ipChange.ipc$dispatch("-1556960942", new Object[]{this});
    }

    public int getDisplayDurationInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "33780992")) {
            return ((Integer) ipChange.ipc$dispatch("33780992", new Object[]{this})).intValue();
        } else if (xf2.j(this.displayDuration)) {
            return 3;
        } else {
            try {
                int intValue = Integer.valueOf(this.displayDuration).intValue();
                if (intValue <= 0) {
                    return 3;
                }
                return intValue;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 3;
            }
        }
    }

    public String getEndTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1805168420")) {
            return this.endTime;
        }
        return (String) ipChange.ipc$dispatch("1805168420", new Object[]{this});
    }

    public String getOs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "747452414")) {
            return this.os;
        }
        return (String) ipChange.ipc$dispatch("747452414", new Object[]{this});
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1158352410")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-1158352410", new Object[]{this});
    }

    public String getPic2() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2025510846")) {
            return this.pic2;
        }
        return (String) ipChange.ipc$dispatch("-2025510846", new Object[]{this});
    }

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "793927611")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("793927611", new Object[]{this});
    }

    public String getScm() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-262081287")) {
            return this.scm;
        }
        return (String) ipChange.ipc$dispatch("-262081287", new Object[]{this});
    }

    public String getShowLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1350885101")) {
            return this.showLabel;
        }
        return (String) ipChange.ipc$dispatch("-1350885101", new Object[]{this});
    }

    public int getShowLabelInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049746815")) {
            return ((Integer) ipChange.ipc$dispatch("-1049746815", new Object[]{this})).intValue();
        } else if (xf2.j(this.showLabel)) {
            return 1;
        } else {
            try {
                int intValue = Integer.valueOf(this.showLabel).intValue();
                if (intValue != 0) {
                    return 1;
                }
                return intValue;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 1;
            }
        }
    }

    public String getSkippable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "156943559")) {
            return this.skippable;
        }
        return (String) ipChange.ipc$dispatch("156943559", new Object[]{this});
    }

    public int getSkippableInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283143883")) {
            return ((Integer) ipChange.ipc$dispatch("-283143883", new Object[]{this})).intValue();
        } else if (xf2.j(this.skippable)) {
            return 1;
        } else {
            try {
                int intValue = Integer.valueOf(this.skippable).intValue();
                if (intValue != 0) {
                    return 1;
                }
                return intValue;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 1;
            }
        }
    }

    public String getStartTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1939077781")) {
            return this.startTime;
        }
        return (String) ipChange.ipc$dispatch("-1939077781", new Object[]{this});
    }

    public boolean isAdEndTimeOverCurrentTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "77995163")) {
            return ((Boolean) ipChange.ipc$dispatch("77995163", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.endTime)) {
            return true;
        } else {
            if (System.currentTimeMillis() >= lk1.k(this.endTime, -1)) {
                return true;
            }
            return false;
        }
    }

    public boolean isAdSupportUseCache() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "970780963")) {
            return this.isAdSupportUseCache;
        }
        return ((Boolean) ipChange.ipc$dispatch("970780963", new Object[]{this})).booleanValue();
    }

    public boolean isPicUrlValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1207421709")) {
            return !xf2.j(this.pic);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1207421709", new Object[]{this})).booleanValue();
    }

    public void setAdSupportUseCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832329547")) {
            ipChange.ipc$dispatch("1832329547", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isAdSupportUseCache = z;
    }

    public void setClickJumpDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605487298")) {
            ipChange.ipc$dispatch("-605487298", new Object[]{this, str});
            return;
        }
        this.clickJumpDescription = str;
    }

    public void setDiffCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283011225")) {
            ipChange.ipc$dispatch("1283011225", new Object[]{this, str});
            return;
        }
        this.diffCityId = str;
    }

    public void setDisplayDuration(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739335580")) {
            ipChange.ipc$dispatch("-739335580", new Object[]{this, str});
            return;
        }
        this.displayDuration = str;
    }

    public void setEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490607406")) {
            ipChange.ipc$dispatch("-1490607406", new Object[]{this, str});
            return;
        }
        this.endTime = str;
    }

    public void setOs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537540512")) {
            ipChange.ipc$dispatch("537540512", new Object[]{this, str});
            return;
        }
        this.os = str;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130638256")) {
            ipChange.ipc$dispatch("-130638256", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public void setPic2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340916444")) {
            ipChange.ipc$dispatch("1340916444", new Object[]{this, str});
            return;
        }
        this.pic2 = str;
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741827459")) {
            ipChange.ipc$dispatch("1741827459", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public void setScm(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883962781")) {
            ipChange.ipc$dispatch("1883962781", new Object[]{this, str});
            return;
        }
        this.scm = str;
    }

    public void setShowLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892970045")) {
            ipChange.ipc$dispatch("-892970045", new Object[]{this, str});
            return;
        }
        this.showLabel = str;
    }

    public void setSkippable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394921841")) {
            ipChange.ipc$dispatch("-1394921841", new Object[]{this, str});
            return;
        }
        this.skippable = str;
    }

    public void setStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947073941")) {
            ipChange.ipc$dispatch("-1947073941", new Object[]{this, str});
            return;
        }
        this.startTime = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919733743")) {
            ipChange.ipc$dispatch("1919733743", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.schema);
        parcel.writeString(this.os);
        parcel.writeString(this.pic);
        parcel.writeString(this.scm);
        parcel.writeString(this.pic2);
        parcel.writeString(this.skippable);
        parcel.writeString(this.displayDuration);
        parcel.writeString(this.showLabel);
        parcel.writeString(this.clickJumpDescription);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeByte(this.isAdSupportUseCache ? (byte) 1 : 0);
        parcel.writeString(this.comboDispatchSystem);
        parcel.writeString(this.comboDispatchId);
        parcel.writeString(this.diffCityId);
    }

    public SplashResponse() {
    }
}
