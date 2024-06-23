package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class b71 extends xe1 {
    private final xe1 a;
    private final TypeSubstitutor b;
    private TypeSubstitutor c;
    private List<TypeParameterDescriptor> d;
    private List<TypeParameterDescriptor> e;
    private TypeConstructor f;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Function1<TypeParameterDescriptor, Boolean> {
        a(b71 b71) {
        }

        /* renamed from: a */
        public Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
            return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
        }
    }

    public b71(xe1 xe1, TypeSubstitutor typeSubstitutor) {
        this.a = xe1;
        this.b = typeSubstitutor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00de A[ADDED_TO_REGION] */
    private static /* synthetic */ void c(int i) {
        String format;
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? 3 : 2)];
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i != 13) {
                                    if (i != 22) {
                                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                                    } else {
                                        objArr[0] = "substitutor";
                                    }
                                    switch (i) {
                                        case 2:
                                        case 3:
                                        case 5:
                                        case 6:
                                        case 8:
                                        case 10:
                                        case 13:
                                        case 22:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                                            break;
                                        case 4:
                                        case 7:
                                        case 9:
                                        case 11:
                                            objArr[1] = "getMemberScope";
                                            break;
                                        case 12:
                                        case 14:
                                            objArr[1] = "getUnsubstitutedMemberScope";
                                            break;
                                        case 15:
                                            objArr[1] = "getStaticScope";
                                            break;
                                        case 16:
                                            objArr[1] = "getDefaultType";
                                            break;
                                        case 17:
                                            objArr[1] = "getConstructors";
                                            break;
                                        case 18:
                                            objArr[1] = "getAnnotations";
                                            break;
                                        case 19:
                                            objArr[1] = "getName";
                                            break;
                                        case 20:
                                            objArr[1] = "getOriginal";
                                            break;
                                        case 21:
                                            objArr[1] = "getContainingDeclaration";
                                            break;
                                        case 23:
                                            objArr[1] = "substitute";
                                            break;
                                        case 24:
                                            objArr[1] = "getKind";
                                            break;
                                        case 25:
                                            objArr[1] = "getModality";
                                            break;
                                        case 26:
                                            objArr[1] = "getVisibility";
                                            break;
                                        case 27:
                                            objArr[1] = "getUnsubstitutedInnerClassesScope";
                                            break;
                                        case 28:
                                            objArr[1] = "getSource";
                                            break;
                                        case 29:
                                            objArr[1] = "getDeclaredTypeParameters";
                                            break;
                                        case 30:
                                            objArr[1] = "getSealedSubclasses";
                                            break;
                                        default:
                                            objArr[1] = "getTypeConstructor";
                                            break;
                                    }
                                    if (i != 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10) {
                                        objArr[2] = "getMemberScope";
                                    } else if (i == 13) {
                                        objArr[2] = "getUnsubstitutedMemberScope";
                                    } else if (i == 22) {
                                        objArr[2] = "substitute";
                                    }
                                    format = String.format(str, objArr);
                                    if (i != 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) {
                                        throw new IllegalArgumentException(format);
                                    }
                                    throw new IllegalStateException(format);
                                }
                            }
                        }
                    }
                }
                objArr[0] = "typeSubstitution";
                switch (i) {
                }
                if (i != 2) {
                }
                objArr[2] = "getMemberScope";
                format = String.format(str, objArr);
                if (i != 2) {
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "kotlinTypeRefiner";
            switch (i) {
            }
            if (i != 2) {
            }
            objArr[2] = "getMemberScope";
            format = String.format(str, objArr);
            if (i != 2) {
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "typeArguments";
        switch (i) {
        }
        if (i != 2) {
        }
        objArr[2] = "getMemberScope";
        format = String.format(str, objArr);
        if (i != 2) {
        }
        throw new IllegalArgumentException(format);
    }

    private TypeSubstitutor d() {
        if (this.c == null) {
            if (this.b.k()) {
                this.c = this.b;
            } else {
                List<TypeParameterDescriptor> parameters = this.a.getTypeConstructor().getParameters();
                this.d = new ArrayList(parameters.size());
                this.c = d60.b(parameters, this.b.j(), this, this.d);
                this.e = CollectionsKt___CollectionsKt.N(this.d, new a(this));
            }
        }
        return this.c;
    }

    @Override // tb.xe1
    @NotNull
    public MemberScope a(@NotNull xo2 xo2, @NotNull i61 i61) {
        if (xo2 == null) {
            c(5);
        }
        if (i61 == null) {
            c(6);
        }
        MemberScope a2 = this.a.a(xo2, i61);
        if (!this.b.k()) {
            return new SubstitutingScope(a2, d());
        }
        if (a2 == null) {
            c(7);
        }
        return a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d2);
    }

    @Override // tb.xe1
    @NotNull
    public MemberScope b(@NotNull i61 i61) {
        if (i61 == null) {
            c(13);
        }
        MemberScope b2 = this.a.b(i61);
        if (!this.b.k()) {
            return new SubstitutingScope(b2, d());
        }
        if (b2 == null) {
            c(14);
        }
        return b2;
    }

    @NotNull
    /* renamed from: e */
    public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            c(22);
        }
        if (typeSubstitutor.k()) {
            return this;
        }
        return new b71(this, TypeSubstitutor.h(typeSubstitutor.j(), d().j()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.a.getAnnotations();
        if (annotations == null) {
            c(18);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.a.getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.a.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            arrayList.add(((ClassConstructorDescriptor) classConstructorDescriptor.newCopyBuilder().setOriginal(classConstructorDescriptor.getOriginal()).setModality(classConstructorDescriptor.getModality()).setVisibility(classConstructorDescriptor.getVisibility()).setKind(classConstructorDescriptor.getKind()).setCopyOverrides(false).build()).substitute(d()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        if (containingDeclaration == null) {
            c(21);
        }
        return containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        d();
        List<TypeParameterDescriptor> list = this.e;
        if (list == null) {
            c(29);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ib2 getDefaultType() {
        ib2 j = KotlinTypeFactory.j(getAnnotations(), getTypeConstructor(), bp2.g(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (j == null) {
            c(16);
        }
        return j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        ClassKind kind = this.a.getKind();
        if (kind == null) {
            c(24);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getMemberScope(@NotNull xo2 xo2) {
        if (xo2 == null) {
            c(10);
        }
        MemberScope a2 = a(xo2, DescriptorUtilsKt.k(f60.g(this)));
        if (a2 == null) {
            c(11);
        }
        return a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.a.getModality();
        if (modality == null) {
            c(25);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    @NotNull
    public og1 getName() {
        og1 name = this.a.getName();
        if (name == null) {
            c(19);
        }
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.a.getSealedSubclasses();
        if (sealedSubclasses == null) {
            c(30);
        }
        return sealedSubclasses;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            c(28);
        }
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope staticScope = this.a.getStaticScope();
        if (staticScope == null) {
            c(15);
        }
        return staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.a.getTypeConstructor();
        if (this.b.k()) {
            if (typeConstructor == null) {
                c(0);
            }
            return typeConstructor;
        }
        if (this.f == null) {
            TypeSubstitutor d2 = d();
            Collection<g61> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            for (g61 g61 : supertypes) {
                arrayList.add(d2.q(g61, Variance.INVARIANT));
            }
            this.f = new si(this, this.d, arrayList, LockBasedStorageManager.NO_LOCKS);
        }
        TypeConstructor typeConstructor2 = this.f;
        if (typeConstructor2 == null) {
            c(1);
        }
        return typeConstructor2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.a.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope == null) {
            c(27);
        }
        return unsubstitutedInnerClassesScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope b2 = b(DescriptorUtilsKt.k(f60.g(this.a)));
        if (b2 == null) {
            c(12);
        }
        return b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.a.getUnsubstitutedPrimaryConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public h60 getVisibility() {
        h60 visibility = this.a.getVisibility();
        if (visibility == null) {
            c(26);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.a.isActual();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return this.a.isCompanionObject();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return this.a.isData();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.a.isExpect();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.a.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return this.a.isFun();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return this.a.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.a.isInner();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return this.a.isValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ClassDescriptor getOriginal() {
        ClassDescriptor original = this.a.getOriginal();
        if (original == null) {
            c(20);
        }
        return original;
    }
}
