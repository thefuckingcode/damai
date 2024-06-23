package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: Taobao */
class co extends Handler {
    final /* synthetic */ XMPushService a;

    co(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            try {
                int i = message.what;
                if (i == 17) {
                    Object obj = message.obj;
                    if (obj != null) {
                        this.a.onStart((Intent) obj, 1);
                    }
                } else if (i == 18) {
                    Message obtain = Message.obtain((Handler) null, 0);
                    obtain.what = 18;
                    Bundle bundle = new Bundle();
                    bundle.putString("xmsf_region", XMPushService.a(this.a));
                    obtain.setData(bundle);
                    message.replyTo.send(obtain);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
