package com.youku.upsplayer.module;

import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class AdDomain {
    @JSONField(name = IWXConnection.TYPE_CELLULAR)
    public String cellularDomain;
    @JSONField(name = "wifi")
    public String wifiDomain;
}
