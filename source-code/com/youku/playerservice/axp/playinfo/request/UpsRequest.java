package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.alisubtitle.subtitle.AliSubtitleConfig;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.constants.NetType;
import com.youku.playerservice.axp.drm.DrmManager;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.item.DrmType;
import com.youku.playerservice.axp.player.PlayerManager;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playinfo.request.task.HttpConnectionTask;
import com.youku.playerservice.axp.playinfo.request.task.MTopTask;
import com.youku.playerservice.axp.playinfo.request.task.MockTask;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.AdUtil;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.SystemUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.UpsUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.upsplayer.IUpsInfoRequest;
import com.youku.upsplayer.UpsInfoRequest;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.AntiTheftChainUtLogType;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.request.PlayVideoInfo;
import com.youku.upsplayer.util.AntiTheftChainUtUtil;
import com.youku.usercenter.passport.api.Passport;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class UpsRequest implements IPlayInfoRequest {
    private static final String TAG = "UpsRequest";
    private IPlayInfoRequest.Callback mCallback;
    private Context mContext;
    private String mDrmR1;
    private volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private PlayerConfig mPlayerConfig;
    private IUpsInfoRequest mRequest;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.playerservice.axp.playinfo.request.UpsRequest$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass2 {
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

    public UpsRequest(PlayerConfig playerConfig) {
        this.mContext = playerConfig.getContext();
        this.mPlayerConfig = playerConfig;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkResult(PlayParams playParams, VideoInfo videoInfo, ConnectStat connectStat) {
        PlayInfoError playInfoError;
        String str;
        String str2;
        PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(this.mContext, playParams);
        playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
        Logger.d(TAG, "checkResult");
        if (connectStat == null) {
            playInfoError = new PlayInfoError();
            playInfoError.setErrorCode(101);
            str2 = "网络连接失败";
        } else {
            String str3 = connectStat.rawUpsData;
            if (videoInfo == null) {
                playInfoError = new PlayInfoError();
                playInfoError.setErrorCode(28001);
                str2 = "数据请求解析异常";
            } else {
                String sessionId = playParams.getSessionId();
                TLogUtil.flowLog(sessionId, "ups url=" + connectStat.url);
                if (!connectStat.connect_success) {
                    playInfoError = new PlayInfoError();
                    playInfoError.setErrorCode(connectStat.response_code);
                    str = connectStat.errMsg;
                } else {
                    UtAntiTheaftBean utAntiTheaftBean = connectStat.utMsg;
                    if (utAntiTheaftBean != null && utAntiTheaftBean.isCkeyError) {
                        AntiTheftChainUtUtil.utlog(AntiTheftChainClientType.External, AntiTheftChainUtLogType.CKEYERROR, utAntiTheaftBean);
                    }
                    if (videoInfo.getError() != null) {
                        int i = videoInfo.getError().code;
                        String str4 = videoInfo.getError().note;
                        int i2 = i < 0 ? (i * -1) + 20000 : i;
                        PlayInfoError playInfoError2 = new PlayInfoError();
                        playInfoError2.setErrorCode(i2);
                        playInfoError2.setErrorMsg(str4);
                        playInfoError2.setConnectStat(connectStat);
                        playInfoError2.setOldErrorCode(i);
                        playInfoUpsResponse.setUpsInfo(new NetUpsInfo(videoInfo));
                        playInfoUpsResponse.setError(playInfoError2);
                        Logger.d(TAG, "server err: " + i);
                        Logger.d(TAG, "note " + str4);
                    } else if (videoInfo.getStream() == null) {
                        playInfoError = new PlayInfoError();
                        playInfoError.setErrorCode(28001);
                        str = "UPS返回信息节点异常导致解析不到播放地址";
                    } else {
                        Logger.d(TAG, "ups to main thread");
                        NetUpsInfo netUpsInfo = new NetUpsInfo(videoInfo);
                        netUpsInfo.setDrmR1(this.mDrmR1);
                        netUpsInfo.setRaw(str3);
                        playInfoUpsResponse.setUpsInfo(netUpsInfo);
                        playInfoUpsResponse.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
                        playInfoUpsResponse.setTimeOfRequestEnd(System.currentTimeMillis());
                    }
                    reportResult(playInfoUpsResponse);
                }
                playInfoError.setErrorMsg(str);
                playInfoError.setConnectStat(connectStat);
                playInfoUpsResponse.setError(playInfoError);
                reportResult(playInfoUpsResponse);
            }
        }
        playInfoError.setErrorMsg(str2);
        playInfoUpsResponse.setError(playInfoError);
        reportResult(playInfoUpsResponse);
    }

    private int constructDrmType() {
        int value = DrmType.DEFAULT.getValue() | DrmType.COPYRIGHT.getValue();
        if (ProvisionAuthenticator.isCencSupported()) {
            value |= DrmType.WV_CENC.getValue();
        }
        if (ProvisionAuthenticator.isCbcsSupported()) {
            value |= DrmType.WV_CBCS.getValue();
        }
        return (!Utils.isYoukuOrHuaweiBaipai(this.mContext) || !AliSubtitleConfig.isAes128Supported()) ? value : value | DrmType.AES128.getValue();
    }

    private NetworkParameter createNetworkParam() {
        NetworkParameter networkParameter = new NetworkParameter();
        networkParameter.connect_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        networkParameter.cookie = this.mPlayParams.getPlayIdParams().getString(HttpIntent.COOKIE);
        networkParameter.userAgent = this.mPlayerConfig.getUserAgent();
        networkParameter.read_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        return networkParameter;
    }

    private String getMediaType() {
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

    private int[] getTimeOut() {
        String config = ConfigFetcher.getInstance().getConfig("player_network_ups", "ups_retry", "5000,30000");
        if (TextUtils.isEmpty(config)) {
            return null;
        }
        Logger.d(TAG, "getTimeOut " + config);
        String[] split = config.split(",");
        if (split.length <= 0) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i] == null) {
                return null;
            }
            try {
                iArr[i] = Integer.valueOf(split[i]).intValue();
            } catch (Exception e) {
                Logger.e(TAG, e.toString());
            }
        }
        return iArr;
    }

    private void putParamWithoutNull(Map<String, String> map, PlayParams playParams, String str) {
        String string = playParams.getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            map.put(str, string);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportResult(PlayInfoResponse playInfoResponse) {
        if (this.mCallback != null && !this.mIsCancel) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(playInfoResponse);
            this.mCallback.onFinished(this.mPlayParams, arrayList);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0476  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0306 A[Catch:{ Exception -> 0x0396 }] */
    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        String dynamicProperty;
        String dynamicProperty2;
        MockTask mockTask;
        Map<String, String> map;
        String str;
        int i;
        StringBuilder sb;
        TLogUtil.playLog("request ups");
        this.mPlayParams = playParams;
        if (!this.mIsCancel) {
            PlayIdParams playIdParams = this.mPlayParams.getPlayIdParams();
            HashMap hashMap = new HashMap();
            hashMap.put("player_source", this.mPlayerConfig.getString(TableField.PLAYER_SOURCE));
            hashMap.put("extag", "EXT-X-PRIVINF");
            hashMap.put("skipPreVideo", "1");
            hashMap.put("tlogSession", this.mPlayParams.getSessionId());
            UpsUtil.addUpsParams(this.mContext, hashMap);
            UpsUtil.addUpsParams(this.mContext, hashMap, this.mPlayParams);
            putParamWithoutNull(hashMap, playParams, "local_st");
            Map<String, String> dlnaParams = playIdParams.getDlnaParams();
            String str2 = "";
            if (dlnaParams == null || dlnaParams.size() <= 0) {
                hashMap.put("master_m3u8", this.mPlayerConfig.isSupport("abrPlay") ? "1" : "0");
                hashMap.put("preferClarity", String.valueOf(this.mPlayParams.getPlayIdParams().getRequestQuality().getUpsCode()));
                hashMap.put("start_point_ms", playParams.getStartTime() + str2);
                hashMap.put("skh", playIdParams.isSkipHeadTail() ? "1" : "0");
            } else {
                String[] strArr = {"client_src", "client_src", "pdevice_utid", "pdevice_model", "master_m3u8", "preferClarity", "spdl", "start_point_ms", "skh"};
                for (int i2 = 0; i2 < 9; i2++) {
                    String str3 = strArr[i2];
                    String str4 = dlnaParams.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        hashMap.put(str3, str4);
                    }
                }
            }
            PlayVideoInfo playVideoInfo = new PlayVideoInfo();
            if (PlayerUtil.isVid(this.mPlayParams.getPlayIdParams().getPlayId())) {
                playVideoInfo.vid = this.mPlayParams.getPlayIdParams().getPlayId();
            } else {
                playVideoInfo.vid = str2;
                playVideoInfo.showid = this.mPlayParams.getPlayIdParams().getPlayId();
            }
            if (playParams.getPlayIdParams().getVideoStage() != 0) {
                playVideoInfo.show_videoseq = String.valueOf(playParams.getPlayIdParams().getVideoStage());
            }
            playVideoInfo.client_ip = NetworkUtil.getIp(this.mContext);
            playVideoInfo.ccode = !TextUtils.isEmpty(this.mPlayParams.getPlayIdParams().getCCode()) ? this.mPlayParams.getPlayIdParams().getCCode() : this.mPlayerConfig.getCCode();
            playVideoInfo.utid = UTDevice.getUtdid(this.mContext);
            playVideoInfo.client_ts = String.valueOf(System.currentTimeMillis() / 1000);
            playVideoInfo.point = "1";
            playVideoInfo.audiolang = "1";
            playVideoInfo.media_type = getMediaType();
            if (dlnaParams == null || dlnaParams.size() <= 0) {
                boolean useSystemPlayer = PlayerManager.getInstance().useSystemPlayer();
                if (useSystemPlayer || playIdParams.isDisableH265()) {
                    playVideoInfo.h265 = "0";
                } else {
                    playVideoInfo.h265 = this.mPlayerConfig.isSupport("h265") ? "1" : "0";
                }
                Map<String, String> extraParams = playIdParams.getExtraParams();
                if (!TextUtils.isEmpty(extraParams.get(Constants.Value.PASSWORD))) {
                    playVideoInfo.password = extraParams.get(Constants.Value.PASSWORD);
                }
                if ("1".equals(playParams.getString("disableDrm")) || useSystemPlayer) {
                    TLogUtil.flowLog(playParams.getSessionId(), "禁用drm，请求清流");
                    sb = new StringBuilder();
                    i = DrmType.DEFAULT.getValue();
                } else {
                    sb = new StringBuilder();
                    i = constructDrmType();
                }
                sb.append(i);
                sb.append(str2);
                str = sb.toString();
            } else {
                if (!TextUtils.isEmpty(dlnaParams.get("h265"))) {
                    playVideoInfo.h265 = dlnaParams.get("h265");
                }
                if (!TextUtils.isEmpty(dlnaParams.get("play_ability"))) {
                    playVideoInfo.play_ability = dlnaParams.get("play_ability");
                }
                if (!TextUtils.isEmpty(dlnaParams.get("p_device"))) {
                    playVideoInfo.p_device = dlnaParams.get("p_device");
                }
                if (!TextUtils.isEmpty(dlnaParams.get("src"))) {
                    playVideoInfo.src = dlnaParams.get("src");
                }
                if (!TextUtils.isEmpty(dlnaParams.get(Constants.Value.PASSWORD))) {
                    playVideoInfo.password = dlnaParams.get(Constants.Value.PASSWORD);
                }
                if (!TextUtils.isEmpty(dlnaParams.get("drm_type"))) {
                    str = dlnaParams.get("drm_type");
                }
                int i3 = AnonymousClass2.$SwitchMap$com$youku$playerservice$axp$constants$NetType[NetworkUtil.getNetType(this.mContext).ordinal()];
                playVideoInfo.network = i3 == 1 ? (i3 == 2 || i3 == 3 || i3 == 4) ? UpsConstant.UPS_NETWORK_4G : UpsConstant.UPS_NETWORK_UNKOWN : "1000";
                playVideoInfo.tq = "0";
                playVideoInfo.brand = Build.getBRAND();
                playVideoInfo.os_ver = Build.VERSION.getRELEASE();
                playVideoInfo.app_ver = Utils.getVersionName(this.mContext);
                String dynamicProperty3 = this.mPlayerConfig.getDynamicProperty(CookieUtil.COOKIE_KEY_YKTK);
                dynamicProperty = this.mPlayerConfig.getDynamicProperty(IRequestConst.STOKEN);
                String dynamicProperty4 = this.mPlayerConfig.getDynamicProperty("ptoken");
                dynamicProperty2 = this.mPlayerConfig.getDynamicProperty(IRequestConst.ATOKEN);
                if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && TextUtils.isEmpty(dynamicProperty)) {
                    dynamicProperty = Passport.getSToken();
                }
                playVideoInfo.yktk = dynamicProperty3;
                playVideoInfo.stoken = dynamicProperty;
                playVideoInfo.ptoken = dynamicProperty4;
                if (!TextUtils.isEmpty(dynamicProperty2)) {
                    hashMap.put(IRequestConst.ATOKEN, dynamicProperty2);
                }
                boolean isExternal = this.mPlayerConfig.isExternal();
                playVideoInfo.client_id = this.mPlayParams.getPlayIdParams().getClientId();
                if (this.mPlayerConfig.getDrmConfig() != null) {
                    Logger.d(TAG, "播放请求前从安全保镖接口获取加密R1，将encryptR_client和key_index参数传给ups服务端");
                    String keyIndex = this.mPlayerConfig.getDrmConfig().getKeyIndex();
                    DrmManager.Result generateEncryptRClient = DrmManager.generateEncryptRClient(this.mContext, keyIndex, this.mPlayerConfig.getDrmConfig().getAuthCode());
                    String str5 = generateEncryptRClient.encryptR;
                    this.mDrmR1 = generateEncryptRClient.R1;
                    if (PlayerManager.getInstance().useSystemPlayer()) {
                        playVideoInfo.encryptR_client = str2;
                    } else {
                        playVideoInfo.encryptR_client = str5;
                        str2 = generateEncryptRClient.keyIndex;
                    }
                    playVideoInfo.key_index = str2;
                    Logger.d("DrmManager", "R1:" + this.mDrmR1);
                    Logger.d("DrmManager", "staticSafeEncrypt:" + str5);
                    Logger.d("DrmManager", "encryptR_client:" + playVideoInfo.encryptR_client);
                    Logger.d("DrmManager", "key_index:" + keyIndex);
                }
                NetworkParameter createNetworkParam = createNetworkParam();
                PlayDefinition.NetworkType networkType = this.mPlayerConfig.getNetworkType();
                if (!"1".equals(SystemUtil.getSystemProperty("debug.ups.get.mock", "0"))) {
                    MockTask mockTask2 = new MockTask(this.mContext);
                    this.mDrmR1 = mockTask2.getR1();
                    mockTask = mockTask2;
                } else {
                    mockTask = networkType == PlayDefinition.NetworkType.MTOP ? new MTopTask(this.mContext, getTimeOut(), this.mPlayParams.getUpsProxyInfo()) : new HttpConnectionTask();
                }
                String string = this.mPlayParams.getPlayIdParams().getString("domain");
                String string2 = this.mPlayParams.getPlayIdParams().getString(TbAuthConstants.IP);
                this.mRequest = (!TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) ? new UpsInfoRequest(this.mContext, mockTask, isExternal) : new UpsInfoRequest(this.mContext, mockTask, isExternal, string, string2);
                if (dlnaParams != null || dlnaParams.size() <= 0) {
                    if (!playParams.getPlayIdParams().isDisableAd()) {
                        map = new HashMap<>();
                        map.put(IRequestConst.NEED_AD, "0");
                        map.put(IRequestConst.NEED_BF, "2");
                    } else {
                        map = AdUtil.getAdRequestParams(7);
                    }
                    if (playIdParams.isDisableBfAd()) {
                        map.put(IRequestConst.NEED_BF, "0");
                    }
                } else {
                    map = new HashMap<>();
                    if (!TextUtils.isEmpty(dlnaParams.get(IRequestConst.NEED_AD))) {
                        map.put(IRequestConst.NEED_AD, dlnaParams.get(IRequestConst.NEED_AD));
                    }
                    if (!TextUtils.isEmpty(dlnaParams.get(IRequestConst.NEED_BF))) {
                        map.put(IRequestConst.NEED_BF, dlnaParams.get(IRequestConst.NEED_BF));
                    }
                    if (!TextUtils.isEmpty(dlnaParams.get(IRequestConst.AVS))) {
                        map.put(IRequestConst.AVS, dlnaParams.get(IRequestConst.AVS));
                    }
                }
                this.mRequest.request(playVideoInfo, hashMap, map, createNetworkParam, new IUpsInfoRequest.IUpsInfoRequestCallback() {
                    /* class com.youku.playerservice.axp.playinfo.request.UpsRequest.AnonymousClass1 */

                    @Override // com.youku.upsplayer.IUpsInfoRequest.IUpsInfoRequestCallback
                    public void onFailure(IUpsInfoRequest.UpsRequestError upsRequestError) {
                        if (!UpsRequest.this.mIsCancel) {
                            PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(UpsRequest.this.mContext, UpsRequest.this.mPlayParams);
                            playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                            PlayInfoError playInfoError = new PlayInfoError();
                            playInfoError.setErrorCode(upsRequestError.getErrorCode());
                            playInfoError.setErrorMsg(upsRequestError.getErrorMsg());
                            playInfoUpsResponse.setError(playInfoError);
                            UpsRequest.this.reportResult(playInfoUpsResponse);
                        }
                    }

                    @Override // com.youku.upsplayer.IUpsInfoRequest.IUpsInfoRequestCallback
                    public void onSuccess(VideoInfo videoInfo, ConnectStat connectStat) {
                        if (!UpsRequest.this.mIsCancel) {
                            UpsRequest upsRequest = UpsRequest.this;
                            upsRequest.checkResult(upsRequest.mPlayParams, videoInfo, connectStat);
                        }
                    }
                });
            }
            playVideoInfo.drm_type = str;
            int i32 = AnonymousClass2.$SwitchMap$com$youku$playerservice$axp$constants$NetType[NetworkUtil.getNetType(this.mContext).ordinal()];
            playVideoInfo.network = i32 == 1 ? (i32 == 2 || i32 == 3 || i32 == 4) ? UpsConstant.UPS_NETWORK_4G : UpsConstant.UPS_NETWORK_UNKOWN : "1000";
            playVideoInfo.tq = "0";
            playVideoInfo.brand = Build.getBRAND();
            playVideoInfo.os_ver = Build.VERSION.getRELEASE();
            playVideoInfo.app_ver = Utils.getVersionName(this.mContext);
            String dynamicProperty32 = this.mPlayerConfig.getDynamicProperty(CookieUtil.COOKIE_KEY_YKTK);
            dynamicProperty = this.mPlayerConfig.getDynamicProperty(IRequestConst.STOKEN);
            String dynamicProperty42 = this.mPlayerConfig.getDynamicProperty("ptoken");
            dynamicProperty2 = this.mPlayerConfig.getDynamicProperty(IRequestConst.ATOKEN);
            dynamicProperty = Passport.getSToken();
            playVideoInfo.yktk = dynamicProperty32;
            playVideoInfo.stoken = dynamicProperty;
            playVideoInfo.ptoken = dynamicProperty42;
            if (!TextUtils.isEmpty(dynamicProperty2)) {
            }
            boolean isExternal2 = this.mPlayerConfig.isExternal();
            playVideoInfo.client_id = this.mPlayParams.getPlayIdParams().getClientId();
            try {
                if (this.mPlayerConfig.getDrmConfig() != null) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            NetworkParameter createNetworkParam2 = createNetworkParam();
            PlayDefinition.NetworkType networkType2 = this.mPlayerConfig.getNetworkType();
            if (!"1".equals(SystemUtil.getSystemProperty("debug.ups.get.mock", "0"))) {
            }
            String string3 = this.mPlayParams.getPlayIdParams().getString("domain");
            String string22 = this.mPlayParams.getPlayIdParams().getString(TbAuthConstants.IP);
            this.mRequest = (!TextUtils.isEmpty(string3) || TextUtils.isEmpty(string22)) ? new UpsInfoRequest(this.mContext, mockTask, isExternal2) : new UpsInfoRequest(this.mContext, mockTask, isExternal2, string3, string22);
            if (dlnaParams != null) {
            }
            if (!playParams.getPlayIdParams().isDisableAd()) {
            }
            if (playIdParams.isDisableBfAd()) {
            }
            this.mRequest.request(playVideoInfo, hashMap, map, createNetworkParam2, new IUpsInfoRequest.IUpsInfoRequestCallback() {
                /* class com.youku.playerservice.axp.playinfo.request.UpsRequest.AnonymousClass1 */

                @Override // com.youku.upsplayer.IUpsInfoRequest.IUpsInfoRequestCallback
                public void onFailure(IUpsInfoRequest.UpsRequestError upsRequestError) {
                    if (!UpsRequest.this.mIsCancel) {
                        PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(UpsRequest.this.mContext, UpsRequest.this.mPlayParams);
                        playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                        PlayInfoError playInfoError = new PlayInfoError();
                        playInfoError.setErrorCode(upsRequestError.getErrorCode());
                        playInfoError.setErrorMsg(upsRequestError.getErrorMsg());
                        playInfoUpsResponse.setError(playInfoError);
                        UpsRequest.this.reportResult(playInfoUpsResponse);
                    }
                }

                @Override // com.youku.upsplayer.IUpsInfoRequest.IUpsInfoRequestCallback
                public void onSuccess(VideoInfo videoInfo, ConnectStat connectStat) {
                    if (!UpsRequest.this.mIsCancel) {
                        UpsRequest upsRequest = UpsRequest.this;
                        upsRequest.checkResult(upsRequest.mPlayParams, videoInfo, connectStat);
                    }
                }
            });
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
