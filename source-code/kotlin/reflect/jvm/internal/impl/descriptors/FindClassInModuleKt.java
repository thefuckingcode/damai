package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;
import tb.n02;
import tb.og1;
import tb.oi;

/* compiled from: Taobao */
public final class FindClassInModuleKt {
    @Nullable
    public static final ClassDescriptor a(@NotNull ModuleDescriptor moduleDescriptor, @NotNull oi oiVar) {
        k21.i(moduleDescriptor, "<this>");
        k21.i(oiVar, "classId");
        ClassifierDescriptor b = b(moduleDescriptor, oiVar);
        if (b instanceof ClassDescriptor) {
            return (ClassDescriptor) b;
        }
        return null;
    }

    @Nullable
    public static final ClassifierDescriptor b(@NotNull ModuleDescriptor moduleDescriptor, @NotNull oi oiVar) {
        ClassifierDescriptor contributedClassifier;
        k21.i(moduleDescriptor, "<this>");
        k21.i(oiVar, "classId");
        ModuleDescriptor a = n02.a(moduleDescriptor);
        if (a == null) {
            en0 h = oiVar.h();
            k21.h(h, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(h);
            List<og1> f = oiVar.i().f();
            k21.h(f, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope = packageViewDescriptor.getMemberScope();
            Object P = k.P(f);
            k21.h(P, "segments.first()");
            contributedClassifier = memberScope.getContributedClassifier((og1) P, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier == null) {
                return null;
            }
            for (og1 og1 : f.subList(1, f.size())) {
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
                k21.h(og1, "name");
                ClassifierDescriptor contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(og1, NoLookupLocation.FROM_DESERIALIZATION);
                if (contributedClassifier2 instanceof ClassDescriptor) {
                    contributedClassifier = (ClassDescriptor) contributedClassifier2;
                    continue;
                } else {
                    contributedClassifier = null;
                    continue;
                }
                if (contributedClassifier == null) {
                    return null;
                }
            }
        } else {
            en0 h2 = oiVar.h();
            k21.h(h2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = a.getPackage(h2);
            List<og1> f2 = oiVar.i().f();
            k21.h(f2, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope2 = packageViewDescriptor2.getMemberScope();
            Object P2 = k.P(f2);
            k21.h(P2, "segments.first()");
            ClassifierDescriptor contributedClassifier3 = memberScope2.getContributedClassifier((og1) P2, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier3 != null) {
                Iterator<og1> it = f2.subList(1, f2.size()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    og1 next = it.next();
                    if (!(contributedClassifier3 instanceof ClassDescriptor)) {
                        break;
                    }
                    MemberScope unsubstitutedInnerClassesScope2 = ((ClassDescriptor) contributedClassifier3).getUnsubstitutedInnerClassesScope();
                    k21.h(next, "name");
                    ClassifierDescriptor contributedClassifier4 = unsubstitutedInnerClassesScope2.getContributedClassifier(next, NoLookupLocation.FROM_DESERIALIZATION);
                    if (contributedClassifier4 instanceof ClassDescriptor) {
                        contributedClassifier3 = (ClassDescriptor) contributedClassifier4;
                        continue;
                    } else {
                        contributedClassifier3 = null;
                        continue;
                    }
                    if (contributedClassifier3 == null) {
                        break;
                    }
                }
            }
            contributedClassifier3 = null;
            if (contributedClassifier3 != null) {
                return contributedClassifier3;
            }
            en0 h3 = oiVar.h();
            k21.h(h3, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(h3);
            List<og1> f3 = oiVar.i().f();
            k21.h(f3, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope3 = packageViewDescriptor3.getMemberScope();
            Object P3 = k.P(f3);
            k21.h(P3, "segments.first()");
            contributedClassifier = memberScope3.getContributedClassifier((og1) P3, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier == null) {
                return null;
            }
            for (og1 og12 : f3.subList(1, f3.size())) {
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope3 = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
                k21.h(og12, "name");
                ClassifierDescriptor contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(og12, NoLookupLocation.FROM_DESERIALIZATION);
                if (contributedClassifier5 instanceof ClassDescriptor) {
                    contributedClassifier = (ClassDescriptor) contributedClassifier5;
                    continue;
                } else {
                    contributedClassifier = null;
                    continue;
                }
                if (contributedClassifier == null) {
                    return null;
                }
            }
        }
        return contributedClassifier;
    }

    @NotNull
    public static final ClassDescriptor c(@NotNull ModuleDescriptor moduleDescriptor, @NotNull oi oiVar, @NotNull NotFoundClasses notFoundClasses) {
        k21.i(moduleDescriptor, "<this>");
        k21.i(oiVar, "classId");
        k21.i(notFoundClasses, "notFoundClasses");
        ClassDescriptor a = a(moduleDescriptor, oiVar);
        if (a != null) {
            return a;
        }
        return notFoundClasses.d(oiVar, SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.v(SequencesKt__SequencesKt.h(oiVar, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    @Nullable
    public static final TypeAliasDescriptor d(@NotNull ModuleDescriptor moduleDescriptor, @NotNull oi oiVar) {
        k21.i(moduleDescriptor, "<this>");
        k21.i(oiVar, "classId");
        ClassifierDescriptor b = b(moduleDescriptor, oiVar);
        if (b instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) b;
        }
        return null;
    }
}
