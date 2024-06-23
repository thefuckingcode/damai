package kotlin.reflect.jvm.internal.impl.types;

import com.lzy.okgo.cache.CacheEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);

    public static final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        return Companion.create(typeConstructor, list);
    }

    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.createByConstructorsMap$default(Companion, map, false, 2, null);
    }

    public abstract TypeProjection get(TypeConstructor typeConstructor);

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, CacheEntity.KEY);
        return get(kotlinType.getConstructor());
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createByConstructorsMap(map, z);
        }

        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
            Intrinsics.checkParameterIsNotNull(map, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(map, z);
        }

        public final TypeSubstitution create(KotlinType kotlinType) {
            Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        public final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            Intrinsics.checkParameterIsNotNull(typeConstructor, "typeConstructor");
            Intrinsics.checkParameterIsNotNull(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull((List) parameters);
            if (!(typeParameterDescriptor != null ? typeParameterDescriptor.isCapturedFromOuterDeclaration() : false)) {
                return new IndexedParametersSubstitution(parameters, list);
            }
            Companion companion = this;
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters2, "typeConstructor.parameters");
            List<TypeParameterDescriptor> list2 = parameters2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                arrayList.add(t.getTypeConstructor());
            }
            return createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip(arrayList, list)), false, 2, null);
        }
    }
}
