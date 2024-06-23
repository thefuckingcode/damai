package tb;

import com.youku.gaiax.provider.module.GaiaXProxyTask;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class sr0 implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ sr0(Function0 function0) {
        this.a = function0;
    }

    public final void run() {
        GaiaXProxyTask.a(this.a);
    }
}
