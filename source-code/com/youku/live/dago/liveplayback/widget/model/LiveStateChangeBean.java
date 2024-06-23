package com.youku.live.dago.liveplayback.widget.model;

import java.io.Serializable;

/* compiled from: Taobao */
public class LiveStateChangeBean implements Serializable {
    public int dt;
    public Ext ext;
    public String params;
    public long sendTime;
    public int st;

    /* compiled from: Taobao */
    public static class Ext implements Serializable {
        public int isRecordOpen;
        public boolean landScape;
        public String videoUrl;
        public String videoUrlCode;
        public int videoUrlQuality;
    }
}
