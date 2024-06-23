package tb;

import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

/* compiled from: Taobao */
public class wg1 implements IUTCrashCaughtListener {
    long a;

    public wg1(long j) {
        this.a = j;
    }

    @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
    public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
        if (thread == null && th == null) {
            if (System.currentTimeMillis() - this.a > 10000) {
                return null;
            }
            HotPatchManager.getInstance().setNativeCrashFlag();
            HotPatchManager.getInstance().cleanPatchs(true);
            return null;
        } else if (th == null) {
            return null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            HotPatchManager.getInstance().setJavaCrashFlag(byteArrayOutputStream.toString().contains("_CF_"));
            return null;
        }
    }
}
