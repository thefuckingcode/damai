package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
public class Scene {
    @JSONField(name = Constants.COMPONENT)
    public Component[] components;
    @JSONField(name = "scene")
    public String scene;
}
