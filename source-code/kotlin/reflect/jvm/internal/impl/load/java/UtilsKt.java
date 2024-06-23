package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix;
import kotlin.reflect.jvm.internal.impl.utils.NumbersKt;
import kotlin.text.StringsKt;

/* compiled from: utils.kt */
public final class UtilsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bf, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4) != false) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public static final JavaDefaultValue lexicalCastFrom(KotlinType kotlinType, String str) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$lexicalCastFrom");
        Intrinsics.checkParameterIsNotNull(str, "value");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.getKind() == ClassKind.ENUM_CLASS) {
                MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
                Name identifier = Name.identifier(str);
                Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(value)");
                ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(identifier, NoLookupLocation.FROM_BACKEND);
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) contributedClassifier;
                if (classDescriptor2.getKind() == ClassKind.ENUM_ENTRY) {
                    return new EnumEntry(classDescriptor2);
                }
                return null;
            }
        }
        KotlinType makeNotNullable = TypeUtilsKt.makeNotNullable(kotlinType);
        NumberWithRadix extractRadix = NumbersKt.extractRadix(str);
        String component1 = extractRadix.component1();
        int component2 = extractRadix.component2();
        try {
            if (KotlinBuiltIns.isBoolean(makeNotNullable)) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str));
            } else if (KotlinBuiltIns.isChar(makeNotNullable)) {
                obj = StringsKt.singleOrNull(str);
            } else if (KotlinBuiltIns.isByte(makeNotNullable)) {
                obj = StringsKt.toByteOrNull(component1, component2);
            } else if (KotlinBuiltIns.isShort(makeNotNullable)) {
                obj = StringsKt.toShortOrNull(component1, component2);
            } else if (KotlinBuiltIns.isInt(makeNotNullable)) {
                obj = StringsKt.toIntOrNull(component1, component2);
            } else if (KotlinBuiltIns.isLong(makeNotNullable)) {
                obj = StringsKt.toLongOrNull(component1, component2);
            } else if (KotlinBuiltIns.isFloat(makeNotNullable)) {
                obj = StringsKt.toFloatOrNull(str);
            } else {
                obj = KotlinBuiltIns.isDouble(makeNotNullable) ? StringsKt.toDoubleOrNull(str) : str;
            }
        } catch (IllegalArgumentException unused) {
        }
        if (obj == null) {
            return new Constant(obj);
        }
        return null;
        obj = null;
        if (obj == null) {
        }
    }
}
