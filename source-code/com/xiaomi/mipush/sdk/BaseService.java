package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public abstract class BaseService extends Service {
    private a a;

    /* compiled from: Taobao */
    public static class a extends Handler {
        private WeakReference<BaseService> a;

        public a(WeakReference<BaseService> weakReference) {
            this.a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000);
        }

        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what == 1001 && (weakReference = this.a) != null && (baseService = weakReference.get()) != null) {
                b.c("TimeoutHandler " + baseService.toString() + " kill self");
                if (!baseService.a()) {
                    baseService.stopSelf();
                    return;
                }
                b.c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.a == null) {
            this.a = new a(new WeakReference(this));
        }
        this.a.a();
    }
}
