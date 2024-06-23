package tb;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* compiled from: Taobao */
public final class u41 {
    public static final og1 DEFAULT_ANNOTATION_MEMBER_NAME = og1.f("value");
    public static final en0 DEFAULT_NULL_FQ_NAME = new en0("kotlin.annotations.jvm.internal.DefaultNull");
    public static final en0 DEFAULT_VALUE_FQ_NAME = new en0("kotlin.annotations.jvm.internal.DefaultValue");
    public static final en0 DEPRECATED_ANNOTATION = new en0(Deprecated.class.getCanonicalName());
    public static final en0 DOCUMENTED_ANNOTATION = new en0(Documented.class.getCanonicalName());
    public static final en0 ENHANCED_MUTABILITY_ANNOTATION = new en0("kotlin.jvm.internal.EnhancedMutability");
    public static final en0 ENHANCED_NULLABILITY_ANNOTATION = new en0("kotlin.jvm.internal.EnhancedNullability");
    public static final en0 JETBRAINS_MUTABLE_ANNOTATION = new en0("org.jetbrains.annotations.Mutable");
    public static final en0 JETBRAINS_NOT_NULL_ANNOTATION = new en0("org.jetbrains.annotations.NotNull");
    public static final en0 JETBRAINS_NULLABLE_ANNOTATION = new en0("org.jetbrains.annotations.Nullable");
    public static final en0 JETBRAINS_READONLY_ANNOTATION = new en0("org.jetbrains.annotations.ReadOnly");
    public static final en0 KOTLIN_JVM_INTERNAL = new en0("kotlin.jvm.internal");
    public static final String METADATA_DESC;
    public static final en0 METADATA_FQ_NAME;
    public static final en0 MUTABLE_ANNOTATION = new en0("kotlin.annotations.jvm.Mutable");
    public static final en0 PARAMETER_NAME_FQ_NAME = new en0("kotlin.annotations.jvm.internal.ParameterName");
    public static final en0 PURELY_IMPLEMENTS_ANNOTATION = new en0("kotlin.jvm.PurelyImplements");
    public static final en0 READONLY_ANNOTATION = new en0("kotlin.annotations.jvm.ReadOnly");
    public static final en0 REPEATABLE_ANNOTATION = new en0("java.lang.annotation.Repeatable");
    public static final en0 RETENTION_ANNOTATION = new en0(Retention.class.getCanonicalName());
    public static final en0 TARGET_ANNOTATION = new en0(Target.class.getCanonicalName());

    static {
        en0 en0 = new en0("kotlin.Metadata");
        METADATA_FQ_NAME = en0;
        METADATA_DESC = "L" + a51.c(en0).f() + ";";
    }
}
