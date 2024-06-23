package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.g61;
import tb.rn0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class MemberDeserializer$containsSuspendFunctionType$1 extends PropertyReference1 {
    public static final MemberDeserializer$containsSuspendFunctionType$1 INSTANCE = new MemberDeserializer$containsSuspendFunctionType$1();

    /* synthetic */ MemberDeserializer$containsSuspendFunctionType$1() {
    }

    @Override // kotlin.reflect.KProperty1
    @Nullable
    public Object get(@Nullable Object obj) {
        return Boolean.valueOf(rn0.o((g61) obj));
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        return "isSuspendFunctionType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public KDeclarationContainer getOwner() {
        return dz1.d(rn0.class, "deserialization");
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public String getSignature() {
        return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }
}
