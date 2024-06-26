package com.youku.live.messagechannel.connection;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.orange.OrangeConfig;
import com.taobao.weex.common.Constants;
import com.youku.live.messagechannel.callback.IMCConnectionEventCallback;
import com.youku.live.messagechannel.callback.MCConnectionEvent;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.utils.HttpUtils;
import com.youku.live.messagechannel.utils.MCThreadFactory;
import com.youku.live.messagechannel.utils.MyLog;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.common.util.HttpHeaderConstant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.q;

/* compiled from: Taobao */
public class CDNMCConnection extends AbstractMCConnection {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG = getClass().getName();
    private String cdnExpireInterval;
    private String closePullSwitch;
    private int lastestVer = 0;
    private IMCConnectionEventCallback launchCallback;
    private String minPullInterval;
    private ScheduledThreadPoolExecutor pullCDNMsgExecutor;
    private ScheduledFuture pullCDNMsgFuture;
    private int pullInterval;
    private String url;

    /* compiled from: Taobao */
    public class PullMsgFromCDN implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        PullMsgFromCDN() {
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2002143179")) {
                ipChange.ipc$dispatch("2002143179", new Object[]{this});
            } else if (CDNMCConnection.this.getConnectionState().getCode() <= MCConnectionState.INIT.getCode()) {
                if (CDNMCConnection.this.pullCDNMsgFuture != null) {
                    CDNMCConnection.this.pullCDNMsgFuture.cancel(true);
                }
                MyLog.w(CDNMCConnection.this.TAG, "Connection status is not open, pull job terminal.");
            } else {
                CDNMCConnection cDNMCConnection = CDNMCConnection.this;
                HttpUtils.pullCDNMsg(cDNMCConnection.context, cDNMCConnection.url, new Callback() {
                    /* class com.youku.live.messagechannel.connection.CDNMCConnection.PullMsgFromCDN.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-77403867")) {
                            ipChange.ipc$dispatch("-77403867", new Object[]{this, call, iOException});
                            return;
                        }
                        String str = CDNMCConnection.this.TAG;
                        MyLog.e(str, "CDN pull onFailure" + CDNMCConnection.this.appIdAndChannelString(), iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, q qVar) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "106585728")) {
                            ipChange.ipc$dispatch("106585728", new Object[]{this, call, qVar});
                        } else if (qVar == null || !qVar.isSuccessful()) {
                            if (qVar != null && !qVar.isSuccessful()) {
                                MyLog.e(CDNMCConnection.this.TAG, "CDN pull response fail, code:", Integer.valueOf(qVar.e()), ", msg:", qVar.k());
                            }
                        } else if (qVar.l() == null || qVar.l().e() != 304) {
                            MyLog.d(CDNMCConnection.this.TAG, "CDN pull success, begin to process response", CDNMCConnection.this.appIdAndChannelString());
                            if (CDNMCConnection.this.getConnectionState() == MCConnectionState.OPENING) {
                                CDNMCConnection.this.setConnectionState(MCConnectionState.OPEN);
                                MyLog.d(CDNMCConnection.this.TAG, "CDN pull connection launch success", CDNMCConnection.this.appIdAndChannelString(), " mcConnectionState:", CDNMCConnection.this.getConnectionState());
                                if (CDNMCConnection.this.launchCallback != null) {
                                    IMCConnectionEventCallback iMCConnectionEventCallback = CDNMCConnection.this.launchCallback;
                                    MCConnectionEvent mCConnectionEvent = MCConnectionEvent.LAUNCH_SUCCESS;
                                    iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
                                }
                            }
                            if (qVar.j() == null || qVar.a() == null) {
                                MyLog.e(CDNMCConnection.this.TAG, "CDN pull response headers or body is null", CDNMCConnection.this.appIdAndChannelString());
                                return;
                            }
                            long time = new Date(qVar.j().c(HttpHeaderConstant.DATE)).getTime();
                            try {
                                String k = qVar.a().k();
                                qVar.a().close();
                                if (TextUtils.isEmpty(k)) {
                                    MyLog.e(CDNMCConnection.this.TAG, "CDN pull body is empty", CDNMCConnection.this.appIdAndChannelString());
                                    return;
                                }
                                try {
                                    JSONObject parseObject = JSON.parseObject(k);
                                    if (parseObject != null) {
                                        Long l = parseObject.getLong(ALBiometricsKeys.KEY_APP_ID);
                                        String string = parseObject.getString(RemoteMessageConst.Notification.CHANNEL_ID);
                                        if (l == null || TextUtils.isEmpty(string)) {
                                            MyLog.e(CDNMCConnection.this.TAG, "CDN pull body's appId or channelId is null, bodyString:", k, CDNMCConnection.this.appIdAndChannelString());
                                        } else if (CDNMCConnection.this.appId != l.longValue() || !CDNMCConnection.this.channelId.equals(string)) {
                                            MyLog.e(CDNMCConnection.this.TAG, "CDN pull body's appId or channelId not match, bodyString:", k, CDNMCConnection.this.appIdAndChannelString());
                                        } else {
                                            Long l2 = parseObject.getLong("releaseTime");
                                            long cdnExpirePeriod = CDNMCConnection.this.cdnExpirePeriod();
                                            if (l2 == null) {
                                                MyLog.e(CDNMCConnection.this.TAG, "CDN pull file releaseTime is null, bodyString:", k, ", cdnExpirePeriod:", Long.valueOf(cdnExpirePeriod));
                                            } else if (time - l2.longValue() > cdnExpirePeriod) {
                                                MyLog.d(CDNMCConnection.this.TAG, "CDN pull file expired, bodyString:", k, ", cdnExpirePeriod:", Long.valueOf(cdnExpirePeriod));
                                            } else {
                                                Integer integer = parseObject.getInteger("ver");
                                                if (integer == null) {
                                                    MyLog.e(CDNMCConnection.this.TAG, "CDN pull file ver is null, bodyString:", k, ", cdnExpirePeriod:", Long.valueOf(cdnExpirePeriod));
                                                } else if (integer.intValue() == CDNMCConnection.this.lastestVer) {
                                                    MyLog.d(CDNMCConnection.this.TAG, "CDN pull file version not update, bodyString:", k);
                                                } else {
                                                    Integer integer2 = parseObject.getInteger(Constants.Name.INTERVAL);
                                                    if (integer2 == null || integer2.intValue() == CDNMCConnection.this.pullInterval) {
                                                        MyLog.d(CDNMCConnection.this.TAG, "CDN pull body's interval has no change, pullInterval:", Integer.valueOf(CDNMCConnection.this.pullInterval), ", bodyString:", k);
                                                    } else {
                                                        CDNMCConnection.this.resetPullInterval(integer2.intValue());
                                                    }
                                                    String string2 = parseObject.getString("url");
                                                    if (TextUtils.isEmpty(string2) || string2.equals(CDNMCConnection.this.url)) {
                                                        MyLog.d(CDNMCConnection.this.TAG, "CDN pull body's url has no change, url:", CDNMCConnection.this.url, ", bodyString:", k);
                                                    } else {
                                                        MyLog.i(CDNMCConnection.this.TAG, "CDN pull url change from:", CDNMCConnection.this.url, " to:", string2);
                                                        CDNMCConnection.this.url = string2;
                                                    }
                                                    CDNMCConnection.this.deliverMessages(MCMessage.parseMsgJsonToMCMessages(MCConnectionFlag.CDN, parseObject));
                                                    CDNMCConnection.this.lastestVer = integer.intValue();
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    String str = CDNMCConnection.this.TAG;
                                    MyLog.e(str, "CDN pull body parse to json error, bodyString:" + k + CDNMCConnection.this.appIdAndChannelString(), e);
                                }
                            } catch (IOException e2) {
                                String str2 = CDNMCConnection.this.TAG;
                                MyLog.e(str2, "CDN pull body get error" + CDNMCConnection.this.appIdAndChannelString(), e2);
                                qVar.a().close();
                            } catch (Throwable th) {
                                qVar.a().close();
                                throw th;
                            }
                        } else {
                            MyLog.d(CDNMCConnection.this.TAG, "CDN pull response not modified, not need to process", CDNMCConnection.this.appIdAndChannelString());
                        }
                    }
                });
            }
        }
    }

    public CDNMCConnection(Context context, long j, String str, int i, String str2) {
        super(context, j, str);
        OrangeConfig instance = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.closePull;
        this.closePullSwitch = instance.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig instance2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.minPullInterval;
        this.minPullInterval = instance2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        OrangeConfig instance3 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo3 = OrangeConfKey.cdnExpireInterval;
        this.cdnExpireInterval = instance3.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo3.name, keyInfo3.def);
        if (i > 0) {
            this.pullInterval = i;
        } else {
            this.pullInterval = Integer.valueOf(this.minPullInterval).intValue();
        }
        this.url = str2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long cdnExpirePeriod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "594942184")) {
            return Long.valueOf(this.cdnExpireInterval).longValue() * 1000;
        }
        return ((Long) ipChange.ipc$dispatch("594942184", new Object[]{this})).longValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetPullInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713646565")) {
            ipChange.ipc$dispatch("-713646565", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i <= 0) {
            i = Integer.valueOf(this.minPullInterval).intValue();
        }
        int i2 = this.pullInterval;
        if (i2 != i) {
            MyLog.i(this.TAG, "CDN pull interval change from:", Integer.valueOf(i2), " to:", Integer.valueOf(i));
            this.pullInterval = i;
            ScheduledFuture scheduledFuture = this.pullCDNMsgFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.pullCDNMsgExecutor;
            PullMsgFromCDN pullMsgFromCDN = new PullMsgFromCDN();
            int i3 = this.pullInterval;
            this.pullCDNMsgFuture = scheduledThreadPoolExecutor.scheduleWithFixedDelay(pullMsgFromCDN, (long) i3, (long) i3, TimeUnit.SECONDS);
            return;
        }
        MyLog.d(this.TAG, "CDN pull body's interval has no change, pullInterval:", Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public boolean customDispatchFilterPass(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "479739723")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("479739723", new Object[]{this, mCMessage})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void customLaunch(IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361902388")) {
            ipChange.ipc$dispatch("1361902388", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        this.launchCallback = iMCConnectionEventCallback;
        if ("0".equals(this.closePullSwitch)) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new MCThreadFactory("connection-pull-cdn-msg"));
            this.pullCDNMsgExecutor = scheduledThreadPoolExecutor;
            this.pullCDNMsgFuture = scheduledThreadPoolExecutor.scheduleWithFixedDelay(new PullMsgFromCDN(), 0, (long) this.pullInterval, TimeUnit.SECONDS);
            return;
        }
        MyLog.w(this.TAG, "CDN pull is ban", appIdAndChannelString(), " mcConnectionState:", getConnectionState());
        if (iMCConnectionEventCallback != null) {
            MCConnectionEvent mCConnectionEvent = MCConnectionEvent.LAUNCH_FAIL;
            iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void customShutdown(IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "464168023")) {
            ipChange.ipc$dispatch("464168023", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        ScheduledFuture scheduledFuture = this.pullCDNMsgFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.pullCDNMsgFuture = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.pullCDNMsgExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        MyLog.d(this.TAG, "CDN pull connection shutdown success", appIdAndChannelString(), " mcConnectionState:", getConnectionState());
        if (iMCConnectionEventCallback != null) {
            MCConnectionEvent mCConnectionEvent = MCConnectionEvent.SHUTDOWN_SUCCESS;
            iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void doSomethingForReopen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157524146")) {
            ipChange.ipc$dispatch("157524146", new Object[]{this});
        }
    }

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public MCConnectionFlag getConnectionFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1006591077")) {
            return MCConnectionFlag.CDN;
        }
        return (MCConnectionFlag) ipChange.ipc$dispatch("1006591077", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    public void stateChangeNotify(MCConnectionState mCConnectionState, MCConnectionState mCConnectionState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986310549")) {
            ipChange.ipc$dispatch("1986310549", new Object[]{this, mCConnectionState, mCConnectionState2});
        }
    }
}
