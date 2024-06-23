package com.taobao.weex.devtools.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
/* compiled from: Taobao */
public class JsonRpcResponse {
    @JsonProperty
    public JSONObject error;
    @JsonProperty(required = true)
    public long id;
    @JsonProperty
    public JSONObject result;
}
