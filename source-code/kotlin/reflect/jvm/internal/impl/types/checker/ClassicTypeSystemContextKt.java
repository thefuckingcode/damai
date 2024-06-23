package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: ClassicTypeSystemContext.kt */
public final class ClassicTypeSystemContextKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.IN.ordinal()] = 2;
            iArr[TypeVariance.OUT.ordinal()] = 3;
            int[] iArr2 = new int[Variance.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Variance.INVARIANT.ordinal()] = 1;
            iArr2[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr2[Variance.OUT_VARIANCE.ordinal()] = 3;
        }
    }

    public static final TypeVariance convertVariance(Variance variance) {
        Intrinsics.checkParameterIsNotNull(variance, "$this$convertVariance");
        int i = WhenMappings.$EnumSwitchMapping$1[variance.ordinal()];
        if (i == 1) {
            return TypeVariance.INV;
        }
        if (i == 2) {
            return TypeVariance.IN;
        }
        if (i == 3) {
            return TypeVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
