package com.taobao.agoo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
public class AgooCommondReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, final Intent intent) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.agoo.AgooCommondReceiver.AnonymousClass1 */

            public void run() {
                try {
                    String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(context.getPackageName());
                    intent.setFlags(0);
                    intent.setClassName(context, agooCustomServiceName);
                    IntentDispatch.dispatchIntent(context, intent);
                } catch (Throwable th) {
                    ALog.e("AgooCommondReceiver", "onReceive error", th, new Object[0]);
                }
            }
        });
    }
}
