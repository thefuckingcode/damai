package com.alibaba.aliweex.adapter;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public interface ICallback {
    void failure(JSONObject jSONObject);

    void success(JSONObject jSONObject);
}
