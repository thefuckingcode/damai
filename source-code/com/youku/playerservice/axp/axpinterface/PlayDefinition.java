package com.youku.playerservice.axp.axpinterface;

import android.text.TextUtils;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;

/* compiled from: Taobao */
public class PlayDefinition {

    /* compiled from: Taobao */
    public enum NetworkType {
        HTTP,
        MTOP
    }

    /* compiled from: Taobao */
    public enum PlayEnvironment {
        ONLINE(0),
        PRE(1),
        DAILY(2);
        
        int type;

        private PlayEnvironment(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    public enum PlayFormat {
        UNKNOWN("-1"),
        MP4("0"),
        HLS("1", LiveManager.StreamConfig.FORMAT_HLS),
        DASH("2"),
        FLV("3", LiveManager.StreamConfig.FORMAT_FLV),
        MP5("4"),
        M5V("5"),
        RTP("6", "rtp"),
        ARTP("7", "artp"),
        LHLS("8", "lhls"),
        GRTN("9", "grtn"),
        RTMP("11", "raphael");
        
        private String protocol;
        private String statistics;

        private PlayFormat(String str) {
            this.statistics = str;
        }

        private PlayFormat(String str, String str2) {
            this.statistics = str;
            this.protocol = str2;
        }

        public static PlayFormat getPlayFormatByProtocol(String str) {
            if ("sdp".equalsIgnoreCase(str)) {
                str = "rtp";
            } else if ("httpflv".equalsIgnoreCase(str)) {
                str = LiveManager.StreamConfig.FORMAT_FLV;
            }
            PlayFormat[] values = values();
            for (PlayFormat playFormat : values) {
                if (str != null && str.equalsIgnoreCase(playFormat.protocol)) {
                    return playFormat;
                }
            }
            return UNKNOWN;
        }

        public static PlayFormat getPlayFormatByStatistics(String str) {
            PlayFormat[] values = values();
            for (PlayFormat playFormat : values) {
                if (str != null && str.equalsIgnoreCase(playFormat.statistics)) {
                    return playFormat;
                }
            }
            return UNKNOWN;
        }

        public static PlayFormat getPlayFormatByUrl(String str) {
            return TextUtils.isEmpty(str) ? UNKNOWN : (str.contains(".mp4") || str.contains(".m5v")) ? MP4 : (str.contains(".m3u8") || str.contains(".ts")) ? HLS : str.contains(".flv") ? FLV : str.contains(".mp5") ? MP5 : str.contains("artp://") ? ARTP : str.contains("artc://") ? GRTN : UNKNOWN;
        }

        public boolean equals(String str) {
            return str != null && str.equalsIgnoreCase(this.protocol);
        }

        public String getStatistics() {
            return this.statistics;
        }
    }

    /* compiled from: Taobao */
    public enum PlayInfoType {
        UNKNOWN(0),
        UPS(1),
        LIVE(2),
        URL(3),
        LOCAL(4);
        
        int type;

        private PlayInfoType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    public enum PlayScene {
        UNKNOWN(0),
        SHORT_VIDEO(1),
        LONG_VIDEO(2),
        LIVE_LAIFENG(3),
        LIVE_YOUKU(4);
        
        int type;

        private PlayScene(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    public enum PlayType {
        VOD(0),
        LIVE(1),
        URL(2);
        
        int type;

        private PlayType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }
}
