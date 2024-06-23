package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;

/* compiled from: Taobao */
public class FaceCellItem extends BaseCellItem<FaceCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public String icon;
    public String src;

    public FaceCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1375971435")) {
            return BaseCellItem.TYPE_FACE;
        }
        return (String) ipChange.ipc$dispatch("1375971435", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public FaceCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766345071")) {
            return (FaceCellItem) ipChange.ipc$dispatch("-766345071", new Object[]{this, map});
        }
        if (map.containsKey("src")) {
            this.src = getString(map.get("src"));
        }
        if (map.containsKey(RemoteMessageConst.Notification.ICON)) {
            this.icon = getString(map.get(RemoteMessageConst.Notification.ICON));
        }
        return this;
    }

    public FaceCellItem() {
    }
}
