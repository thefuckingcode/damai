package cn.damai.homepage.splash;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SplashResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SplashResponse> CREATOR = new a();
    private String os;
    private String pic;
    private String pic2;
    private String schema;
    private String scm;

    /* compiled from: Taobao */
    public class a implements Parcelable.Creator<SplashResponse> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public SplashResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2030952657")) {
                return new SplashResponse(parcel);
            }
            return (SplashResponse) ipChange.ipc$dispatch("-2030952657", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public SplashResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-672415856")) {
                return new SplashResponse[i];
            }
            return (SplashResponse[]) ipChange.ipc$dispatch("-672415856", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public SplashResponse() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1493990613")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1493990613", new Object[]{this})).intValue();
    }

    public String getOs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "324337079")) {
            return this.os;
        }
        return (String) ipChange.ipc$dispatch("324337079", new Object[]{this});
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1390025907")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-1390025907", new Object[]{this});
    }

    public String getPic2() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-617454661")) {
            return this.pic2;
        }
        return (String) ipChange.ipc$dispatch("-617454661", new Object[]{this});
    }

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1021223156")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("1021223156", new Object[]{this});
    }

    public String getScm() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-493754784")) {
            return this.scm;
        }
        return (String) ipChange.ipc$dispatch("-493754784", new Object[]{this});
    }

    public void setOs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305867015")) {
            ipChange.ipc$dispatch("305867015", new Object[]{this, str});
            return;
        }
        this.os = str;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277417929")) {
            ipChange.ipc$dispatch("1277417929", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public void setPic2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040985219")) {
            ipChange.ipc$dispatch("2040985219", new Object[]{this, str});
            return;
        }
        this.pic2 = str;
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "198054762")) {
            ipChange.ipc$dispatch("198054762", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public void setScm(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002948330")) {
            ipChange.ipc$dispatch("-1002948330", new Object[]{this, str});
            return;
        }
        this.scm = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662489450")) {
            ipChange.ipc$dispatch("-1662489450", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.schema);
        parcel.writeString(this.os);
        parcel.writeString(this.pic);
        parcel.writeString(this.scm);
        parcel.writeString(this.pic2);
    }

    protected SplashResponse(Parcel parcel) {
        this.schema = parcel.readString();
        this.os = parcel.readString();
        this.pic = parcel.readString();
        this.scm = parcel.readString();
        this.pic2 = parcel.readString();
    }
}
