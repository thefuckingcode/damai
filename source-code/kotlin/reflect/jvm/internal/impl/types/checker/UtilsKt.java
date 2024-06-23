package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* compiled from: utils.kt */
public final class UtilsKt {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    public static final KotlinType findCorrespondingSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z;
        boolean z2;
        Intrinsics.checkParameterIsNotNull(kotlinType, "subtype");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "supertype");
        Intrinsics.checkParameterIsNotNull(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new SubtypePathNode(kotlinType, null));
        TypeConstructor constructor = kotlinType2.getConstructor();
        while (!arrayDeque.isEmpty()) {
            SubtypePathNode subtypePathNode = (SubtypePathNode) arrayDeque.poll();
            KotlinType type = subtypePathNode.getType();
            TypeConstructor constructor2 = type.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean isMarkedNullable = type.isMarkedNullable();
                for (SubtypePathNode previous = subtypePathNode.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    KotlinType type2 = previous.getType();
                    List<TypeProjection> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().getProjectionKind() != Variance.INVARIANT) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            KotlinType safeSubstitute = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                            Intrinsics.checkExpressionValueIsNotNull(safeSubstitute, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                            type = approximate(safeSubstitute);
                        } else {
                            type = TypeConstructorSubstitution.Companion.create(type2).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                            Intrinsics.checkExpressionValueIsNotNull(type, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        }
                        isMarkedNullable = !isMarkedNullable || type2.isMarkedNullable();
                    }
                    z = false;
                    if (!z) {
                    }
                    if (!isMarkedNullable) {
                    }
                }
                TypeConstructor constructor3 = type.getConstructor();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor)) {
                    return TypeUtils.makeNullableAsSpecified(type, isMarkedNullable);
                }
                throw new AssertionError("Type constructors should be equals!\n" + "substitutedSuperType: " + debugInfo(constructor3) + ", \n\n" + "supertype: " + debugInfo(constructor) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor));
            }
            for (KotlinType kotlinType3 : constructor2.getSupertypes()) {
                Intrinsics.checkExpressionValueIsNotNull(kotlinType3, "immediateSupertype");
                arrayDeque.add(new SubtypePathNode(kotlinType3, subtypePathNode));
            }
        }
        return null;
    }

    private static final KotlinType approximate(KotlinType kotlinType) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getUpper();
    }

    private static final String debugInfo(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        UtilsKt$debugInfo$1$1 utilsKt$debugInfo$1$1 = new UtilsKt$debugInfo$1$1(sb);
        utilsKt$debugInfo$1$1.invoke("type: " + typeConstructor);
        utilsKt$debugInfo$1$1.invoke("hashCode: " + typeConstructor.hashCode());
        utilsKt$debugInfo$1$1.invoke("javaClass: " + typeConstructor.getClass().getCanonicalName());
        for (ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            utilsKt$debugInfo$1$1.invoke("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor));
            utilsKt$debugInfo$1$1.invoke("javaClass: " + declarationDescriptor.getClass().getCanonicalName());
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
