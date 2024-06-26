package com.taobao.accs.dispatch;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class IntentDispatch {
    public static final String TAG = "IntentDispatch";
    private static final List<String> maybeDisabledService;

    static {
        ArrayList arrayList = new ArrayList();
        maybeDisabledService = arrayList;
        arrayList.add("org.android.agoo.accs.AgooService");
        arrayList.add("com.taobao.taobao.TaobaoIntentService");
        arrayList.add(AdapterUtilityImpl.msgService);
    }

    public static void dispatchIntent(final Context context, final Intent intent) {
        String str;
        String str2;
        if (context == null || intent == null) {
            ALog.e(TAG, "dispatchIntent context or intent is null", new Object[0]);
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            if (intent.getComponent() == null) {
                str = intent.toString();
                str2 = "";
            } else {
                str = intent.getComponent().getClassName();
                str2 = intent.getComponent().getPackageName();
            }
            dynamicEnableService(applicationContext, str2, str);
            if (Utils.isTarget26(applicationContext)) {
                ALog.i(TAG, "dispatchIntent bind service start", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                if (!applicationContext.bindService(intent, new ServiceConnection() {
                    /* class com.taobao.accs.dispatch.IntentDispatch.AnonymousClass1 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        ALog.d(IntentDispatch.TAG, "bindService connected", "componentName", componentName.toString());
                        Messenger messenger = new Messenger(iBinder);
                        Message message = new Message();
                        try {
                            message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                            messenger.send(message);
                            IntentDispatch.saveUnbindService(applicationContext, this);
                            if (!context.getPackageName().equals(componentName.getPackageName())) {
                                return;
                            }
                        } catch (Exception e) {
                            ALog.e(IntentDispatch.TAG, "dispatch intent with exception", e, new Object[0]);
                            IntentDispatch.saveUnbindService(applicationContext, this);
                            if (!context.getPackageName().equals(componentName.getPackageName())) {
                                return;
                            }
                        } catch (Throwable th) {
                            IntentDispatch.saveUnbindService(applicationContext, this);
                            if (context.getPackageName().equals(componentName.getPackageName())) {
                                AppMonitorAdapter.commitAlarmSuccess("accs", "bind", componentName.getClassName());
                            }
                            throw th;
                        }
                        AppMonitorAdapter.commitAlarmSuccess("accs", "bind", componentName.getClassName());
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        ALog.d(IntentDispatch.TAG, "bindService on disconnect", "componentName", componentName.toString());
                        IntentDispatch.saveUnbindService(applicationContext, this);
                        if (context.getPackageName().equals(componentName.getPackageName())) {
                            AppMonitorAdapter.commitAlarmFail("accs", "bind", componentName.getClassName(), UtilityImpl.int2String(-3), "onServiceDisconnected");
                        }
                    }
                }, 1) && context.getPackageName().equals(str2)) {
                    AppMonitorAdapter.commitAlarmFail("accs", "bind", intent.toString(), UtilityImpl.int2String(-2), "dispatchIntent bindService return false");
                    return;
                }
                return;
            }
            ALog.i(TAG, "dispatchIntent start service ", new Object[0]);
            applicationContext.startService(intent);
            if (context.getPackageName().equals(str2)) {
                AppMonitorAdapter.commitAlarmSuccess("accs", "bind", str);
            }
        } catch (Exception e) {
            ALog.e(TAG, "dispatchIntent method call with exception ", e, new Object[0]);
            if (context.getPackageName().equals(null)) {
                AppMonitorAdapter.commitAlarmFail("accs", "bind", intent.toString(), UtilityImpl.int2String(-1), "dispatchIntent method call with exception");
            }
        }
    }

    private static void dynamicEnableService(Context context, String str, String str2) {
        if (!maybeDisabledService.contains(str2)) {
            ALog.i(TAG, "dynamicEnableService, not exist in list", new Object[0]);
            return;
        }
        ALog.i(TAG, "dynamicEnableService start", new Object[0]);
        ComponentName componentName = new ComponentName(str, str2);
        if (!UtilityImpl.getServiceEnabled(context, componentName)) {
            UtilityImpl.enableService(context, componentName);
        }
    }

    /* access modifiers changed from: private */
    public static void saveUnbindService(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable th) {
            ALog.e(TAG, "saveUnbindService err", th, new Object[0]);
        }
    }
}
