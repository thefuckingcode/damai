package tb;

import android.preference.PreferenceManager;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.instantpatch.InstantPatchUpdater;

/* compiled from: Taobao */
public class yc0 extends ad0 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static yc0 a = new yc0();
    }

    public static yc0 INSTANCE() {
        return b.a;
    }

    @Override // tb.dd0
    public String biz() {
        return js2.HOTPATCH;
    }

    @Override // tb.dd0
    public String requestVersion() {
        return PreferenceManager.getDefaultSharedPreferences(UpdateDataSource.getInstance().getApplication()).getString(InstantPatchUpdater.EFFECTIVE_VERSION, "-1");
    }

    private yc0() {
    }
}
