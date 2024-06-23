package com.youku.arch.analysis.a;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.liveservice.LivePlayerController;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1433323541")) {
            return !TextUtils.isEmpty(str) && !"0.0.0.0".equals(str) && !LivePlayerController.CLIENT_IP.equals(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("1433323541", new Object[]{str})).booleanValue();
    }
}
