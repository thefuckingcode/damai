package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(@NotNull String str) {
        super(str);
        k21.i(str, "message");
    }
}
