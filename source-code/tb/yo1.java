package tb;

import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taobao.hotpatch.monitor.IPatchVersionMonitor;

/* compiled from: Taobao */
public class yo1 implements IPatchVersionMonitor {
    public yo1() {
        db.c().d();
    }

    @Override // com.taobao.hotpatch.monitor.IPatchVersionMonitor
    public void patchVersion(String str, String str2) {
        db.c().b(str, str2);
        db.c().a(str, str2);
        MotuCrashReporter.getInstance().addNativeHeaderInfo(str, str2);
    }

    @Override // com.taobao.hotpatch.monitor.IPatchVersionMonitor
    public void versionChange(String str, String str2, String str3) {
        db.c().b(str, str2);
        db.c().a(str, str2);
        MotuCrashReporter.getInstance().addNativeHeaderInfo(str, str2);
    }
}
