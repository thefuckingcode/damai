package tb;

import com.vivo.push.PushClientConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class g51 implements DeserializedContainerSource {
    @NotNull
    private final a51 a;
    @Nullable
    private final a51 b;
    @Nullable
    private final KotlinJvmBinaryClass c;

    public g51(@NotNull a51 a51, @Nullable a51 a512, @NotNull ProtoBuf$Package protoBuf$Package, @NotNull NameResolver nameResolver, @Nullable q01<e51> q01, boolean z, @NotNull DeserializedContainerAbiStability deserializedContainerAbiStability, @Nullable KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        k21.i(a51, PushClientConstants.TAG_CLASS_NAME);
        k21.i(protoBuf$Package, "packageProto");
        k21.i(nameResolver, "nameResolver");
        k21.i(deserializedContainerAbiStability, "abiStability");
        this.a = a51;
        this.b = a512;
        this.c = kotlinJvmBinaryClass;
        GeneratedMessageLite.c<ProtoBuf$Package, Integer> cVar = JvmProtoBuf.packageModuleName;
        k21.h(cVar, "packageModuleName");
        Integer num = (Integer) fv1.a(protoBuf$Package, cVar);
        if (num != null) {
            nameResolver.getString(num.intValue());
        }
    }

    @NotNull
    public final oi a() {
        return new oi(this.a.g(), d());
    }

    @Nullable
    public final a51 b() {
        return this.b;
    }

    @Nullable
    public final KotlinJvmBinaryClass c() {
        return this.c;
    }

    @NotNull
    public final og1 d() {
        String f = this.a.f();
        k21.h(f, "className.internalName");
        og1 f2 = og1.f(StringsKt__StringsKt.M0(f, v00.DIR, null, 2, null));
        k21.h(f2, "identifier(className.internalName.substringAfterLast('/'))");
        return f2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        k21.h(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    @NotNull
    public String getPresentableString() {
        return "Class '" + a().b().b() + '\'';
    }

    @NotNull
    public String toString() {
        return ((Object) g51.class.getSimpleName()) + ": " + this.a;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public g51(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @NotNull ProtoBuf$Package protoBuf$Package, @NotNull NameResolver nameResolver, @Nullable q01<e51> q01, boolean z, @NotNull DeserializedContainerAbiStability deserializedContainerAbiStability) {
        this(r2, r1, protoBuf$Package, nameResolver, q01, z, deserializedContainerAbiStability, kotlinJvmBinaryClass);
        k21.i(kotlinJvmBinaryClass, "kotlinClass");
        k21.i(protoBuf$Package, "packageProto");
        k21.i(nameResolver, "nameResolver");
        k21.i(deserializedContainerAbiStability, "abiStability");
        a51 b2 = a51.b(kotlinJvmBinaryClass.getClassId());
        k21.h(b2, "byClassId(kotlinClass.classId)");
        String e = kotlinJvmBinaryClass.getClassHeader().e();
        a51 a51 = null;
        if (e != null) {
            if (e.length() > 0) {
                a51 = a51.d(e);
            }
        }
    }
}
