package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.s;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.f60;
import tb.fn0;
import tb.k21;
import tb.og1;
import tb.sz1;

/* compiled from: Taobao */
public interface ClassifierNamePolicy {

    /* compiled from: Taobao */
    public static final class a implements ClassifierNamePolicy {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            k21.i(classifierDescriptor, "classifier");
            k21.i(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                og1 name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                k21.h(name, "classifier.name");
                return descriptorRenderer.f(name, false);
            }
            fn0 m = f60.m(classifierDescriptor);
            k21.h(m, "getFqName(classifier)");
            return descriptorRenderer.e(m);
        }
    }

    /* compiled from: Taobao */
    public static final class b implements ClassifierNamePolicy {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            boolean z;
            k21.i(classifierDescriptor, "classifier");
            k21.i(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                og1 name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                k21.h(name, "classifier.name");
                return descriptorRenderer.f(name, false);
            }
            ArrayList arrayList = new ArrayList();
            ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
            do {
                arrayList.add(classifierDescriptor2.getName());
                DeclarationDescriptor containingDeclaration = classifierDescriptor2.getContainingDeclaration();
                z = containingDeclaration instanceof ClassDescriptor;
                classifierDescriptor2 = containingDeclaration;
            } while (z);
            return sz1.c(s.D(arrayList));
        }
    }

    /* compiled from: Taobao */
    public static final class c implements ClassifierNamePolicy {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
        }

        private final String a(ClassifierDescriptor classifierDescriptor) {
            og1 name = classifierDescriptor.getName();
            k21.h(name, "descriptor.name");
            String b = sz1.b(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return b;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            k21.h(containingDeclaration, "descriptor.containingDeclaration");
            String b2 = b(containingDeclaration);
            if (b2 == null || k21.d(b2, "")) {
                return b;
            }
            return ((Object) b2) + '.' + b;
        }

        private final String b(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                return a((ClassifierDescriptor) declarationDescriptor);
            }
            if (!(declarationDescriptor instanceof PackageFragmentDescriptor)) {
                return null;
            }
            fn0 j = ((PackageFragmentDescriptor) declarationDescriptor).getFqName().j();
            k21.h(j, "descriptor.fqName.toUnsafe()");
            return sz1.a(j);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            k21.i(classifierDescriptor, "classifier");
            k21.i(descriptorRenderer, "renderer");
            return a(classifierDescriptor);
        }
    }

    @NotNull
    String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer);
}
