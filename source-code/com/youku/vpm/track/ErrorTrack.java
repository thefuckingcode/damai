package com.youku.vpm.track;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.PlayerErrorMsg;
import com.youku.vpm.PlayerLoadingMsg;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.TLogUtil;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class ErrorTrack extends BaseTrack implements BaseTrack.OnExtrasBuildCallback {
    private static final String TAG = "ErrorTrack";
    private static int[] UPS_ERROR = {25001, 26001, 26003, 26004, 26006, 26007, 26008};
    private Context mContext;
    private boolean mIsSend;
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

    public static void flowLog(String str, String str2) {
        TLogUtil.loge("[KeyFlow][MiddleLayer][axp][" + str + jl1.ARRAY_END_STR, str2);
    }

    private double getDoubleValueForPlayErrInfo(String str) {
        return TrackUtil.getDoubleValue(str);
    }

    private String getNotEmptyString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    private String intToIP(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    @Override // com.youku.vpm.BaseTrack.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    public double getLoadingTotalTime() {
        if (this.playingLoadingStartTime <= 0) {
            return -1.0d;
        }
        double currentTimeMillis = (double) (System.currentTimeMillis() - this.playingLoadingStartTime);
        this.playingLoadingStartTime = 0;
        return currentTimeMillis;
    }

    public String getLoadingType() {
        return this.mLoadingType;
    }

    public String getQuitType() {
        return this.mQuitType;
    }

    public void onDataFail(int i) {
        if (!contains(i)) {
            i = 0;
        }
        onError(i);
    }

    public void onEndLoading() {
        this.mLoadingType = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0176  */
    public void onError(int i) {
        String str;
        PlayerErrorMsg playerErrorMsg2;
        String str2;
        if (!this.mIsSend) {
            this.mIsSend = true;
            boolean isRealVideoStarted = this.mTrack.isRealVideoStarted();
            String str3 = MonitorType.PLAYING;
            String str4 = isRealVideoStarted ? str3 : "beforePlay";
            IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
            IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
            String str5 = null;
            flowLog(vpmInfo.getString("sessionId", null), "[vpmCode]" + i);
            Table tableWithCreate = getTableWithCreate(isRealVideoStarted ? TableId.PLAYING : TableId.BEFORE_PLAY);
            Map<String, String> dimensions = tableWithCreate.getDimensions();
            dimensions.put("isSuccess", isRealVideoStarted ? "1" : "0");
            dimensions.put("videoErrorMsg", null);
            dimensions.put("videoErrorCode", String.valueOf(i));
            try {
                PlayerErrorMsg playerErrorMsg3 = this.playerErrorMsg;
                if (playerErrorMsg3 != null) {
                    str = intToIP(Integer.parseInt(playerErrorMsg3.IP));
                    dimensions.put("cdnIP", str);
                    dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
                    dimensions.put("quitType", getQuitType());
                    PlayerErrorMsg playerErrorMsg4 = this.playerErrorMsg;
                    String url = playerErrorMsg4 == null ? playerErrorMsg4.URL : this.mTrack.getUrl();
                    dimensions.put("URL", url);
                    dimensions.put("fileId", getNotEmptyString(PlayerLoadingMsg.getFileId(url)));
                    dimensions.put("IP", str);
                    playerErrorMsg2 = this.playerErrorMsg;
                    if (playerErrorMsg2 == null) {
                        str5 = getNotEmptyString(playerErrorMsg2.via);
                        str2 = getNotEmptyString(this.playerErrorMsg.connList);
                    } else {
                        str2 = null;
                    }
                    dimensions.put("via", str5);
                    dimensions.put("connList", str2);
                    dimensions.put("clientIP", getValueFromInfo(vpmFullInfo, "clientIP"));
                    dimensions.put("videoCode", this.mTrack.getVideoCodec());
                    this.mTrack.buildExtras(str4, dimensions, this);
                    Map<String, Double> measures = tableWithCreate.getMeasures();
                    measures.put("loading2backtime", Double.valueOf(getLoadingTotalTime()));
                    PlayerErrorMsg playerErrorMsg5 = this.playerErrorMsg;
                    measures.put("KTime", Double.valueOf(playerErrorMsg5 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg5.KTime) : 0.0d));
                    PlayerErrorMsg playerErrorMsg6 = this.playerErrorMsg;
                    measures.put("CDNTime", Double.valueOf(playerErrorMsg6 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg6.CDNTime) : 0.0d));
                    measures.put("speedX", Double.valueOf(vpmInfo.getDouble("speedX", 0.0d)));
                    measures.put("impairmentCount", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
                    measures.put("liveEnableAlixSourcer", Double.valueOf(Double.parseDouble(ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_alix_sourcer", "0"))));
                    VpmProxy.commitPlayErrInfoStatistics(dimensions, measures, Boolean.valueOf(isRealVideoStarted));
                    Context context = this.mContext;
                    if (!isRealVideoStarted) {
                        str3 = "beforePlay";
                    }
                    TrackUtil.printlog(context, TAG, str3, dimensions, measures);
                    TLogUtil.vpmLog("ErrorTrack:baseInfo:" + dimensions.toString());
                    TLogUtil.vpmLog("ErrorTrack:statisticsInfo:" + measures.toString());
                    this.mTrack.onMonitorPoint(str4, dimensions, measures);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            str = null;
            dimensions.put("cdnIP", str);
            dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
            dimensions.put("quitType", getQuitType());
            PlayerErrorMsg playerErrorMsg42 = this.playerErrorMsg;
            if (playerErrorMsg42 == null) {
            }
            dimensions.put("URL", url);
            dimensions.put("fileId", getNotEmptyString(PlayerLoadingMsg.getFileId(url)));
            dimensions.put("IP", str);
            playerErrorMsg2 = this.playerErrorMsg;
            if (playerErrorMsg2 == null) {
            }
            dimensions.put("via", str5);
            dimensions.put("connList", str2);
            dimensions.put("clientIP", getValueFromInfo(vpmFullInfo, "clientIP"));
            dimensions.put("videoCode", this.mTrack.getVideoCodec());
            this.mTrack.buildExtras(str4, dimensions, this);
            Map<String, Double> measures2 = tableWithCreate.getMeasures();
            measures2.put("loading2backtime", Double.valueOf(getLoadingTotalTime()));
            PlayerErrorMsg playerErrorMsg52 = this.playerErrorMsg;
            measures2.put("KTime", Double.valueOf(playerErrorMsg52 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg52.KTime) : 0.0d));
            PlayerErrorMsg playerErrorMsg62 = this.playerErrorMsg;
            measures2.put("CDNTime", Double.valueOf(playerErrorMsg62 == null ? getDoubleValueForPlayErrInfo(playerErrorMsg62.CDNTime) : 0.0d));
            measures2.put("speedX", Double.valueOf(vpmInfo.getDouble("speedX", 0.0d)));
            measures2.put("impairmentCount", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
            measures2.put("liveEnableAlixSourcer", Double.valueOf(Double.parseDouble(ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_alix_sourcer", "0"))));
            VpmProxy.commitPlayErrInfoStatistics(dimensions, measures2, Boolean.valueOf(isRealVideoStarted));
            Context context2 = this.mContext;
            if (!isRealVideoStarted) {
            }
            TrackUtil.printlog(context2, TAG, str3, dimensions, measures2);
            TLogUtil.vpmLog("ErrorTrack:baseInfo:" + dimensions.toString());
            TLogUtil.vpmLog("ErrorTrack:statisticsInfo:" + measures2.toString());
            this.mTrack.onMonitorPoint(str4, dimensions, measures2);
        }
    }

    public void onRealVideoStart() {
        this.mLoadingType = null;
    }

    public void onStartLoading(String str) {
        this.mLoadingType = str;
        this.playingLoadingStartTime = System.currentTimeMillis();
    }

    public void setPlayerErrorMsg(Object obj) {
        this.playerErrorMsg = PlayerErrorMsg.creat(String.valueOf(obj));
    }

    public void setQuitType(String str) {
        this.mQuitType = str;
    }
}
