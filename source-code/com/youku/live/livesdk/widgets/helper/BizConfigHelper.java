package com.youku.live.livesdk.widgets.helper;

import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BizConfigHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037 A[SYNTHETIC, Splitter:B:13:0x0037] */
    public static boolean shouldDowngradeToOldContainer(Uri uri) {
        boolean z;
        String queryParameter;
        boolean z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235504135")) {
            return ((Boolean) ipChange.ipc$dispatch("235504135", new Object[]{uri})).booleanValue();
        }
        if (uri != null) {
            String queryParameter2 = uri.getQueryParameter("debug");
            if (queryParameter2 != null) {
                try {
                    z = Boolean.valueOf(queryParameter2).booleanValue();
                } catch (Throwable unused) {
                }
                queryParameter = uri.getQueryParameter("dt2019");
                if (queryParameter != null) {
                    try {
                        z2 = Boolean.valueOf(queryParameter).booleanValue();
                    } catch (Throwable unused2) {
                    }
                    if (z && z2) {
                        return true;
                    }
                }
                z2 = false;
                return true;
            }
            z = false;
            queryParameter = uri.getQueryParameter("dt2019");
            if (queryParameter != null) {
            }
            z2 = false;
            return true;
        }
        return ConfigHelper.getBoolean("live_platform_widget", "downgrade_to_old_container", false);
    }
}
