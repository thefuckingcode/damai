package com.taobao.accs.ut.statistics;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class MonitorStatistic implements UTInterface {
    private static final long COMMIT_INTERVAL = 1200000;
    private static final String PAGE = "MONITOR";
    private static final String TAG = "MonitorStatistic";
    public int connType;
    private long lastCommitTime = 0;
    public int messageNum = 0;
    public boolean networkAvailable;
    public String proxy;
    public long startServiceTime;
    public int status;
    public boolean tcpConnected = false;
    public boolean threadIsalive;
    public int unHandleMessageNum = 0;
    public String url;

    @Override // com.taobao.accs.ut.statistics.UTInterface
    public void commitUT() {
        String str;
        String str2;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(TAG, "commitUT interval:" + (currentTimeMillis - this.lastCommitTime) + " interval1:" + (currentTimeMillis - this.startServiceTime), new Object[0]);
        }
        if (currentTimeMillis - this.lastCommitTime > COMMIT_INTERVAL && currentTimeMillis - this.startServiceTime > DateUtils.MILLIS_PER_MINUTE) {
            HashMap hashMap = new HashMap();
            String str3 = null;
            try {
                String valueOf = String.valueOf(this.messageNum);
                try {
                    str = String.valueOf(this.unHandleMessageNum);
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                    str = null;
                    str3 = valueOf;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str3, str, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    str2 = String.valueOf((int) Constants.SDK_VERSION_CODE);
                } catch (Throwable th3) {
                    th = th3;
                    str2 = null;
                    str3 = valueOf;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str3, str, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    hashMap.put("connStatus", String.valueOf(this.status));
                    hashMap.put("connType", String.valueOf(this.connType));
                    hashMap.put("tcpConnected", String.valueOf(this.tcpConnected));
                    hashMap.put("proxy", String.valueOf(this.proxy));
                    hashMap.put("startServiceTime", String.valueOf(this.startServiceTime));
                    hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                    hashMap.put("networkAvailable", String.valueOf(this.networkAvailable));
                    hashMap.put("threadIsalive", String.valueOf(this.threadIsalive));
                    hashMap.put("url", this.url);
                    if (ALog.isPrintLog(level)) {
                        try {
                            ALog.d(TAG, UTMini.getCommitInfo(66001, valueOf, str, str2, hashMap), new Object[0]);
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    try {
                        UTMini.getInstance().commitEvent(66001, PAGE, valueOf, str, str2, hashMap);
                        this.lastCommitTime = currentTimeMillis;
                    } catch (Throwable th5) {
                        th = th5;
                        str3 = valueOf;
                        str2 = str2;
                        str = str;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str3 = valueOf;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str3, str, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th7) {
                th = th7;
                str2 = null;
                str = null;
                ALog.d(TAG, UTMini.getCommitInfo(66001, str3, str, str2, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
