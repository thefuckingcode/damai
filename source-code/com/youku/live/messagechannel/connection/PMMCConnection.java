package com.youku.live.messagechannel.connection;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.powermsg.common.IPowerMsgCallback;
import com.taobao.tao.powermsg.common.IPowerMsgDispatcher;
import com.youku.live.messagechannel.callback.IMCConnectionEventCallback;
import com.youku.live.messagechannel.callback.MCConnectionEvent;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.HashMap;
import java.util.Map;
import tb.wr1;
import tb.xr1;

/* compiled from: Taobao */
public class PMMCConnection extends AbstractMCConnection {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String BIZ_TAG = "";
    private static final String FROM = "youku-android";
    private static final String PM_CHANNEL = "message-channel";
    private static Map<Integer, IPowerMsgDispatcher> bizPMDispatcher = new HashMap();
    private final String TAG = getClass().getName();
    private int bizCode;
    private int msgFetchMode;
    private String topic;

    public PMMCConnection(Context context, long j, String str, int i, String str2, int i2) {
        super(context, j, str);
        this.bizCode = i;
        this.topic = str2;
        this.msgFetchMode = i2 <= 0 ? 3 : i2;
    }

    private void registerPMMsgDispatcher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792999801")) {
            ipChange.ipc$dispatch("-792999801", new Object[]{this});
        } else if (!bizPMDispatcher.containsKey(Integer.valueOf(this.bizCode))) {
            synchronized (bizPMDispatcher) {
                if (!bizPMDispatcher.containsKey(Integer.valueOf(this.bizCode))) {
                    AnonymousClass3 r1 = new IPowerMsgDispatcher() {
                        /* class com.youku.live.messagechannel.connection.PMMCConnection.AnonymousClass3 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
                        public void onDispatch(wr1 wr1) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-149673315")) {
                                ipChange.ipc$dispatch("-149673315", new Object[]{this, wr1});
                            } else if (wr1 == null) {
                                MyLog.e(PMMCConnection.this.TAG, "PowerMessage is null!");
                            } else if (wr1.c != PMMCConnection.this.bizCode) {
                                MyLog.e(PMMCConnection.this.TAG, "PowerMessage bizCode is not match!");
                            } else {
                                byte[] bArr = wr1.f;
                                if (bArr == null || bArr.length == 0) {
                                    MyLog.e(PMMCConnection.this.TAG, "PowerMessage data is empty!");
                                } else if (wr1.a < 20000) {
                                    MyLog.d(PMMCConnection.this.TAG, "PowerMessage inner messages ignore, type:", Integer.valueOf(wr1.a));
                                } else {
                                    try {
                                        JSONObject parseObject = JSON.parseObject(new String(bArr));
                                        if (parseObject != null) {
                                            PMMCConnection.this.deliverMessages(MCMessage.parseMsgJsonToMCMessages(MCConnectionFlag.PM, parseObject));
                                        }
                                    } catch (Exception e) {
                                        MyLog.e(PMMCConnection.this.TAG, "PowerMessage data parse error!", e);
                                    }
                                }
                            }
                        }

                        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
                        public void onError(int i, Object obj) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1021885416")) {
                                ipChange.ipc$dispatch("1021885416", new Object[]{this, Integer.valueOf(i), obj});
                                return;
                            }
                            MyLog.e(PMMCConnection.this.TAG, "PowerMsg dispatcher error, code:", Integer.valueOf(i));
                        }
                    };
                    xr1.c(this.bizCode, PM_CHANNEL, r1);
                    bizPMDispatcher.put(Integer.valueOf(this.bizCode), r1);
                    MyLog.d(this.TAG, "Register PowerMsg message dispatcher, bizCode:", Integer.valueOf(this.bizCode), ", pChannel:", PM_CHANNEL);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public boolean customDispatchFilterPass(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-421698119")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-421698119", new Object[]{this, mCMessage})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void customLaunch(final IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070615842")) {
            ipChange.ipc$dispatch("2070615842", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        registerPMMsgDispatcher();
        xr1.e(this.bizCode, this.topic, this.msgFetchMode);
        xr1.g(this.bizCode, this.topic, PM_CHANNEL, FROM, "", new IPowerMsgCallback() {
            /* class com.youku.live.messagechannel.connection.PMMCConnection.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-159963709")) {
                    ipChange.ipc$dispatch("-159963709", new Object[]{this, Integer.valueOf(i), map, objArr});
                } else if (i == 1000) {
                    PMMCConnection.this.setConnectionState(MCConnectionState.OPEN);
                    MyLog.d(PMMCConnection.this.TAG, "PowerMsg subscribe success. topic:", PMMCConnection.this.topic, PMMCConnection.this.appIdAndChannelString(), " mcConnectionState:", PMMCConnection.this.getConnectionState());
                    IMCConnectionEventCallback iMCConnectionEventCallback = iMCConnectionEventCallback;
                    if (iMCConnectionEventCallback != null) {
                        MCConnectionEvent mCConnectionEvent = MCConnectionEvent.LAUNCH_SUCCESS;
                        iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
                    }
                } else {
                    MyLog.e(PMMCConnection.this.TAG, "PowerMsg subscribe fail. topic:", PMMCConnection.this.topic, " code:", Integer.valueOf(i), PMMCConnection.this.appIdAndChannelString(), " mcConnectionState:", PMMCConnection.this.getConnectionState());
                    IMCConnectionEventCallback iMCConnectionEventCallback2 = iMCConnectionEventCallback;
                    if (iMCConnectionEventCallback2 != null) {
                        MCConnectionEvent mCConnectionEvent2 = MCConnectionEvent.LAUNCH_FAIL;
                        iMCConnectionEventCallback2.onEvent(mCConnectionEvent2, mCConnectionEvent2.getMsg(), null);
                    }
                }
            }
        }, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void customShutdown(final IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1362002747")) {
            ipChange.ipc$dispatch("-1362002747", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        xr1.i(this.bizCode, this.topic, PM_CHANNEL, FROM, "", new IPowerMsgCallback() {
            /* class com.youku.live.messagechannel.connection.PMMCConnection.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-400503838")) {
                    ipChange.ipc$dispatch("-400503838", new Object[]{this, Integer.valueOf(i), map, objArr});
                } else if (i == 1000) {
                    MyLog.d(PMMCConnection.this.TAG, "PowerMsg unSubscribe success. topic:", PMMCConnection.this.topic, PMMCConnection.this.appIdAndChannelString(), " mcConnectionState:", PMMCConnection.this.getConnectionState());
                    IMCConnectionEventCallback iMCConnectionEventCallback = iMCConnectionEventCallback;
                    if (iMCConnectionEventCallback != null) {
                        MCConnectionEvent mCConnectionEvent = MCConnectionEvent.SHUTDOWN_SUCCESS;
                        iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
                    }
                } else {
                    MyLog.d(PMMCConnection.this.TAG, "PowerMsg unSubscribe fail. topic:", PMMCConnection.this.topic, PMMCConnection.this.appIdAndChannelString(), " mcConnectionState:", PMMCConnection.this.getConnectionState());
                    IMCConnectionEventCallback iMCConnectionEventCallback2 = iMCConnectionEventCallback;
                    if (iMCConnectionEventCallback2 != null) {
                        MCConnectionEvent mCConnectionEvent2 = MCConnectionEvent.SHUTDOWN_FAIL;
                        iMCConnectionEventCallback2.onEvent(mCConnectionEvent2, mCConnectionEvent2.getMsg(), null);
                    }
                }
            }
        }, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void doSomethingForReopen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316005500")) {
            ipChange.ipc$dispatch("-1316005500", new Object[]{this});
        }
    }

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public MCConnectionFlag getConnectionFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1986748589")) {
            return MCConnectionFlag.PM;
        }
        return (MCConnectionFlag) ipChange.ipc$dispatch("-1986748589", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void stateChangeNotify(MCConnectionState mCConnectionState, MCConnectionState mCConnectionState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824483331")) {
            ipChange.ipc$dispatch("1824483331", new Object[]{this, mCConnectionState, mCConnectionState2});
        }
    }
}
