package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class Action {
    @JSONField(name = "mode")
    public int mode;
    @JSONField(name = "pageKey")
    public String pageKey;
    @JSONField(name = "params")
    public Param params;
    @JSONField(name = "type")
    public String type;
}
