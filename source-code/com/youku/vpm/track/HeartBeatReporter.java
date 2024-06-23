package com.youku.vpm.track;

import com.youku.vpm.BaseTrack;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class HeartBeatReporter extends BaseTrack {
    public static final String TAG = "HeartBeatReporter";
    private long lastReportTime;
    private double mIndex;
    private int mLastPositionSecond;
    private double mPlayTime;
    private long reportInterval = DateUtils.MILLIS_PER_MINUTE;

    public HeartBeatReporter(Track track) {
        super(track);
    }

    private void sendHeartBeat() {
        boolean equals = "1.".equals(this.mTrack.getPlayerTrack().getDynamicProperty(TableField.IS_VIP));
        String str = "1";
        boolean equals2 = str.equals(this.mTrack.getPlayerTrack().getDynamicProperty("isLogin"));
        Table tableWithCreate = getTableWithCreate(TableId.PLAYHEARTBEAT);
        Map<String, String> dimensions = tableWithCreate.getDimensions();
        if (!this.mTrack.isRealVideoStarted()) {
            str = "0";
        }
        dimensions.put("isPlayer", str);
        dimensions.put("memberType", equals ? "vip" : "n/a");
        dimensions.put("isLogin", equals2 + "");
        dimensions.put("format", this.mTrack.getFileFormat());
        dimensions.put("index", String.valueOf(this.mIndex));
        dimensions.put("OrangeSession", this.mTrack.getApsVersion());
        this.mTrack.buildExtras(dimensions);
        Map<String, Double> measures = tableWithCreate.getMeasures();
        measures.put("currentPlayDuraion", Double.valueOf(this.mPlayTime));
        this.mIndex += 1.0d;
        if (!this.mTrack.isExternal()) {
            TrackUtil.printlog(this.mTrack.getContext(), "HeartBeatReporter", "", dimensions, measures);
            VpmProxy.commitHeartBeatStatistics(dimensions, measures);
        }
        this.mTrack.onMonitorPoint("playHeartbeat", dimensions, measures);
    }

    public void OnCurrentPositionChangeListener(int i) {
        if (System.currentTimeMillis() - this.lastReportTime >= this.reportInterval) {
            this.lastReportTime = System.currentTimeMillis();
            sendHeartBeat();
        }
        int i2 = i / 1000;
        if (this.mLastPositionSecond != i2) {
            this.mLastPositionSecond = i2;
            this.mPlayTime += 1.0d;
        }
    }
}
