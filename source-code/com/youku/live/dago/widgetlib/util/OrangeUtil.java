package com.youku.live.dago.widgetlib.util;

import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.net.mtop.netfit.ERROR;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import org.android.agoo.message.MessageService;
import tb.jl1;

/* compiled from: Taobao */
public class OrangeUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DISABLE_BOOL = "0";
    public static final String DISABLE_INT = "0";
    public static final String ENABLED_BOOL = "1";
    public static final String ENABLED_INT = "1";
    public static final String LIVE_DANMAKU_GROUP_NAME = "YKLiveDanmaku";
    public static final String LIVE_GIFT_COMB_NAME = "android_liveroom_gift";
    public static final String LIVE_GROUP_NAME = "YKLive";
    public static final String LIVE_LOG_UPLOAD = "YKLivePlayLog";
    public static final String LIVE_PLAYER_GROUP_NAME = "YKLivePlayer";
    public static final String LIVE_ROOM_AB_TEST = "YKLiveRoom_ABTest";

    public static boolean autoProjection() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1392192503")) {
            return ((Boolean) ipChange.ipc$dispatch("1392192503", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "MultiScreenAutoPlay", "1");
        if (TextUtils.isEmpty(config) || config.trim().length() > 1) {
            return true;
        }
        if (!"0".equals(config.trim()) && !"1".equals(config.trim())) {
            return true;
        }
        try {
            if (Integer.parseInt(config.trim()) != 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean changePowerMsgSwitchByStatusChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369091772")) {
            return ((Boolean) ipChange.ipc$dispatch("1369091772", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "changePowerMsgSwitchByStatusChange", "true");
        if (TextUtils.isEmpty(config) || !"true".equals(config)) {
            return false;
        }
        return true;
    }

    public static String dolbyAnimationFileUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "802602638") ? (String) ipChange.ipc$dispatch("802602638", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLive", "dolby_animation_file_url", "");
    }

    public static boolean downgradeWaterMarkPriority() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "524196066")) {
            return ((Boolean) ipChange.ipc$dispatch("524196066", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "WaterMarkTypePriority", "1");
        if (TextUtils.isEmpty(config) || config.trim().length() > 1) {
            return true;
        }
        if (!"0".equals(config.trim()) && !"1".equals(config.trim())) {
            return true;
        }
        try {
            if (Integer.parseInt(config.trim()) != 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean enableDowngradeToH5ForNative() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416193007")) {
            return ((Boolean) ipChange.ipc$dispatch("416193007", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "enable_down_grade_h5_for_native", "false"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enableUserSelectedQuality() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233933191")) {
            return ((Boolean) ipChange.ipc$dispatch("1233933191", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "enableUserSelectedQuality", "false");
        if (TextUtils.isEmpty(config) || !"true".equals(config)) {
            return false;
        }
        return true;
    }

    public static boolean enableWaterMarkForNative() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961097290")) {
            return ((Boolean) ipChange.ipc$dispatch("-961097290", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "enable_water_mark_for_native", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean fixDanmakuRenderOnDestroy() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "739661298") ? ((Boolean) ipChange.ipc$dispatch("739661298", new Object[0])).booleanValue() : getBoolean("support20190212DanmakuRenderOnDestroy", false);
    }

    public static boolean fixDanmakuRenderOnResumePause() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-225289149") ? ((Boolean) ipChange.ipc$dispatch("-225289149", new Object[0])).booleanValue() : getBoolean("support20190212DanmakuRenderOnResumePause", false);
    }

    public static boolean fixLeftBackButtonClickEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1898632022") ? ((Boolean) ipChange.ipc$dispatch("1898632022", new Object[0])).booleanValue() : getBoolean("fix20190114BackEvent", false);
    }

    public static boolean fixPhinexGifCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "959231366") ? ((Boolean) ipChange.ipc$dispatch("959231366", new Object[0])).booleanValue() : getBoolean("support20190212PhinexGifCircle", false);
    }

    public static boolean getBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1328606961")) {
            return ((Boolean) ipChange.ipc$dispatch("-1328606961", new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        }
        try {
            String config = OrangeConfig.getInstance().getConfig("YKLive", str, z ? "1" : "0");
            if (config == null || config.compareToIgnoreCase("1") != 0) {
                z2 = false;
            }
            return z2;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getCarouselRequestNumber() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246102462")) {
            return ((Integer) ipChange.ipc$dispatch("-1246102462", new Object[0])).intValue();
        }
        OrangeConfig instance = OrangeConfig.getInstance();
        String str = MessageService.MSG_DB_COMPLETE;
        String config = instance.getConfig("YKLive", "YKL_CAROUSEK_REQUEST_NUMBER", str);
        if (!TextUtils.isEmpty(config)) {
            str = config;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception unused) {
            return 100;
        }
    }

    public static long getChatRefreshTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2132420139")) {
            return ((Long) ipChange.ipc$dispatch("2132420139", new Object[0])).longValue();
        }
        try {
            return Long.parseLong(OrangeConfig.getInstance().getConfig("YKLive", "chat_refresh", ERROR.MTOP_XFLUSH_SUCCESS_CODE));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 2000;
        }
    }

    public static int getChatRoomConnectDelayTime() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371767075")) {
            return ((Integer) ipChange.ipc$dispatch("-1371767075", new Object[0])).intValue();
        }
        try {
            i = ParseUtils.parse2Int(OrangeConfig.getInstance().getConfig("YKLive", "chatroom_connect_delay_time", "6"));
            if (i == 0) {
                i = 6;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 6000;
        }
        return i * 1000;
    }

    public static int getCibnStreamFormat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1571547507")) {
            return ((Integer) ipChange.ipc$dispatch("-1571547507", new Object[0])).intValue();
        }
        String str = "1";
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_CIBN_STREAM_FORMAT", str);
        if (!TextUtils.isEmpty(config)) {
            str = config;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception unused) {
            return 1;
        }
    }

    public static double getDouble(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033709776")) {
            return ((Double) ipChange.ipc$dispatch("-1033709776", new Object[]{str, Double.valueOf(d)})).doubleValue();
        } else if (str == null) {
            return d;
        } else {
            try {
                return Double.parseDouble(OrangeConfig.getInstance().getConfig("YKLive", str, String.valueOf(d)));
            } catch (Exception e) {
                e.printStackTrace();
                return d;
            }
        }
    }

    public static boolean getEnableImpairmentConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617395546")) {
            return ((Boolean) ipChange.ipc$dispatch("-617395546", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "impairment_monitor_enable", "false"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean getEnableTimeShiftPopupConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288724971")) {
            return ((Boolean) ipChange.ipc$dispatch("288724971", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "time_shift_popup_enable", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static float getFloat(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1329385627")) {
            return ((Float) ipChange.ipc$dispatch("1329385627", new Object[]{str, Float.valueOf(f)})).floatValue();
        } else if (str == null) {
            return f;
        } else {
            try {
                return Float.parseFloat(OrangeConfig.getInstance().getConfig("YKLive", str, String.valueOf(f)));
            } catch (Exception e) {
                e.printStackTrace();
                return f;
            }
        }
    }

    public static int getGifDowngradeAndroidVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881482876")) {
            return ((Integer) ipChange.ipc$dispatch("881482876", new Object[0])).intValue();
        }
        String str = "0";
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_GIF_DOWNGRADE_ANDROID_VERSION", str);
        if (!TextUtils.isEmpty(config)) {
            str = config;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getGifDowngradePercentage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802200107")) {
            return ((Integer) ipChange.ipc$dispatch("802200107", new Object[0])).intValue();
        }
        String str = "0";
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_GIF_DOWNGRADE_PERCENTAGE", str);
        if (!TextUtils.isEmpty(config)) {
            str = config;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getImpairmentCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403834631")) {
            return ((Integer) ipChange.ipc$dispatch("403834631", new Object[0])).intValue();
        }
        try {
            return Integer.parseInt(OrangeConfig.getInstance().getConfig("YKLive", "impairment_count", "2"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 2;
        }
    }

    public static long getImpairmentTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427499858")) {
            return ((Long) ipChange.ipc$dispatch("-1427499858", new Object[0])).longValue();
        }
        try {
            return (long) Integer.parseInt(OrangeConfig.getInstance().getConfig("YKLive", "impairment_time", "10000"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 10000;
        }
    }

    public static int getInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692247372")) {
            return ((Integer) ipChange.ipc$dispatch("-692247372", new Object[]{str, Integer.valueOf(i)})).intValue();
        } else if (str == null) {
            return i;
        } else {
            try {
                return Integer.parseInt(OrangeConfig.getInstance().getConfig("YKLive", str, String.valueOf(i)));
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
    }

    public static String getJsBundle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502376190")) {
            return (String) ipChange.ipc$dispatch("502376190", new Object[]{str});
        }
        OrangeConfig instance = OrangeConfig.getInstance();
        return instance.getConfig("YKLive", str + "_liveRoomUrl", null);
    }

    public static String getLiveLogUpload() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "176728402") ? (String) ipChange.ipc$dispatch("176728402", new Object[0]) : OrangeConfig.getInstance().getConfig(LIVE_LOG_UPLOAD, "YKLPlayLogEnable", "1");
    }

    public static long getLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411766105")) {
            return ((Long) ipChange.ipc$dispatch("-411766105", new Object[]{str, Long.valueOf(j)})).longValue();
        } else if (str == null) {
            return j;
        } else {
            try {
                return Long.parseLong(OrangeConfig.getInstance().getConfig("YKLive", str, String.valueOf(j)));
            } catch (Exception e) {
                e.printStackTrace();
                return j;
            }
        }
    }

    public static long getLowSpeedConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815251970")) {
            return ((Long) ipChange.ipc$dispatch("1815251970", new Object[0])).longValue();
        }
        try {
            return (long) Integer.parseInt(OrangeConfig.getInstance().getConfig("YKLive", "impairment_low_net_speed", MessageService.MSG_DB_COMPLETE));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 100;
        }
    }

    public static String getNativePlayerBlacklistConfigs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2111024745") ? (String) ipChange.ipc$dispatch("2111024745", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLiveRoom_ABTest", "nw_black_list", "");
    }

    public static long getPlayEndLimitTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085612438")) {
            return ((Long) ipChange.ipc$dispatch("2085612438", new Object[0])).longValue();
        }
        try {
            return Long.parseLong(OrangeConfig.getInstance().getConfig("YKLive", "play_end_limit", "100000"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 100000;
        }
    }

    public static String getString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548471718")) {
            return (String) ipChange.ipc$dispatch("-1548471718", new Object[]{str, str2});
        } else if (str == null) {
            return str2;
        } else {
            try {
                return OrangeConfig.getInstance().getConfig("YKLive", str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        }
    }

    public static String getUsePasSRooms() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1795530909") ? (String) ipChange.ipc$dispatch("1795530909", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLiveRoom_ABTest", "pass_plus_container_white_list", "");
    }

    public static boolean hideFullScreenModuleLiveId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912979343")) {
            return ((Boolean) ipChange.ipc$dispatch("912979343", new Object[]{str})).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "hideFullScreenModuleLiveId", "");
        try {
            if (!TextUtils.isEmpty(config)) {
                for (String str2 : config.split(",")) {
                    if (str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isDanmakuUseNewPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946509419")) {
            return ((Boolean) ipChange.ipc$dispatch("-946509419", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig(LIVE_DANMAKU_GROUP_NAME, "PAINT_NEW", "0");
        if (config == null || config.compareToIgnoreCase("1") != 0) {
            return false;
        }
        return true;
    }

    public static boolean isLiveDolbyOpen() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "11739569")) {
            return ((Boolean) ipChange.ipc$dispatch("11739569", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_LIVE_DOLBY_OPEN", "1");
        if (TextUtils.isEmpty(config) || config.trim().length() > 1) {
            return true;
        }
        if (!"0".equals(config.trim()) && !"1".equals(config.trim())) {
            return true;
        }
        try {
            if (Integer.parseInt(config.trim()) != 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isLiveNaviLaifengEnable() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-608748246")) {
            return ((Boolean) ipChange.ipc$dispatch("-608748246", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_BANNER_REQUEST_ENABLE", "1");
        if (TextUtils.isEmpty(config) || config.trim().length() > 1) {
            return true;
        }
        if (!"0".equals(config.trim()) && !"1".equals(config.trim())) {
            return true;
        }
        try {
            if (Integer.parseInt(config.trim()) != 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isLiveNaviOpenSEI() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "149349804")) {
            return ((Boolean) ipChange.ipc$dispatch("149349804", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_LIVE_NAVI_OPEN_SEI", "1");
        if (TextUtils.isEmpty(config) || config.trim().length() > 1) {
            return true;
        }
        if (!"0".equals(config.trim()) && !"1".equals(config.trim())) {
            return true;
        }
        try {
            if (Integer.parseInt(config.trim()) != 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isOpenNewCombSend() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2104612216")) {
            return ((Boolean) ipChange.ipc$dispatch("-2104612216", new Object[0])).booleanValue();
        }
        try {
            if (1 == Integer.parseInt(OrangeConfig.getInstance().getConfig(LIVE_GIFT_COMB_NAME, "combo_button_effects", "1"))) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isOrangeDanmuDefaultClose() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "2037257637")) {
            return ((Boolean) ipChange.ipc$dispatch("2037257637", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "YKL_DANMU_DEFAULT_STATUS", "0");
        if (TextUtils.isEmpty(config) || config.trim().length() > 1) {
            return true;
        }
        if (!"0".equals(config.trim()) && !"1".equals(config.trim())) {
            return true;
        }
        try {
            if (Integer.parseInt(config.trim()) != 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isPcdnEnabled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613163549")) {
            return ((Boolean) ipChange.ipc$dispatch("-1613163549", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "PCDN_ENABLED", "1");
        if (config == null || config.compareToIgnoreCase("1") == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPlayerUseQualitySmooth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843510428")) {
            return ((Boolean) ipChange.ipc$dispatch("-843510428", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "PLAYER_QUALITY_SMOOTH", "1");
        if (config == null || config.compareToIgnoreCase("1") == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPlayerUseSceneSmooth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371512713")) {
            return ((Boolean) ipChange.ipc$dispatch("-371512713", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "PLAYER_SCENE_SMOOTH", "1");
        if (config == null || config.compareToIgnoreCase("1") == 0) {
            return true;
        }
        return false;
    }

    public static boolean isUseCacheInSVGAAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834003037")) {
            return ((Boolean) ipChange.ipc$dispatch("834003037", new Object[0])).booleanValue();
        }
        if (1 == ParseUtils.parse2Int(OrangeConfig.getInstance().getConfig(LIVE_GIFT_COMB_NAME, "svga_use_cache", "0"))) {
            return true;
        }
        return false;
    }

    public static boolean isUseFlameDanMu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114068486")) {
            return ((Boolean) ipChange.ipc$dispatch("-2114068486", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "use_flame_dan_mu", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean needDowngradeToNativeRoom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822120273")) {
            return ((Boolean) ipChange.ipc$dispatch("822120273", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "systemVersion", "");
        try {
            Log.d("YKLive", "needDowngradeToNativeRoom >> 系统版本 = " + config);
            if (!TextUtils.isEmpty(config)) {
                for (String str : config.split(",")) {
                    if (str.equals(Build.VERSION.getRELEASE())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        String config2 = OrangeConfig.getInstance().getConfig("YKLive", "systemModel", "");
        try {
            Log.d("YKLive", "needDowngradeToNativeRoom >> 设备型号 = " + config2);
            if (!TextUtils.isEmpty(config2)) {
                for (String str2 : config2.split(",")) {
                    if (str2.equals(Build.getMODEL())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        String config3 = OrangeConfig.getInstance().getConfig("YKLive", "downgradeToNativeRoom", "");
        try {
            Log.d("YKLive", "needDowngradeToNativeRoom >> downngradeToNativeRoom = " + config3);
            return Boolean.parseBoolean(config3);
        } catch (Exception unused3) {
            return false;
        }
    }

    public static String projectionBlackList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "576903189") ? (String) ipChange.ipc$dispatch("576903189", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLive", "player_multiscreen_black_list", "");
    }

    public static boolean showChatHistory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955442974")) {
            return ((Boolean) ipChange.ipc$dispatch("1955442974", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "showChatHistory", "true");
        if (config == null || !config.equalsIgnoreCase("true")) {
            return false;
        }
        return true;
    }

    public static boolean supportColdStartPreload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961969123")) {
            return ((Boolean) ipChange.ipc$dispatch("961969123", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "support_cold_start_preload", "1");
        if (config == null || config.length() <= 0 || config.compareToIgnoreCase("1") != 0) {
            return false;
        }
        return true;
    }

    public static String supportFreeFlow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1331411344") ? (String) ipChange.ipc$dispatch("1331411344", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLive", "support_free_flow", "");
    }

    public static boolean supportGiftTrackEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786804306")) {
            return ((Boolean) ipChange.ipc$dispatch("-786804306", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig(LIVE_DANMAKU_GROUP_NAME, "GIFT_TRACK_END", "0");
        if (config == null || config.compareToIgnoreCase("1") != 0) {
            return false;
        }
        return true;
    }

    public static boolean supportPlayerPauseBugFix191014() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731298268")) {
            return ((Boolean) ipChange.ipc$dispatch("-731298268", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig(LIVE_PLAYER_GROUP_NAME, "PLAYER_PAUSE", "1");
        if (config == null || config.compareToIgnoreCase("1") == 0) {
            return true;
        }
        return false;
    }

    public static boolean supportYoukuLiveDanmaku() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-580215596") ? ((Boolean) ipChange.ipc$dispatch("-580215596", new Object[0])).booleanValue() : getBoolean("support20190114YoukuLiveDanmaku", true);
    }

    public static String useNativePlayerByLiveId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "186614116") ? (String) ipChange.ipc$dispatch("186614116", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLive", "native_player_liveIds", "");
    }

    public static boolean useNativePlayerConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1066498916")) {
            return ((Boolean) ipChange.ipc$dispatch("-1066498916", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "native_player_enable", "false"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String useNativePlayerConfigs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1393139423") ? (String) ipChange.ipc$dispatch("-1393139423", new Object[0]) : OrangeConfig.getInstance().getConfig("YKLiveRoom_ABTest", "nw_white_list", jl1.MUL);
    }

    public static boolean useNewPlayerConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309432281")) {
            return ((Boolean) ipChange.ipc$dispatch("309432281", new Object[0])).booleanValue();
        }
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig("YKLive", "use_new_player", "false"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean userHardware() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28863842")) {
            return ((Boolean) ipChange.ipc$dispatch("28863842", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", "systemVersion-software", "");
        try {
            Log.d("YKLive", "userHardware >> 系统版本 = " + config);
            if (!TextUtils.isEmpty(config)) {
                for (String str : config.split(",")) {
                    if (str.equalsIgnoreCase(Build.VERSION.getRELEASE())) {
                        return false;
                    }
                }
            }
        } catch (Exception unused) {
        }
        String config2 = OrangeConfig.getInstance().getConfig("YKLive", "systemModel-software", "");
        try {
            Log.d("YKLive", "userHardware >> 设备型号 = " + config2);
            if (!TextUtils.isEmpty(config2)) {
                for (String str2 : config2.split(",")) {
                    if (str2.equalsIgnoreCase(Build.getMODEL())) {
                        return false;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        String config3 = OrangeConfig.getInstance().getConfig("YKLive", "systemManufacture-software", "");
        try {
            Log.d("YKLive", "userHardware >> 设备品牌 = " + config2);
            if (TextUtils.isEmpty(config3)) {
                return true;
            }
            for (String str3 : config3.split(",")) {
                if (str3.equalsIgnoreCase(Build.getMANUFACTURER())) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused3) {
            return true;
        }
    }
}
