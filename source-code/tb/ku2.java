package tb;

import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.m;
import kotlin.text.n;
import kotlin.text.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ku2 {
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.b.C0(r4) != false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Nullable
    public static final m31 a(@NotNull g61 g61, @NotNull String str) {
        Object obj;
        k21.i(g61, "<this>");
        k21.i(str, "value");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.getKind() == ClassKind.ENUM_CLASS) {
                MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
                og1 f = og1.f(str);
                k21.h(f, "identifier(value)");
                ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(f, NoLookupLocation.FROM_BACKEND);
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) contributedClassifier;
                if (classDescriptor2.getKind() == ClassKind.ENUM_ENTRY) {
                    return new yd0(classDescriptor2);
                }
                return null;
            }
        }
        g61 j = TypeUtilsKt.j(g61);
        mk1 a = nk1.a(str);
        String a2 = a.a();
        int b = a.b();
        try {
            if (b.d0(j)) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str));
            } else if (b.g0(j)) {
                obj = q.W0(str);
            } else if (b.f0(j)) {
                obj = n.j(a2, b);
            } else if (b.A0(j)) {
                obj = n.o(a2, b);
            } else if (b.p0(j)) {
                obj = n.l(a2, b);
            } else if (b.r0(j)) {
                obj = n.n(a2, b);
            } else if (b.n0(j)) {
                obj = m.i(str);
            } else {
                obj = b.l0(j) ? m.h(str) : str;
            }
        } catch (IllegalArgumentException unused) {
        }
        if (obj == null) {
            return new nm(obj);
        }
        return null;
        obj = null;
        if (obj == null) {
        }
    }

    @NotNull
    public static final h60 b(@NotNull qw2 qw2) {
        k21.i(qw2, "<this>");
        h60 g = p31.g(qw2);
        k21.h(g, "toDescriptorVisibility(this)");
        return g;
    }
}
