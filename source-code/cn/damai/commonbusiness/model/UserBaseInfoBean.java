package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserBaseInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UserBaseInfoBean> CREATOR = new Parcelable.Creator<UserBaseInfoBean>() {
        /* class cn.damai.commonbusiness.model.UserBaseInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public UserBaseInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1708673323")) {
                return new UserBaseInfoBean(parcel);
            }
            return (UserBaseInfoBean) ipChange.ipc$dispatch("1708673323", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public UserBaseInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1026280548")) {
                return new UserBaseInfoBean[i];
            }
            return (UserBaseInfoBean[]) ipChange.ipc$dispatch("-1026280548", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String birthday;
    private String headImg;
    private boolean isVip;
    private String maskEmail;
    private String maskMobile;
    private String mobile;
    private String nationPrefix;
    private String nickname;
    private int sex;
    private int userId;
    private String userIntro;
    private String vipLevel;
    private String vipLevelIcon;
    private String vtag;

    protected UserBaseInfoBean(Parcel parcel) {
        this.headImg = parcel.readString();
        this.maskMobile = parcel.readString();
        this.mobile = parcel.readString();
        this.nationPrefix = parcel.readString();
        this.nickname = parcel.readString();
        this.userId = parcel.readInt();
        this.vtag = parcel.readString();
        this.maskEmail = parcel.readString();
        this.isVip = parcel.readByte() != 0;
        this.vipLevel = parcel.readString();
        this.vipLevelIcon = parcel.readString();
        this.sex = parcel.readInt();
        this.birthday = parcel.readString();
        this.userIntro = parcel.readString();
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1533819244")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1533819244", new Object[]{this})).intValue();
    }

    public String getBirthday() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1778288665")) {
            return this.birthday;
        }
        return (String) ipChange.ipc$dispatch("-1778288665", new Object[]{this});
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-857345009")) {
            return this.headImg;
        }
        return (String) ipChange.ipc$dispatch("-857345009", new Object[]{this});
    }

    public String getMaskEmail() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1306750564")) {
            return this.maskEmail;
        }
        return (String) ipChange.ipc$dispatch("-1306750564", new Object[]{this});
    }

    public String getMaskMobile() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "179775960")) {
            return this.maskMobile;
        }
        return (String) ipChange.ipc$dispatch("179775960", new Object[]{this});
    }

    public String getMobile() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-294675124")) {
            return this.mobile;
        }
        return (String) ipChange.ipc$dispatch("-294675124", new Object[]{this});
    }

    public String getNationPrefix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-388066141")) {
            return this.nationPrefix;
        }
        return (String) ipChange.ipc$dispatch("-388066141", new Object[]{this});
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2049268568")) {
            return this.nickname;
        }
        return (String) ipChange.ipc$dispatch("2049268568", new Object[]{this});
    }

    public int getSex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "988267169")) {
            return this.sex;
        }
        return ((Integer) ipChange.ipc$dispatch("988267169", new Object[]{this})).intValue();
    }

    public int getUserId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1242270115")) {
            return this.userId;
        }
        return ((Integer) ipChange.ipc$dispatch("1242270115", new Object[]{this})).intValue();
    }

    public String getUserIntro() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1153443949")) {
            return this.userIntro;
        }
        return (String) ipChange.ipc$dispatch("1153443949", new Object[]{this});
    }

    public String getVipLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1960962513")) {
            return this.vipLevel;
        }
        return (String) ipChange.ipc$dispatch("1960962513", new Object[]{this});
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-882908950")) {
            return this.vipLevelIcon;
        }
        return (String) ipChange.ipc$dispatch("-882908950", new Object[]{this});
    }

    public String getVtag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1799218894")) {
            return this.vtag;
        }
        return (String) ipChange.ipc$dispatch("1799218894", new Object[]{this});
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1798528899")) {
            return this.isVip;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1798528899", new Object[]{this})).booleanValue();
    }

    public void setBirthday(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825298391")) {
            ipChange.ipc$dispatch("825298391", new Object[]{this, str});
            return;
        }
        this.birthday = str;
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870822215")) {
            ipChange.ipc$dispatch("1870822215", new Object[]{this, str});
            return;
        }
        this.headImg = str;
    }

    public void setMaskEmail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475200602")) {
            ipChange.ipc$dispatch("475200602", new Object[]{this, str});
            return;
        }
        this.maskEmail = str;
    }

    public void setMaskMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831795962")) {
            ipChange.ipc$dispatch("-831795962", new Object[]{this, str});
            return;
        }
        this.maskMobile = str;
    }

    public void setMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940086254")) {
            ipChange.ipc$dispatch("-1940086254", new Object[]{this, str});
            return;
        }
        this.mobile = str;
    }

    public void setNationPrefix(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252732571")) {
            ipChange.ipc$dispatch("1252732571", new Object[]{this, str});
            return;
        }
        this.nationPrefix = str;
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779511674")) {
            ipChange.ipc$dispatch("-779511674", new Object[]{this, str});
            return;
        }
        this.nickname = str;
    }

    public void setSex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786621047")) {
            ipChange.ipc$dispatch("-1786621047", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.sex = i;
    }

    public void setUserId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629828959")) {
            ipChange.ipc$dispatch("629828959", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.userId = i;
    }

    public void setUserIntro(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568180823")) {
            ipChange.ipc$dispatch("-568180823", new Object[]{this, str});
            return;
        }
        this.userIntro = str;
    }

    public void setVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983034769")) {
            ipChange.ipc$dispatch("983034769", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isVip = z;
    }

    public void setVipLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777967917")) {
            ipChange.ipc$dispatch("777967917", new Object[]{this, str});
            return;
        }
        this.vipLevel = str;
    }

    public void setVipLevelIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202492620")) {
            ipChange.ipc$dispatch("-1202492620", new Object[]{this, str});
            return;
        }
        this.vipLevelIcon = str;
    }

    public void setVtag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351545904")) {
            ipChange.ipc$dispatch("-351545904", new Object[]{this, str});
            return;
        }
        this.vtag = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662400801")) {
            ipChange.ipc$dispatch("-662400801", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.headImg);
        parcel.writeString(this.maskMobile);
        parcel.writeString(this.mobile);
        parcel.writeString(this.nationPrefix);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.userId);
        parcel.writeString(this.vtag);
        parcel.writeString(this.maskEmail);
        parcel.writeByte(this.isVip ? (byte) 1 : 0);
        parcel.writeString(this.vipLevel);
        parcel.writeString(this.vipLevelIcon);
        parcel.writeInt(this.sex);
        parcel.writeString(this.birthday);
        parcel.writeString(this.userIntro);
    }

    public UserBaseInfoBean() {
    }
}
