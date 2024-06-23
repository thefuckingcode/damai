package com.youku.live.messagechannel.connection.Connector;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.utils.AppFrontBackHelper;
import com.youku.live.messagechannel.utils.HttpUtils;
import com.youku.live.messagechannel.utils.MyLog;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AccsH5Connector implements Connector {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "com.youku.live.messagechannel.connection.Connector.AccsH5Connector";
    private static AccsH5Connector accsH5Connector;
    private static Application application;
    private String accsH5ConnectWssTimeout;
    private String accsH5PingInterval;
    private String accsH5ReconnectInterval;
    private String accsH5ReconnectRetryMaxCount;
    private String accsH5SelfCheckInterval;
    private volatile ScheduledFuture connectCheckFuture;
    private ScheduledFuture connectFuture;
    private ScheduledThreadPoolExecutor connectorScheduledExecutor = new ScheduledThreadPoolExecutor(1);
    private volatile ConnectorStatus connectorStatus = ConnectorStatus.INIT;
    private long lastPongArriveTime;
    private ScheduledFuture pingFuture;
    private Map<String, ConnectorListener> registeredListeners;
    private WebSocketClient webSocketClient;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ConnectCheckTask implements Runnable {
        ConnectCheckTask() {
        }

        public void run() {
            MyLog.i(AccsH5Connector.TAG, "Connect check >> begin...");
            if (ConnectorStatus.OPEN == AccsH5Connector.this.connectorStatus && (AccsH5Connector.this.registeredListeners.isEmpty() || AccsH5Connector.this.webSocketClient == null || !AccsH5Connector.this.webSocketClient.isOpen() || System.currentTimeMillis() - AccsH5Connector.this.lastPongArriveTime > ((long) (Integer.valueOf(AccsH5Connector.this.accsH5SelfCheckInterval).intValue() * 1000)))) {
                MyLog.i(AccsH5Connector.TAG, "Connect check >> disconnect.");
                AccsH5Connector.this.disconnect();
            }
            if (!AccsH5Connector.this.registeredListeners.isEmpty() && ConnectorStatus.CLOSED == AccsH5Connector.this.connectorStatus) {
                MyLog.i(AccsH5Connector.TAG, "Connect check >> connect.");
                AccsH5Connector.this.connect();
            }
            if (ConnectorStatus.CLOSED == AccsH5Connector.this.connectorStatus && AccsH5Connector.this.registeredListeners.isEmpty() && AccsH5Connector.this.connectCheckFuture != null && !AccsH5Connector.this.connectCheckFuture.isCancelled()) {
                AccsH5Connector.this.connectCheckFuture.cancel(true);
                MyLog.i(AccsH5Connector.TAG, "Connect check task stop.");
            }
        }
    }

    /* compiled from: Taobao */
    public class ConnectTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private int retryTimes = 0;

        ConnectTask() {
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2134076032")) {
                ipChange.ipc$dispatch("2134076032", new Object[]{this});
                return;
            }
            MyLog.i(AccsH5Connector.TAG, "ACCS H5 connect begin...");
            if (ConnectorStatus.OPENING != AccsH5Connector.this.connectorStatus) {
                MyLog.w(AccsH5Connector.TAG, "Connector is ", AccsH5Connector.this.connectorStatus.name(), ", stop connect task.");
                AccsH5Connector.this.stopConnectTask();
            } else if (this.retryTimes >= Integer.valueOf(AccsH5Connector.this.accsH5ReconnectRetryMaxCount).intValue()) {
                AccsH5Connector.this.setConnectorStatus(ConnectorStatus.CLOSED);
                MyLog.e(AccsH5Connector.TAG, "Connect retry more than max times:", Integer.valueOf(this.retryTimes));
                AccsH5Connector.this.stopConnectTask();
            } else {
                HttpUtils.accsH5Token(AccsH5Connector.application.getApplicationContext(), new MtopCallback.MtopFinishListener() {
                    /* class com.youku.live.messagechannel.connection.Connector.AccsH5Connector.ConnectTask.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
                    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-88314179")) {
                            ipChange.ipc$dispatch("-88314179", new Object[]{this, mtopFinishEvent, obj});
                            return;
                        }
                        MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                        if (!mtopResponse.getApi().equals(HttpUtils.HTTP_ACCS_H5_TOKEN) || !mtopResponse.isApiSuccess()) {
                            MyLog.e(AccsH5Connector.TAG, "Get ACCS H5 token fail.");
                            return;
                        }
                        JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
                        if (dataJsonObject != null) {
                            String optString = dataJsonObject.optString("deviceId");
                            String optString2 = dataJsonObject.optString("token");
                            String optString3 = dataJsonObject.optString("accsAppKey");
                            String optString4 = dataJsonObject.optString("accsWSSAuthURL");
                            MyLog.i(AccsH5Connector.TAG, "Get ACCS H5 token success, deviceId:", optString, ", token:", optString2, ", accsAppKey:", optString3, ", webSocketURL:", optString4);
                            AccsH5Connector.this.webSocketInit(optString4, optString2);
                        }
                    }
                });
                this.retryTimes++;
            }
        }
    }

    private AccsH5Connector() {
        OrangeConfig instance = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.accsH5ReconnectInterval;
        this.accsH5ReconnectInterval = instance.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig instance2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.accsH5ReconnectRetryMaxCount;
        this.accsH5ReconnectRetryMaxCount = instance2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        OrangeConfig instance3 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo3 = OrangeConfKey.accsH5PingInterval;
        this.accsH5PingInterval = instance3.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo3.name, keyInfo3.def);
        OrangeConfig instance4 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo4 = OrangeConfKey.accsH5SelfCheckInterval;
        this.accsH5SelfCheckInterval = instance4.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo4.name, keyInfo4.def);
        OrangeConfig instance5 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo5 = OrangeConfKey.accsH5ConnectWssTimeOut;
        this.accsH5ConnectWssTimeout = instance5.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo5.name, keyInfo5.def);
        this.registeredListeners = new HashMap();
        this.lastPongArriveTime = 0;
        AppFrontBackHelper.getInstance().addFrontBackEventListener(new AppFrontBackHelper.FrontBackEventListener() {
            /* class com.youku.live.messagechannel.connection.Connector.AccsH5Connector.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.messagechannel.utils.AppFrontBackHelper.FrontBackEventListener
            public void onBack() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1847271452")) {
                    ipChange.ipc$dispatch("1847271452", new Object[]{this});
                }
            }

            @Override // com.youku.live.messagechannel.utils.AppFrontBackHelper.FrontBackEventListener
            public void onFront() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1931577474")) {
                    ipChange.ipc$dispatch("-1931577474", new Object[]{this});
                } else if (!AccsH5Connector.this.registeredListeners.isEmpty() && ConnectorStatus.CLOSED == AccsH5Connector.this.connectorStatus) {
                    AccsH5Connector.this.connect();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void connect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941127892")) {
            ipChange.ipc$dispatch("-1941127892", new Object[]{this});
            return;
        }
        synchronized (this) {
            if (this.registeredListeners.isEmpty()) {
                MyLog.w(TAG, "Listeners is empty, stop open.");
            } else if (ConnectorStatus.OPEN == this.connectorStatus) {
                MyLog.w(TAG, "Connector is open, stop open.");
            } else {
                ConnectorStatus connectorStatus2 = ConnectorStatus.OPENING;
                if (connectorStatus2 == this.connectorStatus) {
                    MyLog.w(TAG, "Connector is opening, stop repeat open.");
                    return;
                }
                setConnectorStatus(connectorStatus2);
                startConnectTask();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void disconnect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864760024")) {
            ipChange.ipc$dispatch("1864760024", new Object[]{this});
            return;
        }
        WebSocketClient webSocketClient2 = this.webSocketClient;
        if (webSocketClient2 != null) {
            webSocketClient2.close();
        }
        stopConnectTask();
        stopPing();
        setConnectorStatus(ConnectorStatus.CLOSED);
    }

    public static synchronized AccsH5Connector getInstance() {
        synchronized (AccsH5Connector.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "275226299")) {
                return (AccsH5Connector) ipChange.ipc$dispatch("275226299", new Object[0]);
            }
            if (accsH5Connector == null && application != null) {
                accsH5Connector = new AccsH5Connector();
            }
            return accsH5Connector;
        }
    }

    public static void setApplication(Application application2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135868807")) {
            ipChange.ipc$dispatch("-135868807", new Object[]{application2});
        } else if (application == null) {
            application = application2;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setConnectorStatus(ConnectorStatus connectorStatus2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257021770")) {
            ipChange.ipc$dispatch("-1257021770", new Object[]{this, connectorStatus2});
        } else if (this.connectorStatus != connectorStatus2) {
            this.connectorStatus = connectorStatus2;
            MyLog.d(TAG, "Connector status change to ", connectorStatus2.name());
            if (ConnectorStatus.OPEN == this.connectorStatus || ConnectorStatus.CLOSED == this.connectorStatus) {
                for (ConnectorListener connectorListener : this.registeredListeners.values()) {
                    if (ConnectorStatus.OPEN == this.connectorStatus) {
                        connectorListener.onOpen();
                    }
                    if (ConnectorStatus.CLOSED == this.connectorStatus) {
                        connectorListener.onClosed();
                    }
                }
            }
        }
    }

    private void startConnectTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967610055")) {
            ipChange.ipc$dispatch("967610055", new Object[]{this});
            return;
        }
        this.connectFuture = this.connectorScheduledExecutor.scheduleWithFixedDelay(new ConnectTask(), 0, (long) Integer.valueOf(this.accsH5ReconnectInterval).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startPing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323409058")) {
            ipChange.ipc$dispatch("323409058", new Object[]{this});
            return;
        }
        ScheduledFuture scheduledFuture = this.pingFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            this.pingFuture = this.connectorScheduledExecutor.scheduleWithFixedDelay(new Runnable() {
                /* class com.youku.live.messagechannel.connection.Connector.AccsH5Connector.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2097416898")) {
                        ipChange.ipc$dispatch("-2097416898", new Object[]{this});
                    } else if (AccsH5Connector.this.webSocketClient != null && AccsH5Connector.this.webSocketClient.isOpen()) {
                        AccsH5Connector.this.webSocketClient.sendFrame(new Framedata() {
                            /* class com.youku.live.messagechannel.connection.Connector.AccsH5Connector.AnonymousClass1.AnonymousClass1 */

                            public void append(Framedata framedata) {
                            }

                            public Framedata.Opcode getOpcode() {
                                return Framedata.Opcode.PING;
                            }

                            public ByteBuffer getPayloadData() {
                                return ByteBuffer.wrap(new byte[0]);
                            }

                            public boolean getTransfereMasked() {
                                return true;
                            }

                            public boolean isFin() {
                                return true;
                            }
                        });
                        MyLog.d(AccsH5Connector.TAG, "WebSocket send ping.");
                    }
                }
            }, (long) Integer.valueOf(this.accsH5PingInterval).intValue(), (long) Integer.valueOf(this.accsH5PingInterval).intValue(), TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopConnectTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927720439")) {
            ipChange.ipc$dispatch("-1927720439", new Object[]{this});
            return;
        }
        ScheduledFuture scheduledFuture = this.connectFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    private void stopPing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674125728")) {
            ipChange.ipc$dispatch("674125728", new Object[]{this});
            return;
        }
        ScheduledFuture scheduledFuture = this.pingFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void webSocketInit(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389016115")) {
            ipChange.ipc$dispatch("389016115", new Object[]{this, str, str2});
            return;
        }
        String str3 = str + "?token=" + str2;
        MyLog.i(TAG, "Connector webSocket init, webSocketWithAuthURLString:", str3);
        try {
            AnonymousClass3 r14 = new WebSocketClient(new URI(str3), new Draft_17(), null, Integer.valueOf(this.accsH5ConnectWssTimeout).intValue() * 1000) {
                /* class com.youku.live.messagechannel.connection.Connector.AccsH5Connector.AnonymousClass3 */

                public void onClose(int i, String str, boolean z) {
                    MyLog.i(AccsH5Connector.TAG, "WebSocket onClose.");
                }

                public void onError(Exception exc) {
                    MyLog.e(AccsH5Connector.TAG, "WebSocket onError.", exc);
                }

                public void onMessage(String str) {
                    ConnectorListener connectorListener;
                    MyLog.d(AccsH5Connector.TAG, "WebSocket onMessage: ", str);
                    AccsH5DataMessage parseJsonToDataMessages = AccsH5DataMessage.parseJsonToDataMessages(str);
                    if (!(parseJsonToDataMessages == null || !"DATA".equals(parseJsonToDataMessages.type) || (connectorListener = (ConnectorListener) AccsH5Connector.this.registeredListeners.get(parseJsonToDataMessages.serviceId)) == null)) {
                        connectorListener.onMessage(parseJsonToDataMessages.serviceId, parseJsonToDataMessages.dataId, parseJsonToDataMessages.data);
                        MyLog.v(AccsH5Connector.TAG, "WebSocket dispatch messages by serviceId, ", parseJsonToDataMessages.toString());
                    }
                    AccsH5DataAckMessage accsH5DataAckMessage = new AccsH5DataAckMessage();
                    accsH5DataAckMessage.protocol = parseJsonToDataMessages.protocol;
                    accsH5DataAckMessage.type = "ACK";
                    accsH5DataAckMessage.serviceId = parseJsonToDataMessages.serviceId;
                    accsH5DataAckMessage.dataId = parseJsonToDataMessages.dataId;
                    accsH5DataAckMessage.data = "";
                    accsH5DataAckMessage.source = parseJsonToDataMessages.target;
                    accsH5DataAckMessage.target = parseJsonToDataMessages.source;
                    accsH5DataAckMessage.ip = parseJsonToDataMessages.ip;
                    AccsH5Connector.this.webSocketClient.send(JSON.toJSONString(accsH5DataAckMessage));
                    MyLog.v(AccsH5Connector.TAG, "WebSocket send ack, ", accsH5DataAckMessage.toString());
                }

                public void onOpen(ServerHandshake serverHandshake) {
                    MyLog.i(AccsH5Connector.TAG, "WebSocket onOpen.");
                    AccsH5Connector.this.setConnectorStatus(ConnectorStatus.OPEN);
                    AccsH5Connector.this.startPing();
                    AccsH5Connector.this.stopConnectTask();
                }

                public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
                    AccsH5Connector.super.onWebsocketPong(webSocket, framedata);
                    AccsH5Connector.this.lastPongArriveTime = System.currentTimeMillis();
                    MyLog.i(AccsH5Connector.TAG, "WebSocket onWebsocketPong.");
                }
            };
            this.webSocketClient = r14;
            r14.connect();
        } catch (Exception unused) {
            MyLog.e(TAG, "Connector webSocket init fail, webSocketWithAuthURLString:", str3);
        }
    }

    public ConnectorStatus getConnectorStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1904912438")) {
            return this.connectorStatus;
        }
        return (ConnectorStatus) ipChange.ipc$dispatch("-1904912438", new Object[]{this});
    }

    @Override // com.youku.live.messagechannel.connection.Connector.Connector
    public boolean isSubscribe(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "254281444")) {
            return this.registeredListeners.containsKey(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("254281444", new Object[]{this, str})).booleanValue();
    }

    @Override // com.youku.live.messagechannel.connection.Connector.Connector
    public void reconnect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977253215")) {
            ipChange.ipc$dispatch("977253215", new Object[]{this});
            return;
        }
        disconnect();
        connect();
    }

    @Override // com.youku.live.messagechannel.connection.Connector.Connector
    public void subscribe(String str, ConnectorListener connectorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187816915")) {
            ipChange.ipc$dispatch("187816915", new Object[]{this, str, connectorListener});
        } else if (!TextUtils.isEmpty(str) && connectorListener != null) {
            this.registeredListeners.put(str, connectorListener);
            if (ConnectorStatus.OPEN == this.connectorStatus) {
                connectorListener.onOpen();
            } else {
                connect();
            }
            if (this.connectCheckFuture == null || this.connectCheckFuture.isCancelled()) {
                this.connectCheckFuture = this.connectorScheduledExecutor.scheduleWithFixedDelay(new ConnectCheckTask(), (long) Integer.valueOf(this.accsH5SelfCheckInterval).intValue(), (long) Integer.valueOf(this.accsH5SelfCheckInterval).intValue(), TimeUnit.SECONDS);
                MyLog.i(TAG, "Connect check task start.");
            }
        }
    }

    @Override // com.youku.live.messagechannel.connection.Connector.Connector
    public void unsubscribe(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "510955503")) {
            ipChange.ipc$dispatch("510955503", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.registeredListeners.remove(str);
        }
    }
}
