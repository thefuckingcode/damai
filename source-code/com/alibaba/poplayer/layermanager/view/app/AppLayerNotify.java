package com.alibaba.poplayer.layermanager.view.app;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;

/* compiled from: Taobao */
public class AppLayerNotify {
    public static final String TAG = "AppLayerNotify";
    private b a = new b();
    private Application b;
    private ActivityManager c;
    private AppBackgroundNotify d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface AppBackgroundNotify {
        void onKeepInBackground();

        void onQuicklyIntoBackground();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class b extends Handler {
        private b() {
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                AppLayerNotify.this.b();
            } else if (i == 10) {
                AppLayerNotify.this.a();
            }
        }
    }

    AppLayerNotify(Application application, AppBackgroundNotify appBackgroundNotify) {
        this.b = application;
        this.d = appBackgroundNotify;
        this.c = (ActivityManager) application.getSystemService("activity");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!c() || !d()) {
            this.a.sendEmptyMessageDelayed(10, 1000);
        } else {
            this.d.onKeepInBackground();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.d.onQuicklyIntoBackground();
        this.a.removeMessages(10);
        this.a.sendEmptyMessageDelayed(10, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        int i;
        String packageName = this.b.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.c.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && ((i = runningAppProcessInfo.importance) == 100 || i == 200)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        List<ActivityManager.RunningTaskInfo> runningTasks = this.c.getRunningTasks(1);
        if (runningTasks.isEmpty() || runningTasks.get(0).topActivity.getPackageName().equals(this.b.getPackageName())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.a.sendEmptyMessageDelayed(1, 200);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.a.removeMessages(1);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.a.removeCallbacksAndMessages(null);
    }
}
