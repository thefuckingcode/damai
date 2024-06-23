package com.youku.alixplayer.opensdk.statistics;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.ups.data.StreamSegItem;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.ProvisionAuthenticator;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class VVTrack extends BaseTrack implements Track.OnExtrasBuildCallback {
    public static final String TAG = "OnePlay";
    private static final String VV_BEGIN = "begin";
    private static final String VV_END = "end";
    private long bufferLatency;
    private long dolbyMaxDuration = 0;
    private String isAdLocalPath;
    private double mBeforeNavTime;
    private int mCpuUsage;
    private int mCpuUsageCount;
    private double mFeelingStartDuration = -1.0d;
    private String mFileFormat;
    private boolean mIsPlay;
    private long mLiveControlEndTime;
    private long mLiveControlStartTime;
    private int mLoopPlayIndex;
    private long mNewRequestStartTime;
    private String mParams;
    private PlayCostTime mPlayCostTime = new PlayCostTime();
    private PlayTimeTrack mPlayTimeTrack = this.mTrack.getPlayTimeTrack();
    private long mPrepareStartTime;
    private long mStartedTime;
    private double mSwitchCount;
    protected int mVideoIndex = 0;
    private String netStatus;
    protected long playTime = 0;
    private long videoFirstFrameDuration = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum PlayMode {
        ON_WALL,
        ON_SCROLL,
        ON_REFRESH
    }

    public VVTrack(PlayerTrack playerTrack, Track track) {
        super(track);
    }

    private double calculateCpuUsage() {
        int i = this.mCpuUsageCount;
        if (i > 0) {
            return (double) (this.mCpuUsage / i);
        }
        return -1.0d;
    }

    private void commitPlayKeyStatistics(String str, int i) {
        Map<String, String> map;
        String str2;
        Map<String, Double> map2;
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        MSGTABLEID msgtableid = MSGTABLEID.ONEPLAY;
        Table table = getTable(msgtableid);
        if ("end".equals(str)) {
            map = this.mTrack.getTable(msgtableid).getDimensions();
        } else {
            map = table.getDimensions();
        }
        map.put("playType", str);
        map.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
        map.put("userId", this.mTrack.getUserId());
        String str3 = "1";
        map.put("isAuto", TrackUtil.isAuto(playVideoInfo) ? str3 : "0");
        map.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
        map.put("preloadinfo", this.mTrack.getString(TableField.PRELOAD_INFO));
        map.put("deviceChip", TrackUtil.getCpuName(this.mTrack.getContext()));
        if (this.mTrack.isFirstPlay()) {
            str2 = str3;
        } else {
            str2 = "0";
        }
        map.put("isFirstPlay", str2);
        map.put("freeFlowType", getFreeFlowType());
        if (!this.mTrack.isVip()) {
            str3 = "0";
        }
        map.put(TableField.IS_VIP, str3);
        map.put("sourceIdentity", "优酷");
        map.put("isAdLocalPath", this.isAdLocalPath);
        map.put("beforeDurationAdtype", this.mTrack.getAdTrack().getAdType());
        map.put("vvEndTime", String.valueOf(this.mTrack.getPlayerContainer().getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL)));
        map.put("DolbyType", youkuVideoInfo != null ? youkuVideoInfo.getDolbyStreamType() : null);
        map.put("loopPlayIndex", this.mLoopPlayIndex + "");
        map.put("playTime", getPlayTime() + "");
        map.put("startClarity", TrackUtil.getStartClarity(youkuVideoInfo));
        map.put("netStatus", this.netStatus);
        map.put("OrangeSession", this.mTrack.getApsVersion());
        this.mTrack.buildExtras(map, playVideoInfo, youkuVideoInfo, this);
        if ("end".equals(str)) {
            map2 = this.mTrack.mVPM.getTable(msgtableid).getMeasures();
        } else {
            map2 = table.getMeasures();
        }
        map.put(ExtrasInfo.EXTRAS, getExtras(map2));
        Double d = new Double((double) this.bufferLatency);
        Double d2 = new Double((double) this.videoFirstFrameDuration);
        map2.put("bufferLatency", d);
        map2.put("videoFirstFrameDuration", d2);
        map2.put("feelingStartDuration", Double.valueOf(this.mFeelingStartDuration));
        map2.put("impairmentDuration", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentDuration()));
        map2.put("impairmentFrequency", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
        map2.put("videoPlayDuration", Double.valueOf(youkuVideoInfo != null ? (double) youkuVideoInfo.getDuration() : 0.0d));
        map2.put("duration", Double.valueOf(this.mPlayCostTime.getPlayTime()));
        map2.put("FrameLossCount", Double.valueOf(this.mTrack.getImpairmentTrack().getDropCount()));
        map2.put("cpuUsage", Double.valueOf(calculateCpuUsage()));
        map2.put("speedX", Double.valueOf(playVideoInfo.getDouble("speedX", 0.0d)));
        map2.put("DolbyTime", Double.valueOf((double) this.dolbyMaxDuration));
        map2.put("switchCount", Double.valueOf(this.mSwitchCount));
        map2.put("beginStage", Double.valueOf((double) i));
        map2.put("D_ReadHistory", Double.valueOf(this.mTrack.getPlayVideoInfo().getDouble("D_ReadHistory", 0.0d)));
        map2.put("seekDuration", Double.valueOf(this.mTrack.getSeekChangeTrack().getSeekDuration()));
        map2.put("seekCount", Double.valueOf(this.mTrack.getSeekChangeTrack().getSeekCount()));
        map2.put("adPlayDuration", Double.valueOf((double) this.mTrack.getAdTrack().getEndPreAdTime()));
        map2.put("startPosition", Double.valueOf(playVideoInfo.getDouble("startPosition", -1.0d)));
        map2.put("renderMode", Double.valueOf(playVideoInfo.getDouble("renderMode", -1.0d)));
        map2.put("p2pCode", Double.valueOf(TrackUtil.getDoubleValue(playVideoInfo.getString("p2pCode", "-1"))));
        map2.put("bufferModeStrategy", Double.valueOf(playVideoInfo.getDouble("bufferModeStrategy", -1.0d)));
        map2.put("playTime", Double.valueOf(getPlayTime()));
        map2.put("ipChangeTotalCnt", Double.valueOf(this.mTrack.getOneEventTrack().getIpChangeTotalCnt()));
        map2.put("ipChangeSuccCnt", Double.valueOf(this.mTrack.getOneEventTrack().getIpChangeSuccCnt()));
        map2.put("drm_support", Double.valueOf((double) ProvisionAuthenticator.getWidevineStats()));
        map2.putAll(this.mPlayTimeTrack.getFastPlayTimes());
        map2.putAll(this.mPlayTimeTrack.getPlayerCoreTimes());
        if (isEmpty(map.get(TableField.FILE_FORMAT)) && youkuVideoInfo != null) {
            String fileFormat = getFileFormat(youkuVideoInfo);
            this.mFileFormat = fileFormat;
            map.put(TableField.FILE_FORMAT, fileFormat);
        }
        VpmProxy.commitOnePlayStatistics(map, map2);
        TrackUtil.printlog("OnePlay-" + str, "VV " + str, map, map2);
        TLogUtil.vpmLog("OnePlay-" + str + ":baseInfo:" + map.toString());
        TLogUtil.vpmLog("OnePlay-" + str + ":statisticsInfo:" + map2.toString());
        if ("begin".equals(str)) {
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getFastPlayTimes().toString());
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getTimestamps().toString());
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getPlayerCoreTimes().toString());
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getPlayerCoreTimestamp().toString());
        }
        this.mTrack.onMonitorPoint("onePlay", map, map2);
    }

    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x03f2  */
    private String getExtras(Map<String, Double> map) {
        long j;
        PlayMode playMode;
        long j2;
        long j3;
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        Map extras = this.mTrack.getExtras(youkuVideoInfo);
        extras.put("isPlayDirectly", "0");
        extras.put("changeOnline", playVideoInfo.getMonitor("changeOnline", "0"));
        extras.put("changeOffline", playVideoInfo.getMonitor("changeOffline", "0"));
        if (!(youkuVideoInfo == null || youkuVideoInfo.getUpsVideoInfo() == null || youkuVideoInfo.getUpsVideoInfo().getVideo() == null)) {
            extras.put("stSorted", youkuVideoInfo.getUpsVideoInfo().getVideo().st_sorted);
        }
        extras.put("netCostFrom", playVideoInfo.getMonitor("netCostFrom", null));
        extras.put("clickTs", this.mPlayTimeTrack.getClickStartTime() + "");
        extras.put("willAppearTs", this.mPlayTimeTrack.getWillAppearTime() + "");
        extras.put("didAppearTs", this.mPlayTimeTrack.getDidAppearTime() + "");
        extras.put("liveControlStartTs", this.mLiveControlStartTime + "");
        extras.put("liveControlEndTs", this.mLiveControlEndTime + "");
        extras.put("activityCreateTs", this.mPlayTimeTrack.getActivityCreateTime() + "");
        extras.put("playwidgetInitTs", this.mPlayTimeTrack.getPlayWidgetInitTime() + "");
        extras.put("playerPrepareTs", this.mPlayTimeTrack.getPlayerPrepareTime() + "");
        extras.put("playerStartTs", this.mPlayTimeTrack.getPlayerStartTime() + "");
        extras.put("setDisplayTs", this.mPlayTimeTrack.getSetDisplayTime() + "");
        extras.put("liveControlCost", (this.mLiveControlEndTime - this.mLiveControlStartTime) + "");
        extras.put("newRequestStartTs", this.mNewRequestStartTime + "");
        extras.put("prepareStartTs", this.mPrepareStartTime + "");
        extras.put("D_SOURCE_Create", map.get("D_SOURCE_Create") + "");
        extras.put("D_Wait_Surface_Time", map.get("D_Wait_Surface_Time") + "");
        extras.put("D_Signal_Time", map.get("D_Signal_Time") + "");
        extras.put("D_Media_Time", map.get("D_Media_Time") + "");
        extras.put("videoStartedTime", this.mStartedTime + "");
        String string = this.mTrack.getString("secondVideoStartTime");
        if (!TextUtils.isEmpty(string)) {
            try {
                j = Long.parseLong(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (!"1".equals(this.mTrack.getString("isOnWall"))) {
                playMode = PlayMode.ON_WALL;
            } else {
                String string2 = playVideoInfo.getString(TableField.PLAY_FROM);
                if ("willAppear".equals(string2) || "didAppear".equals(string2)) {
                    playMode = PlayMode.ON_SCROLL;
                } else {
                    playMode = PlayMode.ON_REFRESH;
                }
            }
            if (playMode != PlayMode.ON_WALL) {
                extras.put("extras-isscroll", "0");
                j3 = this.mStartedTime - this.mPlayTimeTrack.getClickStartTime();
                extras.put("feelingTime", j3 + "");
                extras.put("proprioceptionTime", j3 + "");
                if (j == -1) {
                    extras.put("secondProprioceptionTime", "0");
                } else {
                    j2 = j - this.mPlayTimeTrack.getClickStartTime();
                    extras.put("secondProprioceptionTime", j2 + "");
                    extras.put("maxProprioceptionTime", Math.max(j3, j2) + "");
                    extras.put(IDynamicConfig.KEY_DEVICE_SCORE, playVideoInfo.getString(IDynamicConfig.KEY_DEVICE_SCORE));
                    extras.put("limitReqTime", playVideoInfo.getString("limitTime", "0"));
                    extras.put("playerInitTime", playVideoInfo.getString("playerInitTime", "0"));
                    extras.put("adReqTime", playVideoInfo.getString("adReqTime", "0"));
                    extras.put("pending", playVideoInfo.getString("pending"));
                    extras.put("beforeNavTime", this.mBeforeNavTime + "");
                    extras.put("subtitleFail", playVideoInfo.getString("subtitleFail"));
                    extras.put("playtrigger", !TextUtils.isEmpty(playVideoInfo.getString("LUCSessionID")) ? "no" : BQCCameraParam.VALUE_YES);
                    extras.put("rotateStayTime", (this.mPlayTimeTrack.getRotateStayTime() / 1000) + "");
                    return extras.toString();
                }
            } else {
                if (playMode == PlayMode.ON_SCROLL) {
                    j3 = this.mStartedTime - this.mPlayTimeTrack.getDidAppearTime();
                    extras.put("extras-isscroll", "1");
                    extras.put("feelingTime", j3 + "");
                    extras.put("proprioceptionTime", j3 + "");
                    if (j == -1) {
                        extras.put("secondProprioceptionTime", "0");
                    } else {
                        j2 = j - this.mPlayTimeTrack.getDidAppearTime();
                        extras.put("secondProprioceptionTime", j2 + "");
                    }
                } else if (playMode == PlayMode.ON_REFRESH) {
                    j3 = this.mStartedTime - this.mPlayTimeTrack.getDidAppearTime();
                    extras.put("extras-isscroll", "");
                    extras.put("feelingTime", j3 + "");
                    extras.put("proprioceptionTime", j3 + "");
                    if (j == -1) {
                        extras.put("secondProprioceptionTime", "0");
                        j2 = -1;
                    } else {
                        j2 = j - this.mPlayTimeTrack.getDidAppearTime();
                        extras.put("secondProprioceptionTime", j2 + "");
                    }
                } else {
                    j3 = -1;
                    j2 = -1;
                }
                extras.put("maxProprioceptionTime", Math.max(j3, j2) + "");
                extras.put(IDynamicConfig.KEY_DEVICE_SCORE, playVideoInfo.getString(IDynamicConfig.KEY_DEVICE_SCORE));
                extras.put("limitReqTime", playVideoInfo.getString("limitTime", "0"));
                extras.put("playerInitTime", playVideoInfo.getString("playerInitTime", "0"));
                extras.put("adReqTime", playVideoInfo.getString("adReqTime", "0"));
                extras.put("pending", playVideoInfo.getString("pending"));
                extras.put("beforeNavTime", this.mBeforeNavTime + "");
                extras.put("subtitleFail", playVideoInfo.getString("subtitleFail"));
                extras.put("playtrigger", !TextUtils.isEmpty(playVideoInfo.getString("LUCSessionID")) ? "no" : BQCCameraParam.VALUE_YES);
                extras.put("rotateStayTime", (this.mPlayTimeTrack.getRotateStayTime() / 1000) + "");
                return extras.toString();
            }
            j2 = -1;
            extras.put("maxProprioceptionTime", Math.max(j3, j2) + "");
            extras.put(IDynamicConfig.KEY_DEVICE_SCORE, playVideoInfo.getString(IDynamicConfig.KEY_DEVICE_SCORE));
            extras.put("limitReqTime", playVideoInfo.getString("limitTime", "0"));
            extras.put("playerInitTime", playVideoInfo.getString("playerInitTime", "0"));
            extras.put("adReqTime", playVideoInfo.getString("adReqTime", "0"));
            extras.put("pending", playVideoInfo.getString("pending"));
            extras.put("beforeNavTime", this.mBeforeNavTime + "");
            extras.put("subtitleFail", playVideoInfo.getString("subtitleFail"));
            extras.put("playtrigger", !TextUtils.isEmpty(playVideoInfo.getString("LUCSessionID")) ? "no" : BQCCameraParam.VALUE_YES);
            extras.put("rotateStayTime", (this.mPlayTimeTrack.getRotateStayTime() / 1000) + "");
            return extras.toString();
        }
        j = -1;
        if (!"1".equals(this.mTrack.getString("isOnWall"))) {
        }
        if (playMode != PlayMode.ON_WALL) {
        }
        j2 = -1;
        extras.put("maxProprioceptionTime", Math.max(j3, j2) + "");
        extras.put(IDynamicConfig.KEY_DEVICE_SCORE, playVideoInfo.getString(IDynamicConfig.KEY_DEVICE_SCORE));
        extras.put("limitReqTime", playVideoInfo.getString("limitTime", "0"));
        extras.put("playerInitTime", playVideoInfo.getString("playerInitTime", "0"));
        extras.put("adReqTime", playVideoInfo.getString("adReqTime", "0"));
        extras.put("pending", playVideoInfo.getString("pending"));
        extras.put("beforeNavTime", this.mBeforeNavTime + "");
        extras.put("subtitleFail", playVideoInfo.getString("subtitleFail"));
        extras.put("playtrigger", !TextUtils.isEmpty(playVideoInfo.getString("LUCSessionID")) ? "no" : BQCCameraParam.VALUE_YES);
        extras.put("rotateStayTime", (this.mPlayTimeTrack.getRotateStayTime() / 1000) + "");
        return extras.toString();
    }

    private String getHlsInfoFromUrl(String str) {
        if (str == null || !"1".equals(Uri.parse(str).getQueryParameter("sm"))) {
            return "0";
        }
        return "1";
    }

    private void onFirstFrame() {
        if (!this.mIsPlay) {
            this.mIsPlay = true;
            this.mPlayTimeTrack.putTimestamp("adStartTs", System.currentTimeMillis());
            this.mPlayTimeTrack.putTimestamp("realVideoStartTs", System.currentTimeMillis());
            long currentTimeMillis = System.currentTimeMillis();
            this.mStartedTime = currentTimeMillis;
            long playStartTime = this.mPlayTimeTrack.getPlayStartTime();
            long clickStartTime = this.mPlayTimeTrack.getClickStartTime();
            if (clickStartTime > 0) {
                this.mFeelingStartDuration = (double) (currentTimeMillis - clickStartTime);
            } else {
                this.mFeelingStartDuration = (double) (currentTimeMillis - this.mPlayTimeTrack.getWillAppearTime());
            }
            long j = currentTimeMillis - playStartTime;
            this.videoFirstFrameDuration = j;
            if (this.mTrack.getAdTrack().getEndPreAdTime() != 0) {
                this.bufferLatency = currentTimeMillis - this.mTrack.getAdTrack().getEndPreAdTime();
            } else {
                this.bufferLatency = j;
            }
            this.mLiveControlStartTime = this.mPlayTimeTrack.getLiveControlStartTime();
            this.mLiveControlEndTime = this.mPlayTimeTrack.getLiveControlEndTime();
            this.mNewRequestStartTime = this.mPlayTimeTrack.getNewRequestStartTime();
            this.mPrepareStartTime = this.mPlayTimeTrack.getPrepareStartTime();
            this.mPlayTimeTrack.finish();
        }
    }

    public void addSwitchCounts() {
        this.mSwitchCount += 1.0d;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.Track.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    /* access modifiers changed from: protected */
    public double getDoubleValue(String str) {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception unused) {
            VpmProxy.alarmCommitFail("vpm", "commitPlayKeyStatistics", HiAnalyticsConstant.KeyAndValue.NUMBER_01, str);
            return 0.0d;
        }
    }

    public String getFileFormat(YoukuVideoInfo youkuVideoInfo) {
        String str = null;
        if (youkuVideoInfo == null || this.mTrack.getPlayVideoInfo().getPlayType() != PlayType.LIVE) {
            if (isEmpty(null) && youkuVideoInfo != null) {
                str = TrackUtil.getFileFormatByUrl(getUrl(youkuVideoInfo));
            }
            if (isEmpty(str)) {
                str = this.mTrack.getPlayVideoInfo().getString(TableField.FILE_FORMAT, "-1");
            }
            if (str != null) {
                return str;
            }
            return "-1";
        }
        LiveInfo liveInfo = youkuVideoInfo.getLiveInfo();
        if (liveInfo == null) {
            return null;
        }
        BypassPlayInfo bypassPlayInfo = liveInfo.bypassPlayInfo;
        if (bypassPlayInfo != null) {
            String str2 = bypassPlayInfo.url;
            if (!isEmpty(str2)) {
                str = TrackUtil.getFileFormatByUrl(str2);
            }
        }
        return (!isEmpty(str) || liveInfo.getFileFormat() == FileFormat.UNKNOWN) ? str : liveInfo.getFileFormat().getStatistics();
    }

    public String getFreeFlowType() {
        if (this.mTrack.getPlayerConfig().getDynamicProperties() != null) {
            return this.mTrack.getPlayerConfig().getDynamicProperties().call("freeFlowType");
        }
        return null;
    }

    public String getIsPlayFromCache() {
        return this.mTrack.getTable(MSGTABLEID.ONEPLAY).getDimensions().get("isPlayFromCache");
    }

    public int getLoopPlayIndex() {
        return this.mLoopPlayIndex;
    }

    public String getParams() {
        return this.mParams;
    }

    public double getPlayTime() {
        return this.mPlayCostTime.getPlayTime();
    }

    public PlayTimeTrack getPlayTimeTrack() {
        return this.mPlayTimeTrack;
    }

    public String getPlayWay(YoukuVideoInfo youkuVideoInfo) {
        return "net";
    }

    public String getPushStreamType(YoukuVideoInfo youkuVideoInfo) {
        LiveInfo liveInfo;
        VideoInfo videoInfo;
        return (youkuVideoInfo == null || this.mTrack.getPlayVideoInfo().getPlayType() != PlayType.LIVE || (liveInfo = youkuVideoInfo.getLiveInfo()) == null || (videoInfo = liveInfo.videoInfo) == null) ? "" : videoInfo.pushStreamType;
    }

    /* access modifiers changed from: protected */
    public String getUrl(YoukuVideoInfo youkuVideoInfo) {
        IVideoStream videoStream;
        BitStream currentBitStream;
        int i;
        String str = this.mTrack.getTable(MSGTABLEID.ONEPLAY).getDimensions().get("URL");
        if (!isEmpty(str)) {
            return str;
        }
        if (youkuVideoInfo == null || (videoStream = this.mTrack.getPlayerContainer().getVideoStream()) == null || (currentBitStream = videoStream.getCurrentBitStream()) == null) {
            return null;
        }
        Quality quality = currentBitStream.getQuality();
        String m3u8Text = currentBitStream.getM3u8Text();
        String m3u8Url = currentBitStream.getM3u8Url();
        if (quality == Quality.AUTO && !TextUtils.isEmpty(m3u8Text)) {
            return m3u8Text;
        }
        if (!TextUtils.isEmpty(m3u8Url) && "1".equals(Uri.parse(m3u8Url).getQueryParameter("sm"))) {
            return m3u8Url;
        }
        List<StreamSegItem> streamSegList = currentBitStream.getStreamSegList();
        if (streamSegList == null || streamSegList.size() <= 0 || this.mVideoIndex >= streamSegList.size() || (i = this.mVideoIndex) < 0) {
            return null;
        }
        StreamSegItem streamSegItem = streamSegList.get(i);
        if (streamSegItem == null) {
            return str;
        }
        if (!TextUtils.isEmpty(streamSegItem.getCDNUrl())) {
            return streamSegItem.getCDNUrl();
        }
        return !TextUtils.isEmpty(streamSegItem.getRTMPUrl()) ? streamSegItem.getRTMPUrl() : str;
    }

    public void onAdStart() {
        onFirstFrame();
    }

    public void onCpuUsage(int i) {
        this.mCpuUsage += i;
        this.mCpuUsageCount++;
    }

    public void onCurrentPositionUpdate(int i) {
        this.mPlayCostTime.onCurrentPositionUpdate(i, -1);
    }

    public void onRealVideoStart() {
        onFirstFrame();
    }

    public void onVVBegin(int i) {
        this.netStatus = StaticsUtil.getNetStatus();
        commitPlayKeyStatistics("begin", i);
    }

    public void onVVEnd() {
        commitPlayKeyStatistics("end", 0);
    }

    public void setIsADPlayFromCache(int i) {
        if (TextUtils.isEmpty(this.isAdLocalPath)) {
            this.isAdLocalPath = String.valueOf(i);
        }
    }

    public void setLoopPlayIndex(int i) {
        this.mLoopPlayIndex = i;
    }

    public void setPrepareInfo(int i, int i2, Object obj, long j) {
        TLogUtil.loge("OnePlay", "setPrepareInfo:  obj:" + String.valueOf(obj));
        if (obj != null) {
            this.mParams = String.valueOf(obj);
        }
    }
}
