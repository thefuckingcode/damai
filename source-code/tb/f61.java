package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class f61 implements DeserializedContainerSource {
    @NotNull
    private final KotlinJvmBinaryClass a;

    public f61(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable q01<e51> q01, boolean z, @NotNull DeserializedContainerAbiStability deserializedContainerAbiStability) {
        k21.i(kotlinJvmBinaryClass, "binaryClass");
        k21.i(deserializedContainerAbiStability, "abiStability");
        this.a = kotlinJvmBinaryClass;
    }

    @NotNull
    public final KotlinJvmBinaryClass a() {
        return this.a;
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
        return "Class '" + this.a.getClassId().b().b() + '\'';
    }

    @NotNull
    public String toString() {
        return ((Object) f61.class.getSimpleName()) + ": " + this.a;
    }
}
