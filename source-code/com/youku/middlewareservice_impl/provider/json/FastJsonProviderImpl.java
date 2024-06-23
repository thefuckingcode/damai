package com.youku.middlewareservice_impl.provider.json;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.middlewareservice.provider.json.FastJsonProvider;

@Keep
/* compiled from: Taobao */
public class FastJsonProviderImpl extends JsonProviderImpl implements FastJsonProvider {
    @Override // com.youku.middlewareservice.provider.json.FastJsonProvider
    public JSONObject parseObject(String str) {
        return JSON.parseObject(str);
    }
}
