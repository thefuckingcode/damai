package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

public class KotlinTypeCheckerImpl implements KotlinTypeChecker {
    private final TypeCheckingProcedure procedure;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "procedure";
        } else if (i == 2) {
            objArr[0] = "subtype";
        } else if (i == 3) {
            objArr[0] = "supertype";
        } else if (i == 4) {
            objArr[0] = "a";
        } else if (i != 5) {
            objArr[0] = "equalityAxioms";
        } else {
            objArr[0] = "b";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl";
        if (i == 1) {
            objArr[2] = "<init>";
        } else if (i == 2 || i == 3) {
            objArr[2] = "isSubtypeOf";
        } else if (i == 4 || i == 5) {
            objArr[2] = "equalTypes";
        } else {
            objArr[2] = "withAxioms";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static KotlinTypeChecker withAxioms(final KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(0);
        }
        return new KotlinTypeCheckerImpl(new TypeCheckingProcedure(new TypeCheckerProcedureCallbacksImpl() {
            /* class kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl.AnonymousClass1 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "constructor1";
                } else {
                    objArr[0] = "constructor2";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1";
                objArr[2] = "assertEqualTypeConstructors";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks, kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl
            public boolean assertEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                return typeConstructor.equals(typeConstructor2) || typeConstructorEquality.equals(typeConstructor, typeConstructor2);
            }
        }));
    }

    protected KotlinTypeCheckerImpl(TypeCheckingProcedure typeCheckingProcedure) {
        if (typeCheckingProcedure == null) {
            $$$reportNull$$$0(1);
        }
        this.procedure = typeCheckingProcedure;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(3);
        }
        return this.procedure.isSubtypeOf(kotlinType, kotlinType2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(4);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(5);
        }
        return this.procedure.equalTypes(kotlinType, kotlinType2);
    }
}
