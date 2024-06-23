package com.taobao.orange.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.model.ConfigAckDO;
import com.taobao.orange.model.IndexAckDO;
import com.taobao.orange.sync.BaseAuthRequest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.w6;

/* compiled from: Taobao */
public class ReportAckUtils {
    static final int MSG_REPORT_CONFIGACKS = 1;
    static final int MSG_WAIT_CONFIGACKS = 0;
    static final String TAG = "ReportAck";
    private static Handler handler = new ConfigHandler(Looper.getMainLooper());
    static final Set<ConfigAckDO> mConfigAckDOSet = new HashSet();

    /* compiled from: Taobao */
    static class ConfigHandler extends Handler {
        ConfigHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (OLog.isPrintLog(1)) {
                    OLog.d(ReportAckUtils.TAG, "wait config acks", new Object[0]);
                }
                sendEmptyMessageDelayed(1, 30000);
            } else if (i == 1) {
                Set<ConfigAckDO> set = ReportAckUtils.mConfigAckDOSet;
                synchronized (set) {
                    if (OLog.isPrintLog(1)) {
                        OLog.d(ReportAckUtils.TAG, "report config acks", "size", Integer.valueOf(set.size()));
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(set);
                    ReportAckUtils.reportConfigAcks(hashSet);
                    set.clear();
                }
            }
        }
    }

    public static void reportConfigAck(ConfigAckDO configAckDO) {
        w6.b().commitStat(configAckDO);
        if (GlobalOrange.reportUpdateAck && configAckDO != null) {
            Set<ConfigAckDO> set = mConfigAckDOSet;
            synchronized (set) {
                if (set.size() == 0) {
                    handler.sendEmptyMessage(0);
                }
                set.add(configAckDO);
            }
        }
    }

    static void reportConfigAcks(final Set<ConfigAckDO> set) {
        if (GlobalOrange.reportUpdateAck && set.size() != 0) {
            OThreadFactory.execute(new Runnable() {
                /* class com.taobao.orange.util.ReportAckUtils.AnonymousClass1 */

                public void run() {
                    if (GlobalOrange.reportUpdateAck) {
                        new BaseAuthRequest(null, true, OConstant.REQTYPE_ACK_CONFIG_UPDATE) {
                            /* class com.taobao.orange.util.ReportAckUtils.AnonymousClass1.AnonymousClass1 */

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public Map<String, String> getReqParams() {
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public String getReqPostBody() {
                                return JSON.toJSONString(set);
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public Object parseResContent(String str) {
                                return null;
                            }
                        }.syncRequest();
                    }
                }
            }, GlobalOrange.randomDelayAckInterval);
        }
    }

    public static void reportIndexAck(final IndexAckDO indexAckDO) {
        w6.b().commitStat(indexAckDO);
        if (GlobalOrange.reportUpdateAck) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "report index ack", indexAckDO);
            }
            OThreadFactory.execute(new Runnable() {
                /* class com.taobao.orange.util.ReportAckUtils.AnonymousClass2 */

                public void run() {
                    if (GlobalOrange.reportUpdateAck) {
                        new BaseAuthRequest(null, true, OConstant.REQTYPE_ACK_INDEX_UPDATE) {
                            /* class com.taobao.orange.util.ReportAckUtils.AnonymousClass2.AnonymousClass1 */

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public Map<String, String> getReqParams() {
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public String getReqPostBody() {
                                return JSON.toJSONString(indexAckDO);
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public Object parseResContent(String str) {
                                return null;
                            }
                        }.syncRequest();
                    }
                }
            }, GlobalOrange.randomDelayAckInterval);
        }
    }
}
