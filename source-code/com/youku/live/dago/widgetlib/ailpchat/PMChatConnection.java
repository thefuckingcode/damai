package com.youku.live.dago.widgetlib.ailpchat;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ali.user.mobile.rpc.ApiConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.tao.powermsg.common.IPowerMsgCallback;
import com.taobao.tao.powermsg.common.IPowerMsgDispatcher;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AnalyticsUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.wr1;
import tb.xr1;

/* compiled from: Taobao */
public class PMChatConnection implements IChatConnection {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG = "PMChatConnection";
    private boolean isForceDisConnect = false;
    private String mAppId = "";
    private int mBizCode = 13;
    private String mFrom = "youku-android";
    private boolean mIsConnected = false;
    private IChatConnection.ConnectionListner mListener;
    private String mMTopKey = "";
    private IPowerMsgDispatcher mPowerMsgDispatcher = new IPowerMsgDispatcher() {
        /* class com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
        public void onDispatch(wr1 wr1) {
            JSONObject jSONObject;
            String str;
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1017907576")) {
                ipChange.ipc$dispatch("-1017907576", new Object[]{this, wr1});
            } else if (!TextUtils.isEmpty(PMChatConnection.this.mTopicId) && PMChatConnection.this.mTopicId.equals(wr1.d)) {
                String str2 = new String(wr1.f);
                ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "chatroom connect dispatch pm msg , data = " + str2);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("datas")) {
                        try {
                            jSONObject = JSON.parseObject(str2);
                        } catch (Exception unused) {
                        }
                        if (jSONObject == null) {
                            String string = jSONObject.getString("datas");
                            String string2 = jSONObject.getString("roomId");
                            String string3 = jSONObject.getString(RemoteMessageConst.MSGID);
                            JSONArray parseArray = !TextUtils.isEmpty(string) ? JSON.parseArray(string) : null;
                            if (parseArray != null && parseArray.size() > 0) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("topicId", wr1.d);
                                hashMap.put("roomId", string2);
                                hashMap.put(RemoteMessageConst.MSGID, string3);
                                hashMap.put("ts", Long.valueOf(wr1.e));
                                hashMap.put("powerMsgId", wr1.b);
                                hashMap.put("datas", parseArray);
                                if (PMChatConnection.this.mWeexListeners == null) {
                                    Log.d("PMChatConnection", "WEEX listener is NULL, get FROM list");
                                    if (PMChatConnection.this.mListener != null) {
                                        PMChatConnection.this.mListener.refreshWeexListener();
                                    }
                                }
                                if (PMChatConnection.this.mWeexListeners != null) {
                                    for (IChatConnection.WeexMessageListener weexMessageListener : PMChatConnection.this.mWeexListeners) {
                                        if (weexMessageListener != null) {
                                            weexMessageListener.onDispatch(hashMap);
                                        }
                                    }
                                }
                                int i2 = 0;
                                while (i2 < parseArray.size()) {
                                    ChatMessage chatMessage = new ChatMessage();
                                    JSONObject jSONObject2 = parseArray.getJSONObject(i2);
                                    if (jSONObject2 != null) {
                                        chatMessage.msgType = jSONObject2.getString("msgType");
                                        String string4 = jSONObject2.getString("data");
                                        JSONObject parseObject = !TextUtils.isEmpty(string4) ? JSON.parseObject(new String(Base64.decode(string4, i))) : null;
                                        if ("notify_unsubscribe".equals(chatMessage.msgType)) {
                                            if (parseObject != null) {
                                                str = parseObject.getString(ApiConstants.ApiField.MTOP_APPKEY);
                                            } else {
                                                str = "";
                                            }
                                            HashMap hashMap2 = new HashMap();
                                            hashMap2.put(ApiConstants.ApiField.MTOP_APPKEY, str);
                                            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("ailp-chat", 19999, "notify_unsubscribe", "", "", hashMap2);
                                            if (PMChatConnection.this.mMTopKey.equals(str)) {
                                                Log.w("PMChatConnection", "receive unsubscribe msg, disconnect PM");
                                                PMChatConnection.this.isForceDisConnect = true;
                                                PMChatConnection.this.disconnect(null);
                                                return;
                                            }
                                        }
                                        if (parseObject != null) {
                                            chatMessage.dataDictionary = parseObject;
                                        }
                                    }
                                    chatMessage.roomId = jSONObject.getString("roomId");
                                    chatMessage.msgId = jSONObject.getString(RemoteMessageConst.MSGID);
                                    chatMessage.subType = wr1.a + "";
                                    chatMessage.topic = wr1.d;
                                    chatMessage.powerMsgId = wr1.b;
                                    if (PMChatConnection.this.mListener != null) {
                                        PMChatConnection.this.mListener.dispatchReceiveMessage(chatMessage);
                                    }
                                    i2++;
                                    i = 0;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                jSONObject = null;
                if (jSONObject == null) {
                }
            }
        }

        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
        public void onError(int i, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-146671587")) {
                ipChange.ipc$dispatch("-146671587", new Object[]{this, Integer.valueOf(i), obj});
            }
        }
    };
    private String mTopicId = "";
    private List<IChatConnection.WeexMessageListener> mWeexListeners;

    public PMChatConnection() {
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean connect(ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1676441291")) {
            return ((Boolean) ipChange.ipc$dispatch("-1676441291", new Object[]{this, iCallback})).booleanValue();
        }
        PMTopicIdManager.getInstance().notifySubscribe(this.mTopicId);
        int topicSubscribeCount = PMTopicIdManager.getInstance().getTopicSubscribeCount(this.mTopicId);
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "SUB topic , current topic Count = " + topicSubscribeCount);
        if (TextUtils.isEmpty(this.mTopicId)) {
            return false;
        }
        xr1.b(this.mBizCode, this.mPowerMsgDispatcher);
        xr1.e(this.mBizCode, this.mTopicId, 3);
        xr1.f(this.mBizCode, this.mTopicId, this.mFrom, new IPowerMsgCallback() {
            /* class com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1021848918")) {
                    ipChange.ipc$dispatch("-1021848918", new Object[]{this, Integer.valueOf(i), map, objArr});
                    return;
                }
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.put("code", Integer.valueOf(i));
                if (i == 1000) {
                    hashMap2.put("success", "1");
                    AnalyticsUtils.callbackSuccess(AnalyticsConstants.SPM_CHATROOM_SUBSCRIPTION);
                    PMChatConnection.this.mIsConnected = true;
                    ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "connection  success = " + PMChatConnection.this.mTopicId);
                    if (PMChatConnection.this.mListener != null) {
                        PMChatConnection.this.mListener.connectionStateChange(ConnectState.CONNECTED);
                    }
                } else {
                    hashMap2.put("success", "0");
                    AnalyticsUtils.callbackFail(AnalyticsConstants.SPM_CHATROOM_SUBSCRIPTION, String.valueOf(i));
                    ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "connection  failure code = " + i);
                    if (PMChatConnection.this.mListener != null) {
                        PMChatConnection.this.mListener.connectionStateChange(ConnectState.DISCONNECTED);
                    }
                }
                hashMap2.put("ban", "0");
                ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("ailp-chat", 19999, "subscribe", "", "", hashMap2);
            }
        }, new Object[0]);
        return false;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean disconnect(final ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493342813")) {
            return ((Boolean) ipChange.ipc$dispatch("1493342813", new Object[]{this, iCallback})).booleanValue();
        }
        PMTopicIdManager.getInstance().notifyUnsubscribe(this.mTopicId);
        int topicSubscribeCount = PMTopicIdManager.getInstance().getTopicSubscribeCount(this.mTopicId);
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "UNSUB topic , current topic Count = " + topicSubscribeCount);
        if (topicSubscribeCount > 0) {
            return false;
        }
        if (TextUtils.isEmpty(this.mTopicId)) {
            Log.d("PMChatConnection", "topic id is " + this.mTopicId + ", or mIsConected = " + this.mIsConnected);
            return false;
        }
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "connetction  disconnect TOPIC = " + this.mTopicId);
        xr1.h(this.mBizCode, this.mTopicId, this.mFrom, new IPowerMsgCallback() {
            /* class com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1262389047")) {
                    ipChange.ipc$dispatch("-1262389047", new Object[]{this, Integer.valueOf(i), map, objArr});
                    return;
                }
                CallbackObject callbackObject = new CallbackObject();
                callbackObject.topicId = PMChatConnection.this.mTopicId;
                HashMap hashMap = new HashMap();
                if (PMChatConnection.this.isForceDisConnect) {
                    hashMap.put("force", "1");
                } else {
                    hashMap.put("force", "0");
                }
                if (i == 1000) {
                    ICallback iCallback = iCallback;
                    if (iCallback != null) {
                        iCallback.onSuccess(callbackObject);
                    }
                    Log.d("PMChatConnection", "disconnect success = " + PMChatConnection.this.mTopicId);
                    hashMap.put("success", "1");
                    PMChatConnection.this.mIsConnected = false;
                } else {
                    callbackObject.msg = "disconnect failure";
                    ICallback iCallback2 = iCallback;
                    if (iCallback2 != null) {
                        iCallback2.onFailure(i, callbackObject);
                    }
                    Log.d("PMChatConnection", "disconnect failure");
                    hashMap.put("success", "0");
                }
                ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("ailp-chat", 19999, "unsubscribe", "", "", hashMap);
            }
        }, new Object[0]);
        return true;
    }

    public boolean isConnected() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1760493341")) {
            return this.mIsConnected;
        }
        return ((Boolean) ipChange.ipc$dispatch("1760493341", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429411074")) {
            ipChange.ipc$dispatch("1429411074", new Object[]{this});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2142451567")) {
            ipChange.ipc$dispatch("-2142451567", new Object[]{this});
            return;
        }
        Log.d("PMChatConnection", "release PM connection");
        this.mTopicId = "";
        List<IChatConnection.WeexMessageListener> list = this.mWeexListeners;
        if (list != null) {
            list.clear();
            this.mWeexListeners = null;
        }
        this.mListener = null;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285110459")) {
            ipChange.ipc$dispatch("-1285110459", new Object[]{this});
            return;
        }
        xr1.b(this.mBizCode, this.mPowerMsgDispatcher);
        xr1.e(this.mBizCode, this.mTopicId, 3);
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean sendMessage(Map<String, Object> map, final IChatConnection.SendMessageCallback sendMessageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491723038")) {
            return ((Boolean) ipChange.ipc$dispatch("-491723038", new Object[]{this, map, sendMessageCallback})).booleanValue();
        }
        wr1 wr1 = new wr1();
        wr1.d = "";
        String str = (String) map.get("data");
        if (!TextUtils.isEmpty(str)) {
            wr1.f = str.getBytes();
        }
        String str2 = (String) map.get("userId");
        wr1.a = ParseUtils.parse2Int((String) map.get("msgType"));
        wr1.c = 13;
        xr1.d(13, wr1, new IPowerMsgCallback() {
            /* class com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-781308789")) {
                    ipChange.ipc$dispatch("-781308789", new Object[]{this, Integer.valueOf(i), map, objArr});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("code", Integer.valueOf(i));
                if (i == 1000) {
                    ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "send msg success");
                    hashMap.put("msg", "success");
                    sendMessageCallback.onSuccess(hashMap);
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "send msg fail");
                hashMap.put("msg", "ailed, and check the error code");
                sendMessageCallback.onFail(hashMap);
            }
        }, new Object[0]);
        return false;
    }

    public void setAppId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108519678")) {
            ipChange.ipc$dispatch("-2108519678", new Object[]{this, str});
            return;
        }
        this.mAppId = str;
    }

    public void setBizCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048328975")) {
            ipChange.ipc$dispatch("1048328975", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBizCode = i;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void setConnectionListener(IChatConnection.ConnectionListner connectionListner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34102171")) {
            ipChange.ipc$dispatch("34102171", new Object[]{this, connectionListner});
            return;
        }
        this.mListener = connectionListner;
    }

    public void setFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731562006")) {
            ipChange.ipc$dispatch("1731562006", new Object[]{this, str});
            return;
        }
        this.mFrom = str;
    }

    public void setMtopKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758321607")) {
            ipChange.ipc$dispatch("758321607", new Object[]{this, str});
            return;
        }
        this.mMTopKey = str;
    }

    public void setTopicId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103673740")) {
            ipChange.ipc$dispatch("-2103673740", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "set topic , TOPIC = " + str);
        this.mTopicId = str;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void setWeexMessageListener(List<IChatConnection.WeexMessageListener> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477813419")) {
            ipChange.ipc$dispatch("1477813419", new Object[]{this, list});
            return;
        }
        this.mWeexListeners = list;
    }

    public PMChatConnection(String str, String str2, int i, IChatConnection.ConnectionListner connectionListner) {
        this.mTopicId = str;
        this.mFrom = str2;
        this.mBizCode = i;
        this.mListener = connectionListner;
    }

    public PMChatConnection(String str, IChatConnection.ConnectionListner connectionListner) {
        this.mTopicId = str;
        this.mListener = connectionListner;
    }
}
