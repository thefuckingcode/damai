package cn.damai.discover.main.ui.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class RankUserBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String count;
    public String countDisplay;
    public String havanaIdStr;
    public String headPic;
    public boolean isCurrentLoginUser;
    public String nickName;
    public int rankingNo;

    public int getMaskDrawableRid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678917479")) {
            return ((Integer) ipChange.ipc$dispatch("-678917479", new Object[]{this})).intValue();
        }
        int i = this.rankingNo;
        if (i == 1) {
            return R$drawable.icon_rank_user_1;
        }
        if (i == 2) {
            return R$drawable.icon_rank_user_2;
        }
        if (i != 3) {
            return R$drawable.icon_rank_user_default;
        }
        return R$drawable.icon_rank_user_3;
    }

    public String getRankNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713605647")) {
            return (String) ipChange.ipc$dispatch("-1713605647", new Object[]{this});
        } else if (this.rankingNo > 999) {
            return "999+";
        } else {
            return this.rankingNo + "";
        }
    }

    public boolean isValidUser() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "641501982")) {
            return !TextUtils.isEmpty(this.havanaIdStr);
        }
        return ((Boolean) ipChange.ipc$dispatch("641501982", new Object[]{this})).booleanValue();
    }
}
