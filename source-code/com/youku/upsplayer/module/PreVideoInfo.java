package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import tb.lf1;

/* compiled from: Taobao */
public class PreVideoInfo {
    @JSONField(name = "metaId")
    public String metaId;
    @JSONField(name = "scm")
    public String scm;
    @JSONField(name = lf1.RESOURCE_STREAM)
    public PreVideoStream[] stream;
    @JSONField(name = "text")
    public PreVideoText text;
    @JSONField(name = "trackInfo")
    public String trackInfo;
}
