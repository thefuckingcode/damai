package tb;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class j1 extends xe1 {
    private final og1 a;
    protected final NotNullLazyValue<ib2> b;
    private final NotNullLazyValue<MemberScope> c;
    private final NotNullLazyValue<ReceiverParameterDescriptor> d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Function0<ib2> {

        /* access modifiers changed from: package-private */
        /* renamed from: tb.j1$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0304a implements Function1<i61, ib2> {
            C0304a() {
            }

            /* renamed from: a */
            public ib2 invoke(i61 i61) {
                ClassifierDescriptor e = i61.e(j1.this);
                if (e == null) {
                    return (ib2) j1.this.b.invoke();
                }
                if (e instanceof TypeAliasDescriptor) {
                    return KotlinTypeFactory.b((TypeAliasDescriptor) e, bp2.g(e.getTypeConstructor().getParameters()));
                }
                if (e instanceof xe1) {
                    return bp2.u(e.getTypeConstructor().refine(i61), ((xe1) e).b(i61), this);
                }
                return e.getDefaultType();
            }
        }

        a() {
        }

        /* renamed from: a */
        public ib2 invoke() {
            j1 j1Var = j1.this;
            return bp2.t(j1Var, j1Var.getUnsubstitutedMemberScope(), new C0304a());
        }
    }

    /* compiled from: Taobao */
    class b implements Function0<MemberScope> {
        b() {
        }

        /* renamed from: a */
        public MemberScope invoke() {
            return new c11(j1.this.getUnsubstitutedMemberScope());
        }
    }

    /* compiled from: Taobao */
    class c implements Function0<ReceiverParameterDescriptor> {
        c() {
        }

        /* renamed from: a */
        public ReceiverParameterDescriptor invoke() {
            return new u61(j1.this);
        }
    }

    public j1(@NotNull StorageManager storageManager, @NotNull og1 og1) {
        if (storageManager == null) {
            c(0);
        }
        if (og1 == null) {
            c(1);
        }
        this.a = og1;
        this.b = storageManager.createLazyValue(new a());
        this.c = storageManager.createLazyValue(new b());
        this.d = storageManager.createLazyValue(new c());
    }

    private static /* synthetic */ void c(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // tb.xe1
    @NotNull
    public MemberScope a(@NotNull xo2 xo2, @NotNull i61 i61) {
        if (xo2 == null) {
            c(9);
        }
        if (i61 == null) {
            c(10);
        }
        if (xo2.f()) {
            MemberScope b2 = b(i61);
            if (b2 == null) {
                c(11);
            }
            return b2;
        }
        return new SubstitutingScope(b(i61), TypeSubstitutor.g(xo2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d2);
    }

    @NotNull
    /* renamed from: d */
    public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            c(17);
        }
        if (typeSubstitutor.k()) {
            return this;
        }
        return new b71(this, typeSubstitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ib2 getDefaultType() {
        ib2 ib2 = (ib2) this.b.invoke();
        if (ib2 == null) {
            c(19);
        }
        return ib2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getMemberScope(@NotNull xo2 xo2) {
        if (xo2 == null) {
            c(14);
        }
        MemberScope a2 = a(xo2, DescriptorUtilsKt.k(f60.g(this)));
        if (a2 == null) {
            c(15);
        }
        return a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    @NotNull
    public og1 getName() {
        og1 og1 = this.a;
        if (og1 == null) {
            c(2);
        }
        return og1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ClassDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) this.d.invoke();
        if (receiverParameterDescriptor == null) {
            c(5);
        }
        return receiverParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope = (MemberScope) this.c.invoke();
        if (memberScope == null) {
            c(4);
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope b2 = b(DescriptorUtilsKt.k(f60.g(this)));
        if (b2 == null) {
            c(16);
        }
        return b2;
    }
}
