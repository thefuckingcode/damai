package tb;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.m;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class x41 {
    @NotNull
    public static final x41 INSTANCE;
    @NotNull
    private static final Set<String> a;
    @NotNull
    private static final Set<String> b;
    @NotNull
    private static final Set<String> c;
    @NotNull
    private static final Set<String> d;
    @NotNull
    private static final Set<String> e;
    @NotNull
    private static final Set<String> f;

    static {
        x41 x41 = new x41();
        INSTANCE = x41;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        a = f0.j(signatureBuildingComponents.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        b = f0.i(f0.i(f0.i(f0.i(f0.i(f0.i(x41.b(), signatureBuildingComponents.f("List", "sort(Ljava/util/Comparator;)V")), signatureBuildingComponents.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), signatureBuildingComponents.e("Double", "isInfinite()Z", "isNaN()Z")), signatureBuildingComponents.e("Float", "isInfinite()Z", "isNaN()Z")), signatureBuildingComponents.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), signatureBuildingComponents.e("CharSequence", "isEmpty()Z"));
        c = f0.i(f0.i(f0.i(f0.i(f0.i(f0.i(signatureBuildingComponents.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), signatureBuildingComponents.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), signatureBuildingComponents.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), signatureBuildingComponents.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), signatureBuildingComponents.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), signatureBuildingComponents.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), signatureBuildingComponents.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        d = f0.i(f0.i(signatureBuildingComponents.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), signatureBuildingComponents.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), signatureBuildingComponents.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> a2 = x41.a();
        String[] b2 = signatureBuildingComponents.b("D");
        String[] strArr = new String[b2.length];
        System.arraycopy(b2, 0, strArr, 0, b2.length);
        Set set = f0.i(a2, signatureBuildingComponents.e("Float", strArr));
        String[] b3 = signatureBuildingComponents.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr2 = new String[b3.length];
        System.arraycopy(b3, 0, strArr2, 0, b3.length);
        e = f0.i(set, signatureBuildingComponents.e("String", strArr2));
        String[] b4 = signatureBuildingComponents.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr3 = new String[b4.length];
        System.arraycopy(b4, 0, strArr3, 0, b4.length);
        f = signatureBuildingComponents.e("Throwable", strArr3);
    }

    private x41() {
    }

    private final Set<String> a() {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        List<JvmPrimitiveType> list = m.j(JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType2 : list) {
            String b2 = jvmPrimitiveType2.getWrapperFqName().g().b();
            k21.h(b2, "it.wrapperFqName.shortName().asString()");
            String[] b3 = signatureBuildingComponents.b("Ljava/lang/String;");
            String[] strArr = new String[b3.length];
            System.arraycopy(b3, 0, strArr, 0, b3.length);
            boolean unused = r.v(linkedHashSet, signatureBuildingComponents.e(b2, strArr));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        List<JvmPrimitiveType> list = m.j(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : list) {
            String b2 = jvmPrimitiveType.getWrapperFqName().g().b();
            k21.h(b2, "it.wrapperFqName.shortName().asString()");
            boolean unused = r.v(linkedHashSet, signatureBuildingComponents.e(b2, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> c() {
        return a;
    }

    @NotNull
    public final Set<String> d() {
        return e;
    }

    @NotNull
    public final Set<String> e() {
        return b;
    }

    @NotNull
    public final Set<String> f() {
        return d;
    }

    @NotNull
    public final Set<String> g() {
        return f;
    }

    @NotNull
    public final Set<String> h() {
        return c;
    }

    public final boolean i(@NotNull fn0 fn0) {
        k21.i(fn0, "fqName");
        if (!k21.d(fn0, c.a.array)) {
            c cVar = c.INSTANCE;
            return c.e(fn0);
        }
    }

    public final boolean j(@NotNull fn0 fn0) {
        k21.i(fn0, "fqName");
        if (i(fn0)) {
            return true;
        }
        oi o = w31.INSTANCE.o(fn0);
        if (o == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(o.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
