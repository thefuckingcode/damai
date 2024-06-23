package com.youku.httpcommunication;

import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class Utils$1 extends Thread {
    Utils$1() {
    }

    public void run() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(30));
        } catch (Exception unused) {
        }
        OrangeConfig.getInstance().registerListener(new String[]{"arch_common_config"}, new OrangeConfigListenerV1() {
            /* class com.youku.httpcommunication.Utils$1.AnonymousClass1 */

            @Override // com.taobao.orange.OrangeConfigListenerV1
            public void onConfigUpdate(String str, boolean z) {
                String[] unused = c.d = OrangeConfig.getInstance().getConfig("arch_common_config", "accs_whitelist", TextUtils.join(",", c.c)).split(",");
            }
        });
    }
}
