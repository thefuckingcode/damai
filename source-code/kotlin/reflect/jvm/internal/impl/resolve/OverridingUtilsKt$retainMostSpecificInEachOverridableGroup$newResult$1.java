package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: overridingUtils.kt */
public final class OverridingUtilsKt$retainMostSpecificInEachOverridableGroup$newResult$1 extends Lambda implements Function1<D, D> {
    public static final OverridingUtilsKt$retainMostSpecificInEachOverridableGroup$newResult$1 INSTANCE = new OverridingUtilsKt$retainMostSpecificInEachOverridableGroup$newResult$1();

    OverridingUtilsKt$retainMostSpecificInEachOverridableGroup$newResult$1() {
        super(1);
    }

    public final D invoke(D d) {
        Intrinsics.checkParameterIsNotNull(d, "$receiver");
        return d;
    }
}
