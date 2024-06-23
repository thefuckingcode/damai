package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.aranger.exception.IPCException;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class AccsHandler {
    public static final String TAG = "AccsHandler";
    private static Handler handler = new Handler(Looper.getMainLooper());

    private static void exeCallback(String str, Runnable runnable) {
        if (Constants.IMPAAS.equals(str) || GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private static Map<TaoBaseService.ExtHeaderType, String> getExtHeader(Map<Integer, String> map) {
        Exception e;
        HashMap hashMap = null;
        if (map == null) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            try {
                TaoBaseService.ExtHeaderType[] values = TaoBaseService.ExtHeaderType.values();
                for (TaoBaseService.ExtHeaderType extHeaderType : values) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        hashMap2.put(extHeaderType, str);
                    }
                }
                return hashMap2;
            } catch (Exception e2) {
                e = e2;
                hashMap = hashMap2;
                ALog.e(TAG, "getExtHeader", e, new Object[0]);
                return hashMap;
            }
        } catch (Exception e3) {
            e = e3;
            ALog.e(TAG, "getExtHeader", e, new Object[0]);
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    public static TaoBaseService.ExtraInfo getExtraInfo(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> extHeader = getExtHeader(hashMap);
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra("host");
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = extHeader;
            extraInfo.oriExtHeader = hashMap;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    public static NetPerformanceMonitor getPref(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable("monitor");
        } catch (Exception e) {
            ALog.e(TAG, "get NetPerformanceMonitor Error:", e, new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isPrintLog(String str) {
        return ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x026f A[Catch:{ Exception -> 0x027c }] */
    public static int onReceiveData(Context context, final Intent intent, final AccsDataListener accsDataListener) {
        String str;
        Exception e;
        String str2;
        String str3 = "1";
        if (accsDataListener == null || context == null) {
            ALog.e(TAG, "onReceiveData listener or context null", new Object[0]);
            return 2;
        } else if (intent == null) {
            return 2;
        } else {
            try {
                final int intExtra = intent.getIntExtra("command", -1);
                final int intExtra2 = intent.getIntExtra("errorCode", 0);
                final String stringExtra = intent.getStringExtra(Constants.KEY_USER_ID);
                final String stringExtra2 = intent.getStringExtra(Constants.KEY_DATA_ID);
                final String stringExtra3 = intent.getStringExtra("serviceId");
                if (!ALog.isPrintLog(ALog.Level.I)) {
                    try {
                        if (!Constants.IMPAAS.equals(stringExtra3)) {
                            str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                            if (intExtra <= 0) {
                                UTMini.getInstance().commitEvent(66001, "MsgToBuss5", "commandId=" + intExtra, "serviceId=" + stringExtra3 + " dataId=" + stringExtra2, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, "3commandId=" + intExtra + "serviceId=" + stringExtra3, 0.0d);
                                if (intExtra == 5) {
                                    exeCallback(stringExtra3, new Runnable() {
                                        /* class com.taobao.accs.utl.AccsHandler.AnonymousClass1 */

                                        public void run() {
                                            try {
                                                accsDataListener.onBind(stringExtra3, intExtra2, AccsHandler.getExtraInfo(intent));
                                            } catch (IPCException e) {
                                                ALog.e(AccsHandler.TAG, "onReceiveData onBind", e, new Object[0]);
                                            }
                                        }
                                    });
                                    return 2;
                                } else if (intExtra == 6) {
                                    exeCallback(stringExtra3, new Runnable() {
                                        /* class com.taobao.accs.utl.AccsHandler.AnonymousClass2 */

                                        public void run() {
                                            try {
                                                accsDataListener.onUnbind(stringExtra3, intExtra2, AccsHandler.getExtraInfo(intent));
                                            } catch (IPCException e) {
                                                ALog.e(AccsHandler.TAG, "onReceiveData onUnbind", e, new Object[0]);
                                            }
                                        }
                                    });
                                    return 2;
                                } else if (intExtra != 100) {
                                    if (intExtra == 101) {
                                        final byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                                        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                                        if (byteArrayExtra != null) {
                                            if (isPrintLog(stringExtra3)) {
                                                ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA onData dataId:" + stringExtra2 + " serviceId:" + stringExtra3, new Object[0]);
                                            }
                                            final TaoBaseService.ExtraInfo extraInfo = getExtraInfo(intent);
                                            if (booleanExtra) {
                                                ALog.i(TAG, "onReceiveData try to send biz ack dataId " + stringExtra2, new Object[0]);
                                                sendBusinessAck(context, intent, stringExtra2, extraInfo.oriExtHeader);
                                            }
                                            try {
                                                intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                                            } catch (Exception e2) {
                                                ALog.e(TAG, "get NetPerformanceMonitor Error:", e2, new Object[0]);
                                            }
                                            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS_SUCCESS, "1commandId=101serviceId=" + stringExtra3, 0.0d);
                                            exeCallback(stringExtra3, new Runnable() {
                                                /* class com.taobao.accs.utl.AccsHandler.AnonymousClass3 */

                                                public void run() {
                                                    try {
                                                        if (AccsHandler.isPrintLog(stringExtra3)) {
                                                            ALog.e(AccsHandler.TAG, "onData start", Constants.KEY_DATA_ID, stringExtra2, "serviceId", stringExtra3, "command", Integer.valueOf(intExtra), PushClientConstants.TAG_CLASS_NAME, accsDataListener.getClass().getName());
                                                        }
                                                        accsDataListener.onData(stringExtra3, stringExtra, stringExtra2, byteArrayExtra, extraInfo);
                                                        if (AccsHandler.isPrintLog(stringExtra3)) {
                                                            ALog.e(AccsHandler.TAG, "onData end", Constants.KEY_DATA_ID, stringExtra2);
                                                        }
                                                    } catch (IPCException e) {
                                                        ALog.e(AccsHandler.TAG, "onReceiveData onData", e, new Object[0]);
                                                    }
                                                }
                                            });
                                            return 2;
                                        }
                                        ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA msg null", new Object[0]);
                                        str3 = str3;
                                        str = str2;
                                        try {
                                            AppMonitorAdapter.commitAlarmFail("accs", str, stringExtra3, str3, "COMMAND_RECEIVE_DATA msg null");
                                            return 2;
                                        } catch (Exception e3) {
                                            e = e3;
                                            AppMonitorAdapter.commitAlarmFail("accs", str, "", str3, "callback error" + e.toString());
                                            ALog.e(TAG, "onReceiveData", e, new Object[0]);
                                            return 2;
                                        }
                                    } else if (intExtra == 103) {
                                        boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                        final String stringExtra4 = intent.getStringExtra("host");
                                        final String stringExtra5 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                                        final boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                        final boolean booleanExtra4 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                        if (TextUtils.isEmpty(stringExtra4)) {
                                            return 2;
                                        }
                                        if (booleanExtra2) {
                                            exeCallback(stringExtra3, new Runnable() {
                                                /* class com.taobao.accs.utl.AccsHandler.AnonymousClass7 */

                                                public void run() {
                                                    try {
                                                        accsDataListener.onConnected(new TaoBaseService.ConnectInfo(stringExtra4, booleanExtra3, booleanExtra4));
                                                    } catch (IPCException e) {
                                                        ALog.e(AccsHandler.TAG, "onReceiveData onConnected", e, new Object[0]);
                                                    }
                                                }
                                            });
                                            return 2;
                                        }
                                        exeCallback(stringExtra3, new Runnable() {
                                            /* class com.taobao.accs.utl.AccsHandler.AnonymousClass8 */

                                            public void run() {
                                                try {
                                                    accsDataListener.onDisconnected(new TaoBaseService.ConnectInfo(stringExtra4, booleanExtra3, booleanExtra4, intExtra2, stringExtra5));
                                                } catch (IPCException e) {
                                                    ALog.e(AccsHandler.TAG, "onReceiveData onDisconnected", e, new Object[0]);
                                                }
                                            }
                                        });
                                        return 2;
                                    } else if (intExtra != 104) {
                                        ALog.w(TAG, "onReceiveData command not handled", new Object[0]);
                                        return 2;
                                    } else {
                                        final boolean booleanExtra5 = intent.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                        ALog.e(TAG, "onReceiveData anti brush result:" + booleanExtra5, new Object[0]);
                                        exeCallback(stringExtra3, new Runnable() {
                                            /* class com.taobao.accs.utl.AccsHandler.AnonymousClass6 */

                                            public void run() {
                                                try {
                                                    accsDataListener.onAntiBrush(booleanExtra5, null);
                                                } catch (IPCException e) {
                                                    ALog.e(AccsHandler.TAG, "onReceiveData onAntiBrush", e, new Object[0]);
                                                }
                                            }
                                        });
                                        return 2;
                                    }
                                } else if (TextUtils.equals("res", intent.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                    final byte[] byteArrayExtra2 = intent.getByteArrayExtra("data");
                                    exeCallback(stringExtra3, new Runnable() {
                                        /* class com.taobao.accs.utl.AccsHandler.AnonymousClass4 */

                                        public void run() {
                                            try {
                                                if (AccsHandler.isPrintLog(stringExtra3)) {
                                                    String str = AccsHandler.TAG;
                                                    ALog.e(str, "onResponse start dataId:" + stringExtra2 + " serviceId:" + stringExtra3, new Object[0]);
                                                }
                                                accsDataListener.onResponse(stringExtra3, stringExtra2, intExtra2, byteArrayExtra2, AccsHandler.getExtraInfo(intent));
                                                if (AccsHandler.isPrintLog(stringExtra3)) {
                                                    String str2 = AccsHandler.TAG;
                                                    ALog.e(str2, "onResponse end dataId:" + stringExtra2, new Object[0]);
                                                }
                                            } catch (IPCException e) {
                                                ALog.e(AccsHandler.TAG, "onReceiveData onResponse", e, new Object[0]);
                                            }
                                        }
                                    });
                                    return 2;
                                } else {
                                    exeCallback(stringExtra3, new Runnable() {
                                        /* class com.taobao.accs.utl.AccsHandler.AnonymousClass5 */

                                        public void run() {
                                            try {
                                                if (AccsHandler.isPrintLog(stringExtra3)) {
                                                    String str = AccsHandler.TAG;
                                                    ALog.e(str, "onSendData start dataId:" + stringExtra2 + " serviceId:" + stringExtra3, new Object[0]);
                                                }
                                                accsDataListener.onSendData(stringExtra3, stringExtra2, intExtra2, AccsHandler.getExtraInfo(intent));
                                                if (AccsHandler.isPrintLog(stringExtra3)) {
                                                    String str2 = AccsHandler.TAG;
                                                    ALog.e(str2, "onSendData end dataId:" + stringExtra2, new Object[0]);
                                                }
                                            } catch (IPCException e) {
                                                ALog.e(AccsHandler.TAG, "onReceiveData onSendData", e, new Object[0]);
                                            }
                                        }
                                    });
                                    return 2;
                                }
                            } else {
                                ALog.w(TAG, "onReceiveData command not handled", new Object[0]);
                                return 2;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str = BaseMonitor.ALARM_POINT_REQ_ERROR;
                        str3 = str3;
                        AppMonitorAdapter.commitAlarmFail("accs", str, "", str3, "callback error" + e.toString());
                        ALog.e(TAG, "onReceiveData", e, new Object[0]);
                        return 2;
                    }
                }
                String str4 = TAG;
                str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                try {
                    ALog.e(str4, "onReceiveData", Constants.KEY_DATA_ID, stringExtra2, "serviceId", stringExtra3, "command", Integer.valueOf(intExtra), PushClientConstants.TAG_CLASS_NAME, accsDataListener.getClass().getName());
                    if (intExtra <= 0) {
                    }
                } catch (Exception e5) {
                    e = e5;
                    str3 = str3;
                    str = str2;
                    AppMonitorAdapter.commitAlarmFail("accs", str, "", str3, "callback error" + e.toString());
                    ALog.e(TAG, "onReceiveData", e, new Object[0]);
                    return 2;
                }
            } catch (Exception e6) {
                e = e6;
                str = BaseMonitor.ALARM_POINT_REQ_ERROR;
                AppMonitorAdapter.commitAlarmFail("accs", str, "", str3, "callback error" + e.toString());
                ALog.e(TAG, "onReceiveData", e, new Object[0]);
                return 2;
            }
        }
    }

    private static void sendBusinessAck(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra("host");
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra("target");
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, 0);
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.sendBusinessAck(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                    return;
                }
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
