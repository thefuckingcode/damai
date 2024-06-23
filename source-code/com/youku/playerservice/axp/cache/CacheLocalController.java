package com.youku.playerservice.axp.cache;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.local.SimpleLocalDataStorage;
import com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoLiveResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class CacheLocalController {
    private static final int STORE_DATA_FROM_LIVE = 1;
    private static final int STORE_DATA_FROM_MAIN_INFO = 4;
    private static final int STORE_DATA_FROM_QINFO = 3;
    private static final int STORE_DATA_FROM_SIMPLE = 2;

    public CacheLocalController(Context context) {
        if (context != null) {
            while (!(context instanceof Application)) {
                try {
                    context = context.getApplicationContext();
                } catch (Exception unused) {
                    return;
                }
            }
            SimpleLocalDataStorage.initInstance(context);
            SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().deleteExpiredCache(System.currentTimeMillis());
        }
    }

    private VideoUpsInfoEntity constructEntity(PlayInfoResponse playInfoResponse, Map<String, String> map, Map<String, String> map2) {
        String str;
        if (playInfoResponse == null || TextUtils.isEmpty(playInfoResponse.getCachePlayID())) {
            return null;
        }
        String string = (playInfoResponse.getPlayParams() == null || playInfoResponse.getPlayParams().getPlayIdParams() == null) ? "" : playInfoResponse.getPlayParams().getPlayIdParams().getString(TableField.PLAYER_SOURCE);
        if (TextUtils.isEmpty(string) && map != null) {
            string = map.get(TableField.PLAYER_SOURCE);
        }
        String str2 = map != null ? map.get("requestMode") : null;
        if (str2 == null && playInfoResponse.getRequestMode() != null) {
            str2 = playInfoResponse.getRequestMode().toString();
        }
        String str3 = map != null ? map.get("playType") : null;
        if (str3 == null && playInfoResponse.getInfoType() != null) {
            str3 = playInfoResponse.getInfoType().toString();
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        String obj = map2 != null ? map2.toString() : playInfoResponse.getCookieParams();
        JSONObject constructLocalExtraInfo = playInfoResponse.constructLocalExtraInfo();
        if (constructLocalExtraInfo == null) {
            constructLocalExtraInfo = new JSONObject();
        }
        int i = 0;
        if (playInfoResponse.getLiveInfo() != null && playInfoResponse.getLiveInfo().getLivePlayControl() != null) {
            String str4 = playInfoResponse.getLiveInfo().getLivePlayControl().rawData;
            constructLocalExtraInfo.put("upsCacheForm", (Object) 1);
            str = str4;
            i = 1;
        } else if (playInfoResponse.getUpsInfo() == null) {
            str = null;
        } else if (!TextUtils.isEmpty(playInfoResponse.getUpsInfo().getQGetErrorCode())) {
            return null;
        } else {
            if (playInfoResponse.getUpsInfo().getSimpleVideoInfo() != null) {
                String rawData = playInfoResponse.getUpsInfo().getSimpleVideoInfo().getRawData();
                constructLocalExtraInfo.put("upsCacheForm", (Object) 2);
                str = rawData;
                i = 2;
            } else {
                String raw = playInfoResponse.getUpsInfo().getRaw();
                if (str2 == null || !str2.equals(PlayInfoResponse.RequestMode.NORMAL)) {
                    constructLocalExtraInfo.put("upsCacheForm", (Object) 3);
                    str = raw;
                    i = 3;
                } else {
                    constructLocalExtraInfo.put("upsCacheForm", (Object) 4);
                    str = raw;
                    i = 4;
                }
            }
        }
        if (!ApsUtil.enableUpsLocalCache(i) || !ApsUtil.enableUpsLocalCache(i, string)) {
            return null;
        }
        VideoUpsInfoEntity videoUpsInfoEntity = new VideoUpsInfoEntity(playInfoResponse.getCachePlayID(), str3, str2);
        videoUpsInfoEntity.setRawData(str);
        videoUpsInfoEntity.setExpiredTime(Long.valueOf(playInfoResponse.getTimeOfRequestEnd() + playInfoResponse.getInvalidTime()));
        videoUpsInfoEntity.setExtraParams(obj);
        videoUpsInfoEntity.setExtraData(constructLocalExtraInfo.toJSONString());
        return videoUpsInfoEntity;
    }

    private PlayInfoResponse constructResponse(VideoUpsInfoEntity videoUpsInfoEntity) {
        JSONObject parseObject;
        if (videoUpsInfoEntity == null || (parseObject = JSON.parseObject(videoUpsInfoEntity.getExtraData())) == null) {
            return null;
        }
        int intValue = parseObject.getIntValue("upsCacheForm");
        if (intValue != 1) {
            if (intValue == 2) {
                SimpleVideoInfo simpleVideoInfo = (SimpleVideoInfo) JSON.parseObject(videoUpsInfoEntity.getRawData(), SimpleVideoInfo.class);
                if (simpleVideoInfo != null) {
                    PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(null, null);
                    NetUpsInfo netUpsInfo = new NetUpsInfo(simpleVideoInfo);
                    simpleVideoInfo.setRawData(videoUpsInfoEntity.getRawData());
                    playInfoUpsResponse.setUpsInfo(netUpsInfo);
                    if (videoUpsInfoEntity.getExtraData() != null) {
                        playInfoUpsResponse.updateLocalExtraInfo(JSON.parseObject(videoUpsInfoEntity.getExtraData()));
                    }
                    playInfoUpsResponse.setRequestMode(PlayInfoResponse.RequestMode.MULTIGET);
                    playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                    return playInfoUpsResponse;
                }
            } else if (intValue == 3) {
                PlayInfoUpsResponse playInfoUpsResponse2 = new PlayInfoUpsResponse(null, null);
                PlayInfoResponse.RequestMode requestMode = PlayInfoResponse.RequestMode.QGET;
                playInfoUpsResponse2.setRequestMode(requestMode);
                VideoInfo parseJson1 = ParseResult.parseJson1(videoUpsInfoEntity.getRawData());
                if (parseJson1 != null) {
                    NetUpsInfo netUpsInfo2 = new NetUpsInfo(parseJson1);
                    netUpsInfo2.setRaw(videoUpsInfoEntity.getRawData());
                    playInfoUpsResponse2.setUpsInfo(netUpsInfo2);
                    if (videoUpsInfoEntity.getExtraData() != null) {
                        playInfoUpsResponse2.updateLocalExtraInfo(JSON.parseObject(videoUpsInfoEntity.getExtraData()));
                    }
                    if (playInfoUpsResponse2.getRequestMode() == null) {
                        playInfoUpsResponse2.setRequestMode(requestMode);
                    }
                    playInfoUpsResponse2.setInfoType(PlayDefinition.PlayInfoType.UPS);
                }
                return playInfoUpsResponse2;
            } else if (intValue == 4) {
                PlayInfoUpsResponse playInfoUpsResponse3 = new PlayInfoUpsResponse(null, null);
                playInfoUpsResponse3.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
                VideoInfo parseJson12 = ParseResult.parseJson1(videoUpsInfoEntity.getRawData());
                if (parseJson12 != null) {
                    NetUpsInfo netUpsInfo3 = new NetUpsInfo(parseJson12);
                    netUpsInfo3.setRaw(videoUpsInfoEntity.getRawData());
                    playInfoUpsResponse3.setUpsInfo(netUpsInfo3);
                    if (videoUpsInfoEntity.getExtraData() != null) {
                        playInfoUpsResponse3.updateLocalExtraInfo(JSON.parseObject(videoUpsInfoEntity.getExtraData()));
                    }
                    if (playInfoUpsResponse3.getRequestMode() == null) {
                        playInfoUpsResponse3.setRequestMode(PlayInfoResponse.RequestMode.QGET);
                    }
                    playInfoUpsResponse3.setInfoType(PlayDefinition.PlayInfoType.UPS);
                }
                return playInfoUpsResponse3;
            }
            return null;
        }
        PlayInfoLiveResponse playInfoLiveResponse = new PlayInfoLiveResponse(null, null);
        playInfoLiveResponse.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
        playInfoLiveResponse.setInfoType(PlayDefinition.PlayInfoType.LIVE);
        return playInfoLiveResponse;
    }

    private VideoUpsInfoEntity getPlayInfoInner(String str, Map<String, String> map, Map<String, String> map2) {
        String str2 = map != null ? map.get("requestMode") : null;
        String str3 = map != null ? map.get("playType") : null;
        try {
            List<VideoUpsInfoEntity> upsCacheData = SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().getUpsCacheData(str, System.currentTimeMillis());
            if (upsCacheData != null) {
                if (upsCacheData.size() != 0) {
                    VideoUpsInfoEntity videoUpsInfoEntity = upsCacheData.get(0);
                    if (map2 != null) {
                        for (Map.Entry<String, String> entry : map2.entrySet()) {
                            String value = entry.getValue();
                            if (!TextUtils.isEmpty(value) && (videoUpsInfoEntity.getExtraData() == null || !videoUpsInfoEntity.getExtraData().contains(value))) {
                                return null;
                            }
                        }
                    }
                    if (!(str2 == null || str2.equals(videoUpsInfoEntity.getRequestMode()))) {
                        return null;
                    }
                    if (str3 == null || str3.equals(videoUpsInfoEntity.getPlayType())) {
                        return videoUpsInfoEntity;
                    }
                    return null;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void cleanPlayInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().deleteCache(str);
            } catch (Exception unused) {
            }
        }
    }

    public boolean isExistPlayInfo(String str, Map<String, String> map, Map<String, String> map2) {
        return !TextUtils.isEmpty(str) && getPlayInfoInner(str, map, map2) != null;
    }

    public PlayInfoResponse queryPlayInfo(String str, Map<String, String> map, Map<String, String> map2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            VideoUpsInfoEntity playInfoInner = getPlayInfoInner(str, map, map2);
            if (playInfoInner == null) {
                return null;
            }
            PlayInfoResponse constructResponse = constructResponse(playInfoInner);
            if (Logger.DEBUG && constructResponse != null) {
                Log.e(SimpleLocalDataStorage.TAG, "Get cache for " + str + " content: " + playInfoInner.toString());
            }
            return constructResponse;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<PlayInfoResponse> queryPlayInfo(List<String> list, Map<String, String> map, Map<String, String> map2) {
        PlayInfoResponse constructResponse;
        if (!(list == null || list.size() == 0)) {
            String str = map != null ? map.get("requestMode") : null;
            String str2 = map != null ? map.get("playType") : null;
            ArrayList arrayList = new ArrayList();
            try {
                List<VideoUpsInfoEntity> upsCacheData = SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().getUpsCacheData(list, System.currentTimeMillis());
                if (upsCacheData != null) {
                    if (upsCacheData.size() != 0) {
                        for (VideoUpsInfoEntity videoUpsInfoEntity : upsCacheData) {
                            boolean z = true;
                            if (map2 != null) {
                                Iterator<Map.Entry<String, String>> it = map2.entrySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String value = it.next().getValue();
                                    if (TextUtils.isEmpty(value) || (videoUpsInfoEntity.getExtraData() != null && videoUpsInfoEntity.getExtraData().contains(value))) {
                                    }
                                }
                                z = false;
                            }
                            if (!z || str == null || str.equals(videoUpsInfoEntity.getRequestMode())) {
                                if (!z || str2 == null || str2.equals(videoUpsInfoEntity.getPlayType())) {
                                    if (z && (constructResponse = constructResponse(videoUpsInfoEntity)) != null) {
                                        arrayList.add(constructResponse);
                                    }
                                }
                            }
                        }
                        return arrayList;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean savePlayInfoResponse(PlayInfoResponse playInfoResponse, Map<String, String> map, Map<String, String> map2) {
        if (playInfoResponse != null && !TextUtils.isEmpty(playInfoResponse.getCachePlayID())) {
            try {
                VideoUpsInfoEntity constructEntity = constructEntity(playInfoResponse, map, map2);
                if (constructEntity == null) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(constructEntity);
                SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().insertUpsCacheData(arrayList);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean savePlayInfoResponse(List<PlayInfoResponse> list, Map<String, String> map, Map<String, String> map2) {
        if (!(list == null || list.size() == 0)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PlayInfoResponse playInfoResponse : list) {
                    VideoUpsInfoEntity constructEntity = constructEntity(playInfoResponse, map, map2);
                    if (constructEntity != null) {
                        if (Logger.DEBUG) {
                            Log.e(SimpleLocalDataStorage.TAG, "" + constructEntity.toString());
                        }
                        arrayList.add(constructEntity);
                    }
                }
                SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().insertUpsCacheData(arrayList);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
