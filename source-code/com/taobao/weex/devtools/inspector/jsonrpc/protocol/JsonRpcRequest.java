package com.taobao.weex.devtools.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
/* compiled from: Taobao */
public class JsonRpcRequest {
    @JsonProperty
    public Long id;
    @JsonProperty(required = true)
    public String method;
    @JsonProperty
    public JSONObject params;

    public JsonRpcRequest() {
    }

    public JsonRpcRequest(Long l, String str, JSONObject jSONObject) {
        this.id = l;
        this.method = str;
        this.params = jSONObject;
    }
}
