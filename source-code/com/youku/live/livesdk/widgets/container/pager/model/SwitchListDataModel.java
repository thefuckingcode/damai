package com.youku.live.livesdk.widgets.container.pager.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class SwitchListDataModel implements Serializable {
    public String changeStatus;
    public long dateTimestamp;
    public boolean hasNext;
    public List<SwitchItemModel> itemList;
    public int offset;
    public boolean roomSwitch;
}
