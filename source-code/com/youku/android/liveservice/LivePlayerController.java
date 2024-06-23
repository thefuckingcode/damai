package com.youku.android.liveservice;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.android.liveservice.bean.Artp;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.Grtn;
import com.youku.android.liveservice.bean.Hls;
import com.youku.android.liveservice.bean.HttpFlv;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Mcs;
import com.youku.android.liveservice.bean.MicInfo;
import com.youku.android.liveservice.bean.MicPlayInfo;
import com.youku.android.liveservice.bean.Mu;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.Rtp;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.android.liveservice.utils.DrmManager;
import com.youku.android.liveservice.utils.ErrorCodeHelper;
import com.youku.android.liveservice.utils.LiveOrangeUtil;
import com.youku.android.liveservice.utils.Logger;
import com.youku.android.liveservice.utils.MTopHelper;
import com.youku.android.liveservice.utils.PlayControlV3Util;
import com.youku.android.liveservice.utils.UriHelper;
import com.youku.android.liveservice.utils.Utils;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainFactory;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.vpm.constants.TableField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class LivePlayerController {
    public static final String CLIENT_IP = "127.0.0.1";
    public static final int E_MD_END = 30999;
    public static final int E_MD_FORCE_LOGIN = 30650;
    public static final int E_MD_INVALID_LOGIN = 30201;
    public static final int E_MD_START = 30000;
    public static final int E_PCTRL_ARER_LIMIT = 40002;
    public static final int E_PCTRL_FULL = 40001;
    public static final int E_PCTRL_QUALITY_VIP = 1001;
    private static final String LIVE_PLAY_CONTROL_VERSION_V4 = "4.0";
    private static final String PLAY_CONTROL = "mtop.youku.live.com.liveplaycontrol";
    public static final int REQUEST_QUALITY = LiveOrangeUtil.getChannelQuality();
    public static final String SDK_VERSION = "1.2.2";
    public static final int STATUS_OK = 200;
    private static final String TAG = "LivePlayerController";
    private String broadcastVideoCode;
    private String mAppKey;
    private String mCCode;
    private String mCCode4ott;
    private String mCkey;
    private Context mContext;
    private String mCurPcdnPlayUrl;
    private String mCurPlayUrl;
    private int mLastQuality;
    private String mLiveId;
    private LivePlayControl mLivePlayControl;
    private int mLiveState;
    private IPlayControlListener mPlayContorlListener;
    private long mStartTime;

    /* compiled from: Taobao */
    public interface IPlayControlListener {
        void requestFailure(LivePlayControl livePlayControl, int i, String str);

        void requestSuccess(VideoInfo videoInfo);
    }

    public LivePlayerController(String str) {
        this(str, null, "", "");
    }

    /* access modifiers changed from: private */
    public static boolean containLoginYtid(LivePlayControl livePlayControl) {
        MicInfo micInfo;
        List<Mcs> list;
        String str;
        String str2;
        if (livePlayControl == null || (micInfo = livePlayControl.micInfo) == null || (list = micInfo.mcs) == null || list.size() <= 0) {
            return false;
        }
        for (Mcs mcs : livePlayControl.micInfo.mcs) {
            Mu mu = mcs.mu;
            if (!(mu == null || (str = mu.u) == null || (str2 = livePlayControl.loginYtid) == null || !str2.equals(str))) {
                return true;
            }
        }
        return false;
    }

    private void doRequest(String str, String str2, Map<String, String> map, boolean z, boolean z2, IRemoteBaseListener iRemoteBaseListener) {
        MtopBusiness mtopBusiness;
        MtopRequest mtopRequest = new MtopRequest();
        MTopHelper.buildMtopRequest(mtopRequest, str, str2, z2, map);
        Mtop mtop = MTopHelper.getMtop();
        if (mtop != null) {
            mtopBusiness = MtopBusiness.build(mtop, mtopRequest);
        } else {
            mtopBusiness = MtopBusiness.build(Mtop.instance(this.mContext), mtopRequest);
        }
        MTopHelper.buildMtopBusiness(mtopBusiness, str, map, z, iRemoteBaseListener);
        if (Utils.isYoukuOrBaipai(this.mContext) && Utils.enableNewDomain()) {
            mtopBusiness.setCustomDomain("live-acs.youku.com", "pre-live-acs.youku.com", "daily-acs.youku.com");
        }
        mtopBusiness.startRequest();
    }

    /* access modifiers changed from: private */
    public static BypassPlayInfo getBypassPlayInfo(String str, LivePlayControl livePlayControl, String str2, String str3) {
        String str4 = livePlayControl.liveId;
        int i = livePlayControl.liveStatus;
        Quality defaultQuality = livePlayControl.getDefaultQuality();
        if (defaultQuality == null) {
            return null;
        }
        BypassPlayInfo bypassPlayInfo = new BypassPlayInfo();
        bypassPlayInfo.livePlayControl = livePlayControl;
        bypassPlayInfo.livePlayControlContent = str3;
        bypassPlayInfo.ccode = str;
        String str5 = defaultQuality.playurl;
        String str6 = defaultQuality.h265PlayUrl;
        if (str5 != null) {
            if (str5.equals(null) || TextUtils.isEmpty(null)) {
                bypassPlayInfo.url = str5;
                bypassPlayInfo.isP2p = false;
            } else {
                bypassPlayInfo.url = null;
                bypassPlayInfo.isP2p = true;
            }
        }
        long j = livePlayControl.now;
        long j2 = livePlayControl.endTimestamp;
        if (j > j2) {
            livePlayControl.now = j2;
        }
        long j3 = livePlayControl.startTimestamp;
        int i2 = livePlayControl.timeShiftOffset;
        if (((long) i2) + j3 > livePlayControl.now || ((long) i2) + j3 > j2) {
            livePlayControl.timeShiftOffset = -1;
        }
        int i3 = livePlayControl.timeShiftOffset;
        if (i3 >= 0 && ((long) i3) < j2) {
            long j4 = ((long) (i3 * 1000)) + (j3 * 1000);
            bypassPlayInfo.url = UriHelper.appendUriParameter(bypassPlayInfo.url, "lhs_start", stampToDate(j4));
            str6 = defaultQuality.h265PlayUrl;
            if (!TextUtils.isEmpty(str6)) {
                str6 = UriHelper.appendUriParameter(str6, "lhs_start", stampToDate(j4));
            }
        }
        bypassPlayInfo.definition = defaultQuality.name;
        bypassPlayInfo.qualityCode = defaultQuality.code;
        bypassPlayInfo.h265 = defaultQuality.h265;
        bypassPlayInfo.h265PlayUrl = str6;
        HashMap hashMap = new HashMap();
        hashMap.put("liveUrl", str5 + "&vip=0");
        hashMap.put("liveAdFlag", 1);
        hashMap.put("liveState", Integer.valueOf(i));
        hashMap.put("liveid", str4);
        hashMap.put("screenid", livePlayControl.screenId);
        hashMap.put(Constants.Name.QUALITY, String.valueOf(defaultQuality.quality));
        hashMap.put(TableField.DRM_TYPE, livePlayControl.drm ? "2" : "0");
        hashMap.put(TableField.IS_VIP, "0");
        hashMap.put(TableField.PS_ID, livePlayControl.psid);
        if (str5 != null) {
            if (str5.equals(null) || TextUtils.isEmpty(null)) {
                hashMap.put("cdnType", "1");
            } else {
                hashMap.put("cdnType", "3");
            }
        }
        bypassPlayInfo.utParams = hashMap;
        bypassPlayInfo.encryptRServer = livePlayControl.eRs;
        bypassPlayInfo.copyrightKey = livePlayControl.cRk;
        bypassPlayInfo.drmType = livePlayControl.drm ? 2 : 0;
        bypassPlayInfo.adJsonStr = livePlayControl.adJsonStr;
        bypassPlayInfo.subtitleUrl = livePlayControl.subtitleUrl;
        bypassPlayInfo.quality = defaultQuality.quality;
        bypassPlayInfo.playType = defaultQuality.playType;
        bypassPlayInfo.bitStream = defaultQuality.bitStream;
        bypassPlayInfo.smooth = false;
        if (i == 0) {
            if (!TextUtils.isEmpty("")) {
                bypassPlayInfo.vid = "";
            }
        } else if (i != 1 && i == 2 && !TextUtils.isEmpty("")) {
            bypassPlayInfo.vid = "";
        }
        return bypassPlayInfo;
    }

    public static String getCustomCKey(Context context, String str, Map<String, String> map) {
        String str2;
        AntiTheftChainParam antiTheftChainParam = new AntiTheftChainParam();
        antiTheftChainParam.setServerEnv(0);
        antiTheftChainParam.setCcode(str);
        antiTheftChainParam.setClientIP(map.get(TbAuthConstants.CLIENT_IP));
        antiTheftChainParam.setContext(context);
        antiTheftChainParam.setUtid(UTDevice.getUtdid(context));
        if ((map.get("liveId") instanceof String) && !TextUtils.isEmpty(map.get("liveId"))) {
            antiTheftChainParam.setVid(map.get("liveId"));
        }
        antiTheftChainParam.setClientTs(String.valueOf(System.currentTimeMillis()));
        antiTheftChainParam.setAntiTheftChainClientType(AntiTheftChainClientType.Internal);
        try {
            str2 = AntiTheftChainFactory.create().getCkey(antiTheftChainParam);
        } catch (AntiTheftChainException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (Logger.DEBUG) {
            String str3 = TAG;
            Logger.d(str3, "getCKey cKey = " + str2);
        }
        return str2;
    }

    private String getEncyptX() {
        String generateEncryptRClient = DrmManager.generateEncryptRClient(this.mContext, this.mAppKey, "");
        String r1 = DrmManager.getR1();
        String encodeBase64 = DrmManager.encodeBase64(generateEncryptRClient);
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getEncyptX drmR1=" + r1 + " drmX=" + generateEncryptRClient);
        }
        return encodeBase64;
    }

    /* access modifiers changed from: private */
    public static List<MicPlayInfo> getMicPlayInfos(LivePlayControl livePlayControl) {
        ArrayList arrayList = new ArrayList();
        if (livePlayControl.micInfo.mcs.size() > 0) {
            for (Mcs mcs : livePlayControl.micInfo.mcs) {
                MicPlayInfo micPlayInfo = new MicPlayInfo();
                micPlayInfo.rtp = getPlayRtp(mcs, livePlayControl.micInfo.dfi);
                micPlayInfo.flv = getPlayFlv(mcs, livePlayControl.micInfo.dfi);
                micPlayInfo.artp = getPlayArtp(mcs, livePlayControl.micInfo.dfi);
                micPlayInfo.grtn = getPlayGrtn(mcs, livePlayControl.micInfo.dfi);
                arrayList.add(micPlayInfo);
            }
        }
        return arrayList;
    }

    private static Artp getPlayArtp(Mcs mcs, int i) {
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

    private static HttpFlv getPlayFlv(Mcs mcs, int i) {
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

    private static Grtn getPlayGrtn(Mcs mcs, int i) {
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

    private static Hls getPlayHls(Mcs mcs, int i) {
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

    private static Rtp getPlayRtp(Mcs mcs, int i) {
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

    public static String stampToDate(long j) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(j));
        Log.e("fornia", "offset url播放date点:" + format + " time url播放时间点:" + j);
        return format;
    }

    public String getCKey() {
        return this.mCkey;
    }

    public void getPlayControl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        getPlayControl(str, str2, str3, str4, str5, str6, str7, str8, str9, z, "");
    }

    public void setLiveState(int i) {
        this.mLiveState = i;
    }

    public void setPlayControlListener(IPlayControlListener iPlayControlListener) {
        this.mPlayContorlListener = iPlayControlListener;
    }

    public LivePlayerController(String str, Context context, String str2, String str3) {
        this(str, context, str2, "", str3);
    }

    public void getPlayControl(String str, String str2, final String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.mStartTime = System.currentTimeMillis();
        final String str11 = z ? this.mCCode4ott : this.mCCode;
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str + JSMethod.NOT_SET + str2);
        hashMap.put(TbAuthConstants.CLIENT_IP, CLIENT_IP);
        String customCKey = getCustomCKey(this.mContext, str11, hashMap);
        this.mCkey = customCKey;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("liveId", str);
        hashMap2.put("sceneId", str2);
        hashMap2.put("sdkVersion", SDK_VERSION);
        hashMap2.put("app", "android");
        hashMap2.put("ckey", customCKey);
        hashMap2.put(PluginName.AD, str4);
        hashMap2.put("ccode", str11);
        hashMap2.put(PluginName.AD, str4);
        hashMap2.put("cna", "");
        hashMap2.put("keyIndex", this.mAppKey);
        hashMap2.put("encryptRClient", getEncyptX());
        if (!TextUtils.isEmpty(str3)) {
            hashMap2.put("reqQuality", str3);
        }
        hashMap2.put("playAbilities", str5);
        hashMap2.put("refer", str7);
        hashMap2.put("userQualityRecord", str9);
        if (!TextUtils.isEmpty(str6)) {
            hashMap2.put("params", str6);
        }
        if (!TextUtils.isEmpty(str10)) {
            hashMap2.put(TableField.PS_ID, str10);
        }
        hashMap2.put("osVersion", Build.VERSION.getRELEASE());
        hashMap2.put("deviceType", Utils.URLEncoder(Build.getMODEL()));
        hashMap2.put("chipset", Utils.getCpuName());
        hashMap2.put("network", Utils.getUpsNetworkType(this.mContext));
        if (Logger.DEBUG) {
            String str12 = TAG;
            Logger.d(str12, "getPlayControl params = " + hashMap2);
        }
        doRequest("mtop.youku.live.com.liveplaycontrol", "4.0", hashMap2, true, false, new IRemoteBaseListener() {
            /* class com.youku.android.liveservice.LivePlayerController.AnonymousClass1 */

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                IPlayControlListener iPlayControlListener = LivePlayerController.this.mPlayContorlListener;
                if (Logger.DEBUG) {
                    String str = LivePlayerController.TAG;
                    Logger.d(str, "getPlayControl oError mtopResponse = " + mtopResponse);
                }
                if (iPlayControlListener != null) {
                    iPlayControlListener.requestFailure(null, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_REQUEST_ERROR, "");
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:80:0x019b  */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x019f  */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x01cf  */
            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                BypassPlayInfo bypassPlayInfo;
                List<MicPlayInfo> list;
                MicInfo micInfo;
                List<Mcs> list2;
                if (Logger.DEBUG) {
                    Logger.d(LivePlayerController.TAG, "getPlayControl onSuccess mtopResponse = " + mtopResponse);
                }
                long currentTimeMillis = System.currentTimeMillis() - LivePlayerController.this.mStartTime;
                IPlayControlListener iPlayControlListener = LivePlayerController.this.mPlayContorlListener;
                try {
                    String str = new String(mtopResponse.getBytedata());
                    int i2 = mtopResponse.getDataJsonObject().getInt("status");
                    String string = mtopResponse.getDataJsonObject().getString("msg");
                    long j = mtopResponse.getDataJsonObject().getLong("now");
                    if (ErrorCodeHelper.statusFromPlayControlIsOK(i2)) {
                        JSONObject jSONObject = mtopResponse.getDataJsonObject().getJSONObject("data");
                        if (jSONObject != null) {
                            String jSONObject2 = jSONObject.toString();
                            if (jSONObject2.contains("\\/")) {
                                jSONObject2 = jSONObject2.replaceAll("\\\\/", "/");
                            }
                            LivePlayControl controlFromJsonString = PlayControlV3Util.getControlFromJsonString(jSONObject2);
                            controlFromJsonString.rawData = jSONObject2;
                            controlFromJsonString.jsonObject = jSONObject;
                            if (!TextUtils.isEmpty(controlFromJsonString.adInfo)) {
                                controlFromJsonString.adJsonStr = new String(Base64.decode(controlFromJsonString.adInfo, 0));
                            }
                            controlFromJsonString.now = j;
                            LivePlayerController.this.mLivePlayControl = controlFromJsonString;
                            if (iPlayControlListener == null) {
                                return;
                            }
                            if (i2 == 2001) {
                                int errorFromPlayControl = ErrorCodeHelper.errorFromPlayControl(i2);
                                if (string == null) {
                                    string = "";
                                }
                                iPlayControlListener.requestFailure(controlFromJsonString, errorFromPlayControl, string);
                                return;
                            }
                            int i3 = controlFromJsonString.liveStatus;
                            if (i3 == 0) {
                                if (string == null) {
                                    string = "";
                                }
                                iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_LIVE_NOT_BEGIN, string);
                            } else if (i3 == 2) {
                                if (string == null) {
                                    string = "";
                                }
                                iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_LIVE_COMPLETE, string);
                            } else {
                                if ("live".equals(controlFromJsonString.streamMode)) {
                                    bypassPlayInfo = LivePlayerController.getBypassPlayInfo(str11, controlFromJsonString, str3, str);
                                } else if (!"mic".equals(controlFromJsonString.streamMode)) {
                                    iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_UNKNOWN_STREAMMODE, "");
                                    return;
                                } else if (TextUtils.isEmpty(controlFromJsonString.micMode) || "video".equals(controlFromJsonString.micMode)) {
                                    if (controlFromJsonString.mcu != 1) {
                                        iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_UNDO_VIDEO_MCU_0, "");
                                        return;
                                    } else if (!LivePlayerController.containLoginYtid(controlFromJsonString)) {
                                        bypassPlayInfo = LivePlayerController.getBypassPlayInfo(str11, controlFromJsonString, str3, str);
                                    } else {
                                        iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_UNDO_VIDEO_MCU_1_NOTONMIC, "");
                                        return;
                                    }
                                } else if (PushConstants.URI_PACKAGE_NAME.equals(controlFromJsonString.micMode)) {
                                    if (controlFromJsonString.mcu != 1) {
                                        list = LivePlayerController.getMicPlayInfos(controlFromJsonString);
                                        bypassPlayInfo = null;
                                        VideoInfo videoInfo = new VideoInfo();
                                        videoInfo.costTime = currentTimeMillis;
                                        videoInfo.livePlayControl = controlFromJsonString;
                                        videoInfo.status = i2;
                                        videoInfo.loginYtid = controlFromJsonString.loginYtid;
                                        videoInfo.liveId = controlFromJsonString.liveId;
                                        videoInfo.screenId = controlFromJsonString.screenId;
                                        videoInfo.bizType = controlFromJsonString.bizType;
                                        videoInfo.landscape = controlFromJsonString.landscape;
                                        videoInfo.streamMode = controlFromJsonString.streamMode;
                                        videoInfo.pushStreamType = controlFromJsonString.pushStreamType;
                                        videoInfo.liveStatus = controlFromJsonString.liveStatus;
                                        videoInfo.mcu = controlFromJsonString.mcu;
                                        if (i2 == 2002) {
                                            videoInfo.isTrail = true;
                                        }
                                        if (list == null) {
                                            videoInfo.micPlayInfos = list;
                                            List<String> list3 = controlFromJsonString.micInfo.po;
                                            videoInfo.poList = list3;
                                            videoInfo.protocol = list3.get(0);
                                            videoInfo.videoFormat = "2";
                                            if (!controlFromJsonString.micMode.equals(PushConstants.URI_PACKAGE_NAME) || controlFromJsonString.micInfo.mcs.size() <= 1) {
                                                videoInfo.isLaifengPk = false;
                                            } else {
                                                videoInfo.isLaifengPk = true;
                                            }
                                            iPlayControlListener.requestSuccess(videoInfo);
                                            return;
                                        } else if (bypassPlayInfo == null) {
                                            return;
                                        } else {
                                            if (!ErrorCodeHelper.statusFromQualityIsOK(bypassPlayInfo.qualityCode)) {
                                                int errorFromPlayControlQuality = ErrorCodeHelper.errorFromPlayControlQuality(bypassPlayInfo.qualityCode);
                                                if (string == null) {
                                                    string = "";
                                                }
                                                iPlayControlListener.requestFailure(controlFromJsonString, errorFromPlayControlQuality, string);
                                                return;
                                            }
                                            videoInfo.bypassPlayInfo = bypassPlayInfo;
                                            videoInfo.adInfo = controlFromJsonString.adInfo;
                                            videoInfo.ad = controlFromJsonString.ad;
                                            videoInfo.waterMarkV2List = controlFromJsonString.waterMarkV2;
                                            videoInfo.protocol = bypassPlayInfo.playType;
                                            videoInfo.videoFormat = String.valueOf(bypassPlayInfo.quality);
                                            String str2 = controlFromJsonString.micMode;
                                            if (str2 == null || !str2.equals(PushConstants.URI_PACKAGE_NAME) || (micInfo = controlFromJsonString.micInfo) == null || (list2 = micInfo.mcs) == null || list2.size() <= 1) {
                                                videoInfo.isLaifengPk = false;
                                            } else {
                                                videoInfo.isLaifengPk = true;
                                            }
                                            iPlayControlListener.requestSuccess(videoInfo);
                                            return;
                                        }
                                    } else if (!LivePlayerController.containLoginYtid(controlFromJsonString)) {
                                        bypassPlayInfo = LivePlayerController.getBypassPlayInfo(str11, controlFromJsonString, str3, str);
                                    } else {
                                        iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_UNDO_PK_MCU_0, "");
                                        return;
                                    }
                                } else if ("audio".equals(controlFromJsonString.micMode)) {
                                    iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_UNDO_AUDIO_MICMODE, "");
                                    return;
                                } else {
                                    iPlayControlListener.requestFailure(controlFromJsonString, ErrorCodeHelper.LIVE_ERROR_UNDO_UNKNOWN_MICMODE, "");
                                    return;
                                }
                                list = null;
                                VideoInfo videoInfo2 = new VideoInfo();
                                videoInfo2.costTime = currentTimeMillis;
                                videoInfo2.livePlayControl = controlFromJsonString;
                                videoInfo2.status = i2;
                                videoInfo2.loginYtid = controlFromJsonString.loginYtid;
                                videoInfo2.liveId = controlFromJsonString.liveId;
                                videoInfo2.screenId = controlFromJsonString.screenId;
                                videoInfo2.bizType = controlFromJsonString.bizType;
                                videoInfo2.landscape = controlFromJsonString.landscape;
                                videoInfo2.streamMode = controlFromJsonString.streamMode;
                                videoInfo2.pushStreamType = controlFromJsonString.pushStreamType;
                                videoInfo2.liveStatus = controlFromJsonString.liveStatus;
                                videoInfo2.mcu = controlFromJsonString.mcu;
                                if (i2 == 2002) {
                                }
                                if (list == null) {
                                }
                            }
                        } else if (iPlayControlListener != null) {
                            if (string == null) {
                                string = "";
                            }
                            iPlayControlListener.requestFailure(null, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_UNPARSABLE, string);
                        }
                    } else if (iPlayControlListener != null) {
                        int errorFromPlayControl2 = ErrorCodeHelper.errorFromPlayControl(i2);
                        if (string == null) {
                            string = "";
                        }
                        iPlayControlListener.requestFailure(null, errorFromPlayControl2, string);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (iPlayControlListener != null) {
                        iPlayControlListener.requestFailure(null, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_UNPARSABLE, "");
                    }
                }
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                if (Logger.DEBUG) {
                    String str = LivePlayerController.TAG;
                    Logger.d(str, "getPlayControl onSystemError mtopResponse = " + mtopResponse);
                }
                IPlayControlListener iPlayControlListener = LivePlayerController.this.mPlayContorlListener;
                if (iPlayControlListener != null) {
                    iPlayControlListener.requestFailure(null, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_REQUEST_SYSTEM_ERROR, mtopResponse.getRetCode());
                }
            }
        });
    }

    public LivePlayerController(String str, Context context, String str2, String str3, String str4) {
        this.mLastQuality = -1;
        this.mLiveId = str == null ? "" : str;
        this.mContext = context;
        this.mCCode = str2 == null ? "" : str2;
        this.mCCode4ott = str3 == null ? "" : str3;
        this.mAppKey = str4 == null ? "" : str4;
    }
}
