package com.youku.alixplayer.opensdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.alixplayer.opensdk.utils.PlayCode;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.Map;

/* compiled from: Taobao */
public class ErrorTrack extends BaseTrack implements Track.OnExtrasBuildCallback {
    private static final String TAG = "ErrorTrack";
    private static int[] UPS_ERROR = {25001, 26001, 26003, 26004, 26006, 26007, 26008};
    private Context mContext;
    private String mLoadingType;
    private String mQuitType;
    public PlayerErrorMsg playerErrorMsg;
    private long playingLoadingStartTime = 0;

    public ErrorTrack(Track track) {
        super(track);
        this.mContext = track.getContext();
    }

    private boolean contains(int i) {
        for (int i2 : UPS_ERROR) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private double getDoubleValueForPlayErrInfo(String str) {
        return TrackUtil.getDoubleValueForPlayErrInfo(str);
    }

    private String getNotEmptyString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.Track.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    public double getLoadingTotalTime() {
        if (this.playingLoadingStartTime <= 0) {
            return -1.0d;
        }
        double nanoTime = (double) ((System.nanoTime() / 1000000) - this.playingLoadingStartTime);
        this.playingLoadingStartTime = 0;
        return nanoTime;
    }

    public String getLoadingType() {
        return this.mLoadingType;
    }

    public String getQuitType() {
        return this.mQuitType;
    }

    public void onEndLoading() {
        this.mLoadingType = null;
    }

    public void onError(String str) {
        String string = this.mTrack.getString("retryCount");
        String string2 = this.mTrack.getString("retryCode");
        if ((PlayCode.USER_LOADING_RETURN.equals(str) || PlayCode.RETURN_WHEN_BUFFERING.equals(str)) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            int intValue = Integer.valueOf(string2).intValue();
            onError(intValue, ErrorCodeUtil.getErrorMsg(intValue));
            return;
        }
        int intValue2 = Integer.valueOf(str).intValue();
        onError(intValue2, ErrorCodeUtil.getErrorMsg(intValue2));
    }

    public void onRealVideoStart() {
        this.mLoadingType = null;
    }

    public void onStartLoading(String str) {
        this.mLoadingType = str;
        this.playingLoadingStartTime = System.nanoTime() / 1000000;
    }

    public void setPlayerErrorMsg(Object obj) {
        this.playerErrorMsg = PlayerErrorMsg.creat(String.valueOf(obj));
    }

    public void setQuitType(String str) {
        this.mQuitType = str;
    }

    public void onError(int i) {
        onError(i, ErrorCodeUtil.getErrorMsg(i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0229  */
    public void onError(int i, String str) {
        String str2;
        PlayerErrorMsg playerErrorMsg2;
        String str3;
        String str4;
        boolean isRealVideoStarted = this.mTrack.isRealVideoStarted();
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        Table table = getTable(isRealVideoStarted ? MSGTABLEID.PLAYING : MSGTABLEID.BEFORE_PLAY);
        Map<String, String> dimensions = table.getDimensions();
        String str5 = "1";
        dimensions.put("isSuccess", isRealVideoStarted ? str5 : "0");
        dimensions.put("videoErrorMsg", str);
        dimensions.put("videoErrorCode", String.valueOf(i));
        try {
            PlayerErrorMsg playerErrorMsg3 = this.playerErrorMsg;
            if (playerErrorMsg3 != null) {
                str2 = PlayerUtil.intToIP(Integer.parseInt(playerErrorMsg3.IP));
                dimensions.put("cdnIP", str2);
                dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
                dimensions.put("quitType", getQuitType());
                dimensions.put(TableField.FILE_FORMAT, this.mTrack.getOnePlayTrack().getFileFormat(youkuVideoInfo));
                dimensions.put(ExtrasInfo.EXTRAS, this.mTrack.getExtras(youkuVideoInfo).toString());
                dimensions.put("userId", this.mTrack.getUserId());
                PlayerErrorMsg playerErrorMsg4 = this.playerErrorMsg;
                String url = playerErrorMsg4 == null ? playerErrorMsg4.URL : this.mTrack.getOnePlayTrack().getUrl(youkuVideoInfo);
                dimensions.put("URL", url);
                dimensions.put("fileId", getNotEmptyString(PlayerLoadingMsg.getFileId(url)));
                dimensions.put("IP", str2);
                playerErrorMsg2 = this.playerErrorMsg;
                if (playerErrorMsg2 == null) {
                    str4 = getNotEmptyString(playerErrorMsg2.via);
                    str3 = getNotEmptyString(this.playerErrorMsg.connList);
                } else {
                    str4 = null;
                    str3 = null;
                }
                dimensions.put("via", str4);
                dimensions.put("connList", str3);
                dimensions.put("clientIP", null);
                if (!(youkuVideoInfo == null || youkuVideoInfo.getUpsVideoInfo() == null || youkuVideoInfo.getUpsVideoInfo().getUps() == null || youkuVideoInfo.getUpsVideoInfo().getUps().ups_client_netip == null)) {
                    dimensions.put("clientIP", youkuVideoInfo.getUpsVideoInfo().getUps().ups_client_netip);
                }
                if (!PlayerUtil.hasInternet(this.mContext)) {
                    dimensions.put("brokenLink", "0");
                } else {
                    dimensions.put("brokenLink", str5);
                }
                dimensions.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
                dimensions.put("videoCode", this.mTrack.getVideoCodec());
                dimensions.put("videoErrorCode", String.valueOf(i));
                dimensions.put("sourceIdentity", "优酷");
                dimensions.put("netStatus", StaticsUtil.getNetStatus());
                if (!this.mTrack.isVip()) {
                    str5 = "0";
                }
                dimensions.put(TableField.IS_VIP, str5);
                this.mTrack.buildExtras(dimensions, playVideoInfo, youkuVideoInfo, this);
                Map<String, Double> measures = table.getMeasures();
                measures.put("loading2backtime", Double.valueOf(getLoadingTotalTime()));
                PlayerErrorMsg playerErrorMsg5 = this.playerErrorMsg;
                measures.put("KTime", Double.valueOf(playerErrorMsg5 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg5.KTime) : 0.0d));
                PlayerErrorMsg playerErrorMsg6 = this.playerErrorMsg;
                measures.put("CDNTime", Double.valueOf(playerErrorMsg6 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg6.CDNTime) : 0.0d));
                measures.put("speedX", Double.valueOf(playVideoInfo.getDouble("speedX", 0.0d)));
                measures.put("impairmentCount", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
                measures.put("liveEnableAlixSourcer", Double.valueOf(Double.parseDouble(ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_alix_sourcer", "0"))));
                VpmProxy.commitPlayErrInfoStatistics(dimensions, measures, Boolean.valueOf(isRealVideoStarted));
                String str6 = MonitorType.PLAYING;
                TrackUtil.printlog(TAG, !isRealVideoStarted ? str6 : "beforePlay", dimensions, measures);
                TLogUtil.vpmLog("ErrorTrack:baseInfo:" + dimensions.toString());
                TLogUtil.vpmLog("ErrorTrack:statisticsInfo:" + measures.toString());
                if (!isRealVideoStarted) {
                    str6 = "beforePlay";
                }
                this.mTrack.onMonitorPoint(str6, dimensions, measures);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        str2 = null;
        dimensions.put("cdnIP", str2);
        dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
        dimensions.put("quitType", getQuitType());
        dimensions.put(TableField.FILE_FORMAT, this.mTrack.getOnePlayTrack().getFileFormat(youkuVideoInfo));
        dimensions.put(ExtrasInfo.EXTRAS, this.mTrack.getExtras(youkuVideoInfo).toString());
        dimensions.put("userId", this.mTrack.getUserId());
        PlayerErrorMsg playerErrorMsg42 = this.playerErrorMsg;
        if (playerErrorMsg42 == null) {
        }
        dimensions.put("URL", url);
        dimensions.put("fileId", getNotEmptyString(PlayerLoadingMsg.getFileId(url)));
        dimensions.put("IP", str2);
        playerErrorMsg2 = this.playerErrorMsg;
        if (playerErrorMsg2 == null) {
        }
        dimensions.put("via", str4);
        dimensions.put("connList", str3);
        try {
            dimensions.put("clientIP", null);
            dimensions.put("clientIP", youkuVideoInfo.getUpsVideoInfo().getUps().ups_client_netip);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!PlayerUtil.hasInternet(this.mContext)) {
        }
        dimensions.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
        dimensions.put("videoCode", this.mTrack.getVideoCodec());
        dimensions.put("videoErrorCode", String.valueOf(i));
        dimensions.put("sourceIdentity", "优酷");
        dimensions.put("netStatus", StaticsUtil.getNetStatus());
        if (!this.mTrack.isVip()) {
        }
        dimensions.put(TableField.IS_VIP, str5);
        this.mTrack.buildExtras(dimensions, playVideoInfo, youkuVideoInfo, this);
        Map<String, Double> measures2 = table.getMeasures();
        measures2.put("loading2backtime", Double.valueOf(getLoadingTotalTime()));
        PlayerErrorMsg playerErrorMsg52 = this.playerErrorMsg;
        measures2.put("KTime", Double.valueOf(playerErrorMsg52 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg52.KTime) : 0.0d));
        PlayerErrorMsg playerErrorMsg62 = this.playerErrorMsg;
        measures2.put("CDNTime", Double.valueOf(playerErrorMsg62 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg62.CDNTime) : 0.0d));
        measures2.put("speedX", Double.valueOf(playVideoInfo.getDouble("speedX", 0.0d)));
        measures2.put("impairmentCount", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
        measures2.put("liveEnableAlixSourcer", Double.valueOf(Double.parseDouble(ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_alix_sourcer", "0"))));
        VpmProxy.commitPlayErrInfoStatistics(dimensions, measures2, Boolean.valueOf(isRealVideoStarted));
        String str62 = MonitorType.PLAYING;
        TrackUtil.printlog(TAG, !isRealVideoStarted ? str62 : "beforePlay", dimensions, measures2);
        TLogUtil.vpmLog("ErrorTrack:baseInfo:" + dimensions.toString());
        TLogUtil.vpmLog("ErrorTrack:statisticsInfo:" + measures2.toString());
        if (!isRealVideoStarted) {
        }
        this.mTrack.onMonitorPoint(str62, dimensions, measures2);
    }

    public void onError(VideoRequestError videoRequestError) {
        int httpStatus = videoRequestError.getHttpStatus();
        int errorCode = videoRequestError.getErrorCode();
        String errorMsg = videoRequestError.getErrorMsg();
        if (httpStatus == 200 && !contains(errorCode)) {
            errorCode = 0;
        }
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = ErrorCodeUtil.getErrorMsg(errorCode);
        }
        onError(errorCode, errorMsg);
    }
}
