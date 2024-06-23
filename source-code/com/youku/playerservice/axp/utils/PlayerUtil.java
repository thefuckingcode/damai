package com.youku.playerservice.axp.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.taobao.application.common.b;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.weex.annotation.JSMethod;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.android.liveservice.bean.Artp;
import com.youku.android.liveservice.bean.Grtn;
import com.youku.android.liveservice.bean.Hls;
import com.youku.android.liveservice.bean.HttpFlv;
import com.youku.android.liveservice.bean.Mcs;
import com.youku.android.liveservice.bean.Rtp;
import com.youku.core.context.YoukuContext;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.phone.freeflow.YKFreeFlowResult;
import com.youku.phone.freeflow.YoukuFreeFlowApi;
import com.youku.phone.freeflow.model.CarrierType;
import com.youku.vo.LanguageBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class PlayerUtil {
    public static boolean has265Failed;

    public static String completionVid(String str) {
        StringBuilder sb;
        String str2;
        if ("".equals(str) || !str.substring(0, 1).equals("X")) {
            return str;
        }
        int length = str.substring(1).getBytes().length % 4;
        if (length == 3) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "=";
        } else if (length != 2) {
            return str;
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = jl1.EQUAL2;
        }
        sb.append(str2);
        return sb.toString();
    }

    public static String getAbilityJson(boolean z) {
        return getAbilityJsonInJsonObject(z).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00be A[Catch:{ JSONException -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c6 A[Catch:{ JSONException -> 0x00e4 }] */
    public static JSONObject getAbilityJsonInJsonObject(boolean z) {
        String str;
        YKFreeFlowResult yKFreeFlowResult;
        String str2 = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hbrPlay", ConfigFetcher.getInstance().getConfig("z_real_config", "live_z_real_enable", "0"));
            jSONObject.put("ahbrPlay", 1);
            jSONObject.put("abrPlay", ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_abr", str2));
            String str3 = LiveManager.StreamConfig.QTY_1080P;
            if (str2.equals(ConfigFetcher.getInstance().getConfig("youku_player_config", "force_show_4k", "0")) || str2.equals(ConfigFetcher.getInstance().getConfig("player_config", "4k_support", "0"))) {
                str3 = "4k";
            }
            String config = ConfigFetcher.getInstance().getConfig("z_real_config", "max_fps", "50");
            jSONObject.put("decode_resolution_FPS", str3 + JSMethod.NOT_SET + config);
            if (!has265Failed) {
                if (z) {
                    str = getDecode();
                    jSONObject.put(ImageStatistics.KEY_BITMAP_DECODE, str);
                    jSONObject.put("decodeMode", getDecodeMode());
                    jSONObject.put("fansPlay", !"0".equals(ConfigFetcher.getInstance().getConfig("live_multi_view_config", "fansPlay", "0")) ? 1 : 0);
                    yKFreeFlowResult = null;
                    if (FeatureManager.getInstance().hasFreeFlow()) {
                        yKFreeFlowResult = YoukuFreeFlowApi.getFreeFlowResult("live");
                    }
                    if (yKFreeFlowResult != null) {
                        CarrierType carrierType = yKFreeFlowResult.getCarrierType();
                        if (carrierType != CarrierType.MOBILE) {
                            if (carrierType == CarrierType.UNICOM) {
                                str2 = "2";
                            } else if (carrierType == CarrierType.TELECOM) {
                                str2 = "3";
                            }
                        }
                        jSONObject.put("ct_type", str2);
                        return jSONObject;
                    }
                    str2 = "0";
                    jSONObject.put("ct_type", str2);
                    return jSONObject;
                }
            }
            str = "H264";
            TLogUtil.playLog("播放器h265播放报错或者业务层指定不使用h265，则能力改为不支持h265");
            jSONObject.put(ImageStatistics.KEY_BITMAP_DECODE, str);
            jSONObject.put("decodeMode", getDecodeMode());
            jSONObject.put("fansPlay", !"0".equals(ConfigFetcher.getInstance().getConfig("live_multi_view_config", "fansPlay", "0")) ? 1 : 0);
            yKFreeFlowResult = null;
            if (FeatureManager.getInstance().hasFreeFlow()) {
            }
            if (yKFreeFlowResult != null) {
            }
            str2 = "0";
            jSONObject.put("ct_type", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c9 A[Catch:{ JSONException -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ca A[Catch:{ JSONException -> 0x00df }] */
    public static JSONObject getAbilityJsonInJsonObject(boolean z, Context context) {
        String str;
        YKFreeFlowResult freeFlowResult;
        CarrierType carrierType;
        String str2 = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hbrPlay", ConfigFetcher.getInstance().getConfig("z_real_config", "live_z_real_enable", "0"));
            jSONObject.put("ahbrPlay", 1);
            jSONObject.put("abrPlay", ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_abr", str2));
            String str3 = LiveManager.StreamConfig.QTY_1080P;
            if (str2.equals(ConfigFetcher.getInstance().getConfig("youku_player_config", "force_show_4k", "0")) || str2.equals(ConfigFetcher.getInstance().getConfig("player_config", "4k_support", "0"))) {
                str3 = "4k";
            }
            String config = ConfigFetcher.getInstance().getConfig("z_real_config", "max_fps", "50");
            jSONObject.put("decode_resolution_FPS", str3 + JSMethod.NOT_SET + config);
            if (!has265Failed) {
                if (z) {
                    str = getDecode();
                    jSONObject.put(ImageStatistics.KEY_BITMAP_DECODE, str);
                    jSONObject.put("decodeMode", getDecodeMode());
                    jSONObject.put("fansPlay", !"0".equals(ConfigFetcher.getInstance().getConfig("live_multi_view_config", "fansPlay", "0")) ? 1 : 0);
                    if (Utils.isYoukuOrHuaweiBaipai(context) && (freeFlowResult = YoukuFreeFlowApi.getFreeFlowResult("live")) != null) {
                        carrierType = freeFlowResult.getCarrierType();
                        if (carrierType == CarrierType.MOBILE) {
                            if (carrierType == CarrierType.UNICOM) {
                                str2 = "2";
                            } else if (carrierType == CarrierType.TELECOM) {
                                str2 = "3";
                            }
                        }
                        jSONObject.put("ct_type", str2);
                        return jSONObject;
                    }
                    str2 = "0";
                    jSONObject.put("ct_type", str2);
                    return jSONObject;
                }
            }
            str = "H264";
            TLogUtil.playLog("播放器h265播放报错或者业务层指定不使用h265，则能力改为不支持h265");
            jSONObject.put(ImageStatistics.KEY_BITMAP_DECODE, str);
            jSONObject.put("decodeMode", getDecodeMode());
            jSONObject.put("fansPlay", !"0".equals(ConfigFetcher.getInstance().getConfig("live_multi_view_config", "fansPlay", "0")) ? 1 : 0);
            carrierType = freeFlowResult.getCarrierType();
            if (carrierType == CarrierType.MOBILE) {
            }
            jSONObject.put("ct_type", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String getDecode() {
        return ConfigFetcher.getInstance().getConfig("live_player_config", ImageStatistics.KEY_BITMAP_DECODE, "H265");
    }

    public static String getDecodeMode() {
        return ConfigFetcher.getInstance().getConfig("live_player_config", "decode_mode", "HW");
    }

    public static int getDeviceScore() {
        return b.d().getInt("oldDeviceScore", YoukuContext.getApplicationContext().getSharedPreferences("device_score", 0).getInt("device_score", -1));
    }

    public static String getLanguageCodeById(int i) {
        LanguageBean[] languageBeanArr = LanguageBean.ALL_LANGAUGE;
        for (LanguageBean languageBean : languageBeanArr) {
            if (i == languageBean.id) {
                return languageBean.code;
            }
        }
        return LanguageBean.ALL_LANGAUGE[0].code;
    }

    public static Artp getPlayArtp(Mcs mcs, int i) {
        List<Artp> list = mcs.ms.playInfo.artp;
        if (list != null && list.size() > 0) {
            for (Artp artp : mcs.ms.playInfo.artp) {
                if (artp.idx == i) {
                    return artp;
                }
            }
        }
        return null;
    }

    public static HttpFlv getPlayFlv(Mcs mcs, int i) {
        List<HttpFlv> list = mcs.ms.playInfo.httpFlv;
        if (list != null && list.size() > 0) {
            for (HttpFlv httpFlv : mcs.ms.playInfo.httpFlv) {
                if (httpFlv.idx == i) {
                    return httpFlv;
                }
            }
        }
        return null;
    }

    public static Grtn getPlayGrtn(Mcs mcs, int i) {
        List<Grtn> list = mcs.ms.playInfo.grtn;
        if (list != null && list.size() > 0) {
            for (Grtn grtn : mcs.ms.playInfo.grtn) {
                if (grtn.idx == i) {
                    return grtn;
                }
            }
        }
        return null;
    }

    public static Hls getPlayHls(Mcs mcs, int i) {
        List<Hls> list = mcs.ms.playInfo.hls;
        if (list != null && list.size() > 0) {
            for (Hls hls : mcs.ms.playInfo.hls) {
                if (hls.idx == i) {
                    return hls;
                }
            }
        }
        return null;
    }

    public static Rtp getPlayRtp(Mcs mcs, int i) {
        List<Rtp> list = mcs.ms.playInfo.rtp;
        if (list != null && list.size() > 0) {
            for (Rtp rtp : mcs.ms.playInfo.rtp) {
                if (rtp.idx == i) {
                    return rtp;
                }
            }
        }
        return null;
    }

    public static boolean isFeed(String str) {
        try {
            float parseFloat = Float.parseFloat(str);
            return parseFloat >= 2.0f && parseFloat < 4.0f;
        } catch (Exception unused) {
            TLogUtil.flowLog(null, "playerSource转换Float失败 " + str);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static boolean isShowId(String str) {
        int length = str.length();
        ?? startsWith = str.startsWith("z");
        int i = length - startsWith;
        int i2 = startsWith;
        if (i != 20) {
            return false;
        }
        while (i2 < length) {
            char charAt = str.charAt(i2 == 1 ? 1 : 0);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'F') && (charAt < 'a' || charAt > 'f'))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean isSkipHeadAndTail(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("skip_head", true);
    }

    public static boolean isVid(String str) {
        return TextUtils.isEmpty(str) || !isShowId(str);
    }

    public static String urlEncoder(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
