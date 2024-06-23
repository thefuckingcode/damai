package cn.damai.tetris.component.ip.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class IPInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> awardsList;
    private String category;
    private Content content;
    public boolean focus;
    private String guidelines;
    private boolean haveseen;
    private String id;
    private String ipName;
    private List<IpTags> ipTags;
    private long ipvuv;
    public String ipvuvDescription;
    private String itemScore;
    public boolean like;
    private Rank rank;
    private String scoreDesc;
    private List<String> verticalPicList;

    public List<String> getAwardsList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "816029989")) {
            return this.awardsList;
        }
        return (List) ipChange.ipc$dispatch("816029989", new Object[]{this});
    }

    public String getCategory() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1442574264")) {
            return this.category;
        }
        return (String) ipChange.ipc$dispatch("-1442574264", new Object[]{this});
    }

    public Content getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "774863671")) {
            return this.content;
        }
        return (Content) ipChange.ipc$dispatch("774863671", new Object[]{this});
    }

    public boolean getFocus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1032034720")) {
            return this.focus;
        }
        return ((Boolean) ipChange.ipc$dispatch("1032034720", new Object[]{this})).booleanValue();
    }

    public String getGuidelines() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1167569779")) {
            return this.guidelines;
        }
        return (String) ipChange.ipc$dispatch("-1167569779", new Object[]{this});
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1923889957")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("1923889957", new Object[]{this});
    }

    public String getIpName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1505068380")) {
            return this.ipName;
        }
        return (String) ipChange.ipc$dispatch("1505068380", new Object[]{this});
    }

    public List<IpTags> getIpTags() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1603212305")) {
            return this.ipTags;
        }
        return (List) ipChange.ipc$dispatch("1603212305", new Object[]{this});
    }

    public long getIpvuv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-897921960")) {
            return this.ipvuv;
        }
        return ((Long) ipChange.ipc$dispatch("-897921960", new Object[]{this})).longValue();
    }

    public String getItemScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-689264917")) {
            return this.itemScore;
        }
        return (String) ipChange.ipc$dispatch("-689264917", new Object[]{this});
    }

    public float getItemScoreFloat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688450249")) {
            return ((Float) ipChange.ipc$dispatch("1688450249", new Object[]{this})).floatValue();
        } else if (TextUtils.isEmpty(this.itemScore)) {
            return 0.0f;
        } else {
            try {
                return Float.parseFloat(this.itemScore);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
    }

    public Rank getRank() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1543146283")) {
            return this.rank;
        }
        return (Rank) ipChange.ipc$dispatch("1543146283", new Object[]{this});
    }

    public String getScoreDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "187321839")) {
            return this.scoreDesc;
        }
        return (String) ipChange.ipc$dispatch("187321839", new Object[]{this});
    }

    public List<String> getVerticalPicList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1463291515")) {
            return this.verticalPicList;
        }
        return (List) ipChange.ipc$dispatch("-1463291515", new Object[]{this});
    }

    public void setAwardsList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550344775")) {
            ipChange.ipc$dispatch("550344775", new Object[]{this, list});
            return;
        }
        this.awardsList = list;
    }

    public void setCategory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652457066")) {
            ipChange.ipc$dispatch("-1652457066", new Object[]{this, str});
            return;
        }
        this.category = str;
    }

    public void setContent(Content content2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049327717")) {
            ipChange.ipc$dispatch("1049327717", new Object[]{this, content2});
            return;
        }
        this.content = content2;
    }

    public void setFocus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-817623764")) {
            ipChange.ipc$dispatch("-817623764", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.focus = z;
    }

    public void setGuidelines(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350159089")) {
            ipChange.ipc$dispatch("350159089", new Object[]{this, str});
            return;
        }
        this.guidelines = str;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647601319")) {
            ipChange.ipc$dispatch("-1647601319", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setIpName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982612478")) {
            ipChange.ipc$dispatch("-1982612478", new Object[]{this, str});
            return;
        }
        this.ipName = str;
    }

    public void setIpTags(List<IpTags> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227236133")) {
            ipChange.ipc$dispatch("-1227236133", new Object[]{this, list});
            return;
        }
        this.ipTags = list;
    }

    public void setIpvuv(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516753580")) {
            ipChange.ipc$dispatch("-516753580", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.ipvuv = j;
    }

    public void setItemScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857580821")) {
            ipChange.ipc$dispatch("-1857580821", new Object[]{this, str});
            return;
        }
        this.itemScore = str;
    }

    public void setRank(Rank rank2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125542877")) {
            ipChange.ipc$dispatch("125542877", new Object[]{this, rank2});
            return;
        }
        this.rank = rank2;
    }

    public void setScoreDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453195161")) {
            ipChange.ipc$dispatch("-453195161", new Object[]{this, str});
            return;
        }
        this.scoreDesc = str;
    }

    public void setVerticalPicList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919486335")) {
            ipChange.ipc$dispatch("919486335", new Object[]{this, list});
            return;
        }
        this.verticalPicList = list;
    }
}
