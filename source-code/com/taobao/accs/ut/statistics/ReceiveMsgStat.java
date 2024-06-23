package com.taobao.accs.ut.statistics;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.weex.common.Constants;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.HashMap;

/* compiled from: Taobao */
public class ReceiveMsgStat implements UTInterface {
    private static final String TAG = "ReceiveMessage";
    private final String PAGE_NAME = "receiveMessage";
    public String dataId;
    public String dataLen;
    public String deviceId;
    private boolean isCommitted = false;
    public String messageType;
    public String receiveDate;
    public boolean repeat = false;
    public String serviceId;
    public String toBzDate;
    public String userId;

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
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str2, (String) null, str, hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    hashMap.put(PushConstants.DEVICE_ID, this.deviceId);
                    hashMap.put("data_id", this.dataId);
                    hashMap.put("receive_date", this.receiveDate);
                    hashMap.put("to_bz_date", this.toBzDate);
                    hashMap.put("service_id", this.serviceId);
                    hashMap.put("data_length", this.dataLen);
                    hashMap.put("msg_type", this.messageType);
                    hashMap.put("repeat", this.repeat ? Constants.Name.Y : "n");
                    hashMap.put(UTDataCollectorNodeColumn.USER_ID, this.userId);
                    UTMini.getInstance().commitEvent(66001, "receiveMessage", str2, (Object) null, str, hashMap);
                } catch (Throwable th3) {
                    th = th3;
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
