package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

public final class ReflectKotlinClassFinderKt {
    public static final String toRuntimeFqName(ClassId classId) {
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "relativeClassName.asString()");
        String replace$default = StringsKt.replace$default(asString, '.', (char) Typography.dollar, false, 4, (Object) null);
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName, "packageFqName");
        if (packageFqName.isRoot()) {
            return replace$default;
        }
        return classId.getPackageFqName() + '.' + replace$default;
    }
}
