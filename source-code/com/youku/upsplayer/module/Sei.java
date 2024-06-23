package com.youku.upsplayer.module;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class Sei {
    @JSONField(name = "client_config")
    public String config;
    @JSONField(name = "lang")
    public String lang;
    @JSONField(name = "position")
    public Position position;
    @JSONField(name = "encodeVid")
    public String vid;

    /* compiled from: Taobao */
    public static final class Position {
        @JSONField(name = "textBot")
        public String textBot;
        @JSONField(name = "textLeft")
        public String textLeft;
    }

    public boolean isValid() {
        Position position2;
        return !TextUtils.isEmpty(this.lang) && (position2 = this.position) != null && !TextUtils.isEmpty(position2.textLeft) && !TextUtils.isEmpty(this.position.textBot);
    }
}
