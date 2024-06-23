package tb;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class uv2 extends ContextWrapper {
    private WeakReference<Context> a;

    public uv2(Context context) {
        super(context.getApplicationContext());
        this.a = new WeakReference<>(context);
    }

    public Context a() {
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Resources getResources() {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            return context.getResources();
        }
        return super.getResources();
    }

    public Resources.Theme getTheme() {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            return context.getTheme();
        }
        return super.getTheme();
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            Context a2 = a();
            if (a2 != null) {
                return a2.registerReceiver(broadcastReceiver, intentFilter);
            }
            return super.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void startActivities(Intent[] intentArr) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    public void startActivity(Intent intent) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000a */
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Context a2 = a();
        if (a2 != null) {
            a2.unregisterReceiver(broadcastReceiver);
            return;
        }
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        try {
            Context a2 = a();
            if (a2 != null) {
                return a2.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            }
            return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }
}
