package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import androidx.core.util.Pair;
import cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class ProjectWantSeeBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public GuideVO guideVO;
    private boolean showWant;
    private boolean subFlag;
    private long thresholdNum;
    private String tips;
    public String tipsSubTitle;
    public String tipsTitle;
    private String title;
    private List<String> userImgs;
    private String wantDesc;
    private long wantNum;
    private String wantNumStr;
    private String wantNumSuffix;

    /* compiled from: Taobao */
    public static class GuideVO implements Serializable {
        public String posterUrl;
        public String subTitle;
        public String title;
        public String titleSuffix;
        public int titleType;
    }

    public long getThresholdNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2120645790")) {
            return this.thresholdNum;
        }
        return ((Long) ipChange.ipc$dispatch("2120645790", new Object[]{this})).longValue();
    }

    public String getTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1079812307")) {
            return this.tips;
        }
        return (String) ipChange.ipc$dispatch("1079812307", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1402303917")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1402303917", new Object[]{this});
    }

    public List<String> getUserImgs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-447763267")) {
            return this.userImgs;
        }
        return (List) ipChange.ipc$dispatch("-447763267", new Object[]{this});
    }

    public String getWantDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "487277532")) {
            return this.wantDesc;
        }
        return (String) ipChange.ipc$dispatch("487277532", new Object[]{this});
    }

    public long getWantNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "88776739")) {
            return this.wantNum;
        }
        return ((Long) ipChange.ipc$dispatch("88776739", new Object[]{this})).longValue();
    }

    public Pair<String, String> getWantNumPair() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-88506519")) {
            return WantSeeHelper.d(this.wantNum);
        }
        return (Pair) ipChange.ipc$dispatch("-88506519", new Object[]{this});
    }

    public String getWantNumStr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "433850646")) {
            return this.wantNumStr;
        }
        return (String) ipChange.ipc$dispatch("433850646", new Object[]{this});
    }

    public String getWantNumSuffix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1260002498")) {
            return this.wantNumSuffix;
        }
        return (String) ipChange.ipc$dispatch("1260002498", new Object[]{this});
    }

    public boolean isShowWant() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "973979132")) {
            return this.showWant;
        }
        return ((Boolean) ipChange.ipc$dispatch("973979132", new Object[]{this})).booleanValue();
    }

    public boolean isSubFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "354255837")) {
            return this.subFlag;
        }
        return ((Boolean) ipChange.ipc$dispatch("354255837", new Object[]{this})).booleanValue();
    }

    public void setShowWant(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120845064")) {
            ipChange.ipc$dispatch("1120845064", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.showWant = z;
    }

    public void setSubFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869859695")) {
            ipChange.ipc$dispatch("1869859695", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.subFlag = z;
    }

    public void setThresholdNum(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228187034")) {
            ipChange.ipc$dispatch("-228187034", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.thresholdNum = j;
    }

    public void setTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178313621")) {
            ipChange.ipc$dispatch("-1178313621", new Object[]{this, str});
            return;
        }
        this.tips = str;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969619075")) {
            ipChange.ipc$dispatch("1969619075", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void setUserImgs(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485304657")) {
            ipChange.ipc$dispatch("-1485304657", new Object[]{this, list});
            return;
        }
        this.userImgs = list;
    }

    public void setWantDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956593534")) {
            ipChange.ipc$dispatch("-1956593534", new Object[]{this, str});
            return;
        }
        this.wantDesc = str;
    }

    public void setWantNum(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980373481")) {
            ipChange.ipc$dispatch("980373481", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.wantNum = j;
    }

    public void setWantNumStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545415288")) {
            ipChange.ipc$dispatch("-1545415288", new Object[]{this, str});
            return;
        }
        this.wantNumStr = str;
    }

    public void setWantNumSuffix(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463291916")) {
            ipChange.ipc$dispatch("-1463291916", new Object[]{this, str});
            return;
        }
        this.wantNumSuffix = str;
    }
}
