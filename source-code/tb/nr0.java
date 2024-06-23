package tb;

import com.youku.gaiax.impl.GaiaXContext;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class nr0 implements Callable {
    public final /* synthetic */ GaiaXContext a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ nr0(GaiaXContext gaiaXContext, Function0 function0) {
        this.a = gaiaXContext;
        this.b = function0;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return GaiaXContext.m892workerTask$lambda1(this.a, this.b);
    }
}
