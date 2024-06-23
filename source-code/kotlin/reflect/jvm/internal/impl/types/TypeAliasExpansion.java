package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeAliasExpansion.kt */
public final class TypeAliasExpansion {
    public static final Companion Companion = new Companion(null);
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeAliasExpansion, typeAliasDescriptor, list, map);
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeProjection getReplacement(TypeConstructor typeConstructor) {
        Intrinsics.checkParameterIsNotNull(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.mapping.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics.checkParameterIsNotNull(typeAliasDescriptor, "descriptor");
        if (!Intrinsics.areEqual(this.descriptor, typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.parent;
            return typeAliasExpansion != null ? typeAliasExpansion.isRecursion(typeAliasDescriptor) : false;
        }
    }

    /* compiled from: TypeAliasExpansion.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TypeAliasExpansion create(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
            Intrinsics.checkParameterIsNotNull(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkParameterIsNotNull(list, "arguments");
            TypeConstructor typeConstructor = typeAliasDescriptor.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "typeAliasDescriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            List<TypeParameterDescriptor> list2 = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                arrayList.add(t.getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, MapsKt.toMap(CollectionsKt.zip(arrayList, list)), null);
        }
    }
}
