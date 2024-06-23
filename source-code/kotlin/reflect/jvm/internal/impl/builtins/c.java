package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.fn0;
import tb.k21;
import tb.og1;
import tb.oi;
import tb.qj;

/* compiled from: Taobao */
public final class c {
    @JvmField
    @NotNull
    public static final en0 ANNOTATION_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final en0 BUILT_INS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final Set<en0> BUILT_INS_PACKAGE_FQ_NAMES;
    @JvmField
    @NotNull
    public static final og1 BUILT_INS_PACKAGE_NAME;
    @JvmField
    @NotNull
    public static final en0 COLLECTIONS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final en0 CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final en0 CONTINUATION_INTERFACE_FQ_NAME_RELEASE;
    @JvmField
    @NotNull
    public static final en0 COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final en0 COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final en0 COROUTINES_PACKAGE_FQ_NAME_RELEASE;
    @JvmField
    @NotNull
    public static final og1 ENUM_VALUES;
    @JvmField
    @NotNull
    public static final og1 ENUM_VALUE_OF;
    @NotNull
    public static final c INSTANCE = new c();
    @JvmField
    @NotNull
    public static final en0 KOTLIN_REFLECT_FQ_NAME;
    @JvmField
    @NotNull
    public static final List<String> PREFIXES = m.j("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
    @JvmField
    @NotNull
    public static final en0 RANGES_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final en0 RESULT_FQ_NAME = new en0("kotlin.Result");
    @JvmField
    @NotNull
    public static final en0 TEXT_PACKAGE_FQ_NAME;

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static final a INSTANCE;
        @JvmField
        @NotNull
        public static final fn0 _boolean;
        @JvmField
        @NotNull
        public static final fn0 _byte;
        @JvmField
        @NotNull
        public static final fn0 _char;
        @JvmField
        @NotNull
        public static final fn0 _double;
        @JvmField
        @NotNull
        public static final fn0 _enum;
        @JvmField
        @NotNull
        public static final fn0 _float;
        @JvmField
        @NotNull
        public static final fn0 _int;
        @JvmField
        @NotNull
        public static final fn0 _long;
        @JvmField
        @NotNull
        public static final fn0 _short;
        @JvmField
        @NotNull
        public static final en0 annotation;
        @JvmField
        @NotNull
        public static final en0 annotationRetention;
        @JvmField
        @NotNull
        public static final en0 annotationTarget;
        @JvmField
        @NotNull
        public static final fn0 any;
        @JvmField
        @NotNull
        public static final fn0 array;
        @JvmField
        @NotNull
        public static final Map<fn0, PrimitiveType> arrayClassFqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final fn0 charSequence;
        @JvmField
        @NotNull
        public static final fn0 cloneable;
        @JvmField
        @NotNull
        public static final en0 collection;
        @JvmField
        @NotNull
        public static final en0 comparable;
        @JvmField
        @NotNull
        public static final en0 deprecated;
        @JvmField
        @NotNull
        public static final en0 deprecatedSinceKotlin;
        @JvmField
        @NotNull
        public static final en0 deprecationLevel;
        @JvmField
        @NotNull
        public static final en0 extensionFunctionType;
        @JvmField
        @NotNull
        public static final Map<fn0, PrimitiveType> fqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final fn0 functionSupertype;
        @JvmField
        @NotNull
        public static final fn0 intRange;
        @JvmField
        @NotNull
        public static final en0 iterable;
        @JvmField
        @NotNull
        public static final en0 iterator;
        @JvmField
        @NotNull
        public static final fn0 kCallable = f("KCallable");
        @JvmField
        @NotNull
        public static final fn0 kClass = f("KClass");
        @JvmField
        @NotNull
        public static final fn0 kDeclarationContainer = f("KDeclarationContainer");
        @JvmField
        @NotNull
        public static final fn0 kMutableProperty0 = f("KMutableProperty0");
        @JvmField
        @NotNull
        public static final fn0 kMutableProperty1 = f("KMutableProperty1");
        @JvmField
        @NotNull
        public static final fn0 kMutableProperty2 = f("KMutableProperty2");
        @JvmField
        @NotNull
        public static final fn0 kMutablePropertyFqName = f("KMutableProperty");
        @JvmField
        @NotNull
        public static final oi kProperty;
        @JvmField
        @NotNull
        public static final fn0 kProperty0 = f("KProperty0");
        @JvmField
        @NotNull
        public static final fn0 kProperty1 = f("KProperty1");
        @JvmField
        @NotNull
        public static final fn0 kProperty2 = f("KProperty2");
        @JvmField
        @NotNull
        public static final fn0 kPropertyFqName;
        @JvmField
        @NotNull
        public static final en0 list;
        @JvmField
        @NotNull
        public static final en0 listIterator;
        @JvmField
        @NotNull
        public static final fn0 longRange;
        @JvmField
        @NotNull
        public static final en0 map;
        @JvmField
        @NotNull
        public static final en0 mapEntry;
        @JvmField
        @NotNull
        public static final en0 mustBeDocumented;
        @JvmField
        @NotNull
        public static final en0 mutableCollection;
        @JvmField
        @NotNull
        public static final en0 mutableIterable;
        @JvmField
        @NotNull
        public static final en0 mutableIterator;
        @JvmField
        @NotNull
        public static final en0 mutableList;
        @JvmField
        @NotNull
        public static final en0 mutableListIterator;
        @JvmField
        @NotNull
        public static final en0 mutableMap;
        @JvmField
        @NotNull
        public static final en0 mutableMapEntry;
        @JvmField
        @NotNull
        public static final en0 mutableSet;
        @JvmField
        @NotNull
        public static final fn0 nothing;
        @JvmField
        @NotNull
        public static final fn0 number;
        @JvmField
        @NotNull
        public static final en0 parameterName;
        @JvmField
        @NotNull
        public static final Set<og1> primitiveArrayTypeShortNames;
        @JvmField
        @NotNull
        public static final Set<og1> primitiveTypeShortNames;
        @JvmField
        @NotNull
        public static final en0 publishedApi;
        @JvmField
        @NotNull
        public static final en0 repeatable;
        @JvmField
        @NotNull
        public static final en0 replaceWith;
        @JvmField
        @NotNull
        public static final en0 retention;
        @JvmField
        @NotNull
        public static final en0 set;
        @JvmField
        @NotNull
        public static final fn0 string;
        @JvmField
        @NotNull
        public static final en0 suppress;
        @JvmField
        @NotNull
        public static final en0 target;
        @JvmField
        @NotNull
        public static final en0 throwable;
        @JvmField
        @NotNull
        public static final oi uByte;
        @JvmField
        @NotNull
        public static final en0 uByteArrayFqName;
        @JvmField
        @NotNull
        public static final en0 uByteFqName;
        @JvmField
        @NotNull
        public static final oi uInt;
        @JvmField
        @NotNull
        public static final en0 uIntArrayFqName;
        @JvmField
        @NotNull
        public static final en0 uIntFqName;
        @JvmField
        @NotNull
        public static final oi uLong;
        @JvmField
        @NotNull
        public static final en0 uLongArrayFqName;
        @JvmField
        @NotNull
        public static final en0 uLongFqName;
        @JvmField
        @NotNull
        public static final oi uShort;
        @JvmField
        @NotNull
        public static final en0 uShortArrayFqName;
        @JvmField
        @NotNull
        public static final en0 uShortFqName;
        @JvmField
        @NotNull
        public static final fn0 unit;
        @JvmField
        @NotNull
        public static final en0 unsafeVariance;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            any = aVar.d("Any");
            nothing = aVar.d("Nothing");
            cloneable = aVar.d("Cloneable");
            suppress = aVar.c("Suppress");
            unit = aVar.d("Unit");
            charSequence = aVar.d("CharSequence");
            string = aVar.d("String");
            array = aVar.d("Array");
            _boolean = aVar.d("Boolean");
            _char = aVar.d("Char");
            _byte = aVar.d("Byte");
            _short = aVar.d("Short");
            _int = aVar.d("Int");
            _long = aVar.d("Long");
            _float = aVar.d("Float");
            _double = aVar.d("Double");
            number = aVar.d("Number");
            _enum = aVar.d("Enum");
            functionSupertype = aVar.d("Function");
            throwable = aVar.c("Throwable");
            comparable = aVar.c("Comparable");
            intRange = aVar.e("IntRange");
            longRange = aVar.e("LongRange");
            deprecated = aVar.c("Deprecated");
            deprecatedSinceKotlin = aVar.c("DeprecatedSinceKotlin");
            deprecationLevel = aVar.c("DeprecationLevel");
            replaceWith = aVar.c("ReplaceWith");
            extensionFunctionType = aVar.c("ExtensionFunctionType");
            parameterName = aVar.c("ParameterName");
            annotation = aVar.c("Annotation");
            target = aVar.a("Target");
            annotationTarget = aVar.a("AnnotationTarget");
            annotationRetention = aVar.a("AnnotationRetention");
            retention = aVar.a("Retention");
            repeatable = aVar.a("Repeatable");
            mustBeDocumented = aVar.a("MustBeDocumented");
            unsafeVariance = aVar.c("UnsafeVariance");
            publishedApi = aVar.c("PublishedApi");
            iterator = aVar.b("Iterator");
            iterable = aVar.b("Iterable");
            collection = aVar.b("Collection");
            list = aVar.b("List");
            listIterator = aVar.b("ListIterator");
            set = aVar.b("Set");
            en0 b = aVar.b("Map");
            map = b;
            en0 c = b.c(og1.f("Entry"));
            k21.h(c, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = c;
            mutableIterator = aVar.b("MutableIterator");
            mutableIterable = aVar.b("MutableIterable");
            mutableCollection = aVar.b("MutableCollection");
            mutableList = aVar.b("MutableList");
            mutableListIterator = aVar.b("MutableListIterator");
            mutableSet = aVar.b("MutableSet");
            en0 b2 = aVar.b("MutableMap");
            mutableMap = b2;
            en0 c2 = b2.c(og1.f("MutableEntry"));
            k21.h(c2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = c2;
            fn0 f = f("KProperty");
            kPropertyFqName = f;
            oi m = oi.m(f.l());
            k21.h(m, "topLevel(kPropertyFqName.toSafe())");
            kProperty = m;
            en0 c3 = aVar.c("UByte");
            uByteFqName = c3;
            en0 c4 = aVar.c("UShort");
            uShortFqName = c4;
            en0 c5 = aVar.c("UInt");
            uIntFqName = c5;
            en0 c6 = aVar.c("ULong");
            uLongFqName = c6;
            oi m2 = oi.m(c3);
            k21.h(m2, "topLevel(uByteFqName)");
            uByte = m2;
            oi m3 = oi.m(c4);
            k21.h(m3, "topLevel(uShortFqName)");
            uShort = m3;
            oi m4 = oi.m(c5);
            k21.h(m4, "topLevel(uIntFqName)");
            uInt = m4;
            oi m5 = oi.m(c6);
            k21.h(m5, "topLevel(uLongFqName)");
            uLong = m5;
            uByteArrayFqName = aVar.c("UByteArray");
            uShortArrayFqName = aVar.c("UShortArray");
            uIntArrayFqName = aVar.c("UIntArray");
            uLongArrayFqName = aVar.c("ULongArray");
            HashSet f2 = qj.f(PrimitiveType.values().length);
            int i = 0;
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                f2.add(primitiveType.getTypeName());
            }
            primitiveTypeShortNames = f2;
            HashSet f3 = qj.f(PrimitiveType.values().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                f3.add(primitiveType2.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = f3;
            HashMap e = qj.e(PrimitiveType.values().length);
            PrimitiveType[] values = PrimitiveType.values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                PrimitiveType primitiveType3 = values[i2];
                i2++;
                a aVar2 = INSTANCE;
                String b3 = primitiveType3.getTypeName().b();
                k21.h(b3, "primitiveType.typeName.asString()");
                e.put(aVar2.d(b3), primitiveType3);
            }
            fqNameToPrimitiveType = e;
            HashMap e2 = qj.e(PrimitiveType.values().length);
            PrimitiveType[] values2 = PrimitiveType.values();
            int length2 = values2.length;
            while (i < length2) {
                PrimitiveType primitiveType4 = values2[i];
                i++;
                a aVar3 = INSTANCE;
                String b4 = primitiveType4.getArrayTypeName().b();
                k21.h(b4, "primitiveType.arrayTypeName.asString()");
                e2.put(aVar3.d(b4), primitiveType4);
            }
            arrayClassFqNameToPrimitiveType = e2;
        }

        private a() {
        }

        private final en0 a(String str) {
            en0 c = c.ANNOTATION_PACKAGE_FQ_NAME.c(og1.f(str));
            k21.h(c, "ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return c;
        }

        private final en0 b(String str) {
            en0 c = c.COLLECTIONS_PACKAGE_FQ_NAME.c(og1.f(str));
            k21.h(c, "COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return c;
        }

        private final en0 c(String str) {
            en0 c = c.BUILT_INS_PACKAGE_FQ_NAME.c(og1.f(str));
            k21.h(c, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return c;
        }

        private final fn0 d(String str) {
            fn0 j = c(str).j();
            k21.h(j, "fqName(simpleName).toUnsafe()");
            return j;
        }

        private final fn0 e(String str) {
            fn0 j = c.RANGES_PACKAGE_FQ_NAME.c(og1.f(str)).j();
            k21.h(j, "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return j;
        }

        @JvmStatic
        @NotNull
        public static final fn0 f(@NotNull String str) {
            k21.i(str, "simpleName");
            fn0 j = c.KOTLIN_REFLECT_FQ_NAME.c(og1.f(str)).j();
            k21.h(j, "KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return j;
        }
    }

    static {
        og1 f = og1.f("values");
        k21.h(f, "identifier(\"values\")");
        ENUM_VALUES = f;
        og1 f2 = og1.f("valueOf");
        k21.h(f2, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = f2;
        en0 en0 = new en0("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME_RELEASE = en0;
        en0 c = en0.c(og1.f("experimental"));
        k21.h(c, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"experimental\"))");
        COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL = c;
        en0 c2 = c.c(og1.f("intrinsics"));
        k21.h(c2, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"intrinsics\"))");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL = c2;
        en0 c3 = c.c(og1.f("Continuation"));
        k21.h(c3, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL = c3;
        en0 c4 = en0.c(og1.f("Continuation"));
        k21.h(c4, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_RELEASE = c4;
        en0 en02 = new en0("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = en02;
        og1 f3 = og1.f("kotlin");
        k21.h(f3, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = f3;
        en0 k = en0.k(f3);
        k21.h(k, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = k;
        en0 c5 = k.c(og1.f("annotation"));
        k21.h(c5, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = c5;
        en0 c6 = k.c(og1.f("collections"));
        k21.h(c6, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = c6;
        en0 c7 = k.c(og1.f("ranges"));
        k21.h(c7, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = c7;
        en0 c8 = k.c(og1.f("text"));
        k21.h(c8, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = c8;
        en0 c9 = k.c(og1.f("internal"));
        k21.h(c9, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"internal\"))");
        BUILT_INS_PACKAGE_FQ_NAMES = e0.g(k, c6, c7, c5, en02, c9, en0);
    }

    private c() {
    }

    @JvmStatic
    @NotNull
    public static final oi a(int i) {
        return new oi(BUILT_INS_PACKAGE_FQ_NAME, og1.f(b(i)));
    }

    @JvmStatic
    @NotNull
    public static final String b(int i) {
        return k21.r("Function", Integer.valueOf(i));
    }

    @JvmStatic
    @NotNull
    public static final en0 c(@NotNull PrimitiveType primitiveType) {
        k21.i(primitiveType, "primitiveType");
        en0 c = BUILT_INS_PACKAGE_FQ_NAME.c(primitiveType.getTypeName());
        k21.h(c, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
        return c;
    }

    @JvmStatic
    @NotNull
    public static final String d(int i) {
        return k21.r(FunctionClassKind.SuspendFunction.getClassNamePrefix(), Integer.valueOf(i));
    }

    @JvmStatic
    public static final boolean e(@NotNull fn0 fn0) {
        k21.i(fn0, "arrayFqName");
        return a.arrayClassFqNameToPrimitiveType.get(fn0) != null;
    }
}
