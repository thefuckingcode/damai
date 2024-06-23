package tb;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelicateCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@DelicateCoroutinesApi
/* compiled from: Taobao */
public final class vs0 implements CoroutineScope {
    @NotNull
    public static final vs0 INSTANCE = new vs0();

    private vs0() {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
