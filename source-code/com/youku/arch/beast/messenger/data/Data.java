package com.youku.arch.beast.messenger.data;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class Data {
    @JSONField(name = "content")
    public Content content = new Content();
    @JSONField(name = "msgType")
    public int msgType = 2;
}
