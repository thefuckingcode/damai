package tb;

import com.youku.gaiax.impl.GaiaXContext;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
public final /* synthetic */ class mr0 implements Callable {
    public final /* synthetic */ GaiaXContext a;

    public /* synthetic */ mr0(GaiaXContext gaiaXContext) {
        this.a = gaiaXContext;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return GaiaXContext.m890releaseTask$lambda3(this.a);
    }
}
