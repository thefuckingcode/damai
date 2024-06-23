package tb;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class d60 {
    private static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 4 ? 3 : 2)];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static TypeSubstitutor b(@NotNull List<TypeParameterDescriptor> list, @NotNull xo2 xo2, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(0);
        }
        if (xo2 == null) {
            a(1);
        }
        if (declarationDescriptor == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        TypeSubstitutor c = c(list, xo2, declarationDescriptor, list2, null);
        if (c != null) {
            return c;
        }
        throw new AssertionError("Substitution failed");
    }

    @Nullable
    public static TypeSubstitutor c(@NotNull List<TypeParameterDescriptor> list, @NotNull xo2 xo2, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2, @Nullable boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (xo2 == null) {
            a(6);
        }
        if (declarationDescriptor == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            so2 k = so2.k(declarationDescriptor, typeParameterDescriptor.getAnnotations(), typeParameterDescriptor.isReified(), typeParameterDescriptor.getVariance(), typeParameterDescriptor.getName(), i, SourceElement.NO_SOURCE, typeParameterDescriptor.getStorageManager());
            hashMap.put(typeParameterDescriptor.getTypeConstructor(), new vo2(k.getDefaultType()));
            hashMap2.put(typeParameterDescriptor, k);
            list2.add(k);
            i++;
        }
        TypeSubstitutor h = TypeSubstitutor.h(xo2, ko2.i(hashMap));
        for (TypeParameterDescriptor typeParameterDescriptor2 : list) {
            so2 so2 = (so2) hashMap2.get(typeParameterDescriptor2);
            for (g61 g61 : typeParameterDescriptor2.getUpperBounds()) {
                g61 q = h.q(g61, Variance.IN_VARIANCE);
                if (q == null) {
                    return null;
                }
                if (!(q == g61 || zArr == null)) {
                    zArr[0] = true;
                }
                so2.g(q);
            }
            so2.o();
        }
        return h;
    }
}
