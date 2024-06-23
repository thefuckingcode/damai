package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.BaseTrack;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.monitor.PlayAbnormalSummary;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import java.util.Map;

/* compiled from: Taobao */
public class PlayAbnormalSummaryTrack extends BaseTrack {
    public static final String TAG = "PlayAbnormalSummary";
    private boolean mHasData;
    private Table mTable = new PlayAbnormalSummary();

    public PlayAbnormalSummaryTrack(Track track) {
        super(track);
    }

    public void commit(YoukuVideoInfo youkuVideoInfo) {
        Map<String, String> dimensions = this.mTable.getDimensions();
        addBaseDimensions(dimensions);
        Map<String, Double> measures = this.mTable.getMeasures();
        addBaseMeasures(measures);
        if (!this.mTrack.getPlayerConfig().isExternal()) {
            VpmProxy.commitPlayAbnormalSummary(dimensions, measures);
            TrackUtil.printlog("PlayAbnormalSummary", "PlayAbnormalSummary", dimensions, measures);
        }
    }

    public void getPlayerInfoForVVEnd(String str) {
        if (!this.mHasData) {
            this.mTable.putString(str);
            this.mHasData = true;
        }
    }
}
