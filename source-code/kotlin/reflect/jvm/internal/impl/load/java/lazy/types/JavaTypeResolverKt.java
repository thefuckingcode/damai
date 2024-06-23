package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.List;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import tb.be2;
import tb.en0;
import tb.g61;
import tb.k21;
import tb.vo2;
import tb.y31;

public final class JavaTypeResolverKt {
    private static final en0 a = new en0("java.lang.Class");

    public static final g61 b(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0<? extends g61> function0) {
        k21.i(typeParameterDescriptor, "<this>");
        k21.i(function0, "defaultValue");
        if (typeParameterDescriptor == typeParameterDescriptor2) {
            return (g61) function0.invoke();
        }
        List<g61> upperBounds = typeParameterDescriptor.getUpperBounds();
        k21.h(upperBounds, "upperBounds");
        g61 g61 = (g61) k.P(upperBounds);
        if (g61.c().getDeclarationDescriptor() instanceof ClassDescriptor) {
            k21.h(g61, "firstUpperBound");
            return TypeUtilsKt.m(g61);
        }
        if (typeParameterDescriptor2 != null) {
            typeParameterDescriptor = typeParameterDescriptor2;
        }
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
            if (k21.d(typeParameterDescriptor3, typeParameterDescriptor)) {
                return (g61) function0.invoke();
            }
            List<g61> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
            k21.h(upperBounds2, "current.upperBounds");
            g61 g612 = (g61) k.P(upperBounds2);
            if (g612.c().getDeclarationDescriptor() instanceof ClassDescriptor) {
                k21.h(g612, "nextUpperBound");
                return TypeUtilsKt.m(g612);
            }
            declarationDescriptor = g612.c().getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static /* synthetic */ g61 c(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterDescriptor2 = null;
        }
        if ((i & 2) != 0) {
            function0 = new JavaTypeResolverKt$getErasedUpperBound$1(typeParameterDescriptor);
        }
        return b(typeParameterDescriptor, typeParameterDescriptor2, function0);
    }

    public static final TypeProjection d(TypeParameterDescriptor typeParameterDescriptor, y31 y31) {
        k21.i(typeParameterDescriptor, "typeParameter");
        k21.i(y31, RichTextNode.ATTR);
        if (y31.d() == TypeUsage.SUPERTYPE) {
            return new vo2(be2.a(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static final y31 e(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(typeUsage, "<this>");
        return new y31(typeUsage, null, z, typeParameterDescriptor, 2, null);
    }

    public static /* synthetic */ y31 f(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return e(typeUsage, z, typeParameterDescriptor);
    }
}
