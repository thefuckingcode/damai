package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ThemeBannerBean implements BannerItem, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String dispatchTaskId;
    public String id;
    public String joinTotal;
    public String name;
    public String pic;
    public String subTitle;
    public String themePrize;
    public String themeType;
    public String type;
    public String url;

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1677996175")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-1677996175", new Object[]{this});
    }

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145731911")) {
            return (String) ipChange.ipc$dispatch("-2145731911", new Object[]{this});
        } else if (isH5()) {
            return this.url;
        } else {
            if (!isTheme() || TextUtils.isEmpty(this.id)) {
                return null;
            }
            if (TextUtils.equals("1", this.themeType)) {
                return "damai://V1/DiscoverThemePage?themeId=" + this.id;
            }
            if (TextUtils.equals("2", this.themeType)) {
                return "damai://V1/DiscoverCircleThemePage?themeId=" + this.id;
            }
            return null;
        }
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166783676")) {
            return (String) ipChange.ipc$dispatch("-1166783676", new Object[]{this});
        } else if (isH5()) {
            return this.subTitle;
        } else {
            if (isTheme()) {
                return this.joinTotal;
            }
            return null;
        }
    }

    public String getTagText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-103352687")) {
            return (String) ipChange.ipc$dispatch("-103352687", new Object[]{this});
        } else if (!isTheme() || !TextUtils.equals(this.themePrize, "1")) {
            return null;
        } else {
            return "有奖";
        }
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1711236674")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("1711236674", new Object[]{this});
    }

    public boolean isH5() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1095712909")) {
            return TextUtils.equals("3", this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("1095712909", new Object[]{this})).booleanValue();
    }

    public boolean isOldTheme() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-743318376")) {
            return isTheme() && TextUtils.equals("1", this.themeType);
        }
        return ((Boolean) ipChange.ipc$dispatch("-743318376", new Object[]{this})).booleanValue();
    }

    public boolean isTheme() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-101697425")) {
            return TextUtils.equals("2", this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("-101697425", new Object[]{this})).booleanValue();
    }
}
