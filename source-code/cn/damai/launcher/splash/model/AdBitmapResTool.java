package cn.damai.launcher.splash.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.bean.AdBitmapRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class AdBitmapResTool {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String AD_SPLASH_SP = "sp_splash_ad_info";
    public static final String SP_KEY_SAVED_AD_RES = "sp_key_last_saved_ad_res";
    private static boolean isGetOnce;
    private static AdBitmapRes sBitmapRes;

    public static void applySpSplashResString(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240498288")) {
            ipChange.ipc$dispatch("1240498288", new Object[]{context, str});
            return;
        }
        getInnerSp(context).edit().putString(SP_KEY_SAVED_AD_RES, str).apply();
    }

    public static synchronized void cache(AdBitmapRes adBitmapRes) {
        synchronized (AdBitmapResTool.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "72520145")) {
                ipChange.ipc$dispatch("72520145", new Object[]{adBitmapRes});
                return;
            }
            sBitmapRes = adBitmapRes;
        }
    }

    @Nullable
    public static synchronized AdBitmapRes cacheGet() {
        synchronized (AdBitmapResTool.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1642662869")) {
                return (AdBitmapRes) ipChange.ipc$dispatch("1642662869", new Object[0]);
            }
            isGetOnce = true;
            return sBitmapRes;
        }
    }

    public static String getCityId(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1840797147")) {
            return context.getSharedPreferences(ShareperfenceConstants.CITY_SHAREPREFENCE, 0).getString(ShareperfenceConstants.CITY_ID, "852");
        }
        return (String) ipChange.ipc$dispatch("-1840797147", new Object[]{context});
    }

    private static SharedPreferences getInnerSp(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-688816168")) {
            return context.getSharedPreferences(AD_SPLASH_SP, 0);
        }
        return (SharedPreferences) ipChange.ipc$dispatch("-688816168", new Object[]{context});
    }

    @Nullable
    public static SplashResponse getSpCacheSplashRes(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1029229833")) {
            return (SplashResponse) ipChange.ipc$dispatch("1029229833", new Object[]{context});
        }
        String string = getInnerSp(context).getString(SP_KEY_SAVED_AD_RES, "");
        if (!TextUtils.isEmpty(string)) {
            return (SplashResponse) s41.a(string, SplashResponse.class);
        }
        return null;
    }

    public static synchronized boolean isCacheGetApiInvoked() {
        synchronized (AdBitmapResTool.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2001838517")) {
                return ((Boolean) ipChange.ipc$dispatch("2001838517", new Object[0])).booleanValue();
            }
            return isGetOnce;
        }
    }
}
