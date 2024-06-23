package tb;

import com.youku.gaiax.js.utils.GaiaXJSTaskQueue;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class qr0 implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ qr0(Function0 function0) {
        this.a = function0;
    }

    public final void run() {
        GaiaXJSTaskQueue.m904executeTask$lambda2(this.a);
    }
}
