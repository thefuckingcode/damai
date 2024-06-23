package com.youku.live.dago.widgetlib.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.Orientation;

/* compiled from: Taobao */
public class LiveAppUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getDirection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695252385")) {
            return (String) ipChange.ipc$dispatch("695252385", new Object[0]);
        }
        return WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE ? "fplayer" : "vplayer";
    }

    public static String getFromeName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "644721608")) {
            return (String) ipChange.ipc$dispatch("644721608", new Object[0]);
        }
        return isStarLive() ? "chat_starlive" : "chat_ykliveroom";
    }

    public static boolean isStarLive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305246108")) {
            return ((Boolean) ipChange.ipc$dispatch("-305246108", new Object[0])).booleanValue();
        }
        if (UIUtil.getContext() != null) {
            return "com.youku.starlive".equals(UIUtil.getContext().getPackageName());
        }
        return false;
    }
}
