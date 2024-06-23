package com.youku.live.livesdk.wkit.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.wkit.component.common.utils.SharedPreferenceUtil;
import tb.ol1;

/* compiled from: Taobao */
public class ConfigUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getSdkVersion(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1712802846")) {
            return (String) ipChange.ipc$dispatch("-1712802846", new Object[]{context, uri});
        }
        String str = null;
        if (uri != null) {
            str = uri.getQueryParameter("sdkversion");
        }
        return TextUtils.isEmpty(str) ? useSdkVersionConfig(context) : str;
    }

    public static boolean isPipMiniAppOnPauseFinishing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119698982")) {
            return ((Boolean) ipChange.ipc$dispatch("119698982", new Object[0])).booleanValue();
        }
        String string = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("live_platform_widget", "live_pip_miniapp_onpause_finishing", "1");
        if (TextUtils.isEmpty(string) || !"0".equals(string)) {
            return true;
        }
        return false;
    }

    public static boolean isPipSwitchOpen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008199796")) {
            return ((Boolean) ipChange.ipc$dispatch("-2008199796", new Object[0])).booleanValue();
        }
        String string = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("live_platform_widget", SharedPreferenceUtil.KEY_LIVE_PIP_SWITCH, "0");
        if (TextUtils.isEmpty(string) || !"1".equals(string)) {
            return false;
        }
        return true;
    }

    public static String useSdkVersionConfig(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1705100380")) {
            return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString(ol1.LIVE_PLATFORM_CONFIG, "live_sdk_version", SDKConstants.SDK_VERSION_NUMBER);
        }
        return (String) ipChange.ipc$dispatch("-1705100380", new Object[]{context});
    }
}
