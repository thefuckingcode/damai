package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaAnnotations annotations;
    private final LazyJavaResolverContext c;
    private final JavaTypeParameter javaTypeParameter;

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaTypeParameter javaTypeParameter2, int i, DeclarationDescriptor declarationDescriptor) {
        super(lazyJavaResolverContext.getStorageManager(), declarationDescriptor, javaTypeParameter2.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, lazyJavaResolverContext.getComponents().getSupertypeLoopChecker());
        Intrinsics.checkParameterIsNotNull(lazyJavaResolverContext, "c");
        Intrinsics.checkParameterIsNotNull(javaTypeParameter2, "javaTypeParameter");
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "containingDeclaration");
        this.c = lazyJavaResolverContext;
        this.javaTypeParameter = javaTypeParameter2;
        this.annotations = new LazyJavaAnnotations(lazyJavaResolverContext, javaTypeParameter2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl
    public LazyJavaAnnotations getAnnotations() {
        return this.annotations;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public List<KotlinType> resolveUpperBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            SimpleType anyType = this.c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkExpressionValueIsNotNull(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        Collection<JavaClassifierType> collection = upperBounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.getTypeResolver().transformJavaType(it.next(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }
}
