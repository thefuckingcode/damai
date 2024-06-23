package tb;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class vo2 extends uo2 {
    private final Variance a;
    private final g61 b;

    public vo2(@NotNull Variance variance, @NotNull g61 g61) {
        if (variance == null) {
            a(0);
        }
        if (g61 == null) {
            a(1);
        }
        this.a = variance;
        this.b = g61;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (!(i == 4 || i == 5)) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i == 4 || i == 5) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        Variance variance = this.a;
        if (variance == null) {
            a(4);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public g61 getType() {
        g61 g61 = this.b;
        if (g61 == null) {
            a(5);
        }
        return g61;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull i61 i61) {
        if (i61 == null) {
            a(6);
        }
        return new vo2(this.a, i61.g(this.b));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public vo2(@NotNull g61 g61) {
        this(Variance.INVARIANT, g61);
        if (g61 == null) {
            a(2);
        }
    }
}
