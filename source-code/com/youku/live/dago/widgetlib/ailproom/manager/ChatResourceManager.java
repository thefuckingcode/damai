package com.youku.live.dago.widgetlib.ailproom.manager;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ChatResourceManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile ChatResourceManager sInstance;
    private boolean isOrangeDowngradeGif = false;
    private List<BaseInfoBean> mYellSourceList = new ArrayList();
    private Map<String, BaseInfoBean> mYellSourceMap = new HashMap();

    public static ChatResourceManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624712165")) {
            return (ChatResourceManager) ipChange.ipc$dispatch("-624712165", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (ChatResourceManager.class) {
                if (sInstance == null) {
                    sInstance = new ChatResourceManager();
                }
            }
        }
        return sInstance;
    }

    public void addYellSource(String str, BaseInfoBean baseInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739454016")) {
            ipChange.ipc$dispatch("-739454016", new Object[]{this, str, baseInfoBean});
            return;
        }
        this.mYellSourceList.add(baseInfoBean);
        this.mYellSourceMap.put(str, baseInfoBean);
    }

    public void clearYellSource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115362053")) {
            ipChange.ipc$dispatch("-115362053", new Object[]{this});
            return;
        }
        this.mYellSourceMap.clear();
        this.mYellSourceList.clear();
    }

    public BaseInfoBean getYellSource(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1848381155")) {
            return this.mYellSourceMap.get(str);
        }
        return (BaseInfoBean) ipChange.ipc$dispatch("-1848381155", new Object[]{this, str});
    }

    public List<BaseInfoBean> getYellSourceList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1995413683")) {
            return this.mYellSourceList;
        }
        return (List) ipChange.ipc$dispatch("1995413683", new Object[]{this});
    }

    public Map<String, BaseInfoBean> getYellSourceMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-515928783")) {
            return this.mYellSourceMap;
        }
        return (Map) ipChange.ipc$dispatch("-515928783", new Object[]{this});
    }

    public boolean isOrangeDowngradeGif() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-223041480")) {
            return this.isOrangeDowngradeGif;
        }
        return ((Boolean) ipChange.ipc$dispatch("-223041480", new Object[]{this})).booleanValue();
    }

    public void setOrangeDowngradeGif(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2142787932")) {
            ipChange.ipc$dispatch("-2142787932", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isOrangeDowngradeGif = z;
    }

    public void setYellSourceMap(Map<String, BaseInfoBean> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468775293")) {
            ipChange.ipc$dispatch("468775293", new Object[]{this, map});
            return;
        }
        this.mYellSourceMap.putAll(map);
    }
}
