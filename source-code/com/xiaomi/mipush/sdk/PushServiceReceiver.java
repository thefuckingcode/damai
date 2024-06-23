package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: Taobao */
public class PushServiceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, PushMessageHandler.class);
        intent2.putExtras(intent);
        intent2.setAction(intent.getAction());
        PushMessageHandler.a(context, intent2);
    }
}
