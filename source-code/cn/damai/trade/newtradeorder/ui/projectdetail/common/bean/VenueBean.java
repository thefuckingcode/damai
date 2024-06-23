package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VenueBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<VenueBean> CREATOR = new Parcelable.Creator<VenueBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public VenueBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "873364133")) {
                return new VenueBean(parcel);
            }
            return (VenueBean) ipChange.ipc$dispatch("873364133", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public VenueBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-977415184")) {
                return new VenueBean[i];
            }
            return (VenueBean[]) ipChange.ipc$dispatch("-977415184", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String distance;
    private double lat;
    private double lng;
    public String region;
    public String showCountText;
    private String venueAddr;
    private String venueCityName;
    private String venueId;
    private String venueName;

    public VenueBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1073109286")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1073109286", new Object[]{this})).intValue();
    }

    public String getDistance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "866708941")) {
            return this.distance;
        }
        return (String) ipChange.ipc$dispatch("866708941", new Object[]{this});
    }

    public double getLat() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1022335567")) {
            return this.lat;
        }
        return ((Double) ipChange.ipc$dispatch("-1022335567", new Object[]{this})).doubleValue();
    }

    public double getLng() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1010717077")) {
            return this.lng;
        }
        return ((Double) ipChange.ipc$dispatch("-1010717077", new Object[]{this})).doubleValue();
    }

    public String getRegion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "495112844")) {
            return this.region;
        }
        return (String) ipChange.ipc$dispatch("495112844", new Object[]{this});
    }

    public String getVenueAddr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-619515426")) {
            return this.venueAddr;
        }
        return (String) ipChange.ipc$dispatch("-619515426", new Object[]{this});
    }

    public String getVenueCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1227142397")) {
            return this.venueCityName;
        }
        return (String) ipChange.ipc$dispatch("-1227142397", new Object[]{this});
    }

    public String getVenueId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-407344504")) {
            return this.venueId;
        }
        return (String) ipChange.ipc$dispatch("-407344504", new Object[]{this});
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-545161352")) {
            return this.venueName;
        }
        return (String) ipChange.ipc$dispatch("-545161352", new Object[]{this});
    }

    public boolean notMainLandProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1371489490")) {
            return "2".equals(this.region) || "3".equals(this.region);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1371489490", new Object[]{this})).booleanValue();
    }

    public void setDistance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215845553")) {
            ipChange.ipc$dispatch("1215845553", new Object[]{this, str});
            return;
        }
        this.distance = str;
    }

    public void setLat(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309198927")) {
            ipChange.ipc$dispatch("309198927", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.lat = d;
    }

    public void setLng(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669372117")) {
            ipChange.ipc$dispatch("669372117", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.lng = d;
    }

    public void setRegion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068504274")) {
            ipChange.ipc$dispatch("1068504274", new Object[]{this, str});
            return;
        }
        this.region = str;
    }

    public void setVenueAddr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304653400")) {
            ipChange.ipc$dispatch("304653400", new Object[]{this, str});
            return;
        }
        this.venueAddr = str;
    }

    public void setVenueCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255372333")) {
            ipChange.ipc$dispatch("-1255372333", new Object[]{this, str});
            return;
        }
        this.venueCityName = str;
    }

    public void setVenueId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359031314")) {
            ipChange.ipc$dispatch("-1359031314", new Object[]{this, str});
            return;
        }
        this.venueId = str;
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685337602")) {
            ipChange.ipc$dispatch("-1685337602", new Object[]{this, str});
            return;
        }
        this.venueName = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897445169")) {
            ipChange.ipc$dispatch("897445169", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.distance);
        parcel.writeString(this.venueCityName);
        parcel.writeString(this.venueId);
        parcel.writeString(this.venueName);
        parcel.writeDouble(this.lng);
        parcel.writeDouble(this.lat);
        parcel.writeString(this.venueAddr);
        parcel.writeString(this.showCountText);
        parcel.writeString(this.region);
    }

    protected VenueBean(Parcel parcel) {
        this.distance = parcel.readString();
        this.venueCityName = parcel.readString();
        this.venueId = parcel.readString();
        this.venueName = parcel.readString();
        this.lng = parcel.readDouble();
        this.lat = parcel.readDouble();
        this.venueAddr = parcel.readString();
        this.showCountText = parcel.readString();
        this.region = parcel.readString();
    }
}
