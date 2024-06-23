package cn.damai.user.userprofile.cuser.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class CUser {
    private static transient /* synthetic */ IpChange $ipChange;
    public String birthday;
    public String city;
    private List<CommonFavObject> commonArtist;
    private List<CommonFavObject> commonProject;
    public String county;
    private DynamicsList dynamicsList;
    private List<String> fansImg;
    private String fansNum;
    private int favoriteFlag;
    private FocusList focusList;
    private List<String> followImg;
    private String followNum;
    public String headBgImg;
    private String headImg;
    private String sex;
    public String summary;
    private String userId;
    public String userNick;
    public boolean vaccount;

    public String getAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163416735")) {
            return (String) ipChange.ipc$dispatch("1163416735", new Object[]{this});
        } else if (!xf2.j(this.county) && !xf2.j(this.city)) {
            return this.county + " / " + this.city;
        } else if (!xf2.j(this.county)) {
            return this.county;
        } else {
            return !xf2.j(this.city) ? this.city : "";
        }
    }

    public String getBirthday() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "521750248")) {
            return this.birthday;
        }
        return (String) ipChange.ipc$dispatch("521750248", new Object[]{this});
    }

    public List<CommonFavObject> getCommonArtist() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1809523172")) {
            return this.commonArtist;
        }
        return (List) ipChange.ipc$dispatch("1809523172", new Object[]{this});
    }

    public List<CommonFavObject> getCommonProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "591901248")) {
            return this.commonProject;
        }
        return (List) ipChange.ipc$dispatch("591901248", new Object[]{this});
    }

    public DynamicsList getDynamicsList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "242988638")) {
            return this.dynamicsList;
        }
        return (DynamicsList) ipChange.ipc$dispatch("242988638", new Object[]{this});
    }

    public List<String> getFansImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1061829685")) {
            return this.fansImg;
        }
        return (List) ipChange.ipc$dispatch("1061829685", new Object[]{this});
    }

    public String getFansNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1689833647")) {
            return this.fansNum;
        }
        return (String) ipChange.ipc$dispatch("-1689833647", new Object[]{this});
    }

    public int getFavoriteFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1162400800")) {
            return this.favoriteFlag;
        }
        return ((Integer) ipChange.ipc$dispatch("1162400800", new Object[]{this})).intValue();
    }

    public FocusList getFocusList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2142657108")) {
            return this.focusList;
        }
        return (FocusList) ipChange.ipc$dispatch("2142657108", new Object[]{this});
    }

    public List<String> getFollowImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "903393508")) {
            return this.followImg;
        }
        return (List) ipChange.ipc$dispatch("903393508", new Object[]{this});
    }

    public String getFollowNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "671822912")) {
            return this.followNum;
        }
        return (String) ipChange.ipc$dispatch("671822912", new Object[]{this});
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1475886866")) {
            return this.headImg;
        }
        return (String) ipChange.ipc$dispatch("-1475886866", new Object[]{this});
    }

    public String getSex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-297322479")) {
            return this.sex;
        }
        return (String) ipChange.ipc$dispatch("-297322479", new Object[]{this});
    }

    public String getUserId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "871275569")) {
            return this.userId;
        }
        return (String) ipChange.ipc$dispatch("871275569", new Object[]{this});
    }

    public void setBirthday(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887939338")) {
            ipChange.ipc$dispatch("-887939338", new Object[]{this, str});
            return;
        }
        this.birthday = str;
    }

    public void setCommonArtist(List<CommonFavObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943693208")) {
            ipChange.ipc$dispatch("-943693208", new Object[]{this, list});
            return;
        }
        this.commonArtist = list;
    }

    public void setCommonProject(List<CommonFavObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225335004")) {
            ipChange.ipc$dispatch("-225335004", new Object[]{this, list});
            return;
        }
        this.commonProject = list;
    }

    public void setDynamicsList(DynamicsList dynamicsList2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023193068")) {
            ipChange.ipc$dispatch("-1023193068", new Object[]{this, dynamicsList2});
            return;
        }
        this.dynamicsList = dynamicsList2;
    }

    public void setFansImg(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953896143")) {
            ipChange.ipc$dispatch("1953896143", new Object[]{this, list});
            return;
        }
        this.fansImg = list;
    }

    public void setFansNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833478213")) {
            ipChange.ipc$dispatch("1833478213", new Object[]{this, str});
            return;
        }
        this.fansNum = str;
    }

    public void setFavoriteFlag(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130988418")) {
            ipChange.ipc$dispatch("130988418", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.favoriteFlag = i;
    }

    public void setFocusList(FocusList focusList2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036321128")) {
            ipChange.ipc$dispatch("2036321128", new Object[]{this, focusList2});
            return;
        }
        this.focusList = focusList2;
    }

    public void setFollowImg(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524688128")) {
            ipChange.ipc$dispatch("1524688128", new Object[]{this, list});
            return;
        }
        this.followImg = list;
    }

    public void setFollowNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681436214")) {
            ipChange.ipc$dispatch("1681436214", new Object[]{this, str});
            return;
        }
        this.followNum = str;
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124106168")) {
            ipChange.ipc$dispatch("-124106168", new Object[]{this, str});
            return;
        }
        this.headImg = str;
    }

    public void setSex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791485829")) {
            ipChange.ipc$dispatch("791485829", new Object[]{this, str});
            return;
        }
        this.sex = str;
    }

    public void setUserId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155353139")) {
            ipChange.ipc$dispatch("-155353139", new Object[]{this, str});
            return;
        }
        this.userId = str;
    }
}
