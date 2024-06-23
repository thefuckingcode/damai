package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.g60;
import tb.h60;
import tb.i61;
import tb.k21;
import tb.mi;
import tb.og1;
import tb.oi;
import tb.r11;
import tb.si;
import tb.so2;
import tb.w11;
import tb.ww1;

/* compiled from: Taobao */
public final class NotFoundClasses {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final ModuleDescriptor b;
    @NotNull
    private final MemoizedFunctionToNotNull<en0, PackageFragmentDescriptor> c;
    @NotNull
    private final MemoizedFunctionToNotNull<a, ClassDescriptor> d;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final oi a;
        @NotNull
        private final List<Integer> b;

        public a(@NotNull oi oiVar, @NotNull List<Integer> list) {
            k21.i(oiVar, "classId");
            k21.i(list, "typeParametersCount");
            this.a = oiVar;
            this.b = list;
        }

        @NotNull
        public final oi a() {
            return this.a;
        }

        @NotNull
        public final List<Integer> b() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class b extends mi {
        private final boolean h;
        @NotNull
        private final List<TypeParameterDescriptor> i;
        @NotNull
        private final si j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull og1 og1, boolean z, int i2) {
            super(storageManager, declarationDescriptor, og1, SourceElement.NO_SOURCE, false);
            k21.i(storageManager, "storageManager");
            k21.i(declarationDescriptor, "container");
            k21.i(og1, "name");
            this.h = z;
            w11 w11 = ww1.h(0, i2);
            ArrayList arrayList = new ArrayList(n.q(w11, 10));
            Iterator it = w11.iterator();
            while (it.hasNext()) {
                int nextInt = ((r11) it).nextInt();
                arrayList.add(so2.l(this, Annotations.Companion.b(), false, Variance.INVARIANT, og1.f(k21.r("T", Integer.valueOf(nextInt))), nextInt, storageManager));
            }
            this.i = arrayList;
            this.j = new si(this, TypeParameterUtilsKt.d(this), d0.c(DescriptorUtilsKt.l(this).getBuiltIns().i()), storageManager);
        }

        @NotNull
        /* renamed from: e */
        public MemberScope.b getStaticScope() {
            return MemberScope.b.INSTANCE;
        }

        @NotNull
        /* renamed from: f */
        public si getTypeConstructor() {
            return this.j;
        }

        /* access modifiers changed from: protected */
        @NotNull
        /* renamed from: g */
        public MemberScope.b b(@NotNull i61 i61) {
            k21.i(i61, "kotlinTypeRefiner");
            return MemberScope.b.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        @NotNull
        public Annotations getAnnotations() {
            return Annotations.Companion.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return e0.d();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public h60 getVisibility() {
            h60 h60 = g60.PUBLIC;
            k21.h(h60, "PUBLIC");
            return h60;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // tb.mi, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isFun() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        @NotNull
        public String toString() {
            return "class " + getName() + " (not found)";
        }
    }

    public NotFoundClasses(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "module");
        this.a = storageManager;
        this.b = moduleDescriptor;
        this.c = storageManager.createMemoizedFunction(new NotFoundClasses$packageFragments$1(this));
        this.d = storageManager.createMemoizedFunction(new NotFoundClasses$classes$1(this));
    }

    @NotNull
    public final ClassDescriptor d(@NotNull oi oiVar, @NotNull List<Integer> list) {
        k21.i(oiVar, "classId");
        k21.i(list, "typeParametersCount");
        return this.d.invoke(new a(oiVar, list));
    }
}
