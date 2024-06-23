package tb;

import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class io2 {
    private static /* synthetic */ void a(int i) {
        String str = (i == 7 || i == 10) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 7 || i == 10) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
            case 16:
            case 18:
                objArr[0] = "supertype";
                break;
            case 2:
            case 15:
            case 17:
            default:
                objArr[0] = "subtype";
                break;
            case 4:
                objArr[0] = "typeCheckingProcedureCallbacks";
                break;
            case 5:
            case 8:
            case 21:
                objArr[0] = "parameter";
                break;
            case 6:
            case 9:
                objArr[0] = "argument";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 11:
                objArr[0] = "type1";
                break;
            case 12:
                objArr[0] = "type2";
                break;
            case 13:
                objArr[0] = "typeParameter";
                break;
            case 14:
                objArr[0] = "typeArgument";
                break;
            case 19:
                objArr[0] = "subtypeArgumentProjection";
                break;
            case 20:
                objArr[0] = "supertypeArgumentProjection";
                break;
        }
        if (i == 7) {
            objArr[1] = "getOutType";
        } else if (i != 10) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        } else {
            objArr[1] = "getInType";
        }
        switch (i) {
            case 5:
            case 6:
                objArr[2] = "getOutType";
                break;
            case 7:
            case 10:
                break;
            case 8:
            case 9:
                objArr[2] = "getInType";
                break;
            case 11:
            case 12:
                objArr[2] = "equalTypes";
                break;
            case 13:
            case 14:
                objArr[2] = "getEffectiveProjectionKind";
                break;
            case 15:
            case 16:
                objArr[2] = "isSubtypeOf";
                break;
            case 17:
            case 18:
                objArr[2] = "checkSubtypeForTheSameConstructor";
                break;
            case 19:
            case 20:
            case 21:
                objArr[2] = "capture";
                break;
            default:
                objArr[2] = "findCorrespondingSupertype";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 7 || i == 10) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Nullable
    public static g61 b(@NotNull g61 g61, @NotNull g61 g612) {
        if (g61 == null) {
            a(0);
        }
        if (g612 == null) {
            a(1);
        }
        return c(g61, g612, new ho2());
    }

    @Nullable
    public static g61 c(@NotNull g61 g61, @NotNull g61 g612, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        if (g61 == null) {
            a(2);
        }
        if (g612 == null) {
            a(3);
        }
        if (typeCheckingProcedureCallbacks == null) {
            a(4);
        }
        return lu2.d(g61, g612, typeCheckingProcedureCallbacks);
    }
}
