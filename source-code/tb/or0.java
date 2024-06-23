package tb;

import com.youku.gaiax.impl.GaiaXContext;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class or0 implements Callable {
    public final /* synthetic */ GaiaXContext a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ or0(GaiaXContext gaiaXContext, Function0 function0) {
        this.a = gaiaXContext;
        this.b = function0;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return GaiaXContext.m891uiTask$lambda6(this.a, this.b);
    }
}
