package tb;

import android.content.Context;
import android.util.Log;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import java.util.Map;

/* compiled from: Taobao */
public class ay0 {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements OrangeConfigListenerV1 {
        a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            Map<String, String> configs;
            Log.i("HotPatchOrangeReceiver", "onConfigUpdate");
            if (!z && (configs = OrangeConfig.getInstance().getConfigs("android_hotpatch_configcenter")) != null) {
                String str2 = configs.get("clean_patch");
                Log.i("HotPatchOrangeReceiver", "the clearPatch is " + str2);
                if (str2 != null && str2.equals("true")) {
                    HotPatchManager.getInstance().cleanPatchs(true);
                    HotPatchManager.getInstance().cleanDexPatch();
                }
                String str3 = configs.get("forbid_patch");
                if (str3 == null) {
                    return;
                }
                if (str3.equals("true")) {
                    HotPatchManager.getInstance().setUsedSupport(false);
                } else if (str3.equals("false")) {
                    HotPatchManager.getInstance().setUsedSupport(true);
                }
            }
        }
    }

    public static void a(Context context) {
        OrangeConfig.getInstance().registerListener(new String[]{"android_hotpatch_configcenter"}, new a());
    }
}
