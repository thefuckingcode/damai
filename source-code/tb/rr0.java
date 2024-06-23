package tb;

import com.taobao.orange.OrangeConfigListenerV1;
import com.youku.gaiax.provider.module.GaiaXProxyPrefs;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class rr0 implements OrangeConfigListenerV1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ rr0(Function0 function0) {
        this.a = function0;
    }

    @Override // com.taobao.orange.OrangeConfigListenerV1
    public final void onConfigUpdate(String str, boolean z) {
        GaiaXProxyPrefs.a(this.a, str, z);
    }
}
