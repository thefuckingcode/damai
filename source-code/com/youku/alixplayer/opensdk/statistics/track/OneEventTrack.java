package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.statistics.BaseTrack;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import java.util.Map;

/* compiled from: Taobao */
public class OneEventTrack extends BaseTrack {
    private static final String TAG = "OneEvent";
    private double mIpChangeSuccCnt;
    private double mIpChangeTotalCnt;

    public OneEventTrack(Track track) {
        super(track);
    }

    public void commitOneEventStatistics(String str) {
        Table table = this.mTrack.mVPM.getTable(MSGTABLEID.ONEEVENT);
        Map<String, String> dimensions = table.getDimensions();
        addBaseDimensions(dimensions);
        dimensions.put("eventType", str);
        Map<String, Double> measures = table.getMeasures();
        addBaseMeasures(measures);
        if (!this.mTrack.getPlayerConfig().isExternal()) {
            VpmProxy.commitOneEventStatistics(dimensions, measures);
            TrackUtil.printlog(TAG, str, dimensions, measures);
        }
        if ("1".equals(str)) {
            this.mIpChangeTotalCnt += 1.0d;
            if (measures.get("isSuccess").doubleValue() == 1.0d) {
                this.mIpChangeSuccCnt += 1.0d;
            }
        }
    }

    public double getIpChangeSuccCnt() {
        return this.mIpChangeSuccCnt;
    }

    public double getIpChangeTotalCnt() {
        return this.mIpChangeTotalCnt;
    }
}
