package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class nn0 extends j1 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final oi l = new oi(c.BUILT_INS_PACKAGE_FQ_NAME, og1.f("Function"));
    @NotNull
    private static final oi m = new oi(c.KOTLIN_REFLECT_FQ_NAME, og1.f("KFunction"));
    @NotNull
    private final StorageManager e;
    @NotNull
    private final PackageFragmentDescriptor f;
    @NotNull
    private final FunctionClassKind g;
    private final int h;
    @NotNull
    private final b i = new b(this);
    @NotNull
    private final on0 j;
    @NotNull
    private final List<TypeParameterDescriptor> k;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    private final class b extends k1 {
        final /* synthetic */ nn0 d;

        /* compiled from: Taobao */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(nn0 nn0) {
            super(nn0.e);
            k21.i(nn0, "this$0");
            this.d = nn0;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<g61> c() {
            List<oi> list;
            int i = a.$EnumSwitchMapping$0[this.d.o().ordinal()];
            if (i == 1) {
                list = l.e(nn0.l);
            } else if (i == 2) {
                list = m.j(nn0.m, new oi(c.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(this.d.k())));
            } else if (i == 3) {
                list = l.e(nn0.l);
            } else if (i == 4) {
                list = m.j(nn0.m, new oi(c.COROUTINES_PACKAGE_FQ_NAME_RELEASE, FunctionClassKind.SuspendFunction.numberedClassName(this.d.k())));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ModuleDescriptor containingDeclaration = this.d.f.getContainingDeclaration();
            ArrayList arrayList = new ArrayList(n.q(list, 10));
            for (oi oiVar : list) {
                ClassDescriptor a2 = FindClassInModuleKt.a(containingDeclaration, oiVar);
                if (a2 != null) {
                    List<TypeParameterDescriptor> list2 = CollectionsKt___CollectionsKt.u0(getParameters(), a2.getTypeConstructor().getParameters().size());
                    ArrayList arrayList2 = new ArrayList(n.q(list2, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor : list2) {
                        arrayList2.add(new vo2(typeParameterDescriptor.getDefaultType()));
                    }
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                    arrayList.add(KotlinTypeFactory.g(Annotations.Companion.b(), a2, arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + oiVar + " not found").toString());
                }
            }
            return CollectionsKt___CollectionsKt.y0(arrayList);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker g() {
            return SupertypeLoopChecker.a.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return this.d.k;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @NotNull
        /* renamed from: p */
        public nn0 n() {
            return this.d;
        }

        @NotNull
        public String toString() {
            return n().toString();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nn0(@NotNull StorageManager storageManager, @NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull FunctionClassKind functionClassKind, int i2) {
        super(storageManager, functionClassKind.numberedClassName(i2));
        k21.i(storageManager, "storageManager");
        k21.i(packageFragmentDescriptor, "containingDeclaration");
        k21.i(functionClassKind, "functionKind");
        this.e = storageManager;
        this.f = packageFragmentDescriptor;
        this.g = functionClassKind;
        this.h = i2;
        this.j = new on0(storageManager, this);
        ArrayList arrayList = new ArrayList();
        w11 w11 = new w11(1, i2);
        ArrayList arrayList2 = new ArrayList(n.q(w11, 10));
        Iterator it = w11.iterator();
        while (it.hasNext()) {
            e(arrayList, this, Variance.IN_VARIANCE, k21.r("P", Integer.valueOf(((r11) it).nextInt())));
            arrayList2.add(ur2.INSTANCE);
        }
        e(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.k = CollectionsKt___CollectionsKt.y0(arrayList);
    }

    private static final void e(ArrayList<TypeParameterDescriptor> arrayList, nn0 nn0, Variance variance, String str) {
        arrayList.add(so2.l(nn0, Annotations.Companion.b(), false, variance, og1.f(str), arrayList.size(), nn0.e));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        k21.h(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) s();
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
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
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public final int k() {
        return this.h;
    }

    @Nullable
    public Void l() {
        return null;
    }

    @NotNull
    /* renamed from: m */
    public List<ClassConstructorDescriptor> getConstructors() {
        return m.g();
    }

    @NotNull
    /* renamed from: n */
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.f;
    }

    @NotNull
    public final FunctionClassKind o() {
        return this.g;
    }

    @NotNull
    /* renamed from: p */
    public List<ClassDescriptor> getSealedSubclasses() {
        return m.g();
    }

    @NotNull
    /* renamed from: q */
    public MemberScope.b getStaticScope() {
        return MemberScope.b.INSTANCE;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: r */
    public on0 b(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this.j;
    }

    @Nullable
    public Void s() {
        return null;
    }

    @NotNull
    public String toString() {
        String b2 = getName().b();
        k21.h(b2, "name.asString()");
        return b2;
    }
}
