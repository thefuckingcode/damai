package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class be2 {

    /* compiled from: Taobao */
    public static final class a extends ko2 {
        final /* synthetic */ List<TypeConstructor> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeConstructor> */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends TypeConstructor> list) {
            this.a = list;
        }

        @Override // tb.ko2
        @Nullable
        public TypeProjection j(@NotNull TypeConstructor typeConstructor) {
            k21.i(typeConstructor, "key");
            if (!this.a.contains(typeConstructor)) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return bp2.s((TypeParameterDescriptor) declarationDescriptor);
        }
    }

    @NotNull
    public static final g61 a(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(typeParameterDescriptor, "<this>");
        List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) typeParameterDescriptor.getContainingDeclaration()).getTypeConstructor().getParameters();
        k21.h(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(n.q(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTypeConstructor());
        }
        TypeSubstitutor g = TypeSubstitutor.g(new a(arrayList));
        List<g61> upperBounds = typeParameterDescriptor.getUpperBounds();
        k21.h(upperBounds, "this.upperBounds");
        g61 q = g.q((g61) k.P(upperBounds), Variance.OUT_VARIANCE);
        if (q != null) {
            return q;
        }
        ib2 y = DescriptorUtilsKt.g(typeParameterDescriptor).y();
        k21.h(y, "builtIns.defaultBound");
        return y;
    }
}
