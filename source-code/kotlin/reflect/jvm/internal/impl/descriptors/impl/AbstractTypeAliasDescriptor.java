package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.bp2;
import tb.g61;
import tb.h60;
import tb.i61;
import tb.ib2;
import tb.jl1;
import tb.k21;
import tb.og1;
import tb.w30;

/* compiled from: Taobao */
public abstract class AbstractTypeAliasDescriptor extends w30 implements TypeAliasDescriptor {
    @NotNull
    private final h60 e;
    private List<? extends TypeParameterDescriptor> f;
    @NotNull
    private final a g = new a(this);

    /* compiled from: Taobao */
    public static final class a implements TypeConstructor {
        final /* synthetic */ AbstractTypeAliasDescriptor a;

        a(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
            this.a = abstractTypeAliasDescriptor;
        }

        @NotNull
        /* renamed from: a */
        public TypeAliasDescriptor getDeclarationDescriptor() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public b getBuiltIns() {
            return DescriptorUtilsKt.g(getDeclarationDescriptor());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return this.a.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<g61> getSupertypes() {
            Collection<g61> supertypes = getDeclarationDescriptor().getUnderlyingType().c().getSupertypes();
            k21.h(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
            return supertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull i61 i61) {
            k21.i(i61, "kotlinTypeRefiner");
            return this;
        }

        @NotNull
        public String toString() {
            return "[typealias " + getDeclarationDescriptor().getName().b() + jl1.ARRAY_END;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull SourceElement sourceElement, @NotNull h60 h60) {
        super(declarationDescriptor, annotations, og1, sourceElement);
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(annotations, "annotations");
        k21.i(og1, "name");
        k21.i(sourceElement, "sourceElement");
        k21.i(h60, "visibilityImpl");
        this.e = h60;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        k21.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitTypeAliasDescriptor(this, d);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final ib2 d() {
        ClassDescriptor classDescriptor = getClassDescriptor();
        MemberScope unsubstitutedMemberScope = classDescriptor == null ? null : classDescriptor.getUnsubstitutedMemberScope();
        if (unsubstitutedMemberScope == null) {
            unsubstitutedMemberScope = MemberScope.b.INSTANCE;
        }
        ib2 t = bp2.t(this, unsubstitutedMemberScope, new AbstractTypeAliasDescriptor$computeDefaultType$1(this));
        k21.h(t, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        return t;
    }

    @NotNull
    /* renamed from: e */
    public TypeAliasDescriptor getOriginal() {
        return (TypeAliasDescriptor) super.getOriginal();
    }

    @NotNull
    public final Collection<TypeAliasConstructorDescriptor> f() {
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            return m.g();
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        k21.h(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (T t : constructors) {
            TypeAliasConstructorDescriptorImpl.a aVar = TypeAliasConstructorDescriptorImpl.Companion;
            StorageManager storageManager = getStorageManager();
            k21.h(t, AdvanceSetting.NETWORK_TYPE);
            TypeAliasConstructorDescriptor b = aVar.b(storageManager, this, t);
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract List<TypeParameterDescriptor> g();

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.f;
        if (list != null) {
            return list;
        }
        k21.A("declaredTypeParametersImpl");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return Modality.FINAL;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract StorageManager getStorageManager();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public h60 getVisibility() {
        return this.e;
    }

    public final void h(@NotNull List<? extends TypeParameterDescriptor> list) {
        k21.i(list, "declaredTypeParameters");
        this.f = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return bp2.c(getUnderlyingType(), new AbstractTypeAliasDescriptor$isInner$1(this));
    }

    @Override // tb.v30
    @NotNull
    public String toString() {
        return k21.r("typealias ", getName().b());
    }
}
