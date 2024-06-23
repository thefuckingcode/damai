package com.youku.alixplayer.opensdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener;
import com.youku.alixplayer.opensdk.statistics.data.ExtraMap;
import com.youku.alixplayer.opensdk.statistics.data.ExtrasNetm3sInfo;
import com.youku.alixplayer.opensdk.statistics.data.ExtrasPlayerInfo;
import com.youku.alixplayer.opensdk.statistics.data.ExtrasVideoInfo;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.VPM;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.track.OneChangeTrack;
import com.youku.alixplayer.opensdk.statistics.track.OneEventTrack;
import com.youku.alixplayer.opensdk.statistics.track.PlayAbnormalDetailTrack;
import com.youku.alixplayer.opensdk.statistics.track.PlayAbnormalSummaryTrack;
import com.youku.alixplayer.opensdk.statistics.track.SubtitleEventTrack;
import com.youku.alixplayer.opensdk.statistics.track.impairment.ImpairmentTrack;
import com.youku.alixplayer.opensdk.statistics.track.quality.QualityChangeTrack;
import com.youku.alixplayer.opensdk.statistics.track.seek.SeekChangeTrack;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class Track implements ITrack {
    public static final String TAG = "Track";
    private int VPMIndex = -1;
    public boolean isFromPreload;
    private boolean isRealVideoCompletion;
    private boolean isRealVideoStarted = false;
    private boolean isVVActive;
    private final AbrPerformTrack mAbrPerformTrack;
    private final AdTrack mAdTrack;
    private Context mContext;
    private final ErrorTrack mErrorTrack;
    private final ImpairmentTrack mImpairmentTrack;
    private boolean mIsFirstPlay;
    private boolean mIsGetVideoInfoSuccess;
    private List<OnExtrasBuildCallback> mOnExtrasBuildCallbacks = new CopyOnWriteArrayList();
    private List<OnPlayerTrackListener> mOnPlayerTrackListeners;
    private final OneChangeTrack mOneChangeTrack;
    private final OneEventTrack mOneEventTrack;
    private Map<String, String> mParamsFromCore = new ConcurrentHashMap();
    private final PlayAbnormalDetailTrack mPlayAbnormalDetailTrack;
    private final PlayAbnormalSummaryTrack mPlayAbnormalSummaryTrack;
    private final PlayTimeTrack mPlayTimeTrack;
    private PlayVideoInfo mPlayVideoInfo;
    public final AlixPlayerContainer mPlayerContainer;
    private PlayerTrack mPlayerTrack;
    private final QualityChangeTrack mQualityChangeTrack;
    private final SeekChangeTrack mSeekChangeTrack;
    public double mSpeedX;
    private Map<String, String> mStringMap = new ConcurrentHashMap();
    private final SubtitleEventTrack mSubtitleEventTrack;
    private String[] mTrackKeys = {TableField.PRELOAD_INFO, TableField.PLAY_FROM};
    public VPM mVPM = new VPM();
    private final String mVVId;
    private final VVTrack mVVTrack;
    private YoukuVideoInfo mVideoInfo;

    /* compiled from: Taobao */
    public interface OnExtrasBuildCallback {
        void buildExtras(String str, Map<String, String> map);
    }

    public Track(Context context, PlayVideoInfo playVideoInfo, AlixPlayerContainer alixPlayerContainer, PlayerTrack playerTrack) {
        this.mContext = context;
        this.mPlayTimeTrack = new PlayTimeTrack(playVideoInfo);
        this.mPlayerContainer = alixPlayerContainer;
        this.mPlayerTrack = playerTrack;
        this.mIsFirstPlay = playerTrack.mIsFirstPlay;
        this.mPlayVideoInfo = playVideoInfo;
        this.mOnPlayerTrackListeners = playerTrack.getOnPlayerTrackListeners();
        this.mImpairmentTrack = new ImpairmentTrack(this);
        this.mErrorTrack = new ErrorTrack(this);
        this.mVVTrack = new VVTrack(playerTrack, this);
        this.mOneChangeTrack = new OneChangeTrack(this);
        this.mAdTrack = new AdTrack(this);
        this.mOneEventTrack = new OneEventTrack(this);
        this.mSeekChangeTrack = new SeekChangeTrack(this);
        this.mQualityChangeTrack = new QualityChangeTrack(this);
        this.mPlayAbnormalDetailTrack = new PlayAbnormalDetailTrack(this);
        this.mPlayAbnormalSummaryTrack = new PlayAbnormalSummaryTrack(this);
        this.mSubtitleEventTrack = new SubtitleEventTrack(this);
        this.mAbrPerformTrack = new AbrPerformTrack(this);
        this.mVVId = UUID.randomUUID().toString();
        String[] strArr = this.mTrackKeys;
        for (String str : strArr) {
            putString(str, playVideoInfo.getString(str));
        }
    }

    private String getCurrentLanguageCode() {
        if (this.mPlayerContainer.getVideoStream() == null || this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() == null) {
            return this.mPlayVideoInfo.getRequestLanguageCode();
        }
        return this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getLanguageCode();
    }

    public void buildExtras(Map<String, String> map, PlayVideoInfo playVideoInfo, YoukuVideoInfo youkuVideoInfo, OnExtrasBuildCallback onExtrasBuildCallback) {
        map.put("extras_player_info", new ExtrasPlayerInfo(this, playVideoInfo).toString());
        onExtrasBuildCallback.buildExtras("extras_player_info", map);
        map.put("extras_netm3s_info", new ExtrasNetm3sInfo(this, playVideoInfo).toString());
        onExtrasBuildCallback.buildExtras("extras_netm3s_info", map);
        map.put("extras_video_info", new ExtrasVideoInfo(this, playVideoInfo, youkuVideoInfo).toString());
        onExtrasBuildCallback.buildExtras("extras_video_info", map);
    }

    public void firstStart() {
        this.mPlayTimeTrack.onStart(PlayTimeTrack.PREPARED_FIRSTFRAME);
        this.mPlayTimeTrack.putTimestamp("playerPreparedTs", System.currentTimeMillis());
    }

    public AdTrack getAdTrack() {
        return this.mAdTrack;
    }

    public IAlixPlayer getAlixPlayer() {
        if (this.mPlayerContainer.getPlayer() instanceof IAlixPlayer) {
            return (IAlixPlayer) this.mPlayerContainer.getPlayer();
        }
        return null;
    }

    public String getApsVersion() {
        return this.mPlayerTrack.getDynamicProperties("apsVersion");
    }

    public Context getContext() {
        return this.mContext;
    }

    public BitStream getCurrentBitStream() {
        IVideoStream videoStream = this.mPlayerContainer.getVideoStream();
        if (videoStream == null) {
            return null;
        }
        return videoStream.getCurrentBitStream();
    }

    public Quality getCurrentQuality() {
        if (this.mPlayerContainer.getVideoStream() == null || this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() == null) {
            return this.mPlayVideoInfo.getRequestQuality();
        }
        return this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getQuality();
    }

    public AlixVideoItem getCurrentVideoItem() {
        if (this.mPlayerContainer.getVideoStream() != null) {
            return this.mPlayerContainer.getVideoStream().getCurAlixVideoItem();
        }
        return null;
    }

    public ErrorTrack getErrorTrack() {
        return this.mErrorTrack;
    }

    public Map getExtras(YoukuVideoInfo youkuVideoInfo) {
        ExtraMap extraMap = new ExtraMap();
        PlayVideoInfo playVideoInfo = this.mPlayVideoInfo;
        boolean z = playVideoInfo.getRequestQuality() == Quality.AUTO;
        extraMap.put((Object) "hasMaster", (Object) playVideoInfo.getMonitor("hasMaster", null));
        extraMap.put((Object) "useMaster", (Object) (z ? "1" : "0"));
        extraMap.put((Object) "requestQuality", (Object) (playVideoInfo.getRequestQuality() + ""));
        extraMap.put((Object) "playQuality", (Object) (getCurrentQuality() + ""));
        extraMap.put((Object) "requestLang", (Object) playVideoInfo.getRequestLanguageCode());
        extraMap.put((Object) "playLang", (Object) getCurrentLanguageCode());
        extraMap.put((Object) "bitStreamChange", (Object) playVideoInfo.getMonitor("bitStreamChange", null));
        extraMap.put((Object) "langChange", (Object) playVideoInfo.getMonitor("langChange", null));
        extraMap.put((Object) "playRetry", (Object) playVideoInfo.getMonitor("playRetry", null));
        extraMap.put((Object) "error", (Object) playVideoInfo.getMonitor("error", "0"));
        extraMap.put((Object) "replay", (Object) playVideoInfo.getMonitor("replay", null));
        extraMap.put((Object) "spm-url", (Object) playVideoInfo.getMonitor("spm-url", null));
        extraMap.put((Object) "scm", (Object) playVideoInfo.getMonitor("scm", null));
        extraMap.put((Object) "pv-spm-pre", (Object) playVideoInfo.getMonitor("pv-spm-pre", null));
        extraMap.put((Object) "feedVpm", (Object) playVideoInfo.getMonitor("feedVpm", null));
        extraMap.put((Object) "ntkInterfere", (Object) playVideoInfo.getString("ntkInterfere", null));
        extraMap.put((Object) "ntkInterfereEnable", (Object) playVideoInfo.getString("ntkInterfereEnable", null));
        extraMap.put((Object) "catonTip", (Object) playVideoInfo.getString("catonTip", null));
        extraMap.put((Object) "wifiInfo", (Object) playVideoInfo.getString("wifiInfo", null));
        extraMap.put((Object) "pcdnVersion", (Object) (getPlayerConfig().getDynamicProperties() != null ? getPlayerConfig().getDynamicProperties().call("pcdnVersion") : null));
        extraMap.put((Object) "smartTileError", (Object) playVideoInfo.getMonitor("smartTileError", null));
        extraMap.put((Object) "useSmartTile", (Object) playVideoInfo.getMonitor("useSmartTile", "0"));
        if (!(youkuVideoInfo == null || youkuVideoInfo.getUpsVideoInfo() == null || youkuVideoInfo.getUpsVideoInfo().getUps() == null)) {
            extraMap.put((Object) "upsClientNetIP", (Object) youkuVideoInfo.getUpsVideoInfo().getUps().ups_client_netip);
        }
        if (youkuVideoInfo != null) {
            extraMap.put((Object) "extras-ismcu", (Object) youkuVideoInfo.isMcu());
            extraMap.put((Object) "extras-ispk", (Object) youkuVideoInfo.isPK());
        }
        extraMap.put((Object) "tinywindowNumOfEnter", (Object) playVideoInfo.getString("tinywindowNumOfEnter", null));
        extraMap.put((Object) "tinywindowTimeOfPlay", (Object) playVideoInfo.getString("tinywindowTimeOfPlay", null));
        extraMap.put((Object) "tinywindowNumOfKeep", (Object) playVideoInfo.getString("tinywindowNumOfKeep", null));
        extraMap.put((Object) "tinyWindowType", (Object) playVideoInfo.getString("tinyWindowType", null));
        extraMap.put((Object) "tinywindowRefusePermission", (Object) playVideoInfo.getString("tinywindowRefusePermission", null));
        return extraMap;
    }

    public ImpairmentTrack getImpairmentTrack() {
        return this.mImpairmentTrack;
    }

    public OneChangeTrack getOneChangeTrack() {
        return this.mOneChangeTrack;
    }

    public OneEventTrack getOneEventTrack() {
        return this.mOneEventTrack;
    }

    public VVTrack getOnePlayTrack() {
        return this.mVVTrack;
    }

    public String getParamsFromCore(String str, String str2) {
        return this.mParamsFromCore.containsKey(str) ? this.mParamsFromCore.get(str) : str2;
    }

    public PlayAbnormalDetailTrack getPlayAbnormalDetailTrack() {
        return this.mPlayAbnormalDetailTrack;
    }

    public PlayAbnormalSummaryTrack getPlayAbnormalSummaryTrack() {
        return this.mPlayAbnormalSummaryTrack;
    }

    public PlayTimeTrack getPlayTimeTrack() {
        return this.mPlayTimeTrack;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerContainer.getPlayerConfig();
    }

    public AlixPlayerContainer getPlayerContainer() {
        return this.mPlayerContainer;
    }

    public String getPlayerInfoByKey(int i) {
        return ((IAlixPlayer) this.mPlayerContainer.getPlayer()).getPlayerInfoByKey(i);
    }

    public void getPlayerInfoForVVEnd(String str) {
        if (!this.mParamsFromCore.containsKey(-1) && getAlixPlayer() != null) {
            String playerInfoByKey = getAlixPlayer().getPlayerInfoByKey(-1);
            if (!TextUtils.isEmpty(playerInfoByKey)) {
                this.mParamsFromCore.put("-1", playerInfoByKey);
                this.mVPM.setParams(VPM.VVEND, playerInfoByKey);
                getPlayAbnormalSummaryTrack().getPlayerInfoForVVEnd(playerInfoByKey);
                TLogUtil.vpmLog(str + " mVVEndInfo: " + playerInfoByKey);
            }
        }
    }

    public String getPlayerSource() {
        return this.mPlayerContainer.getPlayerConfig().getExtras().getString(TableField.PLAYER_SOURCE);
    }

    public QualityChangeTrack getQualityChangeTrack() {
        return this.mQualityChangeTrack;
    }

    public Reporter getReporter() {
        if (getAlixPlayer() != null) {
            return getAlixPlayer().getReporter();
        }
        return null;
    }

    public SeekChangeTrack getSeekChangeTrack() {
        return this.mSeekChangeTrack;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public String getString(String str) {
        return this.mStringMap.get(str);
    }

    public SubtitleEventTrack getSubtitleEventTrack() {
        return this.mSubtitleEventTrack;
    }

    public Table getTable(MSGTABLEID msgtableid) {
        return this.mVPM.getTable(msgtableid);
    }

    public String getUserId() {
        if (this.mPlayerContainer.getPlayerConfig().getDynamicProperties() == null) {
            return null;
        }
        return this.mPlayerContainer.getPlayerConfig().getDynamicProperties().call("userId");
    }

    public int getVPMIndex() {
        int i = this.VPMIndex + 1;
        this.VPMIndex = i;
        return i;
    }

    public String getVVId() {
        return this.mVVId;
    }

    public String getVideoCodec() {
        Table table = this.mVPM.getTable(MSGTABLEID.ONEPLAY);
        return (table == null || table.getDimensions() == null) ? "-1" : table.getDimensions().get("videoCode");
    }

    public YoukuVideoInfo getYoukuVideoInfo() {
        return this.mVideoInfo;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public boolean isDataReady() {
        return this.mIsGetVideoInfoSuccess;
    }

    public boolean isFirstPlay() {
        return this.mIsFirstPlay;
    }

    public boolean isLogin() {
        if (this.mPlayerContainer.getPlayerConfig().getDynamicProperties() == null) {
            return false;
        }
        return "1".equalsIgnoreCase(this.mPlayerContainer.getPlayerConfig().getDynamicProperties().call("isLogin"));
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public boolean isRealVideoCompletion() {
        return this.isRealVideoCompletion;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public boolean isRealVideoStarted() {
        return this.isRealVideoStarted;
    }

    public boolean isVip() {
        if (this.mPlayerContainer.getPlayerConfig().getDynamicProperties() == null) {
            return false;
        }
        return "1".equalsIgnoreCase(this.mPlayerContainer.getPlayerConfig().getDynamicProperties().call(TableField.IS_VIP));
    }

    public void onCompletion() {
        onVVEnd();
        this.isRealVideoCompletion = true;
    }

    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        this.mVideoInfo = youkuVideoInfo;
        this.mIsGetVideoInfoSuccess = true;
        this.mPlayTimeTrack.putTimestamp("requestEndTs", System.currentTimeMillis());
    }

    public void onMonitorPoint(String str, Map<String, String> map, Map<String, Double> map2) {
        OnPlayerTrackListener.Result result = new OnPlayerTrackListener.Result(map, map2);
        this.mAbrPerformTrack.onMonitorPoint(this, str, result);
        for (OnPlayerTrackListener onPlayerTrackListener : this.mOnPlayerTrackListeners) {
            if (onPlayerTrackListener != null) {
                onPlayerTrackListener.onMonitorPoint(this, str, result);
            }
        }
    }

    public void onNewRequest() {
        this.mErrorTrack.onStartLoading("newRequest");
        this.mPlayTimeTrack.onStart(PlayTimeTrack.PLAY_SOURCEREADY);
        this.mPlayTimeTrack.putTimestamp("requestStartTs", System.currentTimeMillis());
    }

    public void onRealVideoStart() {
        this.mVVTrack.onRealVideoStart();
        this.mAdTrack.onRealVideoStart();
        this.mErrorTrack.onRealVideoStart();
        this.isRealVideoStarted = true;
    }

    public void onVVBegin(int i) {
        if (!this.isVVActive) {
            this.mPlayerTrack.mIsFirstPlay = false;
            this.mVVTrack.onVVBegin(i);
            if (i == 2) {
                this.isVVActive = true;
            }
        }
    }

    public void onVVEnd() {
        if (this.isVVActive && this.mVideoInfo != null) {
            getPlayerInfoForVVEnd("onVVEnd is null");
            this.mVVTrack.onVVEnd();
            getPlayAbnormalSummaryTrack().commit(this.mVideoInfo);
            this.isVVActive = false;
        }
    }

    public void prepareAsync() {
        this.mPlayTimeTrack.onStart(PlayTimeTrack.SOURCEREADY_PREPARED);
        this.mPlayTimeTrack.putTimestamp("playerPrepareTs", System.currentTimeMillis());
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public void putString(String str, String str2) {
        this.mStringMap.put(str, String.valueOf(str2));
    }

    public boolean setParams(int i, Object obj) {
        return this.mVPM.setParams(i, obj);
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }
}
