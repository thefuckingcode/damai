package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b60;
import tb.dd2;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.x61;
import tb.y61;

/* compiled from: Taobao */
public final class LazyJavaPackageScope extends y61 {
    @NotNull
    private final JavaPackage m;
    @NotNull
    private final LazyJavaPackageFragment n;
    @NotNull
    private final NullableLazyValue<Set<String>> o;
    @NotNull
    private final MemoizedFunctionToNullable<a, ClassDescriptor> p;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final og1 a;
        @Nullable
        private final JavaClass b;

        public a(@NotNull og1 og1, @Nullable JavaClass javaClass) {
            k21.i(og1, "name");
            this.a = og1;
            this.b = javaClass;
        }

        @Nullable
        public final JavaClass a() {
            return this.b;
        }

        @NotNull
        public final og1 b() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && k21.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class b {

        /* compiled from: Taobao */
        public static final class a extends b {
            @NotNull
            private final ClassDescriptor a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(@NotNull ClassDescriptor classDescriptor) {
                super(null);
                k21.i(classDescriptor, "descriptor");
                this.a = classDescriptor;
            }

            @NotNull
            public final ClassDescriptor a() {
                return this.a;
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0272b extends b {
            @NotNull
            public static final C0272b INSTANCE = new C0272b();

            private C0272b() {
                super(null);
            }
        }

        /* compiled from: Taobao */
        public static final class c extends b {
            @NotNull
            public static final c INSTANCE = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(@NotNull x61 x61, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(x61);
        k21.i(x61, c.a);
        k21.i(javaPackage, "jPackage");
        k21.i(lazyJavaPackageFragment, "ownerDescriptor");
        this.m = javaPackage;
        this.n = lazyJavaPackageFragment;
        this.o = x61.e().createNullableLazyValue(new LazyJavaPackageScope$knownClassNamesInPackage$1(x61, this));
        this.p = x61.e().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$classes$1(this, x61));
    }

    private final ClassDescriptor G(og1 og1, JavaClass javaClass) {
        if (!dd2.b(og1)) {
            return null;
        }
        Set set = (Set) this.o.invoke();
        if (javaClass != null || set == null || set.contains(og1.b())) {
            return this.p.invoke(new a(og1, javaClass));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final b K(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return b.C0272b.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().c() != KotlinClassHeader.Kind.CLASS) {
            return b.c.INSTANCE;
        }
        ClassDescriptor m2 = p().a().b().m(kotlinJvmBinaryClass);
        return m2 != null ? new b.a(m2) : b.C0272b.INSTANCE;
    }

    @Nullable
    public final ClassDescriptor H(@NotNull JavaClass javaClass) {
        k21.i(javaClass, "javaClass");
        return G(javaClass.getName(), javaClass);
    }

    @Nullable
    /* renamed from: I */
    public ClassDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return G(og1, null);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: J */
    public LazyJavaPackageFragment v() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> e(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        if (!b60.a(b60.Companion.f())) {
            return e0.d();
        }
        Set<String> set = (Set) this.o.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            for (String str : set) {
                hashSet.add(og1.f(str));
            }
            return hashSet;
        }
        JavaPackage javaPackage = this.m;
        if (function1 == null) {
            function1 = FunctionsKt.a();
        }
        Collection<JavaClass> classes = javaPackage.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t : classes) {
            og1 name = t.getLightClassOriginKind() == LightClassOriginKind.SOURCE ? null : t.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> g(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        return e0.d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033 A[SYNTHETIC] */
    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        boolean z;
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        b60.a aVar = b60.Companion;
        if (!b60.a(aVar.f() | aVar.d())) {
            return m.g();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) o().invoke()) {
            DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof ClassDescriptor) {
                og1 name = ((ClassDescriptor) declarationDescriptor).getName();
                k21.h(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    z = true;
                    if (!z) {
                        arrayList.add(obj);
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return arrayList;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return m.g();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public DeclaredMemberIndex i() {
        return DeclaredMemberIndex.a.INSTANCE;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull og1 og1) {
        k21.i(collection, "result");
        k21.i(og1, "name");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> m(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        return e0.d();
    }
}
