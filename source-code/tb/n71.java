package tb;

import android.app.Activity;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import java.util.Map;

/* compiled from: Taobao */
public class n71 extends LauncherProcessor {
    public n71() {
    }

    @Override // com.taobao.monitor.impl.processor.launcher.LauncherProcessor, com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityCreated(Activity activity, Map<String, Object> map, long j) {
        super.onActivityCreated(activity, map, j);
        Object obj = map.get("blackPage");
        if (obj != null && activity.getClass().getName().equals(obj.toString())) {
            this.d = null;
        }
    }

    public n71(String str) {
        super(str);
    }
}
