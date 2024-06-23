package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public abstract class BaseCellItem<T extends BaseCellItem> implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_BUTTON = "button";
    public static final String TYPE_FACE = "face";
    public static final String TYPE_GIFT = "gift";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_MEDAL = "medal";
    public static final String TYPE_MEDAL_ANCHOR_LEVEL = "lfAnchorLevel";
    public static final String TYPE_MEDAL_USER_LEVEL = "lfUserLevel";
    public static final String TYPE_TEXT = "text";

    public boolean getBoolean(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1534941639")) {
            return obj != null && Boolean.parseBoolean(getString(obj));
        }
        return ((Boolean) ipChange.ipc$dispatch("1534941639", new Object[]{this, obj})).booleanValue();
    }

    public String getColor(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161222584")) {
            return (String) ipChange.ipc$dispatch("1161222584", new Object[]{this, obj});
        } else if (obj == null) {
            return "#FFFFFFFF";
        } else {
            return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + String.valueOf(obj);
        }
    }

    public int getInt(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386439345")) {
            return ((Integer) ipChange.ipc$dispatch("-1386439345", new Object[]{this, obj})).intValue();
        } else if (obj == null) {
            return 0;
        } else {
            return Integer.parseInt(getString(obj));
        }
    }

    public String getString(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119078106")) {
            return (String) ipChange.ipc$dispatch("119078106", new Object[]{this, obj});
        } else if (obj == null) {
            return null;
        } else {
            return String.valueOf(obj);
        }
    }

    public abstract String getType();

    public abstract T parseCellItem(Map map);
}
