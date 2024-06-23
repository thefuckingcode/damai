package com.youku.live.messagechannel.report;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.message.MCSysMessageName;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
public class MCMarkMessageManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String APP_MONITOR_MODULE_NAME = "MessageChannel";
    private static final String CHARACTER_CONNECTOR = "_";
    private static final String TAG = "com.youku.live.messagechannel.report.MCMarkMessageManager";
    private static MCMarkMessageManager mcMarkMessageManager = new MCMarkMessageManager();
    private String closeAppMonitorStoreMarkMessageOverflowReport;
    private Map<String, MCMarkMessage> lastDispatchSysProbe = new ConcurrentHashMap();
    private Map<String, ConcurrentLinkedQueue<MCMarkMessage>> reportDispatchMarkMessages = new ConcurrentHashMap();
    private String reportMarkMessageCount;
    private String storeMarkMessageCount;

    private MCMarkMessageManager() {
        OrangeConfig instance = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.storeMarkMessageCount;
        this.storeMarkMessageCount = instance.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig instance2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.reportMarkMessageCount;
        this.reportMarkMessageCount = instance2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        OrangeConfig instance3 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo3 = OrangeConfKey.closeAppMonitorStoreMarkMessageOverflowReport;
        this.closeAppMonitorStoreMarkMessageOverflowReport = instance3.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo3.name, keyInfo3.def);
    }

    public static MCMarkMessageManager getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1163880781") ? (MCMarkMessageManager) ipChange.ipc$dispatch("-1163880781", new Object[0]) : mcMarkMessageManager;
    }

    private static String getMarkMessageCacheKey(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199067250")) {
            return (String) ipChange.ipc$dispatch("-199067250", new Object[]{Long.valueOf(j), str});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j);
        stringBuffer.append("_");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static String getSysProbeCacheKey(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754980681")) {
            return (String) ipChange.ipc$dispatch("754980681", new Object[]{Long.valueOf(j), str});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j);
        stringBuffer.append("_");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public void clearStoredMarkMessages(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529809578")) {
            ipChange.ipc$dispatch("529809578", new Object[]{this, Long.valueOf(j), str});
            return;
        }
        this.lastDispatchSysProbe.remove(getSysProbeCacheKey(j, str));
        this.reportDispatchMarkMessages.remove(getMarkMessageCacheKey(j, str));
    }

    public MCMarkMessage getCurrentSysProbe(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1125730337")) {
            return (MCMarkMessage) ipChange.ipc$dispatch("1125730337", new Object[]{this, Long.valueOf(j), str});
        }
        return this.lastDispatchSysProbe.remove(getSysProbeCacheKey(j, str));
    }

    public List<MCMarkMessage> getStoredMarkMessages(long j, String str) {
        MCMarkMessage poll;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073999564")) {
            return (List) ipChange.ipc$dispatch("-2073999564", new Object[]{this, Long.valueOf(j), str});
        }
        String markMessageCacheKey = getMarkMessageCacheKey(j, str);
        ArrayList arrayList = new ArrayList(Integer.valueOf(this.reportMarkMessageCount).intValue());
        ConcurrentLinkedQueue<MCMarkMessage> concurrentLinkedQueue = this.reportDispatchMarkMessages.get(markMessageCacheKey);
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
            for (int i = 0; i < Integer.valueOf(this.reportMarkMessageCount).intValue() && (poll = concurrentLinkedQueue.poll()) != null; i++) {
                arrayList.add(poll);
            }
        }
        return arrayList;
    }

    public boolean isMarkMessage(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1193980221")) {
            return ((Boolean) ipChange.ipc$dispatch("-1193980221", new Object[]{this, mCMessage})).booleanValue();
        } else if (mCMessage != null) {
            return MCSysMessageName.SYS_PROBE.getName().equals(mCMessage.msgType) || mCMessage.statMark;
        } else {
            return false;
        }
    }

    public void storeMarkMessage(MCMarkMessage mCMarkMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592805594")) {
            ipChange.ipc$dispatch("-592805594", new Object[]{this, mCMarkMessage});
        } else if (mCMarkMessage != null && mCMarkMessage.mcMessage != null) {
            if (MCSysMessageName.SYS_PROBE.getName().equals(mCMarkMessage.mcMessage.msgType)) {
                MCMessage mCMessage = mCMarkMessage.mcMessage;
                String sysProbeCacheKey = getSysProbeCacheKey(mCMessage.appId, mCMessage.channelId);
                MCMarkMessage mCMarkMessage2 = this.lastDispatchSysProbe.get(sysProbeCacheKey);
                if (mCMarkMessage2 == null || mCMarkMessage2.mcMessage.sendTime < mCMarkMessage.mcMessage.sendTime) {
                    this.lastDispatchSysProbe.put(sysProbeCacheKey, mCMarkMessage);
                    MyLog.d(TAG, "Lasted sys_probe update, mcMarkMessage:", mCMarkMessage);
                    return;
                }
                return;
            }
            MCMessage mCMessage2 = mCMarkMessage.mcMessage;
            if (mCMessage2.statMark) {
                String markMessageCacheKey = getMarkMessageCacheKey(mCMessage2.appId, mCMessage2.channelId);
                ConcurrentLinkedQueue<MCMarkMessage> concurrentLinkedQueue = this.reportDispatchMarkMessages.get(markMessageCacheKey);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    this.reportDispatchMarkMessages.put(markMessageCacheKey, concurrentLinkedQueue);
                }
                int intValue = Integer.valueOf(this.storeMarkMessageCount).intValue();
                if (concurrentLinkedQueue.size() < intValue) {
                    concurrentLinkedQueue.offer(mCMarkMessage);
                } else if ("0".equals(this.closeAppMonitorStoreMarkMessageOverflowReport)) {
                    StringBuffer stringBuffer = new StringBuffer("current:");
                    stringBuffer.append(concurrentLinkedQueue.size());
                    stringBuffer.append(",max:");
                    stringBuffer.append(intValue);
                    AppMonitor.Alarm.commitFail(APP_MONITOR_MODULE_NAME, "storeMarkMessageCount", "overFlow", stringBuffer.toString());
                }
            }
        }
    }
}
