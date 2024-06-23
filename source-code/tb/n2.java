package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class n2 extends w30 implements TypeParameterDescriptor {
    private final Variance e;
    private final boolean f;
    private final int g;
    private final NotNullLazyValue<TypeConstructor> h;
    private final NotNullLazyValue<ib2> i;
    private final StorageManager j;

    /* compiled from: Taobao */
    class a implements Function0<TypeConstructor> {
        final /* synthetic */ StorageManager a;
        final /* synthetic */ SupertypeLoopChecker b;

        a(StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            this.a = storageManager;
            this.b = supertypeLoopChecker;
        }

        /* renamed from: a */
        public TypeConstructor invoke() {
            return new c(n2.this, this.a, this.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Function0<ib2> {
        final /* synthetic */ og1 a;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements Function0<MemberScope> {
            a() {
            }

            /* renamed from: a */
            public MemberScope invoke() {
                return TypeIntersectionScope.c("Scope for type parameter " + b.this.a.b(), n2.this.getUpperBounds());
            }
        }

        b(og1 og1) {
            this.a = og1;
        }

        /* renamed from: a */
        public ib2 invoke() {
            return KotlinTypeFactory.j(Annotations.Companion.b(), n2.this.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(new a()));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c extends AbstractTypeConstructor {
        private final SupertypeLoopChecker c;
        final /* synthetic */ n2 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull n2 n2Var, StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            super(storageManager);
            if (storageManager == null) {
                l(0);
            }
            this.d = n2Var;
            this.c = supertypeLoopChecker;
        }

        private static /* synthetic */ void l(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<g61> c() {
            List<g61> f = this.d.f();
            if (f == null) {
                l(1);
            }
            return f;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @Nullable
        public g61 d() {
            return me0.j("Cyclic upper bounds");
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker g() {
            SupertypeLoopChecker supertypeLoopChecker = this.c;
            if (supertypeLoopChecker == null) {
                l(5);
            }
            return supertypeLoopChecker;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.b g = DescriptorUtilsKt.g(this.d);
            if (g == null) {
                l(4);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            n2 n2Var = this.d;
            if (n2Var == null) {
                l(3);
            }
            return n2Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> emptyList = Collections.emptyList();
            if (emptyList == null) {
                l(2);
            }
            return emptyList;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public List<g61> i(@NotNull List<g61> list) {
            if (list == null) {
                l(7);
            }
            List<g61> d2 = this.d.d(list);
            if (d2 == null) {
                l(8);
            }
            return d2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public void k(@NotNull g61 g61) {
            if (g61 == null) {
                l(6);
            }
            this.d.e(g61);
        }

        public String toString() {
            return this.d.getName().toString();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected n2(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull Variance variance, boolean z, int i2, @NotNull SourceElement sourceElement, @NotNull SupertypeLoopChecker supertypeLoopChecker) {
        super(declarationDescriptor, annotations, og1, sourceElement);
        if (storageManager == null) {
            a(0);
        }
        if (declarationDescriptor == null) {
            a(1);
        }
        if (annotations == null) {
            a(2);
        }
        if (og1 == null) {
            a(3);
        }
        if (variance == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        if (supertypeLoopChecker == null) {
            a(6);
        }
        this.e = variance;
        this.f = z;
        this.g = i2;
        this.h = storageManager.createLazyValue(new a(storageManager, supertypeLoopChecker));
        this.i = storageManager.createLazyValue(new b(og1));
        this.j = storageManager;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, d);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public List<g61> d(@NotNull List<g61> list) {
        if (list == null) {
            a(12);
        }
        if (list == null) {
            a(13);
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public abstract void e(@NotNull g61 g61);

    /* access modifiers changed from: protected */
    @NotNull
    public abstract List<g61> f();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public ib2 getDefaultType() {
        ib2 ib2 = (ib2) this.i.invoke();
        if (ib2 == null) {
            a(10);
        }
        return ib2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public int getIndex() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.j;
        if (storageManager == null) {
            a(14);
        }
        return storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = (TypeConstructor) this.h.invoke();
        if (typeConstructor == null) {
            a(9);
        }
        return typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public List<g61> getUpperBounds() {
        List<g61> h2 = ((c) getTypeConstructor()).getSupertypes();
        if (h2 == null) {
            a(8);
        }
        return h2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public Variance getVariance() {
        Variance variance = this.e;
        if (variance == null) {
            a(7);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isReified() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, tb.v30
    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) super.getOriginal();
        if (typeParameterDescriptor == null) {
            a(11);
        }
        return typeParameterDescriptor;
    }
}
