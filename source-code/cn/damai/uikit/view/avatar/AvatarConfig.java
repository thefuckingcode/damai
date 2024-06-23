package cn.damai.uikit.view.avatar;

import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class AvatarConfig implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean clearDrawableWhenDiffUrlSet = true;
    public int innerBorderDrawableRid = R$drawable.uikit_dm_avatar_inner_border;
    public int outBorderDrawableRid = -1;
    public int placeHolderDrawableRid = R$drawable.uikit_account_place_holder_default;
    public boolean showOutBorder = false;
    public boolean showVTag = false;
    public int yyTagDrawableRid = -1;

    public AvatarConfig() {
    }

    public static AvatarConfig blackDiamondConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2020357303") ? (AvatarConfig) ipChange.ipc$dispatch("2020357303", new Object[0]) : new AvatarConfig(R$drawable.avatar_out_border_868bff, true, R$drawable.dm_yy_black_member_icon);
    }

    public static AvatarConfig defaultConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "951093117") ? (AvatarConfig) ipChange.ipc$dispatch("951093117", new Object[0]) : new AvatarConfig();
    }

    public static AvatarConfig mineTabNoneLoginConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362229213")) {
            return (AvatarConfig) ipChange.ipc$dispatch("362229213", new Object[0]);
        }
        AvatarConfig avatarConfig = new AvatarConfig();
        avatarConfig.placeHolderDrawableRid = R$drawable.mine_icon_user_default_none_login;
        return avatarConfig;
    }

    public static AvatarConfig normalDiamondConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-160186863") ? (AvatarConfig) ipChange.ipc$dispatch("-160186863", new Object[0]) : new AvatarConfig(R$drawable.avatar_out_border_ffaf86, true, R$drawable.dm_yy_member_icon);
    }

    public static AvatarConfig vTagConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586761384")) {
            return (AvatarConfig) ipChange.ipc$dispatch("586761384", new Object[0]);
        }
        AvatarConfig avatarConfig = new AvatarConfig();
        avatarConfig.showVTag = true;
        return avatarConfig;
    }

    public int getInnerBorderDrawableRid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1786326382")) {
            return this.innerBorderDrawableRid;
        }
        return ((Integer) ipChange.ipc$dispatch("1786326382", new Object[]{this})).intValue();
    }

    public int getOutBorderDrawableRid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "586355494")) {
            return this.outBorderDrawableRid;
        }
        return ((Integer) ipChange.ipc$dispatch("586355494", new Object[]{this})).intValue();
    }

    public int getPlaceHolderDrawableRid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1825779487")) {
            return this.placeHolderDrawableRid;
        }
        return ((Integer) ipChange.ipc$dispatch("1825779487", new Object[]{this})).intValue();
    }

    public int getYyTagDrawableRid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-567026714")) {
            return this.yyTagDrawableRid;
        }
        return ((Integer) ipChange.ipc$dispatch("-567026714", new Object[]{this})).intValue();
    }

    public boolean isShowOutBorder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1296904145")) {
            return this.showOutBorder;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1296904145", new Object[]{this})).booleanValue();
    }

    public boolean isShowVTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-941912155")) {
            return this.showVTag;
        }
        return ((Boolean) ipChange.ipc$dispatch("-941912155", new Object[]{this})).booleanValue();
    }

    public AvatarConfig(int i, boolean z, int i2) {
        this.outBorderDrawableRid = i;
        this.showOutBorder = z;
        this.yyTagDrawableRid = i2;
    }
}
