package com.youku.vpm.track.ad;

import com.youku.vpm.IPlayer;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TrackUtil;
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
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        IPlayer player = this.mTrack.getPlayer();
        if (player == null) {
            map = this.mTrack.mTableBuilder.getTable(TableId.AD_PLAY).getDimensions();
        } else {
            map = player.getAllDims(TableId.AD_PLAY);
            if (map == null) {
                map = new HashMap<>();
            }
        }
        map.put("vvId", this.mTrack.getVVId());
        map.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        map.put(TableField.PS_ID, vpmFullInfo.getString(TableField.PS_ID, null));
        map.put(TableField.MEDIA_TYPE, vpmInfo.getString(TableField.MEDIA_TYPE, "0"));
        map.put(TableField.PLAY_WAY, vpmFullInfo.getString(TableField.PLAY_WAY, null));
        map.put("adType", String.valueOf(i));
        map.put("videoVid", vpmFullInfo.getString("vId", null));
        map.put("videoShowId", vpmFullInfo.getString("showId", null));
        map.put("videoFileformat", this.mTrack.getString(TableField.FILE_FORMAT));
        Map<String, Double> hashMap = new HashMap<>();
        if (player == null) {
            hashMap = this.mTrack.mTableBuilder.getTable(TableId.AD_PLAY).getMeasures();
        } else {
            Map<String, String> allValues = player.getAllValues(TableId.AD_PLAY);
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
        map.put("adVid", vpmInfo.getString("pre_adid_" + i2, null));
        map.put("adFileformat", TrackUtil.getFileFormatByUrl(map.get("adUrl")));
        if (!this.mTrack.isExternal()) {
            VpmProxy.commitAdPlayStatistics(map, hashMap);
            TrackUtil.printlog(this.mTrack.getContext(), "AdPlay", "AdPlay", map, hashMap);
        }
    }
}
