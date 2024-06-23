package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DivisionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DivisionBean> CREATOR = new Parcelable.Creator<DivisionBean>() {
        /* class cn.damai.commonbusiness.address.bean.DivisionBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DivisionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "535853139")) {
                return new DivisionBean(parcel);
            }
            return (DivisionBean) ipChange.ipc$dispatch("535853139", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DivisionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2093323632")) {
                return new DivisionBean[i];
            }
            return (DivisionBean[]) ipChange.ipc$dispatch("-2093323632", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String damaiDivisionId;
    private String damaiDivisionName;
    private String divisionAbbName;
    private String divisionId;
    private String divisionLevel;
    private String divisionName;
    private String divisionZip;
    private String handTag;
    private String parentId;
    private String pinyin;

    public DivisionBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2027308227")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2027308227", new Object[]{this})).intValue();
    }

    public String getDamaiDivisionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-465514347")) {
            return this.damaiDivisionId;
        }
        return (String) ipChange.ipc$dispatch("-465514347", new Object[]{this});
    }

    public String getDamaiDivisionName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-611805627")) {
            return this.damaiDivisionName;
        }
        return (String) ipChange.ipc$dispatch("-611805627", new Object[]{this});
    }

    public String getDivisionAbbName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-604106828")) {
            return this.divisionAbbName;
        }
        return (String) ipChange.ipc$dispatch("-604106828", new Object[]{this});
    }

    public String getDivisionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-45322263")) {
            return this.divisionId;
        }
        return (String) ipChange.ipc$dispatch("-45322263", new Object[]{this});
    }

    public String getDivisionLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1723065324")) {
            return this.divisionLevel;
        }
        return (String) ipChange.ipc$dispatch("1723065324", new Object[]{this});
    }

    public String getDivisionName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-534138727")) {
            return this.divisionName;
        }
        return (String) ipChange.ipc$dispatch("-534138727", new Object[]{this});
    }

    public String getDivisionZip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "718320201")) {
            return this.divisionZip;
        }
        return (String) ipChange.ipc$dispatch("718320201", new Object[]{this});
    }

    public String getHandTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-643715264")) {
            return this.handTag;
        }
        return (String) ipChange.ipc$dispatch("-643715264", new Object[]{this});
    }

    public String getParentId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "475586982")) {
            return this.parentId;
        }
        return (String) ipChange.ipc$dispatch("475586982", new Object[]{this});
    }

    public String getPinyin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2049346410")) {
            return this.pinyin;
        }
        return (String) ipChange.ipc$dispatch("2049346410", new Object[]{this});
    }

    public void setDamaiDivisionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264229503")) {
            ipChange.ipc$dispatch("-1264229503", new Object[]{this, str});
            return;
        }
        this.damaiDivisionId = str;
    }

    public void setDamaiDivisionName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775110447")) {
            ipChange.ipc$dispatch("-775110447", new Object[]{this, str});
            return;
        }
        this.damaiDivisionName = str;
    }

    public void setDivisionAbbName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265629118")) {
            ipChange.ipc$dispatch("-1265629118", new Object[]{this, str});
            return;
        }
        this.divisionAbbName = str;
    }

    public void setDivisionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780093717")) {
            ipChange.ipc$dispatch("780093717", new Object[]{this, str});
            return;
        }
        this.divisionId = str;
    }

    public void setDivisionLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6753802")) {
            ipChange.ipc$dispatch("6753802", new Object[]{this, str});
            return;
        }
        this.divisionLevel = str;
    }

    public void setDivisionName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1019449701")) {
            ipChange.ipc$dispatch("1019449701", new Object[]{this, str});
            return;
        }
        this.divisionName = str;
    }

    public void setDivisionZip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506861491")) {
            ipChange.ipc$dispatch("-1506861491", new Object[]{this, str});
            return;
        }
        this.divisionZip = str;
    }

    public void setHandTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96590282")) {
            ipChange.ipc$dispatch("-96590282", new Object[]{this, str});
            return;
        }
        this.handTag = str;
    }

    public void setParentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975966712")) {
            ipChange.ipc$dispatch("1975966712", new Object[]{this, str});
            return;
        }
        this.parentId = str;
    }

    public void setPinyin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005104564")) {
            ipChange.ipc$dispatch("2005104564", new Object[]{this, str});
            return;
        }
        this.pinyin = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245743208")) {
            ipChange.ipc$dispatch("245743208", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.damaiDivisionId);
        parcel.writeString(this.damaiDivisionName);
        parcel.writeString(this.divisionAbbName);
        parcel.writeString(this.divisionId);
        parcel.writeString(this.divisionLevel);
        parcel.writeString(this.divisionName);
        parcel.writeString(this.divisionZip);
        parcel.writeString(this.handTag);
        parcel.writeString(this.parentId);
        parcel.writeString(this.pinyin);
    }

    protected DivisionBean(Parcel parcel) {
        this.damaiDivisionId = parcel.readString();
        this.damaiDivisionName = parcel.readString();
        this.divisionAbbName = parcel.readString();
        this.divisionId = parcel.readString();
        this.divisionLevel = parcel.readString();
        this.divisionName = parcel.readString();
        this.divisionZip = parcel.readString();
        this.handTag = parcel.readString();
        this.parentId = parcel.readString();
        this.pinyin = parcel.readString();
    }
}
