package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class AdPlayTrack {
    public static final String TAG = "AdPlay";
    private Track mTrack;

    public AdPlayTrack(Track track) {
        this.mTrack = track;
    }

    public void commit(int i, int i2) {
        Map<String, String> map;
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        Reporter reporter = this.mTrack.getReporter();
        if (reporter == null) {
            map = this.mTrack.mVPM.getTable(MSGTABLEID.AD_PLAY).getDimensions();
        } else {
            map = reporter.getAllDims(Reporter.MonitorTableName.AD_PLAY);
            if (map == null) {
                map = new HashMap<>();
            }
        }
        map.put("vvId", this.mTrack.getVVId());
        map.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        map.put(TableField.PS_ID, TrackUtil.getPsId(youkuVideoInfo));
        map.put(TableField.MEDIA_TYPE, playVideoInfo.getPlayType().getValue() + "");
        map.put(TableField.PLAY_WAY, TrackUtil.getPlayWay(this.mTrack, youkuVideoInfo));
        map.put("adType", String.valueOf(i));
        map.put("videoVid", youkuVideoInfo.getVid());
        map.put("videoShowId", youkuVideoInfo.getShowId());
        map.put("videoFileformat", this.mTrack.getOnePlayTrack().getFileFormat(youkuVideoInfo));
        Map<String, Double> hashMap = new HashMap<>();
        if (reporter == null) {
            hashMap = this.mTrack.mVPM.getTable(MSGTABLEID.AD_PLAY).getMeasures();
        } else {
            Map<String, String> allValues = reporter.getAllValues(Reporter.MonitorTableName.AD_PLAY);
            if (allValues != null && allValues.size() > 0) {
                try {
                    for (Map.Entry<String, String> entry : allValues.entrySet()) {
                        hashMap.put(entry.getKey(), Double.valueOf(Double.parseDouble(entry.getValue())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        map.put("adVid", playVideoInfo.getString("pre_adid_" + i2));
        map.put("adFileformat", TrackUtil.getFileFormatByUrl(map.get("adUrl")));
        if (!this.mTrack.getPlayerConfig().isExternal()) {
            VpmProxy.commitAdPlayStatistics(map, hashMap);
            TrackUtil.printlog("AdPlay", "AdPlay", map, hashMap);
        }
    }
}
