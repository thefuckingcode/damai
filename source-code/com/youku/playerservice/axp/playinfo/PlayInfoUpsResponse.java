package com.youku.playerservice.axp.playinfo;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.business.common.model.MidAdPointInfo;
import com.alimm.xadsdk.business.common.utils.AdUtils;
import com.tencent.open.SocialConstants;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.BitStreamFinder;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.DrmType;
import com.youku.playerservice.axp.item.MasterBitStream;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.QualityStream;
import com.youku.playerservice.axp.item.StreamSegItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.CacheUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.service.download.DownloadInfoOuter;
import com.youku.ups.data.RequestParams;
import com.youku.upsplayer.module.Dvd;
import com.youku.upsplayer.module.Point;
import com.youku.upsplayer.module.Segs;
import com.youku.upsplayer.module.Show;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.StreamExt;
import com.youku.upsplayer.module.Ups;
import com.youku.upsplayer.module.Video;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.vpm.constants.TableField;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class PlayInfoUpsResponse extends PlayInfoResponse {
    public static final String SHOW_ID = "showId";
    public static final String SHOW_NAME = "showName";
    public static final String SHOW_THUMB_URL = "showThumbUrl";
    public static final String TAG = "PlayInfoUpsResponse";
    private List<BitStream> mBitStreamList = new ArrayList();
    private Context mContext;
    private ArrayList<Point> mCutAdPointList = new ArrayList<>();
    private ArrayList<Point> mFvvPoints = new ArrayList<>();
    private List<BitStream> mH264BitStreamList = new ArrayList();
    private List<MidAdPointInfo> mMidAdPointList = new ArrayList();
    private ArrayList<Point> mOriginCutPointList = new ArrayList<>();
    private List<Point> mPointList = new ArrayList();
    private Map<String, List<QualityStream>> mQualityList;
    private List<BitStream> mSoundBitStreamList = new ArrayList();
    private Quality mUpsQuality = Quality.UNKNOWN;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$playerservice$axp$item$DrmType;

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
            $SwitchMap$com$youku$playerservice$axp$item$DrmType = iArr;
            iArr[DrmType.COPYRIGHT.ordinal()] = 1;
            $SwitchMap$com$youku$playerservice$axp$item$DrmType[DrmType.CHINA.ordinal()] = 2;
            $SwitchMap$com$youku$playerservice$axp$item$DrmType[DrmType.WIDEVINE.ordinal()] = 3;
            $SwitchMap$com$youku$playerservice$axp$item$DrmType[DrmType.WV_CBCS.ordinal()] = 4;
            $SwitchMap$com$youku$playerservice$axp$item$DrmType[DrmType.WV_CENC.ordinal()] = 5;
        }
    }

    public PlayInfoUpsResponse(Context context, PlayParams playParams) {
        super(playParams);
        this.mContext = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private void constructAdInfo(VideoInfo videoInfo) {
        Map<String, Object> map;
        AdInfo adInfo;
        try {
            if (!TextUtils.isEmpty(this.mPlayParams.getString("adJson"))) {
                String string = this.mPlayParams.getString("adJson");
                this.mAdInfo = AdUtils.parseAd(string, false, 0, new HashMap());
                this.mProperties.put("resultAdJson", string);
                map = this.mProperties;
                adInfo = this.mAdInfo;
            } else {
                if (!TextUtils.isEmpty(videoInfo.getAd()) && !hasVideoType("politics_sensitive")) {
                    String ad = videoInfo.getAd();
                    this.mAdInfo = AdUtils.parseAd(ad, false, 0, new HashMap());
                    this.mProperties.put("resultAdJson", ad);
                    map = this.mProperties;
                    adInfo = this.mAdInfo;
                }
                if (TextUtils.isEmpty(videoInfo.getYkAd())) {
                    this.mProperties.put("ykAdJson", videoInfo.getYkAd());
                    return;
                }
                return;
            }
            map.put("advInfo", adInfo);
            if (TextUtils.isEmpty(videoInfo.getYkAd())) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.d(TAG, "constructAdInfo 构建广告参数出现异常, " + e.getMessage());
        }
    }

    private void constructAdPointList(JSONArray jSONArray) {
        double d = 0.0d;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Point point = new Point();
                point.start = optJSONObject.optDouble("start");
                point.type = optJSONObject.optString("ctype");
                point.title = optJSONObject.optString("title");
                point.desc = optJSONObject.optString(SocialConstants.PARAM_APP_DESC);
                point.cut_vid = optJSONObject.optString("cut_vid");
                point.al = optJSONObject.optInt("al");
                if (!TextUtils.isEmpty(point.cut_vid)) {
                    this.mCutAdPointList.add(point);
                    Point point2 = new Point();
                    point2.start = point.start - d;
                    point2.al = point.al;
                    point2.cut_vid = point.cut_vid;
                    point2.desc = point.desc;
                    point2.title = point.title;
                    point2.type = point.type;
                    this.mOriginCutPointList.add(point2);
                    d += (double) point2.al;
                } else if (Point.STANDARD.equals(point.type)) {
                    MidAdPointInfo midAdPointInfo = new MidAdPointInfo();
                    midAdPointInfo.setStart(point.start);
                    midAdPointInfo.setType(point.type);
                    midAdPointInfo.setTitle(point.title);
                    midAdPointInfo.setDesc(point.desc);
                    this.mMidAdPointList.add(midAdPointInfo);
                }
            }
        }
    }

    private void constructBaseInfo(DownloadInfoOuter downloadInfoOuter) {
        this.mProperties.put("title", downloadInfoOuter.title);
        this.mProperties.put("showId", downloadInfoOuter.showid);
        this.mProperties.put("showVideoSeq", Integer.valueOf(downloadInfoOuter.show_videoseq));
        this.mProperties.put("isPanorama", downloadInfoOuter.isPanorama() ? "1" : "0");
        this.mProperties.put("", Boolean.valueOf(downloadInfoOuter.exclusive));
        File file = new File(downloadInfoOuter.getSavePath(), FeatureManager.FEATURE_KEY_WATERMARK);
        if (file.exists()) {
            try {
                this.mProperties.put("waterMarkJson", CacheUtil.readFile(file.getPath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (downloadInfoOuter.points != null) {
            constructAdPointList(downloadInfoOuter.points);
        }
    }

    private void constructBaseInfo(VideoInfo videoInfo) {
        if (videoInfo.getShow() != null) {
            Show show = videoInfo.getShow();
            this.mProperties.put("showId", videoInfo.getShow().encodeid);
            this.mProperties.put(SHOW_NAME, videoInfo.getShow().title);
            this.mProperties.put(SHOW_THUMB_URL, !TextUtils.isEmpty(show.show_thumburl_big_jpg) ? show.show_thumburl_big_jpg : show.show_thumburl);
            this.mProperties.put("showVThumbUrl", show.show_vthumburl_big_jpg);
            this.mProperties.put("showVideoSeq", Integer.valueOf(show.stage));
            this.mProperties.put("copyright", show.copyright);
        }
        if (videoInfo.getDvd() != null) {
            Dvd dvd = videoInfo.getDvd();
            this.mProperties.put("headTime", dvd.head);
            this.mProperties.put("tailTime", dvd.tail);
            constructDvdInfo(dvd);
        }
        if (videoInfo.getUps() != null) {
            Ups ups = videoInfo.getUps();
            this.mProperties.put(TableField.PS_ID, ups.psid);
            this.mProperties.put(RequestParams.client_ts, Long.valueOf(ups.client_ts));
            this.mProperties.put("ups_ts", Integer.valueOf(ups.ups_ts));
            this.mProperties.put("ups_client_netip", ups.ups_client_netip);
        }
        if (videoInfo.getVideo() != null) {
            Video video = videoInfo.getVideo();
            this.mProperties.put("title", video.title);
            this.mProperties.put(TableField.VIDEO_TYPE, video.ctype);
            String[] strArr = video.type;
            if (strArr != null) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = strArr[i];
                    Map<String, Object> map = this.mProperties;
                    map.put("has_" + str, "true");
                    if ("panorama".equals(str)) {
                        this.mProperties.put("isPanorama", "1");
                        break;
                    }
                    i++;
                }
            }
        }
        if (videoInfo.getController() != null && hasVideoFeature(Point.FVV_TIPS)) {
            this.mProperties.put("dofDegradeMode", String.valueOf(videoInfo.getController().dof_degrade_mode));
        }
    }

    private BitStream constructBitStream(Stream stream) {
        BitStream bitStream;
        String str;
        MediaMap.MediaFormat media = MediaMap.getMedia("audio".equals(stream.media_type) ? stream.media_type : stream.stream_type);
        if (media == null) {
            return null;
        }
        if (TextUtils.isEmpty(stream.stream_type) || !stream.stream_type.contains("auto")) {
            bitStream = new BitStream(media.getQuality(), stream.stream_type, media.getCodec(), Math.max(stream.milliseconds_audio, stream.milliseconds_video));
        } else {
            Codec codec = Codec.H264;
            if ("H265".equalsIgnoreCase(stream.codec)) {
                codec = Codec.H265;
            } else {
                "H264".equalsIgnoreCase(stream.codec);
            }
            bitStream = new MasterBitStream(Quality.AUTO, stream.stream_type, codec, Math.max(stream.milliseconds_audio, stream.milliseconds_video));
        }
        bitStream.setLogo(stream.logo);
        bitStream.setFileSize(stream.size);
        bitStream.setWidth(stream.width);
        bitStream.setHeight(stream.height);
        bitStream.setM3u8Url(stream.m3u8_url);
        bitStream.setLangCode(stream.audio_lang);
        StreamExt streamExt = stream.stream_ext;
        if (streamExt != null) {
            bitStream.setSubtitleLang(streamExt.subtitle_lang);
            bitStream.setHlsSubtitle(stream.stream_ext.hls_subtitle);
            bitStream.setHlsLogo(stream.stream_ext.hls_logo);
            bitStream.setDrmLicenseUri(stream.stream_ext.uri);
            bitStream.setDofConfigFile(stream.stream_ext.dofConfigFile);
            bitStream.setDofAngleRange(stream.stream_ext.rotationAngle6dof);
            bitStream.setHlsPlayConf(stream.stream_ext.playconf);
        }
        bitStream.setFs(stream.fs);
        bitStream.setFsError(stream.fs_error);
        ArrayList arrayList = new ArrayList();
        Segs[] segsArr = stream.segs;
        if (segsArr != null) {
            for (Segs segs : segsArr) {
                if (!(segs == null || ((str = segs.cdn_url) == null && segs.rtmp_url == null))) {
                    StreamSegItem streamSegItem = new StreamSegItem(str, segs.total_milliseconds_video);
                    streamSegItem.setAd(segs.ad);
                    streamSegItem.setFileSize(segs.size);
                    arrayList.add(streamSegItem);
                }
            }
        }
        bitStream.setStreamSegList(arrayList);
        constructDrm(stream, bitStream);
        return bitStream;
    }

    private void constructBitStreamList(VideoInfo videoInfo) {
        boolean z;
        List<BitStream> list;
        if (!(videoInfo == null || videoInfo.getStream() == null || videoInfo.getStream().length <= 0)) {
            this.mBitStreamList.clear();
            this.mH264BitStreamList.clear();
            Stream[] stream = videoInfo.getStream();
            ArrayList<BitStream> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Stream stream2 : stream) {
                BitStream constructBitStream = constructBitStream(stream2);
                if (constructBitStream != null) {
                    if (constructBitStream.getQuality() == Quality.SOUND) {
                        list = this.mSoundBitStreamList;
                    } else {
                        if ("1".equalsIgnoreCase(stream2.spd)) {
                            this.mUpsQuality = constructBitStream.getQuality();
                        }
                        if (constructBitStream.getCodec() == Codec.AV1) {
                            arrayList2.add(constructBitStream);
                        } else if (constructBitStream.getCodec() == Codec.H265) {
                            arrayList.add(constructBitStream);
                        } else {
                            list = this.mH264BitStreamList;
                        }
                    }
                    list.add(constructBitStream);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (BitStream bitStream : arrayList) {
                this.mBitStreamList.add(bitStream);
                arrayList3.add(bitStream);
            }
            if (!isEmpty(this.mH264BitStreamList)) {
                for (BitStream bitStream2 : this.mH264BitStreamList) {
                    if (!isEmpty(arrayList3)) {
                        Iterator it = arrayList3.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BitStream bitStream3 = (BitStream) it.next();
                            if (bitStream2.getQuality() == bitStream3.getQuality() && bitStream2.getLangCode().equals(bitStream3.getLangCode())) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        this.mBitStreamList.add(bitStream2);
                    }
                }
            }
        }
    }

    private void constructDrm(Stream stream, BitStream bitStream) {
        StringBuilder sb;
        if (stream.stream_ext != null) {
            DrmType drmByStr = DrmType.getDrmByStr(stream.drm_type);
            String drmR1 = getUpsInfo().getDrmR1();
            int i = AnonymousClass1.$SwitchMap$com$youku$playerservice$axp$item$DrmType[drmByStr.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    Logger.d(TAG, "是商业drm视频");
                    String str = stream.stream_ext.chinaDrmExtInf;
                    bitStream.setDrmKey("drm_key_irdeto:" + str);
                    bitStream.putString("skipCnt", stream.stream_ext.skipCnt + "");
                } else if (i == 3 || i == 4 || i == 5) {
                    Logger.d(TAG, "WidevineDRM");
                    bitStream.putString("fmp4_in_hls", "1");
                    if (!TextUtils.isEmpty(stream.encryptR_server) && !TextUtils.isEmpty(stream.stream_ext.copyright_key)) {
                        Logger.d(TAG, "R1:" + drmR1 + ",encryptR_server:" + stream.encryptR_server + ",copyright_key:" + stream.stream_ext.copyright_key);
                        sb = new StringBuilder();
                    }
                }
                bitStream.setDrmType(stream.drm_type);
            }
            Logger.d("", "是自研drm视频");
            if (!TextUtils.isEmpty(stream.encryptR_server) && !TextUtils.isEmpty(stream.stream_ext.copyright_key)) {
                Logger.d(TAG, "R1:" + drmR1 + ",encryptR_server:" + stream.encryptR_server + ",copyright_key:" + stream.stream_ext.copyright_key);
                sb = new StringBuilder();
            }
            bitStream.setDrmType(stream.drm_type);
            sb.append(drmR1);
            sb.append(",");
            sb.append(stream.encryptR_server);
            sb.append(",");
            sb.append(stream.stream_ext.copyright_key);
            bitStream.setDrmKey(sb.toString());
            bitStream.setDrmType(stream.drm_type);
        }
    }

    private void constructDvdInfo(Dvd dvd) {
        Point[] pointArr;
        if (!(dvd == null || (pointArr = dvd.point) == null)) {
            double d = 0.0d;
            for (int i = 0; i < pointArr.length; i++) {
                Point point = new Point();
                point.start = Double.parseDouble(pointArr[i].start);
                point.type = pointArr[i].ctype;
                point.title = pointArr[i].title;
                point.desc = pointArr[i].desc;
                if (!TextUtils.isEmpty(pointArr[i].al)) {
                    point.al = Integer.parseInt(pointArr[i].al);
                }
                String str = pointArr[i].cut_vid;
                point.cut_vid = str;
                if (!TextUtils.isEmpty(str)) {
                    this.mCutAdPointList.add(point);
                    Point point2 = new Point();
                    point2.start = point.start - d;
                    point2.al = point.al;
                    point2.cut_vid = point.cut_vid;
                    point2.desc = point.desc;
                    point2.title = point.title;
                    point2.type = point.type;
                    this.mOriginCutPointList.add(point2);
                    d += (double) point2.al;
                } else if (!TextUtils.isEmpty(point.type)) {
                    if (Point.STANDARD.equals(point.type)) {
                        MidAdPointInfo midAdPointInfo = new MidAdPointInfo();
                        midAdPointInfo.setStart(point.start);
                        midAdPointInfo.setType(point.type);
                        midAdPointInfo.setTitle(point.title);
                        midAdPointInfo.setDesc(point.desc);
                        this.mMidAdPointList.add(midAdPointInfo);
                    } else if (Point.FVV_HIGHLIGHT_TIPS.equals(point.type) || Point.FVV_TIPS.equals(point.type)) {
                        this.mFvvPoints.add(point);
                    } else {
                        this.mPointList.add(point);
                    }
                }
            }
        }
        this.mProperties.put("middleAd", this.mMidAdPointList);
        this.mProperties.put("bfAd", this.mCutAdPointList);
    }

    private void constructQualityList(Video video) {
        this.mQualityList = new LinkedHashMap();
        if (video == null) {
            TLogUtil.playLog("video为空，无法构建清晰度列表");
            return;
        }
        for (Map.Entry<String, List<String>> entry : video.getStreamTypes().entrySet()) {
            String key = entry.getKey();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : entry.getValue()) {
                MediaMap.MediaFormat media = MediaMap.getMedia(str);
                if (media != null) {
                    Quality quality = media.getQuality();
                    if (!linkedHashMap.containsKey(quality)) {
                        String streamExtProperty = video.getStreamExtProperty(key, str, "size");
                        String streamExtProperty2 = video.getStreamExtProperty(key, str, "display");
                        String streamExtProperty3 = video.getStreamExtProperty(key, str, "fps");
                        String streamExtProperty4 = video.getStreamExtProperty(key, str, "resolu");
                        BitStream bitStream = getBitStream(quality, key);
                        QualityStream qualityStream = bitStream != null ? new QualityStream(bitStream) : new QualityStream(quality, key, str);
                        if (streamExtProperty != null && TextUtils.isDigitsOnly(streamExtProperty)) {
                            qualityStream.setStreamSize(Long.valueOf(streamExtProperty).longValue());
                        }
                        qualityStream.setCanPlay(bitStream != null);
                        if (streamExtProperty3 != null && TextUtils.isDigitsOnly(streamExtProperty3)) {
                            qualityStream.setFps(Integer.valueOf(streamExtProperty3).intValue());
                        }
                        if (streamExtProperty4 != null && TextUtils.isDigitsOnly(streamExtProperty4)) {
                            qualityStream.setResolu(Integer.valueOf(streamExtProperty4).intValue());
                        }
                        qualityStream.setDisplay(streamExtProperty2);
                        linkedHashMap.put(quality, qualityStream);
                    }
                }
            }
            if (linkedHashMap.containsKey(Quality.HD2_HDR_HFR)) {
                linkedHashMap.remove(Quality.HD2_HDR);
            }
            if (linkedHashMap.containsKey(Quality.HD3_HDR_HFR)) {
                linkedHashMap.remove(Quality.HD3_HDR);
            }
            if (linkedHashMap.containsKey(Quality.HD4K_HDR_HFR)) {
                linkedHashMap.remove(Quality.HD4K);
            }
            this.mQualityList.put(key, new ArrayList(linkedHashMap.values()));
        }
    }

    private BitStream getBitStream(Quality quality, String str) {
        for (BitStream bitStream : this.mBitStreamList) {
            if (bitStream.getQuality() == quality && (str == null || str.equals(bitStream.getLangCode()))) {
                return bitStream;
            }
        }
        return null;
    }

    private int getHeadTime() {
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        if (netUpsInfo == null || netUpsInfo.getVideoInfo() == null || this.mUpsInfo.getVideoInfo().getDvd() == null || TextUtils.isEmpty(this.mUpsInfo.getVideoInfo().getDvd().head)) {
            return 0;
        }
        return Integer.parseInt(this.mUpsInfo.getVideoInfo().getDvd().head);
    }

    private BitStream getSoundBitStream(Quality quality, String str) {
        for (BitStream bitStream : this.mSoundBitStreamList) {
            if (bitStream.getQuality() == quality && (str == null || str.equals(bitStream.getLangCode()))) {
                return bitStream;
            }
        }
        return null;
    }

    private int getTailTime() {
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        if (netUpsInfo == null || netUpsInfo.getVideoInfo() == null || this.mUpsInfo.getVideoInfo().getDvd() == null || TextUtils.isEmpty(this.mUpsInfo.getVideoInfo().getDvd().tail)) {
            return 0;
        }
        return Integer.parseInt(this.mUpsInfo.getVideoInfo().getDvd().tail);
    }

    private static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    private boolean isValid(Stream stream) {
        if (stream == null) {
            return false;
        }
        String str = null;
        if (stream.m3u8_url != null) {
            if ("auto".equals(stream.stream_type)) {
                return true;
            }
            try {
                str = Uri.parse(stream.m3u8_url).getQueryParameter("sm");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if ("1".equals(str)) {
            return true;
        }
        Segs[] segsArr = stream.segs;
        return segsArr != null && segsArr.length > 0;
    }

    public List<BitStream> getBitStreamList() {
        return this.mBitStreamList;
    }

    public List<Point> getCutAdPoints() {
        return this.mCutAdPointList;
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public String getPlayId() {
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        return (netUpsInfo == null || netUpsInfo.getVideoInfo() == null || this.mUpsInfo.getVideoInfo().getVideo() == null || this.mUpsInfo.getVideoInfo().getVideo().encodeid == null) ? super.getPlayId() : this.mUpsInfo.getVideoInfo().getVideo().encodeid;
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public VodItem getPlayItem(PlayParams playParams, Quality quality, String str) {
        BitStream bitStream;
        BitStream bitStream2;
        if (isCacheQuality(quality, str)) {
            bitStream = this.mCacheInfo.getBitStream();
        } else {
            Quality quality2 = Quality.UNKNOWN;
            Quality quality3 = quality != quality2 ? quality : Quality.AUTO;
            List<BitStream> list = this.mBitStreamList;
            if (list == null || list.isEmpty()) {
                playParams.putString("findStreamError", "noStream");
                return null;
            }
            BitStreamFinder bitStreamFinder = new BitStreamFinder(this, NetworkUtil.isWifi(this.mContext));
            BitStream findBitStream = bitStreamFinder.findBitStream(quality3, str);
            if (findBitStream == null) {
                String sessionId = playParams.getSessionId();
                TLogUtil.flowLog(sessionId, "quality=" + quality3 + " langCode=" + str + "选流失败，忽略语言再次重试选流");
                findBitStream = bitStreamFinder.findBitStream(quality3, (String) null);
                playParams.putString("findStreamError", "langNull");
            }
            if (findBitStream == null) {
                String sessionId2 = playParams.getSessionId();
                TLogUtil.flowLog(sessionId2, "quality:" + quality3 + " langCode:" + str + "选流失败，选第一个流");
                bitStream2 = bitStreamFinder.findFirstBitStream();
                playParams.putString("findStreamError", "firstStream");
            } else {
                bitStream2 = findBitStream;
            }
            if (!(quality == quality2 || quality == bitStream2.getQuality())) {
                String sessionId3 = playParams.getSessionId();
                TLogUtil.flowLog(sessionId3, "起播降档requestQuality=" + quality + " curQuality=" + bitStream2.getQuality());
                playParams.putString("bitStreamChange", "起播降档");
            }
            bitStream = bitStream2;
        }
        if (bitStream != null) {
            return new VodItem(playParams, bitStream);
        }
        return null;
    }

    public VodItem getPlayItem(PlayParams playParams, String str, String str2) {
        BitStream findBitStream = new BitStreamFinder(this, NetworkUtil.isWifi(this.mContext)).findBitStream(str, str2);
        if (findBitStream != null) {
            return new VodItem(playParams, findBitStream);
        }
        return null;
    }

    public VodItem getPlayItemWithoutDownshift(PlayParams playParams, Quality quality, String str) {
        BitStream soundBitStream = quality == Quality.SOUND ? getSoundBitStream(quality, str) : isCacheQuality(quality, str) ? this.mCacheInfo.getBitStream() : getBitStream(quality, str);
        if (soundBitStream != null) {
            return new VodItem(playParams, soundBitStream);
        }
        return null;
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public Map<String, List<QualityStream>> getQualityList(String str) {
        return this.mQualityList;
    }

    public long getRealStartTime(@NonNull PlayInfo playInfo) {
        PlayParams playParams = playInfo.getPlayParams();
        long startTime = playParams.getStartTime();
        long j = 0;
        if (startTime >= 0) {
            return startTime;
        }
        boolean isSkipHeadTail = playParams.getPlayIdParams().isSkipHeadTail();
        int headTime = getHeadTime();
        if (headTime > 0 && isSkipHeadTail) {
            startTime = (long) headTime;
            playParams.setStartTime(startTime);
        }
        int tailTime = getTailTime();
        int duration = playInfo.getDuration();
        boolean z = false;
        boolean z2 = tailTime > 0;
        int i = 5;
        try {
            int parseInt = Integer.parseInt(playParams.getString("startTimeResetGap", "5"));
            if (parseInt >= 1) {
                i = parseInt;
            }
        } catch (Exception unused) {
        }
        if (!z2 || !isSkipHeadTail ? startTime > ((long) (duration - (i * 1000))) : startTime > ((long) (tailTime - (i * 1000)))) {
            z = true;
        }
        String str = "";
        if (z) {
            str = str + "进行修复，从0开始播放 ";
            TLogUtil.playLog(str);
        } else {
            j = startTime;
        }
        TLogUtil.flowLog(playParams.getSessionId(), ((((str + "isSkipTail:" + isSkipHeadTail + " ") + "hasSkipTail:" + z2 + " ") + "point:" + j + " ") + "duration:" + duration + " ") + "tailPoint:" + tailTime + " ");
        return j;
    }

    public List<BitStream> getSoundBitStreamList() {
        return this.mSoundBitStreamList;
    }

    public Quality getUpsQuality() {
        return this.mUpsQuality;
    }

    public boolean hasVideoFeature(String str) {
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        if (netUpsInfo == null || netUpsInfo.getVideoInfo() == null || this.mUpsInfo.getVideoInfo().getDvd() == null || this.mUpsInfo.getVideoInfo().getDvd().video_features == null) {
            return false;
        }
        return Arrays.asList(this.mUpsInfo.getVideoInfo().getDvd().video_features).contains(str);
    }

    public boolean hasVideoType(String str) {
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        if (netUpsInfo == null || netUpsInfo.getVideoInfo() == null || this.mUpsInfo.getVideoInfo().getVideo() == null || this.mUpsInfo.getVideoInfo().getVideo().type == null) {
            return false;
        }
        return Arrays.asList(this.mUpsInfo.getVideoInfo().getVideo().type).contains(str);
    }

    public boolean isCacheQuality(Quality quality, String str) {
        CacheUpsInfo cacheUpsInfo = this.mCacheInfo;
        return cacheUpsInfo != null && quality == cacheUpsInfo.getCacheQuality();
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public void setAdInfo(AdInfo adInfo) {
        super.setAdInfo(adInfo);
        this.mProperties.put("advInfo", this.mAdInfo);
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public void setCacheInfo(CacheUpsInfo cacheUpsInfo) {
        String str;
        super.setCacheInfo(cacheUpsInfo);
        VideoInfo videoInfo = cacheUpsInfo.getVideoInfo();
        if (videoInfo != null) {
            constructBaseInfo(videoInfo);
            str = videoInfo.getAd();
        } else {
            DownloadInfoOuter downloadInfo = cacheUpsInfo.getDownloadInfo();
            constructBaseInfo(downloadInfo);
            str = downloadInfo.ad != null ? downloadInfo.ad.toString() : null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mProperties.put("resultAdJson", str);
        }
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public void setUpsInfo(NetUpsInfo netUpsInfo) {
        super.setUpsInfo(netUpsInfo);
        VideoInfo videoInfo = netUpsInfo.getVideoInfo();
        if (videoInfo != null) {
            constructBaseInfo(videoInfo);
            constructAdInfo(videoInfo);
            constructBitStreamList(videoInfo);
            constructQualityList(videoInfo.getVideo());
        }
    }
}
