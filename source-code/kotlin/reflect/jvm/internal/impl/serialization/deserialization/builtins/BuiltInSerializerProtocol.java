package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.text.StringsKt;

/* compiled from: BuiltInSerializerProtocol.kt */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol INSTANCE = new BuiltInSerializerProtocol();

    /* JADX WARNING: Illegal instructions before constructor call */
    private BuiltInSerializerProtocol() {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension = BuiltInsProtoBuf.packageFqName;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "BuiltInsProtoBuf.packageFqName");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> generatedExtension2 = BuiltInsProtoBuf.constructorAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension2, "BuiltInsProtoBuf.constructorAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> generatedExtension3 = BuiltInsProtoBuf.classAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension3, "BuiltInsProtoBuf.classAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> generatedExtension4 = BuiltInsProtoBuf.functionAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension4, "BuiltInsProtoBuf.functionAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension5 = BuiltInsProtoBuf.propertyAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension5, "BuiltInsProtoBuf.propertyAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension6 = BuiltInsProtoBuf.propertyGetterAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension6, "BuiltInsProtoBuf.propertyGetterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension7 = BuiltInsProtoBuf.propertySetterAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension7, "BuiltInsProtoBuf.propertySetterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> generatedExtension8 = BuiltInsProtoBuf.enumEntryAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension8, "BuiltInsProtoBuf.enumEntryAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> generatedExtension9 = BuiltInsProtoBuf.compileTimeValue;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension9, "BuiltInsProtoBuf.compileTimeValue");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> generatedExtension10 = BuiltInsProtoBuf.parameterAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension10, "BuiltInsProtoBuf.parameterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> generatedExtension11 = BuiltInsProtoBuf.typeAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension11, "BuiltInsProtoBuf.typeAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> generatedExtension12 = BuiltInsProtoBuf.typeParameterAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension12, "BuiltInsProtoBuf.typeParameterAnnotation");
    }

    public final String getBuiltInsFilePath(FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        String asString = fqName.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "fqName.asString()");
        sb.append(StringsKt.replace$default(asString, '.', '/', false, 4, (Object) null));
        sb.append("/");
        sb.append(getBuiltInsFileName(fqName));
        return sb.toString();
    }

    public final String getBuiltInsFileName(FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        return shortName(fqName) + "." + "kotlin_builtins";
    }

    private final String shortName(FqName fqName) {
        if (fqName.isRoot()) {
            return "default-package";
        }
        String asString = fqName.shortName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "fqName.shortName().asString()");
        return asString;
    }
}
