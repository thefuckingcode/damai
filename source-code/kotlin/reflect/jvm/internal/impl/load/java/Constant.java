package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
public final class Constant extends JavaDefaultValue {
    private final Object value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Constant(Object obj) {
        super(null);
        Intrinsics.checkParameterIsNotNull(obj, "value");
        this.value = obj;
    }
}
