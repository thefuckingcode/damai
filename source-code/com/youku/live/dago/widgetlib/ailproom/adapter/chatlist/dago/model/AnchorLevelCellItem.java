package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class AnchorLevelCellItem extends BaseCellItem<AnchorLevelCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public int level;

    public AnchorLevelCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-502642935")) {
            return BaseCellItem.TYPE_MEDAL_ANCHOR_LEVEL;
        }
        return (String) ipChange.ipc$dispatch("-502642935", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public AnchorLevelCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384300721")) {
            return (AnchorLevelCellItem) ipChange.ipc$dispatch("1384300721", new Object[]{this, map});
        }
        if (map.containsKey("level")) {
            this.level = getInt(map.get("level"));
        }
        return this;
    }

    public AnchorLevelCellItem() {
    }
}
