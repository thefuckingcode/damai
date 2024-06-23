package com.youku.live.dago.liveplayback.widget.plugins.tipsview;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConstants;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.TipsPosition;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class TipsConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Long DEFAULT_DISPLAY_TIME = 3000L;
    public static final Long MAX_DISPLAY_DURATION = 600000L;
    private String description = "";
    private long displayTime = -1;
    private Map<String, Object> extraMap;
    private int frequency = Integer.MAX_VALUE;
    private FrequencyType frequencyType = FrequencyType.NO_LIMIT;
    private TipsPosition position;
    private String tipId;
    private String tipsKey = TipsConstants.LeftBottomTips.KEY.KEY_DEFAULT;
    private int tipsLevel = 0;
    private ITipsPresenter tipsPresenter;
    private BaseTipsUiConfig tipsUiConfig;

    /* compiled from: Taobao */
    public enum FrequencyType {
        NO_LIMIT,
        DAY,
        APP_INSTALL,
        APP_RUN,
        DAYS
    }

    private Map<String, Object> getExtraMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-850683615")) {
            return this.extraMap;
        }
        return (Map) ipChange.ipc$dispatch("-850683615", new Object[]{this});
    }

    public String getDescription() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1394853738")) {
            return this.description;
        }
        return (String) ipChange.ipc$dispatch("1394853738", new Object[]{this});
    }

    public long getDisplayTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "497962071")) {
            return this.displayTime;
        }
        return ((Long) ipChange.ipc$dispatch("497962071", new Object[]{this})).longValue();
    }

    public int getFrequency() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-303647287")) {
            return this.frequency;
        }
        return ((Integer) ipChange.ipc$dispatch("-303647287", new Object[]{this})).intValue();
    }

    public FrequencyType getFrequencyType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1207717668")) {
            return this.frequencyType;
        }
        return (FrequencyType) ipChange.ipc$dispatch("-1207717668", new Object[]{this});
    }

    public TipsPosition getPosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1339407985")) {
            return this.position;
        }
        return (TipsPosition) ipChange.ipc$dispatch("-1339407985", new Object[]{this});
    }

    public String getTipId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1273825340")) {
            return this.tipId;
        }
        return (String) ipChange.ipc$dispatch("-1273825340", new Object[]{this});
    }

    public String getTipsKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-752254603")) {
            return this.tipsKey;
        }
        return (String) ipChange.ipc$dispatch("-752254603", new Object[]{this});
    }

    public int getTipsLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "804326905")) {
            return this.tipsLevel;
        }
        return ((Integer) ipChange.ipc$dispatch("804326905", new Object[]{this})).intValue();
    }

    public ITipsPresenter getTipsPresenter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1802045366")) {
            return this.tipsPresenter;
        }
        return (ITipsPresenter) ipChange.ipc$dispatch("1802045366", new Object[]{this});
    }

    public BaseTipsUiConfig getTipsUiConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2017111")) {
            return this.tipsUiConfig;
        }
        return (BaseTipsUiConfig) ipChange.ipc$dispatch("2017111", new Object[]{this});
    }

    public TipsConfig setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773150302")) {
            return (TipsConfig) ipChange.ipc$dispatch("773150302", new Object[]{this, str});
        }
        this.description = str;
        return this;
    }

    public TipsConfig setDisplayTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190026951")) {
            return (TipsConfig) ipChange.ipc$dispatch("190026951", new Object[]{this, Long.valueOf(j)});
        }
        Long l = MAX_DISPLAY_DURATION;
        if (j > l.longValue()) {
            j = l.longValue();
        }
        this.displayTime = j;
        return this;
    }

    public void setExtraMap(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012406235")) {
            ipChange.ipc$dispatch("-1012406235", new Object[]{this, map});
            return;
        }
        this.extraMap = map;
    }

    public TipsConfig setFrequency(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734383347")) {
            return (TipsConfig) ipChange.ipc$dispatch("734383347", new Object[]{this, Integer.valueOf(i)});
        }
        this.frequency = i;
        return this;
    }

    public TipsConfig setFrequencyType(FrequencyType frequencyType2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953117574")) {
            return (TipsConfig) ipChange.ipc$dispatch("-1953117574", new Object[]{this, frequencyType2});
        }
        this.frequencyType = frequencyType2;
        return this;
    }

    public TipsConfig setPosition(TipsPosition tipsPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240448189")) {
            return (TipsConfig) ipChange.ipc$dispatch("240448189", new Object[]{this, tipsPosition});
        }
        this.position = tipsPosition;
        return this;
    }

    public void setTipId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657487666")) {
            ipChange.ipc$dispatch("1657487666", new Object[]{this, str});
            return;
        }
        this.tipId = str;
    }

    public TipsConfig setTipsKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358260531")) {
            return (TipsConfig) ipChange.ipc$dispatch("1358260531", new Object[]{this, str});
        }
        this.tipsKey = str;
        return this;
    }

    public TipsConfig setTipsLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153133885")) {
            return (TipsConfig) ipChange.ipc$dispatch("-1153133885", new Object[]{this, Integer.valueOf(i)});
        }
        this.tipsLevel = i;
        return this;
    }

    public TipsConfig setTipsUiConfig(BaseTipsUiConfig baseTipsUiConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118005775")) {
            return (TipsConfig) ipChange.ipc$dispatch("-2118005775", new Object[]{this, baseTipsUiConfig});
        }
        this.tipsUiConfig = baseTipsUiConfig;
        return this;
    }

    public TipsConfig setTipsView(ITipsPresenter iTipsPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693781955")) {
            return (TipsConfig) ipChange.ipc$dispatch("1693781955", new Object[]{this, iTipsPresenter});
        }
        this.tipsPresenter = iTipsPresenter;
        return this;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525166896")) {
            return (String) ipChange.ipc$dispatch("-525166896", new Object[]{this});
        }
        return "[tipId:" + this.tipId + "|tipsLevel:" + this.tipsLevel + "|displayTime:" + this.displayTime + "|frequencyType:" + this.frequencyType + "|frequency:" + this.frequency + "|tipsKey:" + this.tipsKey + "|description:" + this.description + jl1.ARRAY_END_STR;
    }
}
