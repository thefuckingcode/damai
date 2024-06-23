package com.youku.live.messagechannel.message;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.callback.IMCDispatchMsgCallback;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.heartbeat.MCHeartbeat;
import com.youku.live.messagechannel.report.MCMarkMessage;
import com.youku.live.messagechannel.report.MCMarkMessageManager;
import com.youku.live.messagechannel.utils.LRUQueue;
import com.youku.live.messagechannel.utils.MCThreadPool;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.ServerTimeEstimater;
import com.youku.live.messagechannel.utils.UTEvent;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.a;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class MCMessageProcessor implements Closeable {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = MCMessageProcessor.class.getName();
    private static MCMessageProcessor mcMessageProcessor = new MCMessageProcessor();
    String callbackWaitTime;
    private String closeMemCacheSwitch;
    private LRUQueue<String> dispatchedMsgIds4HighDiscard = new LRUQueue<>(Integer.valueOf(this.maxMemCacheCount).intValue());
    private LRUQueue<String> dispatchedMsgIds4LowDiscard;
    String maxMemCacheCount;
    private MCMessageStream<MCMessage> mcMessageDownstream;
    private Disposable mcMessageDownstreamDisposable;

    /* compiled from: Taobao */
    public class MarkMessageReportTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        CountDownLatch countDownLatch;
        long dispatchTime;
        MCMessage mcMessage;

        public MarkMessageReportTask(MCMessage mCMessage, CountDownLatch countDownLatch2, long j) {
            this.mcMessage = mCMessage;
            this.countDownLatch = countDownLatch2;
            this.dispatchTime = j;
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1784278482")) {
                ipChange.ipc$dispatch("-1784278482", new Object[]{this});
                return;
            }
            try {
                this.countDownLatch.await((long) Integer.valueOf(MCMessageProcessor.this.callbackWaitTime).intValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                MyLog.e(MCMessageProcessor.TAG, "MarkMessage report countDownLatch interruptedException.", e);
            }
            long estimateServerTimestamp = ServerTimeEstimater.estimateServerTimestamp();
            MCMarkMessageManager.getInstance().storeMarkMessage(new MCMarkMessage(this.dispatchTime, estimateServerTimestamp, this.mcMessage, estimateServerTimestamp - this.dispatchTime >= ((long) Integer.valueOf(MCMessageProcessor.this.callbackWaitTime).intValue())));
        }
    }

    private MCMessageProcessor() {
        OrangeConfig instance = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.maxMemCacheCount;
        this.maxMemCacheCount = instance.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig instance2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.callbackWaitTime;
        this.callbackWaitTime = instance2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        this.dispatchedMsgIds4LowDiscard = new LRUQueue<>(Integer.valueOf(this.maxMemCacheCount).intValue());
        this.mcMessageDownstream = new MCMessageStream<>();
        OrangeConfig instance3 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo3 = OrangeConfKey.closeMemCache;
        this.closeMemCacheSwitch = instance3.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo3.name, keyInfo3.def);
        this.mcMessageDownstreamDisposable = this.mcMessageDownstream.getObservable().subscribeOn(a.a()).filter(new Predicate<MCMessage>() {
            /* class com.youku.live.messagechannel.message.MCMessageProcessor.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean test(MCMessage mCMessage) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1711574658")) {
                    return ((Boolean) ipChange.ipc$dispatch("1711574658", new Object[]{this, mCMessage})).booleanValue();
                } else if (mCMessage == null) {
                    return false;
                } else {
                    if (MCMessageProcessor.this.deDuplicationProcess(mCMessage)) {
                        if (QoS.isLow(mCMessage.qos) || QoS.isMedium(mCMessage.qos)) {
                            MyLog.v(MCMessageProcessor.TAG, "DispatchedMsgIds4LowDiscard size:", Integer.valueOf(MCMessageProcessor.this.dispatchedMsgIds4LowDiscard.size()));
                        } else {
                            MyLog.v(MCMessageProcessor.TAG, "DispatchedMsgIds4HighDiscard size:", Integer.valueOf(MCMessageProcessor.this.dispatchedMsgIds4HighDiscard.size()));
                        }
                        MyLog.v(MCMessageProcessor.TAG, "Message is duplicate, message:", mCMessage);
                        return false;
                    } else if (MCMessageProcessor.this.isExpired(mCMessage)) {
                        MyLog.v(MCMessageProcessor.TAG, "Message is expired, message:", mCMessage);
                        return false;
                    } else if (!MCMessageProcessor.this.specialMessageProcess(mCMessage)) {
                        return true;
                    } else {
                        MyLog.v(MCMessageProcessor.TAG, "Message is special message, message:", mCMessage);
                        return false;
                    }
                }
            }
        }).subscribe(new Consumer<MCMessage>() {
            /* class com.youku.live.messagechannel.message.MCMessageProcessor.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void accept(MCMessage mCMessage) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1809466603")) {
                    ipChange.ipc$dispatch("-1809466603", new Object[]{this, mCMessage});
                    return;
                }
                MyLog.v(MCMessageProcessor.TAG, "Message dispatch consume, message:", mCMessage.toString());
                Map<String, IMCDispatchMsgCallback> dispatcher = MCMessageDispatcher.getDispatcher(mCMessage.appId);
                if (dispatcher != null) {
                    IMCDispatchMsgCallback iMCDispatchMsgCallback = dispatcher.get(mCMessage.channelId);
                    if (iMCDispatchMsgCallback != null) {
                        long estimateServerTimestamp = ServerTimeEstimater.estimateServerTimestamp();
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        MCThreadPool.markMsgStore.execute(new MarkMessageReportTask(mCMessage, countDownLatch, estimateServerTimestamp));
                        try {
                            iMCDispatchMsgCallback.onDispatch(mCMessage);
                            MyLog.v(MCMessageProcessor.TAG, "Message dispatch success, message:", mCMessage.toString());
                            countDownLatch.countDown();
                            MCMessageReporter.getInstance().reportMessages(new MCMessageDispatch4UTRecord(mCMessage.appId, mCMessage.channelId, mCMessage.connectionSource.name(), mCMessage.msgId, mCMessage.msgType, mCMessage.qos, mCMessage.sendTime, mCMessage.expireTime, mCMessage.statMark, estimateServerTimestamp, ServerTimeEstimater.estimateServerTimestamp(), MCHeartbeat.getDeviceOnlineTimeInChannel(mCMessage.appId, mCMessage.channelId)));
                        } catch (Exception e) {
                            String str = MCMessageProcessor.TAG;
                            MyLog.e(str, "Message dispatch fail, message:" + mCMessage.toString(), e);
                            MCMessageReporter.getInstance().reportErrorMessages(mCMessage);
                        }
                    } else {
                        MyLog.w(MCMessageProcessor.TAG, "Message dispatch fail cause of channel callback not exist, message:", mCMessage.toString());
                    }
                } else {
                    MyLog.w(MCMessageProcessor.TAG, "Message dispatch fail cause of appId not exist, message:", mCMessage.toString());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean deDuplicationProcess(@NonNull MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548844736")) {
            return ((Boolean) ipChange.ipc$dispatch("548844736", new Object[]{this, mCMessage})).booleanValue();
        } else if (!"0".equals(this.closeMemCacheSwitch)) {
            return false;
        } else {
            if (TextUtils.isEmpty(mCMessage.qos) || (!QoS.isLow(mCMessage.qos) && !QoS.isMedium(mCMessage.qos))) {
                return this.dispatchedMsgIds4HighDiscard.add(mCMessage.msgId);
            }
            return this.dispatchedMsgIds4LowDiscard.add(mCMessage.msgId);
        }
    }

    public static MCMessageProcessor getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815637317")) {
            return (MCMessageProcessor) ipChange.ipc$dispatch("-815637317", new Object[0]);
        }
        if (!mcMessageProcessor.isAvailable()) {
            synchronized (MCMessageProcessor.class) {
                if (!mcMessageProcessor.isAvailable()) {
                    mcMessageProcessor = new MCMessageProcessor();
                    HashMap hashMap = new HashMap(8);
                    hashMap.put("event", "newInstance");
                    UTEvent.record("msgProcessor", hashMap);
                    MyLog.w(TAG, "MCMessageProcessor is not available, create new instance.");
                }
            }
        }
        return mcMessageProcessor;
    }

    private boolean isAvailable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200681997")) {
            return ((Boolean) ipChange.ipc$dispatch("200681997", new Object[]{this})).booleanValue();
        }
        boolean isDisposed = this.mcMessageDownstreamDisposable.isDisposed();
        if (!isDisposed) {
            return true;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put("event", "isNotAvailable");
        hashMap.put("downStreamDisposable", String.valueOf(isDisposed));
        UTEvent.record("msgProcessor", hashMap);
        MyLog.w(TAG, "MCMessageProcessor is not available, downStreamDisposable: ", Boolean.valueOf(isDisposed));
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isExpired(@NonNull MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885075693")) {
            return ((Boolean) ipChange.ipc$dispatch("-885075693", new Object[]{this, mCMessage})).booleanValue();
        }
        int i = mCMessage.expireTime;
        return i > 0 && mCMessage.sendTime + ((long) (i * 1000)) < ServerTimeEstimater.estimateServerTimestamp();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean specialMessageProcess(@NonNull MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027903623")) {
            return ((Boolean) ipChange.ipc$dispatch("-2027903623", new Object[]{this, mCMessage})).booleanValue();
        } else if (!MCSystemMessageProcessor.getInstance().isSystemMessage(mCMessage)) {
            return false;
        } else {
            MCSystemMessageProcessor.getInstance().process(mCMessage);
            return true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742136720")) {
            ipChange.ipc$dispatch("-742136720", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put("event", "close");
        UTEvent.record("msgProcessor", hashMap);
    }

    public void process(List<MCMessage> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1056586038")) {
            ipChange.ipc$dispatch("-1056586038", new Object[]{this, list});
            return;
        }
        d.fromIterable(list).subscribe(this.mcMessageDownstream);
    }
}
