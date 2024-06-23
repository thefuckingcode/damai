package com.ali.user.open.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: Taobao */
public class SessionSyncReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (TextUtils.equals(intent.getAction(), "aliuser_sync_session")) {
                    intent.getStringExtra("from");
                }
            } catch (Throwable unused) {
            }
        }
    }
}
