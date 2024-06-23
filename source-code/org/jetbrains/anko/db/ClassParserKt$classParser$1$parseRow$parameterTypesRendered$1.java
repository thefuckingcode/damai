package org.jetbrains.anko.db;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "it", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 1, 11})
/* compiled from: ClassParser.kt */
final class ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1 extends Lambda implements Function1<Class<?>, String> {
    public static final ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1 INSTANCE = new ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1();

    ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1() {
        super(1);
    }

    public final String invoke(Class<?> cls) {
        Intrinsics.checkExpressionValueIsNotNull(cls, "it");
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkExpressionValueIsNotNull(canonicalName, "it.canonicalName");
        return canonicalName;
    }
}
