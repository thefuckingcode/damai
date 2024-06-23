package cn.damai.discover.content.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.discover.content.net.ContentCard;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.ArrayList;
import java.util.List;
import tb.d20;
import tb.f92;

/* compiled from: Taobao */
public class FollowInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentId;
    public int focusCount;
    public boolean isFocus = false;
    public final List<FollowedUser> mUsers;
    public boolean needAnimation = false;
    public boolean needSetUiMarginTop = false;
    public String targetId;
    public String targetType;

    public FollowInfo(ContentDetail contentDetail, ContentCard contentCard) {
        ScriptBean scriptBean;
        ArrayList arrayList = new ArrayList();
        this.mUsers = arrayList;
        boolean z = false;
        if (contentDetail != null) {
            this.isFocus = contentDetail.focus;
            this.contentId = contentDetail.contentId;
            this.focusCount = contentDetail.focusCount;
            if (!f92.d(contentDetail.focusList)) {
                arrayList.addAll(contentDetail.focusList);
            }
        }
        if (contentDetail != null && contentDetail.itemType == 2 && (scriptBean = contentDetail.scriptInfo) != null) {
            this.targetType = "25";
            this.targetId = scriptBean.getId();
        } else if (contentCard != null) {
            this.targetType = contentCard.targetType;
            this.targetId = contentCard.targetId;
        }
        this.needSetUiMarginTop = (contentCard == null || !contentCard.isHasBody()) ? true : z;
    }

    public boolean isHasFlowParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1381032784")) {
            return !TextUtils.isEmpty(this.targetType) && !TextUtils.isEmpty(this.targetId);
        }
        return ((Boolean) ipChange.ipc$dispatch("1381032784", new Object[]{this})).booleanValue();
    }

    public void updateMyFollowFromFollowList(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658383961")) {
            ipChange.ipc$dispatch("658383961", new Object[]{this, Boolean.valueOf(z)});
        } else if (LoginManager.k().q()) {
            String E = d20.E();
            String i = d20.i();
            if (!TextUtils.isEmpty(E)) {
                String str = null;
                try {
                    str = d20.B(Login.getHeadPicLink());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FollowedUser followedUser = new FollowedUser(E, i, str);
                if (z) {
                    this.focusCount++;
                    this.mUsers.remove(followedUser);
                    this.mUsers.add(0, followedUser);
                    return;
                }
                this.mUsers.remove(followedUser);
                this.focusCount--;
            }
        }
    }
}
