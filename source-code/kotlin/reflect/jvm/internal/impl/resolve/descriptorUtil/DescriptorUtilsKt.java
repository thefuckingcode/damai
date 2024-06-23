package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.f60;
import tb.fn0;
import tb.g61;
import tb.i61;
import tb.j61;
import tb.k21;
import tb.og1;
import tb.oi;
import tb.om;
import tb.vx1;

/* compiled from: Taobao */
public final class DescriptorUtilsKt {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a implements DFS.Neighbors<ValueParameterDescriptor> {
        public static final a INSTANCE = new a();

        a() {
        }

        @NotNull
        /* renamed from: a */
        public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
            Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
            ArrayList arrayList = new ArrayList(n.q(overriddenDescriptors, 10));
            Iterator<T> it = overriddenDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getOriginal());
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b implements DFS.Neighbors<CallableMemberDescriptor> {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @NotNull
        /* renamed from: a */
        public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
            Collection<? extends CallableMemberDescriptor> collection = null;
            if (this.a) {
                callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.getOriginal();
            }
            if (callableMemberDescriptor != null) {
                collection = callableMemberDescriptor.getOverriddenDescriptors();
            }
            return collection == null ? m.g() : collection;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends DFS.b<CallableMemberDescriptor, CallableMemberDescriptor> {
        final /* synthetic */ Ref$ObjectRef<CallableMemberDescriptor> a;
        final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        c(Ref$ObjectRef<CallableMemberDescriptor> ref$ObjectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
            this.a = ref$ObjectRef;
            this.b = function1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public void afterChildren(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            k21.i(callableMemberDescriptor, "current");
            if (this.a.element == null && this.b.invoke(callableMemberDescriptor).booleanValue()) {
                this.a.element = callableMemberDescriptor;
            }
        }

        /* renamed from: b */
        public boolean beforeChildren(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            k21.i(callableMemberDescriptor, "current");
            return this.a.element == null;
        }

        @Nullable
        /* renamed from: c */
        public CallableMemberDescriptor result() {
            return this.a.element;
        }
    }

    static {
        k21.h(og1.f("value"), "identifier(\"value\")");
    }

    public static final boolean a(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        k21.i(valueParameterDescriptor, "<this>");
        Boolean e = DFS.e(l.e(valueParameterDescriptor), a.INSTANCE, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        k21.h(e, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return e.booleanValue();
    }

    @Nullable
    public static final om<?> b(@NotNull AnnotationDescriptor annotationDescriptor) {
        k21.i(annotationDescriptor, "<this>");
        return (om) k.Q(annotationDescriptor.getAllValueArguments().values());
    }

    @Nullable
    public static final CallableMemberDescriptor c(@NotNull CallableMemberDescriptor callableMemberDescriptor, boolean z, @NotNull Function1<? super CallableMemberDescriptor, Boolean> function1) {
        k21.i(callableMemberDescriptor, "<this>");
        k21.i(function1, "predicate");
        return (CallableMemberDescriptor) DFS.b(l.e(callableMemberDescriptor), new b(z), new c(new Ref$ObjectRef(), function1));
    }

    public static /* synthetic */ CallableMemberDescriptor d(CallableMemberDescriptor callableMemberDescriptor, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(callableMemberDescriptor, z, function1);
    }

    @Nullable
    public static final en0 e(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        fn0 j = j(declarationDescriptor);
        if (!j.f()) {
            j = null;
        }
        if (j == null) {
            return null;
        }
        return j.l();
    }

    @Nullable
    public static final ClassDescriptor f(@NotNull AnnotationDescriptor annotationDescriptor) {
        k21.i(annotationDescriptor, "<this>");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.builtins.b g(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        return l(declarationDescriptor).getBuiltIns();
    }

    @Nullable
    public static final oi h(@Nullable ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        oi h;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new oi(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (h = h((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return h.d(classifierDescriptor.getName());
    }

    @NotNull
    public static final en0 i(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        en0 n = f60.n(declarationDescriptor);
        k21.h(n, "getFqNameSafe(this)");
        return n;
    }

    @NotNull
    public static final fn0 j(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        fn0 m = f60.m(declarationDescriptor);
        k21.h(m, "getFqName(this)");
        return m;
    }

    @NotNull
    public static final i61 k(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "<this>");
        vx1 vx1 = (vx1) moduleDescriptor.getCapability(j61.a());
        i61 i61 = vx1 == null ? null : (i61) vx1.a();
        return i61 == null ? i61.a.INSTANCE : i61;
    }

    @NotNull
    public static final ModuleDescriptor l(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        ModuleDescriptor g = f60.g(declarationDescriptor);
        k21.h(g, "getContainingModule(this)");
        return g;
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> m(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        return SequencesKt___SequencesKt.n(n(declarationDescriptor), 1);
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> n(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        return SequencesKt__SequencesKt.h(declarationDescriptor, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    @NotNull
    public static final CallableMemberDescriptor o(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        k21.h(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    @Nullable
    public static final ClassDescriptor p(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "<this>");
        for (g61 g61 : classDescriptor.getDefaultType().c().getSupertypes()) {
            if (!kotlin.reflect.jvm.internal.impl.builtins.b.a0(g61)) {
                ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
                if (f60.w(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean q(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "<this>");
        vx1 vx1 = (vx1) moduleDescriptor.getCapability(j61.a());
        return (vx1 == null ? null : (i61) vx1.a()) != null;
    }

    @Nullable
    public static final ClassDescriptor r(@NotNull ModuleDescriptor moduleDescriptor, @NotNull en0 en0, @NotNull LookupLocation lookupLocation) {
        k21.i(moduleDescriptor, "<this>");
        k21.i(en0, "topLevelClassFqName");
        k21.i(lookupLocation, "location");
        en0.d();
        en0 e = en0.e();
        k21.h(e, "topLevelClassFqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(e).getMemberScope();
        og1 g = en0.g();
        k21.h(g, "topLevelClassFqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(g, lookupLocation);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}
