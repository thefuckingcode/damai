package tb;

import android.content.SharedPreferences;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;

/* compiled from: Taobao */
public class u6 extends q1 {

    /* compiled from: Taobao */
    public static class a {
        public static long a() {
            return qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0).getLong("lastStartProcessTime", -1);
        }

        public static void b(long j) {
            SharedPreferences.Editor edit = qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0).edit();
            edit.putLong("lastStartProcessTime", j);
            edit.apply();
        }
    }

    public void a(boolean z) {
        this.a.c("isFirstLaunch", z);
    }

    public void b(boolean z) {
        this.a.c("isFullNewInstall", z);
    }

    public void c(long j) {
        this.a.e("lastStartProcessTime", j);
    }

    public void d(String str) {
        if (LauncherProcessor.WARM.equals(str)) {
            str = LauncherProcessor.HOT;
        }
        this.a.f("launchType", str);
    }

    public void e(long j) {
        this.a.e("startAppOnCreateSystemClockTime", j);
    }

    public void f(long j) {
        this.a.e("startAppOnCreateSystemTime", j);
    }

    public void g(long j) {
        this.a.e("startProcessSystemClockTime", j);
    }

    public void h(long j) {
        this.a.e("startProcessSystemTime", j);
        a.b(j);
    }
}
