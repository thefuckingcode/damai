package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f60;
import tb.g61;
import tb.k21;
import tb.me0;
import tb.tr1;

/* compiled from: Taobao */
public final class TypeParameterUtilsKt {
    @Nullable
    public static final tr1 a(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return b(g61, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null, 0);
    }

    private static final tr1 b(g61 g61, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = null;
        if (classifierDescriptorWithTypeParameters == null || me0.r(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
        if (!classifierDescriptorWithTypeParameters.isInner()) {
            if (size != g61.b().size()) {
                f60.E(classifierDescriptorWithTypeParameters);
            }
            return new tr1(classifierDescriptorWithTypeParameters, g61.b().subList(i, g61.b().size()), null);
        }
        List<TypeProjection> subList = g61.b().subList(i, size);
        DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
        if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
            classifierDescriptorWithTypeParameters2 = (ClassifierDescriptorWithTypeParameters) containingDeclaration;
        }
        return new tr1(classifierDescriptorWithTypeParameters, subList, b(g61, classifierDescriptorWithTypeParameters2, size));
    }

    private static final a c(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        return new a(typeParameterDescriptor, declarationDescriptor, i);
    }

    @NotNull
    public static final List<TypeParameterDescriptor> d(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        TypeConstructor typeConstructor;
        k21.i(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters, "declaredTypeParameters");
        if (!(classifierDescriptorWithTypeParameters.isInner() || (classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor))) {
            return declaredTypeParameters;
        }
        List list2 = SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.t(SequencesKt___SequencesKt.o(SequencesKt___SequencesKt.z(DescriptorUtilsKt.m(classifierDescriptorWithTypeParameters), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
        Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.m(classifierDescriptorWithTypeParameters).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                declarationDescriptor = null;
                break;
            }
            declarationDescriptor = it.next();
            if (declarationDescriptor instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (!(classDescriptor == null || (typeConstructor = classDescriptor.getTypeConstructor()) == null)) {
            list = typeConstructor.getParameters();
        }
        if (list == null) {
            list = m.g();
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            List<TypeParameterDescriptor> list3 = CollectionsKt___CollectionsKt.k0(list2, list);
            ArrayList arrayList = new ArrayList(n.q(list3, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : list3) {
                k21.h(typeParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
                arrayList.add(c(typeParameterDescriptor, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
            }
            return CollectionsKt___CollectionsKt.k0(declaredTypeParameters, arrayList);
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters2, "declaredTypeParameters");
        return declaredTypeParameters2;
    }
}
