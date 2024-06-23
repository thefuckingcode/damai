package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* access modifiers changed from: package-private */
public class TypeCheckerProcedureCallbacksImpl implements TypeCheckingProcedureCallbacks {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean capture(KotlinType kotlinType, TypeProjection typeProjection) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (typeProjection != null) {
            return false;
        }
        $$$reportNull$$$0(9);
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean noCorrespondingSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(10);
        }
        if (kotlinType2 != null) {
            return false;
        }
        $$$reportNull$$$0(11);
        return false;
    }

    TypeCheckerProcedureCallbacksImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean assertEqualTypes(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedure typeCheckingProcedure) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(1);
        }
        if (typeCheckingProcedure == null) {
            $$$reportNull$$$0(2);
        }
        return typeCheckingProcedure.equalTypes(kotlinType, kotlinType2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean assertEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(3);
        }
        if (typeConstructor2 == null) {
            $$$reportNull$$$0(4);
        }
        return typeConstructor.equals(typeConstructor2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean assertSubtype(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedure typeCheckingProcedure) {
        if (kotlinType == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(6);
        }
        if (typeCheckingProcedure == null) {
            $$$reportNull$$$0(7);
        }
        return typeCheckingProcedure.isSubtypeOf(kotlinType, kotlinType2);
    }
}
