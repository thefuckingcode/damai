package com.youku.arch.beast.hostschedule;

import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class DomainCell {
    @JSONField(name = IWXConnection.TYPE_CELLULAR)
    public String cellular;
    @JSONField(name = "wifi")
    public String wifi;
}
