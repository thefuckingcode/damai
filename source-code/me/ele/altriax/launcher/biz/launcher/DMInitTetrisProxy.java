package me.ele.altriax.launcher.biz.launcher;

import android.app.Application;
import com.taobao.android.launcher.biz.task.TaggedTask;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.impl.DMInitTetrisProxyTask;

/* compiled from: Taobao */
public class DMInitTetrisProxy extends TaggedTask {
    public DMInitTetrisProxy(String str) {
        super(str);
    }

    @Override // com.taobao.android.launcher.biz.task.TaggedRunnable
    public void run(Application application, HashMap<String, Object> hashMap) {
        new DMInitTetrisProxyTask().init(application, hashMap);
    }
}
