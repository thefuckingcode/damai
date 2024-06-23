package com.youku.live.dago.widgetlib.util;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
public class WXAttrParse {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean getBoolean(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1183250432")) {
            return obj != null && Boolean.parseBoolean(getString(obj));
        }
        return ((Boolean) ipChange.ipc$dispatch("-1183250432", new Object[]{obj})).booleanValue();
    }

    public static int getColor(Object obj, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133976395")) {
            return ((Integer) ipChange.ipc$dispatch("-133976395", new Object[]{obj, Integer.valueOf(i)})).intValue();
        } else if (obj == null) {
            return i;
        } else {
            return Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + String.valueOf(obj));
        }
    }

    public static int getInt(Object obj, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1292360319")) {
            return obj == null ? i : Integer.parseInt(getString(obj));
        }
        return ((Integer) ipChange.ipc$dispatch("-1292360319", new Object[]{obj, Integer.valueOf(i)})).intValue();
    }

    public static String getString(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2043353363")) {
            return getString(obj, null);
        }
        return (String) ipChange.ipc$dispatch("2043353363", new Object[]{obj});
    }

    public static String getString(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1761764809")) {
            return obj == null ? str : String.valueOf(obj);
        }
        return (String) ipChange.ipc$dispatch("1761764809", new Object[]{obj, str});
    }
}
