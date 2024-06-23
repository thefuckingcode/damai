package com.youku.playerservice.axp.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.application.common.b;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import com.youku.arch.analysis.net.c;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.constants.NetType;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: Taobao */
public class UpsUtil {
    public static final String TAG = "UpsUtil";

    /* renamed from: com.youku.playerservice.axp.utils.UpsUtil$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$playerservice$axp$constants$NetType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[NetType.values().length];
            $SwitchMap$com$youku$playerservice$axp$constants$NetType = iArr;
            iArr[NetType.WIFI.ordinal()] = 1;
            $SwitchMap$com$youku$playerservice$axp$constants$NetType[NetType.G2.ordinal()] = 2;
            $SwitchMap$com$youku$playerservice$axp$constants$NetType[NetType.G3.ordinal()] = 3;
            try {
                $SwitchMap$com$youku$playerservice$axp$constants$NetType[NetType.G4.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    private enum Ability {
        HDR_50FPS_720P,
        HDR_50FPS_1080P,
        HDR_50FPS_4K,
        HDR_TRY_STREAM,
        PWHDR_50FPS,
        PWHDR_720P,
        PWHDR_1080P,
        AD_MANTIANXING,
        HDR_SUPPORT,
        HDR_4K_SUPPORT,
        STREAM_AD_REAL_VIDEO_SEPARATE,
        ON_SITE_HDR_SUPPORT,
        DRM_SUPPORT,
        RESERVED_0,
        CACHE_SHOW_ALL_DEF,
        FOUR_K_SUPPORT,
        HDR10,
        HBR,
        HBR_HD3,
        HBR_2K,
        HBR_4K,
        HBR_HFR,
        HBR_PW,
        AV1,
        MULTI_SUBTITLES,
        HBR_120,
        RESERVED_1,
        BIT_10;

        /* access modifiers changed from: package-private */
        public int getBit() {
            return 1 << ordinal();
        }
    }

    public static void addUpsParams(Context context, Map<String, String> map) {
        map.put(IRequestConst.MDL, getTextEncoder(Build.getMODEL()));
        map.put("device_score", getDeviceScore(context) + "");
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            map.put("chipset", Utils.getCpuName(context));
        }
        map.put(AdUtConstants.XAD_UT_ARG_MEDIA_TYPE, getMediaType());
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            map.put("abrMode", getABRResPref4G(context));
            map.put("device_score", getDeviceScore(context) + "");
        }
        if (ProvisionAuthenticator.getWidevineLevel() == ProvisionAuthenticator.WidevineLevel.L1) {
            map.put("drm_level", "1");
        }
    }

    public static void addUpsParams(Context context, Map<String, String> map, PlayParams playParams) {
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            map.put("net_status", c.a().b().a() + "");
            map.put("preferClarity", String.valueOf(playParams.getPlayIdParams().getRequestQuality().getUpsCode()));
            map.put("last_clarity", QualityUtil.getLastQuality(context) + "");
            map.put("clarity_chg_ts", QualityUtil.getLastQualityChangeTs(context) + "");
        }
        map.put("spdl", playParams.getPlayIdParams().getLanguageCode());
    }

    public static String convertPlayerAbility(@NonNull PlayerConfig playerConfig) {
        return "";
    }

    public static String convertPlayerCloseAblity(@Nullable Context context, @NonNull PlayerConfig playerConfig) {
        return "";
    }

    public static String getABRResPref4G(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("abr_pref4g", "0");
    }

    private static int getDeviceScore(Context context) {
        return b.d().getInt("oldDeviceScore", context.getApplicationContext().getSharedPreferences("device_score", 0).getInt("device_score", -1));
    }

    private static String getMediaType() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Point.STANDARD);
        stringBuffer.append(",audio");
        if (ApsUtil.enableSubtitle()) {
            stringBuffer.append(",subtitle");
        }
        if (ApsUtil.enableSei()) {
            stringBuffer.append(",sei");
        }
        stringBuffer.append(",playconf");
        return stringBuffer.toString();
    }

    public static String getNetType(Context context) {
        int i = AnonymousClass1.$SwitchMap$com$youku$playerservice$axp$constants$NetType[NetworkUtil.getNetType(context).ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4) ? UpsConstant.UPS_NETWORK_4G : UpsConstant.UPS_NETWORK_UNKOWN : "1000";
    }

    public static String getTextEncoder(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getUpsHostFromSp(Context context) {
        return context != null ? context.getSharedPreferences("networkDialog", 4).getString("network_ups_host", "") : "";
    }

    public static String getUpsIpFromSp(Context context) {
        return context != null ? context.getSharedPreferences("networkDialog", 4).getString("network_ups_ip", "") : "";
    }

    public static boolean isExistsScreenFile(Context context) {
        if (context != null) {
            try {
                if (context.getExternalCacheDir() != null) {
                    String str = context.getExternalCacheDir().getAbsolutePath() + "/player_file_special/1001.json";
                    TLogUtil.playUerActionLog("屏幕矫正文件地址: " + str);
                    return new File(str).exists();
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
