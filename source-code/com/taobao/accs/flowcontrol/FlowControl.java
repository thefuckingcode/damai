package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;
    private static final String TAG = "FlowControl";
    private Context mContext;
    private FlowCtrlInfoHolder mFlowCtrlHolder;

    /* compiled from: Taobao */
    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i, long j, long j2, long j3) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i;
            this.delayTime = j;
            this.expireTime = j2 <= 0 ? 0 : j2;
            this.startTime = j3 <= 0 ? 0 : j3;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    /* compiled from: Taobao */
    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + JSMethod.NOT_SET + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + JSMethod.NOT_SET + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.mContext = context;
    }

    private void checkFlowCtrl() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.mFlowCtrlHolder;
        if (flowCtrlInfoHolder != null && flowCtrlInfoHolder.flowCtrlMap != null) {
            synchronized (this) {
                Iterator<Map.Entry<String, FlowControlInfo>> it = this.mFlowCtrlHolder.flowCtrlMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().isExpired()) {
                        it.remove();
                    }
                }
            }
        }
    }

    private boolean checkFlowCtrlInfo(long j, long j2) {
        if (j != 0 && j2 > 0) {
            return true;
        }
        ALog.e(TAG, "error flow ctrl info", new Object[0]);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    public long getFlowCtrlDelay(String str, String str2) {
        long j;
        long j2;
        long j3;
        long j4;
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.mFlowCtrlHolder;
        long j5 = 0;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (this) {
            FlowControlInfo flowControlInfo = this.mFlowCtrlHolder.get("ALL", null);
            FlowControlInfo flowControlInfo2 = this.mFlowCtrlHolder.get(SERVICE_ALL_BRUSH, null);
            FlowControlInfo flowControlInfo3 = this.mFlowCtrlHolder.get(str, null);
            FlowControlInfo flowControlInfo4 = this.mFlowCtrlHolder.get(str, str2);
            if (flowControlInfo != null) {
                if (!flowControlInfo.isExpired()) {
                    j = flowControlInfo.delayTime;
                    if (flowControlInfo2 != null) {
                        if (!flowControlInfo2.isExpired()) {
                            j2 = flowControlInfo2.delayTime;
                            if (flowControlInfo3 != null) {
                                if (!flowControlInfo3.isExpired()) {
                                    j3 = flowControlInfo3.delayTime;
                                    if (flowControlInfo4 != null) {
                                        if (!flowControlInfo4.isExpired()) {
                                            j5 = flowControlInfo4.delayTime;
                                        }
                                    }
                                    j4 = -1;
                                    if (!(j == -1 || j5 == -1)) {
                                        if (j3 == -1) {
                                            if (j2 == -1) {
                                                j4 = -1000;
                                            } else {
                                                long j6 = j > j5 ? j : j5;
                                                j4 = j6 > j3 ? j6 : j3;
                                            }
                                        }
                                    }
                                    if ((flowControlInfo4 != null && flowControlInfo4.isExpired()) || (flowControlInfo != null && flowControlInfo.isExpired())) {
                                        checkFlowCtrl();
                                    }
                                }
                            }
                            j3 = 0;
                            if (flowControlInfo4 != null) {
                            }
                            j4 = -1;
                            if (j3 == -1) {
                            }
                            checkFlowCtrl();
                        }
                    }
                    j2 = 0;
                    if (flowControlInfo3 != null) {
                    }
                    j3 = 0;
                    if (flowControlInfo4 != null) {
                    }
                    j4 = -1;
                    if (j3 == -1) {
                    }
                    checkFlowCtrl();
                }
            }
            j = 0;
            if (flowControlInfo2 != null) {
            }
            j2 = 0;
            if (flowControlInfo3 != null) {
            }
            j3 = 0;
            if (flowControlInfo4 != null) {
            }
            j4 = -1;
            if (j3 == -1) {
            }
            checkFlowCtrl();
        }
        ALog.e(TAG, "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j4 + " global:" + j + " serviceDelay:" + j3 + " bidDelay:" + j5, new Object[0]);
        return j4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011a, code lost:
        r13 = r19;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fd A[Catch:{ all -> 0x011d, all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0142 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0144  */
    public int updateFlowCtrlInfo(Map<Integer, String> map, String str) {
        long j;
        int i;
        int i2;
        Throwable th;
        long j2;
        FlowControlInfo flowControlInfo;
        if (map != null) {
            try {
                String str2 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_STATUS.ordinal()));
                String str3 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_DELAY.ordinal()));
                String str4 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_EXPIRE.ordinal()));
                String str5 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()));
                i = TextUtils.isEmpty(str2) ? 0 : Integer.valueOf(str2).intValue();
                try {
                    j = TextUtils.isEmpty(str3) ? 0 : Long.valueOf(str3).longValue();
                    try {
                        long longValue = TextUtils.isEmpty(str4) ? 0 : Long.valueOf(str4).longValue();
                        if ((i != 420 && i != 421 && i != 422) || !checkFlowCtrlInfo(j, longValue)) {
                            return 0;
                        }
                        synchronized (this) {
                            try {
                                if (this.mFlowCtrlHolder == null) {
                                    this.mFlowCtrlHolder = new FlowCtrlInfoHolder();
                                }
                                FlowControlInfo flowControlInfo2 = null;
                                if (i == 420) {
                                    j2 = j;
                                    flowControlInfo = new FlowControlInfo("ALL", "", i, j, longValue, System.currentTimeMillis());
                                    this.mFlowCtrlHolder.put("ALL", "", flowControlInfo);
                                } else {
                                    j2 = j;
                                    if (i == 422) {
                                        flowControlInfo = new FlowControlInfo(SERVICE_ALL_BRUSH, "", i, j2, longValue, System.currentTimeMillis());
                                        this.mFlowCtrlHolder.put(SERVICE_ALL_BRUSH, "", flowControlInfo);
                                    } else {
                                        if (i == 421 && !TextUtils.isEmpty(str)) {
                                            FlowControlInfo flowControlInfo3 = new FlowControlInfo(str, str5, i, j2, longValue, System.currentTimeMillis());
                                            this.mFlowCtrlHolder.put(str, str5, flowControlInfo3);
                                            flowControlInfo2 = flowControlInfo3;
                                        }
                                        if (flowControlInfo2 != null) {
                                            ALog.e(TAG, "updateFlowCtrlInfo " + flowControlInfo2.toString(), new Object[0]);
                                        }
                                    }
                                }
                                flowControlInfo2 = flowControlInfo;
                                if (flowControlInfo2 != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.e(TAG, "updateFlowCtrlInfo", th, new Object[0]);
                        i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                        if (i2 <= 0) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    j = 0;
                    ALog.e(TAG, "updateFlowCtrlInfo", th, new Object[0]);
                    i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i2 <= 0) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                j = 0;
                i = 0;
                ALog.e(TAG, "updateFlowCtrlInfo", th, new Object[0]);
                i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i2 <= 0) {
                }
            }
        } else {
            j = 0;
            i = 0;
        }
        i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 <= 0) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return 422 == i ? 3 : 2;
    }
}
