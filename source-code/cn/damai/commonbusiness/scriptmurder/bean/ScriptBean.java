package cn.damai.commonbusiness.scriptmurder.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.bean.SaleModelTagsBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String actionUrl;
    @JSONField(deserialize = false, serialize = false)
    @NotNull
    private String des = "";
    @Nullable
    private String difficultyName;
    @Nullable
    private String id;
    @Nullable
    private String name;
    @Nullable
    private String playerNum;
    @Nullable
    private String posterUrl;
    @Nullable
    private ArrayList<SaleModelTagsBean> saleModelTags;
    @Nullable
    private String score;
    @Nullable
    private String scriptTag;
    @Nullable
    private String scriptTime;

    @Nullable
    public final String getActionUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1144373928")) {
            return this.actionUrl;
        }
        return (String) ipChange.ipc$dispatch("1144373928", new Object[]{this});
    }

    @NotNull
    public final String getDes() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "368666593")) {
            return (String) ipChange.ipc$dispatch("368666593", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        String str = this.scriptTag;
        if (!(str == null || str.length() == 0)) {
            arrayList.add(str);
        }
        String str2 = this.playerNum;
        if (str2 != null) {
            arrayList.add(str2 + (char) 20154);
        }
        String str3 = this.scriptTime;
        if (!(str3 == null || str3.length() == 0)) {
            arrayList.add(str3 + "小时");
        }
        String str4 = this.difficultyName;
        if (!(str4 == null || str4.length() == 0)) {
            z = false;
        }
        if (!z) {
            arrayList.add(str4);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(" | ");
            }
            stringBuffer.append((String) arrayList.get(i));
        }
        String stringBuffer2 = stringBuffer.toString();
        k21.h(stringBuffer2, "value.toString()");
        return stringBuffer2;
    }

    @Nullable
    public final String getDifficultyName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1613879853")) {
            return this.difficultyName;
        }
        return (String) ipChange.ipc$dispatch("1613879853", new Object[]{this});
    }

    @Nullable
    public final String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "820446178")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("820446178", new Object[]{this});
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1754322350")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1754322350", new Object[]{this});
    }

    @Nullable
    public final String getPlayerNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1656785460")) {
            return this.playerNum;
        }
        return (String) ipChange.ipc$dispatch("1656785460", new Object[]{this});
    }

    @Nullable
    public final String getPosterUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1697039951")) {
            return this.posterUrl;
        }
        return (String) ipChange.ipc$dispatch("-1697039951", new Object[]{this});
    }

    @Nullable
    public final ArrayList<SaleModelTagsBean> getSaleModelTags() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "764841360")) {
            return this.saleModelTags;
        }
        return (ArrayList) ipChange.ipc$dispatch("764841360", new Object[]{this});
    }

    @Nullable
    public final String getScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1297272479")) {
            return this.score;
        }
        return (String) ipChange.ipc$dispatch("-1297272479", new Object[]{this});
    }

    @Nullable
    public final String getScriptTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1386508514")) {
            return this.scriptTag;
        }
        return (String) ipChange.ipc$dispatch("-1386508514", new Object[]{this});
    }

    @Nullable
    public final String getScriptTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-589675393")) {
            return this.scriptTime;
        }
        return (String) ipChange.ipc$dispatch("-589675393", new Object[]{this});
    }

    public final void setActionUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-849351474")) {
            ipChange.ipc$dispatch("-849351474", new Object[]{this, str});
            return;
        }
        this.actionUrl = str;
    }

    public final void setDes(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37689419")) {
            ipChange.ipc$dispatch("-37689419", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.des = str;
    }

    public final void setDifficultyName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-626438831")) {
            ipChange.ipc$dispatch("-626438831", new Object[]{this, str});
            return;
        }
        this.difficultyName = str;
    }

    public final void setId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494620100")) {
            ipChange.ipc$dispatch("-1494620100", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157825228")) {
            ipChange.ipc$dispatch("1157825228", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public final void setPlayerNum(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144463166")) {
            ipChange.ipc$dispatch("-2144463166", new Object[]{this, str});
            return;
        }
        this.playerNum = str;
    }

    public final void setPosterUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261131493")) {
            ipChange.ipc$dispatch("1261131493", new Object[]{this, str});
            return;
        }
        this.posterUrl = str;
    }

    public final void setSaleModelTags(@Nullable ArrayList<SaleModelTagsBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010994904")) {
            ipChange.ipc$dispatch("-1010994904", new Object[]{this, arrayList});
            return;
        }
        this.saleModelTags = arrayList;
    }

    public final void setScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930626357")) {
            ipChange.ipc$dispatch("930626357", new Object[]{this, str});
            return;
        }
        this.score = str;
    }

    public final void setScriptTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997295848")) {
            ipChange.ipc$dispatch("-1997295848", new Object[]{this, str});
            return;
        }
        this.scriptTag = str;
    }

    public final void setScriptTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1085015871")) {
            ipChange.ipc$dispatch("1085015871", new Object[]{this, str});
            return;
        }
        this.scriptTime = str;
    }
}
