package com.taobao.accs.ut.statistics;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.weex.common.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
public class BindAppStatistic implements UTInterface {
    private static final String TAG = "BindAppStatistic";
    private final String PAGE_NAME = "BindApp";
    public String deviceId;
    public String failReason;
    private boolean isCommitted = false;
    public boolean ret;
    public String time;

    private void commit(String str) {
        Throwable th;
        String str2;
        String str3;
        if (!this.isCommitted) {
            this.isCommitted = true;
            HashMap hashMap = new HashMap();
            try {
                str3 = this.deviceId;
                try {
                    str2 = String.valueOf((int) Constants.SDK_VERSION_CODE);
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str3, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    hashMap.put(PushConstants.DEVICE_ID, this.deviceId);
                    hashMap.put("bind_date", this.time);
                    hashMap.put("ret", this.ret ? Constants.Name.Y : "n");
                    hashMap.put("fail_reasons", this.failReason);
                    hashMap.put("push_token", "");
                    UTMini.getInstance().commitEvent(66001, str, str3, (Object) null, str2, hashMap);
                } catch (Throwable th3) {
                    th = th3;
                    ALog.d(TAG, UTMini.getCommitInfo(66001, str3, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                str3 = null;
                str2 = null;
                ALog.d(TAG, UTMini.getCommitInfo(66001, str3, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.ut.statistics.UTInterface
    public void commitUT() {
        commit("BindApp");
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setFailReason(int i) {
        if (i == -4) {
            setFailReason("msg too large");
        } else if (i == -3) {
            setFailReason("service not available");
        } else if (i == -2) {
            setFailReason("param error");
        } else if (i == -1) {
            setFailReason("network fail");
        } else if (i == 200) {
        } else {
            if (i != 300) {
                setFailReason(String.valueOf(i));
            } else {
                setFailReason("app not bind");
            }
        }
    }
}
