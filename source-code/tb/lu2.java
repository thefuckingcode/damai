package tb;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class lu2 {
    private static final g61 a(g61 g61) {
        return CapturedTypeApproximationKt.a(g61).d();
    }

    private static final String b(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        c(k21.r("type: ", typeConstructor), sb);
        c(k21.r("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        c(k21.r("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            c(k21.r("fqName: ", DescriptorRenderer.FQ_NAMES_IN_TYPES.a(declarationDescriptor)), sb);
            c(k21.r("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        k21.i(str, "<this>");
        k21.i(sb, "$this_anonymous");
        sb.append(str);
        k21.h(sb, "append(value)");
        sb.append('\n');
        k21.h(sb, "append('\\n')");
        return sb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    @Nullable
    public static final g61 d(@NotNull g61 g61, @NotNull g61 g612, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z;
        boolean z2;
        k21.i(g61, "subtype");
        k21.i(g612, "supertype");
        k21.i(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new tg2(g61, null));
        TypeConstructor c = g612.c();
        while (!arrayDeque.isEmpty()) {
            tg2 tg2 = (tg2) arrayDeque.poll();
            g61 b = tg2.b();
            TypeConstructor c2 = b.c();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(c2, c)) {
                boolean d = b.d();
                for (tg2 a = tg2.a(); a != null; a = a.a()) {
                    g61 b2 = a.b();
                    List<TypeProjection> b3 = b2.b();
                    if (!(b3 instanceof Collection) || !b3.isEmpty()) {
                        Iterator<T> it = b3.iterator();
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
                            g61 n = CapturedTypeConstructorKt.f(ko2.Companion.b(b2), false, 1, null).c().n(b, Variance.INVARIANT);
                            k21.h(n, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                            b = a(n);
                        } else {
                            b = ko2.Companion.b(b2).c().n(b, Variance.INVARIANT);
                            k21.h(b, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                        }
                        d = !d || b2.d();
                    }
                    z = false;
                    if (!z) {
                    }
                    if (!d) {
                    }
                }
                TypeConstructor c3 = b.c();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(c3, c)) {
                    return bp2.p(b, d);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(c3) + ", \n\nsupertype: " + b(c) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(c3, c));
            }
            for (g61 g613 : c2.getSupertypes()) {
                k21.h(g613, "immediateSupertype");
                arrayDeque.add(new tg2(g613, tg2));
            }
        }
        return null;
    }
}
