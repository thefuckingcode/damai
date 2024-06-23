package com.youku.playerservice.axp.cache.task;

import android.content.Context;
import android.preference.PreferenceManager;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.phone.YoukuTmp;
import com.youku.phone.keycenter.YkKeyCenterConstant;
import com.youku.playerservice.axp.DrmConfig;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.MinsetPreloadInfo;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.request.QGetUpsRequest;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.playhistory.PlayHistory;
import com.youku.playhistory.data.PlayHistoryInfo;
import com.youku.vip.info.VipUserService;
import com.youku.vpm.constants.TableField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class MinsetTask extends CacheTask {
    private Context mContext;
    private Map<String, String> mExtParams;
    private List<MinsetPreloadInfo> mMinsetPreloadInfos;
    private IPlayInfoRequest.Callback mPlayInfoRequestCallback = new IPlayInfoRequest.Callback() {
        /* class com.youku.playerservice.axp.cache.task.MinsetTask.AnonymousClass1 */

        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(PlayParams playParams, List<PlayInfoResponse> list) {
            if (list != null && list.size() > 0) {
                CachePool.getInstance().savePlayInfoResponseList(MinsetTask.this.mContext, list);
            }
        }
    };

    public MinsetTask(Context context, List<MinsetPreloadInfo> list, Map<String, String> map) {
        this.mContext = context;
        this.mMinsetPreloadInfos = list;
        this.mExtParams = map;
    }

    private void filterPlayerSourceTag(List<MinsetPreloadInfo> list, boolean z) {
        if (!(list == null || list.size() == 0)) {
            ArrayMap arrayMap = new ArrayMap();
            for (MinsetPreloadInfo minsetPreloadInfo : list) {
                if (minsetPreloadInfo != null) {
                    String str = minsetPreloadInfo.playerSource;
                    if (TextUtils.isEmpty(str)) {
                        str = "1";
                    }
                    List list2 = (List) arrayMap.get(str);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(minsetPreloadInfo);
                        arrayMap.put(str, arrayList);
                    } else {
                        list2.add(minsetPreloadInfo);
                    }
                }
            }
            for (Map.Entry entry : arrayMap.entrySet()) {
                preloadMinInfoObject((List) entry.getValue(), z, (String) entry.getKey());
            }
        }
    }

    private void getMultiUpsByQGet(List<MinsetPreloadInfo> list, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MinsetPreloadInfo minsetPreloadInfo = list.get(i);
            if (minsetPreloadInfo != null && (!ApsUtil.enableMinVideoCacheCheck(str) || !CachePool.getInstance().checkPlayInfoResponseExist(this.mContext, PlayDefinition.PlayInfoType.UPS, minsetPreloadInfo.vid, str))) {
                arrayList.add(minsetPreloadInfo);
            }
        }
        JSONArray jSONArray = new JSONArray();
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            MinsetPreloadInfo minsetPreloadInfo2 = (MinsetPreloadInfo) it.next();
            if (!TextUtils.isEmpty(minsetPreloadInfo2.vid)) {
                try {
                    PlayHistoryInfo byIdExceptHighlights = PlayHistory.getByIdExceptHighlights(this.mContext, minsetPreloadInfo2.vid);
                    JSONObject jSONObject = new JSONObject();
                    String str7 = minsetPreloadInfo2.vid;
                    if (byIdExceptHighlights != null) {
                        String str8 = PlayerUtil.isShowId(str7) ? minsetPreloadInfo2.vid : str2;
                        String str9 = byIdExceptHighlights.videoId;
                        if (byIdExceptHighlights.point > 10 && !byIdExceptHighlights.isPlayEnd()) {
                            minsetPreloadInfo2.startPoint = byIdExceptHighlights.point * 1000;
                        }
                        String languageCodeById = PlayerUtil.getLanguageCodeById(byIdExceptHighlights.lang);
                        if (TextUtils.isEmpty(minsetPreloadInfo2.lang)) {
                            minsetPreloadInfo2.lang = languageCodeById;
                        }
                        str5 = str2;
                        str3 = str9;
                        str4 = str8;
                        str7 = str3;
                    } else {
                        if (PlayerUtil.isShowId(str7)) {
                            str5 = minsetPreloadInfo2.vid;
                            str6 = str2;
                        } else {
                            str6 = minsetPreloadInfo2.vid;
                            str5 = str2;
                        }
                        if (TextUtils.isEmpty(minsetPreloadInfo2.lang)) {
                            minsetPreloadInfo2.lang = "default";
                        }
                        str3 = str6;
                        str4 = str2;
                    }
                    if (!isAlreadCached(str7, minsetPreloadInfo2.lang, str)) {
                        JSONObject put = jSONObject.put("vid", str3);
                        if (TextUtils.isEmpty(str3)) {
                            str2 = str5 + str2;
                        }
                        put.put("showid", str2).put("langcode", minsetPreloadInfo2.lang).put("hpp", minsetPreloadInfo2.startPoint).put("source_spm", minsetPreloadInfo2.spm).put("ext_showid", str4);
                        jSONArray.put(jSONObject);
                        sb.append(str5);
                        sb.append("|");
                        sb.append(str3);
                        sb.append(",");
                    }
                } catch (Exception e) {
                    Logger.e(CacheManager.TAG_MINSET, "vid " + minsetPreloadInfo2.vid + " exception:" + e);
                }
            }
        }
        if (jSONArray.length() > 0) {
            if (Logger.DEBUG) {
                Logger.d(CacheManager.TAG_MINSET, "preload  list--- " + jSONArray.toString());
            }
            PlayerConfig createPlayerConfig = PlayerConfig.createPlayerConfig(this.mContext);
            createPlayerConfig.setDrmConfig(new DrmConfig(this.mExtParams.get("keyindex"), str2));
            QGetUpsRequest qGetUpsRequest = new QGetUpsRequest(createPlayerConfig);
            qGetUpsRequest.setRequestCallback(this.mPlayInfoRequestCallback);
            PlayIdParams playIdParams = new PlayIdParams(jSONArray.toString(), YkKeyCenterConstant.getUpsCCodePlay());
            playIdParams.putAllExtraParams(this.mExtParams);
            playIdParams.putString(TableField.PLAYER_SOURCE, str);
            playIdParams.putExtraParam("ids", URLEncoder.encode(jSONArray.toString(), "utf-8"));
            if (sb.length() > 1) {
                playIdParams.putExtraParam("idsForCkey", sb.deleteCharAt(sb.length() - 1).toString());
            }
            playIdParams.putExtraParam("client_hdr", "1");
            playIdParams.putExtraParam("device_score", PlayerUtil.getDeviceScore() + str2);
            playIdParams.putExtraParam("chipset", Utils.getCpuName(this.mContext));
            playIdParams.putExtraParam("ignaps", "1");
            if (z) {
                playIdParams.putExtraParam(IRequestConst.NEED_AD, "0");
                playIdParams.putExtraParam(IRequestConst.NEED_BF, "2");
            }
            playIdParams.setRequestQuality(Quality.getQualityByCode(getRequestQuality(this.mContext)));
            qGetUpsRequest.request(PlayParams.createPlayParams(PlayDefinition.PlayType.VOD, PlayDefinition.PlayScene.LONG_VIDEO, playIdParams));
        }
    }

    private String getVidFromScheme(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("youku:")) {
            Matcher matcher = Pattern.compile("id=.*?&").matcher(str);
            if (matcher.find()) {
                return str.substring(matcher.start() + 3, matcher.end() - 1);
            }
            return null;
        } else if (TextUtils.isEmpty(str) || !str.contains(WVUtils.URL_SEPARATOR)) {
            return str;
        } else {
            return null;
        }
    }

    private void preloadMinInfoObject(List<MinsetPreloadInfo> list, boolean z, String str) {
        int i;
        if ((VipUserService.getInstance().isVip() ? VipUserService.getInstance().isLightVip() ? "2" : "1" : "0").equals("1") || z) {
            String config = ConfigFetcher.getInstance().getConfig("minset_config", "multiups_preload_switch", "1");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).vid = getVidFromScheme(list.get(i3).vid);
            }
            arrayList.addAll(list);
            if ("1".equals(config)) {
                try {
                    i = Integer.parseInt(ApsUtil.getQGetUpsLimitNum());
                } catch (NumberFormatException unused) {
                    i = 10;
                }
                int size = arrayList.size() / i;
                while (i2 < size + 1) {
                    int i4 = i2 * 10;
                    i2++;
                    int i5 = i2 * 10;
                    try {
                        if (i5 >= arrayList.size()) {
                            i5 = arrayList.size();
                        }
                        getMultiUpsByQGet(arrayList.subList(i4, i5), z, str);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return;
            }
            return;
        }
        Logger.d(CacheManager.TAG_MINSET, "is not vip return");
    }

    @Override // java.util.concurrent.Callable, com.youku.playerservice.axp.cache.task.CacheTask, com.youku.playerservice.axp.cache.task.CacheTask
    public CachePreloadResult call() {
        if (!Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MinsetPreloadInfo minsetPreloadInfo : this.mMinsetPreloadInfos) {
            if (minsetPreloadInfo != null) {
                if (minsetPreloadInfo.disableAD) {
                    arrayList.add(minsetPreloadInfo);
                } else {
                    arrayList2.add(minsetPreloadInfo);
                }
            }
        }
        try {
            if (arrayList.size() > 0) {
                filterPlayerSourceTag(arrayList, true);
            }
            if (arrayList2.size() > 0) {
                filterPlayerSourceTag(arrayList2, false);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean firstTimeOfThisMonth(String str) {
        String format = new SimpleDateFormat("yyyy_MM").format(new Date());
        if (format.equals(YoukuTmp.getPreference(str, ""))) {
            return false;
        }
        YoukuTmp.savePreference(str, format);
        return true;
    }

    public int getRequestQuality(Context context) {
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt("video_quality", -1);
        if (i != 99 || !firstTimeOfThisMonth("firstTimeOfThisMonthForDolby")) {
            return i;
        }
        return 4;
    }

    public boolean isAlreadCached(String str, String str2, String str3) {
        NetUpsInfo upsInfo;
        PlayInfoResponse queryPlayInfoResponse = CachePool.getInstance().queryPlayInfoResponse(this.mContext, PlayDefinition.PlayInfoType.UPS, str, str3);
        if (queryPlayInfoResponse == null || (upsInfo = queryPlayInfoResponse.getUpsInfo()) == null) {
            return false;
        }
        return TextUtils.isEmpty(str2) || "default".equalsIgnoreCase(str2) || str2.equalsIgnoreCase(upsInfo.getLangCode());
    }
}
