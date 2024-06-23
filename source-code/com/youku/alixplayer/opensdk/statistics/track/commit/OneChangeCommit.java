package com.youku.alixplayer.opensdk.statistics.track.commit;

import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.BaseTrack;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.vpm.data.ExtrasInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class OneChangeCommit extends BaseTrack implements Track.OnExtrasBuildCallback {
    public static final String TAG = "OneChange";
    public long changeStartTime;
    public String changeStateAfter;
    public String changeStateBefore;
    public double changeTotalTimeFromPlayer;
    public double currentPosition;
    public String isAuto;
    public String isSuccess;
    private int mQualityMode;
    public double playTime;
    public double timeConsume;

    public OneChangeCommit(Track track) {
        super(track);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.Track.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
        str.hashCode();
    }

    public void commitOneChangeStatistics(MSGTABLEID msgtableid, String str, String str2, Track track, YoukuVideoInfo youkuVideoInfo) {
        Map<String, String> map;
        Map<String, String> map2;
        if (youkuVideoInfo == null) {
            TLogUtil.playLog("video is null on onechange");
            return;
        }
        Reporter reporter = this.mTrack.getReporter();
        if (reporter == null) {
            map = track.mVPM.getTable(msgtableid).getDimensions();
        } else {
            if (msgtableid == MSGTABLEID.ONECHANGE_SEEK) {
                map = reporter.getAllDims(Reporter.MonitorTableName.ONE_CHANGE_SEEK);
            } else {
                map = reporter.getAllDims(Reporter.MonitorTableName.ONE_CHANGE_QUALITY);
            }
            if (map == null) {
                map = new HashMap<>();
            }
        }
        addBaseDimensions(map);
        map.put("VPMIndex", String.valueOf(track.getVPMIndex()));
        map.put("changeStateBefore", this.changeStateBefore);
        map.put("changeStateAfter", this.changeStateAfter);
        map.put("changeType", str);
        map.put("isSuccess", this.isSuccess);
        map.put("isAuto", this.isAuto);
        map.put("qualityMode", this.mQualityMode + "");
        track.getExtras(youkuVideoInfo);
        if (track.getExtras(youkuVideoInfo) != null) {
            map.put(ExtrasInfo.EXTRAS, track.getExtras(youkuVideoInfo).toString());
        }
        track.buildExtras(map, youkuVideoInfo.getPlayVideoInfo(), youkuVideoInfo, this);
        Map<String, Double> hashMap = new HashMap<>();
        if (reporter == null) {
            hashMap = track.mVPM.getTable(msgtableid).getMeasures();
        } else {
            if (msgtableid == MSGTABLEID.ONECHANGE_SEEK) {
                map2 = reporter.getAllValues(Reporter.MonitorTableName.ONE_CHANGE_SEEK);
            } else {
                map2 = reporter.getAllValues(Reporter.MonitorTableName.ONE_CHANGE_QUALITY);
            }
            try {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    hashMap.put(entry.getKey(), Double.valueOf(Double.parseDouble(entry.getValue())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        hashMap.put("timeConsume", Double.valueOf(this.timeConsume));
        hashMap.put("changeTotalTimeFromPlayer", Double.valueOf(this.changeTotalTimeFromPlayer));
        hashMap.put("videoPlayDuration", Double.valueOf((double) youkuVideoInfo.getDuration()));
        hashMap.put("PlayTime", Double.valueOf(this.playTime));
        hashMap.put("currentPosition", Double.valueOf(this.currentPosition));
        if (!this.mTrack.getPlayerConfig().isExternal()) {
            VpmProxy.commitOneChangeStatistics(map, hashMap);
            TLogUtil.vpmLog("OneChange:baseInfo:" + map.toString());
            TLogUtil.vpmLog("OneChange:statisticsInfo:" + hashMap.toString());
            TrackUtil.printlog("OneChange-" + str2, str2, map, hashMap);
        }
    }

    public OneChangeCommit setQualityMode(int i) {
        this.mQualityMode = i;
        return this;
    }
}
