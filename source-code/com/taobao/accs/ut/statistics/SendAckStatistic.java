package com.taobao.accs.ut.statistics;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* compiled from: Taobao */
public class SendAckStatistic implements UTInterface {
    private static final String TAG = "accs.SendAckStatistic";
    private final String PAGE_NAME = "sendAck";
    public String dataId;
    public String deviceId;
    public String failReason;
    private boolean isCommitted = false;
    public String sendTime;
    public String serviceId;
    public String sessionId;

    @Override // com.taobao.accs.ut.statistics.UTInterface
    public void commitUT() {
        String str;
        String str2;
        Throwable th;
        if (!this.isCommitted) {
            this.isCommitted = true;
            HashMap hashMap = new HashMap();
            try {
                str2 = this.deviceId;
                try {
                    str = String.valueOf((int) Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put(PushConstants.DEVICE_ID, this.deviceId);
                        hashMap.put("session_id", this.sessionId);
                        hashMap.put("data_id", this.dataId);
                        hashMap.put("ack_date", this.sendTime);
                        hashMap.put("service_id", this.serviceId);
                        hashMap.put("fail_reasons", this.failReason);
                        UTMini.getInstance().commitEvent(66001, "sendAck", str2, (Object) null, str, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = null;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str2, (String) null, str, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = null;
                str = null;
                ALog.d(TAG, UTMini.getCommitInfo(66001, str2, (String) null, str, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
