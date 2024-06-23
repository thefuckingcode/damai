package kotlin.reflect.jvm.internal.impl.types;

import com.lzy.okgo.cache.CacheEntity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSubstitution.kt */
public final class TypeSubstitution$Companion$EMPTY$1 extends TypeSubstitution {
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public Void get(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, CacheEntity.KEY);
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return true;
    }

    public String toString() {
        return "Empty TypeSubstitution";
    }

    TypeSubstitution$Companion$EMPTY$1() {
    }
}
