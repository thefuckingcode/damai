package com.taobao.weex.devtools.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import javax.annotation.Nullable;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
/* compiled from: Taobao */
public class JsonRpcEvent {
    @JsonProperty(required = true)
    public String method;
    @JsonProperty
    public JSONObject params;

    public JsonRpcEvent() {
    }

    public JsonRpcEvent(String str, @Nullable JSONObject jSONObject) {
        this.method = str;
        this.params = jSONObject;
    }
}
