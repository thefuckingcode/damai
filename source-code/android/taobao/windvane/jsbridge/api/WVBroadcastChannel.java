package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weaver.broadcast.MessageCallback;
import com.taobao.weaver.broadcast.MessageChannel;
import com.taobao.weex.ui.component.WXWeb;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WVBroadcastChannel extends WVApiPlugin {
    private static final String CHANNEL_INSTANCE_ID = "instanceId";
    private static final String CHANNEL_KEY = "name";
    private static final String CHANNEL_MESSAGE = "message";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_RESULT = "result";
    private Map<String, MessageChannel> messageTokenChannels = new HashMap();

    private void onMessage(JSONObject jSONObject, final WVCallBackContext wVCallBackContext) {
        if (this.messageTokenChannels != null) {
            final String string = jSONObject.getString(CHANNEL_INSTANCE_ID);
            if (!TextUtils.isEmpty(string)) {
                MessageChannel messageChannel = this.messageTokenChannels.get(string);
                if (messageChannel != null) {
                    messageChannel.setCallback(new MessageCallback() {
                        /* class android.taobao.windvane.jsbridge.api.WVBroadcastChannel.AnonymousClass1 */

                        public void onMessage(Object obj) {
                            WVCallBackContext wVCallBackContext = wVCallBackContext;
                            if (wVCallBackContext != null) {
                                wVCallBackContext.fireEvent("Broadcast.Message." + string, JSON.toJSONString(obj));
                            }
                        }
                    });
                } else if (wVCallBackContext != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", (Object) "-1");
                    jSONObject2.put("message", (Object) "channel token not exist");
                    wVCallBackContext.error(jSONObject2.toJSONString());
                }
            } else if (wVCallBackContext != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", (Object) "-1");
                jSONObject3.put("message", (Object) "channel token empty error");
                wVCallBackContext.error(jSONObject3.toJSONString());
            }
        }
    }

    public void closeChannel(JSONObject jSONObject) {
        MessageChannel remove;
        if (jSONObject != null && this.messageTokenChannels != null && (remove = this.messageTokenChannels.remove(jSONObject.getString(CHANNEL_INSTANCE_ID))) != null) {
            remove.close();
        }
    }

    public void createChannel(JSONObject jSONObject, WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext == null || wVCallBackContext.getWebview().getContext() == null || jSONObject == null || TextUtils.isEmpty(jSONObject.getString("name")) || TextUtils.isEmpty(jSONObject.getString(CHANNEL_INSTANCE_ID))) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", (Object) "-1");
            jSONObject2.put("message", (Object) "channel args error");
            wVCallBackContext.error(new WVResult(jSONObject2.toJSONString()));
            return;
        }
        synchronized (this) {
            if (this.messageTokenChannels == null) {
                this.messageTokenChannels = new HashMap();
            }
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString(CHANNEL_INSTANCE_ID);
            if (this.messageTokenChannels.get(string2) != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", (Object) "-1");
                jSONObject3.put("message", (Object) "channel error token has been used");
                wVCallBackContext.error(jSONObject3.toJSONString());
                return;
            }
            this.messageTokenChannels.put(string2, new MessageChannel(wVCallBackContext.getWebview().getContext(), string, (MessageCallback) null));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("result", (Object) "0");
            jSONObject4.put("message", (Object) "channel create success");
            wVCallBackContext.success(jSONObject4.toJSONString());
            onMessage(jSONObject, wVCallBackContext);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject parseObject = JSON.parseObject(str2);
            if ("createChannel".equals(str)) {
                createChannel(parseObject, wVCallBackContext);
                return true;
            } else if ("closeChannel".equals(str)) {
                closeChannel(parseObject);
                return true;
            } else if (!WXWeb.POST_MESSAGE.equals(str)) {
                return false;
            } else {
                postMessage(parseObject, wVCallBackContext);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        Map<String, MessageChannel> map = this.messageTokenChannels;
        if (map != null) {
            for (Map.Entry<String, MessageChannel> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().close();
                }
            }
            this.messageTokenChannels.clear();
        }
        super.onDestroy();
    }

    public void postMessage(JSONObject jSONObject, WVCallBackContext wVCallBackContext) {
        if (this.messageTokenChannels != null) {
            if (!TextUtils.isEmpty(jSONObject.getString(CHANNEL_INSTANCE_ID)) && jSONObject.containsKey("message")) {
                String string = jSONObject.getString(CHANNEL_INSTANCE_ID);
                Object obj = jSONObject.get("message");
                MessageChannel messageChannel = this.messageTokenChannels.get(string);
                if (messageChannel == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", (Object) "-1");
                    jSONObject2.put("message", (Object) "channel token not exist");
                    wVCallBackContext.error(jSONObject2.toJSONString());
                    return;
                }
                messageChannel.postMessage(obj);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", (Object) "0");
                jSONObject3.put("message", (Object) "post message success");
                wVCallBackContext.success(jSONObject3.toJSONString());
            } else if (wVCallBackContext != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", (Object) "-1");
                jSONObject4.put("message", (Object) "post message args error");
                wVCallBackContext.error(jSONObject4.toJSONString());
            }
        }
    }
}
