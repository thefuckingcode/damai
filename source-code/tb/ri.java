package tb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ri implements KClass<Object>, ClassBasedDeclarationContainer {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> b;
    @NotNull
    private static final HashMap<String, String> c;
    @NotNull
    private static final HashMap<String, String> d;
    @NotNull
    private static final HashMap<String, String> e;
    @NotNull
    private static final Map<String, String> f;
    @NotNull
    private final Class<?> a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final String a(@NotNull Class<?> cls) {
            String str;
            k21.i(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) ri.e.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) ri.e.get(cls.getName());
            return str3 == null ? cls.getCanonicalName() : str3;
        }

        @Nullable
        public final String b(@NotNull Class<?> cls) {
            String str;
            k21.i(cls, "jClass");
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        k21.h(simpleName, "name");
                        String str3 = StringsKt__StringsKt.K0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
                        if (str3 != null) {
                            return str3;
                        }
                    }
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        k21.h(simpleName, "name");
                        return StringsKt__StringsKt.K0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
                    }
                    k21.h(simpleName, "name");
                    return StringsKt__StringsKt.J0(simpleName, '$', null, 2, null);
                } else if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) ri.f.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str4 = (String) ri.f.get(cls.getName());
                    return str4 == null ? cls.getSimpleName() : str4;
                }
            }
            return str2;
        }

        public final boolean c(@Nullable Object obj, @NotNull Class<?> cls) {
            k21.i(cls, "jClass");
            Map map = ri.b;
            k21.g(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return po2.k(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = z41.c(z41.e(cls));
            }
            return cls.isInstance(obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: java.util.HashMap<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List list = m.j(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            arrayList.add(do2.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = x.r(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k21.h(values, "primitiveFqNames.values");
        for (T t : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k21.h(t, "kotlinName");
            sb.append(StringsKt__StringsKt.M0(t, '.', null, 2, null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Pair a2 = do2.a(sb2, ((String) t) + ".Companion");
            hashMap3.put(a2.getFirst(), a2.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : b.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        e = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(w.e(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.M0((String) entry2.getValue(), '.', null, 2, null));
        }
        f = linkedHashMap;
    }

    public ri(@NotNull Class<?> cls) {
        k21.i(cls, "jClass");
        this.a = cls;
    }

    private final Void d() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ri) && k21.d(z41.c(this), z41.c((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public Object getObjectInstance() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return Companion.a(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return Companion.b(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return z41.c(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    public boolean isInstance(@Nullable Object obj) {
        return Companion.c(obj, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        d();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
