package com.youku.live.dago.widgetlib.ailpchat;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public abstract class ChatRoom implements IChatConnection.ConnectionListner {
    private static transient /* synthetic */ IpChange $ipChange;
    protected static Map<String, Class<? extends IChatConnection>> mClazzMap = new HashMap();
    protected String PM = "pm://";
    private final String TAG = "ChatRoom";
    public ChatRoomConfig mChatRoomConfig = new ChatRoomConfig();
    protected IChatConnection mConnection;
    private List<MessageDelegate> mMessageDelegates = new ArrayList();
    protected String mUniqueKey;
    protected volatile int sConnectionCount = 0;

    /* compiled from: Taobao */
    public interface SendMsgCallback {
        void onSendFail(int i);

        void onSendSuccess(int i);
    }

    private void dispatchMessage(ChatMessage chatMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955842131")) {
            ipChange.ipc$dispatch("-1955842131", new Object[]{this, chatMessage});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("ChatRoom", "dispath to delegate");
        if (this.mMessageDelegates.size() == 0) {
            setMessageDelegate();
        }
        for (MessageDelegate messageDelegate : this.mMessageDelegates) {
            List<String> list = messageDelegate.names;
            if (list != null && (list.contains(jl1.MUL) || messageDelegate.names.contains(chatMessage.msgType))) {
                messageDelegate.dispatchReceiveMessage(chatMessage);
            }
        }
    }

    public static void registerClass(String str, Class<? extends IChatConnection> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987358320")) {
            ipChange.ipc$dispatch("-987358320", new Object[]{str, cls});
        } else if (cls != null) {
            ((ILog) Dsl.getService(ILog.class)).d("ChatConnection", "registerClass = " + cls);
        }
    }

    private void setMessageDelegate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504782248")) {
            ipChange.ipc$dispatch("504782248", new Object[]{this});
        } else if (ChatRoomManager.mChatRoomMessageDelegates.get(this.mUniqueKey) != null) {
            for (MessageDelegate messageDelegate : ChatRoomManager.mChatRoomMessageDelegates.get(this.mUniqueKey)) {
                addMessageDelegate(messageDelegate);
            }
        }
    }

    public void addMessageDelegate(MessageDelegate messageDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137084756")) {
            ipChange.ipc$dispatch("-137084756", new Object[]{this, messageDelegate});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).w("ChatConnection", "addMessageDelegate");
        this.mMessageDelegates.add(messageDelegate);
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.ConnectionListner
    public ConnectState connectState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1530926093")) {
            return null;
        }
        return (ConnectState) ipChange.ipc$dispatch("-1530926093", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.ConnectionListner
    public void connectionStateChange(ConnectState connectState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580664643")) {
            ipChange.ipc$dispatch("580664643", new Object[]{this, connectState});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.ConnectionListner
    public void dispatchReceiveMessage(ChatMessage chatMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214851050")) {
            ipChange.ipc$dispatch("-1214851050", new Object[]{this, chatMessage});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("ChatRoom", "chatroom  dispatch pm Message");
        dispatchMessage(chatMessage);
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.ConnectionListner
    public void dispatchWeexMessage(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967629639")) {
            ipChange.ipc$dispatch("-1967629639", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("ChatRoom", "chatroom  dispatch pm Message");
    }

    public boolean enter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082030628")) {
            return ((Boolean) ipChange.ipc$dispatch("1082030628", new Object[]{this})).booleanValue();
        }
        ((ILog) Dsl.getService(ILog.class)).d("ChatRoom", "chatroom enter start");
        if (this.mConnection != null) {
            this.sConnectionCount++;
            ((ILog) Dsl.getService(ILog.class)).d("ChatConnection", "enter room sConnectionCount = " + this.sConnectionCount);
            this.mConnection.connect(null);
        }
        return false;
    }

    public IChatConnection getConnection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "347389604")) {
            return this.mConnection;
        }
        return (IChatConnection) ipChange.ipc$dispatch("347389604", new Object[]{this});
    }

    public List<MessageDelegate> getMessageDelegates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1096497676")) {
            return this.mMessageDelegates;
        }
        return (List) ipChange.ipc$dispatch("1096497676", new Object[]{this});
    }

    public boolean leave() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "470561253")) {
            return ((Boolean) ipChange.ipc$dispatch("470561253", new Object[]{this})).booleanValue();
        }
        ((ILog) Dsl.getService(ILog.class)).d("ChatRoom", "chatroom leave stop");
        this.sConnectionCount--;
        ((ILog) Dsl.getService(ILog.class)).d("ChatConnection", "leave room sConnectionCount = " + this.sConnectionCount);
        if (this.sConnectionCount > 0) {
            return false;
        }
        if (ChatRoomManager.mChatRoomMessageDelegates.containsKey(this.mUniqueKey)) {
            ChatRoomManager.mChatRoomMessageDelegates.remove(this.mUniqueKey);
        }
        List<MessageDelegate> list = this.mMessageDelegates;
        if (list != null) {
            list.clear();
        }
        IChatConnection iChatConnection = this.mConnection;
        if (iChatConnection != null) {
            iChatConnection.disconnect(new ICallback() {
                /* class com.youku.live.dago.widgetlib.ailpchat.ChatRoom.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpchat.ICallback
                public void onFailure(int i, CallbackObject callbackObject) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2031495672")) {
                        ipChange.ipc$dispatch("2031495672", new Object[]{this, Integer.valueOf(i), callbackObject});
                        return;
                    }
                    String str = null;
                    if (callbackObject != null) {
                        str = callbackObject.topicId;
                    }
                    if (ChatRoomManager.mChatRoomWeexListeners.containsKey(str)) {
                        ChatRoomManager.mChatRoomWeexListeners.remove(str);
                    }
                    if (ChatRoom.this.mChatRoomConfig != null && ChatRoomManager.mRoomIdWeexListeners.containsKey(ChatRoom.this.mChatRoomConfig.roomId)) {
                        ChatRoomManager.mRoomIdWeexListeners.remove(ChatRoom.this.mChatRoomConfig.roomId);
                    }
                    IChatConnection iChatConnection = ChatRoom.this.mConnection;
                    if (iChatConnection != null) {
                        iChatConnection.release();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpchat.ICallback
                public void onSuccess(CallbackObject callbackObject) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-648958572")) {
                        ipChange.ipc$dispatch("-648958572", new Object[]{this, callbackObject});
                        return;
                    }
                    String str = null;
                    if (callbackObject != null) {
                        str = callbackObject.topicId;
                    }
                    if (ChatRoomManager.mChatRoomWeexListeners.containsKey(str)) {
                        ChatRoomManager.mChatRoomWeexListeners.remove(str);
                    }
                    if (ChatRoom.this.mChatRoomConfig != null && ChatRoomManager.mRoomIdWeexListeners.containsKey(ChatRoom.this.mChatRoomConfig.roomId)) {
                        ChatRoomManager.mRoomIdWeexListeners.remove(ChatRoom.this.mChatRoomConfig.roomId);
                    }
                    IChatConnection iChatConnection = ChatRoom.this.mConnection;
                    if (iChatConnection != null) {
                        iChatConnection.release();
                    }
                }
            });
        }
        return true;
    }

    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1069395073")) {
            ipChange.ipc$dispatch("1069395073", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("pmchat", "chat room On PAUSE");
    }

    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "439295398")) {
            ipChange.ipc$dispatch("439295398", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("pmchat", "chat room On RESUME");
    }

    public void removeMessageDelegate(MessageDelegate messageDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050299125")) {
            ipChange.ipc$dispatch("2050299125", new Object[]{this, messageDelegate});
            return;
        }
        this.mMessageDelegates.remove(messageDelegate);
        ((ILog) Dsl.getService(ILog.class)).w("ChatConnection", "removeMessageDelegate");
    }

    public boolean sendMessage(Map<String, Object> map, final SendMsgCallback sendMsgCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511287766")) {
            return ((Boolean) ipChange.ipc$dispatch("-511287766", new Object[]{this, map, sendMsgCallback})).booleanValue();
        }
        this.mConnection.sendMessage(map, new IChatConnection.SendMessageCallback() {
            /* class com.youku.live.dago.widgetlib.ailpchat.ChatRoom.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.SendMessageCallback
            public void onFail(Map<String, Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-76451006")) {
                    ipChange.ipc$dispatch("-76451006", new Object[]{this, map});
                    return;
                }
                sendMsgCallback.onSendFail(((Integer) map.get("code")).intValue());
            }

            @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.SendMessageCallback
            public void onSuccess(Map<String, Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1962233857")) {
                    ipChange.ipc$dispatch("-1962233857", new Object[]{this, map});
                    return;
                }
                sendMsgCallback.onSendSuccess(((Integer) map.get("code")).intValue());
            }
        });
        return false;
    }

    /* access modifiers changed from: protected */
    public void setConnectionListener(IChatConnection.ConnectionListner connectionListner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388705061")) {
            ipChange.ipc$dispatch("-388705061", new Object[]{this, connectionListner});
            return;
        }
        IChatConnection iChatConnection = this.mConnection;
        if (iChatConnection != null) {
            iChatConnection.setConnectionListener(connectionListner);
        }
    }

    public void setWeexListener(List<IChatConnection.WeexMessageListener> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602170766")) {
            ipChange.ipc$dispatch("-602170766", new Object[]{this, list});
            return;
        }
        IChatConnection iChatConnection = this.mConnection;
        if (iChatConnection != null) {
            iChatConnection.setWeexMessageListener(list);
            String str = "";
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    str = str + "," + list.get(i).hashCode();
                }
            }
            ((ILog) Dsl.getService(ILog.class)).i("liutaoLog", "setWeexMessageListeners" + str + " to mConnection:" + this.mConnection.hashCode());
        }
    }

    public void unregister(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-473922720")) {
            ipChange.ipc$dispatch("-473922720", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).w("ChatConnection", MiPushClient.COMMAND_UNREGISTER);
    }
}
