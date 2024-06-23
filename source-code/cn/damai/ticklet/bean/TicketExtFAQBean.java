package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class TicketExtFAQBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String iconUrl;
    @Nullable
    private ArrayList<String> normalQuestionList;
    @Nullable
    private String note;
    @Nullable
    private Boolean roleAndSceneGame = Boolean.FALSE;
    @Nullable
    private String title;

    @Nullable
    public final String getIconUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "42043655")) {
            return this.iconUrl;
        }
        return (String) ipChange.ipc$dispatch("42043655", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getNormalQuestionList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1327079478")) {
            return this.normalQuestionList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1327079478", new Object[]{this});
    }

    @Nullable
    public final String getNote() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-603576713")) {
            return this.note;
        }
        return (String) ipChange.ipc$dispatch("-603576713", new Object[]{this});
    }

    @Nullable
    public final Boolean getRoleAndSceneGame() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "732396603")) {
            return this.roleAndSceneGame;
        }
        return (Boolean) ipChange.ipc$dispatch("732396603", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-376177239")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-376177239", new Object[]{this});
    }

    public final void setIconUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312900273")) {
            ipChange.ipc$dispatch("-312900273", new Object[]{this, str});
            return;
        }
        this.iconUrl = str;
    }

    public final void setNormalQuestionList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-729171514")) {
            ipChange.ipc$dispatch("-729171514", new Object[]{this, arrayList});
            return;
        }
        this.normalQuestionList = arrayList;
    }

    public final void setNote(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1823765689")) {
            ipChange.ipc$dispatch("-1823765689", new Object[]{this, str});
            return;
        }
        this.note = str;
    }

    public final void setRoleAndSceneGame(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2023702437")) {
            ipChange.ipc$dispatch("-2023702437", new Object[]{this, bool});
            return;
        }
        this.roleAndSceneGame = bool;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580192275")) {
            ipChange.ipc$dispatch("-580192275", new Object[]{this, str});
            return;
        }
        this.title = str;
    }
}
