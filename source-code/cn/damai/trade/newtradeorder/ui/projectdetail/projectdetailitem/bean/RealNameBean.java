package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class RealNameBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameBean> CREATOR = new Parcelable.Creator<RealNameBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RealNameBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1121349791")) {
                return new RealNameBean(parcel);
            }
            return (RealNameBean) ipChange.ipc$dispatch("-1121349791", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RealNameBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1853657392")) {
                return new RealNameBean[i];
            }
            return (RealNameBean[]) ipChange.ipc$dispatch("1853657392", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<CredentialNames> credentialNames;
    private RealNamePopup realNamePopup;
    private String type;

    /* compiled from: Taobao */
    public static class CredentialNames implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<CredentialNames> CREATOR = new Parcelable.Creator<CredentialNames>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameBean.CredentialNames.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public CredentialNames createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1840747335")) {
                    return new CredentialNames(parcel);
                }
                return (CredentialNames) ipChange.ipc$dispatch("1840747335", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public CredentialNames[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1060759984")) {
                    return new CredentialNames[i];
                }
                return (CredentialNames[]) ipChange.ipc$dispatch("-1060759984", new Object[]{this, Integer.valueOf(i)});
            }
        };
        String id;
        String name;

        public CredentialNames() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-38156279")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-38156279", new Object[]{this})).intValue();
        }

        public String getId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "273239970")) {
                return this.id;
            }
            return (String) ipChange.ipc$dispatch("273239970", new Object[]{this});
        }

        public String getName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "661489170")) {
                return this.name;
            }
            return (String) ipChange.ipc$dispatch("661489170", new Object[]{this});
        }

        public void readFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1652172571")) {
                ipChange.ipc$dispatch("1652172571", new Object[]{this, parcel});
                return;
            }
            this.id = parcel.readString();
            this.name = parcel.readString();
        }

        public void setId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1278143364")) {
                ipChange.ipc$dispatch("-1278143364", new Object[]{this, str});
                return;
            }
            this.id = str;
        }

        public void setName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1261428980")) {
                ipChange.ipc$dispatch("-1261428980", new Object[]{this, str});
                return;
            }
            this.name = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-222531614")) {
                ipChange.ipc$dispatch("-222531614", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.id);
            parcel.writeString(this.name);
        }

        protected CredentialNames(Parcel parcel) {
            this.id = parcel.readString();
            this.name = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    public static class RealNamePopup implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<RealNamePopup> CREATOR = new Parcelable.Creator<RealNamePopup>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameBean.RealNamePopup.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public RealNamePopup createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1257817571")) {
                    return new RealNamePopup(parcel);
                }
                return (RealNamePopup) ipChange.ipc$dispatch("1257817571", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public RealNamePopup[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1598871088")) {
                    return new RealNamePopup[i];
                }
                return (RealNamePopup[]) ipChange.ipc$dispatch("-1598871088", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private String desc;
        private String title;

        public RealNamePopup() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "818193019")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("818193019", new Object[]{this})).intValue();
        }

        public String getDesc() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1545540490")) {
                return this.desc;
            }
            return (String) ipChange.ipc$dispatch("1545540490", new Object[]{this});
        }

        public String getTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-976725963")) {
                return this.title;
            }
            return (String) ipChange.ipc$dispatch("-976725963", new Object[]{this});
        }

        public void setDesc(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "374358164")) {
                ipChange.ipc$dispatch("374358164", new Object[]{this, str});
                return;
            }
            this.desc = str;
        }

        public void setTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2017333535")) {
                ipChange.ipc$dispatch("-2017333535", new Object[]{this, str});
                return;
            }
            this.title = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1200126032")) {
                ipChange.ipc$dispatch("-1200126032", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.title);
            parcel.writeString(this.desc);
        }

        protected RealNamePopup(Parcel parcel) {
            this.title = parcel.readString();
            this.desc = parcel.readString();
        }
    }

    public RealNameBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-587060900")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-587060900", new Object[]{this})).intValue();
    }

    public List<CredentialNames> getCredentialNames() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1701697140")) {
            return this.credentialNames;
        }
        return (List) ipChange.ipc$dispatch("1701697140", new Object[]{this});
    }

    public RealNamePopup getRealNamePopup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1780586302")) {
            return this.realNamePopup;
        }
        return (RealNamePopup) ipChange.ipc$dispatch("-1780586302", new Object[]{this});
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1355428972")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("-1355428972", new Object[]{this});
    }

    public boolean isRealName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "115714015")) {
            return "1".equals(this.type) || "2".equals(this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("115714015", new Object[]{this})).booleanValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30656984")) {
            ipChange.ipc$dispatch("-30656984", new Object[]{this, parcel});
            return;
        }
        this.realNamePopup = (RealNamePopup) parcel.readParcelable(RealNamePopup.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.credentialNames = arrayList;
        parcel.readList(arrayList, CredentialNames.class.getClassLoader());
        this.type = parcel.readString();
    }

    public void setCredentialNames(List<CredentialNames> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249886832")) {
            ipChange.ipc$dispatch("249886832", new Object[]{this, list});
            return;
        }
        this.credentialNames = list;
    }

    public void setRealNamePopup(RealNamePopup realNamePopup2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975858588")) {
            ipChange.ipc$dispatch("-975858588", new Object[]{this, realNamePopup2});
            return;
        }
        this.realNamePopup = realNamePopup2;
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638618058")) {
            ipChange.ipc$dispatch("638618058", new Object[]{this, str});
            return;
        }
        this.type = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905361169")) {
            ipChange.ipc$dispatch("-1905361169", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.realNamePopup, i);
        parcel.writeList(this.credentialNames);
        parcel.writeString(this.type);
    }

    protected RealNameBean(Parcel parcel) {
        this.realNamePopup = (RealNamePopup) parcel.readParcelable(RealNamePopup.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.credentialNames = arrayList;
        parcel.readList(arrayList, CredentialNames.class.getClassLoader());
    }
}
