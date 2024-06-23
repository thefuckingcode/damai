package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: KotlinTypeRefiner.kt */
public abstract class KotlinTypeRefiner {
    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId classId);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor moduleDescriptor);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor);

    public abstract KotlinType refineType(KotlinType kotlinType);

    /* compiled from: KotlinTypeRefiner.kt */
    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = new Default();

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId classId) {
            Intrinsics.checkParameterIsNotNull(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkParameterIsNotNull(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor) {
            Intrinsics.checkParameterIsNotNull(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor) {
            Intrinsics.checkParameterIsNotNull(declarationDescriptor, "descriptor");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public KotlinType refineType(KotlinType kotlinType) {
            Intrinsics.checkParameterIsNotNull(kotlinType, "type");
            return kotlinType;
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "classDescriptor.typeConstructor");
            Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
            Intrinsics.checkExpressionValueIsNotNull(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            Intrinsics.checkParameterIsNotNull(function0, "compute");
            return (S) ((MemberScope) function0.invoke());
        }
    }
}
