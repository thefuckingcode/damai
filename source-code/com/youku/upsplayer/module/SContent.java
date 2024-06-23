package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class SContent {
    @JSONField(name = "content_type")
    public String content_type;
    @JSONField(name = "data_ext")
    public DataExt data_ext;
    @JSONField(name = "data_url")
    public String data_url;
    @JSONField(name = "scene")
    public String scene;
    @JSONField(name = "show_content")
    public Boolean show_content;
}
