package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 4) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "type";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else if (i != 5) {
            objArr[0] = "projection";
        } else {
            objArr[0] = "kotlinTypeRefiner";
        }
        if (i == 3) {
            objArr[1] = "getProjectionKind";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (!(i == 3 || i == 4)) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i == 3 || i == 4) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    public TypeProjectionImpl(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        this.projection = variance;
        this.type = kotlinType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TypeProjectionImpl(KotlinType kotlinType) {
        this(Variance.INVARIANT, kotlinType);
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        Variance variance = this.projection;
        if (variance == null) {
            $$$reportNull$$$0(3);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        KotlinType kotlinType = this.type;
        if (kotlinType == null) {
            $$$reportNull$$$0(4);
        }
        return kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(5);
        }
        return new TypeProjectionImpl(this.projection, kotlinTypeRefiner.refineType(this.type));
    }
}
