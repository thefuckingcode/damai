package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
public final /* synthetic */ class TypeDeserializer$typeConstructor$1$classNestingLevel$1 extends FunctionReference implements Function1<ClassId, ClassId> {
    public static final TypeDeserializer$typeConstructor$1$classNestingLevel$1 INSTANCE = new TypeDeserializer$typeConstructor$1$classNestingLevel$1();

    TypeDeserializer$typeConstructor$1$classNestingLevel$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ClassId.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    public final ClassId invoke(ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "p1");
        return classId.getOuterClassId();
    }
}
