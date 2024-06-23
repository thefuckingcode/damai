package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class UserLevelCellItem extends BaseCellItem<UserLevelCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public int level;

    public UserLevelCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-31637069")) {
            return BaseCellItem.TYPE_MEDAL_USER_LEVEL;
        }
        return (String) ipChange.ipc$dispatch("-31637069", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public UserLevelCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-192189859")) {
            return (UserLevelCellItem) ipChange.ipc$dispatch("-192189859", new Object[]{this, map});
        }
        if (map.containsKey("level")) {
            this.level = getInt(map.get("level"));
        }
        return this;
    }

    public UserLevelCellItem() {
    }
}
