package com.youku.alixplayer.opensdk.statistics;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.drm.DrmType;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.SystemUtils;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.gl1;

/* compiled from: Taobao */
public class TrackUtil {
    public static final String TAG = "TrackUtil";
    private static String mCpuName = "";

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.alixplayer.opensdk.statistics.TrackUtil$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[DrmType.values().length];
            $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType = iArr;
            iArr[DrmType.COPYRIGHT.ordinal()] = 1;
            $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.CHINA.ordinal()] = 2;
            $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.WIDEVINE.ordinal()] = 3;
            $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.WV_CBCS.ordinal()] = 4;
            $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.WV_CENC.ordinal()] = 5;
        }
    }

    public static String KeyValue(@NonNull String str, String str2, String str3, @NonNull String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            for (String str5 : str.split(str2)) {
                String[] split = str5.split(str3);
                if (split.length >= 2 && str4.equals(split[0])) {
                    return split[1];
                }
            }
        }
        return null;
    }

    public static void commitControlStartClarity(Map<String, String> map, Map<String, Double> map2) {
        printlog("ControlStartClarity", "", map, map2);
        VpmProxy.commitControlStartClarityStatistics(map, map2);
    }

    public static void commitPlayAlarmError(String str, String str2) {
        commitPlayAlarmError(str, str2, null, null);
    }

    public static String getCpuName(Context context) {
        if (!TextUtils.isEmpty(mCpuName)) {
            Logger.d("TrackUtil", "cup name is saved :" + mCpuName);
            return mCpuName;
        }
        mCpuName = getPropString(context, "ro.board.platform");
        Logger.d("TrackUtil", "get ro.board.platform --> " + mCpuName);
        return mCpuName;
    }

    public static String getDecodingType(Track track) {
        return track.getTable(MSGTABLEID.ONEPLAY).getDimensions().get("decodingType");
    }

    public static String getDimension(Track track, String str) {
        Table table = track.mVPM.getTable(MSGTABLEID.ONEPLAY);
        if (table != null) {
            return table.getDimensions().get(str);
        }
        return null;
    }

    private static String getDolbyVideoFormat(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        return str.substring(8);
    }

    public static double getDoubleValue(String str) {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception e) {
            e.getStackTrace();
            return -1.0d;
        }
    }

    public static double getDoubleValueForPlayErrInfo(String str) {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception unused) {
            VpmProxy.alarmCommitFail("vpm", "commitPlayErrInfoStatistics", "02", str);
            return 0.0d;
        }
    }

    public static String getDrmType(Track track) {
        BitStream currentBitStream;
        IVideoStream videoStream = track.getPlayerContainer().getVideoStream();
        if (videoStream == null || (currentBitStream = videoStream.getCurrentBitStream()) == null) {
            return "0";
        }
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.getDrmByStr(currentBitStream.getDrmType()).ordinal()];
        if (i == 1) {
            return "2";
        }
        if (i == 2) {
            return "3";
        }
        if (i == 3) {
            return "4";
        }
        if (i == 4) {
            return "5";
        }
        if (i != 5) {
            return "0";
        }
        return "6";
    }

    public static String getFileFormatByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains(".mp4") || str.contains(".m5v")) {
            return "0";
        }
        if (str.contains(".m3u8") || str.contains(".ts")) {
            return "1";
        }
        if (str.contains(".flv")) {
            return "3";
        }
        if (str.contains(".mp5")) {
            return "4";
        }
        return str.contains("artp://") ? "7" : "-1";
    }

    public static String getPlayWay(@NonNull Track track, YoukuVideoInfo youkuVideoInfo) {
        return track.getOnePlayTrack().getPlayWay(youkuVideoInfo);
    }

    private static String getPropString(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getPsId(YoukuVideoInfo youkuVideoInfo) {
        if (youkuVideoInfo == null || youkuVideoInfo.getUpsVideoInfo() == null || youkuVideoInfo.getUpsVideoInfo().getUps() == null) {
            return null;
        }
        return youkuVideoInfo.getUpsVideoInfo().getUps().psid;
    }

    public static String getStartClarity(YoukuVideoInfo youkuVideoInfo) {
        return (youkuVideoInfo == null || youkuVideoInfo.getUpsVideoInfo() == null || youkuVideoInfo.getUpsVideoInfo().getController() == null) ? "null" : String.valueOf(youkuVideoInfo.getUpsVideoInfo().getController().startClarity);
    }

    public static String getValueByKeyFromUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return Uri.parse(str).getQueryParameter(str2);
        }
        return null;
    }

    public static String getVideoFormat(Quality quality, String str) {
        String description = quality.getDescription();
        if (quality == Quality.DOLBY) {
            description = getDolbyVideoFormat(str);
        }
        return TextUtils.isEmpty(description) ? "-1" : description;
    }

    public static boolean isAuto(PlayVideoInfo playVideoInfo) {
        return playVideoInfo != null && playVideoInfo.getRequestQuality() == Quality.AUTO;
    }

    public static <T> boolean log(String str, Map<String, T> map) {
        if (!SystemUtils.isDebug() || str == null || map == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (!(key == null || value == null)) {
                stringBuffer.append(key);
                stringBuffer.append("=");
                stringBuffer.append((Object) value);
                stringBuffer.append(StringUtils.LF);
            }
        }
        System.out.println();
        Logger.d(str, stringBuffer.toString());
        return true;
    }

    public static <T> String map2String(Map<String, T> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (key != null) {
                stringBuffer.append(key);
                stringBuffer.append("=");
                stringBuffer.append((Object) value);
                stringBuffer.append(StringUtils.LF);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean printlog(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        if (!SystemUtils.isDebug() || str == null || map == null || map2 == null) {
            return false;
        }
        Logger.d(str, "#################################开始 " + str2 + " #####################################");
        printlog(str, map);
        printlog(str, map2);
        Logger.d(str, "##################################结束 " + str2 + " ####################################");
        return true;
    }

    public static void commitPlayAlarmError(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", str);
        hashMap.put("errorMsg", str2);
        hashMap.put(TableField.VV_SOURCE, str3);
        hashMap.put("vvId", str4);
        VpmProxy.commitPlayAlarmErrorStatistics(hashMap, new HashMap());
    }

    private static <T> void printlog(String str, Map<String, T> map) {
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (key != null) {
                Logger.d(str, key + "=" + ((Object) value));
            }
        }
    }

    public static void log(String str, String str2) {
        Logger.d(str, str2);
    }
}
