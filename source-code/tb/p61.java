package tb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.monitor.impl.processor.IProcessorFactory;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.network.UploadStorage;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class p61 implements IProcessorFactory<LauncherProcessor> {
    p61() {
    }

    private void c() {
        if (!lc0.i) {
            SharedPreferences.Editor edit = qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0).edit();
            edit.putString(ls2.KEY_LAST_LAUNCH_SESSION, "");
            edit.apply();
        }
    }

    private void d() {
        boolean z = ws0.r != 1;
        ws0.r = 1;
        if (lc0.E) {
            UploadStorage.a().e(new ls2(z));
            UploadStorage.a().f(true);
        }
    }

    public LauncherProcessor a(String str) {
        d();
        c();
        if (TextUtils.isEmpty(str)) {
            if (lc0.i) {
                return new n71();
            }
            return null;
        } else if (lc0.i) {
            return new n71(str);
        } else {
            return null;
        }
    }

    /* renamed from: b */
    public LauncherProcessor createProcessor() {
        d();
        c();
        if (lc0.i) {
            return new LauncherProcessor();
        }
        return null;
    }
}
