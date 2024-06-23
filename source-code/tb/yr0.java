package tb;

import androidx.annotation.NonNull;
import cn.damai.fluttercommon.plugin.mtop.MtopPlugin;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public final class yr0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AtomicBoolean a = new AtomicBoolean(false);
    private static Set<zp> b;

    public static void a(@NonNull FlutterEngine flutterEngine) {
        Set<zp> set;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278990399")) {
            ipChange.ipc$dispatch("1278990399", new Object[]{flutterEngine});
        } else if (a.get()) {
            g91.c("GeneratedPluginRegistrant", "Flutter plugin already attached to Engine, return");
        } else if (flutterEngine != null && (set = b) != null && set.size() != 0) {
            for (zp zpVar : b) {
                try {
                    flutterEngine.getPlugins().add(zpVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            a.compareAndSet(false, true);
        }
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466433974")) {
            ipChange.ipc$dispatch("1466433974", new Object[0]);
            return;
        }
        if (b == null) {
            b = new HashSet();
        }
        b.add(new MtopPlugin());
        b.add(new pl1());
        b.add(new wq2());
        b.add(new kg1());
        b.add(new h92());
        b.add(new j9());
        b.add(new wp());
    }
}
