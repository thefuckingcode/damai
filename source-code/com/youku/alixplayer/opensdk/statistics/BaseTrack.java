package com.youku.alixplayer.opensdk.statistics;

import android.text.TextUtils;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.vpm.constants.TableField;
import java.util.Map;

/* compiled from: Taobao */
public class BaseTrack {
    protected final Track mTrack;

    public BaseTrack(Track track) {
        this.mTrack = track;
    }

    public void addBaseDimensions(Map<String, String> map) {
        String str;
        String str2;
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        String str3 = null;
        if (playVideoInfo.getPlayType() == PlayType.VOD) {
            map.put("vid", youkuVideoInfo != null ? youkuVideoInfo.getVid() : playVideoInfo.getVid());
            map.put("showId", youkuVideoInfo != null ? youkuVideoInfo.getShowId() : null);
            map.put(TableField.VIDEO_FORMAT, TrackUtil.getVideoFormat(this.mTrack.getCurrentQuality(), null));
        } else {
            map.put("vid", youkuVideoInfo != null ? youkuVideoInfo.getScreenId() : null);
            map.put("showId", youkuVideoInfo != null ? youkuVideoInfo.getLiveId() : playVideoInfo.getLiveId());
            map.put(TableField.VIDEO_FORMAT, this.mTrack.getCurrentVideoItem() != null ? this.mTrack.getCurrentVideoItem().getName() : null);
        }
        map.put(TableField.MEDIA_TYPE, playVideoInfo.getPlayType().getValue() + "");
        map.put("playerCore", "alix");
        map.put("vvId", this.mTrack.getVVId());
        map.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        String str4 = "1";
        map.put(TableField.USE_MIN_SET, playVideoInfo.getFastData() != null ? str4 : "0");
        map.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
        map.put(TableField.PS_ID, youkuVideoInfo != null ? youkuVideoInfo.getPsid() : null);
        map.put(TableField.PLAY_WAY, "net");
        if (this.mTrack.getCurrentVideoItem() != null) {
            str = this.mTrack.getCurrentVideoItem().getStreamType() + "";
        } else {
            str = null;
        }
        map.put(TableField.STREAM_TYPE, str);
        if (getTrack().isVip()) {
            str2 = str4;
        } else {
            str2 = "0";
        }
        map.put(TableField.IS_VIP, str2);
        if (!TrackUtil.isAuto(playVideoInfo)) {
            str4 = "0";
        }
        map.put("isAuto", str4);
        map.put(TableField.DRM_TYPE, TrackUtil.getDrmType(this.mTrack));
        map.put("isRtmpe", TrackUtil.getDrmType(this.mTrack));
        map.put(TableField.DOLBY_TYPE, youkuVideoInfo != null ? youkuVideoInfo.getDolbyStreamType() : null);
        map.put("deviceChip", TrackUtil.getCpuName(getTrack().getContext()));
        if (youkuVideoInfo != null) {
            str3 = youkuVideoInfo.getVideoType();
        }
        map.put(TableField.VIDEO_TYPE, str3);
    }

    public void addBaseMeasures(Map<String, Double> map) {
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        map.put("videoPlayDuration", Double.valueOf(youkuVideoInfo != null ? (double) youkuVideoInfo.getDuration() : 0.0d));
        map.put("feedType", Double.valueOf(playVideoInfo.getDouble("feedMode", 0.0d)));
    }

    public Table getTable(MSGTABLEID msgtableid) {
        Table table = this.mTrack.getTable(msgtableid);
        Reporter reporter = msgtableid.getMonitorTableName() != null ? this.mTrack.getReporter() : null;
        Map<String, String> dimensions = table.getDimensions();
        addBaseDimensions(dimensions);
        if (reporter != null) {
            for (Map.Entry<String, String> entry : reporter.getAllDims(msgtableid.getMonitorTableName()).entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!isEmpty(key) && !isEmpty(value)) {
                    dimensions.put(key, value);
                }
            }
        }
        Map<String, Double> measures = table.getMeasures();
        addBaseMeasures(measures);
        if (reporter != null) {
            for (Map.Entry<String, String> entry2 : reporter.getAllValues(msgtableid.getMonitorTableName()).entrySet()) {
                String key2 = entry2.getKey();
                String value2 = entry2.getValue();
                if (!isEmpty(key2) && !isEmpty(value2)) {
                    try {
                        measures.put(key2, Double.valueOf(value2));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return table;
    }

    public Track getTrack() {
        return this.mTrack;
    }

    /* access modifiers changed from: protected */
    public boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || "-1".equals(str);
    }
}
