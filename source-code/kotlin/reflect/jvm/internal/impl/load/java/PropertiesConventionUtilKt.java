package kotlin.reflect.jvm.internal.impl.load.java;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* compiled from: propertiesConventionUtil.kt */
public final class PropertiesConventionUtilKt {
    public static final Name propertyNameByGetMethodName(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "methodName");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(name, "get", false, null, 12, null);
        return propertyNameFromAccessorMethodName$default != null ? propertyNameFromAccessorMethodName$default : propertyNameFromAccessorMethodName$default(name, "is", false, null, 8, null);
    }

    public static final Name propertyNameBySetMethodName(Name name, boolean z) {
        Intrinsics.checkParameterIsNotNull(name, "methodName");
        return propertyNameFromAccessorMethodName$default(name, "set", false, z ? "is" : null, 4, null);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "methodName");
        return CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(name, false), propertyNameBySetMethodName(name, true)});
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z, str2);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z, String str2) {
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        Intrinsics.checkExpressionValueIsNotNull(identifier, "methodName.identifier");
        if (!StringsKt.startsWith$default(identifier, str, false, 2, (Object) null) || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && 'z' >= charAt) {
            return null;
        }
        if (str2 != null) {
            return Name.identifier(str2 + StringsKt.removePrefix(identifier, (CharSequence) str));
        } else if (!z) {
            return name;
        } else {
            String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(identifier, (CharSequence) str), true);
            if (!Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                return null;
            }
            return Name.identifier(decapitalizeSmartForCompiler);
        }
    }

    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        if (JvmAbi.isGetterName(asString)) {
            return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
        }
        if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }
}
