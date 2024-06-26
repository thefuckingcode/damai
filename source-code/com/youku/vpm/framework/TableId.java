package com.youku.vpm.framework;

import com.alimm.xadsdk.base.expose.MonitorType;

/* compiled from: Taobao */
public enum TableId {
    ONEPLAY("onePlay"),
    IMPAIRMENT("impairment"),
    BEFORE_PLAY("beforePlay"),
    PLAYING(MonitorType.PLAYING),
    ONECHANGE_SEEK("oneChange"),
    ONECHANGE_QUALITY("oneChange"),
    PLAYHEARTBEAT,
    ONEEVENT,
    AD_PLAY("adPlay"),
    AD_ERROR("adError"),
    AD_IMPAIRMENT("AdImpairment"),
    START_LOADING,
    SUBTITLE_EVENT(null),
    PLAY_ABNORMAL_DETAIL(null),
    PLAY_ABNORMAL_SUMMARY(null);
    
    private String monitor;

    private TableId() {
        this.monitor = null;
    }

    private TableId(String str) {
        this.monitor = str;
    }
}
