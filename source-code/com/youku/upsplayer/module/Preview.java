package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class Preview {
    @JSONField(name = "thumb")
    public String[] thumb;
    @JSONField(name = "thumb_hd")
    public String[] thumb_hd;
    @JSONField(name = "timespan")
    public String timespan;
}
