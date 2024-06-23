package kotlin.reflect.jvm.internal.impl.types;

import com.lzy.okgo.cache.CacheEntity;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSubstitution.kt */
public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {
    final /* synthetic */ boolean $approximateCapturedTypes;
    final /* synthetic */ Map $map;

    TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map map, boolean z) {
        this.$map = map;
        this.$approximateCapturedTypes = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics.checkParameterIsNotNull(typeConstructor, CacheEntity.KEY);
        return (TypeProjection) this.$map.get(typeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.$map.isEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        return this.$approximateCapturedTypes;
    }
}
