package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class PayScene {
    @JSONField(name = "jump_address")
    public String jump_address;
    @JSONField(name = "scenes")
    public Scene[] scenes;
}
