package com.alibaba.aliweex.adapter;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
public interface IAliPayModuleAdapter {
    void tradePay(WXSDKInstance wXSDKInstance, JSONObject jSONObject, ICallback iCallback);
}
