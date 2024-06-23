package com.taobao.weex.devtools.inspector.protocol.module;

import android.annotation.SuppressLint;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.taobao.weex.devtools.inspector.console.ConsolePeerManager;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import com.taobao.weex.devtools.json.annotation.JsonValue;
import com.youku.resource.widget.YKActionSheet;
import org.json.JSONObject;

/* compiled from: Taobao */
public class Console implements ChromeDevtoolsDomain {

    @SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
    /* compiled from: Taobao */
    public static class CallFrame {
        @JsonProperty(required = true)
        public int columnNumber;
        @JsonProperty(required = true)
        public String functionName;
        @JsonProperty(required = true)
        public int lineNumber;
        @JsonProperty(required = true)
        public String url;

        public CallFrame() {
        }

        public CallFrame(String str, String str2, int i, int i2) {
            this.functionName = str;
            this.url = str2;
            this.lineNumber = i;
            this.columnNumber = i2;
        }
    }

    @SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
    /* compiled from: Taobao */
    public static class ConsoleMessage {
        @JsonProperty(required = true)
        public MessageLevel level;
        @JsonProperty(required = true)
        public MessageSource source;
        @JsonProperty(required = true)
        public String text;
    }

    @SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
    /* compiled from: Taobao */
    public static class MessageAddedRequest {
        @JsonProperty(required = true)
        public ConsoleMessage message;
    }

    /* compiled from: Taobao */
    public enum MessageLevel {
        LOG(DumpManager.LOG_PATH),
        WARNING(YKActionSheet.ACTION_STYLE_WARNING),
        ERROR("error"),
        DEBUG("debug");
        
        private final String mProtocolValue;

        private MessageLevel(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    /* compiled from: Taobao */
    public enum MessageSource {
        XML("xml"),
        JAVASCRIPT("javascript"),
        NETWORK("network"),
        CONSOLE_API("console-api"),
        STORAGE("storage"),
        APPCACHE("appcache"),
        RENDERING("rendering"),
        CSS("css"),
        SECURITY("security"),
        OTHER("other");
        
        private final String mProtocolValue;

        private MessageSource(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ConsolePeerManager.getOrCreateInstance().removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ConsolePeerManager.getOrCreateInstance().addPeer(jsonRpcPeer);
    }
}
