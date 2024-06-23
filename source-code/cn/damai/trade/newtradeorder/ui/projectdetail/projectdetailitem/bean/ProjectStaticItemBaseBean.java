package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ProjectStaticItemBaseBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticItemBaseBean> CREATOR = new Parcelable.Creator<ProjectStaticItemBaseBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectStaticItemBaseBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1709810197")) {
                return new ProjectStaticItemBaseBean(parcel);
            }
            return (ProjectStaticItemBaseBean) ipChange.ipc$dispatch("-1709810197", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectStaticItemBaseBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1190414952")) {
                return new ProjectStaticItemBaseBean[i];
            }
            return (ProjectStaticItemBaseBean[]) ipChange.ipc$dispatch("1190414952", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public int atomSplit = 1;
    public long categoryId;
    public GeneralAgentBean generalAgent;
    public String hasNoneSeatImg;
    public boolean hasServiceFee;
    public String hasSkuPopup;
    public String isHotProject;
    public String isShowHotProjectModel;
    public long itemId;
    public String itemName;
    public ItemPics itemPics;
    public int itemType;
    public String nationalStandardCityId;
    public int oldCompanyId;
    public ArrayList<PerformSeatImageBean> performSeatImages;
    public String projectStatus;
    public List<String> seatImages;
    public ArrayList<ServiceNote> serviceNotes;
    public long sfpt;
    public String sfptPrefix;
    public String sfptSuffix;
    public String sfptTip;
    public String showDuration;
    public List<String> showTag;
    public String showTime;
    public String subTitle;

    /* compiled from: Taobao */
    public static class GeneralAgentBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<GeneralAgentBean> CREATOR = new Parcelable.Creator<GeneralAgentBean>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean.GeneralAgentBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public GeneralAgentBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-445736793")) {
                    return new GeneralAgentBean(parcel);
                }
                return (GeneralAgentBean) ipChange.ipc$dispatch("-445736793", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public GeneralAgentBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "102190096")) {
                    return new GeneralAgentBean[i];
                }
                return (GeneralAgentBean[]) ipChange.ipc$dispatch("102190096", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private String description;
        private String generalAgent;
        private int generalType;

        public GeneralAgentBean() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "474891033")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("474891033", new Object[]{this})).intValue();
        }

        public String getDescription() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1104542203")) {
                return this.description;
            }
            return (String) ipChange.ipc$dispatch("1104542203", new Object[]{this});
        }

        public String getGeneralAgent() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-29009772")) {
                return this.generalAgent;
            }
            return (String) ipChange.ipc$dispatch("-29009772", new Object[]{this});
        }

        public int getGeneralType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "808717106")) {
                return this.generalType;
            }
            return ((Integer) ipChange.ipc$dispatch("808717106", new Object[]{this})).intValue();
        }

        public void setDescription(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1876085979")) {
                ipChange.ipc$dispatch("1876085979", new Object[]{this, str});
                return;
            }
            this.description = str;
        }

        public void setGeneralAgent(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-501421878")) {
                ipChange.ipc$dispatch("-501421878", new Object[]{this, str});
                return;
            }
            this.generalAgent = str;
        }

        public void setGeneralType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "220490008")) {
                ipChange.ipc$dispatch("220490008", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.generalType = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1351911726")) {
                ipChange.ipc$dispatch("-1351911726", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.description);
            parcel.writeString(this.generalAgent);
            parcel.writeInt(this.generalType);
        }

        protected GeneralAgentBean(Parcel parcel) {
            this.description = parcel.readString();
            this.generalAgent = parcel.readString();
            this.generalType = parcel.readInt();
        }
    }

    public ProjectStaticItemBaseBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1277207098")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1277207098", new Object[]{this})).intValue();
    }

    public int getAtomSplit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "914584056")) {
            return this.atomSplit;
        }
        return ((Integer) ipChange.ipc$dispatch("914584056", new Object[]{this})).intValue();
    }

    public long getCategoryId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1361755721")) {
            return this.categoryId;
        }
        return ((Long) ipChange.ipc$dispatch("-1361755721", new Object[]{this})).longValue();
    }

    public GeneralAgentBean getGeneralAgent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1320153502")) {
            return this.generalAgent;
        }
        return (GeneralAgentBean) ipChange.ipc$dispatch("-1320153502", new Object[]{this});
    }

    public Boolean getHasServiceFee() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "854810240")) {
            return Boolean.valueOf(this.hasServiceFee);
        }
        return (Boolean) ipChange.ipc$dispatch("854810240", new Object[]{this});
    }

    public String getHasSkuPopup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1421282683")) {
            return this.hasSkuPopup;
        }
        return (String) ipChange.ipc$dispatch("1421282683", new Object[]{this});
    }

    public String getIsHotProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-619593062")) {
            return this.isHotProject;
        }
        return (String) ipChange.ipc$dispatch("-619593062", new Object[]{this});
    }

    public String getIsShowHotProjectModel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "42107944")) {
            return this.isShowHotProjectModel;
        }
        return (String) ipChange.ipc$dispatch("42107944", new Object[]{this});
    }

    public long getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1391397822")) {
            return this.itemId;
        }
        return ((Long) ipChange.ipc$dispatch("-1391397822", new Object[]{this})).longValue();
    }

    public String getItemName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1398456450")) {
            return this.itemName;
        }
        return (String) ipChange.ipc$dispatch("1398456450", new Object[]{this});
    }

    public ItemPics getItemPics() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1966094649")) {
            return this.itemPics;
        }
        return (ItemPics) ipChange.ipc$dispatch("1966094649", new Object[]{this});
    }

    public List<PerformSeatImageBean> getListPerformSeatImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1540092154")) {
            return this.performSeatImages;
        }
        return (List) ipChange.ipc$dispatch("-1540092154", new Object[]{this});
    }

    public List<String> getListSeatImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-246215463")) {
            return this.seatImages;
        }
        return (List) ipChange.ipc$dispatch("-246215463", new Object[]{this});
    }

    public String getNationalStandardCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-324080039")) {
            return this.nationalStandardCityId;
        }
        return (String) ipChange.ipc$dispatch("-324080039", new Object[]{this});
    }

    public ArrayList<ServiceNote> getServiceNotes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "726059178")) {
            return this.serviceNotes;
        }
        return (ArrayList) ipChange.ipc$dispatch("726059178", new Object[]{this});
    }

    public long getSfpt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "277537113")) {
            return this.sfpt;
        }
        return ((Long) ipChange.ipc$dispatch("277537113", new Object[]{this})).longValue();
    }

    public String getSfptPrefix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1755943027")) {
            return this.sfptPrefix;
        }
        return (String) ipChange.ipc$dispatch("-1755943027", new Object[]{this});
    }

    public String getSfptTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-319406922")) {
            return this.sfptTip;
        }
        return (String) ipChange.ipc$dispatch("-319406922", new Object[]{this});
    }

    public String getShowDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1775780875")) {
            return this.showDuration;
        }
        return (String) ipChange.ipc$dispatch("-1775780875", new Object[]{this});
    }

    public List<String> getShowTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "253213046")) {
            return this.showTag;
        }
        return (List) ipChange.ipc$dispatch("253213046", new Object[]{this});
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2119260754")) {
            return this.showTime;
        }
        return (String) ipChange.ipc$dispatch("-2119260754", new Object[]{this});
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1780133060")) {
            return this.subTitle;
        }
        return (String) ipChange.ipc$dispatch("-1780133060", new Object[]{this});
    }

    public boolean isHasNoneSeatImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "235543878")) {
            return !TextUtils.isEmpty(this.hasNoneSeatImg) && this.hasNoneSeatImg.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("235543878", new Object[]{this})).booleanValue();
    }

    public boolean isHasSkuPopup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1808594871")) {
            return TextUtils.equals("true", this.hasSkuPopup);
        }
        return ((Boolean) ipChange.ipc$dispatch("1808594871", new Object[]{this})).booleanValue();
    }

    public boolean isProjectCancel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "872205581")) {
            return !TextUtils.isEmpty(this.projectStatus) && this.projectStatus.equals("3");
        }
        return ((Boolean) ipChange.ipc$dispatch("872205581", new Object[]{this})).booleanValue();
    }

    public boolean isProjectNATType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1102068464")) {
            return this.itemType == 4;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1102068464", new Object[]{this})).booleanValue();
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "591733502")) {
            ipChange.ipc$dispatch("591733502", new Object[]{this, parcel});
            return;
        }
        this.categoryId = parcel.readLong();
        this.atomSplit = parcel.readInt();
        this.isShowHotProjectModel = parcel.readString();
        this.projectStatus = parcel.readString();
        this.itemType = parcel.readInt();
        this.isHotProject = parcel.readString();
        this.generalAgent = (GeneralAgentBean) parcel.readParcelable(GeneralAgentBean.class.getClassLoader());
        this.itemId = parcel.readLong();
        this.itemName = parcel.readString();
        this.itemPics = (ItemPics) parcel.readParcelable(ItemPics.class.getClassLoader());
        this.seatImages = parcel.createStringArrayList();
        this.performSeatImages = parcel.createTypedArrayList(PerformSeatImageBean.CREATOR);
        this.hasNoneSeatImg = parcel.readString();
        this.nationalStandardCityId = parcel.readString();
        this.oldCompanyId = parcel.readInt();
        this.showTime = parcel.readString();
        this.subTitle = parcel.readString();
        this.showDuration = parcel.readString();
        this.hasSkuPopup = parcel.readString();
        this.showTag = parcel.createStringArrayList();
        this.serviceNotes = parcel.createTypedArrayList(ServiceNote.CREATOR);
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.hasServiceFee = z;
        this.sfpt = parcel.readLong();
        this.sfptPrefix = parcel.readString();
        this.sfptTip = parcel.readString();
    }

    public void setAtomSplit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750888978")) {
            ipChange.ipc$dispatch("750888978", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.atomSplit = i;
    }

    public void setCategoryId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204876435")) {
            ipChange.ipc$dispatch("-204876435", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.categoryId = j;
    }

    public void setItemId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590502466")) {
            ipChange.ipc$dispatch("590502466", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.itemId = j;
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154901776")) {
            ipChange.ipc$dispatch("-1154901776", new Object[]{this, str});
            return;
        }
        this.showTime = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282970683")) {
            ipChange.ipc$dispatch("-1282970683", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.categoryId);
        parcel.writeInt(this.atomSplit);
        parcel.writeString(this.isShowHotProjectModel);
        parcel.writeString(this.projectStatus);
        parcel.writeInt(this.itemType);
        parcel.writeString(this.isHotProject);
        parcel.writeParcelable(this.generalAgent, i);
        parcel.writeLong(this.itemId);
        parcel.writeString(this.itemName);
        parcel.writeParcelable(this.itemPics, i);
        parcel.writeStringList(this.seatImages);
        parcel.writeTypedList(this.performSeatImages);
        parcel.writeString(this.hasNoneSeatImg);
        parcel.writeString(this.nationalStandardCityId);
        parcel.writeInt(this.oldCompanyId);
        parcel.writeString(this.showTime);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.showDuration);
        parcel.writeString(this.hasSkuPopup);
        parcel.writeStringList(this.showTag);
        parcel.writeTypedList(this.serviceNotes);
        parcel.writeByte(this.hasServiceFee ? (byte) 1 : 0);
        parcel.writeLong(this.sfpt);
        parcel.writeString(this.sfptPrefix);
        parcel.writeString(this.sfptTip);
    }

    protected ProjectStaticItemBaseBean(Parcel parcel) {
        boolean z = true;
        this.categoryId = parcel.readLong();
        this.atomSplit = parcel.readInt();
        this.isShowHotProjectModel = parcel.readString();
        this.projectStatus = parcel.readString();
        this.itemType = parcel.readInt();
        this.isHotProject = parcel.readString();
        this.generalAgent = (GeneralAgentBean) parcel.readParcelable(GeneralAgentBean.class.getClassLoader());
        this.itemId = parcel.readLong();
        this.itemName = parcel.readString();
        this.itemPics = (ItemPics) parcel.readParcelable(ItemPics.class.getClassLoader());
        this.seatImages = parcel.createStringArrayList();
        this.performSeatImages = parcel.createTypedArrayList(PerformSeatImageBean.CREATOR);
        this.hasNoneSeatImg = parcel.readString();
        this.nationalStandardCityId = parcel.readString();
        this.oldCompanyId = parcel.readInt();
        this.showTime = parcel.readString();
        this.subTitle = parcel.readString();
        this.showDuration = parcel.readString();
        this.hasSkuPopup = parcel.readString();
        this.showTag = parcel.createStringArrayList();
        this.serviceNotes = parcel.createTypedArrayList(ServiceNote.CREATOR);
        this.hasServiceFee = parcel.readByte() == 0 ? false : z;
        this.sfpt = parcel.readLong();
        this.sfptPrefix = parcel.readString();
        this.sfptTip = parcel.readString();
    }
}
