package tb;

import com.youku.gaiax.impl.utils.GaiaXWorkerExecutor;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class wr0 implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ wr0(Function0 function0) {
        this.a = function0;
    }

    public final void run() {
        GaiaXWorkerExecutor.m899action$lambda0(this.a);
    }
}
